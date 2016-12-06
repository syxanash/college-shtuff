package lab20140415;

public class BagOfWords {
	protected Bag bagOfWords;
	protected int occurences;
	
	public BagOfWords() {
		bagOfWords = new Bag();
	}
	
	void addText(String txt) {
		String[] words = txt.split(" ");
		
		for(String e : words) {
			bagOfWords.addItem(e);
			occurences++;
		}
		
		for(String e : bagOfWords) {
			System.out.println(e + " " + bagOfWords.occurrences(e));
		}
		
		System.out.println(occurences);
	}
	
	float similiarita(BagOfWords bow) {
		float simil = 0;
		
		for (String word : bow.bagOfWords) {
			//TODO Completare
			
			simil += ((this.bagOfWords.occurrences(word) + 1) / (this.occurences + 2)) * 
					 ((bow.bagOfWords.occurrences(word) + 1) / (bow.occurences + 2));
		}
		
		return simil;
	}
}
