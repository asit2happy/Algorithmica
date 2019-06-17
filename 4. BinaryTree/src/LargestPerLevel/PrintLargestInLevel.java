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
		int sum = 0;
		int bigestl=0;
		
		while (!q.isEmpty()) {
			BTNode temp = q.remove();
			if (temp == null) {
				System.out.println(sum);
				list.add(bigestl);
				sum=0;
				bigestl=0;
				if(!q.isEmpty())
					q.add(null);

			} else {
				sum = +temp.data;
				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);

                if(root.left.data>root.right.data)
                    bigestl=root.left.data;
                else
                    bigestl=root.right.data;
			}
		}
		return list;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
