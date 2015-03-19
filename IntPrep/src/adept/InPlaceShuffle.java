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
    //TESTING
	public static void main(String[] args) {
		int[] arr = {1,4,2,8,126,5};
		System.out.println(Arrays.toString(arr));
		int[] result = shuffle(arr);
		System.out.println(Arrays.toString(result));

	}

	/*
	 How NOT to solve a problem: A common first idea is to walk through 
	 the array and swap each element with a random other element. 
	 However, this does not give a random distribution.
	 Why? Suppose our array had 3 elements: [a,b,c].
	 This means it'll make 3 calls to getRandom(0,2). That's 3 random choices, 
	 each with 3 possibilities. So our total number of possible sets of choices 
	 is 3∗3∗3=27. Each of these 27 sets of choices is equally probable. 
	 But how many possible outcomes do we have? The answer is 3!, which is 6.
	 But our function has 27 equally-probable sets of choices. 27 is not evenly 
	 divisible by 6. So some of our 6 possible outcomes will be achievable with 
	 more sets of choices than others. 
	 */
}
