package sorting.linearSorting;

import java.lang.reflect.Array;

import sorting.SortingImpl;

public class Countingsort extends SortingImpl<Integer> {

	@Override
	protected void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex > 0 && rightIndex < array.length
				&& leftIndex < rightIndex && array.length > 1) {

			int k = 0;
			for (int i = leftIndex; i <= rightIndex; i++){
				if (array[i] > k) k = array[i];
			}
			k += 1;
			
			Integer[] c = new Integer[k];
			
			Integer[] result = new Integer[rightIndex-leftIndex +1];
						
			for (int i = 0; i < k; i++) {
				c[i] = 0;
			}
			for (int j = leftIndex; j <= rightIndex; j++) {
				c[array[j]] = c[array[j]] + 1;
			}
			for (int i = 1; i < k; i++) {
				c[i] = c[i] + c[i - 1];
			}
			for (int j = rightIndex; j >= leftIndex; j--) {
				c[array[j]] = c[array[j]] - 1;
				result[c[array[j]]] = array[j];
			}
			
			insertResult(array, result, leftIndex);
			
		}

	}
	
	private void insertResult(Integer[] arrayToModify, Integer[] arraySource, int index) {

		for (int i = 0; i < arraySource.length; i++) {
			Array.set(arrayToModify, index, arraySource[i]);
			index++;
		}
	}
	
}
