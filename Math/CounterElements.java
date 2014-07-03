package leda.aula4;

import java.util.ArrayList;
import java.util.List;

public class CounterElements {

	public static void main(String[] args) {

		String[] s = new String[] { "karen", null, "Andre", null};

		System.out.println(countNotNullElements(s));

	}

	private static <T> int countNotNullElements(T[] array) {
		return count(array, array.length - 1);
	}

	private static <T> int count(T[] array, int index) {
		if (index >= 0) {
			if (array[index] != null) {
				return 1 + count(array, index -1);
			} else {
				return count(array, index - 1);
			}
		}
		return 0;
	}

}
