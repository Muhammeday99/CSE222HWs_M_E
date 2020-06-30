	import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;



public class myLinkedList<E> extends AbstractList<E>{
	Node<E> head,tail;
	int size;
	
	public myLinkedList() {
		head = null;
		tail = new Node<E>();
		size = 0;
	}
	
	public Iterator<E> iterator(int index) {
		return new iterator(index);
	}
	
	static class Node<E>{
		Node<E> nextNode , prevNode;
		E data;
		
		public Node() {
			nextNode = null;
			prevNode = null;
		}
		
		public void set(E e) {
			data = e;
		}
	}
	
	
	private class iterator implements ListIterator<E>{
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int Index;
		
		public iterator(int i) {
			if(i==0) {
				nextItem = (Node<E>) head;
				Index = 0;
			}
			else if(i == size) {
				nextItem = null;
				Index = size;
			}
		}
		
		@Override
		public boolean hasNext() {
			return nextItem != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.nextNode;
			Index++;
			return lastItemReturned.data;
		}
		
		public boolean hasPrevious() {
			return (nextItem == null && size != 0)
			|| nextItem.prevNode != null;
		}
		
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if (nextItem == null) { // Iterator past the last element
				nextItem = tail;
			}
			else {
				nextItem = nextItem.prevNode;
			}
			lastItemReturned = nextItem;
			Index--;
			return lastItemReturned.data;
		}
		
		@Override
		public void remove() {
			if(lastItemReturned.prevNode == null) {
				head = lastItemReturned.nextNode;
				lastItemReturned.nextNode.prevNode = null;
			}else if(lastItemReturned.nextNode == null) {
				tail = lastItemReturned.prevNode;
				lastItemReturned.prevNode.nextNode = null;
			}else {
				lastItemReturned.nextNode.prevNode = lastItemReturned.prevNode;
				lastItemReturned.prevNode.nextNode = lastItemReturned.nextNode;
				lastItemReturned.nextNode = lastItemReturned.prevNode = null;
			}
		}

		@Override
		public int nextIndex() {
			return Index+1;
		}

		@Override
		public int previousIndex() {
			return Index-1;
		}

		@Override
		public void set(E e) {
			nextItem.data = e;
		}

		@Override
		public void add(E e) {
			
		}
	}


	@Override
	public E get(int index) {
		if(index == 0) return head.data;
		else if (index == size) return tail.data;
		
		Node<E> tempNode = head;
		for(int i=0;i<index;i++) {
			tempNode = tempNode.nextNode;
		}
		return tempNode.data;
	}


	@Override
	public int size() {
		return size;
	}
}
