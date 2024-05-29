public class Board 
{
    public char[][] cells = new char[3][3];
    /**
    * Initializes the game board by setting all cells to empty spaces.
    */
    public void initialize()
    {
        //initialize board
        for (int row = 0; row < cells.length; row++)
        {
            for (int col = 0; col < cells[row].length; col++)
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
        if (!isCellEmpty(row, col))
            throw new IllegalArgumentException("The specified cell is not empty.");
        
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
        // Iterate over each row of the board
        for (int row = 0; row < cells.length; row++)
        {
            // Iterate over each column of the current row
            for (int col = 0; col < cells[row].length; col++)
            {
                // Print the character at the current cell
                System.out.print(cells[row][col] + " ");
            }
            // Move to the next line after printing all columns of the current row
            System.out.println();
        }
        // Add an extra newline character for better readability
        System.out.println();
    }
    
}
