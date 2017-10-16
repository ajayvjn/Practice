package trees.bt;

/**
 * Created by Ajay on 10/15/17.
 *
 *  Check both subtrees of the parent node for symmetry.
 *  Perform a recursion for this.
 */
public class MirrorSubTree {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        Node n6 = new Node(4);
        Node n7 = new Node(3);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(new MirrorSubTree().isMirror(n2, n3));
    }

    private boolean isMirror(Node n1, Node n2) {
        if(n1==null  && n2 == null){
            return true;
        }
        if(n1==null  ||  n2 == null){
            return false;
        }

        if (n1.key == n2.key){
            return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
        }
        return false;
    }


}
