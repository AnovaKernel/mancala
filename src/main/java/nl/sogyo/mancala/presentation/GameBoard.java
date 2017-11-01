package nl.sogyo.mancala.presentation;

import nl.sogyo.mancala.logic.Bowl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by Koen on 30/10/2017.
 */
public class GameBoard extends JPanel {
    
    private final ArrayList<BoardObject> boardObjects;
    private Dimension   dim    = new Dimension(400, 400);
    private BasicStroke stroke = new BasicStroke(10);
    
    GameBoard() {
        
        boardObjects = new ArrayList<>(14);
        Bowl bowl = new Bowl();
        
        int x = (int) dim.getWidth() / 10;
        int y = (int) dim.getHeight() / 10;
        boardObjects.add(new BoardObject(2 * x, 6 * y, 1 * x, 1 * y, bowl.getNeighbour(0)));
        boardObjects.add(new BoardObject(3 * x, 6 * y, 1 * x, 1 * y, bowl.getNeighbour(1)));
        boardObjects.add(new BoardObject(4 * x, 6 * y, 1 * x, 1 * y, bowl.getNeighbour(2)));
        boardObjects.add(new BoardObject(5 * x, 6 * y, 1 * x, 1 * y, bowl.getNeighbour(3)));
        boardObjects.add(new BoardObject(6 * x, 6 * y, 1 * x, 1 * y, bowl.getNeighbour(4)));
        boardObjects.add(new BoardObject(7 * x, 6 * y, 1 * x, 1 * y, bowl.getNeighbour(5)));
        boardObjects.add(new BoardObject(8 * y, 4 * y, 1 * x, 3 * y, bowl.getNeighbour(6)));
        boardObjects.add(new BoardObject(7 * x, 4 * y, 1 * x, 1 * y, bowl.getNeighbour(7)));
        boardObjects.add(new BoardObject(6 * x, 4 * y, 1 * x, 1 * y, bowl.getNeighbour(8)));
        boardObjects.add(new BoardObject(5 * x, 4 * y, 1 * x, 1 * y, bowl.getNeighbour(9)));
        boardObjects.add(new BoardObject(4 * x, 4 * y, 1 * x, 1 * y, bowl.getNeighbour(10)));
        boardObjects.add(new BoardObject(3 * x, 4 * y, 1 * x, 1 * y, bowl.getNeighbour(11)));
        boardObjects.add(new BoardObject(2 * x, 4 * y, 1 * x, 1 * y, bowl.getNeighbour(12)));
        boardObjects.add(new BoardObject(1 * x, 4 * y, 1 * x, 3 * y, bowl.getNeighbour(13)));
        
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
                super.mouseClicked(e);
                for (BoardObject b : boardObjects) {
                    if (b.contains(e.getPoint())) {
                        (b).play();
                        //System.out.println(b.getClass().getName());
                        repaint();
                    }
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                checkContains(e);
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                
                checkContains(e);
                
            }
        });
        addMouseMotionListener(new MouseMotionListener() {
            
            @Override
            public void mouseDragged(final MouseEvent e) {
                
                checkContains(e);
            }
            
            @Override
            public void mouseMoved(final MouseEvent e) {
                
                checkContains(e);
            }
        });
    }
    
    private void checkContains(MouseEvent e) {
        
        for (BoardObject b : boardObjects) {
            if (b.contains(e.getPoint())) {
                b.grow();
                repaint(b.getBounds());
            } else {
                b.defaultSize();
                repaint();
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        for (BoardObject b : boardObjects) {
            g2d.draw(b);
            g2d.drawString(b.getScore(), (float) b.getBounds2D().getCenterX(), (float) b.getBounds2D().getCenterY());
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        
        return dim;
    }
}
