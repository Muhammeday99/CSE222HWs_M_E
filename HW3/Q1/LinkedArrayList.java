import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;



public class LinkedArrayList<E> extends AbstractList<E> implements List<E>{
	private Node<E> headNode,tailNode;
	private int size;
	
	public LinkedArrayList() {
		headNode = new Node<E>();
		tailNode = headNode;
		size = 0;
	}
	
	public boolean add(E e) {
		add(size,e);
		return true;
	}
	
	public void add(int Index, E e) {
		Node<E> tempNode = headNode;
		Node<E> tempNode2 = null;
		for(int i=0;i<Index;i++) {
			tempNode = tempNode.nextNode;
		}
		if (tempNode.isFull()) {
			if(tempNode.nextNode != null) {
				tempNode2 = tempNode.nextNode;
			}
			tempNode.nextNode = new Node<E>();
			size++;
			tempNode.nextNode.prevNode = tempNode;
			tempNode = tempNode.nextNode;
			tempNode.nextNode = tempNode2;
			if(tempNode.nextNode==null) {
				tailNode = tempNode;
			}
		}
		tempNode.add(e);
	}
	
	public boolean removeElement(E e) {
		Node<E> tempNode = headNode;
		while (tempNode != null) {
			if (tempNode.remove(e)) {
				if (tempNode.isEmpty()) { // if node is empty delete it
					if (tempNode == headNode) { // if node is head make head the next node
						headNode = tempNode.nextNode;
						headNode.prevNode = null;
					}else if(tempNode == tailNode) { // if node is tail make tail the prev node
						tailNode = tempNode.prevNode;
						tailNode.nextNode = null;
					}else { // if node is in the middle connect prev node to next node
						tempNode.prevNode.nextNode = tempNode.nextNode;
						tempNode.nextNode.prevNode = tempNode.prevNode;
					}
					size--;
				}
				return true;
			}
			tempNode = tempNode.nextNode;
		}
		throw new NoSuchElementException();
	}
	
	public String toString() {
		Node<E> tempNode = headNode;
		while (tempNode != null) {
			tempNode.toString();
			tempNode = tempNode.nextNode;
		}
		return "a";
	}
	
	private static class Node<E>{
		private E[] dataArray;
		private Node<E> nextNode;
		private Node<E> prevNode;
		private int size;
		private final int CAPACITY = 3;
		
		public Node() {
			dataArray = (E[]) new Object[CAPACITY];
			nextNode = null;
			prevNode = null;
			size = 0;
		}
		
		public boolean isFull() {
			return size == CAPACITY;
		}
		
		public int Arrsize() {
			return size;
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public boolean remove(E e) {
			for (int i = 0; i < size; i++) {
				if(dataArray[i].equals(e)) {
					for (int j = i; j < size-1; j++) {
						dataArray[j] = dataArray[j+1];
					}
					size--;
					return true;
				}
			}
			return false;
		}
		
		public void add(E e) {
			dataArray[size] = e;
			size++;
		}
		
		public void set(E e) {
			dataArray[0] = e;
		}
		
		public E get(int Index) {
			return dataArray[Index];
		}
		
		public String toString() {
			for(int i=0;i<size;i++) {
				System.out.print(dataArray[i]+" ");
			}
			System.out.println();
			return "a";
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>(0);
	}
	
	private class Iterator<T> implements ListIterator<E>{
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int Index;
		
		public Iterator(int i) {
			// Validate i parameter.
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
			lastItemReturned = null; // No item returned yet.
			// Special case of last item
			if (i == size) {
				Index = size;
				nextItem = null;
			}
			else { // Start at the beginning
				nextItem = headNode;
			for (Index = 0; Index < i; Index++) {
				nextItem = nextItem.nextNode;
				}
			}
		}
		
		public boolean hasNext() {
			return nextItem != null;
		}
		
		public E next() {
			if (!hasNext()) {
			throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.nextNode;
			Index++;
			return lastItemReturned.dataArray[Index];
			}
		
		public boolean hasPrevious() {
			return (nextItem == null && size != 0)
			|| nextItem.prevNode != null;
			}
		
		@Override
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if (nextItem == null) { // Iterator past the last element
				nextItem = tailNode;
			}
			else {
				nextItem = nextItem.prevNode;
			}
			lastItemReturned = nextItem;
			Index--;
			return lastItemReturned.dataArray[Index];
		}
		
		public void add(E e) {
			if(nextItem == headNode) {
				if(headNode.isFull()) {
					Node<E> newNode = new Node<E>();
					newNode.add(e);
					newNode.nextNode = nextItem;
					nextItem.prevNode = newNode;
					headNode = newNode;
				}else {
					nextItem.add(e);
				}
			}
			if (nextItem == null) {
				if(tailNode.isFull()) {
					Node<E> newNode = new Node<E>();
					newNode.add(e);
					tailNode.nextNode = newNode;
					newNode.prevNode = tailNode;
					tailNode = newNode;
				}else {
					add(e);
				}
			}else {
				if (nextItem.isFull()) {
					Node<E> newNode = new Node<E>();
					newNode.add(e);
					newNode.prevNode = nextItem.prevNode;
					nextItem.prevNode.nextNode = newNode;
					newNode.nextNode = nextItem;
					nextItem.prevNode = newNode;
				}else {
					nextItem.add(e);
				}
			}
			size++;
			Index++;
		}

		@Override
		public int nextIndex() {
			return Index+1;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return Index-1;
		}

		@Override
		public void remove() {
			if (lastItemReturned == headNode) { // if node is head make head the next node
				headNode = lastItemReturned.nextNode;
				headNode.prevNode = null;
			}else if(lastItemReturned == tailNode) { // if node is tail make tail the prev node
				tailNode = lastItemReturned.prevNode;
				tailNode.nextNode = null;
			}else { // if node is in the middle connect prev node to next node
				lastItemReturned.prevNode.nextNode = lastItemReturned.nextNode;
				lastItemReturned.nextNode.prevNode = lastItemReturned.prevNode;
			}
			size--;
		}

		@Override
		public void set(E e) {
			lastItemReturned.set(e);
		}
		

	}
	

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}
}
