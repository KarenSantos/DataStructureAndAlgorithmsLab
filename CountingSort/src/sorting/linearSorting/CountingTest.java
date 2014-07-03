package sorting.linearSorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountingTest {

	Countingsort sort;

	@Before
	public void antes() {
		sort = new Countingsort();
	}

	@Test
	public void test() {
		Integer[] esperado = {1,2,3,4,5};
		Integer[] atual = {5,2,4,1,3};

		sort.sort(atual, 0, 4);

		Assert.assertArrayEquals(esperado, atual);

	}

	@Test
	public void testTamanho() {
		Integer[] atual = {20,41,8,56,10,7,33,45,62,10,13,17,25,19};
		Integer[] esperado = {7,8,10,10,13,17,19,20,25,33,41,45,56,62};

		sort.sort(atual,0,13);

		Assert.assertArrayEquals(esperado, atual);

	}

	@Test
	public void testIndex() {
		Integer[] atual = {20,41,8,56,10,7,33,45,62,10,13,17,25,19};
		Integer[] esperado = {20,41,8,56,10,7,10,13,33,45,62,17,25,19};

		sort.sort(atual,5,10);

		Assert.assertArrayEquals(esperado, atual);

	}
	
	@Test
	public void testTamanhoPar() {
		Integer[] esperado = { 1, 3, 4, 5 };
		Integer[] atual = { 1, 5, 4, 3 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);

	}

	@Test
	public void testTamanhoImpar() {
		Integer[] esperado = {0, 1, 2, 3, 4};
		Integer[] atual = { 4, 1, 0, 3, 2 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}

	@Test
	public void testTodosIguais() {
		Integer[] esperado = { 4, 4, 4, 4 };
		Integer[] atual = { 4, 4, 4, 4 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testAlgunsIguais() {
		Integer[] esperado = { 2, 4, 4, 9 };
		Integer[] atual = { 9, 4, 4, 2 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}

	@Test
	public void testUmDiferente() {
		Integer[] esperado = { 4, 9, 9, 9 };
		Integer[] atual = { 9, 9, 4, 9 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testComZero() {
		Integer[] esperado = { 0, 0, 0, 4 };
		Integer[] atual = { 4, 0, 0, 0};

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testNumerosAltos() {
		Integer[] esperado = {10, 100};
		Integer[] atual = {100,10};

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testComZeroIndex() {
		Integer[] esperado = { 4, 0, 0, 0 };
		Integer[] atual = { 4, 0, 0, 0};

		sort.sort(atual, 1, 2);

		Assert.assertArrayEquals(esperado, atual);
	}
	
}
