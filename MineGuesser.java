
/* CS 125 - Intro to Computer Science II
 * File Name: CS125_Project1.java
 * Java Programming
 * Project 1 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name 1: Samual Shaqqur 
 * Name 2: FirstName2 LastName2
 * Description: This file contains the source code for Project 1.
 */
import java.util.Scanner;

// enum class used to represent each cell of the mine board:
// HM = Hidden Mine, RM = Revealed Mine, HE = Hidden Empty, RE = Revealed Empty
enum MineCell { HM, RM, HE, RE ;

public static MineCell valueOf(char c) {
	// TODO Auto-generated method stub
	return null;
} }

public class CS125_Project1
{
	// Your code should go below this line
	// Constants used to make defining the mine board easier
	final static MineCell he = MineCell.HE;
	final static MineCell hm = MineCell.HM;
	private final static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Samual Shaqqur");
		System.out.println("Project 1");
		System.out.println("");

		// Definition of mine board. *** DO NOT CHANGE ***
		// The hidden mines are represented by 'hm' and the hidden empty
		// cells with 'he' in a 5x5 array.
		MineCell [][] mineBoard = { {he, he, he, he, he},
									{he, hm, he, hm, he},
									{he, he, he, he, he},
									{he, he, hm, he, he},
									{he, he, hm, hm, he} };
		// For creating new hard-coded test board
		/*MineCell [][] mineBoard = { {hm, hm, hm, hm, hm},
									{he, he, he, he, he},
									{he, he, he, he, he},
									{he, he, he, he, he},
									{he, he, he, he, he} };*/
		// Test your board printing functions before continuing
		//testBoardPrinting(mineBoard); // TODO 3: Comment out when print methods tested
		// Definition of some variables and constants
		int i=0;
		int currScore = 5; // Starting score is 5
		int numEmptySpotsFound = 0; // When we reach 20 empty spots, we win!
		final int minePenalty = 4; // Each time we hit a mine, subtract this value
		final int emptySpaceBonus = 1; // Each time we land on an empty space, add this value
		
		//////////////////////////////////////////////////////
		// Continue the game while the score is greater AND
		// the number of empty spots revealed is less than 20
		while (currScore > 0 && numEmptySpotsFound < 20)
		{
			i++;
			// TODO 4: Write code here to ask the user for a row and column to guess...
			System.out.println("-----------------------Next Turn-----------------------");
			int row = 0;
			int col = 0; 
	
			System.out.println("Please enter a ROW number 0-4");
			row = scan.nextInt();
			System.out.println("Please enter a COL number 0-4");
			col = scan.nextInt();
			
			// Respond to each guess the user could make
			if (mineBoard[row][col] == MineCell.HM)
			{
				// TODO 5: Write code here to respond to the user
				// guessing a cell that has hidden mine...
				mineBoard[row][col]=MineCell.RM;
				currScore-=minePenalty;
				System.out.println("After round " +i+ " score is: " +currScore);
				
			}
			else if (mineBoard[row][col] == MineCell.HE)
			{
				// TODO 6: Write code here to respond to the user
				// guessing a cell that has hidden empty cell...
				mineBoard[row][col]=MineCell.RE;
				currScore+=emptySpaceBonus;
				System.out.println("After round " +i+ " score is: " +currScore);
				System.out.println( (20-i)+" empty spaces remaining till victory.");
				if(i==20) 
				break;
			}
			else
			{
				System.out.println("You've already guessed this spot, please try again!");
			}
			printCurrBoard(mineBoard);
		}
		
		//////////////////////////////////////////////////////
		// TODO 7: Deliver final results. If we've reached this point,
		// the game is over. Write code to let the user know if they won 
		// or lost and print the final board (remember, you have a function
		// to print the game-over board)
		printGameOverBoard(mineBoard);
		if(currScore<=0) {
			System.out.print("Oh no, you LOST!");
		}
		else if(currScore>0) {
			System.out.print("Nice job, you WIN!");
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board while game is still being played:
	// '?' for unexplored, 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printCurrBoard(MineCell[][] board)
	{
		// TODO 1: Write code to print the current game state as specified
		// in the comment above
		for (int d = 0; d < board.length; d++) {
			for (int r = 0; r <board[d].length; r++) {
				if(board[d][r]==MineCell.RM) {
					System.out.print(" M");
				}
				else if(board[d][r]==MineCell.RE) {
					System.out.print(" E");
				}
				else {
					System.out.print(" ?");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/////////////////////////////////////////////////////////////////////
	// Prints the state of the board after the game is over (thus, we can
	// reveal everything to the user):
	// 'm' for "unrevealed" mines, 'e' for unrevealed empty cells,
	// 'M' for revealed mines, 'E' for revealed empty cells
	/////////////////////////////////////////////////////////////////////
	static void printGameOverBoard(MineCell[][] board)
	{
		// TODO 2: Write code to print the final (game-over) game state
		// as specified in the comment above
		for (int d = 0; d < board.length; d++) {
			for (int r = 0; r <board[d].length; r++) {
				if(board[d][r]==MineCell.HE) {
					System.out.print(" e");
				}
				if(board[d][r]==MineCell.HM) {
					System.out.print(" m");
				}
				if(board[d][r]==MineCell.RM) {
					System.out.print(" M");
				}
				if(board[d][r]==MineCell.RE) {
					System.out.print(" E");
				}
			}
			System.out.println();
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	// This function simply calls your two board printing methods to help
	// you test that your print methods are working properly before moving
	// on with this lab.
	/////////////////////////////////////////////////////////////////////
	static void testBoardPrinting(MineCell[][] board)
	{
		printCurrBoard(board);
		System.out.println();
		printGameOverBoard(board);
		System.out.println("\n\n*****Exiting program after test. Comment out testBoardPrinting() method in main() to move on.");
		System.exit(0);
	}
}


/******************************************************************************
Insert 2 test cases, which represent program input/output for two different
combinations of inputs. You may literally copy and paste your console contents,
but your two test cases should be DIFFERENT from any test cases given in the
Project description itself.

------------
Test Case 1:
------------
(Your test case I/O here.)

------------
Test Case 2:
------------
(Your test case I/O here.)
******************************************************************************/