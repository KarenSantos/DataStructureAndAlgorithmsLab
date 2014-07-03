package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AVLTreeImplTest {

	private AVLTreeImpl<Integer> avlTree;
	
	@Before
	public void setUp() {
		avlTree = new AVLTreeImpl<Integer>();
		
	}
	
	@Test
	public void testEmptyTree() {

		assertTrue(avlTree.isEmpty());
		
		avlTree.remove(9);
		assertTrue(avlTree.isEmpty());
		assertEquals(0, avlTree.size());
		assertEquals(-1, avlTree.height());
		assertNull(avlTree.search(0).getData());
		assertNull(avlTree.maximum());
		assertNull(avlTree.minimum());
		assertNull(avlTree.predecessor(0));
		assertNull(avlTree.sucessor(0));
		assertArrayEquals(new Integer[] {}, avlTree.preOrder());
		
		
		avlTree.insert(0);
		assertFalse(avlTree.isEmpty());
		assertEquals(1, avlTree.size());
		assertEquals(0, avlTree.height());
		assertEquals(new Integer(0), avlTree.search(0).getData());
		assertEquals(new Integer(0), avlTree.maximum().getData());
		assertEquals(new Integer(0), avlTree.minimum().getData());
		assertNull(avlTree.predecessor(0));
		assertNull(avlTree.sucessor(0));
		assertArrayEquals(new Integer[] {0}, avlTree.preOrder());
	}
	
	@Test
	public void testLeftLeftRotationRoot() {
		
		avlTree.insert(0);
		avlTree.insert(1);
		avlTree.insert(2);
		assertArrayEquals(new Integer[]{1,0,2}, avlTree.preOrder());
	}

	@Test
	public void testLeftLeftRotation() {
		
		avlTree.insert(0);
		avlTree.insert(-1);
		avlTree.insert(1);
		avlTree.insert(2);
		avlTree.insert(3);
		assertArrayEquals(new Integer[]{0,-1,2,1,3}, avlTree.preOrder());
	}
	
	@Test
	public void testRightRightRotationRoot() {
		
		avlTree.insert(2);
		avlTree.insert(1);
		avlTree.insert(0);
		assertArrayEquals(new Integer[]{1,0,2}, avlTree.preOrder());
	}
	
	@Test
	public void testRightRightRotation() {
		
		avlTree.insert(0);
		avlTree.insert(1);
		avlTree.insert(-1);
		avlTree.insert(-2);
		avlTree.insert(-3);
		assertArrayEquals(new Integer[]{0,-2,-3,-1,1}, avlTree.preOrder());
	}
	
	@Test
	public void testLeftRightRotationRoot() {
		
		avlTree.insert(2);
		avlTree.insert(-1);
		avlTree.insert(0);
		assertArrayEquals(new Integer[]{0,-1,2}, avlTree.preOrder());
	}
	
	@Test
	public void testRightLeftRotationRoot() {
		
		avlTree.insert(0);
		avlTree.insert(2);
		avlTree.insert(1);
		assertArrayEquals(new Integer[]{1,0,2}, avlTree.preOrder());
	}

	@Test
	public void testLeftRightRotation() {
		
		avlTree.insert(3);
		avlTree.insert(4);
		avlTree.insert(2);
		avlTree.insert(-1);
		avlTree.insert(0);
		assertArrayEquals(new Integer[]{3,0,-1,2,4}, avlTree.preOrder());
	}

	@Test
	public void testRightLeftRotation() {
		
		avlTree.insert(-1);
		avlTree.insert(-2);
		avlTree.insert(0);
		avlTree.insert(2);
		avlTree.insert(1);
		assertArrayEquals(new Integer[]{-1,-2,1,0,2}, avlTree.preOrder());
	}
	
	@Test
	public void remove(){
		
		avlTree.insert(0);
		avlTree.insert(1);
		avlTree.insert(-1);
		avlTree.insert(-2);
		avlTree.insert(-3);
		avlTree.remove(-2);
		assertArrayEquals(new Integer[]{0,-1,-3,1}, avlTree.preOrder());
		
		avlTree.remove(1);
		assertArrayEquals(new Integer[]{-1,-3,0}, avlTree.preOrder());
		
		avlTree.insert(2);
		avlTree.insert(1);
		avlTree.insert(4);
		assertArrayEquals(new Integer[]{1,-1,-3,0,2,4}, avlTree.preOrder());
		
		avlTree.remove(1);
		assertArrayEquals(new Integer[]{2,-1,-3,0,4}, avlTree.preOrder());
		
		avlTree.remove(4);
		assertArrayEquals(new Integer[]{-1,-3,2,0}, avlTree.preOrder());
		
	}

}
