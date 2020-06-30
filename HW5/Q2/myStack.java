import java.util.NoSuchElementException;

public class myStack<E> {
	private stackNode<E> top;
	
	public myStack() {
		top = null;
	}
	
	public void push(E e) {
		stackNode<E> temp = new stackNode<E>();
		temp.data = e;
		temp.link = top;
		top = temp;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public E peek() {
		if(!isEmpty()) {
			return top.data;
		}
		return null;
	}
	
	public E pop() {
		E temp = peek();
		if (temp == null) {
			throw new NoSuchElementException("Stack is empty");
		}
		top = top.link;
		return temp;
	}
	
	private static class stackNode<E>{
		private E data;
		private stackNode<E> link;
	}
}
