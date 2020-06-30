
public class AgeSearchTree extends BinarySearchTree<AgeData>{
	private Node<AgeData> ASTRoot;
	
	private Node<AgeData> traverse(Node<AgeData> node , AgeData item) {
		Node<AgeData> temp = node;
		if(ASTRoot == null) return null;
		if(node == null) return null;
		else if (node.data.compareTo(item) == 0) {
			return null;
		}
		else if(node.data.compareTo(item) > 0){
			temp = traverse(node.left, item);
		}else if(node.data.compareTo(item) < 0) {
			temp = traverse(node.right, item);
		}
		if(temp == null) temp = node;
		return temp;
	}
	
	@Override
	public boolean add(AgeData item) {
		ASTRoot = add(ASTRoot, item);
		return addReturn;
	}
	
	@Override
	protected Node<AgeData> add(Node<AgeData> localRoot, AgeData item){
		if(localRoot == null) {
			localRoot = new Node<AgeData>(item);
			addReturn = true;
			return localRoot;
		}
		Node<AgeData> temp = traverse(localRoot, item);
		if(temp.left != null && temp.left.data.compareTo(item) == 0) {
			temp = temp.left;
		}else if(temp.right != null && temp.right.data.compareTo(item) == 0) {
			temp = temp.right;
		}
		if(temp.data.compareTo(item) == 0) {
			temp.data.numOfPeople++;
			System.out.println("Age group already exists number of people increased by 1:(Age:" + item.getAge() + ")");
			return localRoot;
		}else {
			if (item.compareTo(temp.data) < 0) {
				temp.left = new Node<AgeData>(item);
			} else if (item.compareTo(temp.data) > 0){
				temp.right = new Node<AgeData>(item);
			}
			addReturn = true;
		}
		return localRoot;
	}
	
	@Override
	public AgeData remove (AgeData target) {
		ASTRoot = remove(ASTRoot , target) ;
		return deleteReturn ;
	}
	
	@Override
	protected Node<AgeData> remove(Node<AgeData> localRoot, AgeData item) {
		if(localRoot == null) {
			deleteReturn = null;
			return localRoot;
		}
		Node<AgeData> temp = traverse(localRoot, item);
		Node<AgeData> temp2 = null;
		if(temp.left != null && temp.left.data.compareTo(item) == 0) {
			temp2 = temp.left;
			deleteReturn = temp2.data;
			if(temp2.data.numOfPeople == 1) {
				temp.left = null;
				System.out.println("Removed age group of age " + temp2.data.getAge());
			}else if(temp2.data.numOfPeople > 1) {
				temp2.data.numOfPeople--;
				System.out.println("Age group has more than one person number of people decreased by 1:(Age:" + item.getAge() + ")");
			}
		}else if(temp.right != null && temp.right.data.compareTo(item) == 0) {
			temp2 = temp.right;
			deleteReturn = temp2.data;
			if(temp2.data.numOfPeople == 1) {
				temp.right = null;
				System.out.println("Removed age group of age " + temp2.data.getAge());
			}else if(temp2.data.numOfPeople > 1) {
				temp2.data.numOfPeople--;
				System.out.println("Age group has more than one person number of people decreased by 1:(Age:" + item.getAge() + ")");
			}
		}
		return localRoot;
	}
	
	@Override
	public AgeData find(AgeData item) {
		return find(ASTRoot, item);
	}
	
	@Override
	protected AgeData find(Node<AgeData> localRoot, AgeData item) {
		if(localRoot == null) {
			return null;
		}
		Node<AgeData> temp = traverse(localRoot, item);
		if(temp.left != null && temp.left.data.compareTo(item) == 0) {
			return temp.left.data;
		}else if (temp.right != null && temp.right.data.compareTo(item) == 0) {
			return temp.right.data;
		}
		return null;
	}
	
	public int youngerThan(int age) {
		AgeData target = new AgeData(age);
		Node<AgeData> temp = ASTRoot;
		if(temp.data.compareTo(target) != 0) {
			temp = traverse(ASTRoot, target);
			if(temp.left != null && temp.left.data.compareTo(target) == 0) {
			temp = temp.left;
			}else if (temp.right != null && temp.right.data.compareTo(target) == 0) {
				temp = temp.right;
			}
		}
		return youngerThan(temp, target,0);
	}
	
	private int youngerThan(Node<AgeData> node, AgeData target, int counter) {
		if(node == null) return counter;
		counter = youngerThan(node.left, target, counter);
		if(node.data.compareTo(target) != 0) {
			counter = youngerThan(node.right, target, counter);
			counter = counter + node.data.numOfPeople;
		}
		return counter;
	}
	
	public int olderThan(int age) {
		return olderThan(ASTRoot, age, 0);
	}
	
	private int olderThan(Node<AgeData> node, int age, int counter) {
		return counter;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(ASTRoot, sb);
		return sb.toString();
	}

	private void preOrderTraverse(Node<AgeData> node, StringBuilder sb) {
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString());
			preOrderTraverse(node.left, sb);
			preOrderTraverse(node.right, sb);
		}
	}
}
