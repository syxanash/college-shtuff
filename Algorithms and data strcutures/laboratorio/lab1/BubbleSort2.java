package lab1;

public class BubbleSort2 {
	public static void main(String... args) {
		int[] a = {1, 2, 4, 3, 9, 7, 5, 8};
		int compars = 0;
		
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.println("=== Scan " + (a.length - i)); // beautify string
			
			for (int j = 0; j < i; j++) {
				System.out.println("Comparing: " + a[j] + " " + a[j + 1]);
				compars++;
			
				if (a[j] >= a[j + 1]) {					
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					
					System.out.println("*SWAP*");
				}
			}
		}
		
		for (int e : a) {
			System.out.print(e + " ");
		}
		
		System.out.println("\nCOMPARISONS: " + compars);
		
	}
}
