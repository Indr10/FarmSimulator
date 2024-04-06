package students.items;

public class Apples extends Food{
	
	// Variable to count the number of instances of Apples
	private static int instanceCount = 0;

	// FINAL Apples attributes declaration
	private static int MATURATION_AGE = 3;
	private static int DEATH_AGE = 5;
	private static int MONETARY_VALUE = 3;
	private final static int COST = 2;
	
	// Constructor to initialize Apples with default values and increment instance count
	public Apples() {
		super(MATURATION_AGE, DEATH_AGE, MONETARY_VALUE);
		
		instanceCount++;
	}
	
	// Gets the count of instances of Apples created
	public static int getGenerationCount() {
		
		return instanceCount;
	}

	// Override the toString() method to show the visual representation of Apples based on its age
	@Override
	public String toString() {
		if (age < maturationAge) {
			return "a"; // not mature
		}
		else {
			return "A"; // mature
		}
	}

	// Get the cost of Apples
	public static int getCost() {
		return COST;
	}
	
	// Copy constructor to create a deep copy of an Apples object
	public Apples(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
		
	;
	}
	
	// Override the copyCons() method to return a deep copy of the Apples object
	@Override
	public Apples copyCons() {
		
		return new Apples(this); // Deep copy of Apples object
	}
	
	public static int getMATURATION_AGE() {
        return MATURATION_AGE;
    }

    public static int getDEATH_AGE() {
        return DEATH_AGE;
    }

    public static int getMONETARY_VALUE() {
        return MONETARY_VALUE;
    }

    public static void setMATURATION_AGE(int maturationAge) {
        MATURATION_AGE = maturationAge;
    }

    public static void setDEATH_AGE(int deathAge) {
        DEATH_AGE = deathAge;
    }

    public static void setMONETARY_VALUE(int monetaryValue) {
        MONETARY_VALUE = monetaryValue;
    }

		
}
