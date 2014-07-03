package adt.heap;

import static org.junit.Assert.*;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class MinHeapImplTest {
	
	MinHeapImpl<Integer> heapInt;
	MinHeapImpl<String> heapSt;
	

	@Before
	public void setUp() throws Exception {
		heapInt = new MinHeapImpl<Integer>();
		heapSt = new MinHeapImpl<String>();
	}

	@Test
	public void testEmpty() {
		assertEquals(true, heapInt.isEmpty());
		assertEquals(true, heapSt.isEmpty());
		assertArrayEquals(new Integer[]{}, heapInt.toArray());
		assertArrayEquals(new String[]{}, heapSt.toArray());
		assertEquals(0, heapInt.getSize());
		assertEquals(0, heapSt.getSize());
		assertEquals(null, heapInt.rootElement());
		assertEquals(null, heapSt.rootElement());
		assertEquals(null, heapInt.extractRootElement());
		assertEquals(null, heapSt.extractRootElement());
	}
	
	@Test
	public void testInsertInt() {
		heapInt.insert(5);
		assertArrayEquals(new Integer[]{5}, heapInt.toArray());
		Integer[] array = (Integer[]) heapInt.toArray();
		assertArrayEquals(new Integer[]{5}, heapInt.toArray());
		assertEquals("[5]", Arrays.toString(heapInt.heapsort(array)));
		
		heapInt.insert(5);
		assertEquals(false, heapInt.isEmpty());
		assertEquals(1, heapInt.getSize());
		assertEquals(new Integer(5), heapInt.rootElement());
		
		heapInt.insert(3);
		assertArrayEquals(new Integer[]{3,5}, heapInt.toArray());
		assertArrayEquals(new Integer[]{3,5}, heapInt.heapsort(heapInt.toArray()));
		
		heapInt.insert(5);
		heapInt.insert(3);
		assertEquals(2, heapInt.getSize());
		assertEquals(new Integer(3), heapInt.rootElement());
		
		heapInt.insert(4);
		heapInt.insert(7);
		heapInt.insert(2);
		assertArrayEquals(new Integer[]{2,3,4,7,5}, heapInt.toArray());
		assertArrayEquals(new Integer[]{2,3,4,5,7}, heapInt.heapsort(heapInt.toArray()));

	}
	
	@Test
	public void testInsertString() {
		heapSt.insert("karen");
		assertArrayEquals(new String[]{"karen"}, heapSt.toArray());
		assertArrayEquals(new String[]{"karen"}, heapSt.heapsort(heapSt.toArray()));
		
		heapSt.insert("karen");
		assertEquals(false, heapSt.isEmpty());
		assertEquals(1, heapSt.getSize());
		assertEquals("karen", heapSt.rootElement());
		
		heapSt.insert("andre");
		assertArrayEquals(new String[]{"andre", "karen"}, heapSt.toArray());
		assertArrayEquals(new String[]{"andre", "karen"}, heapSt.heapsort(heapSt.toArray()));
		
		heapSt.insert("karen");
		heapSt.insert("andre");
		assertEquals(2, heapSt.getSize());
		assertEquals("andre", heapSt.rootElement());
		
		heapSt.insert("papi");
		heapSt.insert("mami");
		heapSt.insert("kelen");
		assertArrayEquals(new String[]{"andre", "karen", "papi", "mami", "kelen"}, heapSt.toArray());
		assertArrayEquals(new String[]{"andre", "karen", "kelen", "mami", "papi"}, heapSt.heapsort(heapSt.toArray()));
		
	}
	
	@Test
	public void testRemoveInt() {
		heapInt.insert(5);
		heapInt.insert(3);
		heapInt.insert(4);
		heapInt.insert(7);
		heapInt.insert(2);
		assertArrayEquals(new Integer[]{2,3,4,7,5}, heapInt.toArray());
		
		assertEquals(new Integer(2), heapInt.rootElement());
		assertArrayEquals(new Integer[]{2,3,4,7,5}, heapInt.toArray());
		
		assertEquals(new Integer(2), heapInt.extractRootElement());
		assertArrayEquals(new Integer[]{3,5,4,7}, heapInt.toArray());
		
		assertEquals(new Integer(3), heapInt.extractRootElement());
		assertArrayEquals(new Integer[]{4,5,7}, heapInt.toArray());
		
		assertEquals(new Integer(4), heapInt.extractRootElement());
		assertArrayEquals(new Integer[]{5,7}, heapInt.toArray());
		
		assertEquals(new Integer(5), heapInt.extractRootElement());
		assertArrayEquals(new Integer[]{7}, heapInt.toArray());
		
		assertEquals(new Integer(7), heapInt.extractRootElement());
		assertArrayEquals(new Integer[]{}, heapInt.toArray());
		
		assertEquals(null, heapInt.extractRootElement());
		
	}
	
	@Test
	public void testBuildHeap() {
		
		heapInt.insert(5);
		heapInt.insert(9);
		heapInt.insert(3);
		heapInt.insert(1);
		heapInt.insert(7);
		heapInt.insert(4);
		
		assertArrayEquals(new Integer[]{1,3,4,9,7,5}, heapInt.toArray());
		
		Integer[] array = new Integer[] {2,7,4,9,1,5,3};
		heapInt.buildHeap(array);
		
		assertArrayEquals(new Integer[]{1, 2, 3, 9, 7, 5, 4}, heapInt.toArray());
		
		
	}

}
