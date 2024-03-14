package students;

import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.Weed;
import java.util.Random;

public class Field {
	
	int height;
	int width;
	
	Item[][] field = new Item[height][width];
	
			
	public Field(int height, int width){
		
		this.height = height;
		this.width = width;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = new Soil();
			}
		}
	}
	
	
	public void tick() {
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {	
				
				if (field[i][j] instanceof Grain || field[i][j] instanceof Apples) {
					field[i][j].tick();			
				}
				
				else if (field[i][j] instanceof Soil) {
					
					Random rand = new Random();
					
					int weedChance = rand.nextInt(10);
					
					if (weedChance <=2 ) {
						
						field[i][j] = new Weed();
					}
				}
			}			
		}
	}
	
	public void till(int row, int column) {
		
		
		// access field location
		// create a new instance of UntilledSoil
		
	}
	
	// get method
	
	public void plant(int row, int column) { // one more parameter representing the thing to plant
		
		
		
	}
	
	// getValue method
	
	// getSummary method
	
}
