package adt.queue;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStackTest {
	
	QueueUsingStack<Integer> queue;
	QueueUsingStack<String> queueString;
	
	@Before
	public void antes(){
		queue = new QueueUsingStack<Integer>(5);
		queueString = new QueueUsingStack<String>(4);
	}

	@Test
	public void testEmptyQueueInt() {
		
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		
		try {
			queue.dequeue();
			fail("Nao deu erro");
		} catch (QueueUnderflowException e){
		}

		Assert.assertEquals(null, queue.head());
	}
	
	@Test
	public void testEnqDeqInt() throws Exception {
		queue.enqueue(1);
		Assert.assertEquals(new Integer(1), queue.head());
		queue.enqueue(2);
		Assert.assertEquals(new Integer(1), queue.head());
		queue.enqueue(3);
		Assert.assertEquals(new Integer(1), queue.head());
		
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		
		queue.enqueue(4);
		Assert.assertEquals(new Integer(1), queue.head());
		queue.enqueue(5);
		Assert.assertEquals(new Integer(1), queue.head());
		
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(true, queue.isFull());
		
		try {
			queue.enqueue(6);
			fail("Nao deu erro");
		} catch (QueueOverflowException e){
		}
		
		queue.dequeue();
		Assert.assertEquals(new Integer(2), queue.head());
		queue.dequeue();
		Assert.assertEquals(new Integer(3), queue.head());
		queue.dequeue();
		Assert.assertEquals(new Integer(4), queue.head());
		queue.dequeue();
		Assert.assertEquals(new Integer(5), queue.head());
		
		Assert.assertEquals(false, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		
		queue.dequeue();
		Assert.assertEquals(null, queue.head());
		
		Assert.assertEquals(true, queue.isEmpty());
		Assert.assertEquals(false, queue.isFull());
		
	}
	
	@Test
	public void testEmptyQueueString() {
		
		Assert.assertEquals(true, queueString.isEmpty());
		Assert.assertEquals(false, queueString.isFull());
		
		try {
			queueString.dequeue();
			fail("Nao deu erro");
		} catch (QueueUnderflowException e){
		}

		Assert.assertEquals(null, queueString.head());
	}
	
	@Test
	public void testEnqDeqString() throws Exception {
		queueString.enqueue("Um");
		Assert.assertEquals("Um", queueString.head());
		queueString.enqueue("Dois");
		Assert.assertEquals("Um", queueString.head());
		queueString.enqueue("Tres");
		Assert.assertEquals("Um", queueString.head());
		
		Assert.assertEquals(false, queueString.isEmpty());
		Assert.assertEquals(false, queueString.isFull());
		
		queueString.enqueue("Quatro");
		Assert.assertEquals("Um", queueString.head());
		
		Assert.assertEquals(false, queueString.isEmpty());
		Assert.assertEquals(true, queueString.isFull());
		
		try {
			queueString.enqueue("Cinco");
			fail("Nao deu erro");
		} catch (QueueOverflowException e){
		}
		
		queueString.dequeue();
		Assert.assertEquals("Dois", queueString.head());
		queueString.dequeue();
		Assert.assertEquals("Tres", queueString.head());
		queueString.dequeue();
		Assert.assertEquals("Quatro", queueString.head());
		
		Assert.assertEquals(false, queueString.isEmpty());
		Assert.assertEquals(false, queueString.isFull());
		
		queueString.dequeue();
		Assert.assertEquals(null, queueString.head());
		
		Assert.assertEquals(true, queueString.isEmpty());
		Assert.assertEquals(false, queueString.isFull());
		
	}

}
