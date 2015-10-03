package jedi;

import java.util.*;

/**
 * Created by aizhan on 10/2/15.
 */
public class ChainOfStrings {

    static int longest_chain(String[] w) {
        List<String> words = Arrays.asList(w);
        for(int i=0; i<w.length; i++) {
            if( w[i].length() > 1) {
                int length = removeCharac(words, w[i], 0);
                return length;
            }
        }
        return -1;

    }

    private static int removeCharac(List<String> words, String word, int chain) {

        if(word.length() == 1) {
            return chain;
        }

        List<Integer> maxLengths = new ArrayList<>();
        for(int i=0; i<word.length(); ++i) {
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            String wordWithoutChar = sb.toString();
//            if(words.contains(wordWithoutChar)) {
//                int chainResult = removeCharac(words, wordWithoutChar, ++chain);
//                return chainResult;
//                maxLengths.add(chainResult);
//            }
        }
        int maxChain = Collections.max(maxLengths);
        return maxChain;
    }

    public static void main(String[] args) {
        String[] w = {"a","b","ba","bca","bda","bdca"};
        int result = longest_chain(w);
        System.out.println(result);
    }

}

//List <String> list = Arrays.asList(array);
//if(list.contains("world"))
