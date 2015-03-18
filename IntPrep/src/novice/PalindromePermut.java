package interview;

import java.util.Map;
import java.util.HashMap;

/*Write an efficient function
 that checks whether any 
 permutation of an input string 
 is a palindrome
 */

public class PalindromePermut {

	public static boolean isPalindromPermut(String str) {
		Map<Character, Boolean> parityMap = new HashMap<Character, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (parityMap.containsKey(c)) {
				parityMap.put(c, false); // even
			} else {
				parityMap.put(c, true); // odd
			}
		}

		boolean oddSeen = false;

		for (Character key : parityMap.keySet()) {
			if (parityMap.get(key)) { // seen odd
				if (oddSeen) {
					return false;
				} else {
					oddSeen = true;
				}
			}
		}
		return true;
	}

	// TESTING
	public static void main(String[] args) {
		System.out.println(isPalindromPermut("civic"));
		System.out.println(isPalindromPermut("ivicc"));
		System.out.println(isPalindromPermut("civil"));
		System.out.println(isPalindromPermut("livci"));

	}
}
