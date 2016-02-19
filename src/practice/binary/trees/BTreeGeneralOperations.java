package practice.binary.trees;

public class BTreeGeneralOperations {
	
	public static void main(String args[]) {
		Node root = createBtree();
		//System.out.println(findHeightOfTree(root));
		levelOrderTraversal(root);
	}

	public static int findHeightOfTree(Node root) {
		if (root==null)
			return 0;
		else
			return Math.max(findHeightOfTree(root.getLeft()), findHeightOfTree(root.getRight()))+1;
	}
	
	public static void levelOrderTraversal(Node root){
		int height = findHeightOfTree(root);
		for(int i=1;i<=height;i++)
			printGivenLevel(root, i);
	}
	
	public static void levelOrderNExtRightTraversal(Node root){
		int height = findHeightOfTree(root);
		for(int i=1;i<=height;i++)
			printNextRightAtGivenLevel(root, i);
	}

	public static void printGivenLevel(Node root, int level) {
		if (root==null)
			return;
		if (level==1)
			System.out.println(root.getData());
		else if (level > 1) {
			printGivenLevel(root.getLeft(), level-1);
			printGivenLevel(root.getRight(), level-1);
		}
	}
	
	public static void printNextRightAtGivenLevel(Node root, int level) {
		if (root==null)
			return;
		if (level==1)
			System.out.println(root.getData());
		else if (level > 1) {
			printNextRightValues(root.getLeft(), level-1);
			printNextRightValues(root.getRight(), level-1);
		}
	}
	
	public static void printNextRightValues(Node root, int level) {
		if (root==null)
			return;
		if (level==1)
			System.out.println(root.getData() + " next right points to " + root.getNextRight() != null ? root.getNextRight().getData() : "NULL");
		else if (level > 1) {
			printGivenLevel(root.getLeft(), level-1);
			printGivenLevel(root.getRight(), level-1);
		}
	}

	public static Node createBtree() {
		Node root = createNode(1);
		root.setLeft(createNode(2));
		root.setRight(createNode(3));
		root.getLeft().setLeft(createNode(4));
		root.getRight().setLeft(createNode(5));
		root.getRight().setRight(createNode(6));
		root.getRight().getLeft().setRight(createNode(7));
		root.getRight().getLeft().getRight().setLeft(createNode(9));
		root.getRight().getRight().setRight(createNode(6));
		root.getRight().getRight().getRight().setRight(createNode(8));
		//root.getRight().getRight().getRight().getRight().setRight(createNode(10));
		//root.getRight().getRight().getRight().getRight().getRight().setLeft(createNode(11));
		return root;
	}
	
	public static Node createNode(int i) {
		Node newNode = new Node();
		newNode.setData(i);
		newNode.setLeft(null);
		newNode.setRight(null);
		return newNode;
	}

}
