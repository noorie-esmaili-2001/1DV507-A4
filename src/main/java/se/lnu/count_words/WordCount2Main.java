package se.lnu.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount2Main {

    public static void main(String[] args) {

        Scanner sc;
        HashWordSet hash = new HashWordSet();
        TreeWordSet tree = new TreeWordSet();
        String read;
        String path = "src/main/resources/HistoryOfProgramming.txt";

        try {
            File file = new File(path);
            sc = new Scanner(file);
            while (sc.hasNext()) {
                read = sc.next();
                Word word = new Word(read.replaceAll("[^A-Za-z\\a]", ""));
                tree.add(word);
                hash.add(word);
            }
            sc.close();

            System.out.println("Tree size: " + tree.size());
            System.out.println("Hash size: " + hash.size() + "\n");

            Word hashWord = new Word("History");
            Word treeWord = new Word("History");

            System.out.println("Hash set contains \"" + hashWord + "\"" + ": " + hash.contains(hashWord));
            System.out.println("Tree set contains \"" + treeWord + "\"" + ": " + tree.contains(treeWord) + "\n");

            System.out.println("Iterator: ");

            int count = 1;

            for (Word word : tree) System.out.println(count++ + ":  " + word);

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}