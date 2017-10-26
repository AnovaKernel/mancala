package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Bowl
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public class Bowl extends BeadContainer {
    
    private Player owner; //should be final (when constructor is ready)
    private Bowl   neighbour; //should be final (when constructor is ready)
    private int    beads;
    private int    available;
    
    public Bowl() {
        
        this(14);
    }
    
    public Bowl constructBowl(){
        
    }
    
    private Bowl(int available) {
        
        beads = 4;
        new Bowl(this, --available);
    }
    
    private Bowl(Bowl neighbour, int available) {
        
        if (available > 0) {
            beads = 4;
            owner = new Player();
            this.neighbour = neighbour;
            new Bowl(this, --available);
        } else
            throw new IllegalArgumentException();
    }
    
    public Player getOwner() {
        
        return owner;
    }
    
    public int getBeads() {
        
        return beads;
    }
    
    public Bowl getNeighbour() {
        
        return neighbour;
    }
    
}
