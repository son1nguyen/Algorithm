package sudokuSolver;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author sonnguyen
 */
public class ButtonView extends JFrame implements ChangeListener {

    //Private instance variables
    private Model model;
    private JPanel boardPanel = new JPanel(new GridLayout(9, 9));

    public ButtonView(Model model) {
        this.model = model;
        setSize(310, 310);
        setLayout(new BorderLayout());
        makeBoard();

        add(boardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        makeBoard();
    }

    public void makeBoard() {
        boardPanel.removeAll();
        int[][] board = model.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                JButton text = new JButton(String.valueOf(board[i][j]));
                boardPanel.add(text);
            }
        }
        revalidate();
        repaint();
    }

}
