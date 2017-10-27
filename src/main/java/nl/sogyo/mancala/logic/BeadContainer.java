package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.BeadContainer
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
abstract class BeadContainer {
    
    int           beads;
    BeadContainer neighbour;
    Player        owner;
    
    BeadContainer getNeighbour(int x) {
        
        if (x == 1)
            return neighbour;
        else
            return neighbour.getNeighbour(--x);
    }
    
    Player getOwner() {
        
        return owner;
    }
    
    int getBeads() {
        
        return beads;
    }
    
    BeadContainer getNeighbour() {
        
        return neighbour;
    }
    
    void setNeighbour(BeadContainer neighbour) {
        
        this.neighbour = neighbour;
    }
    
    public BeadContainer getOpposite() {
        
        return getNeighbour().getOpposite().getNeighbour();
    }
    
}
