package novice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aizhan on 9/4/15.
 */
public class MinNumberSteps {
    /*
    You are in an infinite 2D grid where you can move in any of the 8 directions :
    (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)

    You are given a sequence of points and the order in which you need to cover the points.
    Give the minimum number of steps in which you can achieve it. You start from the first point.

    Example :
        Input : [(0, 0), (1, 1), (1, 2)]
        Output : 2
    It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

    Hint:
        Note that because the order of covering the points is already defined,
        the problem just reduces to figuring out the way to calculate the distance
        between 2 points (A, B) and (C, D).

        Note that what only matters is X = abs(A-C) and Y = abs(B-D).

        While X and Y are positive, you will move along the diagonal and X and Y would both reduce by 1.
        When one of them becomes 0, you would move so that in each step the remaining number reduces by 1.

        In other words, the total number of steps would correspond to max(X, Y).
     */

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static int coverPoints(List<Integer> X, List<Integer> Y) {
        int numSteps = 0;
        for (int i = 0; i < X.size()-1; i++) {
            int xDist = Math.abs(X.get(i) - X.get(i+1));
            int yDist = Math.abs(Y.get(i) - Y.get(i + 1));
            numSteps = numSteps + Math.max(xDist,yDist);
        }
        return numSteps;
    }

    public static void main(String[] args) {
        List<Integer> X1 = Arrays.asList(0,1,1);
        List<Integer> Y1 = Arrays.asList(0,1,2);
        int numSteps1 = coverPoints(X1,Y1);
        System.out.println(numSteps1);

        List<Integer> X2 = Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8);
        List<Integer> Y2 = Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8);
        int numSteps2 = coverPoints(X2,Y2);
        System.out.println(numSteps2);
    }
}
