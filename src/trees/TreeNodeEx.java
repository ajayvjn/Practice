package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 29-Sep-16.
 * Get all the childern in a tree
 */
public class TreeNodeEx<T> {
    private List<TreeNodeEx<T>> children = new ArrayList<TreeNodeEx<T>>();
    private TreeNodeEx<T> parent = null;
    private T data = null;

    public TreeNodeEx(T data) {
        this.data = data;
    }

    public TreeNodeEx(T data, TreeNodeEx<T> parent) {
        this.data = data;
        parent.children.add(this);
        this.parent = parent;
    }

    public List<TreeNodeEx<T>> getChildren() {
        return children;
    }

    public void setParent(TreeNodeEx<T> parent) {
        parent.children.add(this);
        this.parent = parent;
    }

    public void addChild(T data) {
        TreeNodeEx<T> child = new TreeNodeEx<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(TreeNodeEx<T> child) {
        child.parent = this;
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if (this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }

    public static void main(String[] args) {
        TreeNodeEx<String> parentNode = new TreeNodeEx<String>("Parent");
        TreeNodeEx<String> childNode1 = new TreeNodeEx<String>("Child 1", parentNode);
        TreeNodeEx<String> childNode2 = new TreeNodeEx<String>("Child 2");

        childNode2.setParent(parentNode);

        TreeNodeEx<String> grandchildNode = new TreeNodeEx<String>("Grandchild of parentNode. Child of childNode1", childNode1);
        List<TreeNodeEx<String>> childrenNodes = parentNode.getChildren();

        for (TreeNodeEx<String> n : childrenNodes) {
            System.out.println(n.getData());
        }
    }
}
