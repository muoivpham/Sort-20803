package v3;

import java.util.Iterator;

public class BubleSort<T extends Comparable<T>> implements ISortingAlgorithm<T> {

	int moves = 0;
	int comparations = 0;
	@Override
	public void sort(T[] nums, int n) {
		// TODO Auto-generated method stub
		// Sorts an n element table, t, into ascending order
		boolean valuesWereInterchanged = true;
		int passCount = 1;
		int j;
		
		T temp;
		// loop controls the number of passes
		while ((passCount <= (n - 1)) & (valuesWereInterchanged)) {
			valuesWereInterchanged = false; // initiallynointerchanges // the
											// inner loop governs each
											// individual pass

			for (j = 0; j <= ((n - 1) - passCount); j++) {
				
				comparations++;
				if (nums[j].compareTo(nums[j + 1]) > 0) { 
					// elements out of  order
					valuesWereInterchanged = true;
					
					// exchange the entire record, not just the key
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					//swap count 
					moves = moves + 3;
				}
			}
			passCount = passCount + 1;
		}

		
	}
	@Override
	public Result getResult() {
		// TODO Auto-generated method stub
		return new Result(comparations, moves);
	}

}
