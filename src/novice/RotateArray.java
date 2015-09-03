package novice;

import java.util.ArrayList;

/**
 * Created by aizhan on 9/3/15.
 */
public class RotateArray {

    /*
    rotate the array A by B positions
    for example,
        A : [1 2 3 4 5 6]
        B : 1
    The output :
       [2 3 4 5 6 1]
     */

    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < ((A.size())); i++) {
            ret.add(A.get((i + B)%A.size()));
        }
        return ret;
    }
}
