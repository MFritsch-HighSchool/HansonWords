
public class WordFreq implements Comparable<WordFreq> {

	static int sortType = 0; // 0 for alpha, 1 for length, 2 for freq
	private String name;
	int freq;
	
	public WordFreq(String s) {
		this(s,1);
	}
	public WordFreq(String s, int num) {
		name = s;
		freq = num;
	}
	@Override
	public String toString() {
		return name +"\t"+ freq;
	}
	public int compareAlpha(WordFreq other) {
		return this.name.compareTo(other.name);
	}
	
	@Override
	public int compareTo(WordFreq other) {
		if(sortType == 0) {
			return compareAlpha(other);
		}
		else if(sortType == 1) {
			return compareLength(other);
		}
		else if(sortType == 2) {
			return compareFreq(other);
		}

		return 0;
	}
	private int compareFreq(WordFreq other) {
		// TODO Auto-generated method stub
		
		return this.freq-other.freq;
	}
	private int compareLength(WordFreq other) {
		// TODO Auto-generated method stub
		return this.name.length() - other.name.length();
	}
	public void compareAlpha() {
		sortType = 0;
	}
	public void compareLength() {
		sortType = 1;
	}
	public void compareFreq() {
		sortType = 2;
	}
	public void increaseFreq() {
		this.freq++;
	}
}
