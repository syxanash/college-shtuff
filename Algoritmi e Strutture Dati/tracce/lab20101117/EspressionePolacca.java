package lab20101117;

import java.util.LinkedList;

public class EspressionePolacca {
	private LinkedList<ItemEspr> espr = new LinkedList<ItemEspr>();

	public int valuta() throws EccezioneEspressioneNonValida {
		Pila<Integer> stack = new PilaDoubling<Integer>();

		int result = 0;

		for (ItemEspr item : espr) {
			// Operando.class is same for Class.forName("lab20101117.Operando")
			if (item.getClass() == Operando.class) {
				int operando = Integer.parseInt(item.toString());

				stack.push(operando);
			} else {
				try {
					int firstOp = stack.top();
					stack.pop();
					int secondOp = stack.top();
					stack.pop();

					switch (item.toString()) {
					case "+":
						result = secondOp + firstOp;
						break;
					case "-":
						result = secondOp - firstOp;
						break;
					case "*":
						result = secondOp * firstOp;
						break;
					case "/":
						result = secondOp / firstOp;
						break;
					}

					stack.push(result);
				} catch (EccezioneStrutturaVuota e) {
					throw new EccezioneEspressioneNonValida();
				}
			}
		}

		try {
			result = stack.top();
		} catch (EccezioneStrutturaVuota e) {
			throw new EccezioneEspressioneNonValida();
		}

		return result;
	}

	public EspressionePolacca(String espressione) {
		String[] chars = espressione.split(" ");

		for (int i = 0; i < chars.length; i++) {
			if (Operatore.checkOperatore(chars[i])) {
				espr.add(new Operatore(chars[i]));
			} else {
				espr.add(new Operando(Integer.parseInt(chars[i])));
			}
		}
	}

	public static void main(String... args) {
		String[] expressions = { "1", "125 +", "125 12 +",
				"123 245 + 127 - 4 * 2 /" };
		EspressionePolacca polish = null;

		for (String expr : expressions) {

			polish = new EspressionePolacca(expr);

			try {
				System.out.println(polish.valuta());
			} catch (EccezioneEspressioneNonValida e) {
				System.out.println("ESPRESSIONE MAL FORMATA!");
			}
		}
	}
}
