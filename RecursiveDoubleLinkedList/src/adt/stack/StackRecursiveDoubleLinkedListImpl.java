package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackRecursiveDoubleLinkedListImpl(int size) {
		list = new RecursiveDoubleLinkedListImpl<T>();
		this.size = size;
	}
	
	@Override
	public void push(T element) throws StackOverflowException {

		if (list.size() == size){
			throw new StackOverflowException();
		}
		list.insertFirst(element);

	}

	@Override
	public T pop() throws StackUnderflowException {
		if (list.isEmpty()){
			throw new StackUnderflowException();
		}
		T resp = list.toArray()[list.toArray().length - 1];
		list.removeFirst();
		
		return resp;
	}

	@Override
	public T top() {
		T resp = null;
		if (!(list.isEmpty())){
			resp = list.toArray()[0];
		}
		return resp;
	}

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (list.isEmpty()){
			resp = true;
		}
		return resp;
	}

	@Override
	public boolean isFull() {
		boolean resp = false;
		if (list.size() == size){
			resp = true;
		}
		return resp;
	}

}
