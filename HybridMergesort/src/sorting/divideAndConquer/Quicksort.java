/**
 * 
 */
package sorting.divideAndConquer;

import sorting.SortingImpl;
import sorting.Util;

public class Quicksort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex > 0 && rightIndex < array.length
				&& leftIndex < rightIndex) {
			int m = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, m - 1);
			sort(array, m + 1, rightIndex);
		}
	}

	private int partition(T[] array, int left, int right) {

		int i = left + 1;
		int j = right;
		T pivot = array[left];

		while (i <= j) {
			if (array[i].compareTo(pivot) <= 0) {
				i++;
			} else if (array[j].compareTo(pivot) > 0) {
				j--;
			} else {
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, left, j);
		return j;
	}
	
}
