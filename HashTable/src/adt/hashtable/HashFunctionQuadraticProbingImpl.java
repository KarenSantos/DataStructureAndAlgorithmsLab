package adt.hashtable;

public class HashFunctionQuadraticProbingImpl<T> implements	HashFunctionOpenAddress {
	
	protected Hashtable<T> hashtable;
	protected int c1;
	protected int c2;
	
	// The auxiliary hash function used by quadratic probing.
	protected HashFunctionClosedAddress originalHashFunction;
	
	public HashFunctionQuadraticProbingImpl(Hashtable<T> hashtable, 
			HashFunctionClosedAddressMethod method, //the method of the original hash function
			int c1, int c2) {
		super();
		this.hashtable = hashtable;
		//Adjust your constructor to initialize the attribute originalHashFunction with the correct hash function
		
		if (method.equals("DIVISION")){
			originalHashFunction = new HashFunctionDivisionMethodImpl<T>(this.hashtable);
		} else {
			
		}
		
		this.c1 = c1;
		this.c2 = c2;
	}
	
	/**
	 * The hash function might use the length of the hashtable. This can be captured through the method
	 * capacity of the hashtable.
	 */
	@Override
	public int hash(Object element, int probe) {
		int resp;
		resp = (int)(originalHashFunction.hash(element) + c1*probe + c2*(Math.pow(probe, 2))) % hashtable.capacity();
		return resp;
	}

}
