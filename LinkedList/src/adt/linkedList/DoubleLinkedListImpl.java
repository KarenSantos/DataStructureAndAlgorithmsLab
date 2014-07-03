package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl(){
		head = new DoubleLinkedListNode<T>(null, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
		last = (DoubleLinkedListNode<T>) head;
	}
	
	public T getHead(){
		return head.data;
	}
	
	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		DoubleLinkedListNode<T> auxLast = last;
		while (!(auxHead.equals(auxLast)) && !(auxHead.next.equals(auxLast)) &&
		           !(auxHead.data.equals(element)) && !(auxLast.data.equals(element))){
			auxHead = auxHead.next;
			auxLast = auxLast.previous;
		}
		T resp = null;
		if (auxHead.data.equals(element)){
			resp = auxHead.data;
		}if (auxLast.data.equals(element)){
			resp = auxLast.data;
		}
		return resp;
	}
	
	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newLast = 
				new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) last.next, last);
		last.next = newLast;
		
		if (last.isNIL()){
			head = newLast;
		}
		last = newLast;
	}

	@Override
	public void remove(T element) {
		
		if (head.data.equals(element)){
			removeFirst();
		}
		else {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
			while (!(auxHead.isNIL()) && !(auxHead.data.equals(element))){
				auxHead = (DoubleLinkedListNode<T>) auxHead.next;
			}
			if (!(auxHead.isNIL())){
				auxHead.previous.next = auxHead.next;
				
				DoubleLinkedListNode<T> aux2 = (DoubleLinkedListNode<T>) auxHead.next;
                aux2.previous = auxHead.previous;
			}
		}
	}
	
	@Override
	public void insertFirst(T element) {
		
		DoubleLinkedListNode<T> newHead = 
				new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) head, new DoubleLinkedListNode<T>());
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
		auxHead.previous = newHead;
		
		if (head.isNIL()){
			last = newHead;
		}
		head = newHead;
	}
			  
	@Override
	public void removeFirst() {

		if (!(head.isNIL())){
			head = head.next;
			
			if (head.isNIL()){
				last = (DoubleLinkedListNode<T>) head;
			}
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;
			auxHead.previous = new DoubleLinkedListNode<T>();
		}
	}

	@Override
	public void removeLast() {

		if (!(last.isNIL())){
			last = last.previous;
			
			if (last.isNIL()){
				head = last;
			}
			last.next.data = null;
		}
	}

}
