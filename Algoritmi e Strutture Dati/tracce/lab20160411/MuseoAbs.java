package lab20160411;

import java.util.Iterator;

public abstract class MuseoAbs {
	protected Dictionary<String, Record> opere;
	
	public boolean museoVuoto() {
		return opere == null;
	}
	
	public void addOp(String codice, Opera opera) {
		opere.insert(codice, new Record(opera, false, null));
	}
	
	public Opera opera(String codice) {
		if (opere.search(codice) == null)
			return null;
		
		return opere.search(codice).opera;
	}
	
	public void prestito(String codice, String esposizione) {
		this.setPrestito(codice, esposizione, true);
	}
	
	public void restituzione(String codice, String esposizione) {
		this.setPrestito(codice, esposizione, false);
	}
	
	private void setPrestito(String codice, String esposizione, boolean flag) {
		if (opere.search(codice) != null) {
			opere.search(codice).prestata = flag;
			opere.search(codice).esposizione = esposizione;
		}
	}
	
	public boolean prestata(String codice) {
		if (opere.search(codice) == null)
			return false;
		
		return opere.search(codice).prestata;
	}
	
	public AddOnlyList<Opera> prestiti(String esposizione) {
		Iterator<String> it = opere.iterator();
		
		AddOnlyList<Opera> prestiti = new VectorList<Opera>();
		
		while(it.hasNext()) {
			Record rec = opere.search(it.next());
			
			if (rec.prestata && rec.esposizione.compareTo(esposizione) == 0) {
				prestiti.add(rec.opera);
			}
		}
		
		return prestiti;
	}
	
}
