package students;

import students.items.Item;
import students.items.Soil;

public class Field {
	
	public Field(int height, int width){
		
		Item[][] field = new Item[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = new Soil();
			}
		}
	}
	
	
	public void tick() {
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
				if (this.field[i][j])
				
				
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
