	
	
public class RBBST<T extends Comparable<T>> extends BSTWRotation<T>{
		private boolean addReturn;
		
		//Methods
		
		public boolean add(T item){
			if(root == null){
				root = new RedBlackNode<T>(item);
				((RedBlackNode<T>) root).isRed = false; //root is black
				return true;
			} else {
				root = add((RedBlackNode<T>) root, item);
				((RedBlackNode<T>) root).isRed = false; //root is black
				return addReturn;
			}
		}
		
		/**
		 * Recursive add method
		 * @param localRoot The local root of the Red Black Tree
		 * @param item The item to be inserted
		 * @return The new local root
		 */
		private Node<T> add(RedBlackNode<T> localRoot, T item){
			int compare = item.compareTo(localRoot.data);
			if(compare == 0){
				//Item is already in tree
				addReturn = false;
				return localRoot;
			} else if (compare < 0){
				//item < localRoot.data
				if(localRoot.left == null){
					//Create new left child
					localRoot.left = new RedBlackNode<T>(item);
					addReturn = true;
					return localRoot;
				} else { //Need to search
					//Check for two red children, swap colors if found
					moveBlackDown(localRoot);
					//Recursively add on the left
					localRoot.left = add((RedBlackNode<T>) localRoot.left, item);
					//See whether the left child is now red
					if(((RedBlackNode<T>) localRoot.left).isRed){
						if(localRoot.left.left != null
								&& ((RedBlackNode<T>) localRoot.left.left).isRed){
							// Left-left grand-child is also red
							// Single rotation is necessary; change colors
							((RedBlackNode<T>) localRoot.left).isRed = false;
							localRoot.isRed = true;
							return rotateRight(localRoot);
						} else if (localRoot.left.right != null
								&& ((RedBlackNode<T>) localRoot.left.right).isRed){
							// Left-right grand-child is also red
							// Double rotation is necessary; change colors
							localRoot.left = rotateLeft(localRoot.left);
							((RedBlackNode<T>) localRoot.left).isRed = false;
							localRoot.isRed = true;
							return rotateRight(localRoot);
						}
					}
					return localRoot;
				}
			} else {
				//item is greater than localRoot.data
				if(localRoot.right == null){
					//Create new right child
					localRoot.right = new RedBlackNode<T>(item);
					addReturn = true;
					return localRoot;
				} else { //Need to search
					//Check for two red children, swap if needed
					moveBlackDown(localRoot);
					//Recursively add on the right
					localRoot.right = add((RedBlackNode<T>) localRoot.right, item);
					//See whether right child is now red
					if(((RedBlackNode<T>) localRoot.right).isRed){
						if(localRoot.right.right != null
								&& ((RedBlackNode<T>) localRoot.right.right).isRed){
							//Right-right grand-child is also red
							//Single rotation is necessary, change colors
							((RedBlackNode<T>) localRoot.right).isRed = false;
							localRoot.isRed = true;
							return rotateLeft(localRoot);
						} else if (localRoot.right.left != null
								&& ((RedBlackNode<T>) localRoot.right.left).isRed){
							//Right-left grand-child is also red
							//Double rotation is necessary; change colors
							localRoot.right = rotateRight(localRoot.right);
							((RedBlackNode<T>) localRoot.right).isRed = false;
							localRoot.isRed = true;
							return rotateLeft(localRoot);
						}
					}
					return localRoot;
				}
			}
		}
		
		/**
		 * Check to see whether both children of the given node are red.
		 * If so, make them black and change the localRoot's color to red.
		 * @param localRoot The node to check whether both children are red or not
		 */
		private void moveBlackDown(RedBlackNode<T> localRoot){
			if(localRoot.left != null && localRoot.right != null){ //If a child is null, it is black
				if(((RedBlackNode<T>) localRoot.left).isRed 
						&& ((RedBlackNode<T>) localRoot.right).isRed){ //if both children are red, swap colors
					((RedBlackNode<T>) localRoot.left).isRed = false;
					((RedBlackNode<T>) localRoot.right).isRed = false;
					localRoot.isRed = true;
				}
			}
		}
		
		/*
		 * @param <T> The data type of items stored in the node. Must be Comparable
		 */
	private static class RedBlackNode<T extends Comparable<T>> extends Node<T> {
	
			//Additional Data Fields
			/**
			 * Color indicator; true if red, false if black
			 */
			private boolean isRed;
			
			/**
			 * Constructor to create a node with the default color of red with the given data
			 * @param data The data item to be stored in the node
			 */
			public RedBlackNode(T data) {
				super(data);
				isRed = true;
			}
			
			//Methods
			
			/**
			 * Return a String representation of the node
			 * @return A String representation of the node
			 */
			@Override
			public String toString(){
				if(isRed){
					return "Red: " + super.toString();
			} else {
					return "Black: " + super.toString();
	 		}
		}
			
	}
}