package ShopImplementation;

import students.Field;
import students.items.Soil;
import students.items.Weed;

/**
 * Represents a shop item for clearing weeds from the farm.
 */
public class ClearWeed extends Shop{
	
	private static final String NAME = "Clear Weed"; //  Name of the clear weed item
	private static final String EFFECT = "All weeds on the farm have been removed"; // // Effect of the clear weed item
	private static final int COST = 10; // // Cost of the clear weed item
	Field field;

	/**
	 * Constructs a new ClearWeed object with predefined name, cost, and effect.
	 */
	public ClearWeed() {
		super(NAME, COST, EFFECT);
		
	}
	
	/**
	 * Constructs a new ClearWeed object with predefined name, cost, and effect.
	 */
	public void clear (Field field) {
		
		// iterate through the field
		for (int i = 0; i < field.getHeight(); i++) {
			for (int j = 0; j < field.getWidth(); j++) {
				
				// check if the field location has weed
				if (field.get(i, j) instanceof Weed) {
					
					// replace weed with soil
					field.plant(i, j, new Soil());
				}
			}
		}
		
		// Prints information about the usage and effect of clear weed	
		System.out.println("You used " + NAME + "\n" + EFFECT + "\n");
		
	}
	/**
	 * Retrieves the cost of the clear weed item.
	 * @return The cost of the clear weed item.
	 */
	public static int getCost() {
		return COST;
	}
}
