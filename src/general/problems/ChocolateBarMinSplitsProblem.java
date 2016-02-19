package general.problems;

public class ChocolateBarMinSplitsProblem {

	public static void main(String[] args) {
		System.out
				.println(minSplitNumberVariant(226800000, 10000000, 938071715));

	}

	static int minSplitNumber(int width, int height, int nTiles) {
		int ret = 5;
		for (int a = 1; a * a <= nTiles; ++a)
			if (nTiles % a == 0) {
				int b = nTiles / a;
				if (a <= width && b <= height || a <= height && b <= width) {
					if (a == width && b == height || a == height && b == width)
						ret = Math.min(ret, 0);
					else if (a == width || a == height || b == width
							|| b == height)
						ret = Math.min(ret, 1);
					else
						ret = Math.min(ret, 2);
				}
			}
		return ret == 5 ? -1 : ret;
	}

	static int minSplitNumberVariant(int width, int height, int nTiles) {
		if ((long) width * height < (long) nTiles)
			return -1;
		if ((long) width * height == (long) nTiles)
			return 0;
		if (nTiles % width == 0 || nTiles % height == 0)
			return 1;
		for (int a = 1; a * a <= nTiles; ++a)
			if (nTiles % a == 0) {
				int b = nTiles / a;
				if (a <= width && b <= height || a <= height && b <= width)
					return 2;
			}
		return -1;
	}

}
