
public class main {

	public static void main(String[] args) {
		ExpressionTree tree = new ExpressionTree("10 5 15 * + 20 +");
		
		System.out.println(tree.toString());
		System.out.println("\n\n");
		System.out.println(tree.toString2());
		
		System.out.println(tree.eval());

	}

}
