package sorting.variationsOfBubblesort;

import java.util.Arrays;

import sorting.SortingImpl;
import sorting.Util;

/**
 * This bubblesort variation pushes the greatest element to the right and (walking from left to right), 
 * after that, it pushes the smallest element to the left (walking from right to left). This happens 
 * in a same iteration. The following iterations do the same until the array is completely ordered. 
 * The algorithm must sort the elements from leftIndex to rightIndex (inclusive).  
 */
public class BidirectionalBubblesort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array,int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex > 0 && rightIndex < array.length
				&& leftIndex < rightIndex) {

			int limit = 0;
			for (int i = leftIndex; i <= rightIndex/2; i++) {
				for (int j = leftIndex + limit; j < rightIndex - limit; j++) {
					if (array[j].compareTo(array[j + 1]) > 0) {
						Util.swap(array, j, j + 1);
					}
				}
				for (int a = rightIndex - limit; a > leftIndex + limit; a--){
					if (array[a].compareTo(array[a - 1]) < 0) {
						Util.swap(array, a, a - 1);
					}
				}
				limit++;
			}
		}
	}

}
