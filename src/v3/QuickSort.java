package v3;

import java.util.Arrays;
import java.util.Iterator;

public class QuickSort<T extends Comparable<T>> implements ISortingAlgorithm<T> {

	@Override
	public void sort(T[] nums, int n) {
		// TODO Auto-generated method stub
		sort(nums, 0, n - 1);
	}

	private int comparations = 0, moves = 0;

	private void sort(T[] t, int left, int right) {
		// { //Sorts an n element table (t[left], ... t[right]) into
		// ascending order. The initial invocation is as:
		// QuickSort(t, 0, (n-1))
		int i, j;
		T pivot;
		T temp;
		if (left < right) {
			// i is used to scan from the left to find elements >=
			// the pivot key
			i = left;
			// j is used to scan from the right to find elements <=
			// the pivot key
			j = right + 1;
			// set the pivot element
			pivot = t[left];
			moves++;

			while (i < j) {
				i = i + 1;
				while ((i <= right) && (t[i].compareTo(pivot) < 0)) {
					i = i + 1;
					comparations++;
				}
				j = j - 1;
				while ((j >= left) && (t[j].compareTo(pivot) > 0)) {
					j = j - 1;
					comparations++;
				}
				if (i <= j) {
					temp = t[i];
					t[i] = t[j];
					t[j] = temp;
					moves = moves + 3;
				}
			}
			// move the pivot element into its proper position
			// t[j] <==> t[left]
			temp = t[j];
			t[j] = t[left];
			t[left] = temp;
			moves = moves + 3;
			sort(t, left, j - 1); // QuickSort low order partition
			sort(t, j + 1, right);// QuickSort high order partition
		}

	}

	@Override
	public Result getResult() {
		// TODO Auto-generated method stub
		return new Result(comparations, moves);
	}

}