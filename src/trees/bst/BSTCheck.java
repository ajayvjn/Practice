package trees.bst;

/**
 * Created by Ajay on 8/30/17.
 *
 *      5
 *     / \
 *    2   7
 *   /\   /\
 *  1  3 6 8
 *
 * QUESTIONS
 *  What kind of data does this BST support
 *  What to do in case of duplicate value. (Mostly it should goto left)
 *
 *  Runtime O(n) as we are hitting all the node once through recursion.
 */
public class BSTCheck {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n5.left = n2;
        n5.right = n7;
        n2.left = n1;
        n2.right = n3;
        n7.left = n6;
        n7.right = n8;

        System.out.println(isBST(n5));
    }

    private static boolean isBST(Node n) {
        return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node n, int min, int max) {
        if (n == null)
            return true;
        if (n.key < min || n.key > max)
            return false;
        return isBST(n.left, min, n.key) && isBST(n.right, n.key + 1, max);
    }

}

