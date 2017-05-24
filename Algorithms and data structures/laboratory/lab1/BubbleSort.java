package lab1;

public class BubbleSort {
	public static void main(String... args) {
		int[] a = {1, 2, 4, 3, 9, 7, 5, 8};
		
		int compars = 0;
		
		for (int i = 1; i < a.length; i++) {
			
			boolean swapped = false;
			
			System.out.println("=== Scan " + i);
			
			for (int j = 1; j <= a.length - i; j++) {
				
				System.out.println(a[j - 1] + " - " + a[j]);
				compars++;
				
				if (a[j - 1] > a[j]) {					
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					
					swapped = true;
					
					System.out.println("*SWAP*");
				}				
			}
			
			for (int e : a) {
				System.out.print(e + " ");
			}
			System.out.println();
			
			if (!swapped)
				break;
		}
		
		System.out.println("COMPARISONS: " + compars);
	}
}
