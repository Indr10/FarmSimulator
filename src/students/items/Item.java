	package students.items;
	
	public abstract class Item{
		
		// Item attributes declaration
		protected int age;
		protected int maturationAge;
		protected int deathAge;
		protected int monetaryValue;	
		
		// Constructor to initialize item with its attributes
		public Item(int maturationAge, int deathAge, int monetaryValue) {
			this.age = 0;
			this.maturationAge = maturationAge;
			this.deathAge = deathAge;
			this.monetaryValue = monetaryValue;
			
		}
		
		// Increment the age of the item
		public void tick() {
			age++;
		}
		
		// Set the age of the item
		public void setAge(int age) {
			this.age = age;
		}
		
		// checks if the food item is dead or alive, returning true if dead
		public boolean died() {
			return age > deathAge;
		}
		
		// Get the monetary value of the item based on its age and type
		public int getValue() {
			
			if (age >= maturationAge) {
				return monetaryValue;
			}
			
			// Weed has infinite age and maturation age so it needs a specific condition
			else if (this instanceof Weed) {
				
				return monetaryValue;
			}
			
			// food item is not mature
			else {
				return 0;
			}
			
		}
		
		// Checks the current item to another object based on their properties, returns true if they are
		@Override
		public boolean equals (Object otherObj) {
			
			if (this.age == ((Item)otherObj).age
					&& this.deathAge == ((Item)otherObj).deathAge
					&& this.maturationAge == ((Item)otherObj).maturationAge
					&& this.monetaryValue == ((Item)otherObj).monetaryValue){
				
				return true;			
			}
			else {
				return false;
			}
		}
		
		// Abstract method that can be implemented by subclasses for their respective function
		public abstract String toString();
		
		// Copy constructor to create a deep copy of an Item object
		public Item(Item someItem) {
			this.age = someItem.age;
			this.deathAge = someItem.deathAge;
			this.maturationAge = someItem.maturationAge;
			this.monetaryValue = someItem.monetaryValue;
		}
		
		// Abstract method that is implemented by subclasses for creating a deep copy of an item
		public abstract Item copyCons();		
	}
