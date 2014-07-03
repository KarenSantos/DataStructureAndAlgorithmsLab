package adt.queue;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueImplTest {
	
	QueueImpl<Integer> queueInt;
	QueueImpl<String> queueString;
	
	@Before
	public void antes(){
		queueInt = new QueueImpl<Integer>(5);
		queueString = new QueueImpl<String>(4);
		
	}

	@Test
	public void testEmptyQueueInt() {
		
		Assert.assertEquals(true, queueInt.isEmpty());
		Assert.assertEquals(false, queueInt.isFull());
		
		try {
			queueInt.dequeue();
			fail("Nao deu erro");
		} catch (QueueUnderflowException e){
		}

		Assert.assertEquals(null, queueInt.head());
	}
	
	@Test
	public void testEnqDeqInt() throws Exception {
		queueInt.enqueue(1);
		Assert.assertEquals(new Integer(1), queueInt.head());
		queueInt.enqueue(2);
		Assert.assertEquals(new Integer(1), queueInt.head());
		queueInt.enqueue(3);
		Assert.assertEquals(new Integer(1), queueInt.head());
		
		Assert.assertEquals(false, queueInt.isEmpty());
		Assert.assertEquals(false, queueInt.isFull());
		
		queueInt.enqueue(4);
		Assert.assertEquals(new Integer(1), queueInt.head());
		queueInt.enqueue(5);
		Assert.assertEquals(new Integer(1), queueInt.head());
		
		Assert.assertEquals(false, queueInt.isEmpty());
		Assert.assertEquals(true, queueInt.isFull());
		
		try {
			queueInt.enqueue(6);
			fail("Nao deu erro");
		} catch (QueueOverflowException e){
		}
		
		queueInt.dequeue();
		Assert.assertEquals(new Integer(2), queueInt.head());
		queueInt.dequeue();
		Assert.assertEquals(new Integer(3), queueInt.head());
		queueInt.dequeue();
		Assert.assertEquals(new Integer(4), queueInt.head());
		queueInt.dequeue();
		Assert.assertEquals(new Integer(5), queueInt.head());
		
		Assert.assertEquals(false, queueInt.isEmpty());
		Assert.assertEquals(false, queueInt.isFull());
		
		queueInt.dequeue();
		Assert.assertEquals(null, queueInt.head());
		
		Assert.assertEquals(true, queueInt.isEmpty());
		Assert.assertEquals(false, queueInt.isFull());
		
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
