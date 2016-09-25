package generictree;

import java.util.ArrayList;
import java.util.List;

public class Nodee<T> {
	private List<Nodee<T>> children = new ArrayList<Nodee<T>>();
	private Nodee<T> parent = null;
	private T data = null;

	public Nodee(T data) {
		this.data = data;
	}

	public Nodee(T data, Nodee<T> parent) {
		this.data = data;
		parent.children.add(this);
		this.parent = parent;
	}

	public List<Nodee<T>> getChildren() {
		return children;
	}

	public void setParent(Nodee<T> parent) {
		parent.children.add(this);
		this.parent = parent;
	}

	public void addChild(T data) {
		Nodee<T> child = new Nodee<T>(data);
		child.setParent(this);
		this.children.add(child);
	}

	public void addChild(Nodee<T> child) {
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
		Nodee<String> parentNode = new Nodee<String>("Parent");
		Nodee<String> childNode1 = new Nodee<String>("Child 1", parentNode);
		Nodee<String> childNode2 = new Nodee<String>("Child 2");

		childNode2.setParent(parentNode); 

		Nodee<String> grandchildNode = new Nodee<String>("Grandchild of parentNode. Child of childNode1", childNode1);
		List<Nodee<String>> childrenNodes = parentNode.getChildren();
		
		for(Nodee<String> n : childrenNodes){
			System.out.println(n.getData());
		}
	}
}
