package novice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aizhan on 9/3/15.
 */
public class SpiralOrder {

    /*
    Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
    Given the following matrix:
    [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
    ]
    You should return:
    [1, 2, 3, 6, 9, 8, 7, 4, 5]

     */

    public static ArrayList<Integer> spiral(final ArrayList<List<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Populate result;
        int top = 0;
        int bottom = a.size()-1;
        int left = 0;
        int right = a.get(0).size()-1;
        int dir = 0;
        while(left <= right && top <= bottom) {
            if(dir == 0) { //dir ==0 means left to right
                for(int k = left; k<=right; k++) {
                    result.add(a.get(top).get(k));
                }
                top++;
            } else if(dir == 1) { //dir == 1 means top to down
                for(int k = top; k<= bottom; k++) {
                    result.add(a.get(k).get(right));
                }
                right--;

            } else if(dir == 2) { //dir ==2 means right to left
                for(int k = right; k>= left; k--) {
                    result.add(a.get(bottom).get(k));
                }
                bottom--;

            } else if(dir ==3) { //dir ==3 means down to top
                for(int k = bottom; k>= top; k--) {
                    result.add(a.get(k).get(left));
                }
                left++;
            }
            dir = (dir+1)%4;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> matrix1 = new ArrayList<List<Integer>>();
        matrix1.add(Arrays.asList(1, 2, 3));
        matrix1.add(Arrays.asList(4, 5, 6));
        matrix1.add(Arrays.asList(7, 8, 9));

        ArrayList<Integer> result1 = spiral(matrix1);
        System.out.println(result1);

        ArrayList<List<Integer>> matrix2 = new ArrayList<List<Integer>>();
        matrix2.add(Arrays.asList(1, 2, 3));
        matrix2.add(Arrays.asList(4, 5, 6));
        ArrayList<Integer> result2 = spiral(matrix1);
        System.out.println(result2);

        ArrayList<List<Integer>> matrix3 = new ArrayList<List<Integer>>();
        matrix3.add(Arrays.asList(1, 2));
        matrix3.add(Arrays.asList(3, 4));
        matrix3.add(Arrays.asList(5, 6));
        ArrayList<Integer> result3 = spiral(matrix1);
        System.out.println(result3);
    }
}

/*
Solution:

	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 // Populate result;
		 int m, n;

		 m = A.size();
		 n = A.get(0).size();

		 if (m == 0)
		    return result;

		 int len;
		 int dir = 0; // right
		 int row, col, layer;
		 row = col = layer = 0;

		 result.add(A.get(0).get(0));


        for (int step = 1; step < m * n; step++) {

            switch(dir) {

                // Go right
                case 0:

                    if (col == n - layer - 1) {
                        dir = 1;
                        row++;
                    } else {
                        col++;
                    }

                    break;

                // Go down
                case 1:

                    if (row == m - layer - 1) {
                        dir = 2;
                        col--;
                    } else {
                        row++;
                    }

                    break;

                // Go left
                case 2:

                    if (col == layer) {
                        dir = 3;
                        row--;
                    } else {
                        col--;
                    }

                    break;

                // Go up
                case 3:

                    if (row == layer + 1) {
                        dir = 0;
                        col++;
                        layer++;
                    } else {
                        row--;
                    }

                    break;

            }

            //System.out.println(row + " " + col);
            result.add(A.get(row).get(col));

        }




		 return result;
	}
}
 */
