package lab10.list;

public class Main {
	public static void main(String[] args) {
		Lista list = new ListDoubling();
		
		System.out.println("la lista e' vuota: " + list.isEmpty() + "\n");
		
		list.insert("simone", list.firstList());
		list.insert("morena", list.firstList());
		list.insert("pippo", list.firstList());
		
		list.insert("pippona", list.succ(list.firstList()));
		
		for (Posizione p = list.firstList(); !list.endList(p); p = list.succ(p)) {
			System.out.println(list.readList(p));
		}
		
		list.insert("francesco", list.pred(list.succ(list.succ(list.succ(list.firstList())))));
		
		System.out.println("=== new");
		
		for (Posizione p = list.firstList(); !list.endList(p); p = list.succ(p)) {
			System.out.println(list.readList(p));
		}
	}
}
