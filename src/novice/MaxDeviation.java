package novice;

/**
 * Created by aizhan on 9/15/15.
 */
public class MaxDeviation {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 1) {
            return -1;
        }
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        long mean = sum / A.length;
//        System.out.println("-----");
//        System.out.println(mean);

        int indexOfMaxDeviation = -1;
        long maxDeviation = 0;
        for (int a = 0; a < A.length; a++) {
            long deviation = Math.abs(A[a] - mean);
            if (deviation >= maxDeviation) {
                maxDeviation = deviation;
                indexOfMaxDeviation = a;
            }
        }
        return indexOfMaxDeviation;
    }

    public static void main(String[] args) {
        MaxDeviation o = new MaxDeviation();
        System.out.println(o.solution(new int[]{}));
        System.out.println(o.solution(new int[]{9, 4, -3, -10}));
        System.out.println(o.solution(new int[]{3,3,3}));
    }
}
