package students.items;

public class Apples extends Food{
	
	private static int instanceCount = 0;

	final static int MATURATION_AGE = 3;
	final static int DEATH_AGE = 5;
	private final static int MONETARY_VALUE = 3;
	
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


	public static int getMonetaryValue() {
		return MONETARY_VALUE;
	}
}
