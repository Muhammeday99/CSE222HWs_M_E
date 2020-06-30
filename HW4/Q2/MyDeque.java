import java.util.*;



public class MyDeque<E> extends AbstractCollection<E> implements Deque<E>{
	private myLinkedList<E> deque, removed;
	
	public MyDeque() {
		deque = new myLinkedList<E>();
		removed = new myLinkedList<E>();
		deque.size = removed.size = 0;
	}
	
	@Override
	public void addFirst(E e) {
		if(removed.size == 0) {
			if(deque.head == null) {
				deque.head = new myLinkedList.Node<E>();
				deque.head.set(e);
			}else {
				myLinkedList.Node<E> newNode = new myLinkedList.Node<E>();
				newNode.set(e);
				newNode.nextNode = deque.head;
				deque.head.prevNode = newNode;
				deque.head = newNode;
			}
		}else {
			removed.head.set(e);
			removed.head.nextNode = deque.head;
			deque.head.prevNode = removed.head;
			removed.head.prevNode = null;
			deque.head = removed.head;
			if(removed.head.nextNode!=null)
				removed.head = removed.head.nextNode;
			removed.size--;
		}
		if(deque.size == 0) deque.tail = deque.head;
		deque.size++;
	}

	@Override
	public void addLast(E e) {
		if(removed.size == 0) {
			myLinkedList.Node<E> newNode = new myLinkedList.Node<E>();
			newNode.set(e);
			newNode.prevNode = deque.tail;
			deque.tail.nextNode = newNode;
			deque.tail = newNode;
		}else {
			removed.head.set(e);
			removed.head.prevNode= deque.tail;
			removed.head.nextNode = null;
			deque.tail.nextNode = removed.head;
			deque.tail = removed.head;
			if(removed.head.nextNode!=null)
				removed.head = removed.head.nextNode;
			removed.size--;
		}
		if(deque.size == 0) deque.head = deque.tail;
		deque.size++;
	}

	@Override
	public boolean offerFirst(E e) {
		addFirst(e);
		return true;
	}

	@Override
	public boolean offerLast(E e) {
		addLast(e);
		return true;
	}

	@Override
	public E removeFirst() {
		if(deque.size == 0)
			throw new NoSuchElementException();
		else {
			if(removed.head == null) {
				removed.head = new myLinkedList.Node<E>();
			}
			myLinkedList.Node<E> temp = deque.head;
			deque.head = deque.head.nextNode;
			deque.head.prevNode = null;
			temp.nextNode = removed.head;
			removed.head.prevNode = temp;
			removed.head = temp;
			deque.size--;
			removed.size++;
		}
		return removed.head.data;
	}

	@Override
	public E removeLast() {
		if(deque.size == 0)
			throw new NoSuchElementException();
		else {
			if(removed.head == null) {
				removed.head = new myLinkedList.Node<E>();
			}
			myLinkedList.Node<E> temp = deque.tail;
			deque.tail = deque.tail.prevNode;
			deque.tail.nextNode = null;
			temp.nextNode = removed.head;
			removed.head.prevNode = temp;
			removed.head = temp;
			deque.size--;
			removed.size++;
		}
		return removed.head.data;
	}

	@Override
	public E pollFirst() {
		if(deque.size == 0)
			return null;
		else {
			if(removed.head == null) {
				removed.head = new myLinkedList.Node<E>();
			}
			myLinkedList.Node<E> temp = deque.head;
			deque.head = deque.head.nextNode;
			deque.head.prevNode = null;
			temp.nextNode = removed.head;
			removed.head.prevNode = temp;
			removed.head = temp;
			deque.size--;
			removed.size++;
		}
		return removed.head.data;
	}

	@Override
	public E pollLast() {
		if(deque.size == 0)
			return null;
		else {
			if(removed.head == null) {
				removed.head = new myLinkedList.Node<E>();
			}
			myLinkedList.Node<E> temp = deque.tail;
			deque.tail = deque.tail.prevNode;
			deque.tail.nextNode = null;
			temp.nextNode = removed.head;
			removed.head.prevNode = temp;
			removed.head = temp;
			deque.size--;
			removed.size++;
		}
		return removed.head.data;
	}

	@Override
	public E getFirst() {
		if(deque.size == 0)
			throw new NoSuchElementException();
		return deque.head.data;
	}

	@Override
	public E getLast() {
		if(deque.size == 0)
			throw new NoSuchElementException();
		return deque.tail.data;
	}

	@Override
	public E peekFirst() {
		if(deque.size == 0) return null;
		
		return deque.head.data;
	}

	@Override
	public E peekLast() {
		if(deque.size == 0) return null;
		
		return deque.tail.data;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		Iterator<E> itr = deque.iterator(0);
		while (itr.hasNext()) {
			if(itr.next().equals(o)) {
				itr.remove();
				return true;
			}	
		}
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		ListIterator<E> itr = (ListIterator<E>) deque.iterator(deque.size);
		while (itr.hasPrevious()) {
			if(itr.previous() == o) {
				itr.remove();
				return true;
			}	
		}
		return false;
	}

	@Override
	public boolean offer(E e) {
		return offerLast(e);
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public E poll() {
		return pollFirst();
	}

	@Override
	public E element() {
		return getFirst();
	}

	@Override
	public E peek() {
		return peekFirst();
	}

	@Override
	public void push(E e) {
		addFirst(e);
		
	}

	@Override
	public E pop() {
		return removeFirst();
	}

	@Override
	public Iterator<E> descendingIterator() {
		return deque.iterator(deque.size);
	}

	@Override
	public Iterator<E> iterator() {
		return deque.iterator(0);
	}

	@Override
	public int size() {
		return deque.size;
	}
	
	@Override
	public String toString() {
		Iterator<E> itr = deque.iterator(0);
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		return "";
	}
	

}
