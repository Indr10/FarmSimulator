package students;

import students.items.*;		
import java.util.Random;

public class Field {
	
	// Instance variables to store the height, width, and items in the field
	private int height;
	private int width;
	private Item [][] field;
	
	// Constructor to initialize the field with its height and width, filling it with Soil by default
	public Field(int height, int width){
		
		this.height = height;
		this.width = width;
		this.field = new Item[height][width];
		
		// iterate over the field to fill with Soil
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = new Soil();
			}
		}
	}
	
	// Override the toString() method to represent the field as a string
	@Override
	public String toString() {
		
		String fieldString = "   ";
		
		// displays the numbers on the x axis
		for (int i = 1; i <= field[0].length; i++) {
			fieldString += i + " ";
		}
		
		fieldString += "\n";
		
		// iterates over the field to display instances in each row
		for (int j = 0; j <= field.length - 1; j++) {
			
			// adds a space if field y axis index is >= 10
			if (j != 9) {
				fieldString += " " + (j + 1) + " ";
			}
			
			// normal for numbers 1 - 9
			else {
				fieldString += (j + 1) + " ";
			}
			
			// iterate through each column of the field and displays the items visual representation
			for (int k = 0; k <= field[j].length - 1; k++) {
				fieldString += field[j][k].toString() + " ";
			}
			fieldString += "\n";
		}
		
		// Return the final visual representation of the field
		return fieldString;
	}
	
	// Method to age food items in the field, remove dead food items and generate weed
	public void tick() {

	    // iterate through the field
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < width; j++) {    

	            // increase the age of all Grain instances
	            if (field[i][j] instanceof Grain || field[i][j] instanceof Apples) {

	                // checks if food item died
	                if (field[i][j].died()) {

	                    // makes that location untilledSoil
	                    field[i][j] = new UntilledSoil();
	                }

	                field[i][j].tick();            
	            }
	        }           
	    }
	 // 20% chance to generate Weed in a Soil instance in the field
        Random rand = new Random();

        if (rand.nextInt(5) == 0) { // 20% chance random number is 0

            // Generate random coordinates for the weed
            int x = rand.nextInt(height); // random x coordinate on the field
            int y = rand.nextInt(width);  // random y coordinate on the field

            // Place the weed in the randomly chosen location
            field[x][y] = new Weed();
        }
	}

	
	// Till the soil at a specific location
	public void till(int row, int column) {
		
		field[row][column] = new Soil();
			
	}
	
	 // Get the item at a specific location in the field
	public Item get(int row, int column) { 
		
		return field[row][column].copyCons();
		
	}
	
	// Plant an item at a specific location in the field
	public void plant(int row, int column, Item item) { 
		
		field[row][column] = item;
		
	}
	
	 // Calculate the total value of all items in the field
	public int getValue() {
		
		// Initialize field value
		int value = 0;
		
		// iterate through the field and add the value of each item
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				value += field[i][j].getValue();
			}
		}
		
		// returns the total field value
		return value;
	}
	
	 // Generate a summary of the field including counts of different items and total value
	public String getSummary() {
		
		// Initialize values to keep count of instances of each item in the field
		int applesCount = 0;
		int grainCount = 0;
		int soilCount = 0;
		int untilledCount = 0;
		int weedCount = 0;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
				if (field[i][j] instanceof Apples) {
				    applesCount++; // increase count for Apples
				}
				else if (field[i][j] instanceof Grain) {
					grainCount++; // increase count for Grain
				}
				else if (field[i][j] instanceof Soil) {
					soilCount++; // increase count for Soil
				}
				else if (field[i][j] instanceof UntilledSoil) {
					untilledCount++; // increase count for UntilledSoil
				}
				else {
					weedCount++;// increase count for Weed
				}							
			}		
		}		
		
		// generate a summary of the field displaying the number of items in the field
		return  String.format("Apples: 	%d%n", applesCount) + 
				String.format("Grain: 		%d%n", grainCount) +
				String.format("Soil: 		%d%n", soilCount) +
				String.format("Untilled: 	%d%n", untilledCount) +
				String.format("Weed:		%d%n", weedCount) +
				String.format("For a total of:	$%d%n", getValue() ) +
				String.format("Total apples created: %d%n", Apples.getGenerationCount()) +
				String.format("Total grain created: %d%n", Grain.getGenerationCount());	
		
	}

	// get height of the field
	public int getHeight() {
		return height;
	}

	// get width of the field
	public int getWidth() {
		return width;
	}
}