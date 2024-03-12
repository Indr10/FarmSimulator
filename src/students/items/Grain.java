package students.items;

public class Grain extends Food{
	
	private static int instanceCount = 0;

	public Grain(int maturationAge, int deathAge, int monetaryValue) {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
		instanceCount++;
	}
	
	final static int MATURATION_AGE = 2;
	final static int DEATH_AGE = 6;
	final static int MONETARY_VALUE = 2;
	
	public static int getGenerationCount() {
		
		return instanceCount;
	}
	
	public char representingLetter() {
		
		if (this.age < this.maturationAge) {
			return 'g';
		}
		else {
			return 'G';
		}
		
	}
}
