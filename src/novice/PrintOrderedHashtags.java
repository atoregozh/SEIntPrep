package novice;
import java.io.*;
import java.util.*;
/**
 * Created by aizhan on 10/2/15.
 */
public class PrintOrderedHashtags {


        public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            for(int i = 1; i <= N; ++i) {
                int emptySpaces = i;
                while (emptySpaces<=N-1) {
                    System.out.print(" ");
                    ++emptySpaces;
                }
                int hashTags = i;
                while (hashTags > 0) {
                    System.out.print("#");
                    --hashTags;
                }
                System.out.println();
            }
        }

}
