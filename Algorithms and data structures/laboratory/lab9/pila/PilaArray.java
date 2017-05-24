package lab9.pila;

public class PilaArray<T> implements Pila<T> {

	private Object[] pila = new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void push(T elem) {
		if (n == pila.length) {
			Object[] temp = new Object[pila.length * 2];

			for (int i = 0; i < n; i++) {
				temp[i] = pila[i];
			}

			pila = temp;
		}

		pila[n] = elem;
		n++;
	}

	@Override
	public T top() throws EccezioneStrutturaVuota {
		if (n == 0) {
			throw new EccezioneStrutturaVuota();
		}

		return (T) pila[n - 1];
	}

	@Override
	public void pop() throws EccezioneStrutturaVuota {

		if (n == 0) {
			throw new EccezioneStrutturaVuota();
		}

		n--;

		if (n > 1 && n <= pila.length / 4) {
			Object[] temp = new Object[pila.length / 2];

			for (int i = 0; i < n; i++) {
				temp[i] = pila[i];
			}

			pila = temp;
		}
	}

	public static void main(String... args) {
		Pila<String> stack = new PilaArray<String>();

		stack.push("simone");
		stack.push("morena");
		stack.push("stocazzo");

		try {
			while(!stack.isEmpty()) {
				System.out.println(stack.top());
				stack.pop();
			}
			
			//stack.top();
		} catch(EccezioneStrutturaVuota e) {
			System.out.println("pila e' vuota!");
		}
	}
}
