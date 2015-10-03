package novice;

/**
 * Created by aizhan on 9/15/15.
 */
public class EquilibriumIndex {
    /*
    source: http://blog.codility.com/2011/03/solutions-for-task-equi.html

    The equilibrium index of a sequence is an index such that the sum of elements at lower indexes is equal
    to the sum of elements at higher indexes. For example, in a sequence A:
    A[0]=-7 A[1]=1 A[2]=5 A[3]=2 A[4]=-4 A[5]=3 A[6]=0
    3 is an equilibrium index, because:
                        A[0]+A[1]+A[2]=A[4]+A[5]+A[6]
    6 is also an equilibrium index, because:
                        A[0]+A[1]+A[2]+A[3]+A[4]+A[5]=0
    (The sum of zero elements is zero) 7 is not an equilibrium index - because it is not a valid index of sequence A.
    If you still have doubts, here is a precise definition: The integer k is an equilibrium index of a
    sequence A[0],A[1]..,A[n-1] if and only if 0<= k and sum(A[0..(k-1)])=sum(A[(k+1)..(n-1)]).
    Assume the sum of zero elements is equal to zero.

    Write a function
    int equi(int A[], int n)
    that, given a sequence, returns its equilibrium index (any) or -1 if no equilibrium index exists.
    Assume that the sequence may be very long.
     */

    public static void yes() {
        System.out.println("yes again");
    }

    static int solution(int A[], int N) {
        // write your code in C99
        long totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
        }
//        System.out.println(totalSum);
        if (A.length < 1) {
            return -1;
        }
        long sumBefore = 0;
        long sumAfter = totalSum - A[0];
        for (int a = 0; a < A.length; a++) {
//            System.out.println("------------");
//            System.out.println(sumBefore);
//            System.out.println(sumAfter);
            if(sumBefore == sumAfter) {
                return a;
            } else if (a < (A.length - 1)){
                sumBefore += A[a];
                sumAfter -= A[a + 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}, 8));
        System.out.println(solution(new int[]{-1, 3, 5}, 3));
    }
}
