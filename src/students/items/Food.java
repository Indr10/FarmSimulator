package students.items;

public abstract class Food extends Item{

	public Food(int maturationAge, int deathAge, int monetaryValue) {
		super(maturationAge, deathAge, monetaryValue);
	}

	public Food(Item someItem) {
		super(someItem);
		
		this.age = someItem.age;
		this.deathAge = someItem.deathAge;
		this.maturationAge = someItem.maturationAge;
		this.monetaryValue = someItem.monetaryValue;
	}
	
	public int getValue() {
		if (age >= maturationAge) {
			return monetaryValue;
		}
				
		else {
			return 0;
		}
	}
	
}
