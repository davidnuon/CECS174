/*Daan I Leiva
 * Project 10
 * April 17, 2012
 * This program creates a pet dinosaur
 */
public class dinosaur {

	private int gender;
	private String name;
	private int cleanliness;
	private int fireResistance;
	private int strength;
	private int happiness;
	private int flying;
	private int age;
	private int hunger;

	public dinosaur(int x, String y){
		// All the possible characteristics
		gender = x;
		name = y;
		age = 0;
		cleanliness = 8;
		fireResistance = 5;
		strength = 3;
		happiness = 3;
		flying = 3;
		hunger = 0;
	}
	public String getGender(){ // Returns Gender
		String wrGender = null;
		if(gender == 0){  
				wrGender = "male";	
		} else {
			wrGender = "female";
		}
		return wrGender;
	}
	public String getName(){ // Returns Name
		return name;
	}
	public int getCleanliness(){ // Returns Cleanliness
		return cleanliness;
	}
	public int getFireResistance(){ // Returns Fire Resistance
		return fireResistance;
	}
	public int getStrength(){ // Returns Strength
		return strength;
	}
	public int getHappiness(){ // Returns Happiness
		return happiness;
	}
	public int getFlying(){ // Returns Flying Level
		return flying;
	}
	public int getAge(){ // Returns dinosour's age
		return age;
	}
	public int getHunger(){ // Returns hunger level
		return hunger;
	}
	public void age(){ // Ages your pet 1 years
		age++;
	}
	public void feed(){ // Feeds your pet
		happiness += 2;
		flying -=1;
		cleanliness -=2;
		hunger = 0;
		strength += 1;
		check();
	}
	public void ride(){ // Take your dinosour for a ride(flight!)!
		flying += 2;
		strength -=2;
		hunger +=2;
		happiness +=2;
		check();
	}
	public void bathe(){ // Bathe your pet
		cleanliness = 10;
		happiness -= 3;
		fireResistance -= 3;
		check();
	}
	public void train(){ // Train your pet
		strength += 5;
		flying +=4;
		hunger +=4;
		check();
	}
	public void attackVillage(){ // Attack a village
		strength -= 4;
		flying += 2;
		hunger -= 3;
		cleanliness -= 3;
		check();
	}
	public void reinforceSkin(){ // Reinforce your pet's skin
		happiness += 2;
		fireResistance += 5;
		check();
	}
	public void check(){ // checks that stats don't go out of range
		if(cleanliness > 10){
			cleanliness = 10;
		}
		if(fireResistance > 10){
			fireResistance = 10;
		}
		if(strength > 10){
			strength = 10;
		}
		if(happiness > 10){
			happiness = 10;
		}
		if(flying > 10){
			flying = 10;
		}
		if(hunger > 10){
			hunger = 10;
		}
		if(cleanliness < 0){
			cleanliness = 0;
		}
		if(fireResistance < 0){
			fireResistance = 0;
		}
		if(strength < 0){
			strength = 0;
		}
		if(happiness < 0){
			happiness = 0;
		}
		if(flying < 0){
			flying = 0;
		}
		if(hunger < 0){
			hunger = 0;
		}	
	}
}
