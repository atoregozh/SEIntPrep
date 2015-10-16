package adept;

/**
 * Created by aizhan on 10/15/15.
 */
public class RectangleAreasWIntersections {
    /*
    A rectangle is called rectilinear if its edges are all parallel to coordinate axes. Such a rectangle can be described
     by specifying the coordinates of its lower-left and upper-right corners.

     Write a function:
        public int solution(int K, int L, int M, int N, int P, int Q, int R, int S);
     that, given eight integers representing two rectilinear rectangles (one with lower left corner (K,L) and
     upper-right corner (M,N), and another with lower-left corner (P,Q) and upper-right corner (R,S)), returns
     the area of the sum of the rectangles. If the rectangles intersect, the area of their intersection should be counted
     only once. The function should return -1 if the area of the sum exceeds 2,147,483,647.

     For example, given the integers:
        K = -4, L = 1, M = 2, N = 6
        P = 0, Q = -1, R = 4, S = 3
     the function should return 42.

     The area of the first rectangle is 30, the area of the second rectangle is 16, the area of the intersection is 4.

     Assume that:
        K,L,M,N,P,Q,R,S are integers within the range [-2,147,483,647...2,147,483,647]
        K<M
        L<N
        P<R
        Q<S

     Complexity:
        expected worst-case time complexity is O(1)
        expected worst-case space complexity is O(1)
     */

    public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        int distanceX1 = M - K;
        int distanceY1 = N - L;
        int area1 = distanceX1 * distanceY1;

        int distanceX2 = R - P;
        int distanceY2 = S - Q;
        int area2 = distanceX2 * distanceY2;

        return area1 + area2 - intersection(K, M, P, R, L, N, Q, S);
    }

    private static int intersection(int K, int M, int P, int R, int L, int N, int Q, int S) {
        if(P <= M && Q<=N) {
            int beginX = Math.max(K,P);
            int endX = Math.min(R,M);

            int beginY = Math.max(L,Q);
            int endY = Math.min(S,N);
            return (endX - beginX) * (endY - beginY);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(-4,1,2,6,0,-1,4,3));
    }

}
