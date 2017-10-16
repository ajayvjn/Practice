package trees.bt;

/**
 * Created by Ajay on 10/15/17.
 *
 *      1
 *     / \
 *    2   3
 *   /\   /\
 *  4  5 6  7
 *     \
 *     8
 *
 * QUESTIONS
 *  What kind of data does this BST support?
 *  What to do in case of duplicate value? (NEED TO ADDRESS THIS)
 *
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n5.right = n8;

        Node commonNode = new LowestCommonAncestor().findCommonAncestor(n1, n4, n6);
        if (commonNode != null){
            System.out.println(commonNode.key);
        } else {
            System.out.println("Common node not found!");
        }
    }

    private Node findCommonAncestor(Node node, Node n1, Node n2) {
        if (node == null) return null;
        if (node == n1) return n1;
        if (node == n2) return n2;

        Node leftNode = findCommonAncestor(node.left, n1, n2);
        Node rightNode = findCommonAncestor(node.right, n1, n2);

        if (leftNode != null && rightNode != null) return node;
        if (leftNode == null && rightNode == null) return null;
        return leftNode != null? leftNode:rightNode;
    }
}
