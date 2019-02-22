package novice;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode easy question
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * [3,3]
 * 6
 * answer [0,1]
 *
 * [3,2,4]
 * 6
 * answer [1,2]
 *
 * [2,5,5,11]
 * 10
 * answer [1,2]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i= 0; i< nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        boolean hasDups = false;
        if (numToIndex.size() != nums.length) {
            hasDups = true;
        }

        for (int i= 0; i< nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement) && complement != nums[i] && !hasDups) {
                int index1 = i;
                int index2 = numToIndex.get(complement);
                return new int[]{index1, index2};
            }
        }
        for (int i= 0; i< nums.length -1; i++) {
            for (int j= i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("vals: " + nums[i] + " " + nums[j]);
                    System.out.println("indexes: " +  i + " " + j);
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
