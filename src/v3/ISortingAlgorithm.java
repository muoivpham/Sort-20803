package v3;

public interface ISortingAlgorithm<T extends Comparable<T>> {
	public void sort(T[] nums, int n);
	
	public Result getResult();
}
