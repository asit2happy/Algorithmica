package RootToLeafpath;

import java.util.LinkedList;
import java.util.Queue;

import SizeOfTree.BTNode;

public class LongestRootToLeafPath {

	public static int longestRLPath1(BTNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null)
			return 1;
		int ls=longestRLPath1(root.left);
		int rs=longestRLPath1(root.right);
		
		return Math.max(ls, rs) +1;
	}
	
	public static int longestRLPath2(BTNode root) {
		Queue<BTNode> q= new LinkedList<BTNode>();
		q.add(root);
		q.add(null);
		int lcount=0;
		while(!q.isEmpty()) {
			BTNode temp= q.remove();
			if(temp==null) {
				lcount++;
				if(!q.isEmpty())
					q.add(null);
			}else {
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		return lcount;
	}
}
