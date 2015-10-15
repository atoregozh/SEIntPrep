package adept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aizhan on 10/15/15.
 */
public class SaddlePointsInMatrix {
    /*
    A two-dimensional zero-indexed matrix consisting of N rows and M columns is given. A `saddle point` of that matrix
    is any pair of integers (P,Q) s.t.:

        0 < P < N-1
        0 < Q < M-1
        either element (P,Q) is a local minimum in its row and a local maximum in its column, i.e.
        A[P][Q-1] > A[P][Q] < A[P][Q+1] and A[P-1][Q] < A[P][Q] > A[P+1][Q]
        or element (P,Q) is a local maximum in its row and a local maximum in its column, i.e.
        A[P][Q-1] < A[P][Q] > A[P][Q+1] and A[P-1][Q] > A[P][Q] < A[P+1][Q]

    For example, matrix A s.t.:
        A[0][0] = 0     A[0][1] = 1    A[0][2] = 9    A[0][3] = 3
        A[1][0] = 7     A[1][1] = 5    A[1][2] = 8    A[1][3] = 3
        A[2][0] = 9     A[2][1] = 2    A[2][2] = 9    A[2][3] = 4
        A[3][0] = 4     A[3][1] = 6    A[3][2] = 7    A[3][3] = 1
    has 2 saddle points because:

        element (1,1) is a local minimum in its row and a local maximum in its column, so it's a saddle point
        element (1,2) is a local maximum in its row and a local minimum in its column, so it's a saddle point
        element (2,1) is a local minimum in both its row and its column, so it's not a saddle point
        element (2,2) is a local maximum in both its row and its column, so it's not a saddle point
        other elements do not fulfill the requirements for the coordinates.

    Write a function:
        int solution(int[][] A, int N, int M );
    that given a two-dimensional zero-indexed matrix of size N rows and M columns, returns its number of saddle points


    For example, given the matrix A from above, the function should return 2.

    */

    public static int solution(int[][] A, int N, int M) {
        int saddlePoints = 0;
        for (int row = 0; row < N; ++row) {
            for (int column = 0; column < M; ++column) {
                if(isLocalMinInRow(A[row][column], row, A) && isLocalMaxInColumn(A[row][column], column, A)) {
                    System.out.println(A[row][column]);
                    saddlePoints++;
                } else if(isLocalMaxInRow(A[row][column], row, A) && isLocalMinInColumn(A[row][column], column, A)) {
                    System.out.println(A[row][column]);
                    saddlePoints++;
                } else {
                    continue;
                }
            }
        }
        return saddlePoints;
    }

    private static boolean isLocalMinInRow(int numberToVerifyMin, int rowNumber, int[][] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; ++i) {
            if(A[rowNumber][i] < min) {
                min = A[rowNumber][i];
            }
        }
        if (min == numberToVerifyMin) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isLocalMaxInRow(int numberToVerifyMin, int rowNumber, int[][] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            if(A[rowNumber][i] > max) {
                max = A[rowNumber][i];
            }
        }
        if (max == numberToVerifyMin) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isLocalMaxInColumn(int numberToVerifyMin, int columnNumber, int[][] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A[0].length; ++i) {
            //System.out.println(A[i].length);
            if((A[i][columnNumber]) > max) {
                max = A[i][columnNumber];
            }
        }
        if (max == numberToVerifyMin) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isLocalMinInColumn(int numberToVerifyMin, int columnNumber, int[][] A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; ++i) {
            if((A[i][columnNumber]) < min) {
                min = A[i][columnNumber];
            }
        }
        if (min == numberToVerifyMin) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 0, 1,   9, 3,  },
                { 7, 5,   8, 3,  },

                { 9, 2,   9, 4,  },
                { 4, 6,   7, 1,  },

        };

        System.out.println(solution(matrix, 4,4));
    }
}
