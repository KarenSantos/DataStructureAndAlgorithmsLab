package adt.hashtable;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class HashtableClosedAddressImplTest {

	HashtableClosedAddressImpl<Integer> tabela;
	
	@Before
	public void setUp() throws Exception {
	
		tabela = new HashtableClosedAddressImpl<Integer>(11, HashFunctionClosedAddressMethod.DIVISION);
	
	}

	@Test
	public void test() {

		tabela.insert(1);
		tabela.insert(2);
		tabela.insert(3);
		tabela.insert(4);
		
		
		
	}

}
