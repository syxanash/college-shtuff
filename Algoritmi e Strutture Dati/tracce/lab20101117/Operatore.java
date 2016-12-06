package lab20101117;

public class Operatore implements ItemEspr {
	private static String[] operatori = {"+", "-", "*", "/"};
	
	public String value;

	public Operatore(String op) {		
		this.value = op;
	}
	
	public static boolean checkOperatore(String op) {
		boolean isOperatore = false;
		
		for(String e : operatori)
			if (e.compareTo(op) == 0)
				isOperatore = true;
		
		return isOperatore;		
	}
	
	public String toString() {
		return value;
	}
}
