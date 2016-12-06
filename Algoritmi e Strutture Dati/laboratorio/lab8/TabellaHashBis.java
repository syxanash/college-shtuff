package lab8;

public class TabellaHashBis implements Dizionario {
	private Coppia S[];
	private Hash hFun;
	private Scansione cFun;
	private Object canc;

	// definisco la classe per le coppie

	private class Coppia {
		public Object elem;
		public Comparable chiave;

		public Coppia(Object e, Comparable k) {
			this.elem = e;
			this.chiave = k;
		}
	}

	public TabellaHashBis(int n, Hash f, Scansione cFun) {
		S = new Coppia[(int) (n * 1.2)];
		hFun = f;
		this.cFun = cFun;
	}

	public void insert(Object e, Comparable k) {
		int hk = hFun.h(k, S.length);
		
		for (int i = 0; i < S.length; i++) {
			int pos = cFun.c(hk, i, S.length);
			if (S[pos] == canc || S[pos] == null) {
				S[pos] = new Coppia(e, k);
				return;
			}
		}
		
		System.out.println("Array pieno");
		System.exit(1);
	}
	
	public Object search(Comparable k) {
		int hk = hFun.h(k, S.length);
		
		for (int i = 0; i < S.length; i++) {
			int pos = cFun.c(hk, i, S.length);
			
			if (S[pos] == null) {
				break;
			} else if (S[pos].elem == canc) {
				continue;
			} else if (S[pos].chiave.compareTo(k) == 0) {
				return S[pos].elem;
			}
		}
		
		return null;
	}

	public void delete(Comparable k) {
		int hk = hFun.h(k, S.length);
		
		for (int i = 0; i < S.length; i++) {
			int pos = cFun.c(hk, i, S.length);
			
			if (S[pos] == null)
				break;
			
			if (S[pos].chiave.compareTo(k) == 0 && S[pos].elem != canc) {
				S[pos].elem = canc;
				return;
			}
		}

	}
	
	private static void inizializza(Dizionario d) {
		   d.insert("Pippo","080123456");
		   d.insert("Gi�", "080654321");
		   d.insert("Lisa", "081123456");
		   d.insert("Gennarino", "081654321");
		   d.insert("Emy", "347112233");
	}
	
	public static void main(String[] args) {
			Dizionario rubrica = new TabellaHashBis(6, new HashDivisione(), new ScansioneLineare());
			
			inizializza(rubrica);
			
			//rubrica.delete("080654321");
						
			System.out.println(rubrica.search("081654321"));
			System.out.println(rubrica.search("080654321"));
			System.out.println(rubrica.search("081123456"));
			
			rubrica.insert("simone", "666");
			rubrica.delete("666");
			rubrica.insert("simone", "666");
			System.out.println(rubrica.search("666"));
	 }

}
