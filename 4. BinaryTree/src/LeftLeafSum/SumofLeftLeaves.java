package LeftLeafSum;

import SizeOfTree.BTNode;

public class SumofLeftLeaves {
	
	public int sumOfLeftLeave(BTNode root) {
		return leftSum(root, ' ');
	}

	private int leftSum(BTNode root, char lable) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if (lable == 'L')
				return root.data;
			return 0;
		}
		int ls = leftSum(root.left, 'L');
		int rs = leftSum(root.right, 'R');

		
		return ls + rs;
	}

	public static void main(String[] args) {
		
	}

}
