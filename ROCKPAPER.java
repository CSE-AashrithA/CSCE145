/* 
 * Aashrith Atluri
 */
import java.util.Random;
import java.util.Scanner;

public class ROCKPAPER {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);		
		Random random = new Random();							
		String[] choice = {"Rock", "Paper", "Scissors"};  
		boolean continuePlaying = true;  
				
		
		while (continuePlaying) {
			int userScore = 0;
			int programScore = 0;

		
			for (int round = 1; round <= 3; round++) {
				// valid choice
				String userChoice = "";
				boolean correctInput = false;
				
				while (!correctInput) {
					System.out.println("Let's play Rock, Paper or Scissors. Best 2 out of 3 rounds. Good Luck!");		
					System.out.println("Enter \"Rock\", \"Paper\", or \"Scissors\":");
							userChoice = keyboard.nextLine().trim();
							
							if (userChoice.equalsIgnoreCase("Rock") || userChoice.equalsIgnoreCase("Paper") || userChoice.equalsIgnoreCase("Scissors")) {
								correctInput = true;  
							} else {
								System.out.println("The input is not valid, try again");
							}
						}
			
				String programChoice = choice[random.nextInt(3)];
				System.out.println("Computer chose: " + programChoice);

		
				if (userChoice.equalsIgnoreCase(programChoice)) {
					
					System.out.println("User's choice: " + userChoice.toUpperCase() + " vs. " + "Computer's Choice: " + programChoice.toUpperCase() + "! It's a Tie!");
				} else if ((userChoice.equalsIgnoreCase("Rock") && programChoice.equalsIgnoreCase("Scissors")) ||
						(userChoice.equalsIgnoreCase("Paper") && programChoice.equalsIgnoreCase("Rock")) || (userChoice.equalsIgnoreCase("Scissors") && programChoice.equalsIgnoreCase("Paper"))) 
				{
					
					System.out.println("User's choice: " + userChoice.toUpperCase() + " vs. " + "Computer's Choice: " + programChoice.toUpperCase() + "! Player Wins!");
					userScore++;  
				} else {
					
					System.out.println("User's choice: " + userChoice.toUpperCase() + " vs. " + "Computer's Choice: " + programChoice.toUpperCase() + "! Computer Wins!");
					programScore++;  
						}

				
				System.out.println("Player has won " + userScore + " times : Computer has won " + programScore + " times\n");
			}
			
			if (userScore > programScore) {
				System.out.println("The Player wins all!"); // Says that the player wins
			} else if (programScore > userScore) {
				System.out.println("The Computer wins all!"); //Tells the user computer wins
			} else {
				System.out.println("It's a tie all"); // Tells the user a tie
			}
			
			System.out.println("Would you like to play again? \"Yes\" or \"No\""); //Invites the user to play again
			String playAgain = keyboard.nextLine().trim();
			
			if (!playAgain.equalsIgnoreCase("Yes")) {
				continuePlaying = false;
			}
		}
		System.out.println("Thanks for playing");
		keyboard.close();	

	}

}
	

	

