package adept;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aizhan on 10/12/15.
 */
public class HubSpot2 {

    static String[] palindromize(String[] words) {
        String[] result = new String[words.length];
        for(int a = 0; a < words.length; a++) {
            String s = words[a];
            if(s==null || s.length() < 1){
                result[a] = "-1";
                continue;
            }
            Set<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(set.contains(c)){
                    sb.insert(0, c);
                    sb.append(c);
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }
            if(set.size() > 1) {
                result[a] = "-1";
                continue;
            } else if(set.size() == 1){
                sb.insert(sb.length() / 2, set.toArray()[0]);
            }
            result[a] = sb.toString();
        }
        return result;
    }

    public static String print(String[] s){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(String s1 : s){
            sb.append(s1);
            sb.append(",");
        }
        sb.setCharAt(sb.length() -1, ']');
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(print(palindromize(new String[] {"abc", "aab"})));
        System.out.println(print(palindromize(new String[] {"viicc", "cecarar", "toyota"})));
    }
}
