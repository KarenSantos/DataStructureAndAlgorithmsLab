package adt.splaytree;

import java.util.Arrays;

import adt.bst.BSTImpl;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		
		tree.insert(1);
		tree.insert(0);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		
		System.out.println(Arrays.toString(tree.preOrder()));

	}

}
