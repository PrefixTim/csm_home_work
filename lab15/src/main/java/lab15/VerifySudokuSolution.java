package lab15;

public class VerifySudokuSolution {
    public static void main(String[] args) {
        // Sudoku example from Wikipedia
        int[][] arr = {
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        // Solution should have 3 x 3 subsquares containing no duplicates
        System.out.println(checkSudokuSolution(arr, 3));

        // Swap a couple of values to mess something up, check it again
        int temp = arr[2][3];
        arr[2][3] = arr[5][6];
        arr[5][6] = temp;
        System.out.println(checkSudokuSolution(arr, 3));
    }

    /*
     * Check whether the given 2D array is a valid Sudoku solution.
     *
     * grid: the 2D array to check
     * subSquareSize: size of the subsquares in the solution
     * return true if the given array is a valid solution, false otherwise
     */
    public static boolean checkSudokuSolution(int[][] grid, int subSquareSize) {
        final int size = grid.length;

        // First make sure all the values are in the right range.
        if (!checkValues(grid, 1, size)) {
            return false;
        }
        // Check that the rows contain no duplicate values
        for (int row = 0; row < size; ++row) {
            if (!checkRow(grid, row)) {
                return false;
            }
        }
        // Check that the columns contain no duplicate values
        for (int col = 0; col < size; ++col) {
            if (!checkColumn(grid, col)) {
                return false;
            }
        }
        // Check that the subsquares contain no duplicate values
        for (int baseRow = 0; baseRow < size; baseRow += subSquareSize) {
            for (int baseCol = 0; baseCol < size; baseCol += subSquareSize) {
                if (!checkSquare(grid, baseRow, baseCol, subSquareSize)) {
                    return false;
                }
            }
        }

        // If we made it to this point, everything is correct!
        return true;
    }

    /*
     * grid: the 2D array to check
     * min: the smallest allowable value
     * max: the largest allowable value
     * return true if all values in grid are between min and max
     * false if some value in the array is less than min or
     * greater than max
     */
    private static boolean checkValues(int[][] grid, int min, int max) {
        for (int[] rows : grid) {
            for (int i : rows) {
                if (min > i || i > max) return false;
            }
        }
        return true;
    }

    /*
     * grid: the 2D array to check
     * whichRow: the row to check
     * return true if the row contains no duplicate values, false otherwise
     */
    private static boolean checkRow(int[][] grid, int whichRow) {
        final int size = grid.length;
        boolean[] found = new boolean[size];
        for (int col = 0; col < size; ++col) {
            // set found[x - 1] to be true if we find x in the row
            int index = grid[whichRow][col] - 1;
            if (!found[index]) {
                found[index] = true;
            } else {
                // found it twice, so return false
                return false;
            }
        }
        // didn't find any number twice, so return true
        return true;
    }

    /*
     * grid: the 2D array to check
     * whichCol: the column to check
     * return true if the column contains no duplicate values, false otherwise
     */
    private static boolean checkColumn(int[][] grid, int whichCol) {
        // Your code goes here...
        int[][] temp = new int[grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                temp[j][i] = grid[i][j];
            }
        }
        return checkRow(temp, whichCol);
    }

    /*
     * grid: the 2D array to check
     * baseRow: topmost row of the square
     * baseCol: leftmost column of the square
     * subSquareSize: the size of the subsquare to be checked
     * return true if the square contains no duplicates, false otherwise
     */
    private static boolean checkSquare(int[][] grid, int baseRow,
                                       int baseCol, int subSquareSize) {
        // Your code goes here...
        int[][] temp = new int[1][grid.length];
        for (int i = 0; i < subSquareSize ; i++) {
            for (int j = 0; j < subSquareSize; j++) {
                temp[0][i*j+i+j] = grid[baseRow + i][baseCol + j];
            }
        }
        return checkColumn(temp, 0);
    }
}