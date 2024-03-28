package students.items;

public class Weed extends Item{
	
	private final static int MATURATION_AGE = Integer.MAX_VALUE;
	private final static int DEATH_AGE = Integer.MAX_VALUE;
	private final static int MONETARY_VALUE = -1;
	
	public Weed() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
	}

	@Override
	public String toString() {
		return "#";
	}

	public static int getMonetaryValue() {
		
		return 0;
	}

	public Weed(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.monetaryValue = someItem.monetaryValue;
		
	}
	
	@Override
	public Weed copyCons() {
		
		return new Weed(this);
	}
}
