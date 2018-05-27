package offer;

public class ReConstructBinaryTree6 {
	public class TreeNode {
	     int val;
	     TreeNode left;
		 TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public TreeNode reConstructBinaryTree(int[] pre, int[] in){
		if(pre==null || in==null || pre.length==0 || in.length==0){
			return null;
		}
		return constructCore(pre, 0, pre.length-1, in, 0, in.length-1);
	}
	public TreeNode constructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
		if(startPre>endPre || startIn>endIn){
			return null;
		}
		TreeNode root = new TreeNode(pre[startPre]);
		
		for(int i=startIn; i<=endIn; i++){
			if(in[i] == pre[startPre]){
				root.left = constructCore(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
				root.right = constructCore(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);			}
		}
		return root;
	}
}
