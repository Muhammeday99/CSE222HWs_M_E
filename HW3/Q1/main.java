import java.util.Iterator;

public class main {

	public static void main(String[] args) {

		LinkedArrayList<String> myList = new LinkedArrayList<String>();
		
		myList.add("a");
		myList.add("ab");
		myList.add("abc");
		myList.add("abcd");
		myList.add("abcde");
		myList.add("aab");
		System.out.println(myList.size());
		myList.toString();
		
		System.out.println();
		System.out.println("inserting aaa after the first node");
		myList.add(0, "aaa");
		myList.toString();

		System.out.println();
		System.out.println("inserting bcb and removing aaa");
		
		myList.add("bcb");
		myList.removeElement("aaa");
		System.out.println(myList.size());
		myList.toString();
		
		//LinkedArrayList<Integer> myListitr = new LinkedArrayList<Integer>();
		
		//Iterator<Integer> itr = myListitr.createiterator()
		
	}

}
