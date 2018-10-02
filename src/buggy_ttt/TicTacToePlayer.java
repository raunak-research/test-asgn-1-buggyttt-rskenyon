package buggy_ttt;
/**
 * Represents a player in the TicTacToe Game
 * @author Dr. Raunak 
 * @version 1.0 4/5/2018
 */

import java.util.*;

public class TicTacToePlayer {
	
	private TicTacToeBoard board;
	private String playerName;
	private char playerSymbol;

	/**
	 * Parameterized Constructor
	 * @param inputBoard the board this player will play with
	 * @param inputPlayerSymbol the symbol with which this player will play
	 */
	public TicTacToePlayer(TicTacToeBoard inputBoard, String name, char inputPlayerSymbol ) {
		board = inputBoard;
		playerName = name;
		playerSymbol = inputPlayerSymbol;
	}
	
	/**
	 * Getter name for the player symbol
	 * @return Returns the single player character 'X' or 'Y'
	 */
	public char getPlayerSymbol() {
		return playerSymbol;
	}
	
	/**
	 * Getter for the playerName field
	 * @return 
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * Gets the players Player X
	 * @return String 
	 */
	public String toString() {
		return "Player " + playerSymbol + "(" + playerName + ")";
	}
	
	/**
	 * Collect and place a move by one player - checks that move is valid - uses methods from Board class
	 */
	public void getAndPlacePlayerMove() {
		
		Scanner scan = new Scanner(System.in);
		int row = 0;
		int col = 0;
		do {	
			System.out.println( this.toString() + ", enter your move: ");
			row = scan.nextInt();
			col = scan.nextInt();
		} while ( !board.isValidMove(row, col) );
		
		placeMove(row, col);
		scan.close();
	}
	
	/**
	 * place the move
	 * @param rowNo the row number of the play location
	 * @param colNo the column number of the play location
	 */
	private void placeMove(int rowNo, int colNo) {
		board.placeMove (rowNo, colNo, playerSymbol);
	}
}


