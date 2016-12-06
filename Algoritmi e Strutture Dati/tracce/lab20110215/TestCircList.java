package lab20110215;

import java.util.Iterator;

public class TestCircList {
	public static void main(String... args) {
		CircList<String> list = new ListaCircDL<String>();

		list.addCircList("alfa");
		list.addCircList("beta");
		list.addCircList("gamma");
		list.addCircList("delta");
		list.addCircList("epsilon");

		for (String w : list) {
			System.out.print(w + " ");
		}

		list.setDir(Direzione.backward);
		list.ruota();

		System.out.println();

		for (String w : list) {
			System.out.print(w + " ");
		}

		list.setDir(Direzione.forward);
		list.ruota();

		System.out.println();

		for (String w : list) {
			System.out.print(w + " ");
		}

		System.out.println();

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String text = it.next();

			if (text.split("")[0].toLowerCase().compareTo("d") == 0) {
				list.delCircList();

				break;
			}

			list.ruota();
		}

		list.ruota();

		for (String w : list) {
			System.out.print(w + " ");
		}
	}
}
