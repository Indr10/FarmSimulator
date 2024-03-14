package students;

import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
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
				else if (field[i][j].died() == true) {
					
					field[i][j] = new UntilledSoil();
				}
			}			
		}
	}
	
	public void till(int row, int column) {
		
		field[row][column] = new Soil();
			
	}
	
//	public Object get(int row, int column) {
//		
//		return field[row][column].clone();
//		
//	}
	
	
	public void plant(int row, int column) { 
		
		
		
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
				else
					weedCount++;
					totalPrice += field[i][j].getValue();
				}							
		}		
		return String.format("Apples:				%s%n", applesCount) + 
			       String.format("Grain:				$%9.2f%n", grainCount) +
			       String.format("Soil:		$%9.2f%n", soilCount) +
			       String.format("Untilled:		$%9.2f%n", untilledCount) +
			       String.format("Weed:			$%9.2f%n", weedCount) +
			       String.format("For a total of:			$%9.2f%n", totalPrice ) +
			       String.format("Total apples created:			$%9.2f%n", Apples.getGenerationCount()) +
			       String.format("Total grain created:			$%9.2f%n", Grain.getGenerationCount());		
	}			
}
