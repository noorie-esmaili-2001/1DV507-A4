package se.lnu.count_words;

import java.util.Iterator;

public class TreeWordSet implements WordSet {

    private class BST {

        private Word word;
        private BST left = null;
        private BST right = null;

        public BST(Word word) {
            setWord(word);
        }

        public Word getWord() {
            return word;
        }

        public void setWord(Word word) {
            this.word = word;
        }

        public BST getLeft() {
            return left;
        }

        public BST getRight() {
            return right;
        }

        private void add(Word word) {
            if (word.compareTo(getWord()) < 0) {
                if (getLeft() == null) {
                    this.left = new BST(word);
                    size++;
                } else
                    this.left.add(word);

            } else if (word.compareTo(getWord()) > 0) {
                if (getRight() == null) {
                    this.right = new BST(word);
                    size++;
                } else
                    this.right.add(word);

            }

        }

        private boolean contains(Word word) {
            if (word.compareTo(getWord()) < 0) {
                if (getLeft() == null)
                    return false;
                else {
                    return this.left.contains(word);
                }
            } else if (word.compareTo(getWord()) > 0) {
                if (getRight() == null) {
                    return false;
                } else {
                    return this.right.contains(word);
                }
            }
            return true;
        }

        private String print() {

            if (getLeft() != null) {
                this.left.print();
            }

            str.append(getWord()).append(" ");

            if (getRight() != null) {
                this.right.print();
            }

            return str.toString();
        }

        private void getWordArray() {
            if (getLeft() != null) {
                this.left.getWordArray();
            }

            if (cnt == arr.length) {
                resize();
            }
            arr[cnt] = getWord();
            cnt++;
            if (getRight() != null) {
                this.right.getWordArray();
            }

        }

    }

    private class TreeWordSetIterator implements Iterator<Word> {

        private int count = 0;

        public TreeWordSetIterator() {
            root.getWordArray();
        }

        @Override
        public boolean hasNext() {
            if (root == null) {
                return false;
            } else return getArr()[count] != null;
        }

        @Override
        public Word next() {
            return getArr()[count++];
        }
    }

    private BST root = null;
    private int size;
    private final StringBuilder str = new StringBuilder();
    private Word[] arr = new Word[8];
    private int cnt = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Word[] getArr() {
        return arr;
    }

    public TreeWordSet() {
        setSize(0);
    }

    @Override
    public Iterator<Word> iterator() {
        return new TreeWordSetIterator();
    }

    @Override
    public void add(Word word) {
        if (this.root == null) {
            this.root = new BST(word);
            this.size++;
        } else {
            this.root.add(word);

        }

    }

    @Override
    public boolean contains(Word word) {
        if (getSize() == 0) {
            return false;
        } else
            return this.root.contains(word);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (this.root != null) {
            return "[ " + this.root.print() + " ]";
        } else {
            return "[ ]";
        }

    }

    private void resize() {
        Word[] temp = new Word[getArr().length * 2];
        System.arraycopy(getArr(), 0, temp, 0, getArr().length);
        this.arr = temp;
    }
}