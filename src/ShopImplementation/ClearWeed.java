package ShopImplementation;

import students.Field;
import students.items.Soil;
import students.items.Weed;

public class ClearWeed extends Shop{
	
	private static final String NAME = "Clear Weed";
	private static final String EFFECT = "All weeds on the farm have been removed";
	private static final int COST = 10;
	Field field;

	public ClearWeed() {
		super(NAME, COST, EFFECT);
		
	}
	
	public void clear (Field field) {
		
		for (int i = 0; i < field.getHeight(); i++) {
			for (int j = 0; j < field.getWidth(); j++) {
				if (field.get(i, j) instanceof Weed) {
					field.plant(i, j, new Soil());
				}
			}
		}
		
		System.out.println("You used " + NAME + "\n" + EFFECT + "\n");
		
	}

	public static int getCost() {
		return COST;
	}
}
