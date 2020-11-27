/** Eck Exercise 4.4
 * Program prints out average number of rolls to obtain every
 * possible outcome of 2 dice from 10,000 rolls. Uses rollDIe from 
 * RollGivenNumber
 * 
 * @author Joel
 *
 */
public class AverageRollsPerTarget {
	
	/** Loop over every possible target sum.
	 * Call rollDie 10,000 times.
	 * For each rollDie call, keep count of total rolls.
	 * Divide sum rolls by 10,000 for average
	 * Print output 
	 */
	public static void main(String[] args) {
		
		// Print table header
		System.out.print("Total On Dice");
		System.out.println("    Average Number of Rolls");
		System.out.print("-------------");
		System.out.println("    -----------------------");
		
		for (int target=2;target<=12;target++) {
			double avgRolls = repeatRolls(target);
			System.out.printf("%10d%22.4f\n",target,avgRolls);
		} // end target loop101
	
	} // end main

	/** Repeat experiment 10_000 times for target
	 * 
	 * @param target sum of two dice testing for
	 * @return average number of rolls required to reach target
	 */
	static double repeatRolls(int target) {
		int numRuns = 10_000; // number of experiments
		int targetSum = 0; // declare/initialize targetSum
		for (int i=0;i<numRuns;i++) {
			targetSum += rollDie(target); // keep count of rolls
		} // end rollDie loop for single target
		double avgRolls = ((double)targetSum)/numRuns; // Average number of rolls
		return avgRolls;
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
		} // end if
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
			
		} // end while
	} // end rollDie
}
