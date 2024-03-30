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
			
			boolean invalidInput = true;
			
			int xValue = 0;
			int yValue = 0;
			String action = "";
			
			// ATTEMP #2 - WORKS
			do {
			    invalidInput = true; 

			    System.out.println(field.toString());
			    System.out.println("Bank balance: $ " + this.playerBalance
			            + "\n\nEnter your next action: \n"
			            + "  t x y: till\n"
			            + "  h x y: harvest\n"
			            + "  p x y: plant\n"
			            + "  s: field summary\n"
			            + "  w: wait\n"
			            + "  q: quit");
			    actionDetect = scanner.nextLine();
			    
			    Scanner actionDetectScanner = new Scanner(actionDetect);
			    action = actionDetectScanner.next();

			    if (action.equals("p") || action.equals("h") || action.equals("t")) {
			        
			    	if (actionDetectScanner.hasNextInt()) {
			            xValue = actionDetectScanner.nextInt() - 1;
			            
			            if (actionDetectScanner.hasNextInt()) {
			                yValue = actionDetectScanner.nextInt() - 1;
			                
			                if (xValue < 0 || xValue >= field.getHeight() || yValue < 0 || yValue >= field.getWidth()) {
			                    System.out.println("Invalid coordinates. Please enter coordinates within the field.\n");
			                } 
			                else {
			                    invalidInput = false;
			                }
			            } 
			            else {
			                System.out.println("Please enter a valid integer for the y coordinate.\n");
			            }
			        } 
			    	else {
			            System.out.println("Please enter a valid integer for the x coordinate.\n");
			        }
			    } 
			    else if (!action.equals("s") && !action.equals("w") && !action.equals("q")) {
			        System.out.println("\nPlease enter a valid action!\n");
			    } 
			    else {
			        invalidInput = false; 
			    }

			    actionDetectScanner.close(); 

			} while (invalidInput);
						
			int column = xValue;
			int row = yValue;
			
			if (action.equals("q")) {
				running = false;
				scanner.close();
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
				
				// what if they harvest soil or un-tilled soil?
				
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