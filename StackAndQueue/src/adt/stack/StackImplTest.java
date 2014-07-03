package adt.stack;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackImplTest {
	
	StackImpl<Integer> stackInt;
	StackImpl<String> stackString;
	
	@Before
	public void antes(){
		stackInt = new StackImpl<Integer>(5);
		stackString = new StackImpl<String>(4);
	}

	@Test
	public void testEmptyStackInt() {
		
		Assert.assertEquals(true, stackInt.isEmpty());
		Assert.assertEquals(false, stackInt.isFull());
		
		try {
			stackInt.pop();
			fail("Nao deu erro");
		} catch (StackUnderflowException e){
		}

		Assert.assertEquals(null, stackInt.top());
	}
	
	@Test
	public void testPushPopInt() throws Exception {
		stackInt.push(1);
		Assert.assertEquals(new Integer(1), stackInt.top());
		stackInt.push(2);
		Assert.assertEquals(new Integer(2), stackInt.top());
		stackInt.push(3);
		Assert.assertEquals(new Integer(3), stackInt.top());
		
		Assert.assertEquals(false, stackInt.isEmpty());
		Assert.assertEquals(false, stackInt.isFull());
		
		stackInt.push(4);
		Assert.assertEquals(new Integer(4), stackInt.top());
		stackInt.push(5);
		Assert.assertEquals(new Integer(5), stackInt.top());
		
		Assert.assertEquals(false, stackInt.isEmpty());
		Assert.assertEquals(true, stackInt.isFull());
		
		try {
			stackInt.push(6);
			fail("Nao deu erro");
		} catch (StackOverflowException e){
		}
		
		stackInt.pop();
		Assert.assertEquals(new Integer(4), stackInt.top());
		stackInt.pop();
		Assert.assertEquals(new Integer(3), stackInt.top());
		stackInt.pop();
		Assert.assertEquals(new Integer(2), stackInt.top());
		stackInt.pop();
		Assert.assertEquals(new Integer(1), stackInt.top());
		
		Assert.assertEquals(false, stackInt.isEmpty());
		Assert.assertEquals(false, stackInt.isFull());
		
		stackInt.pop();
		Assert.assertEquals(null, stackInt.top());
		
		Assert.assertEquals(true, stackInt.isEmpty());
		Assert.assertEquals(false, stackInt.isFull());
		
	}
	
	@Test
	public void testEmptyStackString() {
		
		Assert.assertEquals(true, stackString.isEmpty());
		Assert.assertEquals(false, stackString.isFull());
		
		try {
			stackString.pop();
			fail("Nao deu erro");
		} catch (StackUnderflowException e){
		}

		Assert.assertEquals(null, stackString.top());
	}
	
	@Test
	public void testPushPopString() throws Exception {
		stackString.push("Um");
		Assert.assertEquals("Um", stackString.top());
		stackString.push("Dois");
		Assert.assertEquals("Dois", stackString.top());
		stackString.push("Tres");
		Assert.assertEquals("Tres", stackString.top());
		
		Assert.assertEquals(false, stackString.isEmpty());
		Assert.assertEquals(false, stackString.isFull());
		
		stackString.push("Quatro");
		Assert.assertEquals("Quatro", stackString.top());
				
		Assert.assertEquals(false, stackString.isEmpty());
		Assert.assertEquals(true, stackString.isFull());
		
		try {
			stackString.push("Cinco");
			fail("Nao deu erro");
		} catch (StackOverflowException e){
		}
		
		stackString.pop();
		Assert.assertEquals("Tres", stackString.top());
		stackString.pop();
		Assert.assertEquals("Dois", stackString.top());
		stackString.pop();
		Assert.assertEquals("Um", stackString.top());
		
		Assert.assertEquals(false, stackString.isEmpty());
		Assert.assertEquals(false, stackString.isFull());
		
		stackString.pop();
		Assert.assertEquals(null, stackString.top());
		
		Assert.assertEquals(true, stackString.isEmpty());
		Assert.assertEquals(false, stackString.isFull());
		
	}

}
