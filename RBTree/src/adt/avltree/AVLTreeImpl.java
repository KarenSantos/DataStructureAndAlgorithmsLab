package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class AVLTreeImpl<T extends Comparable<T>> 
    extends BSTImpl<T> implements AVLTree<T> {

	public AVLTreeImpl(){
		super();
	}
	
	//AUXILIARY
	protected int calculateBalance(BSTNode<T> node){
		int resp = 0;
		if (!node.isEmpty()){
			resp = height((BSTNode<T>)node.getLeft()) - height((BSTNode<T>)node.getRight()); 
		}
		return resp;
	}
	
	//AUXILIARY
	protected void rebalance(BSTNode<T> node){
		int balance = calculateBalance(node);
		
		if (balance > 1){
			int balance2 = calculateBalance((BSTNode<T>)node.getLeft());
			if (balance2 < 0){
				leftRotation((BSTNode<T>)node.getLeft());
				rightRotation(node);
			} else {
				rightRotation(node);
			}
		} else if (balance < -1){
			int balance2 = calculateBalance((BSTNode<T>)node.getRight());
			if (balance2 > 0) {
				rightRotation((BSTNode<T>)node.getRight());
				leftRotation(node);
			} else {
				leftRotation(node);
			}
		}
	}
	
	//AUXILIARY
	protected void rebalanceUp(BSTNode<T> node){
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while(parent!=null){
			rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}
	
	//AUXILIARY
	protected void leftRotation(BSTNode<T> node){
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();
		
		node.setRight(pivot.getLeft());
		node.getRight().setParent(node);
		
		pivot.setLeft(node);
		pivot.setParent(node.getParent());
		
		node.setParent(pivot);

		if (node.equals(root)){
			root = pivot;
		} else {
			if (node.equals(pivot.getParent().getRight())){
				pivot.getParent().setRight(pivot);
			} else {
				pivot.getParent().setLeft(pivot);
			}
		}
		
	}
	
	//AUXILIARY
	protected void rightRotation(BSTNode<T> node){
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();
		
		node.setLeft(pivot.getRight());
		node.getLeft().setParent(node);
		
		pivot.setRight(node);
		pivot.setParent(node.getParent());

		node.setParent(pivot);
		
		if (node.equals(root)){
			root = pivot;
		} else {
			if (node.equals(pivot.getParent().getRight())){
				pivot.getParent().setRight(pivot);
			} else {
				pivot.getParent().setLeft(pivot);
			}
		}
		
	}
	
	@Override
	public void insert(T element) {
		insert(root, element);
	}
	private void insert(BSTNode<T> node, T element){
		if (node.isEmpty()){
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0){
				insert((BSTNode<T>) node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0){
				insert((BSTNode<T>) node.getRight(), element);
			}
			rebalance(node);
		}
	}
	
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		
		if (!node.isEmpty()){ // se o elemento existe
			
			if (node.getLeft().isEmpty() && node.getRight().isEmpty()){           // -- se nao tem filhos
				node.setData(null);
				rebalanceUp(node);
			
			} else if ((node.getLeft().isEmpty() && !node.getRight().isEmpty()) || 
					  (!node.getLeft().isEmpty() && node.getRight().isEmpty())) { // -- se tem um filho soh 
				
				if (!(node.equals(root))) {
					
					if (node.getParent().getLeft().equals(node)){ // se for filho da esquerda
				
						if (!node.getLeft().isEmpty()) {
			                 node.getParent().setLeft(node.getLeft()); // node.left is left child of node.parent
						} else {
			                 node.getParent().setLeft(node.getRight()); // node.right is left child of node.parent
						}
				
					} else {                                       // se for filho da direita
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft()); // node.left is right child of parent
						} else {
			                node.getParent().setRight(node.getRight());  // node.right is right child of parent
						}
					}
				
				} else {
					if (node.getLeft().isEmpty()){
						root = (BSTNode<T>) node.getRight();
					} else {
						root = (BSTNode<T>) node.getLeft();
					}
				}
				rebalanceUp(node);
			
			} else {                                                           // -- se tem dois filhos
				
				BSTNode<T> aux = new BSTNode<T>();
				aux.setData(sucessor(element).getData());
				remove(sucessor(element).getData());
		    	node.setData(aux.getData());
			}
		}
	}
	
}