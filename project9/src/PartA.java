/*  Name: David Nuon
    Date: 4/8/2012
    Program:  Project 9
	Description: A program that will let the user draw rectangles.
*/


import java.util.Scanner;
import java.awt.Rectangle;

public class PartA {
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		final int BOARD_SIZE = 30;
		
		// Make room for the canvas and fill it with blanks
		char [][] canvas;
		canvas = new char[BOARD_SIZE][BOARD_SIZE];
		
		for(int rows = 0; rows < BOARD_SIZE; rows++) {
			for(int cols = 0; cols < BOARD_SIZE; cols++) {
				canvas[rows][cols] = ' ';
			}
		}
		
		// Make room for the rectangles
		Rectangle [] allRectangles;
		
		// Get the list of the rectangles the user wants to draw
		int userNumRects = promptIntInRange("How many rectangles would you like to draw (1-5)? ", 1, 5);
		allRectangles = new Rectangle[userNumRects];
		getRectangles(allRectangles, userNumRects, BOARD_SIZE);
		drawCanvas(allRectangles, canvas, userNumRects, BOARD_SIZE);
	}
	
	
	/*
	 *  Gets the number of rectangles the user wants to draw. Also checks for errors.
	 */
	
	public static void getRectangles(Rectangle[] allRectangles, int numRects, int BOARD_SIZE) {
		int adjustSize = BOARD_SIZE - 1;
		for(int i = 0; i < numRects; i++) {
			int xpos =   promptIntInRange("Please enter x location of rectangle " + (i+1) +": ", 0, adjustSize);
			int ypos =   promptIntInRange("Please enter y location of rectangle " + (i+1) +": ", 0, adjustSize);
			int maxWidth  = adjustSize - xpos == 0 ? 1 : adjustSize - xpos;
			int maxHeight = adjustSize - ypos == 0 ? 1 : adjustSize - ypos;
			
			int width =  promptIntInRange("Please enter width of rectangle " + (i+1) +": ", 1, maxWidth );
			int height = promptIntInRange("Please enter height of rectangle  " + (i+1) +": ", 1, maxHeight);
			
			allRectangles[i] = new Rectangle(xpos, ypos, width, height);
		}
	}
	
	/*
	 *  Draws the board
	 */
	
	public static void drawCanvas(Rectangle[] allRectangles, char[][] board, int numRects, int BOARD_SIZE) {
		String points = "*+,X:";

		for(int rect = 0; rect < numRects; rect++) {
			
			char paint = points.charAt(rect);
			int x      = (int)allRectangles[rect].getX();
			int y      = (int)allRectangles[rect].getY();
			int width  = (int)allRectangles[rect].getWidth();
			int height = (int)allRectangles[rect].getHeight();
			
			for(int ypaint = y; ypaint < y + height; ypaint++) {
				for(int xpaint = x; xpaint < x + width; xpaint++) {
					board[ypaint][xpaint] = paint;
				}
			}
			
		}
		
		for(int rows = 0; rows < BOARD_SIZE; rows++) {
			for(int cols = 0; cols < BOARD_SIZE; cols++) {
				System.out.print(board[rows][cols]);
			}
			System.out.println();
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
