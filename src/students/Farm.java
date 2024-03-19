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
			
			int xValue = -1;
			int yValue = -1;
			String action = "";
			
			if (actionDetect.length() >= 5) {
				
			    xValue = Integer.parseInt(actionDetect.substring(2, 3));
			    yValue = Integer.parseInt(actionDetect.substring(4, 5));
			} 
			
			else {
				action = actionDetect.substring(0,1);
			}
			
				
			int row = xValue;
			int column = yValue;
			
			if (action.equals("q")) {
				running = false;
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
						+ Apples.getMonetaryValue()
						+ " - 'g' to buy grain for $"
						+ Grain.getMonetaryValue());
				
				String foodSelection = scanner.nextLine();
				
				if (foodSelection == "a") {
					if (playerBalance >= Apples.getMonetaryValue()) {
						if (field.field[row][column] instanceof Soil) {
							field.plant(row, column, new Apples());
							playerBalance -= Apples.getMonetaryValue();
						}
						else {
							System.out.println("This location isnt free OR it doesn't have Soil");
						}
					}
					else {
						System.out.println("Not enough funds for Apples");
						field.tick();
					}
				}
				
				else {
					if (playerBalance >= Grain.getMonetaryValue()) {
						if (field.field[row][column] instanceof Soil) {
							field.plant(row, column, new Grain());
							playerBalance -= Grain.getMonetaryValue();
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
					playerBalance += Grain.getMonetaryValue();
				}
				
				else if (field.field[row][column] instanceof Apples) {
					playerBalance += Apples.getMonetaryValue();
				}
				
				else if (field.field[row][column] instanceof Weed) {
					playerBalance += Weed.getMonetaryValue();
				}
			}
			
			else if (action.equals("t")) {
				
				if(field.field[row][column] instanceof UntilledSoil) {
					field.till(row, column);	
				}
			}
			scanner.close();
		}
	}
}