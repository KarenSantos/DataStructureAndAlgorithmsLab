package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;
	
	public RecursiveSingleLinkedListImpl(){
	}
	
	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (getData() == null){
			resp = true;
		}
		return resp;
	}

	@Override
	public int size() {
		int resp;
		if (isEmpty()){
			resp = 0;
		} else {
			resp = 1 + next.size();
		}
		return resp;
	}

	@Override
	public T search(T element) {
		T resp = null;
		if (!isEmpty()){
			if (getData().equals(element)){
				resp = element;
			}else {
				resp = next.search(element);
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			setData(element);
			setNext(new RecursiveSingleLinkedListImpl<T>());
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()){
			if (getData().equals(element)){
				setData(next.getData());
				setNext(next.getNext());
			} else {
				next.remove(element);
			}
		}
	}
	
	@Override
	public T[] toArray(){
		T[] array = (T[]) new Object[size()];
		int index = 0;
		toArrayRecursive(array,this,index);
		return array;
	}

	private void toArrayRecursive(T[] array, RecursiveSingleLinkedListImpl<T> node, int index){
		if (!node.isEmpty()){
			array[index] = node.getData();
			index++;
			toArrayRecursive(array, node.next, index);
		}
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
	
}
