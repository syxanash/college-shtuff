package lab10.list.puntatori;

import lab10.list.Lista;

public class MainPuntatori {
	public static void main(String... args) {
		Lista list = new ListLinked();
		
		list.insert("rome", list.firstList());
		list.insert("simone", list.firstList());
		list.insert("morena", list.firstList());
		list.insert("francesco", list.firstList());
		
	}
}
