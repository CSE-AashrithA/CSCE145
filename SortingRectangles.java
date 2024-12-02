/*
 * Aashrith Atluri
 */
import java.util.Scanner;
public class SortingRectangles {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int numofRectangles = 0;
		double [] areas = new double [0];
		int [] RectangleNumbers = new int[0];
		
		boolean EnteredData = false;
		boolean exitProgram = false;
		
		System.out.println("Its sorting rectangles time"); //Starting comment
		
		
		while (!EnteredData) { //Loop that runs if data has been entered
			System.out.println("\nPlease enter the data for the rectangles first!");
			System.out.print("How many rectangles are we creating?");
			while (!keyboard.hasNextInt()) {
				System.out.print(("Invalid Input. Please enter a valid positive number: "));
				keyboard.next();
			}
			numofRectangles = keyboard.nextInt();
			
			
			while (numofRectangles <= 0) {
				System.out.print("Invalid number of rectangles. Please enter a positive number:");
				while (!keyboard.hasNextInt()) {
					System.out.print(("Invalid Input. Please enter a valid positive number: "));
					keyboard.next();
					
				}
				numofRectangles = keyboard.nextInt();
				
			}
			
			areas = new double [numofRectangles];
			RectangleNumbers = new int[numofRectangles];
			
			for (int i = 0; i <= numofRectangles -1; i++) {
				double length = 0;
				double width = 0;
				
				System.out.println("Enter the length for Rectangle " + (i+1) + ": ");
				while (!keyboard.hasNextDouble()) {
					System.out.println("Invalid input. Please enter a positive number for length: ");
					keyboard.next();
				}
				length = keyboard.nextDouble();
				
				while (length <= 0 ) {
					System.out.print("Length must be a positive number. Please enter again: ");
					keyboard.next();
					while (!keyboard.hasNextDouble()) {
						System.out.print("Invalid input. Please enter a valid positive number for length: ");
						keyboard.next();
				}
				length = keyboard.nextDouble();
			}
			System.out.println("Enter the width for Rectangle " + (i+1) + ": ");
			while (!keyboard.hasNextDouble()) {
				System.out.print("Invalid input. Please enter a valid positive number for the width: ");
				keyboard.next();
			}
			width = keyboard.nextDouble();
			
			while (width <= 0) {
				System.out.println();
				while (!keyboard.hasNextDouble()) {
					System.out.print("Invalid Input. Please enter a positive number for the width: ");
					keyboard.next();
				}
				width = keyboard.nextDouble();
			}
				areas [i] = length * width;
				RectangleNumbers [i] = i + 1;
				
			}
			
			EnteredData = true;
			System.out.println("You have entered valid dimensions for the rectangle!!");
			
		}

