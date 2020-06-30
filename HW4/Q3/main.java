
public class main {

	public static void main(String[] args) {
		RecursiveFunc foo = new RecursiveFunc();
		
		System.out.println("whiteleaf is elfish :"+foo.isElfish("whiteleaf"));
		
		System.out.println("Hello is elfish : "+foo.isElfish("Hello"));
		
		int[] arr = {1,5,0,16,6};
		
		System.out.print("unsorted array: ");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		foo.SelectionSort(arr);
		System.out.print("\nsorted array: ");
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		System.out.println("\nResult of the prefix expression -++3/-4*2568/71 = " + foo.evaluatePrefix("-++3/-4*2568/71") );
		System.out.println("Result of the postfix expression 3425*-6/+8+71/- = " + foo.evaluatePostfix("3425*-6/+8+71/-"));
		
		
		

	}

}
