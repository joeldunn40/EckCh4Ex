/** Eck Exercise 4.2
 * Print out decimal value of input hexadecimal integer (as string).
 * @author Joel
 *
 */

import textio.TextIO;

public class CharacterHexadecimalValue {
	public static void main(String[] args) {
		char ch; // character from input string
		int dec = 0; // decimal value
		String inputStr; // input hex integer string
//		System.out.println("Enter Hex Integer:");
//		inputStr = TextIO.getln();
		
		inputStr = "3d1";
		for (int i=0; i<inputStr.length();i++) {
			int ipow = (int)Math.pow(16,inputStr.length()-i-1);
			ch = inputStr.charAt(i);
//			System.out.print("Char " + i + " = ");
//			System.out.print(hexValue(ch));
//			System.out.print("; " + ipow);
			dec += ipow*hexValue(ch);
//			System.out.println("Dec = " + dec);
		}
		System.out.println("Decimal Value = " + dec);
	}
	
	/** Return decimal integer of hex character
	 * Convert char to upper
	 * Try converting char to integer
	 * 	if successful return decimal
	 * 	else
	 * 		switch A-F
	 * 		default - throw error
	 * @param ch
	 * @return
	 */
	static int hexValue(char ch) {
		ch = Character.toUpperCase(ch);
		try {
			return Integer.parseInt(String.valueOf(ch));
		} catch (NumberFormatException e) {
			switch(ch){
			case 'A':
				return 10;
			case 'B':
				return 11;
			case 'C':
				return 12;
			case 'D':
				return 13;
			case 'E':
				return 14;
			case 'F':
				return 15;
			default: //throw NumberFormatException
				System.out.println("Char \""+ch+"\" doesn't look like Hex digit to me!");
				throw e;
			}
		}
	}
	
	
}
