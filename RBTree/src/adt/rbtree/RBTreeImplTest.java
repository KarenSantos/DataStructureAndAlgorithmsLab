package adt.rbtree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.rbtree.RBNode.Colour;

public class RBTreeImplTest {

	RBTreeImpl<Integer> tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new RBTreeImpl<Integer>();
	}

	@Test
	public void test() {

		assertTrue(tree.isEmpty());
		assertNull(tree.getRoot().getData());
		assertNull(tree.search(0).getData());
		assertEquals("NIL", tree.search(10).toString());
		assertArrayEquals(new Integer[0], tree.preOrder());
		assertEquals(0, tree.size());
	}
	
	@Test
	public void testInsert1() {
		
		tree.insert(8);
		
		assertEquals(1, tree.size());
		assertEquals(Colour.BLACK, ((RBNode<Integer>) tree.getRoot()).getColour());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[0].getColour());
		assertEquals(new Integer(8), tree.extendedPreOrder()[0].getData());
		
		tree.insert(4);
		
		assertEquals(2, tree.size());
		assertEquals(Colour.BLACK, ((RBNode<Integer>) tree.getRoot()).getColour());
		assertArrayEquals(new Integer[]{8,4}, tree.preOrder());
		assertEquals(Colour.RED, tree.extendedPreOrder()[1].getColour());
		
		tree.insert(2);
		
		assertEquals(3, tree.size());
		assertEquals(Colour.BLACK, ((RBNode<Integer>) tree.getRoot()).getColour());
		assertArrayEquals(new Integer[]{4,2,8}, tree.preOrder());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[0].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[1].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[2].getColour());
		
		tree.insert(1);
		
		assertEquals(4, tree.size());
		assertEquals(Colour.BLACK, ((RBNode<Integer>) tree.getRoot()).getColour());
		assertArrayEquals(new Integer[]{4,2,1,8}, tree.preOrder());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[0].getColour());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[1].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[2].getColour());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[3].getColour());
		
		assertEquals(2, tree.blackHeight());
		
	}
	
	@Test
	public void testInsert2() {
		
		tree.insert(8);
		tree.insert(4);
		
		tree.insert(5);
		
		assertEquals(3, tree.size());
		assertEquals(Colour.BLACK, ((RBNode<Integer>) tree.getRoot()).getColour());
		assertArrayEquals(new Integer[]{5,4,8}, tree.preOrder());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[0].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[1].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[2].getColour());
	}
	
	@Test
	public void testInsert3() {
		
		tree.insert(7);
		tree.insert(9);
		
		tree.insert(10);
		
		assertEquals(3, tree.size());
		assertEquals(Colour.BLACK, ((RBNode<Integer>) tree.getRoot()).getColour());
		assertArrayEquals(new Integer[]{9,7,10}, tree.preOrder());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[0].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[1].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[2].getColour());
	}
	
	@Test
	public void testInsert4() {
		
		tree.insert(7);
		tree.insert(9);
		
		tree.insert(8);
		
		assertEquals(3, tree.size());
		assertEquals(Colour.BLACK, ((RBNode<Integer>) tree.getRoot()).getColour());
		assertArrayEquals(new Integer[]{8,7,9}, tree.preOrder());
		assertEquals(Colour.BLACK, tree.extendedPreOrder()[0].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[1].getColour());
		assertEquals(Colour.RED, tree.extendedPreOrder()[2].getColour());
	}
	
}
