package adt.avltree;

import java.util.Arrays;

import adt.bst.BSTImpl;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		
		System.out.println(Arrays.toString(tree.preOrder()));
		
		System.out.println(tree.isEmpty());

		tree.insert(-1);
		tree.insert(-2);
		tree.insert(1);
		tree.insert(0);
		tree.insert(2);
		
		System.out.println(Arrays.toString(tree.preOrder()));

	}

}
