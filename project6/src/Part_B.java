/*  Name: David Nuon
    Date: 3/5/2012
    Program:  Project 6
    Description: Display a menu to the user to allow them to choose to 
				 display a set of Triangular Numbers, Square Numbers, Fibonacci Numbers, or Prime 
				 Numbers.     
*/

import java.util.Scanner;

public class Part_B {
	public static void main(String[] args) {
		// Make space for variables
		Scanner in = new Scanner(System.in);
		int calculationType = 0, numberRange = 0;
		
		String invalidPrompt, miscInput = "";
		invalidPrompt = "Enter a vaild choice. \n\n";
		boolean running, calculationMode;
		
		running     = true;
		calculationMode    = false;
		
		// Program Loop
		while(running) {
			System.out.println("Menu:");
			System.out.println("1. Triangular Numbers");
			System.out.println("2. Square Numbers");
			System.out.println("3. Fibonacci Numbers");
			System.out.println("4. Prime Numbers");
			System.out.println("5. Quit");
			
			if(in.hasNextInt()) {
				calculationType = in.nextInt();
				if (calculationType <= 0 || calculationType > 5) {
					System.out.print(invalidPrompt);
				} else if (calculationType == 5){
					running = false;
				} else {
					calculationMode = true;
				}
			} else {
				System.out.print(invalidPrompt);
				miscInput = in.next();
			}
			
			// Prompt user for range of calculation
			while(calculationMode) {
				System.out.print("Enter the number of calculations: ");
				if(in.hasNextInt()) {
					numberRange = in.nextInt();
					
					// Triangular Numbers					
					if(calculationType == 1) {
						for(int n = 1; n <= numberRange; n++) {

							number = (n(n+1))/2;
							System.out.print(number);
						
							if(n % 5 == 0) {
								System.out.println();
							} else {
								System.out.print(", ");
							}
						}
						System.out.println();
					}
					
					// Square Numbers
					if(calculationType == 2) {
						for(int n = 1; n <= numberRange; n++) {
							System.out.print(n*n);
						
							if(n % 5 == 0) {
								System.out.println();
							} else {
								System.out.print(", ");
							}
						}
						System.out.println();
					}
					
					
					// Fibonacci Numbers
					if(calculationType == 3) {
						for(int n = 1; n <= numberRange; n++) {					
							int prev = -1, number = 1, sum;
							
							for(int i = 0; i <= n; i++) {
								sum = number + prev;
								prev = number;
								number = sum;
							}
							
							System.out.print(number);
							
							if(n % 5 == 0) {
								System.out.println();
							} else {
								System.out.print(", ");
							}
						}
						System.out.println();
					}
					
					
					// Prime Numbers
					if(calculationType == 4) {
						int number = 2;
						int count  = 1;
						while(count < numberRange + 1) {
							int     mod   = 2;
							boolean prime = true;
							boolean calulating = true; 
							
							while(calulating) {
								if(number == 2) {
									calulating = false;
									prime      = true;
								} else {
									for(int divisor = 2; divisor <= number - 1; divisor++) {
										if(number % divisor == 0) {
											calulating = false;
											prime      = false;
										}
									}
								}
								calulating = false;
							}
							
							if(prime) {
								System.out.print(number);
								if(count % 5 == 0) {
									System.out.println();
								} else {
									System.out.print(", ");
								}
								count++;
							}
							number++;
						}
						System.out.println();
					}
					
					calculationMode = false;
				} else {
					System.out.print(invalidPrompt);
					miscInput = in.next();
				}
			}
		}
			
		System.out.println("Done.");
	}
}