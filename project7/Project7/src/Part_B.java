/*  Name: David Nuon
    Date: 3/10/2012
    Program:  Project 7
	Description: A program, using static void methods, that allows the user to choose from different 
	options for displaying a string. 
*/

import java.util.Scanner;

public class Part_B {
	public static void main(String[] args) {
		// Make space for variables
		Scanner in = new Scanner(System.in);
		int choiceType = 0, timesToRepeat = 0;
		int playerWin = 0, computerWin = 0;
		int gameResult;
		
		String invalidPrompt, miscInput = "", userString = "";
		invalidPrompt = "Enter a vaild choice.";
		boolean running, repeatingString;
		
		running          = true;
		repeatingString  = false;
			
		// Program Loop
		while(running) {
			
			choiceType  = displayMenu(in, invalidPrompt);
			gameResult  = playerWin(getChoice(in, invalidPrompt), computerChoice());
			switch (choiceType) {
			case 1:
				// The player plays the game
				if(running) {
					switch (gameResult) {
					case 0: // A loss
						System.out.println("Computer wins.");
						computerWin++;
						break;
					case 1: // A win
						System.out.println("You win.");
						playerWin++;
						break;
					case 2: // A tie
						System.out.println("Tie.");
						break;
					default:
						break;
					}
				}
				System.out.println();
				break;
			case 2:
				// Display the score
				displayScore(playerWin, computerWin);
				System.out.println();
				break;
			case 3:
				// Quit
				running = false;
				break;
			default:
				break;
			}
		} 
			
		System.out.println("Final Score:");
		displayScore(playerWin, computerWin);
	}
	
	public static int displayMenu(Scanner in, String invalidPrompt) {
		int     choiceType = 3;
		boolean valid      = false;    
		
		System.out.println("Menu:");
		System.out.println("1.  Play Game");
		System.out.println("2.  Display Score");
		System.out.println("3.  Quit");
		
		while(!valid) {
			if(in.hasNextInt()) {
				choiceType = in.nextInt();
				if (choiceType <= 0 || choiceType > 3) {
					System.out.print(invalidPrompt);
				} else {
					valid = true;
				}
			} else {
				System.out.println(invalidPrompt);
				String miscInput = in.nextLine();
			}
		}
		
		return choiceType;
	}
	
	public static String getChoice(Scanner in, String invalidPrompt) {
		String userChoice = "";
		boolean valid     = false;    
		
		System.out.println("Choose your weapon:");
		System.out.println("R. Rock");
		System.out.println("P. Paper");
		System.out.println("S. Scissors");
		System.out.println("L. Lizard");
		System.out.println("K. Spock");
				
		while(!valid) {
				userChoice = in.next();
				if (userChoice.equals("R") ||
				    userChoice.equals("P") ||
				    userChoice.equals("S") ||
				    userChoice.equals("L") ||
				    userChoice.equals("K") ) {
					
					valid = true;
				} else {					
					System.out.print(invalidPrompt);
					userChoice = "";
				}
		}		
		
		return userChoice;
	}
	
	public static String computerChoice() {
		String choices = "RPSLK";
		int    random  = (int)(Math.random()*5);
		
		return choices.substring(random, random + 1);
	}
	
	public static int playerWin(String userInput, String computerInput) {
		// (0, 1, 2) = (loss, win, tie)
		int playerWin = 0;

		System.out.println("You chose " + returnName(userInput));
		System.out.println("Computer chose " + returnName(computerInput));
		
		if (userInput.equals(computerInput)) {
			playerWin = 2;
		} else if (userInput.equals("S") && computerInput.equals("P")
				|| userInput.equals("P") && computerInput.equals("R")
				|| userInput.equals("R") && computerInput.equals("L")
				|| userInput.equals("L") && computerInput.equals("K")
				|| userInput.equals("K") && computerInput.equals("S")
				|| userInput.equals("S") && computerInput.equals("L")
				|| userInput.equals("L") && computerInput.equals("P")
				|| userInput.equals("P") && computerInput.equals("K")
				|| userInput.equals("K") && computerInput.equals("R")
				|| userInput.equals("R") && computerInput.equals("S")) {
			playerWin = 1;
		}
		
		return playerWin;
	}
	
	public static String returnName(String key) {
		String name = "";
		
		switch (key) {
			case "R":
				name = "Rock";
				break;
			case "P":
				name = "Paper";
				break;
			case "S":
				name = "Scissors";
				break;
			case "L":
				name = "Lizard";
				break;
			case "K":
				name = "Spock";
				break;
			default:
				name = "invalid value";
				break;
		}
		
		return name;
	}
	
	public static void displayScore(int playerWin, int computerWin) {
		System.out.println("Player = " + playerWin);
		System.out.println("Computer = " + computerWin);
	}
}
