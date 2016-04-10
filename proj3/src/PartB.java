/*  Name: David Nuon
    Date: 2/13/2012
    Program:  Project 3
    Description: An RPG Player generator
*/

public class PartB {
	public static void main(String[] args) {
		// Make space for the values
		int die1, die2, die3, charInt, charStr;
		String formatDie;
		
		formatDie = "Die 1: %1s  Die 2:%2s  Die 3: %3s";
		
		
		// Roll the stats for the first character
		die1 = (int)(Math.random()*5) + 1;
		die2 = (int)(Math.random()*5) + 1;
		die3 = (int)(Math.random()*5) + 1;
		
		System.out.print("Strength: ");
		System.out.printf(formatDie, die1, die2, die3 + " \n");
		charStr = die1 + die2 + die3;
		System.out.println("Sum: " + charStr);
		
		die1 = (int)(Math.random()*5) + 1;
		die2 = (int)(Math.random()*5) + 1;
		die3 = (int)(Math.random()*5) + 1;
		
		System.out.print("Intellegence: ");
		System.out.printf(formatDie, die1, die2, die3 + " \n");
		charInt = die1 + die2 + die3;
		System.out.println("Sum: " + charInt);
		
		if(charInt > charStr) {
			System.out.println("\nYour character is an Elf.\n");
		} else {
			System.out.println("\nYour character is a Dwarf.\n");
		}
		
		// Roll the stats for the second character
		die1 = (int)(Math.random()*5) + 1;
		die2 = (int)(Math.random()*5) + 1;
		die3 = (int)(Math.random()*5) + 1;
		
		System.out.print("Strength: ");
		System.out.printf(formatDie, die1, die2, die3 + " \n");
		charStr = die1 + die2 + die3;
		System.out.println("Sum: " + charStr);
		
		die1 = (int)(Math.random()*5) + 1;
		die2 = (int)(Math.random()*5) + 1;
		die3 = (int)(Math.random()*5) + 1;
		
		System.out.print("Intellegence: ");
		System.out.printf(formatDie, die1, die2, die3 + " \n");
		charInt = die1 + die2 + die3;
		System.out.println("Sum: " + charInt);
		
		if(charInt > charStr) {
			System.out.println("\nYour character is an Elf.");
		} else {
			System.out.println("\nYour character is a Dwarf.");
		}
		
	}

}

