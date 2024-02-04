package se.lnu.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {

    public static void main(String[] args) {

        Scanner sc;
        HashSet<Word> hash = new HashSet<>();
        TreeSet<Word> tree = new TreeSet<>();
        String path = "src/main/resources/HistoryOfProgramming.txt";
        try {
            File file = new File(path);
            sc = new Scanner(file);

            while (sc.hasNext()) {
                String read = sc.next();
                read = read.replaceAll("[^A-Za-z\\s]", "").trim();
                String[] arr = read.split(" ");
                for (String w : arr) {
                    tree.add(new Word(w));
                    hash.add(new Word(w));
                }
            }
            sc.close();
            System.out.println("Tree size: " + tree.size());
            System.out.println("Hash size: " + hash.size() + "\n");

            int count = 1;
            for (Word itr : tree) {
                System.out.println(count++ + ": " + itr);
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }

}