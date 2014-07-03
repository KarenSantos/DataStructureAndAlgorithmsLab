package adt.splaytree;

import adt.avltree.AVLTreeImpl;
import adt.bst.BSTNode;

public class SplayTreeImpl<T extends Comparable<T>> extends AVLTreeImpl<T>
		implements SplayTree<T> {

	public SplayTreeImpl() {
		super();
	}

	private void splay(BSTNode<T> node) {

		if (!node.equals(root)) {    // se ele ainda nao eh raiz

			BSTNode<T> parent = (BSTNode<T>) node.getParent();

			if (parent.equals(root)) {  //se o pai dele eh raiz
				
				if (parent.getLeft().equals(node)) {
					rightRotation((BSTNode<T>) parent);
				} else {
					leftRotation((BSTNode<T>) parent);
				}
			} else {
				
				BSTNode<T> grand = (BSTNode<T>) parent.getParent();
				
				if (parent.getLeft().equals(node)) {  // se ele eh filho a esquerda
					if (grand.getLeft().equals(parent)) { // se o pai dele eh filho a esquerda
						rightRotation(grand);
						rightRotation(parent);
					} else {                              // se o pai dele eh filho a direita
						rightRotation(parent);
						leftRotation(grand);
					}
				} else {							 // se ele eh filho a direita
					if (grand.getLeft().equals(parent)) { // se o pai dele eh filho a esquerda
						leftRotation(parent);
						rightRotation(grand);
					} else {                              // se o pai dele eh filho a direita
						leftRotation(grand);
						leftRotation(parent);
					}
					
				}
			}
			splay(node);
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> node = search(root, element);
		if (!node.isEmpty()) {
			splay(node);
		} else {
			if (!node.equals(root)) {
				splay((BSTNode<T>) node.getParent());
			} 			
		}
		return node;
	}

	@Override
	public void insert(T element) {
		insert(root, element);
		BSTNode<T> node = search(root, element);
		if (!node.isEmpty()) {
			splay(node);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(root, element);;
		if (node.isEmpty()) {
			if (!node.equals(root)) {
				splay((BSTNode<T>) node.getParent());
			}
		} else {
			if (!node.equals(root)) {
				BSTNode<T> toSplay = (BSTNode<T>) node.getParent();
				remove(node);
				splay(toSplay);
			} else {
				remove(node);
			}
		}
	}

	private void remove(BSTNode<T> node) {

		if (!node.isEmpty()) { // se o elemento existe

			if (node.getLeft().isEmpty() && node.getRight().isEmpty()) { // se nao tem filhos
				node.setData(null);

			} else if ((node.getLeft().isEmpty() && !node.getRight().isEmpty())
					|| (!node.getLeft().isEmpty() && node.getRight().isEmpty())) { // se tem um filho soh

				if (!(node.equals(root))) {

					if (node.getParent().getLeft().equals(node)) { // se for filho da esquerda

						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft()); 
						} else {
							node.getParent().setLeft(node.getRight()); 
						}

					} else { // se for filho da direita
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft()); 
						} else {
							node.getParent().setRight(node.getRight()); 
						}
					}

				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
					} else {
						root = (BSTNode<T>) node.getLeft();
					}
				}

			} else { // -- se tem dois filhos

				BSTNode<T> aux = new BSTNode<T>();
				aux.setData(sucessor(node.getData()).getData());
				remove(sucessor(node.getData()));
				node.setData(aux.getData());
			}
		}
	}
}
