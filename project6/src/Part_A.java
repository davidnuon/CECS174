/*  Name: David Nuon
    Date: 3/5/2012
    Program:  Project 6
    Description: Create a program that has a menu in a loop where the user can choose to display 
				 one of the following four triangles, or to exit the program.      
*/

import java.util.Scanner;

public class Part_A {
	public static void main(String[] args) {
		// Make space for variables
		Scanner in = new Scanner(System.in);
		int triangleType = 0, triangleSize = 0;
		
		String invalidPrompt, miscInput = "";
		invalidPrompt = "Enter a vaild choice. \n\n";
		boolean running, triangle;
		
		running     = true;
		triangle    = false;
		
		// Program Loop
		while(running) {
			System.out.println("Menu:");
			System.out.println("1. Triangle 1");
			System.out.println("2. Triangle 2");
			System.out.println("3. Triangle 3");
			System.out.println("4. Triangle 4");
			System.out.println("5. Quit");
			
			if(in.hasNextInt()) {
				triangleType = in.nextInt();
				if (triangleType <= 0 || triangleType > 5) {
					System.out.print(invalidPrompt);
				} else if (triangleType == 5){
					running = false;
				} else {
					triangle = true;
				}
			} else {
				System.out.print(invalidPrompt);
				miscInput = in.next();
			}
			
			// Prompt user for triangle parameters
			while(triangle) {
				System.out.print("Enter size of triangle: ");
				if(in.hasNextInt()) {
					triangleSize = in.nextInt();
					
					// Top Left
					if(triangleType == 1) {
						for(int vert = triangleSize - 1; vert >= 0; vert--) {
							for(int horiz = 0; horiz <= vert; horiz++ ) {
								System.out.print('*');
							}
							System.out.println();
						}
					}
					
					// Top Right
					if(triangleType == 2) {
						for(int vert = triangleSize - 1; vert >= 0; vert--) {
							// During the loop also draw the margin
							for(int horiz = triangleSize - vert; horiz >= 2 ; horiz-- ) {
								System.out.print(' ');
							}
							
							for(int horiz = vert; horiz >= 0 ; horiz-- ) {
								System.out.print('*');
							}
							
							System.out.println();
						}
					}
					
					
					// Bottom Left
					if(triangleType == 3) {
						for(int vert = 0; vert <= triangleSize - 1; vert++) {
							for(int horiz = vert; horiz >= 0 ; horiz-- ) {
								System.out.print('*');
							}
							System.out.println();
						}
					}
					
					
					// Bottom Right
					if(triangleType == 4) {
						for(int vert = 0; vert <= triangleSize - 1; vert++) {
							
							// During the loop also draw the margin
							for(int horiz = triangleSize - vert; horiz >= 2 ; horiz-- ) {
								System.out.print(' ');
							}
							
							for(int horiz = vert; horiz >= 0 ; horiz-- ) {
								System.out.print('*');
							}
							
							System.out.println();
						}
					}
					
					triangle = false;
				} else {
					System.out.print(invalidPrompt);
					miscInput = in.next();
				}
			}
		}
			
		System.out.println("Done.");
	}
}