
import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        TicTacToe game = new TicTacToe();
        game.moveQueue.clear();
        board.initialize();
        System.out.println("Player "+game.currentPlayer+ " Move");
        while(!game.isGameOver())
        {
            System.out.println("Enter row (0, 1, or 2):");
            int row = sc.nextInt();
            System.out.println("Enter column (0, 1, or 2):");
            int col = sc.nextInt();

            if (!board.isValidMove(row, col)) 
            {
                System.out.println("Invalid move, try again.");
            }


            board.placeMove(row, col, game.currentPlayer);
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
                    continue;
                }
                else break;
            }
            game.switchPlayer();
        }
        sc.close();
    }
}
