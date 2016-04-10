/*  Name: David Nuon
    Program:  Dice Class
	Description: A class that represents an 6-sided die
*/

public class Dice {
	private final int MAX = 6;
	private int diceVal;
	
	public Dice() {
		diceVal = 1;
	}
	
	public int roll() {
		diceVal = (int)(Math.random() * MAX) + 1;
		return diceVal;
	}
	
	public int getDiceVal() {
		return diceVal;
	}
	
	public void setDiceVal( int value ){
		if ( value > 0 && value <= MAX ){
			diceVal = value;
		} else {
			diceVal = 1;
		}
	}
}
