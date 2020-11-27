/** Eck Exercise 4.5
 * 4 public static final variables of type ArrayProcessor
 * max, min, sum, avetage.
 * This the class to define the 4 static member variables.
 * It also defines a function that can create ArrayProcessors 
 * for counting the occurances of values in an array.
 * NOTE: this program depends on the interface ArrayProcessor
 * @author Joel
 *
 */

public class LambdaTest {
	/** counts the number of times a value occurs: as lambda expression
	 * @param value 
	 * @return returns an ArrayProcessor
	 */
	public static ArrayProcessor counter ( double value ) {
		return array -> {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == value)
					count++;
			}
			return count;
		};
	}

	/** LE for finding maximum
	 * Array must have length >= 1
	 */
	public static final ArrayProcessor maxer = array -> {
		double max = array[0];
		for (int i = 1; i < array.length; i++ ) {
			if (array[i]>max)
				max = array[i];
		}
		return max;
	};
			
	/** LE for finding minimum
	 * Array must have length >= 1
	 */
	public static final ArrayProcessor miner = array -> {
		double min = array[0];
		for (int i = 1; i < array.length; i++ ) {
			if (array[i]<min)
				min = array[i];
		}
		return min;
	};
	
	/** Lambda expression for finding sum of array
	 * L.E. is value of type ArrayList
	 * Assign LE to a public static final member variable of type ArrayList
	 * called sumer
	 */
	public static final ArrayProcessor sumer = array -> {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		return total;
	}; // ; marks end of assignment statement

	/** LE for calculating average
	 * Array must have length >= 1
	 * calls ArrayProcessor sumer
	 */
	public static final ArrayProcessor averager = array -> sumer.apply(array) / array.length;
		
	/** main() routine to test the other public members of this class
	 * defines 2 test double arrays
	 */
	public static void main(String[] args) {
		double[] firstList = {1,2,3,4,5,6,7,8,9,10};
		double[] secondList = {17.0,3.14,17.0,-3.4,17.0,42.0,29.2,3.14};
		
		System.out.println("Sum of first List (55) = " + sumer.apply(firstList));
		System.out.println("Average of first List (5.5) = " + averager.apply(firstList));
		System.out.println("Min of second List (-3.4) = " + miner.apply(secondList));
		System.out.println("Max of second List (42.0) = " + maxer.apply(secondList));
		System.out.println("Count 17.0 in second List (3) = " + counter(17.0).apply(secondList));
		System.out.println("Count 20.0 in second List (0) = " + counter(20.0).apply(secondList));
		System.out.println("Count 9.0 in first List (1) = " + counter(9.0).apply(firstList));
	} // end main
}
