
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        TicTacToe game = new TicTacToe();
        board.initialize();
        System.out.println("Player "+game.currentPlayer+ " Move");
        while(!game.isGameOver())
        {
            System.out.println("Enter row:");
            int row = sc.nextInt();
            System.out.println("Enter coloum:");
            int col = sc.nextInt();
            board.placeMove(row, col, game.currentPlayer);
            game.makeMove(row, col);
            System.out.println("Press 1 to undo Or Press 2 to Continue");
            int undo = sc.nextInt();
            if(undo == 0)
            {
                board.removeMove(row, col);
                board.printBoard();
            }
            if (game.checkWin())
            {
                System.out.println(game.currentPlayer+" WON");
                game.resetGame();
            }
            game.switchPlayer();
        }
    }
}
