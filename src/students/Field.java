package students;

import students.items.*;		
import java.util.Random;

public class Field {
	
	int height;
	int width;
	Item [][] field;
	
			
	public Field(int height, int width){
		
		this.height = height;
		this.width = width;
		this.field = new Item[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				field[i][j] = new Soil();
			}
		}
	}
	
	@Override
	public String toString() {
		
		String fieldString = "  ";
		
		for (int i = 1; i <= field[0].length - 1; i++) {
			
			fieldString += i + " ";
		}
		
		fieldString += "\n";
		
		for (int j = 0; j <= field.length - 1; j++) {
			
			fieldString += (j + 1) + " ";
			
			for (int k = 0; k < field[j].length - 1; k++) {
				
				fieldString += field[j][k].toString() + " ";
			}
			fieldString += "\n";
		}
		return fieldString;
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
				else if (field[i][j].died() == true) {
					
					field[i][j] = new UntilledSoil();
				}
			}			
		}
	}
	
	public void till(int row, int column) {
		
		field[row][column] = new Soil();
			
	}
	
	public Object get(int row, int column) throws CloneNotSupportedException {
			
		return field[row][column].clone();
		
	}	
	
	public void plant(int row, int column, Item item) { 
		
		field[row][column] = item;
		
	}
	
	public int getValue() {
		
		int value = 0;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
				value += field[i][j].getValue();
				
			}
		}
		return value;
	}
	
	public String getSummary() {
		
		int applesCount = 0;
		int grainCount = 0;
		int soilCount = 0;
		int untilledCount = 0;
		int weedCount = 0;
		int totalPrice = 0;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
				if (field[i][j] instanceof Apples) {
				    applesCount++;
				    totalPrice += field[i][j].getValue();
				}
				else if (field[i][j] instanceof Grain) {
					grainCount++;
					totalPrice += field[i][j].getValue();
				}
				else if (field[i][j] instanceof Soil) {
					soilCount++;
				}
				else if (field[i][j] instanceof UntilledSoil) {
					untilledCount++;
					totalPrice += field[i][j].getValue();
				}
				else {
					weedCount++;
					totalPrice += field[i][j].getValue();
				}							
			}		
		}		
		return String.format("Apples: 	%d%n", applesCount) + 
				String.format("Grain: 		%d%n", grainCount) +
				String.format("Soil: 		%d%n", soilCount) +
				String.format("Untilled: 	%d%n", untilledCount) +
				String.format("Weed:		%d%n", weedCount) +
				String.format("For a total of:	$%d%n", totalPrice ) +
				String.format("Total apples created: %d%n", Apples.getGenerationCount()) +
				String.format("Total grain created: %d%n", Grain.getGenerationCount());		
	}
}