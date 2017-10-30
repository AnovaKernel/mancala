package nl.sogyo.mancala.presentation;

import javax.swing.*;

/**
 * Created by Koen on 30/10/2017.
 */
public class GUI {
    public  GUI(){
        JFrame frame = new JFrame();
        frame.setTitle("Mancala");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        initComponents(frame);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    private void initComponents(JFrame frame) {
        frame.add(new GameBoard());
    }
}
