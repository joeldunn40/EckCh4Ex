/** Eck Exercise 4.3
 * Program rolls pair of dice until number is achieved.
 * Prints number of rolls thrown.
 * Provide dice sum
 * 	check sum is legal
 * 	Roll pair until sum is achieved
 * 	Return roll count to main & print
 * @author Joel
 *
 */
public class RollGivenNumber {
	public static void main(String[] args) {
		int target; // target sum
		int rollCount; // roll count
		
		target = 12;
		System.out.print("Target of " + target);
		rollCount = rollDie(target);
		System.out.println(" was reached in " + rollCount + " roll(s)");
	}
	
	/** Check target is legal (or throw error)
	 * Then roll dice pair until target achieved
	 * @param target the total of two dice we want to get
	 * @return the number of rolls it took to get the target
	 */
	static int rollDie(int target) {
		int rollCount=0; // count the rolls
		if (target<2 || target>12) { // error if out of bounds
			throw new IllegalArgumentException("Target not between 2 & 12");
		}
		// Roll the dice!
		while(true) {
			rollCount++; // increment roll count
			int d1 = (int)(Math.random()*6 + 1); // dice 1 value
			int d2 = (int)(Math.random()*6 + 1); // dice 2 value
			int sum = d1+d2; // total sum
//			System.out.println(rollCount + " " + sum);
			if (sum == target) {
				return rollCount;
			}
			
		}
			
	}
}
