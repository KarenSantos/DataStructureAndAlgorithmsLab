package adt.skipList;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkipListImplTest {

	private SkipListImpl<Integer> lista;
	
	
	@Before
	public void setUp() throws Exception {
		
		lista = new SkipListImpl<Integer>(4);
		
	}

	@Test
	public void test() {

		lista.insert(1, 1);
		assertEquals(1, lista.toArray()[0].getKey());
		
		lista.insert(5, 5);
		assertEquals(5, lista.toArray()[1].getKey());
		assertEquals(2, lista.size());
		
		assertNull(lista.search(4));
		assertEquals(new Integer(1), lista.search(1).satteliteData);

		lista.remove(2);
		assertEquals(2, lista.size());
		
		lista.remove(1);
		assertEquals(1, lista.size());
		
		lista.insert(3, 3, 5);
		assertNull(lista.search(3));
		
		lista.insert(3, 3, 4);
		assertEquals(2, lista.size());
		assertEquals(new Integer(3), lista.search(3).satteliteData);
		assertEquals(4, lista.height());
	}
	
	@Test
	public void test2() {
		
		assertNull(lista.search(0));
		
		assertEquals(0, lista.size());
		lista.remove(0);
		assertEquals(0, lista.size());
		
		lista.insert(3, 3, 2);
		
		assertEquals(1, lista.size());
		
	}

}
