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
    
    public void makeMove(int row, int col)
    {
        // check if move is valid
        // check if game is won
        // check if game is tied
    }

    public void checkWin()
    {
        // check if game is won
    }

    public void switchPlayer()
    {
        // switch player
    }

    public void resetGame()
    {
        // reset game
    }
}