/* CS 125 - Intro to Computer Science II
 * File Name: CS125_Project2.java
 * Project 2 - Due X/XX/XXXX
 * Instructor: Dr. Dan Grissom
 * 
 * Name: Samual Shaqqur
 * Description: Insert your meaningful description for Project 2.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class CS125_Project2
{
	private final static Scanner scan = new Scanner(System.in); //scanner
	static private int count1=0;
	public static void main(String[] args)
	{
		ArrayList<Integer> a1 = new ArrayList<Integer>(); // stores how many times player tries
		ArrayList<Integer> a2 = new ArrayList<Integer>(); // stores row history values
		ArrayList<Integer> a3 = new ArrayList<Integer>(); //stores col history values
		int count=0;
		String ArrayG[][]={ {"r\\c","0","1","2","3","4","5","6"}, //original game board
				{"0","-","-","-","-","-","-","-",},
				{"1","-","-","-","-","-","-","-",},
				{"2","-","-","-","-","-","-","-",},
				{"3","-","-","-","-","-","-","-",},
				{"4","-","-","-","-","-","-","-",},
				{"5","-","-","-","-","-","-","-",},
				{"6","-","-","-","-","-","-","-",}};
		String ArrayinG[][]={ {"r\\c ","0","1","2","3","4","5","6"}, // board that will be changed when player plays
				{"0","-","-","-","-","-","-","-",},
				{"1","-","-","-","-","-","-","-",},
				{"2","-","-","-","-","-","-","-",},
				{"3","-","-","-","-","-","-","-",},
				{"4","-","-","-","-","-","-","-",},
				{"5","-","-","-","-","-","-","-",},
				{"6","-","-","-","-","-","-","-",}};
		
		// Your program should always output your name and the project number.
		// DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Samual Shaqqur");
		System.out.println("Project 2");
		System.out.println("");
		
		
		int hitCount=0;
		char direcion; //direction of ship
		int col;
		int row;
		//request input from user
		System.out.println("Please enter a ROW number 0-6");
		row=scan.nextInt();
		System.out.println("Please enter a COL number 0-6");
		col=scan.nextInt();
		System.out.println("Please enter d(downwards) or r(rightward)");
		direcion=scan.next().charAt(0);
		
		
		while(printCurrBoard(ArrayG,row+1,col+1,direcion)==false) { //runs while not all ships been sunk

			//request input from user
			System.out.println("Please enter a ROW number 0-6");
			row=scan.nextInt();
			System.out.println("Please enter a COL number 0-6");
			col=scan.nextInt();
			System.out.println("Please enter d(downwards) or r(rightward)");
			direcion=scan.next().charAt(0);	
			printCurrBoard(ArrayG,row+1,col+1,direcion); // calls the function that changes values in array
			
		}
		int Row1;
		int Col1;
		
		//make function return count
		
		
		while(count1<9) {
			//request input from user
			System.out.println("Please enter a ROW number 0-6");
			Row1=scan.nextInt();
			System.out.println("Please enter a COL number 0-6");
			Col1=scan.nextInt();
			CheckCurrBoard(ArrayG,ArrayinG,Row1+1,Col1+1);
			
					if(ArrayinG[Row1+1][Col1+1]=="X") { // checks if was ship was sunk
						hitCount++; //counts how many times been sunk
						count++;
						count1++;
						System.out.println("That was a HIT! ");
						a1.add(count); //adds to arraylist of history
						a2.add(Row1); //adds to arraylist of history
						a3.add(Col1); //adds to arraylist of history
					}
					else if(ArrayinG[Row1+1][Col1+1]=="m") { // checks if player missed
						count++;// counter for history to show at end
						System.out.println("That was a Miss! ");
						a1.add(count); //adds to arraylist of history
						a2.add(Row1); //adds to arraylist of history
						a3.add(Col1); //adds to arraylist of history
					}

		}
		System.out.println("Guess | Row Col ");
		for(int i=0;i<a1.size();i++) { // prints out the history of the played game 
					System.out.print(a1.get(i)+ "     | ");
					System.out.print(a2.get(i)+ "    ");
					System.out.print(a3.get(i)+ " ");
					System.out.println(" ");
				}
		System.out.println("End of Program!");
	}
	
	
		
	
	static boolean printCurrBoard(String[][] board, int Row, int Col, char RorDown)
	{
		// TODO 1: Write code to print the current game state as specified
		// in the comment above
		int countS=0;
		int cc=0;
			for (int RowCheck = 0; RowCheck < board.length; RowCheck++) {
				for (int ColCheck = 0; ColCheck <board[RowCheck].length; ColCheck++) {
					if(board[RowCheck][ColCheck]=="S") {
						countS++;
						if(countS==2) {
							cc=2;
						}
						else if(countS==6) {
							cc=3;
						}
					}
				}
			}
		
		
		for (int nRow = 0; nRow < board.length; nRow++) {
			for (int nCol = 0; nCol <board[nRow].length; nCol++) {
				if(Row==nRow && Col==nCol && RorDown=='d' && countS<9) {
					board[nRow][nCol]="S";
					countS++;
						for(int i=Row;i<board[Col].length;i++) {
							if(countS<=2 ) {
								board[i][Col]="S";
								countS++;
							}
							if(countS<=5 && cc==2) {
								board[i][Col]="S";
								countS++;
							}
							if(countS<=10 && cc==3) {
								board[i][Col]="S";
								countS++;
							}
						}
				}
					else if(Row==nRow && Col==nCol && RorDown=='r' && countS<9) {
						board[nRow][nCol]="S";
						countS++;
						for(int rr=Col;rr<board.length;rr++) {
							if(countS<=2) {
								board[Row][rr]="S";
								countS++;
							}
							else if(countS<=5 && cc==2) {
								board[Row][rr]="S";
								countS++;
							}
							else if(countS<=10 && cc==3) {
								board[Row][rr]="S";
								countS++;
							}
						}
					}
				System.out.print(board[nRow][nCol]+ " ");
			}
			System.out.println(" ");
		}	
		if(countS==11) {
			return true;
		}
		else {
			return false;
		}
		
	}
	static void CheckCurrBoard(String[][] Origianlboard, String[][] board, int Row, int Col)
	{
		// TODO 1: Write code to print the current game state as specified
		// in the comment above
		for (int d = 0; d < Origianlboard.length; d++) {
			for (int r = 0; r <Origianlboard[d].length; r++) {
				if(Origianlboard[Row][Col]=="S") {
					board[Row][Col]="X"; //changes cell to X if ship was sunk
					}
				else if(Origianlboard[Row][Col]=="-") {
					board[Row][Col]="m"; // changes cell value to m if missed 
				}
				System.out.print(board[d][r]+ " ");
			}
			System.out.println(" ");
		}	
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
Samual Shaqqur
Project 2

Please enter a ROW number 0-6
0
Please enter a COL number 0-6
0
Please enter d(downwards) or r(rightward)
d
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S - - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
1
Please enter d(downwards) or r(rightward)
d
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S - - - - -  
2 - S - - - - -  
3 - S - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S - - - - -  
2 - S - - - - -  
3 - S - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
Please enter a ROW number 0-6
2
Please enter a COL number 0-6
2
Please enter d(downwards) or r(rightward)
d
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S - - - - -  
2 - S S - - - -  
3 - S - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S - - - - -  
2 - S S - - - -  
3 - S S - - - -  
4 - - S - - - -  
5 - - S - - - -  
6 - - - - - - -  
Please enter a ROW number 0-6
0
Please enter a COL number 0-6
0
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 - - - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
0
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
0
Please enter a COL number 0-6
1
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X - - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a Miss! 
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
1
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
2
Please enter a COL number 0-6
1
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - X - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
3
Please enter a COL number 0-6
1
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - X - - - - -  
3 - X - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
2
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - X X - - - -  
3 - X - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
2
Please enter a COL number 0-6
3
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - X X m - - -  
3 - X - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a Miss! 
Please enter a ROW number 0-6
3
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - X X m - - -  
3 - X X - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
4
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - X X m - - -  
3 - X X - - - -  
4 - - X - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
5
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X m - - - - -  
1 X X - - - - -  
2 - X X m - - -  
3 - X X - - - -  
4 - - X - - - -  
5 - - X - - - -  
6 - - - - - - -  
That was a HIT! 
Guess | Row Col 
1     | 0    0  
2     | 1    0  
3     | 0    1  
4     | 1    1  
5     | 2    1  
6     | 3    1  
7     | 2    2  
8     | 2    3  
9     | 3    2  
10     | 4    2  
11     | 5    2  
End of Program!


------------
Test Case 2:
------------
Samual Shaqqur
Project 2

Please enter a ROW number 0-6
0
Please enter a COL number 0-6
0
Please enter d(downwards) or r(rightward)
d
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S - - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
1
Please enter d(downwards) or r(rightward)
r
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S S S - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S S S - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
Please enter a ROW number 0-6
2
Please enter a COL number 0-6
2
Please enter d(downwards) or r(rightward)
d
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S S S - - -  
2 - - S - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
r\c 0 1 2 3 4 5 6  
0 S - - - - - -  
1 S S S S - - -  
2 - - S - - - -  
3 - - S - - - -  
4 - - S - - - -  
5 - - S - - - -  
6 - - - - - - -  
Please enter a ROW number 0-6
0
Please enter a COL number 0-6
0
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 - - - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
0
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - - - - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
2
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - - X - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
2
Please enter a COL number 0-6
1
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - m X - - - -  
3 - - - - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a Miss! 
Please enter a ROW number 0-6
3
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - m X - - - -  
3 - - X - - - -  
4 - - - - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
4
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - m X - - - -  
3 - - X - - - -  
4 - - X - - - -  
5 - - - - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
5
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - m X - - - -  
3 - - X - - - -  
4 - - X - - - -  
5 - - X - - - -  
6 - - - - - - -  
That was a HIT! 
Please enter a ROW number 0-6
6
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X - - - - - -  
2 - m X - - - -  
3 - - X - - - -  
4 - - X - - - -  
5 - - X - - - -  
6 - - m - - - -  
That was a Miss! 
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
1
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X X - - - - -  
2 - m X - - - -  
3 - - X - - - -  
4 - - X - - - -  
5 - - X - - - -  
6 - - m - - - -  
That was a HIT! 
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
2
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X X X - - - -  
2 - m X - - - -  
3 - - X - - - -  
4 - - X - - - -  
5 - - X - - - -  
6 - - m - - - -  
That was a HIT! 
Please enter a ROW number 0-6
1
Please enter a COL number 0-6
3
r\c  0 1 2 3 4 5 6  
0 X - - - - - -  
1 X X X X - - -  
2 - m X - - - -  
3 - - X - - - -  
4 - - X - - - -  
5 - - X - - - -  
6 - - m - - - -  
That was a HIT! 
Guess | Row Col 
1     | 0    0  
2     | 1    0  
3     | 2    2  
4     | 2    1  
5     | 3    2  
6     | 4    2  
7     | 5    2  
8     | 6    2  
9     | 1    1  
10     | 1    2  
11     | 1    3  
End of Program!

******************************************************************************/