package students;

import java.util.Scanner;	
import students.items.*;

public class Farm {
	
	private int playerBalance;
	Field field;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
		
		this.playerBalance = startingFunds;
		this.field = new Field(fieldWidth, fieldHeight);
		
	}
	
	public void run() {
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
						
			String actionDetect;
			do {
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
			    actionDetect = scanner.nextLine();
			    
			    if (!actionDetect.equals("t") && !actionDetect.equals("h") && !actionDetect.equals("p") &&
			            !actionDetect.equals("s") && !actionDetect.equals("w") && !actionDetect.equals("q")) {
			    	System.out.println("\nPlease enter a valid action!\n");	
			    }
			    
			} while (!actionDetect.equals("t") && !actionDetect.equals("h") && !actionDetect.equals("p") &&
			            !actionDetect.equals("s") && !actionDetect.equals("w") && !actionDetect.equals("q"));

			
			int xValue = 0;
			int yValue = 0;
			String action = "";
			
			Scanner actionDetectScanner = new Scanner(actionDetect);
			action = actionDetectScanner.next();
			
			
						
			if (action.equals("p") || action.equals("h") || action.equals("t")) {
				
				xValue = actionDetectScanner.nextInt() - 1;
			    yValue = actionDetectScanner.nextInt() - 1;
			}
			
			int column = xValue;
			int row = yValue;
			
			if (action.equals("q")) {
				running = false;
				scanner.close();
				actionDetectScanner.close();
			}
			
			else if (action.equals("w")) {
				
			}
			
			else if (action.equals("s")) {
				System.out.println(field.getSummary());
				
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
						if (field.get(row, column) instanceof Soil) {
							field.plant(row, column, new Apples());
							playerBalance -= Apples.getCost();
						}
						else {
							System.out.println("This location isn't free OR isn't tilled \n");
						}
					}
					else {
						System.out.println("Not enough funds for Apples \n");
					}
				}
				
				else {
					if (playerBalance >= Grain.getCost()) {
						if (field.get(row, column) instanceof Soil) {
							field.plant(row, column, new Grain());
							playerBalance -= Grain.getCost();
						}
						else {
							System.out.println("This location isnt free OR it doesn't have Soil \n");
						}
					}
					else {
						System.out.println("Not enough funds for Grain \n");
					}
				}			
			}
			
			else if (action.equals("h")) {
				
				Item harvestedItem = field.get(row, column);
				
				playerBalance += harvestedItem.getValue();	
				
				field.plant(row, column, new Soil());
				
			}
			
			else if (action.equals("t")) {
				
				field.till(row, column);	
			}
			field.tick();
		}
	}
}