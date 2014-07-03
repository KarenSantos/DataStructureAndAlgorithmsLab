package sorting.divideAndConquer.hybridMergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

import sorting.SortingImpl;

/**
 * The algorithm is an hybrid of mergesort and insertion sort. Depending on the
 * size of the input, the algorithm decides between the application of mergesort
 * or insertion sort. The implementation of the algorithm must be in-place!
 */
public class HybridMergesort<T extends Comparable<T>> extends SortingImpl<T> {
	/**
	 * The limit to choose between applying merge or insertion. For inputs with
	 * size less or equal to 4, apply insertion sort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	protected void sort(T[] array, int leftIndex, int rightIndex) {

		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		hybridSort(array, leftIndex, rightIndex);

	}

	private void hybridSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex >= 0 && rightIndex > 0 && rightIndex < array.length
				&& leftIndex < rightIndex && array.length > 1) {

			if (rightIndex - leftIndex + 1 <= 4) {
				insertionSort(array, leftIndex, rightIndex);
				INSERTIONSORT_APPLICATIONS++;

			} else {

				int half = (int) Math
						.ceil((double) (rightIndex - leftIndex) / 2);

				T[] leftArray = Arrays.copyOfRange(array, leftIndex, leftIndex
						+ half);
				T[] rightArray = Arrays.copyOfRange(array, leftIndex + half,
						rightIndex + 1);

				hybridSort(leftArray, 0, leftArray.length - 1);
				hybridSort(rightArray, 0, rightArray.length - 1);

				T[] result = merge(leftArray, rightArray);
				MERGESORT_APPLICATIONS++;
				insertResult(array, result, leftIndex);
			}
		}
	}

	private T[] merge(T[] left, T[] right) {

		T[] result = (T[]) Array.newInstance(left[0].getClass(), left.length
				+ right.length);

		int index = 0;
		while (left.length > 0 && right.length > 0) {

			if (left[0].compareTo(right[0]) <= 0) {
				Array.set(result, index, left[0]);
				left = Arrays.copyOfRange(left, 1, left.length);
			} else {
				Array.set(result, index, right[0]);
				right = Arrays.copyOfRange(right, 1, right.length);
			}
			index++;
		}
		while (left.length > 0) {
			Array.set(result, index, left[0]);
			left = Arrays.copyOfRange(left, 1, left.length);
			index++;
		}
		while (right.length > 0) {
			Array.set(result, index, right[0]);
			right = Arrays.copyOfRange(right, 1, right.length);
			index++;
		}
		return result;
	}

	private void insertResult(T[] arrayToModify, T[] arraySource, int index) {

		for (int i = 0; i < arraySource.length; i++) {
			Array.set(arrayToModify, index, arraySource[i]);
			index++;
		}
	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			T key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

}
