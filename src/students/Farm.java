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
//			System.out.println(actionDetect);
			
			int xValue = 0;
			int yValue = 0;
			String action = "";
			
			Scanner actionDetectScanner = new Scanner(actionDetect);
			action = actionDetectScanner.next();
			
			
						
			if (action.equals("p") || action.equals("h") || action.equals("t")) {
				
				xValue = actionDetectScanner.nextInt();
			    yValue = actionDetectScanner.nextInt();
			}
			
			int column = xValue - 1;
			int row = yValue - 1;
			
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
						if (field.get(row, column) instanceof Soil) {
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
						if (field.get(row, column) instanceof Soil) {
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
				
//				Item harvestedItem = field.get(row, column);
				
				if (field.get(row, column) instanceof Grain) {
					playerBalance += Grain.getCost();
					field.plant(row, column, new Soil());
				}
				
				else if (field.get(row, column) instanceof Apples) {
					playerBalance += Apples.getCost();
					field.plant(row, column, new Soil());
				}
				
				else if (field.get(row, column) instanceof Weed) {
					playerBalance += Weed.getMonetaryValue();
					field.plant(row, column, new Soil());
				}
			}
			
			else if (action.equals("t")) {
				
				field.till(row, column);	
			}
		}
	}
}