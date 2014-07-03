package adt.hashtable;

import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends AbstractHashtable<T, LinkedList<T>> {

	private int size;
	
	// DO NOT DELETE THIS CONSTRUCTOR. ADJUST IT.
	public HashtableClosedAddressImpl(int size, HashFunctionClosedAddressMethod method) {
		super(size);
		
		table = new LinkedList[getPrimeAbove(size)];
		
		hashFunction = new HashFunctionDivisionMethodImpl<T>(this);

		for (int i = 0; i < capacity(); i++){
			table[i] = new LinkedList<T>();
		}
		
		//TODO Adjust your constructor here
		// The length of the internal table must be the immediate prime number greater than 
		// the given size. For example, if size=10 then the length must be 11. If size=20, the length 
		// must be 23. You may use the method getPrimeAbove(int size) but you must implement it.
	}
	
	//AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given number.  
	 */
	private int getPrimeAbove(int number){
		int result = number;
		while(!Util.isPrime(result)){
			result = result + 1;
		}
		return result;
	}
			
	@Override
	public void insert(T element) {
		elements++;
		
		if (table[((HashFunctionDivisionMethodImpl<T>) hashFunction).hash(element)].size() > 0){
			COLLISIONS++;
		}
		
		table[((HashFunctionDivisionMethodImpl<T>) hashFunction).hash(element)].add(element);
		
	}

	@Override
	public void remove(T element) {
		table[((HashFunctionDivisionMethodImpl<T>)hashFunction).hash(element)].remove(element);
		
	}

	@Override
	public T search(T element) {
		
		T result = null;
		
		LinkedList<T> lista = table[((HashFunctionDivisionMethodImpl<T>)hashFunction).hash(element)];
		
		for (int i = 0; i < lista.size(); i++){
			if (element.equals(lista.get(i))){
				result = lista.get(i);
			}
		}
		
		return result;
	}

	@Override
	public int indexOf(T element) {
		
		int resp = -1;
		if (search(element)!=null){
			resp = ((HashFunctionDivisionMethodImpl<T>)hashFunction).hash(element);
		}
		
		return resp;
	}

}
