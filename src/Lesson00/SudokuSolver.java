//package Lesson00; //SUBMITTED BY: David(LI ZEMAN)
import java.awt.Point;
import java.util.Stack;

public class SudokuSolver {
// non-recursive, stack-based, backtracking solver of sudoku puzzles

    int[][] grid;
    Stack<Point> stack;  // Recall Point objects wrap two ints into a single object
    // Check the Java API for more information on the Point class...

    public SudokuSolver(int[][] grid) {
        // Insert code here...
        // Hint: Make sure to make a defensive copy of the grid.
        this.stack = new Stack<>();
        this.grid = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    private boolean isInRow(int num, int row) {
        for(int i = 0; i < this.grid[0].length; i++)
            if (this.grid[i][row] == num)
                return true;
        return false;
    }

    private boolean isInCol(int num, int col) {
        for(int i = 0; i < this.grid.length; i++)
            if (this.grid[col][i] == num)
                return true;
        return false;
    }

    private boolean isInBox(int row, int col, int num) {
        int boxRowStart = (row / 3) * 3;
        int boxRowend  = boxRowStart + 3;

        int boxColumnStart = (col / 3) * 3;
        int boxColumnEnd = boxColumnStart + 3;

        for (int i = boxRowStart; i < boxRowend; i++)
            for (int j = boxColumnStart; j < boxColumnEnd; j++)
                if (this.grid[j][i] == num)
                    return true;
        return false;
    }

    private Point nextBlank() {
        for (int i = 0; i < this.grid.length; i++)
            for (int j = 0; j < this.grid[0].length; j++)
                if (this.grid[i][j] == 0)
                    return new Point(j, i);
        return null;
    }

    private boolean safeToPutNumInPos(int num, int row, int col) {
        return !isInBox(row, col, num) && !isInCol(num, col) && !isInRow(num, row);
    }

    private void printStack() {
        // Not necessary, but useful for debugging...
        for (Point p : this.stack) {
            System.out.println(p);
        }
    }

    // Insert additional methods here, as desired

    public boolean solve() {
        // Insert code here...
        int num = 1;

        while (nextBlank() != null) {
            Point now  = nextBlank();
            for(; num <= 10; num++) {
                if (num == 10) {
                    if (!stack.isEmpty()) {
                        Point tmp = stack.pop();
                        num = this.grid[tmp.y][tmp.x] + 1;
                        this.grid[tmp.y][tmp.x] = 0;
                        break;
                    }
                } else {
                    if (safeToPutNumInPos(num, now.x, now.y)) {
                        this.stack.push(new Point(now.x, now.y));
                        this.grid[now.y][now.x] = num;
                        num = 1;
                        break;
                    }
                }
            }
            if (stack.isEmpty())
                return false;
//            printStack();
//            System.out.println("===================================");
        }
        return true;
    }

    public void printGrid() {
        // Prints this.grid - needed in main(), also useful for debugging...
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++)
                System.out.print(this.grid[row][col] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] solvableGrid = {{0,3,9,0,0,0,7,0,0},
                                {0,0,0,7,0,0,1,0,0},
                                {6,0,0,0,8,0,0,0,4},
                                {8,0,4,0,0,7,0,0,6},
                                {0,0,0,8,0,0,4,0,0},
                                {0,5,0,2,0,6,8,1,0},
                                {0,0,0,0,0,0,0,7,0},
                                {5,8,0,0,0,3,9,4,0},
                                {7,2,3,4,0,8,6,0,0}};

        int[][] unsolvableGrid = {{3,1,6,5,7,8,4,2,0},
                                 {5,2,0,0,0,0,0,0,0},
                                 {0,8,7,0,0,0,0,3,1},
                                 {0,0,3,0,1,0,0,8,0},
                                 {9,0,0,8,6,3,0,0,5},
                                 {0,5,0,0,9,0,6,0,0},
                                 {1,3,0,0,0,0,2,5,0},
                                 {0,0,0,0,0,0,0,7,4},
                                 {0,0,5,2,0,6,3,0,0}};

        System.out.println("Testing solvable puzzle...\n");
        SudokuSolver sudokuSolver = new SudokuSolver(solvableGrid);
        if (sudokuSolver.solve())
            sudokuSolver.printGrid();
        else {
            System.out.println("No solution exists");
        }

        System.out.println("=================\n");

        System.out.println("Testing unsolvable puzzle...\n");
        sudokuSolver = new SudokuSolver(unsolvableGrid);
        if (sudokuSolver.solve())
            sudokuSolver.printGrid();
        else {
            System.out.println("No solution exists");
        }
    }
}
