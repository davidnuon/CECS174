/*  Name: David Nuon
    Date: 2/20/2012
    Program:  Project 4
    Description: A program that uses Nested If Statements to determine and calculate the user’s 
    			 California income tax bracket and tax amount.
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class Part_B {
	public static void main(String[] args) {
		
		// Make space for variables
		Scanner in = new Scanner(System.in);
		DecimalFormat money = new DecimalFormat("$###,###,###.00");
		DecimalFormat figure = new DecimalFormat("###.##%");
		
		int income;
		
		// Amounts of income used for the brackets
		int tier1, tier2, tier3, tier4, tier5;
		tier1 = 8700;
		tier2 = 35350;
		tier3 = 85650;
		tier4 = 178650;
		tier5 = 388350;
		
		double tax = 0;
		
		System.out.print("Please enter your income amount: ");
		income = in.nextInt();
		
		
		// Calulate the rates
		if(income > 0) {
			tax += tier1 * 0.1;
			
			if(income >= tier1) {
				if (income < tier2) {
					tax += (income - tier1)*.15;
				} else {
					tax += (tier2 - tier1)*.15;
				}
			}
			
			if(income >= tier2) {
				if (income < tier3) {
					tax += (income - tier2)*.25;
				} else {
					tax += (tier3 - tier2)*.25;
				}
			}
			
			if(income >= tier3) {
				if (income < tier4) {
					tax += (income - tier3)*.28;
				} else {
					tax += (tier4 - tier3)*.28;	
				}
			}
			
			if(income >= tier4) {
				if (income < tier5) {
					tax += (income - tier4)*.33;
				} else {
					tax += (tier5 - tier4)*.33;	
				}
			}
			
			if(income > tier5) {
				tax += (income - tier5)*.35;	
			}
		}
		
		System.out.println("Tax = " + money.format(tax));
		System.out.println("Effective Tax Rate = " + figure.format(tax/income));
	}

}
