package adt.btree;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BTreeImplTest {

	BTreeImpl<Integer> tree;
	BTreeImpl<Integer> tree2;
	
	@Before
	public void setUp() throws Exception {
		tree = new BTreeImpl<Integer>(3);
		tree2 = new BTreeImpl<Integer>(4);
	}

	@Test
	public void testEmpty() {

		assertEquals(-1, tree.height());
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertNull(tree.search(0).node);
		assertEquals(0, tree.search(1).position);
		assertEquals("[]", tree.maximum(tree.getRoot()).toString());
		assertEquals("[]", tree.minimum(tree.getRoot()).toString());
		assertArrayEquals(new Integer[0], tree.depthLeftOrder());
		
	}
	
	@Test
	public void testInsert() {
		
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		
		assertArrayEquals(new String[]{"[2]","[1]","[3]"}, tree.toStringArray());
		assertEquals(1, tree.height());
		assertFalse(tree.isEmpty());
		assertEquals(3, tree.size());
		assertArrayEquals(new Integer[]{2}, tree.getRoot().getElements().toArray());
		assertEquals(0, tree.search(1).position);
		assertEquals(0, tree.search(2).position);
		assertEquals(0, tree.search(3).position);
		assertEquals("[3]", tree.maximum(tree.getRoot()).toString());
		assertEquals("[1]", tree.minimum(tree.getRoot()).toString());

		
		tree.insert(4);
		tree.insert(5);
		
		assertArrayEquals(new String[]{"[2, 4]","[1]","[3]","[5]"}, tree.toStringArray());
		assertEquals(5, tree.size());
		assertArrayEquals(new Integer[]{2,4}, tree.getRoot().getElements().toArray());
		assertEquals(0, tree.search(2).position);
		assertEquals(1, tree.search(4).position);
		assertEquals(0, tree.search(5).position);
		assertEquals("[5]", tree.maximum(tree.getRoot()).toString());
		assertEquals("[1]", tree.minimum(tree.getRoot()).toString());
		
		tree.insert(6);
		tree.insert(7);
		
		assertArrayEquals(new String[]{"[4]","[2]","[1]","[3]","[6]","[5]","[7]"}, tree.toStringArray());
		assertEquals(7, tree.size());
		assertArrayEquals(new Integer[]{4}, tree.getRoot().getElements().toArray());
		assertEquals(0, tree.search(6).position);
		assertEquals(0, tree.search(7).position);
		assertEquals("[7]", tree.maximum(tree.getRoot()).toString());
		assertEquals("[1]", tree.minimum(tree.getRoot()).toString());
		
		assertNull(tree.search(0).node);

	}
	
	@Test
	public void testInsert2(){
		
		tree2.insert(1);
		tree2.insert(8);
		tree2.insert(14);
		tree2.insert(22);
		tree2.insert(26);
		tree2.insert(30);
		tree2.insert(34);
		tree2.insert(16);
		tree2.insert(20);
		tree2.insert(18);
		tree2.insert(19);
		
		assertEquals(11, tree2.size());
		assertEquals(1, tree2.search(19).position);
		assertEquals(1, tree2.search(18).position);
		assertArrayEquals(new String[]{"[22]","[14, 19]","[1, 8]","[16, 18]","[20]","[30]","[26]","[34]"}, 
				tree2.toStringArray());
		
		assertEquals("[34]", tree.maximum(tree2.getRoot()).toString());
		assertEquals("[1, 8]", tree.minimum(tree2.getRoot()).toString());

	}
	
}
