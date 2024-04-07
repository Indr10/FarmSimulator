package ShopImplementation;

import students.Field;
import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;

/**
 * Represents a shop item for harvesting all mature crops in the farm.
 */
public class HarvestAll extends Shop{
	
	private static final String NAME = "Harvest all"; // Name of the harvest all item
	private static final String EFFECT = "All mature crops in the farm have been harvested"; // Effect of the harvest all item
	private static final int COST = 5; // Cost of the harvest all item
	private static int HARVEST_VALUE = 0; // Total value of the harvested crops
	Field field; 

	/**
	 * Constructs a new HarvestAll object with predefined name, cost, and effect.
	 */
	public HarvestAll() {
		super(NAME, COST, EFFECT);
		
	}
	
	/**
	 * Harvests all mature crops in the field, replacing them with soil.
	 * @param field The field containing the crops to be harvested.
	 */
	public void harvestAll(Field field) {
		
		// iterate through the field
		for (int i = 0; i < field.getHeight(); i++) {
			for (int j = 0; j < field.getWidth(); j++) {
				
				// create a copy of the item at field location
				Item harvestedItem = field.get(i, j);
				
				// check if its apple or grain
				if (harvestedItem instanceof Apples || harvestedItem instanceof Grain) {
					
					// get the value of the crop at location
					HARVEST_VALUE += harvestedItem.getValue();	
				
					// replace crop with soil
					field.plant(i, j, new Soil());}
			}
		}
		// Prints information about the usage and effect of the harvest all		
		System.out.println("You used " + NAME + "\n" + EFFECT+ "\n");
	}
	
	/**
	 * Gets the total value of the harvested crops.
	 * @return The total value of the harvested crops.
	 */
	public static int getHarvestValue() {
		return HARVEST_VALUE;
	}
	
	/**
	 * gets the cost of the harvest all item.
	 * @return The cost of the harvest all item.
	 */
	public static int getCost() {
		return COST;
	}
	
}
