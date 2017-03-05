package sudokuSolver;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author sonnguyen
 */
public class Controller implements Runnable {

    private Model model;
    private ButtonView buttonView;

    public Controller() {
        this.model = new Model();
        this.buttonView = new ButtonView(model);

        //Add listener to the model
        this.model.setListener(buttonView);
    }

    /**
     * Start solving the Sudoku
     */
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            model.solve(0, 0);
        } catch (Exception ex) {
        }
    }
}
