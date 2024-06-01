import java.util.LinkedList;
import java.util.Queue;

public class TicTacToe
{
    char currentPlayer;
    Board board;
    Queue<Move> moveQueue;

    public TicTacToe() 
    {
        currentPlayer = 'X';
        board = new Board();
        board.initialize();  // Ensure the board is initialized
        moveQueue = new LinkedList<>();  
    }
    /**
     * Makes a move on the game board.
     *
     * @param  row   the row number of the move
     * @param  col   the column number of the move
     */
    public void makeMove(int row, int col) 
    { 
        // System.out.println("Attempting move by " + currentPlayer + " at (" + row + ", " + col + ")");
        // Fucked up the logic here
        if (!board.isValidMove(row, col)) {
            System.out.println("Invalid move");
            return;
        }

        if (moveQueue.size() == 6) {
            Move oldestMove = moveQueue.poll();
            board.removeMove(oldestMove.row, oldestMove.col);
        }

        board.placeMove(row, col, currentPlayer);
        moveQueue.offer(new Move(currentPlayer, row, col));
    }

    /**
     * Checks if the current player has won the game.
     *
     * @return true if the current player has won, false otherwise
     */
    public boolean checkWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board.cells[i][0] == currentPlayer && board.cells[i][1] == currentPlayer && board.cells[i][2] == currentPlayer)
                return true;
        }

        for (int i = 0; i < 3; i++)
        {
            if (board.cells[0][i] == currentPlayer && board.cells[1][i] == currentPlayer && board.cells[2][i] == currentPlayer)
                return true; 
        }

        return (board.cells[0][2] == currentPlayer && board.cells[1][1] == currentPlayer && board.cells[2][0] == currentPlayer) || 
               (board.cells[0][0] == currentPlayer && board.cells[1][1] == currentPlayer && board.cells[2][2] == currentPlayer);
    }

    /**
     * Checks if the game is over by calling the checkWin() method.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver()
    {
        return checkWin();
    }

    /**
     * Switches the current player to the other player.
     *
     * This method updates the value of the `currentPlayer` variable to the opposite player ('X' becomes 'O', and 'O' becomes 'X').
     * It then prints the current player's turn to the console.
     *
     * @return void
     */
    public void switchPlayer()
    {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        System.out.println(currentPlayer + " turn");
    }

    /**
     * Resets the game by initializing the board, clearing the move queue, and setting the current player to 'X'.
     *
     * @return void
     */
    public void resetGame()
    {
        board.initialize();
        moveQueue.clear();
        currentPlayer = 'X';
    }
}
