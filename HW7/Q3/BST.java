

public class BST<T extends Comparable<T>>{
		 protected Node<T> root;
		 
		 public BST() {
			 root = null;
		 }
		 
		 public boolean add(T e) {
			 if(root == null) {
				root = new Node<T>(e);
			}else {
				add(e,root);
			}
			return true;
		}
		 
		private Node<T> add(T e, Node<T> node) {
			if(node == null) {
				node = new Node<T>(e);
				return node;
			}else {
				if(e.compareTo(node.data) <= 0) node.left = add(e,node.left);
				else node.right = add(e,node.right);
				return node;
			}
		}
		 
		public void remove(T e) {
			remove(e,root);
		}
		
		private Node<T> remove(T e,Node<T> node) {
			if(root == null) return node;
			
			if(node.data.compareTo(e) > 0) {
				node.left = remove(e, node.left);
			}else if (node.data.compareTo(e) < 0) {
				node.right = remove(e, node.left);
			}else {
				if(node.left == null) return node.right;
				if(node.right == null) return node.left;
				
				node.data = minValue(node.right);
				
				node.right = remove(node.data, node.right);
 			}
			
			return node;
		}
		
		private T minValue(Node<T> node) 
	    { 
	        T minv = node.data; 
	        while (node.left != null) 
	        { 
	            minv = node.left.data; 
	            node = node.left; 
	        } 
	        return minv; 
	    } 
		 
		 static class Node<T extends Comparable<T>>{
			 protected Node<T> left,right;
			 protected T data;
			 
			 public Node(T data) {
				 this.data = data;
				 left = right = null;
			}
			 
			
		 }
	}
	