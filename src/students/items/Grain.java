package students.items;

public class Grain extends Food{
	
	// Variable to count the number of instances of Grain
	private static int instanceCount = 0;

	// FINAL Grain attributes declaration
	private static int MATURATION_AGE = 2;
	private static int DEATH_AGE = 6;
	private static int MONETARY_VALUE = 2;
	private final static int COST = 1;
	
	// Constructor to initialize Grain with default values and increment instance count
	public Grain() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
		instanceCount++;
	}
	
	// Gets the count of instances of Grain created
	public static int getGenerationCount() {
		
		return instanceCount;
	}
	
	// Override the toString() method to show the visual representation of Grain based on its age
	@Override
	public String toString() {
		if (age < maturationAge) {
			return "g";
		}
		else {
			return "G";
		}	
	}

	// Get the cost of Apples
	public static int getCost() {
		return COST;
	}

	// Copy constructor to create a deep copy of a Grain object
	public Grain(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
		
	}
	
	// Override the copyCons() method to return a deep copy of the Grain object
	@Override
	public Grain copyCons() {
		
		return new Grain(this);
	}
}
