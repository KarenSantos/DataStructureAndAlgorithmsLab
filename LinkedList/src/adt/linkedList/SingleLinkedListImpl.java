package adt.linkedList;


public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl(){
		head = new SingleLinkedListNode<T>();
	}
	
	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (head.isNIL()){
			resp = true;
		}
		return resp;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> auxHead = head;
		while (!(auxHead.isNIL())){
			size++;
			auxHead = auxHead.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = head;
		while (!(auxHead.isNIL()) && !(auxHead.data.equals(element))){
			auxHead = auxHead.next;
		}
		return auxHead.data;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> newNode;
		if (head.isNIL()){
			newNode = new SingleLinkedListNode<T>(element, head);
			head = newNode;
		} else {
			SingleLinkedListNode<T> auxHead = head;
			while (!(auxHead.next.isNIL())){
				auxHead = auxHead.next;
			}
			newNode = new SingleLinkedListNode<T>(element, auxHead.next);
			auxHead.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		
		if (head.data.equals(element)){
			head = head.next;
		}
		else {
			SingleLinkedListNode<T> auxHead = head;
			SingleLinkedListNode<T> previous = null;
			while (!(auxHead.isNIL()) && !(auxHead.data.equals(element))){
				previous = auxHead;
				auxHead = auxHead.next;
			}
			if (!(auxHead.isNIL())){
				previous.next = auxHead.next;
			}
		}
	}

	@Override
	public T[] toArray(){
		
		T[] result = (T[]) new Object[size()];
		
		SingleLinkedListNode<T> auxHead = head;
		int count = 0;
		
		while (!(auxHead.isNIL())){
			result[count] = auxHead.data;
			auxHead = auxHead.next;
			count++;
		}
		return result;
	}

}
