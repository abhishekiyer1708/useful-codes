package practice.binary.trees;

public class NextPointerInTree {

	public static void main(String[] args) {
		Node root = BTreeGeneralOperations.createBtree();
		BTreeGeneralOperations.levelOrderTraversal(root);
		makeNextPointerInTree(root);
		BTreeGeneralOperations.levelOrderNExtRightTraversal(root);
	}

	public static void makeNextPointerInTree(Node root) {
		if (root == null)
			return;
		Node rightMostChild = (root.getRight() != null) ? root.getRight()
				: root.getLeft();

		if (rightMostChild == null)
			return;
		// Continue to identify the sibling for root.rightmost (The right most
		// child for root)
		Node temp = root.getNextRight();
		Node leftMostSibling = null;
		while (temp != null && leftMostSibling != null) {
			// Left most sibling to the right in the current level from the
			// right most node of the current node
			leftMostSibling = (temp.getLeft() != null) ? temp.getLeft() : temp
					.getRight();
			if (leftMostSibling != null) {
				rightMostChild.setNextRight(leftMostSibling);
			}
			temp = temp.getNextRight();
		}
		// Finally if the left and right child exists, connect left to right
		if (rightMostChild != root.getLeft() && root.getLeft() != null) {
			root.getLeft().setNextRight(root.getRight());
		}
		// Go down the tree to fix other links
		makeNextPointerInTree(root.getLeft());
		makeNextPointerInTree(root.getRight());

	}

}
