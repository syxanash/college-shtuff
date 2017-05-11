package lab20120403;


public class BagOfWords {
	protected Bag bagOfWords;
	protected int occurences;
	
	public BagOfWords() {
		bagOfWords = new Bag();
		occurences = 0;
	}
	
	public void addText(String text) {
		String[] words = text.split(" ");
		
		for (String w : words) {
			bagOfWords.addItem(w);
			occurences++;
		}
	}
	
	//TODO similarità function
	// vedere lab20140415
}
