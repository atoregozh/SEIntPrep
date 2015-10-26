package adept;

/**
 * Created by aizhan on 10/17/15.
 */
public class SmallestNumberNotInArray {


    /*
    Suppose that you are given a very long, unsorted list of unsigned 64-bit integers. How would you find the smallest
    non-negative integer that does not occur in the list?

    FOLLOW-UP: Now that the obvious solution by sorting has been proposed, can you do it faster than O(n log n)?
     */
    public static int solution(int[] arr) {
        for (int i=0; i<arr.length; ++i) {
            int target = arr[i];
            while(target < arr.length && target != arr[target]) {
                int newTarget = arr[target];
                arr[target] = target;
                target = newTarget;
            }
        }

        for (int i=0; i<arr.length; ++i) {
            if(arr[i] != i) {
                return i;
            }
        }
        return arr.length;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,10,25,4,110}));
//        System.out.println(solution(new int[]{-10,3,2,5,-20}));
    }
}
