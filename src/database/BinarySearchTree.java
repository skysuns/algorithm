package database;

public class BinarySearchTree {
	
	private class Node{
		public Node left;
		public Node right;
		public int val;
		public Node(Node left, Node right, int val) {
			super();
			this.left = left;
			this.right = right;
			this.val = val;
		}		
	}
	
	private Node root;
	
	public BinarySearchTree(Node root) {
		super();
		this.root = root;
	}

	//查找(时间复杂度o(logn)
	public Node search(Node root, int key){
		if(root==null){
			return null;
		}
		Node temp = root;
		while(temp!=null){
			if(temp.val > key){
				temp = temp.left;
			}else if(temp.val < key){
				temp = temp.right;
			}else{
				return temp;
			}
		}
		return null;
	}
	
	//插入
	public Node insert(Node root, int key){
		if(root == null){
			root = new Node(null, null, key);
		}
		if(root.val > key){
			root.left = insert(root.left, key);
		}else if(root.val < key){
			root.right = insert(root.right, key);
		}
		return root;
	}
	
	//删除最小值
	public Node deleteMin(Node root){
		if(root==null)return null;
		
		if(root.left == null) return root.right;
		root.left = deleteMin(root.left);
		
		return root;
	}
	//删除
	public Node delete(Node root, int key){
		if(root==null){
			return null;
		}
		
		if(root.val > key){
			root.left  = delete(root.left, key);
		}else if(root.val < key){
			root.right = delete(root.right, key);
		}else{
			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}else{
				Node temp = getMinNode(root.right);
				temp.right = deleteMin(root.right);
				temp.left = root.left;	
				return temp;
			}
		}
		return root;		
	}
	public Node getMinNode(Node roo){
		 if(root==null || root.left==null){
			 return root;
		 }
		 return getMinNode(root.left);		 
	}
}
