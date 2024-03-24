package students.items;

public class UntilledSoil extends Item{

	final static int MATURATION_AGE = Integer.MAX_VALUE;
	final static int DEATH_AGE = Integer.MAX_VALUE;
	final static int MONETARY_VALUE = -1;
	
	public UntilledSoil() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
	}

	@Override
	public String toString() {
		return "/";
	}

	@Override
	public Item copyCons(Item someItem) {
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
		
		return this;
	}
}
