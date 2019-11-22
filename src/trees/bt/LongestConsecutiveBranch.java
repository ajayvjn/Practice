package trees.bt;

/**
 * Created by Ajay on 10/11/17.
 * <p>
 * 0
 * / \
 * 1   2
 * /\   /\
 * 1  2 1 3
 * <p>
 * QUESTIONS
 * What kind of data does this BST support
 * What to do in case of duplicate value. (Mostly it should goto left)
 * <p>
 * Runtime O(n) as we are hitting all the node once through recursion.
 */

public class LongestConsecutiveBranch {

    public static void main(String[] args) {
        LongestConsecutiveBranch lcb = new LongestConsecutiveBranch();

        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(2);
        Node n6 = new Node(1);
        Node n7 = new Node(3);
        Node n8 = new Node(3);
        Node n9 = new Node(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n7.left = n9;


        System.out.println(lcb.consecutive(n1));
    }


    private int consecutive(Node root) {
        if (root == null) {
            return 0;
        } else {
            return consecutive(root, root.key, 1);
        }
    }

    private int consecutive(Node node, int prev, int length) {
        // check empty condition
        if (node == null) {
            return length;
        }
        if (node.key == prev + 1) {
            length++;
        } else {
            length = 1;
        }
        int leftLength = consecutive(node.left, node.key, length);
        int rightLength = consecutive(node.right, node.key, length);
        int a = Math.max(leftLength, rightLength);
        return Math.max(a, length);
    }
}
