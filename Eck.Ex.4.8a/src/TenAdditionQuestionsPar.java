/** Eck Exercise 4.8
 * Ask the user 10 simple addition questions
 * Print out the questions with user's answers & whether Correct or Wrong
 * Print out final mark
 * 3 subroutines: 
 * 	create
 * 		generate random numbers for quiz
 * 	administer 
 * 		ask questions and record user answers
 * 	grade
 * 		for each question
 * 			compare quiz answers to user answers
 * 			print: question, user answer, correct/wrong
 * 			cumulative score
 * 		return or print final score.
 * 3 Global variables int[]
 * 	firstNumbers
 * 	secondNumbers
 * 	userAnswers 
 * @author Joel
 *
 */

import textio.TextIO;

public class TenAdditionQuestionsPar {
	static final int numQs = 3;
//	static int[] firstNumbers = new int[numQs];
//	static int[] secondNumbers = new int[numQs];;
//	static int[] userAnswers = new int[numQs];;
	
	public static void main(String[] args) {
		int[] firstNumbers = new int[numQs];
		int[] secondNumbers = new int[numQs];;
		int[] userAnswers = new int[numQs];;
		create(firstNumbers,secondNumbers);
		administer(firstNumbers,secondNumbers,userAnswers);
		grade(firstNumbers,secondNumbers,userAnswers);
// 		according to Eck: no global var: use variables set here, call with parameters
//		e.g. create(firstNumbers,secondNumbers) will assign values within main so can then call administer(f.... ) etc
	} // end main
	
	/** 
	 * Precondition: The input number of questions is an integer. 
	 * Postcondition: random integers will be assigned to global arrays
	 * 			      firstNumbers and secondNumbers. These arrays will
	 * 				  have the length numQs.
	 * @param numQs integer representing number of questions to be asked
	 */
	static void create(int[] firstNumbers,int[] secondNumbers) {
		for (int i = 0; i < numQs; i++) {
			firstNumbers[i] = (int)(Math.random()*20);
			secondNumbers[i] = (int)(Math.random()*20);
		} // end for loop assigning random numbers
	} // end create
	
	/** 
	 * Precondition:  firstNumbers and secondNumbers have been assigned
	 * 				  as integer arrays. User answers must be integers
	 * Postcondition: Questions will be presented to the screen and will
	 * 				  record user's answers in userAnswers
	 */
	static void administer(int[] firstNumbers,int[] secondNumbers, int[] userAnswers) {
		for (int i = 0; i < firstNumbers.length; i ++) {
			System.out.printf("%d + %d = ? ",
					firstNumbers[i],secondNumbers[i]);
			userAnswers[i] = TextIO.getlnInt();
		}
	} // end administer
	
	/** 
	 * Precondition:  questions have been asked and user has answered
	 * 				  as integers
	 * Postcondition: Questions, user answers and mark will be printed
	 * 				  with summary mark at the end
	 */
	static void grade(int[] firstNumbers,int[] secondNumbers, int[] userAnswers) {
		int answer;
		int score = 0;
		String mark;
		for (int i = 0; i < firstNumbers.length; i ++) {
			answer = firstNumbers[i] + secondNumbers[i];
			mark = "Wrong!";
			if (answer == userAnswers[i]) {
				mark = "Correct!";
				score++;
			} // end if (increment score & correct mark)
			System.out.printf("%d + %d: %d: %s\n",
					firstNumbers[i],secondNumbers[i],
					userAnswers[i],mark);
		} // end for each question
		System.out.println("Final score = " + score + 
				" out of " + firstNumbers.length);
	} // end grade
}
