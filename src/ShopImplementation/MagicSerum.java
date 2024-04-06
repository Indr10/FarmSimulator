package ShopImplementation;

import students.items.Grain;
import students.items.Apples;

public class MagicSerum extends Shop{
	
	private static final String NAME = "Magic Serum";
	private static final String EFFECT = "Maturation age of all crops have been reduced by 1\n"
										+ "Sell value of all crops have been increased by 1 \n"
										+ "Death age of all crops have been reduced by 1";
	private static final int COST = 10;
	
		public MagicSerum() {
		super(NAME, COST, EFFECT);
		
	}
		
	public void magicSerum() {
		
		
		Apples.setMATURATION_AGE(Apples.getMATURATION_AGE() - 1);
		
		Grain.setMATURATION_AGE(Grain.getMATURATION_AGE() - 1);
	
		Apples.setDEATH_AGE(Apples.getDEATH_AGE() - 1);
		
		Grain.setDEATH_AGE(Grain.getDEATH_AGE() - 1);

		Apples.setMONETARY_VALUE(Apples.getMONETARY_VALUE() + 1);
		
		Grain.setMONETARY_VALUE(Grain.getMONETARY_VALUE() + 1);
		
		System.out.println("You used " + NAME + "\n" + EFFECT+ "\n");

	}
	
	public static int getCost() {
		return COST;
	}
}
