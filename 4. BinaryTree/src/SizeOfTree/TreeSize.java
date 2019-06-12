package SizeOfTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSize {

	
	// Tc = O(n), Sc = O(n) [In worst case maximum stack memory will be utilised for
	// one recursion is one-sided-Binary tree of size n]
	public static int treeSize1(BTNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		// Reduction
		int ls = treeSize1(root.left);
		int rs = treeSize1(root.right);

		// solution building
		return ls + rs + 1;
	}

	// Level Order traversal [Breadth first Traversal]
	// Tc=O(n), Sc=(n)[worst case Balanced Binary Tree where leaf = n/2 where n =
	// total node]
	public static int treeSize2(BTNode root) {
		Queue<BTNode> q = new LinkedList<>();
		q.add(root);
		int count = 0;
		while (!q.isEmpty()) {
			BTNode temp = q.remove();
			count++;
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
		return count;
	}

	// Tc=n; Sc=1
	public static int treeSize3(BTNode root) {
		int count = 0;
		while (root != null)

			if (root.left != null) {
				BTNode temp = inorder_predecessor(root);
				if (temp.right == null) {
					temp.right = root;
					root = root.left;
					count++;
				} else {
					temp.right = null;
					root = root.right;
				}
			} else {
				root = root.right;
				count++;
			}
		return count;
	}

	public static int treeSize4(BTNode root) {
		int count = 0;
		while (root != null) {
			if (root.left != null) {
				BTNode temp = inorder_predecessor(root);
				if (temp.right == null) {
					temp.right = root;
					root = root.left;
					count++;
				} else {
					temp.right = null;
					root = root.right;
				}
			} else {
				root = root.right;
				count++;
			}
		}
		return count;
	}

	private static BTNode inorder_predecessor(BTNode p) {
		BTNode current = p;
		p = p.left;
		while (p.right != null && p.right != current) {
			p = p.right;
		}
		return p;
	}

	public static void main(String[] args) {

	}

}
