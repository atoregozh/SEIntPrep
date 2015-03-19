package adept;

import java.util.Arrays;
import java.util.Random;

public class InPlaceShuffle {
	/*
	 * Write a function to for doing an in-place (i.e. directly on its input and
	 * changing its input) shuffle of an array. 
	 * 
	 * Solution: Choose a random item
	 * to move to the first index, then choose a random OTHER item to move to
	 * the second index, etc.
	 * This algorithm is known as the Fisher-Yates shuffle 
	 * (sometimes called the Knuth shuffle). 
	 */

	public static int[] shuffle(int[] arr) {
		if(arr.length <= 1) {
			return arr;
		}
		
		// walk through from beginning to end
		for (int i = 0; i < arr.length; i++) {

			// choose a random not-yet-placed item to place there
			// (could also be the item currently in that spot)
			// must be an item AFTER the current item, because the stuff
			// before has all already been placed
			int randomIndexToSwap = getRandom(i, arr.length);

			// place our random choice in the spot by swapping
			int temp = arr[i];
			arr[i] = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = temp;
		}

		return arr;
	}

	public static int getRandom(int floor, int ceiling) {
		/*
		 * Helper function to get a random integer that is >=floor and
		 * <=ceiling.
		 */
		Random r = new Random();
		return r.nextInt(ceiling - floor) + floor;
	}

	public static void main(String[] args) {
		int[] arr = {1,4,2,8,126,5};
		int[] result = shuffle(arr);
		System.out.println(Arrays.toString(result));

	}

}
