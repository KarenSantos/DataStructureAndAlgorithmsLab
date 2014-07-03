package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected  BSTNode<T> root;
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}
	
	protected int height(BSTNode<T> node){
		int resp;
		if (node.isEmpty()){
	        resp = -1;  
		
		} else {    
	        int left = height((BSTNode<T>) node.getLeft());    
	        int right = height((BSTNode<T>) node.getRight());    
	        if (left > right) {
	        	resp = left + 1;    
	        } else {
	        	resp = right + 1;    
	        }
	    }
		return resp;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}
	
	private BSTNode<T> search(BSTNode<T> node, T element){
		
		BSTNode<T> resp = new BSTNode<T>();
		
		if (node.isEmpty() || node.getData().equals(element)){
			resp = node;
		} else {
			if (element.compareTo(node.getData()) < 0){
				resp = search((BSTNode<T>) node.getLeft(), element);
			} else {
				resp = search((BSTNode<T>) node.getRight(), element);
			}
		}
		return resp;
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
		}
	}

	@Override
	public BSTNode<T> maximum() {
		
		BSTNode<T> resp = null;
		if (!root.isEmpty()){
			resp = maximum(root);
		}
		return resp;
	}
	
	private BSTNode<T> maximum(BSTNode<T> node){
		BSTNode<T> maximum = node;
		while (!(maximum.getRight().isEmpty())){
			maximum = (BSTNode<T>) maximum.getRight();
		}

		return maximum;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> resp = null;
		if (!root.isEmpty()){
			resp = minimum(root);
		}
		return resp;
	}
	
	private BSTNode<T> minimum(BSTNode<T> node){
		BSTNode<T> minimum = node;
		while (!(minimum.getLeft().isEmpty())){
			minimum = (BSTNode<T>) minimum.getLeft();
		}
		return minimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> resp = null;
		if (!root.isEmpty()){
			if (!(node.getRight().isEmpty())){
				resp = minimum((BSTNode<T>) node.getRight());
			} else {
				resp = (BSTNode<T>) node.getParent();
				while (!(resp==null) && node.equals(resp.getRight())){
					node = resp;
					resp = (BSTNode<T>) resp.getParent();
				}
			}
		}
		return resp;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> resp = null;
		if (!root.isEmpty()){
			if (!(node.getLeft().isEmpty())) {
				resp = maximum((BSTNode<T>) node.getLeft());
			} else {
				resp = (BSTNode<T>) node.getParent();
				while (!(resp==null) && node.equals(resp.getLeft())) {
					node = resp;
					resp = (BSTNode<T>) resp.getParent();
				}
			}
		}
		return resp;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		
		if (!node.isEmpty()){ // se o elemento existe
			
			if (node.getLeft().isEmpty() && node.getRight().isEmpty()){           // -- se nao tem filhos
				node.setData(null);
			
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
			
			} else {                                                           // -- se tem dois filhos
				
				BSTNode<T> aux = new BSTNode<T>();
				aux.setData(sucessor(element).getData());
				remove(sucessor(element).getData());
		    	node.setData(aux.getData());
			}
		}
	}

	@Override
	public T[] preOrder() {
		List<T> list = new ArrayList<T>();
		preOrder(root, list);
		return toArray(list);
	}
	
	private void preOrder(BSTNode<T> node, List<T> list){
		if (!node.isEmpty()){
			visit(node, list);
			preOrder((BSTNode<T>) node.getLeft(), list);
			preOrder((BSTNode<T>) node.getRight(), list);
		}
	}
	
	private void visit(BSTNode<T> node, List<T> list){
		list.add(node.getData());
	}

	@Override
	public T[] order() {
		List<T> list = new ArrayList<T>();
		order(root, list);
		return toArray(list);
	}

	private void order(BSTNode<T> node, List<T> list){
		if (!node.isEmpty()){
			order((BSTNode<T>) node.getLeft(), list);
			visit(node, list);
			order((BSTNode<T>) node.getRight(), list);
		}
	}
	
	@Override
	public T[] postOrder() {
		List<T> list = new ArrayList<T>();
		postOrder(root, list);
		return toArray(list);
	}

	private void postOrder(BSTNode<T> node, List<T> list){
		if (!node.isEmpty()){
			postOrder((BSTNode<T>) node.getLeft(), list);
			postOrder((BSTNode<T>) node.getRight(), list);
			visit(node, list);
		}
	}
	
	@Override
	public int size() {
		return size(root);
	}
	
	private int size(BSTNode<T> node){
		int result = 0;
		if(!node.isEmpty()){
			result = 1 + size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		return result;
	}

	private T[] toArray(List<T> list){
		T[] array = (T[]) new Comparable[list.size()];
		for (int i = 0; i < list.size(); i++){
			array[i] = list.get(i);
		}
		return array;
	}
}
