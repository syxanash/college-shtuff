package patterns.design.adapter;

public class Client {
	public static void main(String[] args) {
		TargetCustomer system = new Adapter();
		System.out.println(system.requiredMethod());
	}
}
