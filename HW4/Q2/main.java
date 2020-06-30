
public class main {

	public static void main(String[] args) {
		MyDeque<Integer> a = new MyDeque<Integer>();
		
		a.addLast(1);
		a.addLast(2);
		a.addLast(3);
		
		System.out.println(a.toString());
		
		System.out.println("removed: "+a.removeLast());
		
		System.out.println(a.toString());
		
		a.addFirst(0);
		System.out.println(a.toString());
		
		System.out.println("removed: "+a.removeFirst());
		
		System.out.println(a.toString());
		
		a.offerLast(3);
		
		System.out.println(a.toString());
		
		System.out.println("removed: "+a.pollLast());
		
		System.out.println(a.toString());
		a.offerFirst(0);
		
		System.out.println(a.toString());
		
		System.out.println("removed: "+a.pollFirst());
		
		System.out.println(a.toString());
		
		System.out.println("First Element in the deque: "+a.getFirst());
		System.out.println("Last Element in the deque: "+a.getLast());
		
		System.out.println("First Element in the deque using peek: "+a.peekFirst());
		System.out.println("Last Element in the deque using peek: "+a.peekLast());
		
		a.addLast(1);
		a.addLast(2);
		
		System.out.println(a.toString());
		
		//System.out.println("Removing first occurance of 1");
		//a.removeFirstOccurrence(1);
		
		//System.out.println(a.toString());


	}

}
