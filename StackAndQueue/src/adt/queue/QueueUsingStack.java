package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	
	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (stack1.isFull()){
			throw new QueueOverflowException();
		}
		
		while (!stack1.isEmpty()){
			try {
				stack2.push(stack1.pop());
			} catch (Exception e){
			}
		}
		
		try{
			stack1.push(element);
		}catch (Exception e){
		}

		while (!stack2.isEmpty()){
			try {
				stack1.push(stack2.pop());
			} catch (Exception e){
			}
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (!stack1.isEmpty()){
			try{
				result = stack1.pop();
			} catch (Exception e){
			}
		} else {
			throw new QueueUnderflowException();
		}
		return result;
	}

	@Override
	public T head() {
		T result = null;
		if(!isEmpty()){
			result = stack1.top();
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}
