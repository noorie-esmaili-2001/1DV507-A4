package se.lnu.count_words;

public class Word implements Comparable<Word> {
	private String word;

	public Word(String str) {
		setWord(str.toLowerCase()); // make all words equal
	}

	
	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String toString() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((getWord() == null) ? 0 : getWord().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Word other = (Word) obj;
		
		if (getWord() == null) {
            return other.getWord() == null;
		} else return getWord().equals(other.getWord());
    }

	public int compareTo(Word o) {
		return getWord().compareTo(o.getWord());
	}
}
