package adept;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aizhan on 9/17/15.
 */
public class ShortestSubstring {
    /*
    Given an array with unique characters arr and a string str, find the smallest
    substring of str containing all characters of arr.

    Example:
    arr: [x,y,z], str: xyyzyzyx
    result: zyx
     */

    public static String getShortestSubstring(char[] arr, String str) {
        int tailIndex = 0;
        String result = null;
        int uniqueCounter = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        // initialize countMap
        for (int i=0; i<arr.length;i++) {
            countMap.put(arr[i],0);
        }
        // scan str
        for (int headIndex=0; headIndex<str.length(); headIndex++) {
            char headChar = str.charAt(headIndex);
            if (!countMap.containsKey(headChar)) {
                continue;
            }
            int headCount = countMap.get(headChar);

            //whether visited each unique character of arr
            if (headCount == 0) {
                uniqueCounter++;
            }
            countMap.put(headChar, headCount+1);

            // push tail forward
            while (uniqueCounter == arr.length) {
                int tempSubstrLength = headIndex - tailIndex + 1;
                int tailCount = 0;
                if (tempSubstrLength == arr.length) {
                    return str.substring(tailIndex, headIndex+1);
                }
                if ( result == null || tempSubstrLength < result.length()) {
                    result = str.substring(tailIndex, headIndex+1);
                }
                char tailChar = str.charAt(tailIndex);
                if (countMap.containsKey(tailChar)) {
                    tailCount = countMap.get(tailChar) -1;
                    if (tailCount == 0) {
                        uniqueCounter--;
                    }
                    countMap.put(tailChar, tailCount);
                }
                tailIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] arr = {'x', 'y', 'z'};
        String str = "xyaayzyzyzx";
        String result = getShortestSubstring(arr, str);
        System.out.println(result);

    }

}
