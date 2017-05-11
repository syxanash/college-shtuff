package lab2;

public class InsertionSort {
	public static void main(String... args) {
		int[] a = {3, 1, 4, 2, 9, 7, 5, 8};
		int compars = 0;
		
		for (int i = 1; i < a.length; i++) {
			
			int minPos = i;
			int minValue = a[i];
			
			System.out.println("=== Scan " + i);
			
			for (int j = i - 1; j >= 0; j--) {
				System.out.println(a[i] + " - " + a[j]);
				compars++;
				
				minValue = a[i];
				
				if (minValue <= a[j]) {
					minPos = j;
				}
			}
			
			if (minPos != i) {
				for (int k = i; k > minPos; k--) {
					a[k] = a[k - 1];
				}
				
				a[minPos] = minValue;
			}
			
			for (int e : a) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		System.out.println("COMPARISONS: " + compars);
	}
}
