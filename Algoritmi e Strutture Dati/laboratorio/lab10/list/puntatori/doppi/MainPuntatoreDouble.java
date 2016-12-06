package lab10.list.puntatori.doppi;

import lab10.list.Lista;
import lab10.list.Posizione;

public class MainPuntatoreDouble {
	public static void main(String... args) {
		Lista list = new ListDoubleLinked();
		
		list.insert("simone", list.firstList());
		list.insert("morena", list.succ(list.firstList()));
		list.insert("francesco", list.succ(list.succ(list.firstList())));
		
		
		
		System.out.println("new ---");
		
		list.remove(list.succ(list.succ(list.firstList())));
		
		for (Posizione tempPos = list.firstList(); !list.endList(tempPos); tempPos = list.succ(tempPos)) {
			System.out.println(list.readList(tempPos));
		}
	}
}
