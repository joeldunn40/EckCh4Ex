/** Eck Ch4 Exercise 4.1
 * Program takes string and capitalizes each word
 * printCapitalized prints capitalized version
 * Define string in main() as inputStr
 * call subroutine printCaptialized(inputStr)
 * 	isStartOfWord = true
 * 	loop through chars
 * 		if char is letter
 * 			if isStartOfWord
 * 				change char to upper
 * 				isStartofWord = false
 * 			else
 * 				change char to lower
 * 			prevCharIsLetter = true
 * 		else 
 * 			isStartofWord = true
 * 		print char
 * @author Joel
 *
 */
public class CapitalizeWords {
	public static void main(String[] args) {
		String inputStr = " bNow is the time to act!"; // declare & define input string
		printCapitalized(inputStr);
	}
	
	/** Subroutine to printCapitalized string
	 * Print string with start of word upper case and rest lower.
	 * @param string string to be capitalized
	 */
	
	static void printCapitalized(String string) {
		boolean isStartOfWord = true;
		System.out.println("Input string = " + string);
		for (int i=0; i<string.length(); i++) {
			char ch = string.charAt(i);			
			if (Character.isLetter(ch)) {
				if (isStartOfWord) {
					ch = Character.toUpperCase(ch);
					isStartOfWord = false;
				} else
					ch = Character.toLowerCase(ch);
			}  else 
				isStartOfWord = true;
//			System.out.print(isStartOfWord);
			System.out.print(ch);
		}
		System.out.println();
	}

}
