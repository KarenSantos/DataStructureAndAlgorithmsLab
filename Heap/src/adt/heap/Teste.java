package adt.heap;

import java.util.Arrays;

public class Teste {
	
	public static void main(String[] args) {
		
		MinHeapImpl<Integer> heap = new MinHeapImpl<Integer>();
		
		Integer[] array = new Integer[] {2,7,4,9,1,5,3};
		heap.buildHeap(array);
		
		Integer[] array2 = heap.heapsort(array);
		
		System.out.println(Arrays.toString(array2));
		
	}

}
