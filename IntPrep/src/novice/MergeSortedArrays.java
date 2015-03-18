package novice;

import java.util.Arrays;

public class MergeSortedArrays {
	/*
	 * Merge 2 sorted arrays into one sorted array
	 */
	public static int[] mergeArrays(int[] arrA, int[] arrB) {

		int indexA = 0, indexB = 0, indexAB = 0;
		int[] arrAB = new int[arrA.length + arrB.length];

		while (indexAB <= arrAB.length) {
			if (indexAB <= arrA.length && indexAB <= arrB.length) {
				if (arrA[indexA] >= arrB[indexB]) {
					arrAB[indexAB] = arrB[indexB];
					indexB++;
				} else {
					arrAB[indexAB] = arrA[indexA];
					indexA++;
				}
				indexAB++;
				continue;
			}
			if (indexAB <= arrA.length) {
				arrAB[indexAB] = arrA[indexA];
				indexA++;
				indexAB++;
				continue;
			}
			if (indexAB <= arrB.length) {
				arrAB[indexAB] = arrA[indexB];
				indexB++;
				indexAB++;
				continue;
			}
		}
		return arrAB;
	}

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {2,6,9};
		int [] result = mergeArrays(arr1, arr2);
		System.out.println(Arrays.toString(result));
	}
}
