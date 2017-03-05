package sudokuSolver;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {

    //Private instance variables
    public static final int DIMENSION = 9;
    public static final int BOX_SIZE = (int) Math.sqrt(DIMENSION);

    public int[][] board = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}};
    private ChangeListener listener;

    public int[][] getBoard() {
        return board;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    public ChangeListener getListener() {
        return listener;
    }

    /**
     * This method solves the Sudoku starting from the first cell
     *
     * @param row
     * @param col
     */
    public void solve(int row, int col) throws Exception {
        if (row >= DIMENSION) {
            System.out.println("Solution Found!!");
        }

        if (board[row][col] != 0) {
            if (col == DIMENSION - 1) {
                solve(row + 1, 0);
            } else {
                solve(row, col + 1);
            }
        } else {
            for (int i = 1; i < DIMENSION + 1; i++) {
                if (validChoice(row, col, i)) {
                    board[row][col] = i;
                    listener.stateChanged(new ChangeEvent(board));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (col == DIMENSION - 1) {
                        solve(row + 1, 0);
                    } else {
                        solve(row, col + 1);
                    }
                }
            }
            board[row][col] = 0;
        }
    }

    /**
     * The method checks whether the number is correct according to the row, col, and block
     *
     * @param row
     * @param col
     * @param num
     * @return true if the number is valid, false if not
     */
    private boolean validChoice(int row, int col, int num) {
        int r = (row / BOX_SIZE) * BOX_SIZE;
        int c = (col / BOX_SIZE) * BOX_SIZE;
        //System.out.println(row + "  " + col);
        for (int i = 0; i < DIMENSION; i++) {
            if (board[row][i] == num
                    || board[i][col] == num
                    || board[r + (i % BOX_SIZE)][c + (i / BOX_SIZE)] == num) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method prints the Sudoku to the console
     */
    public void print() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }

}
