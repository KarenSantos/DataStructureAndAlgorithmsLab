package adt.hashtable;

public class HashtableOpenAddressQuadraticProbingImpl<T> extends
		AbstractHashtable<T, Object> {

	// DO NOT DELET THIS CONSTRUCTOR. ADJUST IT.
	public HashtableOpenAddressQuadraticProbingImpl(int size, HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		
		hashFunction = new HashFunctionQuadraticProbingImpl<T>(this, method, c1, c2);
		
		//TODO Adjust your constructor here
		// The length of the internal table must be given size
		// the hash function must be an implementation of linear probing. 
	}

	@Override
	public void insert(T element) {
		
		if (elements==capacity()){
			throw new HashtableOverflowException();
		}
		elements++;
		
		int i = 0;
		int j;
		while (i < capacity()){
			j = ((HashFunctionQuadraticProbingImpl<T>) hashFunction).hash(element, i);
			
			if (table[j]==null || table[j].equals(new DELETED())){
				table[j] = element;
				break;
			} else {
				i++;
				COLLISIONS++;
			}
		}
	}

	@Override
	public void remove(T element) {

		int index = indexOf(element);
		if (index!=-1){
			table[index] = new DELETED();
		}

	}

	@Override
	public T search(T element) {
		T result = null;

		int index = indexOf(element);
		if (index!=-1){
			result = (T) table[index];
		}
		
		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		int i = 0;
		int j = ((HashFunctionQuadraticProbingImpl<T>) hashFunction).hash(element, i);
		
		while (table[j]!=null || i < capacity()){
			
			if (table[j].equals(element)){
				result = j;
				break;
			} else {
				i++;
				j = ((HashFunctionQuadraticProbingImpl<T>) hashFunction).hash(element, i);
			}
		}
		return result;
	}

}
