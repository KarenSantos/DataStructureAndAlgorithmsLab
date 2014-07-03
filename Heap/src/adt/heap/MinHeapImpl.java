package adt.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinHeapImpl<T extends Comparable<T>> implements MinHeap<T> {

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;
		
	private T[] array;
	private int size;
	
	public MinHeapImpl(){
		array = (T[]) new Comparable[INITIAL_SIZE];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (getSize()==0){
			resp = true;
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (size==array.length){
			array = Arrays.copyOf(array, size + INCREASING_FACTOR);
		}
		size++;
		int i = size-1;
		while (i > 0 && array[getParent(i)].compareTo(element) > 0){
			array[i] = array[getParent(i)];
			i = getParent(i);
		}
		array[i] = element;
	}

	@Override
	public T extractRootElement() {
		T resp = null;
		if (!isEmpty()){
			resp = array[0];
			array[0] = array[size-1];
			size--;
			heapify(0);
		}
		return resp;
	}

	@Override
	public T rootElement() {
		T resp = null;
		if (!isEmpty()){
			resp = array[0];
		}
		return resp;
	}

	@Override
	public T[] heapsort(T[] array) {
		T[] resp;
		if (array.length!=0){ // pra resolver o erro de cast
			resp = (T[]) Array.newInstance(array[0].getClass(), size);
			int index = 0;
			buildHeap(array);
			while (!isEmpty()){
				resp[index] = extractRootElement();
				index++;
			}
		} else { // caso o array esteja vazio ele nao vai achar o array[0]
			resp = (T[]) new Comparable[0];
		}
		return resp;
	}

	@Override
	public void buildHeap(T[] array) {
		size = array.length;
		this.array = array;
		for (int i = getSize()/2; i >= 0; i--){
			heapify(i);
		}
	}

	private void heapify(int position){
		
		int left = getLeft(position);
		int right = getRight(position);
		int smallest;
		if (left < getSize() && array[left].compareTo(array[position]) < 0){
			smallest = left;
		} else {
			smallest = position;
		}
		if (right < getSize() && array[right].compareTo(array[smallest]) < 0){
			smallest = right;
		}
		if (smallest != position){
			Util.swap(array, position, smallest);
			heapify(smallest);
		}
	}
	
	@Override
	public T[] toArray() {
		T[] resp;
		if (!isEmpty()){
			resp = (T[]) Array.newInstance(array[0].getClass(), size);
			for (int i = 0; i < getSize(); i++){
				resp[i] = array[i];
			}
			return resp;
		} else {
			resp = (T[]) new Comparable[0];
		}
		return resp;
	}
	
	public int getSize(){
		return size;
	}
	
	private int getParent(int i){
		i++;
		int resp = i/2;
		return resp-1;
	}
	
	private int getLeft(int i){
		i++;
		int resp = 2*i;
		return resp-1;
	}
	
	private int getRight(int i){
		i++;
		int resp = 2*i;
		return resp;
	}
}
