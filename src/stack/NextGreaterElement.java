package stack;

import java.util.Stack;

/**
 * Created by Ajay on 8/3/17.
 */
public class NextGreaterElement {

    Stack<Integer> stack = new Stack<>();

    private void findNextGreaterElement(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {

            while (!stack.isEmpty()) {
                if (a[i] > stack.peek()) {
                    int v = stack.pop();
                    if(stack.isEmpty())
                        System.out.println(v + " -> -1");
                } else {
                    System.out.println(a[i] + " -> " + stack.peek());
                    break;
                }
            }
            stack.push(a[i]);
        }
        System.out.println(stack.firstElement()+ " -> -1");
    }

    public static void main(String[] args) {
        //int a[] = { 4, 5, 2, 25};
        //int a[] = {15, 13, 21, 3};
        int a[] = {15, 14, 16, 13, 21, 3, 1, 2};
        NextGreaterElement nge = new NextGreaterElement();
        nge.findNextGreaterElement(a);
    }
}
