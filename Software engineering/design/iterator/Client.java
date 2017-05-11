package patterns.design.iterator;

public class Client {
	public static void main(String[] args) {
		Container repo = new NameRepository();
		Iterator iter = repo.getIterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
