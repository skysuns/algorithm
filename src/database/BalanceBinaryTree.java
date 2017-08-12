package database;

//�ο����ͣ�http://www.cnblogs.com/PerkinsZhu/p/5824015.html
//�洢�������ͱ���ʵ��Comparable�ӿڣ�ʵ�ֱȽϷ���
public class BalanceBinaryTree<T extends Comparable<T>> {
	private static class Node<T>{
		Node<T> left;
		Node<T> right;
		T data;
		int height;
		public Node(Node<T> left, Node<T> right, T data) {
			super();
			this.left = left;
			this.right = right;
			this.data = data;
			this.height = 0;
		}
	}
	
	private Node<T> root;
	//����(���⹫���ķ������в���)
	public Node<T> insert(T data){
		return root = insert(data, root);
	}
	//����(˽�з������еݹ���룬���ز���ڵ�)
	private Node<T> insert(T data, Node<T> node){
		if(node == null){
			 return new Node<T>(null, null, data);
		}
		
		int compareResult = data.compareTo(node.data);
		if(compareResult > 0){
			node.right = insert(data, node.right);
			if(getHeight(node.right)-getHeight(node.left) == 2){
				int compareResult1 = data.compareTo(node.right.data);
				if(compareResult1>0){
					node = rotateSingleLeft(node);
				}else{
					node = rotateDoubleRightLeft(node);
				}
			}
		}else if(compareResult < 0){
			node.left = insert(data, node.left);
			if(getHeight(node.left) - getHeight(node.right) == 2){
				int compareResult2 = data.compareTo(node.left.data);
				if(compareResult2 < 0){
					node  = rotateSingleRight(node);
				}else{
					node = rotateDoubleLeftRight(node);
				}
			}
		}
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		return node;
	}
	
	//LL��Ҫ����
	public Node<T> rotateSingleRight(Node<T> node){
		Node<T> temp = node.left;
		node.left = temp.right;
		temp.right = node;
		
		node.height = Math.max(getHeight(node.left), getHeight(node.right));
		temp.height = Math.max(getHeight(temp.left), getHeight(temp.right));
		return temp;
	}
	
	//LR��Ҫ����ת����ת
	public Node<T> rotateDoubleLeftRight(Node<T> node){
		node.left = rotateSingleLeft(node.left);
		node = rotateSingleRight(node);
		return node;
	}
	
	//RR��Ҫ��ת
	public Node<T> rotateSingleLeft(Node<T> node){
		Node<T> temp = node.right;
		node.right = temp.left;
		temp.left = node;
		
		node.height = Math.max(getHeight(node.left), getHeight(node.right));
		temp.height = Math.max(getHeight(temp.left), getHeight(temp.right));
		return temp;
	}
	
	//RL��Ҫ����ת����ת
	public Node<T> rotateDoubleRightLeft(Node<T> node){
		node.right = rotateSingleRight(node.right);
		node = rotateSingleLeft(node);
		return node;
	}
	
	
	//����
	public int getHeight(Node<T> node){
		return node==null ? -1 : node.height;
	}
	
	//ɾ��
	public Node<T> remove(T data, Node<T> node){
		if(node == null){
			return null;
		}
		
		int compareResult = data.compareTo(node.data);
		if(compareResult == 0){
			if(node.left!=null && node.right!=null){
				int balance = getHeight(node.left) - getHeight(node.right);
				Node<T> temp = node;
				if(balance == -1){
					exchangeRightData(node, node.right);
				}else{
					exchangeLeftData(node, node.left);
				}
				temp.height = Math.max(getHeight(temp.left), getHeight(temp.right))+1;
				return temp;
			}else{
				return node.left!=null? node.left:node.right;
			}
		}else if(compareResult > 0){
			node.right = remove(data, node.right);
			node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
			int balance = getHeight(node.left)-getHeight(node.right);
			if(balance == 2){
				Node<T> leftSon = node.left;
				if(leftSon.left.height > leftSon.right.height){
					return node = rotateSingleRight(node);
				}else{
					return node = rotateDoubleLeftRight(node);
				}
			}
		}else{
			node.left = remove(data, node.left);
			node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
			int balance = getHeight(node.left) - getHeight(node.right);
			if(balance == -2){
				Node<T> rightSon = node.right;
				if(rightSon.right.height > rightSon.left.height){
					return node = rotateSingleLeft(node);
				}else{
					return node = rotateDoubleRightLeft(node);
				}
			}
		}
		return null;
	}
	
	//���������е����ֵ����
	public Node<T> exchangeLeftData(Node<T> node, Node<T> right){
		if(right.right != null){
			right.right = exchangeLeftData(node, right.right);
		}else{
			node.data = right.data;
			return right.left;
		}
		right.height = Math.max(getHeight(right.right), getHeight(right.left)) + 1;
		int isbalance = getHeight(right.left) - getHeight(right.left);
		if(isbalance == 2){
			Node<T> leftSon = node.left;
			if(leftSon.left.height > leftSon.right.height){
				return node = rotateSingleRight(node);
			}else{
				return node = rotateDoubleLeftRight(node);
			}
		}
		return right;
	}
	
	//���������е���Сֵ����
	public Node<T> exchangeRightData(Node<T> node, Node<T> left){
		if(left.left != null){
			left.left = exchangeRightData(node, left.left);
		}else{
			node.data = left.data;
			return left.right;
		}
		
		left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;
		int isBalance = getHeight(left.left) - getHeight(left.right);
		if(isBalance == -2){
			Node<T> rightSon = node.right;
			if(rightSon.right.height > rightSon.left.height){
				return node = rotateSingleLeft(node);
			}else{
				return node = rotateDoubleRightLeft(node);
			}
		}
		return left;
	}
}