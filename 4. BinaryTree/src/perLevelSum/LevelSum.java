package perLevelSum;

import java.util.LinkedList;
import java.util.Queue;

import SizeOfTree.BTNode;

public class LevelSum {

	public int getlevelSum(BTNode root) {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		q.add(null);
		int sum = 0;
		while (!q.isEmpty()) {
			BTNode temp = q.remove();
			if (temp == null) {
				System.out.println(sum);
				sum=0;
				if(!q.isEmpty())
					q.add(null);

			} else {
				sum = +temp.data;
				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
