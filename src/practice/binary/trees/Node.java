package practice.binary.trees;

public class Node {
	
	private Object data;
	private Node left;
	private Node right;
	private Node nextRight;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getNextRight() {
		return nextRight;
	}
	public void setNextRight(Node nextRight) {
		this.nextRight = nextRight;
	}
	

}
