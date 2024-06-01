public class Board 
{
    public char[][] cells = new char[3][3];
    /**
    * Initializes() the game board by setting all cells to empty spaces.
    */
    public void initialize()
    {
        //initialize board
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                cells[row][col] =' ';
            }
        }
    }

    /**
     * Checks if the specified cell on the game board is empty.
     *
     * @param row The row index of the cell to check.
     * @param col The column index of the cell to check.
     * @return {@code true} if the cell is empty (contains a space character), {@code false} otherwise.
     */
    public boolean isCellEmpty(int row, int col)
    {
        //check if cell is empty
        return cells[row][col] == ' ';
    }

    public void placeMove(int row, int col, char player)
    {
        //place move on board
        cells[row][col] = player;
    }

    public void removeMove(int row, int col)
    {   
        // remove move from board
        cells[row][col] =' ';
    }

    /**
     * Prints the current state of the game board to the console.
     * The board is displayed as a grid of characters, with each cell containing either a space (' '), 'X', or 'O'.
     * The rows are separated by newline characters, and the columns are separated by space characters.
     */
    public void printBoard() 
    {
        for (int row = 0; row < 3; row++) 
        {
            for (int col = 0; col < 3; col++) 
            {
                System.out.print(cells[row][col]);
                if (col < 2) System.out.print("|");
            }
            System.out.println();
            if (row < 2) System.out.println("-----");
        }
    }

    /**
     * Checks if the specified cell on the game board is a valid move.
     *
     * @param row The row index of the cell to check (0-based).
     * @param col The column index of the cell to check (0-based).
     * @return {@code true} if the cell is within the board bounds and empty, {@code false} otherwise.
     */
    public boolean isValidMove(int row, int col) 
    {
        //check if cell is within the board bounds and empty
        return row >= 0 && row < 3 && col >= 0 && col < 3 && cells[row][col] == ' ';
    }
}
