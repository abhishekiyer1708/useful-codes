package practice.binary.trees;

public class RemoveNodesNotOnPathSumCondtn {

	public int check(Node root, int k, int sum)

	{

		if (root == null)

		{

			if (sum < k)

				return 1;

			else

				return 0;

		}

		else if (root.getLeft() == null && root.getRight() == null)

		{

			sum = sum + (int) root.getData();

			if (sum < k)

				return 1;

			else

				return 0;

		}

		else

		{

			sum = sum + (int) root.getData();

			int l = check(root.getLeft(), k, sum);

			int r = check(root.getRight(), k, sum);

			if (l == 1)

				root.setLeft(null);

			if (r == 1)

				root.setRight(null);

			if (l == 1 && r == 1)

				return 1;

			else

				return 0;

		}

	}

}
