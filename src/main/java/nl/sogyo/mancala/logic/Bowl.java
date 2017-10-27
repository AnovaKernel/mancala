package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Bowl
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public class Bowl extends BeadContainer {
    
    public Bowl() {
        
        beads = 4;
        owner = new Player();
        
        new Kalaha(this, 2);
        
    }
    
    Bowl(BeadContainer bc, int containersCreated) {
        
        beads = 4;
        owner = new Player();
        this.neighbour = bc;
        
        if (containersCreated == 1 || containersCreated == 8)
            new Kalaha(this, ++containersCreated);
        else if (containersCreated <= 13)
            new Bowl(this, ++containersCreated);
        else {
            Bowl b = (Bowl) getNeighbour(13);
            b.setNeighbour(this);
        }
    }
    
}
