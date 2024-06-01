
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) {
            Board board = new Board();
            TicTacToe game = new TicTacToe();
            board.initialize();
            

            System.out.println("Player "+game.currentPlayer+ " Move");
            while(true)
            {
                board.printBoard();
                System.out.println("Enter row (0, 1, or 2):");
                int row = sc.nextInt();
                System.out.println("Enter column (0, 1, or 2):");
                int col = sc.nextInt();
                
                game.makeMove(row, col);
                
                if (game.checkWin())
                {
                    System.out.println(game.currentPlayer+" WON");
                    System.out.println("DO YOU WANT TO PLAY NEXT ROUND ");
                    System.out.println("Press 0 to resart OR any number to QUIT");
                    int br = sc.nextInt();
                    if(br == 0)
                    {
                        game.resetGame();
                        board.initialize();
                    }
                    else break;
                }
                else game.switchPlayer();
            }
        }
    }
}
