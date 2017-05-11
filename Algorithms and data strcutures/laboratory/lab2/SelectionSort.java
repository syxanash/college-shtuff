package lab2;

public class SelectionSort {
	public static void main(String... args) {
		int[] a = { 3, 1, 4, 2, 9, 7, 5, 8 };
		int compars = 0;
		
		for (int i = 0; i < a.length; i++) {
			
			int minPos = i;
			
			System.out.println("=== Scan " + i);
			
			for (int j = i + 1; j < a.length; j++) {
				System.out.println(a[i] + " - " + a[j]);
				compars++;
								
				if (a[j] <= a[minPos]) {
					minPos = j;
					
					System.out.println("*WILL SWAP*");
				}
			}
			
			if (minPos != i) {
				int temp = a[i];
				a[i] = a[minPos];
				a[minPos] = temp;
			}
			
			for (int e : a) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		System.out.println("COMPARISONS: " + compars);
	}
}
