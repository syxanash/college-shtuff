package lab20141120;


public class Tester {
	public static void main(String[] args) {
		ArrayDict<String, Record> volume = new ArrayDict<String, Record>();
		
		AddOnlyList<String> authors = new DoubleLinkedList<String>();
		authors.add("Camil Demetrescu");
		authors.add("Umberto ferraro petrillo");
		Volume vol = new Volume("Mc graw hill", 2007, authors);
		Record rec = new Record(vol, false);
		
		volume.insert("Progettazione algoritmi java", rec);
		
		authors = new DoubleLinkedList<String>();
		authors.add("deitel & deitel");
		vol = new Volume("Pearson-Prentice Hall", 2008, authors);
		rec = new Record(vol, false);
		
		volume.insert("programmazione in java", rec);
		
		Biblioteca bib = new Biblioteca(volume);
		System.out.println(bib.posizione(rec));
	}
}
