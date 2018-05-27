package offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LevelTravse23 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
        	return list;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	TreeNode temp = queue.poll();
        	list.add(temp.val);
        	if(temp.left != null){
        		queue.add(temp.left);
        	}
        	if(temp.right != null){
        		queue.add(temp.right);
        	}
        }
        return list;
    }
}
