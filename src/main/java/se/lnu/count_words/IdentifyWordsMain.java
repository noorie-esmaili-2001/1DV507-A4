package se.lnu.count_words;

import java.io.*;

public class IdentifyWordsMain {
	public static String removeNonAlpha(String files) throws IOException {
		String removeVal = "[^a-zA-Z\\s]";
		StringBuilder txt = new StringBuilder();
		FileReader fileReader;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(files);
			br = new BufferedReader(fileReader);
			String line;

			while ((line = br.readLine()) != null) {
				String result = line.replaceAll(removeVal, "");
				txt.append(result).append("\n");
			}

		} catch (FileNotFoundException e) {
			System.out.println("Unable to find file: " + e.getMessage());
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return txt.toString();

	}

	public static void main(String[] args) throws IOException {
		System.out.println(removeNonAlpha("C:\\Users\\noori\\OneDrive\\Skrivbord\\HistoryOfProgramming.txt"));
	}

}