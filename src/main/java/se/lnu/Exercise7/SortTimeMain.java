package se.lnu.Exercise7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortTimeMain {
	static int numRuns = 5;
	static int intArrayRange = 9000;
	static int stringArrayRange = 10;
	static int timeToMeasure = 1;

	private static void insertionSort(int[] in) {

		if (in.length < 2) {
			return;
		}

		int[] sortedInt = Arrays.copyOf(in, in.length);

		for (int i = 1; i < in.length; i++) {

			int pos = i;

			while (pos > 0 && sortedInt[pos] < sortedInt[pos - 1]) {

				int temp = sortedInt[pos];
				sortedInt[pos] = sortedInt[pos - 1];
				sortedInt[pos - 1] = temp;

				pos--;
			}
		}

	}

	private static void insertionSort(String[] in, Comparator<String> c) {

		if (in.length < 2) {
			return;
		}

		String[] sortedStrings = Arrays.copyOf(in, in.length);

		for (int i = 1; i < in.length; i++) {

			int pos = i;

			while (pos > 0 && c.compare(sortedStrings[pos], sortedStrings[pos - 1]) < 0) {
				String temp = sortedStrings[pos];
				sortedStrings[pos] = sortedStrings[pos - 1];
				sortedStrings[pos - 1] = temp;

				pos--;
			}
		}

	}

	private static String randomString(int size) throws IllegalArgumentException {
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		Random randToFill = new Random();
		StringBuilder randStr = new StringBuilder();
		for (int i = 0; i < size; i++) {
			randStr.append((char) (randToFill.nextInt(26) + 'a'));
		}
		return randStr.toString();
	}

	private static int[] randomIntArray(int size, int range) throws IllegalArgumentException {
		if (size < 0 || range <= 0) {
			throw new IllegalArgumentException();
		}

		int[] array = new int[size];
		Random rand = new Random();

		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(range);
		}

		return array;
	}

	private static String[] randomStringArray(int size, int stringSize) throws IllegalArgumentException {
		if (size < 0 || stringSize <= 0) {
			throw new IllegalArgumentException();
		}

		String[] array = new String[size];

		for (int i = 0; i < size; i++) {
			array[i] = randomString(stringSize);
		}

		return array;
	}

	private static long insertionSortMeasureTime(int[] arr) {
		long before;
		long after;
		before = System.currentTimeMillis();
		insertionSort(arr); // Bad practice, etc
		after = System.currentTimeMillis();

		return after - before;
	}

	private static long insertionSortMeasureTime(String[] arr) {
		long before;
		long after;
		before = System.currentTimeMillis();
		insertionSort(arr, String::compareTo);
		after = System.currentTimeMillis();

		return after - before;
	}

	public static void main(String[] args) {
		double[] results = new double[4];
		int[] intArr;
		String[] strArr;

		for (int i = 0; i < numRuns; i++) {
			long time;
			int count = 100;

			do {
				intArr = randomIntArray(count, intArrayRange);
				time = insertionSortMeasureTime(intArr);

				if (time > timeToMeasure * 1000L) {
					count = count / 2;
				}

				else {
					count = count + count / 2;
				}

			} while (time < timeToMeasure * 975L || time > timeToMeasure * 1025L);

			System.out.println("New int array, size: " + intArr.length + " time to sort: " + time / 1000.0);

			results[0] = results[0] + intArr.length;
			results[1] = results[1] + time / 1000.0;

			count = 100;

			do {
				strArr = randomStringArray(count, stringArrayRange);
				time = insertionSortMeasureTime(strArr);

				if (time > timeToMeasure * 1000L) {
					count = count / 2;
				}

				else {
					count = count + count / 2;
				}

			} while (time < timeToMeasure * 975L || time > timeToMeasure * 1025L);

			System.out.println("New str array, size: " + strArr.length + " time to sort: " + time / 1000.0);

			results[2] = results[2] + strArr.length;
			results[3] = results[3] + time / 1000.0;
		}

		for (int i = 0; i < results.length; i++) {
			results[i] = results[i] / numRuns;
		}

	}
}