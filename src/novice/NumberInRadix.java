package novice;

import java.util.ArrayList;

/**
 * Created by aizhan on 9/15/15.
 */
public class NumberInRadix {
    /*

     */

    public String solution(int V, int R) {
        // write your code in Java SE 8
        if (V == 0) {
            return "0";
        }
        ArrayList<Integer> remainders = new ArrayList<>();
        int result = V;
        while (result > 0) {
            remainders.add(result % R);
            result = result / R;
        }
        StringBuffer resultBuffer = new StringBuffer();
        for (int i = remainders.size() - 1; i >= 0; i--) {
            if (remainders.get(i) > 9) {
                char c1 = (char)(remainders.get(i) - 10);
                c1 += 'a';
                resultBuffer.append(c1);
            } else {
                resultBuffer.append(remainders.get(i));
            }
        }
        return resultBuffer.toString();
    }

    public static void main(String[] args) {
        NumberInRadix o = new NumberInRadix();
        System.out.println(o.solution(10, 20));
        System.out.println(o.solution(62, 21));
        System.out.println(o.solution(7, 5));
        System.out.println(o.solution(31, 16));
        System.out.println(o.solution(0, 16));
        System.out.println(o.solution(71, 36));
        System.out.println(o.solution(35, 36));
        System.out.println(o.solution(35, 2));
        System.out.println(o.solution(4, 2));
    }
}
