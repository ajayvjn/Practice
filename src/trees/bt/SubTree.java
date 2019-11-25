package trees.bt;

public class SubTree {

    // Pre-order traversing
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return true;
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
