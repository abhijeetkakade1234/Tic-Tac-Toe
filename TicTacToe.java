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
        moveQueue = new LinkedList<Move>();  
    }
    
    /**
     * This method is used to make a move in the game.
     * It checks if the move is valid, places the move on the board, adds it to the move queue,
     * checks if the game is won, switches the player, or prints an error message.
     *
     * @param row the row index of the move (0-based)
     * @param col the column index of the move (0-based)
     */
    public void makeMove(int row, int col)
    {
        // check if move is valid
        if (board.isCellEmpty(row, col))
        {
            Move move = new Move(currentPlayer, row, col);
            board.placeMove(row, col, currentPlayer);
            moveQueue.add(move);
        }
        // check if game is won
        if(checkWin())
        {
            System.out.println("Player"+ currentPlayer +"Wins!");
            resetGame();
        }
        else if(moveQueue.size() >= 3)
        {
            Move oldestMove = moveQueue.remove();
            board.removeMove(oldestMove.row, oldestMove.col);
            switchPlayer();
        }
        else
            System.out.println("Invalid move");
        
    }

    public boolean  checkWin()
    {
        // check if game is won for row or col
        for (int i = 0; i < 3; i++)
        {
            // for row
            if (board.cells[i][0] == currentPlayer && board.cells[i][1] == currentPlayer && board.cells[i][2] == currentPlayer)
                return true;
            // for col
            if (board.cells[0][i] == currentPlayer && board.cells[1][i] == currentPlayer && board.cells[2][i] == currentPlayer)
                    return true; 
        }
        // check if game is won for diagonal
        if (board.cells[0][0] == currentPlayer && board.cells[1][1] == currentPlayer && board.cells[2][2] == currentPlayer)
            return true;
        
        // check if game is won for anti diagonal
        if (board.cells[0][2] == currentPlayer && board.cells[1][1] == currentPlayer && board.cells[2][0] == currentPlayer )
            return true;
        
        return false;
    }

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
        if (currentPlayer == 'X') 
            currentPlayer = 'O';
        else 
            currentPlayer = 'X';
        
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