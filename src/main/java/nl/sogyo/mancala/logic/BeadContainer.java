package nl.sogyo.mancala.logic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.BeadContainer
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
abstract class BeadContainer {
    
    private int beads;
    private BeadContainer neighbour;
    private Player owner;
    
    
    
    
    public Player getOwner() {
        
        return owner;
    }
    
    public int getBeads() {
        
        return beads;
    }
    
    public BeadContainer getNeighbour() {
        
        return neighbour;
    }
    
    public BeadContainer getOpposite(){
        return neighbour.getOpposite().getNeighbour();
    }

}
