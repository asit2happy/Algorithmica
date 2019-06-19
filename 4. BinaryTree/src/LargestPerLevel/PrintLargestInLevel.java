package LargestPerLevel;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import SizeOfTree.BTNode;

public class PrintLargestInLevel {

	public static List<Integer> largestInLevel(BTNode root){
		Queue<BTNode> q= new LinkedList<BTNode>();
		q.add(root);
		q.add(null);
		List<Integer> list=new ArrayList<Integer>();
		list.add(root.data);
		int max=0;
		
		while (!q.isEmpty()) {
			BTNode temp = q.remove();
			if (temp == null) {
				list.add(max);
				max=0;
				if(!q.isEmpty())
					q.add(null);
			} else {
				if (root.left != null) {
					q.add(root.left);
					max=Math.max(max, root.left.data);
				}
				if (root.right != null) {
					q.add(root.right);
					max=Math.max(max, root.right.data);
					
				}				
			}
		}
		return list;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
