package v3;

public class CocktailShakerSort<T extends Comparable<T>> implements ISortingAlgorithm<T> {
	int moves = 0, comparations = 0;
	@Override
	public void sort(T[] nums, int n) {
		boolean swapped;
		T temp;
		do {
			swapped = false;
			for (int i = 0; i <= n - 2; i++) {

				comparations++;
				if (nums[i].compareTo(nums[i + 1]) > 0) {
					// test whether the two elements are in the wrong order
					// swap(nums, i, i + 1);
					temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					swapped = true;
					moves = moves + 3;
				}
			}
			if (!swapped) {
				// we can exit the outer loop here if no swaps occurred.
				break;
			}
			swapped = false;
			for (int i = n - 2; i >= 0; i--) {

				comparations++;
				if (nums[i].compareTo(nums[i + 1]) > 0) {
					// swap(nums, i, i + 1);
					temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					swapped = true;
					moves = moves + 3;
				}
			}
			// if no elements have been swapped, then the list is sorted
		} while (swapped);
	}

	@Override
	public Result getResult() {
		// TODO Auto-generated method stub
		return new Result(comparations, moves);
	}

}
