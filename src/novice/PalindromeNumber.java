package novice;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    /**
     * From LeetCode Easy
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     *
     * Example 1:
     *
     * Input: 121
     * Output: true
     * Example 2:
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     *
     * Follow up:
     *
     * Coud you solve it without converting the integer to a string?
     */

    static boolean isPalindrome(int x) {

        /**
         * All negative numbers are not palindrome,
         * for example: -123 is not a palindrome since the '-' does not equal to '3'.
         * So we can return false for all negative numbers.
         */
        if (x < 0) {
            return false;
        }

        List<Integer> digits = new ArrayList<>();

        for (; x != 0; x /= 10) {
            int val = x % 10;
            digits.add(val);
            if (x < 0) {
                x = x * (-1);
            }
        }

        int[] digitsArr = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            digitsArr[i] = digits.get(i);
        }

        int i = 0;
        int j = digitsArr.length -1;
        while (i != j && i <= digitsArr.length -1 && j >= 0 ) {
            if (digitsArr[i] != digitsArr[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String args[] ) {
        //System.out.println(isPalindrome(121)); // expected: true
        //System.out.println(isPalindrome(10)); // expected: false
        //System.out.println(isPalindrome(-121)); // expected: false
        System.out.println(isPalindrome(-1)); // expected: false
        //System.out.println(isPalindrome(1)); // expected: true
    }

    /**
     * MY SOLUTION WAS OVERTHINKING IT.
     * there's a way to solve with with O(log(n)) time and O(1) space. 
     *     public bool IsPalindrome(int x) {
     *         // Special cases:
     *         // As discussed above, when x < 0, x is not a palindrome.
     *         // Also if the last digit of the number is 0, in order to be a palindrome,
     *         // the first digit of the number also needs to be 0.
     *         // Only 0 satisfy this property.
     *         if(x < 0 || (x % 10 == 0 && x != 0)) {
     *             return false;
     *         }
     *
     *         int revertedNumber = 0;
     *         while(x > revertedNumber) {
     *             revertedNumber = revertedNumber * 10 + x % 10;
     *             x /= 10;
     *         }
     *
     *         // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
     *         // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
     *         // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
     *         return x == revertedNumber || x == revertedNumber/10;
     *     }
     */
}
