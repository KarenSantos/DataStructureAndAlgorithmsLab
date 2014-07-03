package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;
	
	public RecursiveDoubleLinkedListImpl(){}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			setData(element);
			setNext(new RecursiveDoubleLinkedListImpl<T>());
			if (getPrevious()==null){
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			}
		} else {
			next.insert(element);
		}
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()){
			insert(element);
		} else{
			RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<T>();
			node.setData(getData());
			node.setNext(getNext());
			node.setPrevious(this);
			setData(element);
			setNext(node);
		}
	}
	
	@Override
	public void remove(T element){
		if (!isEmpty()){
			if (getData().equals(element)){
				if (previous.isEmpty() && next.isEmpty()){
					setData(null);
					setNext(new RecursiveDoubleLinkedListImpl<T>());
					setPrevious(new RecursiveDoubleLinkedListImpl<T>());
				} else {
					setData(next.getData());
					setNext(next.getNext());
					if (!next.isEmpty()){
						((RecursiveDoubleLinkedListImpl<T>)next).setPrevious(this);
					}
				}
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()){
			if (previous.isEmpty() && next.isEmpty()){
				setData(null);
				setNext(new RecursiveDoubleLinkedListImpl<T>());
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			} else {
				setData(next.getData());
				setNext(next.getNext());
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());
				if (!next.isEmpty()){
					((RecursiveDoubleLinkedListImpl<T>)next).setPrevious(this);
				}
			}
		}

	}

	@Override
	public void removeLast() {
		if (!isEmpty()){
			if (previous.isEmpty() && next.isEmpty()){
				removeFirst();
			} else {
				if (next.isEmpty()){
					setData(null);
				} else {
					((RecursiveDoubleLinkedListImpl<T>)next).removeLast();
				}
			}
		}
	}
	
	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
