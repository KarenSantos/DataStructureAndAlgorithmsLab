package adt.hashtable;


public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		HashtableClosedAddressImpl<Integer> tabela = new HashtableClosedAddressImpl<Integer>(11, HashFunctionClosedAddressMethod.DIVISION);
		
		tabela.insert(1);
		tabela.insert(2);
		tabela.insert(3);
		tabela.insert(12);
		
		System.out.println(tabela.search(1).hashCode());
		
		System.out.println(tabela.capacity());
		
		System.out.println(tabela.indexOf(12));
		
	}

}
