package adt.linkedList;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RecursiveSingleLinkedListImplTest {

	RecursiveSingleLinkedListImpl<String> lista;

	@Before
	public void setUp() throws Exception {
		lista = new RecursiveSingleLinkedListImpl<String>();
	}

	@Test
	public void testIsEmpty() {
		
		Assert.assertEquals(true, lista.isEmpty());
		Assert.assertEquals("[]", Arrays.toString(lista.toArray()));
		lista.insert("Risan");
		Assert.assertEquals(false, lista.isEmpty());
		
	}
	
	@Test
	public void testSize() {
		
		lista.insert("Risan");
		Assert.assertEquals(1, lista.size());
		lista.insert("Carmelia");
		Assert.assertEquals(2, lista.size());
		lista.insert("Karen");
		Assert.assertEquals(3, lista.size());
		lista.remove("Karen");
		Assert.assertEquals(2, lista.size());
	}
	
	@Test
	public void testSearch(){
		
		lista.insert("Risan");
		lista.insert("Carmelia");
		Assert.assertEquals(null, lista.search("Karen"));
		lista.insert("Karen");
		lista.insert("Kelen");
		Assert.assertEquals("Kelen", lista.search("Kelen"));
		Assert.assertEquals("Risan", lista.search("Risan"));
		Assert.assertEquals(null, lista.search("Andr�"));
		lista.remove("Risan");
		Assert.assertEquals(null, lista.search("Risan"));
	}
	
	@Test
	public void testToArray(){
		Assert.assertEquals("[]", Arrays.toString(lista.toArray()));
		lista.insert("Risan");
		lista.insert("Carmelia");
		Assert.assertEquals("[Risan, Carmelia]", Arrays.toString(lista.toArray()));
		lista.insert("Karen");
		lista.insert("Kelen");
		Assert.assertEquals("[Risan, Carmelia, Karen, Kelen]", Arrays.toString(lista.toArray()));
		lista.remove("Carmelia");
		Assert.assertEquals("[Risan, Karen, Kelen]", Arrays.toString(lista.toArray()));
	}

}