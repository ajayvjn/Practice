package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Ajay on 8/1/17.
 */
public class InfixToPostfix {

    static Map<Character, Integer> precedence = null;
    Stack<Character> stack = null;

    InfixToPostfix() {
        stack = new Stack<Character>();
        precedence = new HashMap<Character, Integer>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
    }

    private int getPrecedence(char c) {
        if (precedence.containsKey(c)) {
            return precedence.get(c);
        } else {
            return 0;
        }
    }

    private int getPrecedence2(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }

    private String convert(String infix) {
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                System.out.print(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.print(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    System.out.print(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        return "";
    }

    public static void main(String[] args) {
        //String infix = "a+b-c+d";
        //ab+c-d+
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        //abcd^e-fgh*+^*+i-
        InfixToPostfix itp = new InfixToPostfix();
        itp.convert(infix);
    }
}
