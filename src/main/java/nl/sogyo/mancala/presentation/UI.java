package nl.sogyo.mancala.presentation;

import javax.swing.*;
import java.awt.*;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.presentation.UI
 * <p>
 * Created by kverlaan
 * on 10/23/2017
 */
public class UI extends JFrame {
    
    private UI() throws HeadlessException {
        
        setBounds(50, 50, 800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setVisible(true);
        
    }
    
    public static void main(String... args) {
        //ADD CODE HERE
        new UI();
    }
}
