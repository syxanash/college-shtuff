package lab20140220;

public interface PQ<Item> extends Iterable<Item> {
	boolean isNew();
	void insert(Item item, int priority);
	Item first() throws EccezioneStrutturaVuota;
	void delFirst();
	void changePriority(Item item, int priority);
	int getPriority(Item item);
	int size();
}
