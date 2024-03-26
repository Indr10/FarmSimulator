package students.items;

public class Soil extends Item{
	
	final static int MATURATION_AGE = Integer.MAX_VALUE;
	final static int DEATH_AGE = Integer.MAX_VALUE;
	final static int MONETARY_VALUE = 0;
	
	public Soil() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
	}

	@Override
	public String toString() {
		return ".";
	}


	public Soil(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
		
	}
	
	@Override
	public Soil copyCons() {
		
		return new Soil(this);
	}
}
