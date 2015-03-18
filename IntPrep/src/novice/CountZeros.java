package novice;

public class CountZeros {
	//given a sorted array of 0's and 1's, find the number of 0's. Write recursive & iterative versions
	
	public static int countZerosRecursive(int[] array, int start, int end) {
		//base case realized after the fact
		if(start>end) {
			return 0;
		}
		//base case
		if(start==end) {
			if(array[start]==0) {
				return 1;
			} else {
				return 0;
			}
		}
		
		int mid = start + (end-start)/2; //bit shift way: (start+end) >> 1;
		if(array[mid]==0) {
			return mid + countZerosRecursive(array,mid+1,end);
		} else {
			return countZerosRecursive(array,start, mid-1);
		}
		
	}
	
	public static int countZerosIterative(int[] array, int start, int end) {
		int mid;
		while (start < end) {
			mid = start + (end - start) / 2;
			if (array[mid] == 0) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}//finish while

		if (array[start] == 0) {
			return start;
		} else {
			return start - 1;
		}

	}
	
	public static void main(String[] args) {
		int[] arr_test = {0,0,0,1,1};
		int result1 = countZerosRecursive(arr_test,0,4);
		System.out.println(result1);
		int result2 = countZerosIterative(arr_test,0,4);
		System.out.println(result2);
	}

}
