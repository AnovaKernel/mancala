package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Kalaha
 * <p>
 * Created by kverlaan
 * on 26-Oct-17
 */
public class Kalaha extends BeadContainer {
    
    private Player        owner; //should be final (when constructor is ready)
    private BeadContainer neighbour; //should be final (when constructor is ready)
    private int           beads;
    
    public Kalaha() {
        
        this(2);
    }
    
    Kalaha(int available) {
        
        beads = 4;
        owner = new Player();
        if (available > 8)
            neighbour = new Bowl(--available);
        else if (available == 8 || available == 1)
            neighbour = new Kalaha(--available);
        else if (available > 1 && available < 8)
            neighbour = new Bowl(--available);
        
    }
    
    @Override
    public BeadContainer getOpposite() {
        
        return this;
    }
}
