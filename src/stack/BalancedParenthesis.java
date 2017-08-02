package stack;

import java.util.Stack;

/**
 * Created by Ajay on 8/2/17.
 */
public class BalancedParenthesis {

    Stack<Character> stack = new Stack<>();

    private boolean validate(String exp) {
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            } else {
                if (c == ')' && stack.peek() == '('){
                    stack.pop();
                } else if (c == ']' && stack.peek() == '['){
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{'){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
        //String exp = "[(])";
        BalancedParenthesis bp = new BalancedParenthesis();
        System.out.println(bp.validate(exp));
    }
}
