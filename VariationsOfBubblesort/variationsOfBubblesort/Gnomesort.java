package sorting.variationsOfBubblesort;

import sorting.SortingImpl;
import sorting.Util;

/**
 * The implementation of the algorithm must be in-place! 
 */
public class Gnomesort<T extends Comparable<T>> extends SortingImpl<T>{
	protected void sort(T[] array,int leftIndex, int rightIndex){

		if (leftIndex >= 0 && rightIndex > 0 && rightIndex < array.length
				&& leftIndex < rightIndex && array.length > 1) {
			
			int pos = 1;
			
			while (pos < (rightIndex - leftIndex +1)) {
				
				if (array[leftIndex + pos].compareTo(array[leftIndex + pos - 1]) >= 0){
					pos ++;
				} else {
					Util.swap(array, leftIndex + pos, leftIndex + pos -1);
					if (pos > 1)
						pos--;
					else
						pos++;
				}
			}
		}
	}
}
