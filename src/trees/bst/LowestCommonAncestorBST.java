package trees.bst;

/**
 * Created by Ajay on 10/15/17.
 *
 *      6
 *     / \
 *    2   8
 *   /\   /\
 *  0  4 7  9
 *     \
 *     5
 *
 * QUESTIONS
 *  What kind of data does this BST support?
 *  What to do in case of duplicate value? (NEED TO ADDRESS THIS)
 *
 */
public class LowestCommonAncestorBST {
    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(2);
        Node n3 = new Node(8);
        Node n4 = new Node(0);
        Node n5 = new Node(4);
        Node n6 = new Node(7);
        Node n7 = new Node(9);
        Node n8 = new Node(5);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n5.right = n8;

        Node commonNode = new LowestCommonAncestorBST().findCommonAncestor(n1, n2, n3);
        if (commonNode != null){
            System.out.println(commonNode.key);
        } else {
            System.out.println("Common node not found!");
        }
    }

    private Node findCommonAncestor(Node node, Node n1, Node n2) {
        if (n1.key < node.key && n2.key < node.key){
            return findCommonAncestor(node.left, n1, n2);
        } else if(n1.key > node.key && n2.key > node.key){
            return findCommonAncestor(node.right, n1, n2);
        } else {
            return node;
        }
    }
}
