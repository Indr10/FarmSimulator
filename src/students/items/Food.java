package students.items;

public abstract class Food extends Item{

	// Constructor to initialize food items with default values
	public Food(int maturationAge, int deathAge, int monetaryValue) {
		super(maturationAge, deathAge, monetaryValue);
	}
	
	// Copy constructor to create a deep copy of a Food object
	public Food(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
	}
}
