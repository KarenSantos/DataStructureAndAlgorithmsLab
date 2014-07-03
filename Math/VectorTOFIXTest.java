package leda.aula4;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class VectorTOFIXTest {
	
	private VectorTOFIX<Integer> vector1;

	@Before
	public void setUp() throws Exception {
		vector1 = new VectorTOFIX<Integer>(20, 10);
	}

	@Test
	public void constructorTest() {
		Assert.assertEquals("capacidade inicial errada", 20, vector1.size());
		VectorTOFIX<Integer> vector3 = new VectorTOFIX<>(0, 0);
		try { 
			VectorTOFIX<Integer> vector2 = new VectorTOFIX<>(-1, 0);
			fail("Deveria ter lancado excecao");
		} catch (Exception e){
			Assert.assertEquals("mensagem errada", "Illegal Capacity: -1", e.getMessage());
		}
	}
	
	

}
