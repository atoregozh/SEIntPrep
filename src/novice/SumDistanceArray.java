package novice;

/**
 * Created by aizhan on 10/14/15.
 */

/*
Let A be a non-empty zero-indexed array consisting of N integers. A `sum-distance` of a pair of indices (P,Q), for 0<=P<=Q<N,
is the value A[P]+A[Q]+(Q-P)

For example, the following array A:

A[0] = 1
A[1] = 3
A[2] = -3
there are the following pairs of indices: (0,0),(1,1),(2,2),(0,1),(1,2),(0,2) for each of which the sum-distance is defined
as follows:

for (0,0) it is A[0] + A[0] + (0-0) = 1 + 1 + 0 = 2
for (1,1) it is A[1] + A[1] + (1-1) = 3 + 3 + 0 = 6
for (2,2) it is A[2] + A[2] + (2-2) = -3 + (-3) + 0 = -6
for (0,1) it is A[0] + A[1] + (1-0) = 1 + 3 + 1 = 5
for (1,2) it is A[1] + A[2] + (2-1) = 3 + (-3) + 1 = 1
for (0,2) it is A[0] + A[2] + (2-0) = 1 + (-3) + 2 = 0

Write a function:
    int solution(int A[], int N);

that given a zero-indexed array A consisting of N integers, returns the maximal sum-distance value for this array.

For example, given the following array A:

A[0] = 1
A[1] = 3
A[2] = -3
the function should return 6, as explained above.

Given the following array A:
A[0] = -8
A[1] = 4
A[2] = 0
A[3] = 5
A[4] = -3
A[5] = 6
the function should return 4+6+(5-1) = 14
Assume that:

N is an integer within the range [1...100,000]
each element of array A is an integer within the range [-1Bln...1Bln]

*/

public class SumDistanceArray {

    public static int solution(int[] A, int N) {
        double maxSumDist = Integer.MIN_VALUE;
        for(int i=0; i< N; ++i) {
            for(int j=i; j<N; ++j) {
                double currSumDist = A[i] + A[j] + (j-i);
                if (currSumDist > maxSumDist) {
                    maxSumDist = currSumDist;
                }
            }
        }
        return (int) maxSumDist;
    }

    public static void main (String[] args) {
        System.out.println(solution(new int[] {1,3,-3}, 3));
        System.out.println(solution(new int[] {-8,4,0,5,-3,6}, 6));
    }
}
