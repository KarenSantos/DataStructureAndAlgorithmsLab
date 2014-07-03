package adt.splaytree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TopDownSplayTreeImplTest {

	private final int SIZE = 5;

	private TopDownSplayTreeImpl<Integer> tree1;
	private TopDownSplayTreeImpl<Integer> tree2;
	private TopDownSplayTreeImpl<Integer> tree3;

	@Before
	public void setUp() throws Exception {
		// Somente filhos a esquerda
		tree1 = new TopDownSplayTreeImpl<Integer>();
		for (int i = 0; i < SIZE; i++) {
			tree1.insert(i);
		}

		// Somente filhos a direita
		tree2 = new TopDownSplayTreeImpl<Integer>();
		for (int i = SIZE - 1; i >= 0; i--) {
			tree2.insert(i);
		}

		// arvore vazia
		tree3 = new TopDownSplayTreeImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		assertFalse(tree1.isEmpty());
		assertFalse(tree2.isEmpty());
		assertTrue(tree3.isEmpty());
	}

	@Test
	public void testeGetRoot() {
		assertEquals(new Integer(4), tree1.getRoot().getData());
		assertEquals(new Integer(0), tree2.getRoot().getData());
		assertEquals(null, tree3.getRoot().getData());
	}

	@Test
	public void testSearch() {
		assertEquals(new Integer(4), tree1.search(4).getData());
		assertEquals(null, tree1.search(10).getData());// nao tem
		assertEquals(null, tree3.search(99).getData());// arvore vazia
	}

	@Test
	public void testSplay1() {
		
		tree3.insert(9);
		tree3.insert(8);
		tree3.insert(7);
		
		assertArrayEquals(new Integer[] {7,8,9}, tree3.preOrder());
		assertArrayEquals(new Integer[] {9,8,7}, tree3.postOrder());
	
	}
	
	@Test
	public void testSplay2() {
		assertArrayEquals(new Integer[] { 4, 3, 2, 1, 0 }, tree1.preOrder());
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4 }, tree2.preOrder());
		tree1.search(1);
		assertArrayEquals(new Integer[] {1, 0, 4, 2, 3}, tree1.preOrder());
	}
	
	@Test
	public void testSplay3() {
		
		tree3.insert(9);
		tree3.insert(8);
		tree3.insert(6);
		tree3.insert(2);
		
		assertArrayEquals(new Integer[] {9,8,6,2}, tree3.postOrder());
		
		tree3.search(2);
		assertArrayEquals(new Integer[] {9,8,6,2}, tree3.postOrder());
		
		tree3.search(4);
		assertArrayEquals(new Integer[] {2,9,8,6}, tree3.postOrder());
		
		tree3.remove(7);
		assertArrayEquals(new Integer[] {2,6,9,8}, tree3.postOrder());
		
		tree3.remove(8);
		assertArrayEquals(new Integer[] {2,6,9}, tree3.postOrder());
		
		tree3.insert(3);
		assertArrayEquals(new Integer[] {2,6,9,3}, tree3.postOrder());
		
	}
}