package novice;

public class ReverseInteger {
    /**
     * LeetCode easy
     Given a 32-bit signed integer, reverse digits of an integer.

     Example 1:

     Input: 123
     Output: 321
     Example 2:

     Input: -123
     Output: -321
     Example 3:

     Input: 120
     Output: 21
     Note:
     Assume we are dealing with an environment which could only store integers
     within the 32-bit signed integer range: [−2^31,  2^31 − 1].
     For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */

    static int reverse(int x) {
        char[] chars = Integer.toString(x).toCharArray();
        boolean hasNegativeSign = false;
        if (x < 0) {
            hasNegativeSign = true;
            String xAsString = Integer.toString(-1 * x);
            chars = xAsString.toCharArray();
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (hasNegativeSign) {
                reversed.append("-");
                hasNegativeSign = false;
            }
            reversed.append(chars[i]);
        }
        String result =  reversed.toString();
        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    public static void main(String args[] ) {
        //System.out.println(reverse(123)); // expected: 321
        //System.out.println(reverse(-123)); // expected: -321
        //System.out.println(reverse(120)); // expected: 21
        System.out.println(reverse(1534236469)); // expected: 0
    }
}
