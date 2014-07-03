package sorting.variationsOfBubblesort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CombTest {

	Combsort<Integer> sort;
	Combsort<String> sortString;

	@Before
	public void antes() {
		sort = new Combsort<Integer>();
		sortString = new Combsort<String>();
	}

	@Test
	public void test() {
		Integer[] atual = {05,02,04,01,03};
		Integer[] esperado = {01,02,03,04,05};

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
		Integer[] atual = { 1, 5, 4, 3 };
		Integer[] esperado = { 1, 3, 4, 5 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);

	}

	@Test
	public void testTamanhoImpar() {
		Integer[] atual = { 4, 1, 0, 3, 2 };
		Integer[] esperado = {0, 1, 2, 3, 4};

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}

	@Test
	public void testTodosIguais() {
		Integer[] atual = { 4, 4, 4, 4 };
		Integer[] esperado = { 4, 4, 4, 4 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testAlgunsIguais() {
		Integer[] atual = { 9, 4, 4, 2 };
		Integer[] esperado = { 2, 4, 4, 9 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}

	@Test
	public void testUmDiferente() {
		Integer[] atual = { 9, 9, 4, 9 };
		Integer[] esperado = { 4, 9, 9, 9 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testComZero() {
		Integer[] atual = { 4, 0, 0, 0};
		Integer[] esperado = { 0, 0, 0, 4 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testIndices() {
		Integer[] atual = {100,10};
		Integer[] esperado = {100,10};

		sort.sort(atual, -1, 0);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testComZeroIndex() {
		Integer[] atual = { 4, 0, 0, 0};
		Integer[] esperado = { 4, 0, 0, 0 };

		sort.sort(atual, 1, 2);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testComNegativo() {
		Integer[] atual = {0,10,-5,1,-2};
		Integer[] esperado = { -5,-2,0,1,10};

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testComNegativoIndice() {
		Integer[] atual = {0,10,-5,1,-2};
		Integer[] esperado = {-5,0,10,1,-2};

		sort.sort(atual,0,2);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testString() {
		String[] atual = {"bola", "elefante", "doce", "amor", "comida"};
		String[] esperado = {"amor", "bola", "comida", "doce", "elefante"};

		sortString.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testStringIndicePassando() {
		String[] atual = {"bola", "elefante", "doce", "amor", "comida"};
		String[] esperado = {"bola", "elefante", "doce", "amor", "comida"};

		sortString.sort(atual, 3, 6546454);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testStringIndice() {
		String[] atual = {"bola", "elefante", "doce", "amor", "comida"};
		String[] esperado = {"bola", "elefante", "doce", "amor", "comida"};

		sortString.sort(atual, 3, 4);

		Assert.assertArrayEquals(esperado, atual);
	}
	
	@Test
	public void testStringIndice2() {
		String[] atual = {"bola", "elefante", "doce", "amor", "comida"};
		String[] esperado = {"bola", "doce", "elefante", "amor", "comida"};

		sortString.sort(atual, 0, 2);

		Assert.assertArrayEquals(esperado, atual);
	}
	
}
