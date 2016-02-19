package practice.binary.trees;

public class PrintAncestorOfGivenNode {

	public static void main(String[] args) {
		Node root = BTreeGeneralOperations.createBtree();
		printAncestor(root, 8);
	}

	private static boolean printAncestor(Node root, int target) {
		if (root==null)
			return false;
		
		if ((int)root.getData()==target)
			return true;
		
		if (printAncestor(root.getLeft(), target) || printAncestor(root.getRight(), target)) {
			System.out.println(root.getData());
			return true;
		}
		return false;
	}

}
