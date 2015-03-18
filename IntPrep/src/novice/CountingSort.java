package interview;
import java.util.Arrays;
/*
 Write a function that takes:
 1.  a list of unsorted_scores
 2.  the highest_possible_score in the game
 and returns a sorted list of scores in less than O(nlg(n)) time. 
 */
public class CountingSort {

	public static int[] countSort(int[] scores, int highestScore) {

		int[] scoresToCount = new int[highestScore + 1];
		for (int i = 0; i < scores.length; i++) {
			scoresToCount[scores[i]]++;
		}

		for (int i = 1; i <= highestScore; i++) { // do Cumulative Sum business
			scoresToCount[i] += scoresToCount[i - 1];
		}

		int[] sortedScores = new int[scores.length];
		for (int i = scores.length - 1; i >= 0; i--) {
			//More explicitly:
			int sortedIndex = scoresToCount[scores[i]];
			sortedScores[--sortedIndex] = scores[i];
			scoresToCount[scores[i]] = sortedIndex; //decrease count in scoreToCount
			//OR WITH 1 LINE:
			//sortedScores[--scoresToCount[scores[i]]] = scores[i];
		}
		return sortedScores;
	}

	public static void main(String[] args) {
		int[] test_input = { 1, 1, 2, 1, 3, 2, 3, 4, 5, 4, 3, 5, 4 };
		int[] result = countSort(test_input, 5);
		System.out.println(Arrays.toString(result));
	}

}
