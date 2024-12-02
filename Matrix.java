/*
 * Aashrith Atluri
 */
import java.util.Scanner;
public class Matrix {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean validDimensions = true;
		
		System.out.println("Let's subtract Matrices using this program!!"); //Start
		
		
		System.out.println("Please enter the number of rows followed by a space and the number of columns for the first matrix");
		int numberofRows1 = keyboard.nextInt(); //Start of rows
		int numberofColumns1 = keyboard.nextInt(); //Start of columns
		
		// 2. Make the first matrix and populate it
		int[][] matrix1 = new int[numberofRows1][numberofColumns1];
		System.out.println("Please enter the values for the first matrix:");
		for (int i = 0; i < matrix1.length; i++) { 
			for (int j = 0; j < matrix1[i].length; j++) { 
				System.out.printf("Enter value at position [%d][%d]:", i, j);
				matrix1[i][j] = keyboard.nextInt();
			}
		}
		
		System.out.println("Please enter the number of rows followed by a space and number of columns for the second matrix:");
		int numberofRows2 = keyboard.nextInt();
		int numberofColumns2 = keyboard.nextInt();
		
	
		int[][] matrix2 = new int [numberofRows2][numberofColumns2];
		System.out.println("Enter the values for the second matrix.");
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				System.out.printf("Enter value at position [%d][%d]: ", i, j);
				matrix2[i][j] = keyboard.nextInt();
			}
		
		
		}
			
			System.out.println("\nFirst Matrix is:");
			for (int i = 0; i < matrix1.length; i++) {
				for (int j = 0; j < matrix1[i].length; j++) {
					System.out.print(matrix1[i][j] + " ");	
				}
				System.out.println();
			}
			
			System.out.println("\nSecond Matrix is:");
				for (int i = 0; i < matrix2.length; i++) {
					for (int j = 0; j < matrix2[i].length; j++) {
						System.out.print(matrix2[i][j] + " ");	
					}
					System.out.println();	
		}
		
				if (numberofRows1 != numberofRows2 || numberofColumns1 != numberofColumns2) {
					System.out.println("\nMatrices can't be subtracted as their dimensions do not match.");
				} else {
					
					int [][] resultMatrix = new int[numberofRows1][numberofColumns1];
					for (int i = 0; i < matrix1.length; i++) {
						for (int j = 0; j < matrix1[i].length; j++) {
							resultMatrix[i][j] = matrix1[i][j]- matrix2[i][j];
						}
					}
					
				
					System.out.println("\n Resultant Matrix after subtraction."); //Prints Results
					for (int i = 0; i < resultMatrix.length; i++) {
						for (int j = 0; j < resultMatrix[i].length; j++) {
							System.out.print(resultMatrix[i][j] + " ");
						}
						System.out.println();
					}
				}
				keyboard.close(); //Closing 
	}
}

					
					
					
					
					
	

