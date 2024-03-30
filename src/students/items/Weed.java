package students.items;

public class Weed extends Item{
	
	// FINAL Weed attributes declaration
	private final static int MATURATION_AGE = Integer.MAX_VALUE;
	private final static int DEATH_AGE = Integer.MAX_VALUE;
	private final static int MONETARY_VALUE = -1;
	
	// Constructor to initialize Weed with default values
	public Weed() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
	}

	// Override the toString() method to show the visual representation of Weed
	@Override
	public String toString() {
		return "#";
	}

	// Copy constructor to create a deep copy of a Weed object
	public Weed(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.monetaryValue = someItem.monetaryValue;
		
	}
	
	// Override the copyCons() method to return a deep copy of the Weed object
	@Override
	public Weed copyCons() {
		
		return new Weed(this);
	}
}
