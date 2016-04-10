/*  Name: David Nuon
    Date: 2/13/2012
    Program:  Project 3
    Description: A program that will calculate different aspects of a right triangle 
    given the lengths of the base and the height.
*/

import java.text.DecimalFormat;
import java.util.Scanner;


public class PartA {
	public static void main(String[] args) {
		// Make space for the values
		double base, height, hypotenuse, area, perimeter, 
			angleA, angleB, angleC;
		
		
		String format = "%1$5s = %2$-20s\n";
		DecimalFormat twoDForm = new DecimalFormat("0.000");
		Scanner in = new Scanner(System.in);
		
		System.out.println("-- Triangle Calculator --");
		System.out.print("Please enter the Base and Height of the triangle: ");
		
		base   = in.nextDouble();
		height = in.nextDouble();
		hypotenuse = Math.sqrt(Math.pow(base, 2.0) + Math.pow(height, 2.0));
		area   = (base*height)/2;
		perimeter = base + height + hypotenuse;
		
		angleA = Math.sin(Math.toRadians(height/hypotenuse));
		angleB = Math.sin(Math.toRadians(base/hypotenuse));
		angleC = 90.00;
		
		System.out.printf(format, twoDForm.format(base), "Base");
		System.out.printf(format, twoDForm.format(height), "Height");
		System.out.printf(format, twoDForm.format(hypotenuse), "Hypotenuse");
		System.out.printf(format, twoDForm.format(angleA), "Angle A");
		System.out.printf(format, twoDForm.format(angleB), "Angle B");
		System.out.printf(format, twoDForm.format(angleC), "Angle C");
		System.out.printf(format, twoDForm.format(area), "Area");
		System.out.printf(format, twoDForm.format(perimeter), "Perimeter");

	}

}