		while (!exitProgram) {
			System.out.println("\n Choose from the following options:");
			System.out.println("Enter '1' if you would like to Sort Rectangles from Smallest to Largest");
			System.out.println("Enter '2' if you would like to Sort Rectangles from Largest to Smallest");
			System.out.println("Enter '3' if you would like to Get Maximum areas");
			System.out.println("Enter '4' if you would like to Get Minimum areas");
			System.out.println("Enter '5' if you would like to Get Average areas");
			System.out.println("Enter '9' if you would like to Reenter Rectangle Dimensions");
			System.out.println("Enter '0' if you would like to End the Program");
			
			int Choice = keyboard.nextInt();
			keyboard.nextLine();
			
			if (Choice == 1) {
				
				for (int i = 0; i < areas.length - 1; i++) {
					for (int j = 0; j < areas.length - i -1; j++) {
						if (areas [j] > areas [j+1]) {
							
							double temporary = areas [j];
							areas [j] = areas [j+1];
							areas[j+1] = temporary;
							
							int tempValue = RectangleNumbers [j];
							RectangleNumbers [j] = RectangleNumbers [j+1];
							RectangleNumbers [j+1]= tempValue;
									
						}
					}
				}
				System.out.println("Here are the areas sorted from smallest to largest:");
				for (int i = 0; i < areas.length; i++) {
					System.out.println("Rectangle " + RectangleNumbers[i] + " areas: " + areas[i]);
				}
			
			} else if (Choice == 2) {
				for (int i = 0; i < areas.length -1; i++) {
				for (int j = 0; j < areas.length - i - 1; j++) {
					if (areas [j] < areas [j+1]) {
						
						double temporary = areas [j];
						areas [j] = areas [j+1];
						areas[j+1] = temporary;
						
						int tempValue = RectangleNumbers [j];
						RectangleNumbers [j] = RectangleNumbers [j+1];
						RectangleNumbers [j+1]= tempValue;
					}
				}
			}
			System.out.println("Here are the areas sorted from largest to smallest:");
			for (int i = 0; i < areas.length; i++) {
				System.out.println("Rectangle " + RectangleNumbers [i] + " areas: " + areas[i]);
			} 
			
			} else if (Choice == 3) {
				double maximumareas = areas [0];
				int maxRectNum = RectangleNumbers[0];
				for (int i =1; i < areas.length; i++) {
					if (areas[i] > maximumareas) {
						maximumareas = areas[i];
						maxRectNum = RectangleNumbers[i];
					}
				}
				System.out.println("The Maximum areas is for Rectangle "+maxRectNum+"; "+ maximumareas);
				
			} else if (Choice == 4) {
				double minimumareas = areas[0];
				int minRectNumm = RectangleNumbers[0];
				for (int i =1; i < areas.length; i++) {
					if (areas[i] < minimumareas) {
						minimumareas = areas[i];
						minRectNumm = RectangleNumbers[i];
					}
				}
				System.out.println("The minimum areas is for Rectangle " + minRectNumm+"; " + minimumareas);
				
			} else if (Choice == 5) {
				double sum = 0; 
				for (double area: areas) {
					sum += area; 
				}
				double avgareas = sum/areas.length;
				System.out.println("The average areas is: " + avgareas);
		
			} else if (Choice == 9) {
				System.out.print("How many rectangles do you want to create? ");
			    
			 
			    while (!keyboard.hasNextInt()) {
			        System.out.print("Invalid input. Please enter a valid positive number: ");
			        keyboard.next(); 
			    }
			    numofRectangles = keyboard.nextInt();
			    keyboard.nextLine();
			    
			    
			    while (numofRectangles <= 0) {
			        System.out.print("Invalid number of rectangles. Please enter a positive number: ");
			        while (!keyboard.hasNextInt()) {
			            System.out.print("Invalid input. Please enter a valid positive number: ");
			            keyboard.next(); 
			        }
			        numofRectangles = keyboard.nextInt();
			        keyboard.nextLine();
			    }

			  
			    areas = new double[numofRectangles];
			    RectangleNumbers = new int[numofRectangles];
			    
			    
			    for (int i = 0; i < numofRectangles; i++) {
			        double length = 0, width = 0;

			       
			        System.out.print("Enter the length for Rectangle " + (i + 1) + ": ");
			        while (!keyboard.hasNextDouble()) {
			            System.out.print("Invalid input. Please enter a valid positive number for length: ");
			            keyboard.next(); 
			        }
			        length = keyboard.nextDouble();

			      
			        while (length <= 0) {
			            System.out.print("Length must be a positive number. Please enter again: ");
			            while (!keyboard.hasNextDouble()) {
			                System.out.print("Invalid input. Please enter a valid positive number for length: ");
			                keyboard.next(); 
			            }
			            length = keyboard.nextDouble();
			        }

			     
			        System.out.print("Enter the width for Rectangle " + (i + 1) + ": ");
			        while (!keyboard.hasNextDouble()) {
			            System.out.print("Invalid input. Please enter a valid positive number for width: ");
			            keyboard.next(); 
			        }
			        width = keyboard.nextDouble();

			       
			        while (width <= 0) {
			            System.out.print("Width must be a positive number. Please enter again: ");
			            while (!keyboard.hasNextDouble()) {
			                System.out.print("Invalid input. Please enter a valid positive number for width: ");
			                keyboard.next(); 
			            }
			            width = keyboard.nextDouble();
			        }

			        areas[i] = length * width;  
			        RectangleNumbers[i] = i + 1;  
			    }

			    System.out.println("You have entered valid dimensions for the rectangles!"); //Lets user know they are entering valid dimensions
			} else if (Choice == 0) {
				System.out.println(" Thanks for playing"); //Says thank you
				exitProgram = true;
				//Exits
			} else {
				System.out.println("Invalid option. Please try again.");
			}
		}
		keyboard.close();
	}
}

