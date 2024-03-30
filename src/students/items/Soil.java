package students.items;

public class Soil extends Item{
	
	// FINAL Soil attributes declaration
	private final static int MATURATION_AGE = Integer.MAX_VALUE;
	private final static int DEATH_AGE = Integer.MAX_VALUE;
	private final static int MONETARY_VALUE = 0;
	
	// Constructor to initialize Soil with default values
	public Soil() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
	}

	// Override the toString() method to show the visual representation of Soil
	@Override
	public String toString() {
		return ".";
	}

	// Copy constructor to create a deep copy of a Soil object
	public Soil(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.monetaryValue = someItem.monetaryValue;
	}
	
	// Override the copyCons() method to return a deep copy of the Soil object
	@Override
	public Soil copyCons() {
		
		return new Soil(this);
	}
}
