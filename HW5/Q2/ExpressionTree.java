import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;


public class ExpressionTree<E> extends BinaryTree {
	private myStack<Node<String>> operands;
	
	private boolean isOperator(char c) { 
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') 
        { 
            return true; 
        } 
        return false; 
    }
	
	private String editExpression(String exp, String key) {
		String temp = "";
		if(exp.length() <=0) return null;
		for (int i =key.length()+1; i < exp.length(); i++) {
			temp = temp + exp.charAt(i);
		}
		return temp;
	}
	
	private String Reverse(String exp) {
		String temp = "";
		String temp2 = "";
		exp = ' ' + exp + ' '; 
		for (int i = exp.length()-1; i >= 0; i--) {
			if(exp.charAt(i) == ' ') {
				for (int j = temp.length()-1; j >= 0; j--) {
					temp2 = temp2 + temp.charAt(j);
				}
				temp = "";
			}
			temp = temp + exp.charAt(i);
		}
		System.out.println(temp2);
		return temp2;
	}
	
	public ExpressionTree(String expression) {
		operands = new myStack<Node<String>>();
		if(isOperator(expression.charAt(0))) {
			if(expression.charAt(1) == ' ') expression = Reverse(expression);
		}
		root = readBinaryTree(new Scanner(expression)).root;
	}
	
	private void postOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append(" "); // indentation
		}
		if(node == null) {
			sb.append("null\n");
			return;
		}else {
			postOrderTraverse(node.left, depth+1, sb);
			postOrderTraverse(node.right, depth+1, sb);
			sb.append(node.toString());
			sb.append("\n");
		}
		
	}
	
	@Override
	public BinaryTree<String> readBinaryTree(Scanner scan){
		String expression;
		if(scan.hasNext()) {
			expression = scan.nextLine(); 
		}else {
			expression = null;
		}
		Node<String> newNode = null;
		BinaryTree<String> leftTree = null,rightTree = null;
		if(expression == null) {
			return null;
		}
		String data = "";
		int i = 0;
		char temp = expression.charAt(i);
		while(temp != ' ') {
			data = data + temp;
			i++;
			if(i <expression.length())	temp = expression.charAt(i);
			else temp = ' ';
		}
		newNode = new Node<String>(data);
		expression = editExpression(expression, data);
		
		if(!isOperator(data.charAt(0))) {
			operands.push(newNode);
		}else {
			Node<String> n1 = operands.pop();
			Node<String> n2 = operands.pop();
			
			newNode.right = n1;
			newNode.left = n2;
			
			operands.push(newNode);
		}
		readBinaryTree(new Scanner(expression));
		return new BinaryTree<String>(operands.peek());
	}
	
	public int eval() { 
		return eval(root);
	}
	
	private int eval(Node<String> node) {
		if(node == null) throw new NoSuchElementException();
		if(node.left == null && node.right == null) return Integer.parseInt(node.data);
		
		int a = eval(node.left);
		int b = eval(node.right);
		
		switch (node.data) {
		case "+": 
			return a+b;
		case "-": 
			return a-b;
		case "*": 
			return a*b;
		case "/": 
			return a/b;
		default:
			throw new IllegalArgumentException("Unexpected value: " + node.data);
		}
	}
	
	public String toString2() {
		StringBuilder sb = new StringBuilder();
		postOrderTraverse(root, 1, sb);
		return sb.toString();
	}
}
