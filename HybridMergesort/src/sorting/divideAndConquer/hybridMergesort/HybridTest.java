package sorting.divideAndConquer.hybridMergesort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HybridTest {

	HybridMergesort<Integer> sort;

	@Before
	public void antes() {
		sort = new HybridMergesort<Integer>();
	}

	@Test
	public void test() {
		Integer[] esperado = {};
		Integer[] atual = {};

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);

		Assert.assertEquals(0, sort.INSERTIONSORT_APPLICATIONS);
		Assert.assertEquals(0, sort.MERGESORT_APPLICATIONS);
	}

	@Test
	public void testTamanho() {
		Integer[] atual = { -44, -43, -36, -31, -30, -27, -25, -24, -21, -20,
				-18, -15, -11, -8, -6, -5, -3, -2, 2, 5, 13, 16, 20, 30, 34,
				42, 45, 46, 48, 50 };
		Integer[] esperado = Arrays.copyOf(atual, atual.length);

		sort.sort(atual);
		Arrays.sort(atual);

		Assert.assertArrayEquals(esperado, atual);

		Assert.assertEquals(8, sort.INSERTIONSORT_APPLICATIONS);
		Assert.assertEquals(7, sort.MERGESORT_APPLICATIONS);
	}

	@Test
	public void testTamanhoPar() {
		Integer[] esperado = { 1, 3, 4, 5 };
		Integer[] atual = { 1, 5, 4, 3 };

		sort.sort(atual);

		Assert.assertArrayEquals(esperado, atual);
		Assert.assertEquals(1, sort.INSERTIONSORT_APPLICATIONS);
		Assert.assertEquals(0, sort.MERGESORT_APPLICATIONS);
	}

	@Test
	public void testTamanhoImpar() {
		Integer[] esperado = { 1, 2, 3, 4, 5 };
		Integer[] atual = { 4, 1, 5, 3, 2 };

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

}
