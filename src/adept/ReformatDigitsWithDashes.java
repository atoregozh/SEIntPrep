package adept;

import java.util.Arrays;

/**
 * Created by aizhan on 10/15/15.
 */
public class ReformatDigitsWithDashes {
    /*
    We are given a string S representing a phone number, which we would like to reformat. String S consists of N characters:
    digits, spaces and/or dashes. It contains at least two digits.

    Spaces and dashes in string S can be ignored. We want to reformat the given phone number in such a way that the
    digits are grouped in blocks of length three, separated by single dashes. If necessary, the final block or the last
    two blocks can be length of two.

    For example, given string S = "00-44 48 5555 8361", we would like to format it as "004-448-555-583-61".

    Write a function:

        String solution(String s);
    that given a string S representing a phone number, returns this phone number reformatted as described above.

    For example, given S= "00-44 48 5555 8361", the function should return "004-448-555-583-61"
    Given S = "0 - 22 1985--324", the function should return "022-198-53-24". Given S = "555372654", the function should
    return "555-372-654".
    Assume that:
        N is an integer within the range [2..100];
        string S consists only of digits (0-9), spaces and/or dashes (-);
        string S contains at least two digits.

    In your solution, focus on correctness. The performance of your solution will not be the focus of the assessmment.

    Thought process: when remainder is 1, then the last 4 digits are grouped in 2, all others grouped in 3;
    when remainder is 2, the last 2 digits are grouped together, all others grouped in 3;
*/

    public static String solution(String s) {
        String[] sSplit = s.split("[-\\s]");
        String fullString = removeEmptyStrings(sSplit);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<fullString.length(); i=i+3) {
            if(fullString.length()==2) {
                return fullString;
            }
            else if(fullString.length() % 3 == 1 && i==fullString.length()-4) {
                sb.append(fullString.substring(i, i + 2));
                sb.append("-");
            } else if((fullString.length() % 3 == 1 || fullString.length() % 3 == 2) && i==fullString.length()-1) {
                System.out.println(fullString.length());
                sb.append(fullString.substring(i-1));
                sb.append("-");
                break;
            } else if((fullString.length() % 3 == 1 || fullString.length() % 3 == 2) && i==fullString.length()-2) {
                System.out.println(fullString.length());
                sb.append(fullString.substring(i));
                sb.append("-");
                break;
            } else {
                sb.append(fullString.substring(i,i+3));
                sb.append("-");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static String removeEmptyStrings(String[] s){
        StringBuilder sb = new StringBuilder();
        for(String s1 : s){
            if(!s1.equals("")) {
                sb.append(s1);
            }
        }
        return sb.toString();
    }

    public static void main(String [] args){
        System.out.println(solution("0 - 22 1985--324"));
        System.out.println(solution("00-44 48 5555 8361"));
        System.out.println(solution("555372654"));
    }

}
