package students.items;

public class UntilledSoil extends Item{

	private final static int MATURATION_AGE = Integer.MAX_VALUE;
	private final static int DEATH_AGE = Integer.MAX_VALUE;
	private final static int MONETARY_VALUE = -1;
	
	public UntilledSoil() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
	}

	@Override
	public String toString() {
		return "/";
	}

	public UntilledSoil(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
		
	}
	
	@Override
	public UntilledSoil copyCons() {
		
		return new UntilledSoil(this);
	}
}
