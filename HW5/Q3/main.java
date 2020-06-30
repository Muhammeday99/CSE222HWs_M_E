
public class main {

	public static void main(String[] args) {
		AgeSearchTree mytree = new AgeSearchTree();
		
		mytree.add(new AgeData(15));
		mytree.add(new AgeData(4));
		mytree.add(new AgeData(12));
		mytree.add(new AgeData(17));

		mytree.add(new AgeData(12));
		
		System.out.println(mytree.youngerThan(15));
		
		mytree.remove(new AgeData(12));
		mytree.remove(new AgeData(17));
		
		System.out.println(mytree.find(new AgeData(12)).toString());
		
		System.out.println(mytree.toString());
	}

}
