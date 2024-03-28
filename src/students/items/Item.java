	package students.items;
	
	public abstract class Item{
		
		public int age;
		protected int maturationAge;
		protected int deathAge;
		protected int monetaryValue;	
		
		public Item(int maturationAge, int deathAge, int monetaryValue) {
			this.age = 0;
			this.maturationAge = maturationAge;
			this.deathAge = deathAge;
			this.monetaryValue = monetaryValue;
			
		}
		
		public void tick() {
			age++;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public boolean died() {
			return age > deathAge;
		}
		
		public int getValue() {
			
			if (age >= maturationAge) {
				return monetaryValue;
			}
			
			else if (this instanceof Weed) {
				
				return monetaryValue;
			}
					
			else {
				return 0;
			}
			
		}
		
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
		
		public abstract String toString();
		
		public Item(Item someItem) {
			this.age = someItem.age;
			this.deathAge = someItem.deathAge;
			this.maturationAge = someItem.maturationAge;
			this.monetaryValue = someItem.monetaryValue;
		}
		
		public abstract Item copyCons();		
	}
