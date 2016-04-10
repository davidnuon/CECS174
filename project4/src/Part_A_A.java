/*  Name: David Nuon
    Date: 2/20/2012
    Program:  Project 4
    Description: A program that takes in an integer representing a student’s exam score 
				 and then outputs the corresponding letter grade (A: If statements only)
*/

import java.util.Scanner;

public class Part_A_A {
	public static void main(String[] args) {
		
		// Make space for values
		Scanner in = new Scanner(System.in);
		int grade;
		
		System.out.print("Please enter an Exam score: ");
		grade = in.nextInt();
		
		// Checking for the grade.
		if (grade >= 90) {
			System.out.println("This student received an 'A'.");	
		}
		
		if (grade >= 80 && grade <= 89) {
			System.out.println("This student received an 'B'.");	
		}		
		
		if (grade >= 70 && grade <= 79) {
			System.out.println("This student received an 'C'.");	
		}
		
		if (grade >= 60 && grade <= 69) {
			System.out.println("This student received an 'D'.");	
		}
		
		if (grade <= 59) {
			System.out.println("This student received an 'F'.");	
		}
	}

}
