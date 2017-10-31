package nl.sogyo.mancala.presentation;

import nl.sogyo.mancala.logic.BeadContainer;

import java.awt.geom.Ellipse2D;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.presentation.BoardObject
 * <p>
 * Created by kverlaan
 * on 31-Oct-17
 */
public class BoardObject extends Ellipse2D.Double {
    
    private BeadContainer beadContainer;
    
    public BoardObject() {}
    
    BoardObject(final int x, final int y, final int w, final int h, final BeadContainer beadContainer) {
        
        super(x, y, w, h);
        this.beadContainer = beadContainer;
    }
    
    public void play() {
        
        beadContainer.play();
    }
    
    String getScore() {
        
        return "" + beadContainer.getBeads();
    }
}
