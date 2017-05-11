package lab9.codadoppia;

import lab9.pila.EccezioneStrutturaVuota;

public class CodaDoppiaDoubling implements CodaDoppia {

	private Object[] S = new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void push(Object elem) {
		enqueue(elem);
	}

	@Override
	public void pop() throws EccezioneStrutturaVuota {
		n--;
		
		if (n > 1 && n <= S.length / 4) {
			Object[] temp = new Object[S.length / 2];
			
			for (int i = 0; i < n; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
	}

	@Override
	public Object top() throws EccezioneStrutturaVuota {
		if (isEmpty()) {
			throw new EccezioneStrutturaVuota();
		}
		
		return S[n - 1];
	}

	@Override
	public void enqueue(Object elem) {
		S[n] = elem;
		n++;
		
		if (n == S.length) {
			Object[] temp = new Object[S.length * 2];
			
			for (int i = 0; i < n; i++) {
				temp[i] = S[i];
			}
			
			S = temp;
		}
	}

	@Override
	public Object first() throws EccezioneStrutturaVuota {
		if (isEmpty()) {
			throw new EccezioneStrutturaVuota();
		}
		
		return S[0];
	}

	@Override
	public void dequeue() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota();

		Object[] temp = new Object[S.length];
		
		// sovrascrivo la posizione all'inizio e
		// scalo tutti i valori da sinistra
		for (int i = 0; i < n - 1; i++) {
			temp[i] = S[i + 1];
		}
		
		S = temp;
		
		pop();
	}

	public static void main(String... args) {
		CodaDoppia doubleq = new CodaDoppiaDoubling();

		doubleq.enqueue("simone");
		doubleq.enqueue("morena");
		doubleq.enqueue("pippo");
		doubleq.enqueue("gianni");
		
		doubleq.push("minghia");
		
		try {
			doubleq.pop();
			System.out.println(doubleq.top());
		} catch (EccezioneStrutturaVuota e) {
			
		}
	}

}
