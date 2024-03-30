package students.items;

public class UntilledSoil extends Item{

	// FINAL UntilledSoil attributes declaration
	private final static int MATURATION_AGE = Integer.MAX_VALUE;
	private final static int DEATH_AGE = Integer.MAX_VALUE;
	private final static int MONETARY_VALUE = -1;
	
	// Constructor to initialize UntilledSoil with default values
	public UntilledSoil() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
	}

	// Override the toString() method to show the visual representation of UntilledSoil
	@Override
	public String toString() {
		return "/";
	}

	// Copy constructor to create a deep copy of a UntilledSoil object
	public UntilledSoil(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.monetaryValue = someItem.monetaryValue;
		
	}
	
	// Override the copyCons() method to return a deep copy of the UntilledSoil object
	@Override
	public UntilledSoil copyCons() {
		
		return new UntilledSoil(this);
	}
}
