package v3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {

	public Result result;
	public String[] keys = new String[5000];

	public String[] loadFile(File fileName) {
		Scanner scan;
		int n = 0;
		try {
			scan = new Scanner(fileName);
			while (scan.hasNext()) {
				keys[n] = scan.nextLine();
				n++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return keys;
	}

	public void bubleSort(int num) {
		ISortingAlgorithm<String> sorter = new BubleSort<String>();
		String[] str = new String[5000];

		for (int i = 0; i < str.length; i++) {
			str[i] = keys[i];
		}
		sorter.sort(str, num);
		result = sorter.getResult();
	}

	public void shellSort(int num) {
		ISortingAlgorithm<String> sorter = new ShellSort<String>();
		String[] str = new String[5000];

		for (int i = 0; i < str.length; i++) {
			str[i] = keys[i];
		}
		sorter.sort(str, num);
		result = sorter.getResult();
	}

	public void quickSort(int num) {
		ISortingAlgorithm<String> sorter = new QuickSort<String>();
		String[] str = new String[5000];

		for (int i = 0; i < str.length; i++) {
			str[i] = keys[i];
		}
		sorter.sort(str, num);
		result = sorter.getResult();
	}

	public void Cocktail(int num) {
		ISortingAlgorithm<String> sorter = new CocktailShakerSort<String>();
		String[] str = new String[5000];

		for (int i = 0; i < str.length; i++) {
			str[i] = keys[i];
		}
		sorter.sort(str, num);
		result = sorter.getResult();
	}

	public String displayMoves() {
		return String.valueOf(result.getMoves());
	}

	public String displayComparations() {
		return String.valueOf(result.getComparations());
	}

}
