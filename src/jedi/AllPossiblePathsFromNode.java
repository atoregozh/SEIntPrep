package jedi;

import java.util.*;

/**
 * Created by aizhan on 10/25/15.
 */
public class AllPossiblePathsFromNode {
    /**
     * Given chess element k (e.g. knight, pawn, king, queen, etc), find all possible 7-digit numbers based on the
     * chess board positions it could go next
     * Chess board in this question looks as following:
     *         1  2  3
     *         4  5  6
     *         7  8  9
     *            0
     * @param k one of elements in a chess board, the rules where it can go next from startElem position
     *          are prepopulated in a map
     * @param startElem starting position of chess element within a chessboard
     * @return all possible 7 digit numbers resulting from the paths chess element k could take. first three digits need
     * to be separated from the last four digits with a dash
     * e.x. output for findAllPossiblePaths(Knight k, char startElem) are:
     * 349-2761, 349-4940, 343-4343, 349-2760, 343-4067, 340-4043, 340-4049, 340-6067...etc
     */

    /*
    Solution concepts: permutation generation, DFS
     */

    public static Set<String> findAllPossiblePaths(Knight k, char startElem) {

        Map<Character, ArrayList<Character>> graph = k.getPaths();
        Stack<StringBuilder> stack = new Stack<>();
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        stack.push(sb.append(startElem));

        while (!stack.isEmpty()) {
            StringBuilder curr = stack.pop();

            if (curr.length() == 7) {
                curr.insert(3,'-');
                result.add(curr.toString());
                continue;
            }
            for (Character neighbor : graph.get(curr.charAt(curr.length() - 1))) {
                StringBuilder sbNew = new StringBuilder(curr);
                stack.push(sbNew.append(neighbor));
            }

        }
        return result;

    }

    public static void main(String[] args) {
        Knight k = new Knight();
        Set<String> result = findAllPossiblePaths(k, '3');
        System.out.println(result.size() + " numbers");
        for(String s: result) {
            System.out.println(s);
        }
    }

}




class Knight {
    private static final Map<Character, ArrayList<Character>> knightRules = new HashMap<Character, ArrayList<Character>>() {{
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
        return knightRules;
    }
}
