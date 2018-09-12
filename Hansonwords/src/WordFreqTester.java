
public class WordFreqTester {

	public static void main(String[] args) {
		WordFreq one = new WordFreq("hello"),
				 two = new WordFreq("hi",2);
		
	//	String contents = 5+one;
		System.out.println(one);
		System.out.println(two);

		comp(one,two);
		
		one.compareFreq();
		comp(one,two);
		
		one.increaseFreq();
		one.increaseFreq();
		one.compareLength();
		comp(one,two);
		
	}

	private static void comp(WordFreq one, WordFreq two) {
		if(one.compareTo(two)<0) {
			System.out.println(one + " is less than "+two);
		}
		else if(one.compareTo(two)>0) {
			System.out.println(two + " is less than "+one);
		}
		else {
			System.out.println(two + " is equal to "+one);
		}
	}

}
