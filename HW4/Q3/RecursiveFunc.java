import java.util.Stack;

public class RecursiveFunc {
	private Stack<Double> Stack; 
	
	private void swap(int[] arr,int index1, int index2) {
		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public String reverse(String str) {
		int counter = 0;
		for(int i = 0;i < str.length();i++) {
			if(str.charAt(i) == ' ') counter++;
		}
		return reverse(str,counter);
	}
	
	private String reverse(String str, int Index) {
		return "";
		
	}
	
	
	public boolean isElfish(String str) {
		return isElfish(str,0,0,false,false,false);
	}
	
	private boolean isElfish(String str, int index, int counter,boolean e_flag,boolean l_flag,boolean f_flag) {
		if(counter == 3) return true;
		if(index >= str.length() && counter != 3) return false;
		
		boolean istrue = false;
		if((str.charAt(index) == 'e' || str.charAt(index) == 'E') && !e_flag) { 
			counter++;
			e_flag = true;
		}
		
		else if((str.charAt(index) == 'l' || str.charAt(index) == 'L') && !l_flag) {
			counter++;
			l_flag = true;
		}
		
		else if((str.charAt(index) == 'f' || str.charAt(index) == 'F') && !f_flag) {
			counter++;
			f_flag = true;
		}
		
		istrue = isElfish(str,index+1,counter,e_flag,l_flag,f_flag);
		if(istrue) return true;
		else return false;
	}
	
	public void SelectionSort(int[] array) {
		SelectionSort(array,0,1);
	}
	
	private void SelectionSort(int[] array, int index,int j) {
		if(index == array.length-1) return;
		
		if(array[index] > array[j]) {
			swap(array,index, j);
		}
		if(j<array.length-1) SelectionSort(array, index,j+1); 
		SelectionSort(array, index+1,index+2);
	}
	
	public double evaluatePrefix(String str) {
		Stack = new Stack<Double>();
		
		return evaluatePrefix(str, str.length()-1);
	}
	
	private double evaluatePrefix(String str, int index) {
		if(index < 0) return Stack.pop();
		if(str.charAt(index) != '+' && str.charAt(index) != '-' && str.charAt(index) != '*' && str.charAt(index) != '/' ) {
			Stack.push((double) str.charAt(index) - 48);
		}else {
			double a = Stack.pop();
			double b = Stack.pop();
			
			switch(str.charAt(index)) {
				case '+' :
					Stack.push(a+b);
					break;
				case '-' :
					Stack.push(a-b);
					break;
				case '*' :
					Stack.push(a*b);
					break;
				case '/' :
					Stack.push(a/b);
					break;
			}
		}
		return evaluatePrefix(str, index-1);
	}
	
	public double evaluatePostfix(String str) {
		Stack = new Stack<Double>();
		
		return evaluatePostfix(str, 0);
	}

	private double evaluatePostfix(String str, int index) {
		if(index == str.length()) return Stack.pop();
		if(str.charAt(index) != '+' && str.charAt(index) != '-' && str.charAt(index) != '*' && str.charAt(index) != '/' ) {
			Stack.push((double) str.charAt(index) - 48);
		}else {
			double a = Stack.pop();
			double b = Stack.pop();
			
			switch(str.charAt(index)) {
				case '+' :
					Stack.push(b+a);
					break;
				case '-' :
					Stack.push(b-a);
					break;
				case '*' :
					Stack.push(b*a);
					break;
				case '/' :
					Stack.push(b/a);
					break;
			}
		}
		return evaluatePostfix(str, index+1);
	}
	
	public void printArr(int[] arr) {
		
	}
}




