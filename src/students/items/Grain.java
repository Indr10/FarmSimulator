package students.items;

public class Grain extends Food{
	
	private static int instanceCount = 0;

	final static int MATURATION_AGE = 2;
	final static int DEATH_AGE = 6;
	final static int MONETARY_VALUE = 2;
	
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
}
