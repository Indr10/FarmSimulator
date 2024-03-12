package students.items;

public class Apples extends Food{
	
	private static int instanceCount = 0;

	public Apples(int maturationAge, int deathAge, int monetaryValue) {
		super(maturationAge, deathAge, monetaryValue);
		
		instanceCount++;
	}
	
	final static int MATURATION_AGE = 3;
	final static int DEATH_AGE = 5;
	final static int MONETARY_VALUE = 3;
	
	public static int getGenerationCount() {
		
		return instanceCount;
	}
	
	public char representingLetter() {
		
		if (this.age < this.maturationAge) {
			return 'a';
		}
		else {
			return 'A';
		}
	}
}
