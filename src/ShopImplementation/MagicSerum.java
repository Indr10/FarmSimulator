package ShopImplementation;

import students.items.Grain;
import students.items.Apples;

/**
 * Represents a magic serum item that enhances crop properties in the shop.
 */
public class MagicSerum extends Shop{
	
	private static final String NAME = "Magic Serum"; // Name of the magic serum
	
	private static final String EFFECT = "Maturation age of all crops have been reduced by 1\n"
										+ "Sell value of all crops have been increased by 1 \n" // Effect of the magic serum on crops
										+ "Death age of all crops have been reduced by 1"; 
	private static final int COST = 10; // Cost of the magic serum
	
	/**
	 * Constructs a new MagicSerum object with predefined name, cost, and effect.
	 */
	public MagicSerum() {
		super(NAME, COST, EFFECT);
		
	}
	
	/**
	 * Applies the magic serum effect on crops by adjusting their properties.
	 */
	public void magicSerum() {
		
		// Decreases maturation age of apples and grain by 1
		Apples.setMATURATION_AGE(Apples.getMATURATION_AGE() - 1);
		Grain.setMATURATION_AGE(Grain.getMATURATION_AGE() - 1);
		
		// Decreases death age of apples and grain by 1	
		Apples.setDEATH_AGE(Apples.getDEATH_AGE() - 1);
		Grain.setDEATH_AGE(Grain.getDEATH_AGE() - 1);

		// Increases monetary value of apples and grain by 1
		Apples.setMONETARY_VALUE(Apples.getMONETARY_VALUE() + 1);
		Grain.setMONETARY_VALUE(Grain.getMONETARY_VALUE() + 1);
		
		// Prints information about the usage and effect of the magic serum		
		System.out.println("You used " + NAME + "\n" + EFFECT+ "\n");

	}
	
	/**
	 * Gets the cost of the magic serum.
	 * @return The cost of the magic serum.
	 */
	public static int getCost() {
		return COST;
	}
}
