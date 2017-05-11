package lab20150903;


public abstract class AbSession {
	protected AddOnlyList<Item> items;
	
	// dubbio della traccia, i metodi devo inventarmeli io???
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public AddOnlyList<Item> getItems() {
		return items;
	}
	
	public int getPrice(String name) {
		int price = 0;
		
		for (Item e : items) {
			if (e.name.compareTo(name) == 0) {
				price = e.price;
				break;
			}
		}
		
		return price;
	}
	
	public Item getItem(int i) {
		int pos = 0;
		
		for (Item e : items) {
			if (pos == i) {
				return e;
			}
			
			i++;
		}
		
		return null;
	}
}
