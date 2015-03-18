package novice;

import java.util.Arrays;

public class MergeSortedArrays {
	/*
	 * Merge 2 sorted arrays into one sorted array
	 */
	public static int[] mergeArrays(int[] arrA, int[] arrB) {

		int indexA = 0, indexB = 0, indexAB = 0;
		int[] arrAB = new int[arrA.length + arrB.length];
		System.out.println("AB length is " + arrAB.length);
		System.out.println("A length is " + arrA.length);
		System.out.println("B length is " + arrB.length);
		while (indexAB < arrAB.length) {
			if (indexA < arrA.length && indexB < arrB.length) {
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
			if (indexA < arrA.length) {
				arrAB[indexAB] = arrA[indexA];
				indexA++;
				indexAB++;
				continue;
			}
			if (indexB < arrB.length) {
				arrAB[indexAB] = arrB[indexB];
				indexB++;
				indexAB++;
				continue;
			}
		}
		return arrAB;
	}

	public static void main(String[] args) {
		int[] arr1 = {1,2,5,6};
		int[] arr2 = {-2,-1,2};
		int [] result = mergeArrays(arr1, arr2);
		System.out.println(Arrays.toString(result));
	}
}
