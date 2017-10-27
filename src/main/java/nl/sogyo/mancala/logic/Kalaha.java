package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Kalaha
 * <p>
 * Created by kverlaan
 * on 26-Oct-17
 */
public class Kalaha extends BeadContainer {
    
    Kalaha(BeadContainer bc, int containersCreated) {
        
        beads = 4;
        owner = new Player();
        this.neighbour = bc;
        
        if (containersCreated == 1 || containersCreated == 8)
            new Kalaha(this, ++containersCreated);
        else if (containersCreated <= 13)
            new Bowl(this, ++containersCreated);
        else
            getNeighbour(13).setNeighbour(this);
    }
    
    @Override
    public BeadContainer getOpposite() {
        
        return this;
    }
}
