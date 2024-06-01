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
        moveQueue = new LinkedList<>();  
    }
    
    /**
     * This method is used to make a move in the game.
     * It checks if the move is valid, places the move on the board, adds it to the move queue,
     * checks if the game is won, switches the player, or prints an error message.
     * @param row the row index of the move (0-based)
     * @param col the column index of the move (0-based)
     */
    public void makeMove(int row, int col) 
    {
        // Fucked up code here
        if (board.isValidMove(row, col)) {
            System.out.println("Invalid move");
            return;
        }
        
        if (board.isCellEmpty(row, col)) 
        {
            System.out.println("Cell is occupied");
            return;
        }
        
        if (moveQueue.size() == 3) {
            Move oldestMove = moveQueue.poll();
            board.cells[oldestMove.row][oldestMove.col] = ' ';
        }
        
        board.cells[row][col] = currentPlayer;
        moveQueue.offer(new Move(currentPlayer, row, col));
    }

    /**
    * Checks if the current player has won the game by checking for a win in rows, columns, or diagonals.
    *
    * @return  true if the current player has won, false otherwise
    */
    public boolean checkWin()
    {
        // check if game is won for row or col
        for (int i = 0; i < 3; i++)
        {
            // for row
            if (board.cells[i][0] == currentPlayer && board.cells[i][1] == currentPlayer && board.cells[i][2] == currentPlayer)
                return true;
        }

        for (int i = 0; i < 3; i++)
        {
            // for col
            if (board.cells[0][i] == currentPlayer && board.cells[1][i] == currentPlayer && board.cells[2][i] == currentPlayer)
                return true; 
        }

        // check if game is won for anti diagonal and  check if game is won for diagonal
        return (board.cells[0][2] == currentPlayer && board.cells[1][1] == currentPlayer && board.cells[2][0] == currentPlayer) || (board.cells[0][0] == currentPlayer && board.cells[1][1] == currentPlayer && board.cells[2][2] == currentPlayer);
    }

    /**
    * Checks if the game is over by calling the checkWin() method.
    *
    * @return  true if the game is over, false otherwise
    */
    public boolean isGameOver()
    {
        // check if game is over
        return checkWin();
    }

    /**
    * This method is used to switch the current player.
    * It checks the current player and switches it to the other player.
    * If the current player is 'X', it switches to 'O'.
    * If the current player is 'O', it switches to 'X'.
    */
    public void switchPlayer()
    {
        // switch player
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        System.out.println(currentPlayer +" turn");
    }

    /**
     * This method is used to reset the game.
     * It clears the board, removes all moves from the move queue,
     * and switches the current player back to 'X'.
     */
    public void resetGame()
    {
        // reset game
        board.initialize(); // clears the board
        moveQueue.clear(); // removes all moves from the move queue
        currentPlayer = 'X'; // switches the current player back to 'X'
    }
}