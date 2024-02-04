package se.lnu.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {

	private int size;
	private Node[] nodes = new Node[5];

	
	public HashWordSet() {
		size = 0;
	}

	@Override
	public void add(Word word) {
		int pos = getNumber(word);
		Node node = nodes[pos];
		while (node != null) {
			if (node.word.equals(word)) {
				return;
			} else
				node = node.next;
		}

		node = new Node(word);
		node.next = nodes[pos];
		nodes[pos] = node;
		size++;
		if (size == nodes.length) {
			reHash();
		}
	}

	private void reHash() {
		Node[] temp = nodes;
		nodes = new Node[2 * temp.length];
		size = 0;
		for (Node n : temp) {
			if (n == null) {
				continue;
			}
			while (n != null) {
				add(n.word);
				n = n.next;
			}
		}

	}

	private int getNumber(Word word) {
		int hash = word.hashCode();
		if (hash < 0) {
			hash = -hash;
		}
		return hash % nodes.length;
	}

	@Override
	public boolean contains(Word word) {
		int pos = getNumber(word);
		Node node = nodes[pos];
		while (node != null) {
			if (node.word.equals(word))
				return true;
			else
				node = node.next;
		}

		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
        for (Node value : nodes) {
            Node node = value;
            while (node != null) {
                str.append(node.word).append(" ");
                node = node.next;
            }
        }
		str.append(" ]");
		return str.toString();
	}

	@Override
	public Iterator<Word> iterator() {
		return new HashWordSetIterator();
	}

	private class HashWordSetIterator implements Iterator<Word> {

		private int count = 0;
		private Node node = null;

		@Override
		public boolean hasNext() {
			if (node != null && node.next != null) {
				return true;
			}

			for (int i = count; i < nodes.length; i++) {
				if (nodes[i] != null) {
					return true;
				}
			}
			return false;
		}

		@Override
		public Word next() {
			if (node != null && node.next != null) {
				node = node.next;
			} else {
				do {
					if (count == nodes.length) {
						throw new NoSuchElementException();
					}
					node = nodes[count++];
				} while (node == null);
			}
			return node.word;

		}

	}

}