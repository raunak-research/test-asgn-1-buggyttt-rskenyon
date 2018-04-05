package buggy_ttt;

import java.util.*;
/**
 * This class creates all the objects and perform user interaction to
 * play a text-based Tic-Tac-Toe Game
 * @author Dr. Raunak
 * @version 1.0 4/4/2018
 */

public class GameManager {

	public static void main(String args[]) {
		
		Scanner kbScanner = new Scanner(System.in);
		String playerName1, playerName2;
		
		//directions - welcome to game
		System.out.println("Welcome to the Game of TIC TAC TOE");
		System.out.println("--------------");
		
		System.out.println("Enter player one's name: ");
		playerName1 = kbScanner.next();
		System.out.println("Enter player two's name: ");
		playerName2 = kbScanner.next();
		
		System.out.println("Enter Coordinates (1-3) of the Board with a single space in between X and Y");
		System.out.println("For example, to represent row 3 col 2 enter: 3 2");
		System.out.println("");
		
		//Instantiate all pieces of game
		TicTacToeBoard board = new TicTacToeBoard();
		TicTacToePlayer playerO = new TicTacToePlayer(board, playerName1, 'O');
		TicTacToePlayer playerX = new TicTacToePlayer(board, playerName2, 'X');
		
		// TicTacToeGame game = new TicTacToeGame(board, playerO, playerX);

		//do loop to continue playing or exit
		String playAgain;
		do {
			//creates new game - clears board
			board.reset();
			
			//display board
			System.out.println( board );
			
			//instantiate counter 
			int moveCounter = 1;
		
			//loop to switch turns until game is over - moveCounter will alternate players
			//to check if there is a winner every turn
			do {
				
				//Determine which player is going
				if(moveCounter % 2 == 0) 
					playerO.getAndPlacePlayerMove();
				else
					playerX.getAndPlacePlayerMove();
				
				//update counte
				moveCounter++;
				
				System.out.println(board);
				
			} while ( !board.isGameOver() );
			
			// Game Over - Give Results
			if( board.hasWinner() )
				System.out.println("Congratulations to Player " + board.whoWon() + "! You won!");
			else
				System.out.println("Nobody won!, It's a Tie");
		
			//ask to play again
			Scanner scan = new Scanner(System.in);
			System.out.println("Do you want to play again? (y/n)");
			playAgain = scan.next();
		
		} while ( playAgain.equalsIgnoreCase("y") ); 
		
		System.out.println("Exiting...");
		System.out.println("Thank you for playing. Goodbye!");
		
	}
	
}