package jedi;

import java.util.*;

/**
 * Created by aizhan on 9/18/15.
 */
public class SimpleDatabase {

    private Map<String, String> db = new HashMap<>();
    private Map<String, Integer> dbValueCount = new HashMap<>();
    private Map<String, List<String>> transactionValue = new HashMap<>();
    private List<Set<String>> transactionOrder = new ArrayList<>();
    private Map<String, Integer> transactionValueCount = new HashMap<>();

    public void set(String name, String value) {
        if(transactionValue.isEmpty()) {
            db.put(name, value);

        } else {
            if (transactionValue.containsKey(name)) {
                transactionValue.get(name).add(value);
            } else{
                List<String> values = new ArrayList<>();
                values.add(value);
                transactionValue.put(name, values);
            }
            int lastTransactionSet = transactionOrder.size() - 1;
            transactionOrder.get(lastTransactionSet).add(name);
        }
    }

    public String get(String name) {
        if(transactionValue.isEmpty()) {
            return db.containsKey(name) ? db.get(name) : "NULL";

        } else {
            if (transactionValue.containsKey(name)) {
                int lastTransactionValue = transactionValue.get(name).size() - 1;
                return transactionValue.get(name).get(lastTransactionValue);
            } else {
                return "NULL";
            }
        }
    }

    public void unset(String name) {
        if(transactionValue.isEmpty()) {
            db.remove(name);
        } else {
            transactionValue.remove(name);
        }
    }
}
