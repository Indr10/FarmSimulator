package students;

import java.util.Scanner;	
import students.items.*;

public class Farm {
	
	int playerBalance;
	Field field;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
		
		this.playerBalance = startingFunds;
		this.field = new Field(fieldWidth, fieldHeight);
		
	}
	
	public void run() {
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			System.out.println(field.toString());
			
			System.out.println("Bank balance: $ "
					+ this.playerBalance
					+ "\n\nEnter your next action: \n"
					+ "  t x y: till\n"
					+ "  h x y: harvest\n"
					+ "  p x y: plant\n"
					+ "  s: field summary\n"
					+ "  w: wait\n"
					+ "  q: quit");
			
			String actionDetect = scanner.nextLine();
			
			int xValue = 0;
			int yValue = 0;
			String action = "";
			
			if (actionDetect.length() > 1) {
				
				action = actionDetect.substring(0,1);
				
				if (action.equals("s") || action.equals("w") || action.equals("q")) {
					action = actionDetect.substring(0,1);
				}
			} 
			
			else {
				
				xValue = scanner.nextInt();
			    yValue = scanner.nextInt();
			}
			
			int column = xValue;
			int row = yValue;
			
			if (action.equals("q")) {
				running = false;
				scanner.close();
			}
			
			else if (action.equals("w")) {
				field.tick();			
			}
			
			else if (action.equals("s")) {
				field.getSummary();
			}
			
			
			else if (action.equals("p")) {
				
				System.out.println("Enter: \n"
						+ " - 'a' to buy an apple for $"
						+ Apples.getCost()
						+ "\n - 'g' to buy grain for $"
						+ Grain.getCost());
				
				String foodSelection = scanner.nextLine();
				
				if (foodSelection.equals("a")) {
					if (playerBalance >= Apples.getCost()) {
						if (field.field[row][column] instanceof Soil) {
							field.plant(row, column, new Apples());
							playerBalance -= Apples.getCost();
						}
						else {
							System.out.println("This location isn't free OR isn't tilled");
						}
					}
					else {
						System.out.println("Not enough funds for Apples");
						field.tick();
					}
				}
				
				else {
					if (playerBalance >= Grain.getCost()) {
						if (field.field[row][column] instanceof Soil) {
							field.plant(row, column, new Grain());
							playerBalance -= Grain.getCost();
						}
						else {
							System.out.println("This location isnt free OR it doesn't have Soil");
						}
					}
					else {
						System.out.println("Not enough funds for Grain");
						field.tick();
					}
				}	
			}
			
			else if (action.equals("h")) {
				
				if (field.field[row][column] instanceof Grain) {
					playerBalance += Grain.getCost();
					field.field[row][column] = new Soil();
				}
				
				else if (field.field[row][column] instanceof Apples) {
					playerBalance += Apples.getCost();
					field.field[row][column] = new Soil();
				}
				
				else if (field.field[row][column] instanceof Weed) {
					playerBalance += Weed.getMonetaryValue();
					field.field[row][column] = new Soil();
				}
			}
			
			else if (action.equals("t")) {
				
				field.till(row, column);	
			}
		}
	}
}