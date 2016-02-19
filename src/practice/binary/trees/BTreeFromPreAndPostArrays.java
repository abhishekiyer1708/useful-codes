package practice.binary.trees;

public class BTreeFromPreAndPostArrays {
	
	public static void main(String args[]) {
		int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
		int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};
		
		int preIndex = 0;
		Node fullTree = constructTreeUtil(pre, post, preIndex, 0, post.length-1, pre.length);
		printPreOrder(fullTree);
	}
	
	public static Node constructTreeUtil(int[] pre, int[] post, int preIndex, int postStart, int postEnd, int size) {
		
		//base case
		if (preIndex >= size || postStart>postEnd) {
			return null;
		}
		
		Node root = createNode(pre[preIndex]);
		++preIndex;
		
		if (postStart==postEnd) {
			return root;
		}
		int i;
		for(i=postStart;i<postEnd;++i){
			if (pre[preIndex]==post[i]) {
				break;
			}
		}
		
		if (i<postEnd) {
			root.setLeft(constructTreeUtil(pre, post, preIndex, postStart, i, size));
			root.setRight(constructTreeUtil(pre, post, preIndex, i+1, postEnd, size));
		}
		
		return root;
	}

	public static Node createNode(int i) {
		Node newNode = new Node();
		newNode.setData(i);
		newNode.setLeft(null);
		newNode.setRight(null);
		return newNode;
	}
	
	public static void printInorder(Node root) {
		if (root==null)
			return;
		printInorder(root.getLeft());
		System.out.println(root.getData());
		printInorder(root.getRight());
	}
	
	public static void printPreOrder(Node root) {
		System.out.println(root.getData());
		printInorder(root.getLeft());
		printInorder(root.getRight());
	}
	
	public static void printPostOrder(Node root) {
		printInorder(root.getLeft());
		printInorder(root.getRight());
		System.out.println(root.getData());
	}

}
