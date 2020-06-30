package softwareStore;

public interface SearchTree<T extends Comparable<T>> {
	public T search(T key);
	public void add(T item);
	public void remove(T key);
	
	static class Node<T extends Comparable<T>>{
		Node<T> left,right,parent;
		T data;
		
		public Node(T d) {
			data = d;
			left = right = parent = null;
		}
	}
}
