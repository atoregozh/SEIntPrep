package adept;

import java.util.*;

/**
 * Created by aizhan on 9/17/15.
 */
public class QuadCombination {

    /*
    Given an array of numbers arr and a number S, find 4 different numbers in arr that sum up to S.

    Write a function that gets arr and S and returns an array with 4 indices of such numbers in arr,
    or null if no such combination exists.
    Explain and code the most efficient solution possible, and analyze its runtime and space complexity.

    The array is not sorted, and may hold any real number (positive, negative, zero, integer or fraction)

    Any solution of more than O(n2) is not efficient enough.


    Solution:

    The naive solution is to iterate on every possible combination of 4 numbers from arr until the required combination
    if found. Using 4 nested loop involves O(n4) time complexity and O(1) space complexity. This is quite inefficient.

    We can do better, if we look at all the pairs in arr, and then try to build the sum S from 2 different pairs.

    First, we iterate over all the possible pairs in arr with 2 nested loops and hash each pair by its sum.
    Then, for each pairSum in the pairs hash table, we look for its complement S - pairSum. When we find two pairs
    that sum up to S, we need to check that these pairs are drawn from 4 different indices in arr (in other words:
    that no number is used twice to reach the desired sum).

    Time Complexity: Let n be the length or arr. Hashing all pairs in arr by their sum and iterating over all
    sums and their complements takes O(n2) time (n2 pairs and constant number of actions for each).
    Uniqueness check for all indices of the pairs of sums that adds up to S until a valid combination is found,
    is also O(n2) (checking at most n2 pairs with 4 comparisons for each). Overall: quadratic O(n2) time complexity.

    Space Complexity: n2 pairs have up to n2 different sums. Hashing them takes O(n2) space complexity.

     */


    public static int[] findArrayQuadCombination(double[] arr, double sum) {

        if (arr == null ) {
            return null;
        }

        if (arr.length < 4) {
            return null;
        }

        Map<Double, List<Integer[]>> pairHash = new HashMap<>();
        for (int i = 0; i<arr.length; i++) {
            for(int j=i+1; j < arr.length; j++) {
                double currentSum = arr[i] + arr[j];
                Integer[] indexes = {i,j};
                if (pairHash.containsKey(currentSum)) {
                    pairHash.get(currentSum).add(indexes);
                } else{
                    List<Integer[]> indexList = new ArrayList<>();
                    indexList.add(indexes);
                    pairHash.put(currentSum, indexList);
                }
            }
        }

        for (double pairSum: pairHash.keySet()) {
            if (pairHash.containsKey(sum - pairSum)) {
                List<Integer[]> pairsA = pairHash.get(pairSum);
                List<Integer[]> pairsB = pairHash.get(sum - pairSum);
                int[] combination = find4Uniques(pairsA, pairsB);
                if (combination != null) {
                    return combination;
                }
            }
        }
        return null;
    }

    // Helper function.
    // Gets 2 arrays of sub-arrays of 2 numbers
    // Gets 4 unique numbers, from 2 sub-arrays of different arrays
    private static int[] find4Uniques(List<Integer[]> arrA, List<Integer[]> arrB) {
        int lenA = arrA.size();
        int lenB = arrB.size();
        for (int i=0; i < lenA; i++) {
            for (int j=0; j < lenB; j++) {
                if (arrA.get(i)[0] == arrB.get(j)[0] || arrA.get(i)[1] == arrB.get(j)[1] ||
                        arrA.get(i)[0] == arrB.get(j)[1] || arrA.get(i)[1] == arrB.get(j)[0] ) {
                    continue;
                } else {
                    int[] indexes = {arrA.get(i)[0],arrA.get(i)[1], arrB.get(j)[0], arrB.get(j)[1]};
                    return indexes;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        double sum = 5;
        double[] arr = {1,2,3,4};
        int[] result = findArrayQuadCombination(arr, sum);
        System.out.println(Arrays.toString(result));

    }
}
