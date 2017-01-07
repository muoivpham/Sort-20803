package v3;

public class ShellSort<T extends Comparable<T>> implements ISortingAlgorithm<T> {

	// @Override
	// public Result sort(T[] nums) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	int moves = 0, comparations = 0;

	public void sort(T[] R, int n) {
		// Algorithm ShellSort(Table R[0 .. n-1], int h[0 .. t-1]); { //Sorts an
		// n element table, t, into ascending order.
		// Input: an array R that holds the records to be sorted,
		// an array h that holds the increments such that: h[0] = 1 and
		// h[i] > h[i-1].
		// Use Shell’s increments:
		// hi = n/2, hi-1 = hi/2, hi-2 = hi-1/2 ... h1 = 1
		// Example (for n = 900; h9 = 900/2 = 450, h8 = 450/2 = 225,
		// h7 =225/2=112,h6 =112/2=56,...,h1 =3/2=1
		// FirstInc returns the largest increment to be used when
		// sorting the table
		int j, i;
		T K, X;
		// inc = FirstInc(h)
		int inc = R.length / 2;
		int[] h = new int[inc];
		int m = 0;

		m = 1;
		while (inc >= 1) {
			for (i = inc; i <= (n - 1); i++) {
				j = i;
				K = R[i];
				X = R[i];
				//? 
				moves++;
				
				while ((j >= inc) && (R[j - inc].compareTo(K) > 0)) {
					R[j] = R[j - inc];
					j = j - inc;
					moves++;
					comparations++;
				}
				
				if (j >= inc)
					comparations++;
				
				R[j] = X;
				moves++;
			}
			// NextInc returns the next increment smaller than inc
			inc = NextInc(inc);
		}

	}

	private int NextInc(int inc) {
		// TODO Auto-generated method stub
		inc *= (5.0 / 11);
		return inc;
	}

	private int FirstInc(T[] h) {
		// TODO Auto-generated method stub
		int ans = h.length / 2;
		return ans;
	}

	@Override
	public Result getResult() {
		// TODO Auto-generated method stub
		return new Result(comparations, moves);
	}

}
