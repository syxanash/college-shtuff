package lab20140904;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkypeTest {
	public static void main(String... args) {
		Random rnd = new Random();
		Skype[] convs = new Skype[3];
		int[] nums = { 7, 9, 13 };

		for (int j = 0; j < convs.length; j++) {
			convs[j] = new Skype();
			List<Integer> scrambled = new ArrayList<Integer>();
	
			for (int i = 0; i < nums[j]; i++) {
				int random = rnd.nextInt(nums[j]);
	
				if (scrambled.contains(random)) {
					i--;
				} else {
					scrambled.add(random);
				}
			}
	
			for (int i = 0; i < nums[j]; i++) {
				int casual = scrambled.get(i);
				boolean last = (i + 1) == nums[j];
	
				convs[j].addPacchetto(new Pacchetto("simone", "morena", casual,
						"boh", last));
			}
		}
		
		System.out.println(convs[0].compareTo(convs[0]) == 0);
	}
}
