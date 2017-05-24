package lab10.list.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String... args) {
		Lista<String> list = new ListDoubling<String>();
		
		list.insert("simone", list.firstList());
		list.insert("morena", list.firstList());
		list.insert("pippa", list.firstList());
		
		Iterator tempIt = list.iterator();
		
		while(tempIt.hasNext()) {
			System.out.println(tempIt.next());
		}
		
		System.out.println("new ----");
		
		tempIt = list.iterator(); // prendo il primo
		tempIt.next();   // leggo il successivo al primo
		tempIt.remove(); // lo rimuovo
		
		for (Iterator temp = list.iterator(); temp.hasNext();) {
			System.out.println(temp.next());
		}
	}
}
