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
        
        new Kalaha(this, 2, owner.getOpponent());
        
    }
    
    Bowl(BeadContainer bc, int containersCreated, Player owner) {
        
        beads = 4;
        this.owner = owner;
        this.neighbour = bc;
        
        if (containersCreated == 1 || containersCreated == 8)
            new Kalaha(this, ++containersCreated, owner.getOpponent());
        else if (containersCreated <= 13)
            new Bowl(this, ++containersCreated, owner);
        else {
            Bowl b = (Bowl) getNeighbour(13);
            b.setNeighbour(this);
        }
    }
    
    @Override
    void play() {
        
        if (getOwner().isTurn() ) {
            int beadsInHand = getBeads();
            setBeads(0);
            getNeighbour().transferBeadsOnPlayerMove(beadsInHand);
            //if movePossible, switch turn

            getOwner().setTurn();
        } else
            System.out.println("Play has been called outside of players turn");
        
    }
}
