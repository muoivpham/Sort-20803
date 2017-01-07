package v3;

import java.io.File;
import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		String[] lines = { "15", "19", "34", "41", "27", "13", "9", "11", "44" };

		Model model = new Model();
		String[] keys = model.loadFile(new File("Ascending.dat"));
		System.out.println(Arrays.toString(keys));

		ISortingAlgorithm<String> sorter2 = new CocktailShakerSort<String>();
		sorter2.sort(keys, 5000);
		System.out.println(Arrays.toString(keys));
		System.out.println(sorter2.getResult().toString());

	}
}
