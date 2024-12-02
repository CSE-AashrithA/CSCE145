/*
 * Aashrith Atluri
 */
import java.util.Random;
import java.util.Scanner;
public class PotHoleDriving {
	static final int GRID_SIZE = 10;
    static final char EMPTY_ROAD = '-';
    static final char PLAYER_CAR = 'X';
    static final char GOAL = '^';
    static final char POTHOLE_SYMBOL = '@';
    static char[][] gameBoard = new char[GRID_SIZE][GRID_SIZE];
    static boolean[][] potholePositions = new boolean[GRID_SIZE][GRID_SIZE];
    static int playerRow = 0;
    static int playerCol = 0;
    static int goalRow = 9;
    static int goalCol = 9;
    static Random randomGen = new Random();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        boolean continuePlaying;

        do {
            initializeGame();
            boolean isGameActive = true;

            while (isGameActive) {
                printBoard();
                System.out.print("Enter direction (N, S, W, E, NW, NE, SW, SE): ");
                String moveDirection = scanner.nextLine().toUpperCase();

                if (validMove(moveDirection)) {
                    performMove(moveDirection);
                    if (checkVictory()) {
                        System.out.println("You've reached home! Congratulations!");
                        isGameActive = false;
                    } else if (checkDefeat()) {
                        printBoard();
                        System.out.println("Oops! You hit a pothole. Game over.");
                        isGameActive = false;
                    }
                } else {
                    System.out.println("Invalid direction. Please try again.");
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            continuePlaying = scanner.nextLine().equalsIgnoreCase("yes");
        } while (continuePlaying);

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    private static void initializeGame() {
        gameBoard = new char[GRID_SIZE][GRID_SIZE];
        potholePositions = new boolean[GRID_SIZE][GRID_SIZE];

        
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                gameBoard[i][j] = EMPTY_ROAD;
            }
        }

        // Place car and home on the board
        playerRow = 0;
        playerCol = 0;
        gameBoard[playerRow][playerCol] = PLAYER_CAR;
        gameBoard[goalRow][goalCol] = GOAL;

        // Randomly place potholes on the board
        int placedPotholes = 0;
        while (placedPotholes < 5) {
            int row = randomGen.nextInt(GRID_SIZE);
            int col = randomGen.nextInt(GRID_SIZE);

            if (gameBoard[row][col] == EMPTY_ROAD) {
                potholePositions[row][col] = true;
                placedPotholes++;
            }
        }
    }

    
    private static void printBoard() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print(PLAYER_CAR + " ");
                } else if (i == goalRow && j == goalCol) {
                    System.out.print(GOAL + " ");
                } else {
                    System.out.print(EMPTY_ROAD + " ");
                }
            }
            System.out.println();
        }
    }

    
    private static boolean validMove(String direction) {
        int targetRow = playerRow;
        int targetCol = playerCol;

       
        if (direction.equals("N")) {
            targetRow--;
        } else if (direction.equals("S")) {
            targetRow++;
        } else if (direction.equals("W")) {
            targetCol--;
        } else if (direction.equals("E")) {
            targetCol++;
        } else if (direction.equals("NW")) {
            targetRow--;
            targetCol--;
        } else if (direction.equals("NE")) {
            targetRow--;
            targetCol++;
        } else if (direction.equals("SW")) {
            targetRow++;
            targetCol--;
        } else if (direction.equals("SE")) {
            targetRow++;
            targetCol++;
        } else {
            return false; // Invalid input
        }

        
        return targetRow >= 0 && targetRow < GRID_SIZE && targetCol >= 0 && targetCol < GRID_SIZE;
    }

    
    private static void performMove(String direction) {
        gameBoard[playerRow][playerCol] = EMPTY_ROAD; // Clear previous car position

        if (direction.equals("N")) {
            playerRow--;
        } else if (direction.equals("S")) {
            playerRow++;
        } else if (direction.equals("W")) {
            playerCol--;
        } else if (direction.equals("E")) {
            playerCol++;
        } else if (direction.equals("NW")) {
            playerRow--;
            playerCol--;
        } else if (direction.equals("NE")) {
            playerRow--;
            playerCol++;
        } else if (direction.equals("SW")) {
            playerRow++;
            playerCol--;
        } else if (direction.equals("SE")) {
            playerRow++;
            playerCol++;
        }

        gameBoard[playerRow][playerCol] = PLAYER_CAR; // Update position on the board
    }

    
    private static boolean checkVictory() {
        return playerRow == goalRow && playerCol == goalCol;
    }

   
    private static boolean checkDefeat() {
        return potholePositions[playerRow][playerCol];
    }
	

	}


