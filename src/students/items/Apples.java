package students.items;

public class Apples extends Food{
	
	private static int instanceCount = 0;

	final static int MATURATION_AGE = 3;
	final static int DEATH_AGE = 5;
	final static int MONETARY_VALUE = 3;
	private final static int COST = 2;
	
	
	public Apples() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
		instanceCount++;
	}
	
	
	public static int getGenerationCount() {
		
		return instanceCount;
	}

	@Override
	public String toString() {
		if (age < maturationAge) {
			return "a";
		}
		else {
			return "A";
		}
	}

	public static int getCost() {
		return COST;
	}
	
	
	public Apples(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
		
	;
	}
	
	@Override
	public Apples copyCons() {
		
		return new Apples(this);
	}
		
}
