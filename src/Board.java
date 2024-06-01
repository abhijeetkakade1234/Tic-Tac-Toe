public class Board 
{
    public char[][] cells = new char[3][3];

    /**
     * Initializes the 3x3 game board by setting all cells to an empty space.
     *
     * This function iterates over each row and column of the game board and
     * assigns the character ' ' (empty space) to each cell. This effectively
     * clears the board for a new game.
     */
    public void initialize()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                cells[row][col] = ' ';
            }
        }
    }

    /**
     * Checks if the cell at the specified row and column is empty.
     *
     * @param  row  the row index of the cell (0-based)
     * @param  col  the column index of the cell (0-based)
     * @return      true if the cell is empty, false otherwise
     */
    public boolean isCellEmpty(int row, int col)
    {
        return cells[row][col] == ' ';
    }

    /**
     * Places a move on the game board at the specified row and column.
     *
     * @param  row    the row index of the cell (0-based)
     * @param  col    the column index of the cell (0-based)
     * @param  player the player making the move ('X' or 'O')
     */
    public void placeMove(int row, int col, char player)
    {
        cells[row][col] = player;
    }

    /**
     * Removes the move at the specified row and column by setting the corresponding cell to an empty space.
     *
     * @param  row  the row index of the cell (0-based)
     * @param  col  the column index of the cell (0-based)
     */
    public void removeMove(int row, int col)
    {   
        cells[row][col] = ' ';
    }
    
    /**
     * Prints the current state of the game board to the console.
     *
     * This function iterates over each row and column of the game board and prints
     * the contents of each cell. It uses the "|" character to separate the cells
     * in each row, and prints a line of dashes ("-----") between each row.
     *
     * @param  None
     * @return None
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

    public boolean isValidMove(int row, int col) 
    {
        boolean withinBounds = row >= 0 && row < 3 && col >= 0 && col < 3;
        boolean cellEmpty = cells[row][col] == ' ';
        // System.out.println("Checking move validity at (" + row + ", " + col + "): withinBounds = " + withinBounds + ", cellEmpty = " + cellEmpty);
        return withinBounds && cellEmpty;
    }
}
