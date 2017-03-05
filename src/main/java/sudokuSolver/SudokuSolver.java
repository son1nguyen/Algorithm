package sudokuSolver;

public class SudokuSolver {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Controller());
        t.start();
    }
}
