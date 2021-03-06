/*  Name: David Nuon
    Date: 2/20/2012
    Program:  Project 4
    Description: A program that takes in an integer representing a studentís exam score 
				 and then outputs the corresponding letter grade (C: else if statements)
*/

import java.util.Scanner;

public class Part_A_C {
	public static void main(String[] args) {
		
		// Make space for values
		Scanner in = new Scanner(System.in);
		int grade;
		
		System.out.print("Please enter an Exam score: ");
		grade = in.nextInt();
		
		// Checking for the grade.
		if (grade >= 90) {
			System.out.println("This student received an 'A'.");	
		} else if (grade >= 80 && grade <= 89) {
			System.out.println("This student received an 'B'.");	
		} else if (grade >= 70 && grade <= 79) {
			System.out.println("This student received an 'C'.");	
		} else if (grade >= 60 && grade <= 69) {
			System.out.println("This student received an 'D'.");	
		} else if (grade <= 59) {
			System.out.println("This student received an 'F'.");	
		}
	}

}
