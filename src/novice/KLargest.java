package novice;
import java.util.Arrays;

// TODO: need to test for correctness
public class KLargest {
	
	/*
	 Given an input sequence of n integers, each of which has a value between
     1 and 100 (inclusive), write a function that outputs the sum of the k
     largest integers. 
     Solution: use counting sort procedure
     * What is the complexity of your algorithm? O(n) 
     * Do you think it is the best? yes, because need to check every element at least once
     * What if each value is between 1 and m, where m is a variable? This wouldn't impact the solution
	 */
	
	public static int returnMaxK(int[] arr, int k) {
		int[] arrToCount = new int[100];
		int sum=0;
		
		for(int i=0; i<arr.length; i++) {
			arrToCount[arr[i]]++;
		}
		
		for(int i=arrToCount.length; i>0 ; i--) {
			if(arrToCount[i]!=0) {
				for(int j=0;j<arrToCount[i];j++) {
					sum+=i;
					k--;
					
					if(k==0) {
						return sum;
					}
				}
			}
		}
		return sum;
		
	}
	
	public static void main(String[] args) {
		int[] test_input = { 1, 1, 2, 1, 3, 2, 3, 4, 5, 4, 3, 5, 4 };
		int result = returnMaxK(test_input, 3);
		System.out.println(result);
	}

}
