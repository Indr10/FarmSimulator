package ShopImplementation;

import students.Field;
import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;

public class HarvestAll extends Shop{
	
	private static final String NAME = "Harvest all";
	private static final String EFFECT = "All mature crops in the farm have been harvested";
	private static final int COST = 5;
	private static int HARVEST_VALUE = 0;
	Field field;

	public HarvestAll() {
		super(NAME, COST, EFFECT);
		
	}
	
	public void harvestAll(Field field) {
		
		for (int i = 0; i < field.getHeight(); i++) {
			for (int j = 0; j < field.getWidth(); j++) {
				
				Item harvestedItem = field.get(i, j);
				if (harvestedItem instanceof Apples || harvestedItem instanceof Grain) {
					
					HARVEST_VALUE += harvestedItem.getValue();	
				
					field.plant(i, j, new Soil());}
			}
		}
		System.out.println("You used " + NAME + "\n" + EFFECT+ "\n");
	}
	
	public static int getHarvestValue() {
		return HARVEST_VALUE;
		
	}
	
	public static int getCost() {
		return COST;
	}
	
}
