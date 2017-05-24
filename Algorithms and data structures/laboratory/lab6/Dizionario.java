package lab6;

public class Dizionario {
	private Coppia[] S = new Coppia[0];

	private class Coppia {
		Object elem;
		Comparable chiave;

		Coppia(Object e, Comparable k) {
			this.elem = e;
			this.chiave = k;
		}
	}

	public void insert(Object e, Comparable k) {
		Coppia[] temp = new Coppia[S.length + 1];
		int newPos = S.length;
		
		for (int i = 0; i < S.length; i++) {
			temp[i] = S[i];
		}

		S = temp;

		for (int i = 0; i < S.length - 1; i++) {
			if (k.compareTo(S[i].chiave) <= 0) {
				newPos = i;
				break;
			}
		}

		for (int i = S.length - 1; i > newPos; i--) {
			S[i] = S[i - 1];
		}

		S[newPos] = new Coppia(e, k);
	}

	public void delete(Comparable k) {
		int i = 0;
		int j = S.length;
		
		boolean found = false;

		while (i < j && !found) {
			int m = (i + j) / 2;

			if (k.compareTo(S[m].chiave) == 0) {
				Coppia[] temp = new Coppia[S.length - 1];
				
				for (j = 0; j < i; j++) {
					temp[j] = S[j];
				}
				
				for (j = i; j < S.length - 1; j++) {
					temp[j] = S[j + 1];
				}
				
				S = temp;
				
				found = true;
			} else {
				if (k.compareTo(S[m].chiave) < 0) {
					j = m;
				} else {
					i = m + 1;
				}
			}
		}
	}

	public Object search(Comparable k) {
		int i = 0;
		int j = S.length;

		while (i < j) {
			int m = (i + j) / 2;

			if (k.compareTo(S[m].chiave) == 0) {
				return S[m].elem;
			} else {
				if (k.compareTo(S[m].chiave) < 0) {
					j = m;
				} else {
					i = m + 1;
				}
			}
		}

		return null;
	}
	
	public void showAll() {
		for (int i = 0; i < S.length; i++) {
			System.out.println(S[i].elem + "  " + S[i].chiave);
		}
	}
	
	public static void main(String... args) {
		Dizionario manage = new Dizionario();
		manage.insert("Pippo", "080123456");
		manage.insert("Giò", "080654321");
		manage.insert("Lisa", "081123456");
		manage.insert("Gennarino", "081654321");
		manage.insert("Emy", "347112233");
		
		manage.showAll();
		
		System.out.println("I've found: " + manage.search("081654321"));
		
		manage.delete("081654321");
		
		System.out.println("------- something's coming:");
		
		//manage.showAll();
		
		manage.insert("SimoneGrande", "081654321");
		
		manage.showAll();
	}
}
