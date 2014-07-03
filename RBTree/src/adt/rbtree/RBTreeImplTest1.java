package adt.rbtree;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;



public class RBTreeImplTest1 {

	@Test
	public void test() {
		RBTreeImpl<Integer> tree = new RBTreeImpl<Integer>();
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());
		
		tree.insert(10);
		assertEquals(1, tree.size());
		assertEquals(0, tree.height());
		
		tree.insert(15);
		tree.insert(5);
		
		assertTrue("[(10,B), (5,R), (15,R)]".equals(Arrays.toString(tree.extendedPreOrder())));
		tree.insert(1);
		assertTrue("[(10,B), (5,B), (1,R), (15,B)]".equals((Arrays.toString(tree.extendedPreOrder()))));
		tree.insert(12);
		assertTrue("[(10,B), (5,B), (1,R), (15,B), (12,R)]".equals(Arrays.toString(tree.extendedPreOrder())));
		assertTrue(tree.verifyProperties());
		/**
		 *       10
		 *     5   15
		 *    1   12
		 */

		tree.insert(14);
		assertTrue("[(10,B), (5,B), (1,R), (14,B), (12,R), (15,R)]".equals(Arrays.toString(tree.extendedPreOrder())));
		assertEquals(2, tree.height());
		assertTrue(tree.verifyProperties());
		assertEquals(6, tree.size());
		tree.insert(3);
		assertTrue("[(10,B), (3,B), (1,R), (5,R), (14,B), (12,R), (15,R)]".equals(Arrays.toString(tree.extendedPreOrder())));
		tree.insert(4);
		assertTrue("[(10,B), (3,R), (1,B), (5,B), (4,R), (14,B), (12,R), (15,R)]".equals(Arrays.toString(tree.extendedPreOrder())));
		assertTrue(tree.verifyProperties());
		tree.insert(13);
		assertEquals("[(10,B), (3,R), (1,B), (5,B), (4,R), (14,R), (12,B), (13,R), (15,B)]", (Arrays.toString(tree.extendedPreOrder())));
		assertEquals(3, tree.height());
		
	}

}