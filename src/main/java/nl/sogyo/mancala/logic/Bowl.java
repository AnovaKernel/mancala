package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Bowl
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public class Bowl extends BeadContainer{
    
    private int beads;
    private BeadContainer neighbour;
    

    
    public Bowl() {
        beads = 4;
    }
    
   
    public int getBeads() {
        
        return beads;
    }
    
    public BeadContainer getNeighbour() {
        
        return new Bowl();
    }
}
