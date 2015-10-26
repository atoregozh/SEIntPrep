package jedi;

import java.util.*;

/**
 * Created by aizhan on 10/25/15.
 */
public class AllPossiblePathsFromNodeInUndirectedGraph {

    public static Set<String> findAllPossiblePaths(Knight k, char startElem) {

        Map<Character, ArrayList<Character>> graph = k.getPaths();
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        stack.push(sb.append(startElem));

        while (!stack.isEmpty()) {
            StringBuilder curr = stack.pop();

            while (curr.length() == 7 && !stack.isEmpty()) {
                curr.insert(3,'-');
                result.add(curr.toString());
                if(curr != null) { //NOT sure about this if
                    curr = stack.pop();
                }
            }

            if(curr != null) { //NOT sure about this if
                for (Character neighbor : graph.get(curr.charAt(curr.length() - 1))) {
                    StringBuilder sbNew = new StringBuilder(curr);
                    stack.push(sbNew.append(neighbor));
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Knight k = new Knight();
        Set<String> result = findAllPossiblePaths(k, '3');
        for(String s: result) {
            System.out.println(s);
        }
    }

}




class Knight {
    private static final Map<Character, ArrayList<Character>> knightPaths = new HashMap<Character, ArrayList<Character>>() {{
        put('1', new ArrayList<>(Arrays.asList('8', '6')));
        put('2', new ArrayList<>(Arrays.asList('7', '9')));
        put('3', new ArrayList<>(Arrays.asList('4', '8')));
        put('4', new ArrayList<>(Arrays.asList('3', '9', '0')));
        put('6', new ArrayList<>(Arrays.asList('7', '1', '0')));
        put('7', new ArrayList<>(Arrays.asList('2', '6')));
        put('8', new ArrayList<>(Arrays.asList('3', '1')));
        put('9', new ArrayList<>(Arrays.asList('4', '2')));
        put('0', new ArrayList<>(Arrays.asList('4', '6')));
    }};

    public Map<Character, ArrayList<Character>> getPaths() {
        return knightPaths;
    }
}
