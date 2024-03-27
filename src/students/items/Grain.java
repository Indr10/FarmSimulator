package students.items;

public class Grain extends Food{
	
	private static int instanceCount = 0;

	private final static int MATURATION_AGE = 2;
	private final static int DEATH_AGE = 6;
	private final static int MONETARY_VALUE = 2;
	private final static int COST = 1;
	
	public Grain() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
		instanceCount++;
	}
	
	public static int getGenerationCount() {
		
		return instanceCount;
	}
	
	@Override
	public String toString() {
		if (age < maturationAge) {
			return "g";
		}
		else {
			return "G";
		}	
	}

	public static int getCost() {
		return COST;
	}

	public Grain(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
		
	}
	
	@Override
	public Grain copyCons() {
		
		return new Grain(this);
	}
}
