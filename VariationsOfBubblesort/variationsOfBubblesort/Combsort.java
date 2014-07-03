package sorting.variationsOfBubblesort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The combsort algoritm.
 */
public class Combsort<T extends Comparable<T>> extends SortingImpl<T> {
	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex > 0 && rightIndex < array.length
				&& leftIndex < rightIndex && array.length > 1) {

			double fator = 1.25;
			int size = rightIndex - leftIndex + 1;
			int gap = size;

			boolean swaps = true;
			while (gap != 1 || swaps) {

				gap = (int) (gap / fator);
				if (gap < 1)
					gap = 1;

				int i = 0;
				swaps = false;
				while (i + gap < size) {

					if (array[leftIndex + i].compareTo(array[leftIndex + i + gap]) > 0) {
						Util.swap(array, leftIndex + i, leftIndex + i + gap);
						swaps = true;
					}
					i++;
				}
			}
		}
	}
}