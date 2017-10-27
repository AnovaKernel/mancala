package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Kalaha
 * <p>
 * Created by kverlaan
 * on 26-Oct-17
 */
public class Kalaha extends BeadContainer {
    
    Kalaha(BeadContainer bc, int containersCreated, Player owner) {
        
        beads = 4;
        this.owner = owner;
        this.neighbour = bc;
        
        if (containersCreated == 1 || containersCreated == 8)
            new Kalaha(this, ++containersCreated, owner.getOpponent());
        else if (containersCreated <= 13)
            new Bowl(this, ++containersCreated, owner);
        else
            getNeighbour(13).setNeighbour(this);
    }
    
    @Override
    public BeadContainer getOpposite() {
        
        return this;
    }
    

}
