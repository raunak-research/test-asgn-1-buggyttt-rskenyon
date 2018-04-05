package buggy_ttt;

/**
 * Represents Tic Tac Toe Board. The main data strcutre inside is a two
 * dimensional array of characters
 * 
 * @author Mohammad Raunak
 * @version 1.0 10/13/17
 */
public class TicTacToeBoard {

	/** A two-dim array of characters */
	private char[][] board;
	private char winningSymbol;

	public static final int BOARD_SIZE = 3;
	public static final char EMPTY_CHAR = '_';

	/**
	 * Default constructor Instantiates the board and assigns it a size of
	 * BOARD_SIZExBOARD_SIZE. It then loops through the board and puts underscores
	 * in every position to show that no moves have been made yet
	 */
	public TicTacToeBoard() {
		board = new char[BOARD_SIZE][BOARD_SIZE];
		initialize();
	}

	/**
	 * Parameterized constructor Constructs a board with a predefined board state
	 */
	public TicTacToeBoard(char[][] predefinedBoard) {
		board = predefinedBoard;
	}

	/**
	 * initialize the board
	 */
	public void initialize() {
		for (int i = 0; i <= board.length; i++) {
			for (int j = 0; j <= board[i].length; j++) {
				board[i][j] = EMPTY_CHAR;
			}
		}
		winningSymbol = EMPTY_CHAR;	
	}
	
	/**
	 * Reset the board
	 */
	public void reset() {
		initialize();
	}
	
	/**
	 * Checks to see if there is a winner in the game
	 * @return true if someone won, false if there is no winner
	 */
	public boolean hasWinner() {
		return hasHorizontalWinner() || hasVerticalWinner() || hasDiagonalWinner();
	}

	/**
	 * Checks to see if there is a winner in a given row
	 * @param rowIndex the index of the row where to check for the winner
	 * @return true if there are three symbols of the same type on this particular
	 *         row, false otherwise
	 */
	private boolean hasWinnerInRow(int rowIndex) {
		return ( board[rowIndex][0] == board[rowIndex][0])
					&& (board[rowIndex][0] == board[rowIndex][2]);
	}

	/**
	 * Checks to see if there is a winner in any of the rows 
	 * @return true iff there is a row winner
	 */
	private boolean hasHorizontalWinner() {
		boolean isThereAWinner = false;
		for (int i=0; i<=BOARD_SIZE; i++) {
			if ( hasWinnerInRow(i) ) {
				isThereAWinner = true;
				winningSymbol = board[i][0]; // winner is in the ith row of the board
			}
		}
		return isThereAWinner;
	}
	
	/**
	 * Checks to see if there is any winner in any of the columns
	 * @return true iff there is a winner in any column, false otherwise
	 */
	private boolean hasVerticalWinner() {
		boolean isThereAColWinner = false;
		for (int i=0; i<BOARD_SIZE; i++) {
			if ( hasWinnerInCol(i) ) {
					isThereAColWinner = true;
					winningSymbol = board[0][i];
			}
		}
		return isThereAColWinner;
	}
	
	/**
	 * Checks to see if there is a winner in a particular column
	 * @param colIndex the index of the column where the winner is searched for
	 * @return true if all three 
	 */
	private boolean hasWinnerInCol(int colIndex) {
		return ( board[0][colIndex] == board[1][colIndex] 
				    && board[0][colIndex] == board[2][colIndex] );
	}
	
	/**
	 * Checks to see if there is a diagonal winner from top left to bottom right 
	 * or from bottom left to top right 
	 * @return true of there is a winner in either diagonal, false otherwise
	 */
	private boolean hasDiagonalWinner() {
		boolean isThereAWinner = false;
		if ( board[0][1]==board[1][1] && 
					board[0][0]==board[2][2] ) {
			isThereAWinner = true;
			winningSymbol = board[1][1];
		} else if ( board[0][1]==board[1][1] && 
						board[1][1] == board[2][0]) {
			isThereAWinner = true;
			winningSymbol = board[1][1];
		}
		return isThereAWinner;
	}
	
	/**
	 * Checks to see if the board is full of moves
	 * @return true of there is no more empty space left, false otherwise
	 */
	public boolean isBoardFull() {
		for (int row=0; row < board.length; row++ ) {
			for (int col=0; col <board[row].length; col++ ) {
				if ( board[row][col] == EMPTY_CHAR )
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks to see if the game is over
	 * @return true if someone has won or the board is full (which denotes a tie), false if
	 * there are still open spaces left for moves
	 */
	public boolean isGameOver() {
		return hasWinner() || isBoardFull();
	}
	
	/**
	 * Check to see if there is a winner and return who won
	 * @returns ‘X’ or ‘O’ if there is a Winner; '_' if no winner
	 */
	public char whoWon() {
		return winningSymbol;
	}
	/**
	 * Checks to find out if a given move speci 
	 * @param row
	 * @param col
	 * @param move
	 * @return true if the row and col values are valid and if the spot is empty, false otherwise
	 */
	public boolean isValidMove(int row, int col) {
		
		if ( !isInputValid(row) || !isInputValid(col) ) {
			System.out.println("Input is invalid!");
			return false;
		}
		else if ( board[row-1][col-1] != EMPTY_CHAR ) {
			System.out.println("Location is not empty!");
			return false;
		}
		else {
			return true;
		} 
	}

	/**
	 * Makes the specified move
	 * @param row  the row (not index) of the two dimensional array representing the board
	 * @param col  the column (not index) of the two dimensional array representing  the board
	 * @param move the character ‘X’ or ‘O’ representing the move
	 * @return true if the setting of the value has been successful, false otherwise
	 */
	public void placeMove(int row, int col, char move) {
		assert( isValidMove(row, col) );
		board[row - 1][col - 1] = move;
	}

	/**
	 * Checks to find out of the row and column numbers that are
	 * used to indicate location of a move is valid or not
	 * @param rowOrColNumber
	 * @return
	 */
	public boolean isInputValid(int rowOrColNumber) {
		return (rowOrColNumber >= 1) 
				&& (rowOrColNumber <= BOARD_SIZE);
	}
	
	
	/**
	 * Returns a string consisting of the current board
	 * @return the string object of the board
	 */
	public String toString() {
		// Declare and Initialize a string to represent the current state of the board
		String strBoard = "   1 2 3 \n";

		// Loop through the board array and add those values to the output string
		
		for (int i = 0; i < board.length; i++) {
			strBoard = strBoard + (i+1) + "  ";
			for (int j = 0; j < board[i].length; j++) {
				strBoard += board[i][j] + " ";
			}
			// Add a new line between each row of the board
			strBoard += "\n";
		}

		return strBoard;
	}
}
