package trees.bt;

import javax.net.ssl.SNIHostName;

/**
 * Created by Ajay on 2/24/17.
 *
 *
 *            F
 *          /  \
 *        B     H
 *       / \   /
 *      A  D  G
 *        / \
 *       C   E
 */

class SNode
{
    String data;
    SNode left, right;

    SNode(String item)
    {
        data = item;
        left = right = null;
    }
}

public class TreeToLinkedList {
    public static void main(String[] args)
    {
        SNode tree = new SNode("F");
        tree.left = new SNode("B");
        tree.right = new SNode("H");
        tree.left.left = new SNode("A");
        tree.left.right = new SNode("D");
        tree.left.right.left = new SNode("C");
        tree.left.right.right = new SNode("E");
        tree.left.right.right = new SNode("E");
        tree.right.left = new SNode("G");

        TreeToLinkedList d = new TreeToLinkedList();
        //SNode n = d.BSTtoDoublyLL(tree);
        //d.printList(n);
        SNode n = d.BSTtoCircularDoublyLL(tree);
        d.printCList(n);
    }

    void printList(SNode node)
    {
        while(node.left != null){
            node = node.left;
        }
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public SNode BSTtoDoublyLL(SNode root) {

        if (root.left == null && root.right == null) {
            return root;
        }
        //left node
        SNode leftNode = null;
        if (root.left != null){
            leftNode = BSTtoDoublyLL(root.left);

            //join node
            leftNode.left = null;

            while(leftNode.right != null){
                leftNode = leftNode.right;
            }
            leftNode.right = root;
            root.left = leftNode;
        } else {
            leftNode = root;
        }

        //right node
        if (root.right != null){

            SNode rightNode = BSTtoDoublyLL(root.right);

            rightNode.left = root;
            root.right = rightNode;
            while(rightNode.right != null){
                rightNode = rightNode.right;
            }
            rightNode.right = null;
        }

        return leftNode;
    }

    void printCList(SNode node)
    {
        SNode n = node;
        do{
            System.out.println(node.data);
            node = node.right;
        }
        while(node != n);
    }

    private SNode BSTtoCircularDoublyLL(SNode n) {
        if (n == null) return n;
        SNode leftNode = BSTtoCircularDoublyLL(n.left);
        SNode rightNode = BSTtoCircularDoublyLL(n.right);

        n.left = n;
        n.right = n;

        n = concatenate(leftNode, n);
        n = concatenate(n, rightNode);

        return n;
    }

    private SNode concatenate(SNode a, SNode b) {
        if (a == null) return b;
        if (b == null) return a;

        SNode aEnd = a.left;
        SNode bEnd = b.left;

        a.left = bEnd;
        bEnd.right = a;
        aEnd.right = b;
        b.left = aEnd;

        return  a;
    }

}
