package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Bowl
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public class Bowl extends BeadContainer {
    
    private Player        owner; //should be final (when constructor is ready)
    private BeadContainer neighbour; //should be final (when constructor is ready)
    private int           beads;
    
    public Bowl() {
        
        this(14);
    }
    
    Bowl(int available) {
        
        beads = 4;
        owner = new Player();
        if (available == 8 || available == 1)
            neighbour = new Kalaha(--available);
        else
            neighbour = new Bowl(--available);
        
        //if available == 0,
        getOwner();
        
    }
    

    
    public Player getOwner() {
        
        return owner;
    }
    
    public int getBeads() {
        
        return beads;
    }
    
    public BeadContainer getNeighbour() {
        
        return neighbour;
    }
    
    @Override
    public BeadContainer getOpposite() {
        
        return neighbour.getOpposite().getNeighbour();
    }
}
