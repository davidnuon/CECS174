import java.util.Scanner;

/*  Name: David Nuon
    Date: 4/8/2012
    Program:  Project 10
Description: Virtual Pet Dinosaur using
				 Daan Leiva's dinosaur class
*/



public class PartA {

	public static void main(String[] args) {
		boolean running = true;
		dinosaur dinoPet;		

		paintDino();
		dinoPet = setupDino();
		
		while(running) {
			running = programLoop(dinoPet);
		}
		
		System.out.println("Done.");
	}

	// Utility Methods	
	// Setup for a new dino
	
	public static dinosaur setupDino() {
		Scanner in = new Scanner(System.in);
		// Setup for the pet
		String name;
		int gender;
		
		dinosaur dinoPet;
		
		// Get the gender of the dinosaur
		gender = promptIntInRange("Please enter your pets gender, 0 for male, 1 for female:", 0, 1);
		
		// Get he name of the dinosaur
		System.out.print("Please enter the name of your dinosaur: ");
		name = in.next();		
		
		// Make the dinosaur
		return new dinosaur(gender, name);
	}
	
	// Prints out a nice image of a Pterodactyl
	public static void paintDino() {
		System.out.println("");
		System.out.println("                                 <\\             _");
		System.out.println("                                  \\          _/{");
		System.out.println("                           _       \\       _-   -_");
		System.out.println("                         /{        / `\\   _-     - -_");
		System.out.println("                       _~  =      ( @  \\ -        -  -_");
		System.out.println("                     _- -   ~-_   \\( =\\ \\           -  -_");
		System.out.println("                   _~  -       ~_ | 1 :\\ \\      _-~-_ -  -_");
		System.out.println("                 _-   -          ~  |V: \\ \\  _-~     ~-_-  -_");
		System.out.println("              _-~   -            /  | :  \\ \\            ~-_- -_");
		System.out.println("           _-~    -   _.._      {   | : _-``               ~- _-_");
		System.out.println("        _-~   -__..--~    ~-_  {   : \\:}");
		System.out.println("      =~__.--~~              ~-_\\  :  /");
		System.out.println("                                 \\ : /__");
		System.out.println("                                //`Y'--\\");
		System.out.println("                               <+       \\");
		System.out.println("                                \\      WWW     ");
		System.out.println("                                '");
		System.out.println("");
		
	}


	// Program Loop
	public static boolean programLoop(dinosaur dinoPet) {
		boolean running = true;
		int choice;
		System.out.println("");
		System.out.println("Virtual Dino");
		System.out.println("-------------------");
		System.out.println("1. Feed Dino");
		System.out.println("2. Ride Dino");
		System.out.println("3. Buff Dino");
		System.out.println("4. Bathe Dino");
		System.out.println("5. Train Dino");
		System.out.println("6. Attack Village");
		System.out.println("");
		System.out.println("7. Quit Virtual Dino");
		System.out.println("");
		
		choice = promptIntInRange("[1,7]: ", 1, 7);
		
		switch (choice) {
		case 1:
			feedDino(dinoPet);
			printStats(dinoPet);
			break;
		case 2:
			rideDino(dinoPet);
			printStats(dinoPet);
			break;
		case 3:
			buffDino(dinoPet);
			printStats(dinoPet);
			break;
		case 4:
			bathDino(dinoPet);
			printStats(dinoPet);
			break;
		case 5:
			trainDino(dinoPet);
			printStats(dinoPet);
			break;
		case 6:
			attackDino(dinoPet);
			printStats(dinoPet);
			break;

		case 7:
			running = false;
			break;

		default:
			break;
		}
		
		return running;
	}
	
	
	// Methods for the interaction events with the dinosaur

	// Have the dinosaur attack a village
	public static void attackDino(dinosaur dinoPet) {
		System.out.println("You command " + dinoPet.getName() + " to attack a nearby village.");
		System.out.println("After " + dinoPet.getName() + " feeds on the villagers");
		System.out.println("you notice that " + dinoPet.getName() + " is better at flying, but ");
		System.out.println("is now very dirty.");
		
		dinoPet.attackVillage();
	}

	// Train the dinosaur
	public static void trainDino(dinosaur dinoPet) {
		System.out.println("You train " + dinoPet.getName() + " for a day.");;
		System.out.println("You notice that " + dinoPet.getName() + " is stronger but");
		System.out.println("is now very hungry and dirty.");
		
		dinoPet.train();
	}

	// Bathe the dinosaur
	public static void bathDino(dinosaur dinoPet) {
		System.out.println("You bathe " + dinoPet.getName() + ".");
		System.out.println("You notice that " + dinoPet.getName() + " becomes more unhappy");
		System.out.println("and is less fire resistant.");
		
		dinoPet.bathe();
	}

	// Buff the dinosaur
	public static void buffDino(dinosaur dinoPet) {
		System.out.println("You groom and buff " + dinoPet.getName() + ".");;
		System.out.println("You notice that " + dinoPet.getName() + " becomes more happy");
		System.out.println("and is more fire resistant.");	
		
		dinoPet.reinforceSkin();
	}

	// Ride the dinosaur
	public static void rideDino(dinosaur dinoPet) {
		System.out.println("You ride " + dinoPet.getName() + ".");;
		System.out.println("You notice that " + dinoPet.getName() + " becomes more happy");
		System.out.println("but more tired in general and more hungry.");			
	
		dinoPet.ride();
	}

	// Feed the dinosaur
	public static void feedDino(dinosaur dinoPet) {
		System.out.println("You feed " + dinoPet.getName() + ".");;
		System.out.println("You notice that " + dinoPet.getName() + " made a mess");
		System.out.println("and is dirty.");
		
		dinoPet.feed();
	}
	
	
	/*
	 * 	Display the stats of the dino
	 *
	 */
	
	public static void printStats(dinosaur dinoPet) {
		System.out.println();

		printMeter("Strength", dinoPet.getStrength());
		printMeter("Fire Resistance", dinoPet.getFireResistance());
		printMeter("Flying Skill", dinoPet.getFlying());
		printMeter("Cleanliness", dinoPet.getCleanliness());
		printMeter("Happiness", dinoPet.getHappiness());
		printMeter("Hunger", dinoPet.getHunger());
	}
	
	// Helper method for displaying the meters
	
	public static void printMeter(String name, int stat) {
		String format = "%1$-15s +%2$-10s+\n";
		String statusBar = "";
		
		for(int i = 0; i != stat; i++) {
			statusBar += "-";
		}
		
		System.out.printf(format, name, statusBar);
		
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
