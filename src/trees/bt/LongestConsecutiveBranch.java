package trees.bt;

/**
 * Created by Ajay on 10/11/17.
 *
 *      0
 *     / \
 *    1   2
 *   /\   /\
 *  1  2 1 3
 *
 * QUESTIONS
 *  What kind of data does this BST support
 *  What to do in case of duplicate value. (Mostly it should goto left)
 *
 *  Runtime O(n) as we are hitting all the node once through recursion.
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

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(lcb.consecutive(n1));
    }


    private int consecutive(Node root) {
        if (root == null){
            return 0;
        } else {
            int max = Math.max(consecutive(root.left, root.key, 1), consecutive(root.right, root.key, 1));
            return max;
        }
    }

    private int consecutive(Node node, int prev, int length) {
        // check empty condition
        if (node == null){
            return length;
        }
        // check if the the next node is a consecutive number
        else if (node.key == prev + 1){
            int leftLength = consecutive(node.left, node.key, length + 1);
            int rightLength = consecutive(node.right, node.key, length + 1);
            return Math.max(leftLength, rightLength);
        }
        // if the the next node is not a consecutive number, reset the length to 1.
        // consider previous length while checking max length.
        else {
            int leftLength = consecutive(node.left, node.key, 1);
            int rightLength = consecutive(node.right, node.key, 1);
            int max =  Math.max(leftLength, rightLength);
            return Math.max(max, length);
        }
    }
}
