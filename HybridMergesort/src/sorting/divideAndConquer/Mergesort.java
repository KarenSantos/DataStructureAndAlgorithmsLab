package sorting.divideAndConquer;

import java.lang.reflect.Array;
import java.util.Arrays;

import sorting.SortingImpl;

public class Mergesort<T extends Comparable<T>> extends SortingImpl<T> {

	@Override
	protected void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= 0 && rightIndex > 0 && rightIndex < array.length
				&& leftIndex < rightIndex && array.length > 1) {

			int half = (int)Math.ceil((double)(rightIndex - leftIndex) / 2);
			
			T[] leftArray = Arrays.copyOfRange(array, leftIndex, leftIndex + half);
			T[] rightArray = Arrays.copyOfRange(array, leftIndex + half, rightIndex + 1);

			sort(leftArray, 0, leftArray.length - 1);
			sort(rightArray, 0, rightArray.length - 1);
			
			T[] result = merge(leftArray, rightArray);
			insertResult(array, result, leftIndex);
		}

	}

	private T[] merge(T[] left, T[] right) {

		T[] result = (T[]) Array.newInstance(left[0].getClass(), left.length + right.length);

		int index = 0;
		while (left.length > 0 && right.length > 0) {
			
			if (left[0].compareTo(right[0]) <= 0) {
				Array.set(result, index, left[0]);
				left = Arrays.copyOfRange(left, 1, left.length);
			} else {
				Array.set(result, index, right[0]);
				right = Arrays.copyOfRange(right, 1, right.length);
			}
			index ++;
		}
		while (left.length > 0) {
			Array.set(result, index, left[0]);
			left = Arrays.copyOfRange(left, 1, left.length);
			index++;
		}
		while (right.length > 0){
			Array.set(result, index, right[0]);
			right = Arrays.copyOfRange(right, 1, right.length);
			index++;
		}
		return result;
	}
	
	private void insertResult(T[] arrayToModify, T[] arraySource, int index){
		
		for (int i = 0; i < arraySource.length; i++) {
			Array.set(arrayToModify, index, arraySource[i]);
			index++;
		}
	}
	
}
