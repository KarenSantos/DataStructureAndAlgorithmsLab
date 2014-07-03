package adt.bst;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

public class Teste {
	
	public static void main(String[] args) {
		
		BST<Integer> tree = new BSTImpl<Integer>();
		
		tree = new BSTImpl<Integer>();
		for (int i = 0; i < 5; i++) {
			tree.insert(i);
		}
		
		tree.remove(0);
		System.out.println(Arrays.toString(tree.preOrder()));
		tree.remove(1);
		System.out.println(Arrays.toString(tree.preOrder()));
		tree.remove(2);
		System.out.println(Arrays.toString(tree.preOrder()));
		tree.remove(3);
		System.out.println(Arrays.toString(tree.preOrder()));
		tree.remove(4);
		System.out.println(Arrays.toString(tree.preOrder()));
		
		
	}

}
