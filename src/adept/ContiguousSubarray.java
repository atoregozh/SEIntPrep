package adept;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aizhan on 9/3/15.
 */
public class ContiguousSubarray {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
    For example:
    Given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */

    public static int maxSubArray(final List<Integer> a) {
        /*
        Kadane's algorithm consists of a scan through the array values,
        computing at each position the maximum (positive sum) subarray ending
        at that position. This subarray is either empty (in which case its sum is zero)
        or consists of one more element than the maximum subarray ending at the previous position.
         */
        int currentMax = a.get(0);
        int maxSoFar = a.get(0);
        for(int i = 1; i < a.size();i++) {
            int currentVal = a.get(i);
            currentMax = Math.max(currentVal, currentMax + currentVal);
            maxSoFar = Math.max(maxSoFar,currentMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        /*
        A : [ 97, 0, -461, -125, -404, -59, -322, -495, -288, -341, -449, -313, -192,
        -214, -389, -202, -183, -72, -416, -455, -187, -242, -416, 39, -198, -338, -465,
        -248, -25, -398, -97, -461, -214, -423, -407, -77, -190, -67, -178, -410, -160,
        72, -350, -31, -85, -247, -319, -462, -303, -48, -354, -110, 17, 60, 19, 80,
        -218, -28, -426, -366, -140, 50 ]
         */
        List<Integer> A = Arrays.asList(97, 0, -461, -125, -404, -59, -322, -495, -288, -341, -449, -313, -192,
                -214, -389, -202, -183, -72, -416, -455, -187, -242, -416, 39, -198, -338, -465,
                -248, -25, -398, -97, -461, -214, -423, -407, -77, -190, -67, -178, -410, -160,
                72, -350, -31, -85, -247, -319, -462, -303, -48, -354, -110, 17, 60, 19, 80,
                -218, -28, -426, -366, -140, 50);
        int max = maxSubArray(A);
        System.out.println(max);
    }
}


