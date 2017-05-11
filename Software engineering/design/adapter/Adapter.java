package patterns.design.adapter;

// classe che adatta quella legacy e che verrà utilizzata
// dal client mediante l'interfaccia TargetCustomer

public class Adapter implements TargetCustomer {

	@Override
	public String requiredMethod() {
		String value = "";
		
		LegacyCustomer legacy = new LegacyCustomer();
		value = legacy.usefulMethod() + " - valore importante!";
		
		return value;
	}
}
