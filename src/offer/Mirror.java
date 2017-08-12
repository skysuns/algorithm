package offer;

public class Mirror {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	  public void mirror(TreeNode root) {
	        if(root == null){
	            return;
	        }
	        if(root.left!=null || root.right!=null){
	            TreeNode temp = root.left;
	            root.left = root.right;
	            root.right = temp;
	        }
	        if(root.left != null){
	           mirror(root.left);
	        }
	        if(root.right != null){
	            mirror(root.right);
	        }        
	    }
}
