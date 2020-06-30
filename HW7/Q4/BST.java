package softwareStore;

import softwareStore.SearchTree.Node;

public class BST<T extends Comparable<T>> implements SearchTree<T>{
	private BSTNode<T> root;
	
	public BSTNode<T> getroot(){
		return root;
	}
	
	@Override
	public T search(T key) {
		if(search(key, root) != null)
			return search(key, root).data;
		return null;
	}
	
	public BSTNode<T> search(T key, BSTNode<T> node) {
		if(node.data.compareTo(key) == 0) return node;
		if(node.data.compareTo(key) > 0) return search(key, node.left);
		if(node.data.compareTo(key) < 0) return search(key, node.right);
		return null;
	}

	@Override
	public void add(T item) {
		if(root == null) {
			root = new BSTNode<T>(item);
			return;
		}
		root = add(item, root,null);
		
	}
	
	private BSTNode<T> add(T item, BSTNode<T> node, BSTNode<T> parent) {
		if(node == null) {
			node = new BSTNode<T>(item);
			return node;
		}
		else {
			if(item.compareTo(node.data) == 0) {
				return node;
			}
			if(item.compareTo(node.data) > 0) {
				node.right = add(item, node.right,node);
			}else {
				node.left = add(item, node.left,node);
			}
			return node;
		}
	}

	@Override
	public void remove(T key) {
		remove(key, root,null);
	}
	
	private void remove(T key, BSTNode<T> node, BSTNode<T> parent) {
		if(node.data.compareTo(key) == 0) {
			if(node.left == null && node.right == null) {
				if(parent.right.equals(node)) parent.right = null;
				else if (parent.left.equals(node)) parent.left = null;
			}else if (node.left == null && node.right != null) {
				node.data = node.right.data;
				remove(node.right.data, node.right,node);
			}else if (node.right == null && node.left != null) {
				node.data = node.left.data;
				remove(node.left.data, node.left,node);
			}else if(node.left != null && node.right != null) {
				T temp = minV(node.right);
				node.data = temp;
				remove(temp, node.right,node);
			}
		}
		else if (node.data.compareTo(key) < 0) remove(key,node.right,node);
		else remove(key,node.left,node);
	}
	
	private T minV(BSTNode<T> node) {
		if(node.left != null) return minV(node.left);
		return node.data;
	}
	
	public void print() {
		print(root);
	}
	
	private void print(BSTNode<T> node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data.toString());
		print(node.left);
		print(node.right);
	}
	
	
	static class BSTNode<T extends Comparable<T>>{
		BSTNode<T> left,right;
		T data;
		
		public BSTNode(T d) {
			data = d;
			left = right = null;
		}
	}
}
