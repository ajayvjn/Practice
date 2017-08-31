package stack;

/**
 * Created by Ajay on 8/30/17.
 *
 * QUESTIONS
 *   What sort of data to be stored in this stack
 *   Make sure that by stack they mean LIFO
 */
public class MaxValConstantTime {

    Node max = null;
    Node head = null;

    public static void main(String[] args) {
        MaxValConstantTime mvct = new MaxValConstantTime();
        mvct.push(new Node(1));
        mvct.push(new Node(2));
        mvct.push(new Node(3));
        mvct.push(new Node(2));
        mvct.push(new Node(1));
        mvct.push(new Node(4));
        mvct.push(new Node(1));

        mvct.maxNode();

        mvct.pop();
        mvct.pop();

        mvct.maxNode();
    }

    private void push(Node node) {
        if (head == null){
            head = node;
            node.next = null;
            max = node;
        } else {
            if (node.val > max.val ){
                node.prevMax = max;
                max = node;
            } else {
                node.prevMax = null;
            }
            node.next = head;
            head = node;
        }
    }

    private void pop() {
        if (head == null)
            throw new NullPointerException();
        if (head.prevMax != null)
            max = head.prevMax;
        head = head.next;
    }

    private void maxNode() {
        if (max == null){
            System.out.println("Empty Stack");
        } else {
            System.out.println(max.val);
        }
    }
}

class Node{
    int val;
    Node prevMax;
    Node next;

    Node(int val){
        this.val = val;
    }
}
