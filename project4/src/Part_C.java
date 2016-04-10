import java.util.Scanner;

/*  Name: David Nuon
    Date: 2/20/2012
    Program:  Project 4
    Description: A program that prompts the user to input a date and then 
    			 calculates what day of the week that date falls on.  
*/

public class Part_C {
	public static void main(String[] args) {
		// Make space for variables
		Scanner in = new Scanner(System.in);
		int month, day, year, 
			yearLastTwo, yearFirstTwo, weekDay, yearCalc;
		
		System.out.println("-- Day Calculator --");
		System.out.print("Please enter a date (MM DD YYYY): ");
		
		month = in.nextInt();
		day   = in.nextInt();
		year  = in.nextInt();
		yearCalc = year;
		
		// Change the month for Zeller's formula
		if (month == 1) { month = 13; yearCalc -= 1;}
		if (month == 2) { month = 14; yearCalc -= 1;}
		
		// Get the first and second half of the year
		yearLastTwo  = yearCalc % 100 % 1000;
		yearFirstTwo = (yearCalc - yearLastTwo)/100;
		weekDay = (day + (
				((month + 1)*26)/10 + yearLastTwo +
				yearLastTwo/4 + yearFirstTwo/4 - 2*yearFirstTwo
		)) % 7;
		
		if (weekDay < 0) { weekDay += 7; }
		
		System.out.print("Your date was ");
		
		// Day
		switch (weekDay) {
			case 0:
				System.out.print("Saturday, ");
				break;
			case 1:
				System.out.print("Sunday, ");
				break;
			case 2:
				System.out.print("Monday, ");
				break;
			case 3:
				System.out.print("Tuesday, ");
				break;
			case 4:
				System.out.print("Wednesday, ");
				break;
			case 5:
				System.out.print("Thursday, ");
				break;
			case 6:
				System.out.print("Friday, ");
				break;
			default:
				break;
		}
		
		// Month
		switch (month) {
			case 13:
				System.out.print("January ");
				break;
			case 14:
				System.out.print("February ");
				break;
			case 3:
				System.out.print("March ");
				break;
			case 4:
				System.out.print("April ");
				break;
			case 5:
				System.out.print("May ");
				break;
			case 6:
				System.out.print("June ");
				break;
			case 7:
				System.out.print("July ");
				break;
			case 8:
				System.out.print("August ");
				break;
			case 9:
				System.out.print("September ");
				break;
			case 10:
				System.out.print("October ");
				break;
			case 11:
				System.out.print("November ");
				break;
			case 12:
				System.out.print("December ");
				break;
			default:
				break;
		}
		
		System.out.print(day + ", " + year);
	}

}
