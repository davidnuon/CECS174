import java.util.Scanner;

/*  Name: David Nuon
    Date: 4/8/2012
    Program:  Project 9
	Description: A program that play a game of Pig with the user.
*/

public class PartB {
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Make the dice
		Dice playerDie, comDie;
		playerDie = new Dice();
		comDie    = new Dice();
		
		int scores[]      = {0, 0};
		int tempScores [] = {0, 0};
		int turns[]       = {0, 0};
		
		boolean running = true;
		
		while(running) {
			running = programLoop(playerDie, comDie, tempScores, scores, turns);
		}
		
		if(scores[0] >= 100 || scores[1] >= 100) {
			showScore(scores);
			System.out.println();
			if(scores[0] > scores[1]) {
				System.out.println("Player 1 wins!");
			} else {
				System.out.println("Player 2 wins!");
			}
		}
		
		System.out.println("Done");
	}

	/*
	 *  The program loop
	 */
	
	private static boolean programLoop(Dice playerDie, Dice comDie, int[] tempScores, int[] scores, int[] turns) {
		boolean running = true;
		
		System.out.println();
		System.out.println("- Pig -");
		System.out.println("1. Roll");
		System.out.println("2. Hold");
		System.out.println("3. Show Score");
		System.out.println("4. Exit");

		if(scores[0] >= 100 || scores[1] >= 100) {
			running = false;
		} else {
			switch(promptIntInRange("Enter a choice: ", 1, 4)) {
				case 1:
					playerRoll(playerDie, comDie, tempScores, scores, turns);
					break;
				case 2:
					playerHold(playerDie, comDie, tempScores, scores, turns);
					break;
				case 3:
					showScore(scores);
					break;
				case 4:
					running = false;
					break;
				default:
					break;
			}
		}
		
		return running;
	}


	/*
	 *  Shows the scores
	 */
	
	private static void showScore(int[] scores) {
		System.out.println("Player 1 = " +  scores[0]);
		System.out.println("Player 2 = " +  scores[1]);
		
	}	
	
	
	/*
	 *  Resolves the player hold
	 */

	private static void playerHold(Dice playerDie, Dice comDie, int[] tempScores, int[] scores, int[] turns) {
		System.out.println("Player 1 holds");
		scores[0] += tempScores[0];
		tempScores[0] = 0;
		CPUTurn(playerDie, comDie, tempScores, scores, turns);
	}

	/*
	 *  Resolves the player roll
	 */
	private static void playerRoll(Dice playerDie, Dice comDie, int[] tempScores, int[] scores, int[] turns) {
		int playerRoll = playerDie.roll();
		System.out.println("You rolled a " + playerRoll);
		
		if(playerRoll == 1) {
			System.out.println("Turn total = " + turns[0]);
			System.out.println("End of Player 1's Turn");
			CPUTurn(playerDie, comDie, tempScores, scores, turns);
		} else {
			turns[0]++;
			System.out.println("Turn total = " + turns[0]);
			tempScores[0] += playerRoll;
		}
		
	}

	/*
	 *  CPU Turn
	 */
	
	private static void CPUTurn(Dice playerDie, Dice comDie, int[] tempScores, int[] scores, int[] turns) {
		boolean turnPlay = true;
		boolean hold = false;
		int comRoll = 0;
		
		while(turnPlay) {
			comRoll = comDie.roll();
			
			System.out.println("Player 2 rolled a " + comRoll);
			
			if(comRoll == 1) {
				System.out.println("Turn total = " + turns[1]);
				turnPlay = false;
			} else {
				turns[1]++;
				System.out.println("Turn total = " + turns[1]);
				tempScores[1] += comRoll;
				
				// 5% chance of the computer holding
				turnPlay = ((int)(Math.random() * 20 + 1)%19 == 0);
				
				// If the computer's turn ends now (turnPlay is false), he holds.
				hold = !turnPlay;
			}
		}
		
		if(hold) {
			System.out.println("Player 2 holds");
			scores[1] += tempScores[1];
			tempScores[1] = 0;
		} else {
			System.out.println("End of Player 2's Turn");
		}
	}
	
	/*
	 *  Prompts a user for valid integer and returns it
	 *  an integer. Checks to see if it is in a range also.
	 */

	public static int promptIntInRange(String prompt, int min, int max) {
		Scanner in = new Scanner(System.in);
		int out = 0;
		String miscInput = "";
		String error = "Please enter a valid integer value within [" + min + "," + max + "]:";		
		boolean valid = false; 
		
		if(min == max) {
			error = "Please enter: " + min;
		}
		
		System.out.print(prompt);
		while(!valid) {
			if(in.hasNextInt()) {
				out = in.nextInt();
				if(out >= min && out <= max ) {
					valid = true;	
				} else {
					System.out.print(error);				
				}
			} else {
				miscInput = in.next();
				System.out.print(error);
			}
		}
		
		return out;
	}


}
