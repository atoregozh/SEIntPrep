package adept;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by aizhan on 10/15/15.
 */
public class StackMachineArithmetic {

    public static int solution(String S) {
        Stack<Integer> stack = new Stack<>();
        try {
            for(int i=0; i<S.length(); ++i) {
                if(S.charAt(i) == '+') {

                    int number1 = checkIfEmptyAndPop(stack);

                    int number2 = checkIfEmptyAndPop(stack);
                    stack.push(number1 + number2);
                } else if(S.charAt(i) == '*') {
                    int number1 = checkIfEmptyAndPop(stack);
                    int number2 = checkIfEmptyAndPop(stack);
                    stack.push(number1 * number2);
                } else {
                    stack.push(Integer.parseInt(S.substring(i, i+1)));
                }
            }
        } catch(EmptyStackException e) {
            return -1;
        }
        if(stack.isEmpty()) {
            return -1;
        } else {
            return stack.pop();
        }


    }

    private static int checkIfEmptyAndPop(Stack<Integer> s) {
        if(!s.isEmpty()) {
            return s.pop();

        } else {
            throw new EmptyStackException();
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("13+62*7+*"));
    }
}
