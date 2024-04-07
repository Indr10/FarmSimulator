package students;

import java.util.Scanner;			
import students.items.*;
import ShopImplementation.*;

public class Farm {
	
	// Instance variables to store player balance and field
	private int playerBalance;
	private Field field;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
		
		this.playerBalance = startingFunds; // sets player balance
		this.field = new Field(fieldWidth, fieldHeight); // creates a new field
		
	}
	
	
	// Main game loop, runs until user quits
	public void run() {
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
// 		prompts the user to name the Farm
		System.out.print("Please name your Farm: \n");
		String farmName = scanner.nextLine();
			
		while (running) {
			
			// Prints the Farm name
			System.out.println("     " + farmName + "     ");
								
			String actionDetect;
			
			boolean invalidInput = true;
			
			int xValue = 0;
			int yValue = 0;
			String action = "";
			
			// loop to validate all inputs for main actions in the game
			do {
			    invalidInput = true; 

			    // action menu, prompts user to choose their next action
			    System.out.println(field.toString());
			    System.out.println("Bank balance: $ " + this.playerBalance
			            + "\n\nEnter your next action: \n"
			            + "  t x y: till\n"
			            + "  h x y: harvest\n"
			            + "  p x y: plant\n"
			            + "  s: field summary\n"
			            + "  m: market\n"
			            + "  w: wait\n"
			            + "  q: quit");
			    
			    // stores the user input
			    actionDetect = scanner.nextLine();
			    
			    // checks for blank input
			    if (actionDetect.isBlank()) {
			        System.out.println("Please enter a valid action!\n");
			        continue; // restarts the loop, prompt for action gain until its not blank
			    }
			    
			    // passes the user input into a scanner
			    Scanner actionDetectScanner = new Scanner(actionDetect);
			    
			    // scans the letter of the user input
			    action = actionDetectScanner.next();
      
			    // validation to make sure the first letter in the input is p, h or t
			    if (action.equals("p") || action.equals("h") || action.equals("t")) {
			        
			    	// assigns the first number in the scanner to xValue
			    	if (actionDetectScanner.hasNextInt()) {
			            xValue = actionDetectScanner.nextInt() - 1; // -1 cause field starts from 1
			            
			            // assigns the first number in the scanner to yValue
			            if (actionDetectScanner.hasNextInt()) {
			                yValue = actionDetectScanner.nextInt() - 1; // -1 cause field starts from 1
			                
			                // validates input coordinates to ensure they are within the field
			                if (xValue < 0 || xValue >= field.getHeight() || yValue < 0 || yValue >= field.getWidth()) {
			                    System.out.println("Invalid coordinates. Please enter coordinates within the field.\n");
			                } 
			                
			                else {
			                    invalidInput = false;
			                }
			            } 
			            // invalid y coordinate
			            else {
			                System.out.println("Please enter a valid integer for the y coordinate.\n");
			            }
			        } 
			    	// invalid x coordinate
			    	else {
			            System.out.println("Please enter a valid integer for the x coordinate.\n");
			        }
			    } 
			    // validation for action to make sure its one of the remaining actions
			    else if (!action.equals("s") && !action.equals("w") && !action.equals("q") && !action.equals("m")) {
			        System.out.println("\nPlease enter a valid action!\n");
			    } 
			    
			    else {
			        invalidInput = false; 
			    }

			    // close scanner to save memory
			    actionDetectScanner.close(); 

			} while (invalidInput);
						
			int column = xValue;
			int row = yValue;
			
			// when users chooses to quit
			if (action.equals("q")) {
				running = false;
				scanner.close();
			}
			
			// user chooses to wait
			else if (action.equals("w")) {
				// ticks at the end of the game loop
			}
			
			// user chooses to display summary
			else if (action.equals("s")) {
				System.out.println(field.getSummary()); // print field summary
				
			}
			
			// user chooses to plant
			else if (action.equals("p")) {
				
				// prompt for what to plant
				System.out.println("Enter: \n"
						+ " - 'a' to buy an apple for $"
						+ Apples.getCost()
						+ "\n - 'g' to buy grain for $"
						+ Grain.getCost());
				
				// store user choice
				String foodSelection = scanner.nextLine();
				
				// user chooses to plant apple
				if (foodSelection.equals("a")) {
					
					// checks if player has enough balance
					if (playerBalance >= Apples.getCost()) {
						
						// checks if location if instance of soil
						if (field.get(row, column) instanceof Soil) {
							field.plant(row, column, new Apples()); // plant apple
							playerBalance -= Apples.getCost(); // remove apple cost from balance
						}
						// invalid location
						else {
							System.out.println("This location isn't free OR isn't tilled \n");
						}
					}
					// not enough player balance
					else {
						System.out.println("Not enough funds for Apples \n");
					}
				}
				
				// user chooses grain
				else {
					// checks if player has enough balance
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
			
			// user chooses to harvest
			else if (action.equals("h")) {
				
				// copy of the item at the location
				Item harvestedItem = field.get(row, column);
				
				// checks if the item is apple or grain
				if (harvestedItem instanceof Apples || harvestedItem instanceof Grain) {
				
					// adds crop value to player balance
					playerBalance += harvestedItem.getValue();	
				
					// replace crop with soil
					field.plant(row, column, new Soil());}
				
				// invalid harvest item
				else {
					System.out.println("You cannot harvest this object");
				}
			}
			
			// user chooses to till
			else if (action.equals("t")) {
				
				// replace the item in the location with soil
				field.till(row, column);	
			}
			
			// user chooses to go to market
			else if (action.equals("m")) {
				
				// prompt for user to buy something in market
				System.out.println("------ Market Place ------ \n"
						+ "What would you like to buy?\n");
				
				boolean insideMarket = true;

				// loop for validating user choice until its correct
				while (insideMarket) {
				
					System.out.println("Enter: "
							+ " \n- 'ms' to buy magic Serum for $"
							+ MagicSerum.getCost()
							+ " \n- 'c' to clear all weed $"
							+ ClearWeed.getCost()
							+ " \n- 'ha' to harvest all mature crops $"
							+ HarvestAll.getCost());
					
					// Store users buy choice
					String shopSelection = scanner.nextLine();
					
					// user chooses to buy magic serum
					if (shopSelection.equals("ms")) {
					
						MagicSerum magicSerum = new MagicSerum();
						
						// apply magic serum to the crops
						magicSerum.magicSerum();
					
						playerBalance -= MagicSerum.getCost(); // decrease player balance with the cost of magic serum
						
					}
					
					// user chooses to buy clear weed
					else if (shopSelection.equals("c")) {
						
						ClearWeed clear = new ClearWeed();
						
						// clears all weed from farm
						clear.clear(this.field);
						
						playerBalance -= ClearWeed.getCost(); // decrease player balance with the cost of clearing weed
						
					}
					
					// user chooses to buy harvest all
					else if (shopSelection.equals("ha")) {
						
						HarvestAll harvestAll = new HarvestAll();
						
						// harvests all mature crops from farm
						harvestAll.harvestAll(this.field);
						
						playerBalance -= HarvestAll.getCost(); // decrease player balance with the cost of harvesting crops
						playerBalance += HarvestAll.getHarvestValue(); // increase player balance by the harvest value of the crops
						
					}
					
					// invalid input
					else {
						System.out.println("\nPlease choose a valid option.\n");
						continue; // restarts the loop to prompt user again
					}
				}
			}
			// tick the farm by 1 tick
			field.tick();
		}
	}
}