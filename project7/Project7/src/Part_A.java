/*  Name: David Nuon
    Date: 3/10/2012
    Program:  Project 7
	Description: A program, using static void methods, that allows the user to choose from different 
	options for displaying a string. 
*/

import java.util.Scanner;

public class Part_A {
	public static void main(String[] args) {
		// Make space for variables
		Scanner in = new Scanner(System.in);
		int choiceType = 0, timesToRepeat = 0;
		
		String invalidPrompt, miscInput = "", userString = "";
		invalidPrompt = "Enter a vaild choice. \n\n";
		boolean running, repeatingString;
		
		running            = true;
		repeatingString    = false;
		
		// Program Loop
		while(running) {
			System.out.println("Menu:");
			System.out.println("1.  Display String");
			System.out.println("2.  Display String Backwards");
			System.out.println("3.  Repeat String");
			System.out.println("4.  Vertically Repeat String");
			System.out.println("5.  -Quit-");
			
			if(in.hasNextInt()) {
				choiceType = in.nextInt();
				if (choiceType <= 0 || choiceType > 5) {
					System.out.print(invalidPrompt);
				} else if (choiceType == 5){
					running = false;
				} else {
					// Allow only the 3rd and 4th choice invoke a second menu
					if(choiceType == 3 || choiceType == 4) {
						repeatingString = true;
					}
				}
			} else {
				System.out.print(invalidPrompt);
				miscInput = in.nextLine();
			}
			
			miscInput = in.nextLine();
			if(running) {
				// Ask user for a strings
				System.out.print("Enter your string: ");
				userString = in.nextLine();
				
				// Checks to see if the choice requires a second menu or not.
				if(repeatingString) {				
					while(repeatingString) {
						System.out.print("Enter the number of times to repeat: ");
						if(in.hasNextInt()) {
							timesToRepeat = in.nextInt();
							
							switch (choiceType) {
							case 3:
								repeatString(userString, timesToRepeat);
								break;
							case 4:
								vertRepeatString(userString, timesToRepeat);
								break;
							default:
								break;
							}						
							
							repeatingString = false;
						} else {
							System.out.print(invalidPrompt);
							miscInput = in.next();
						}
					}
				} else {
					switch (choiceType) {
					case 1:
						displayString(userString, "Your string is: ");
						break;
					case 2:
						displayStringBackwards(userString);
						break;
					default:
						break;
					}
					
				}
			}
		} 
			
		System.out.println("Done.");
	}
	
	public static void displayString(String inputString, String prompt) {
		System.out.println(prompt + inputString);
	}
	
	public static void displayStringBackwards(String inputString) {
		int     stringLength = inputString.length();
		String reverseString = "";
		
		while(stringLength > 0) {
			reverseString = reverseString + inputString.substring(stringLength - 1, stringLength);
			stringLength--;
		}
				
		displayString(reverseString, "");
	}
	
	public static void repeatString(String inputString, int repeat) {
		while(repeat > 0) {
			displayString(inputString, "");
			repeat--;
		}
	}
	
	public static void vertRepeatString(String inputString, int repeat) {
		int stringLength = inputString.length();
		for(int i = 0; i < stringLength; i++) {
			for(int k = 0; k < repeat; k++) {
				System.out.print(inputString.substring(i, i + 1));
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}
} 