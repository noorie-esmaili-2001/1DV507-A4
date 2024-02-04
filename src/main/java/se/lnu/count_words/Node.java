package se.lnu.count_words;

public class Node {

    Word word;
    Node next = null;

    public Node(Word word) {
        setWord(word);
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String toString() {
        return getWord().toString();
    }
}
