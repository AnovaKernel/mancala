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
    public void play() {
        
        if (getOwner().isTurn() && getBeads() > 0) {
            int beadsInHand = getBeads();
            setBeads(0);
            getNeighbour().transferBeadsOnPlayerMove(beadsInHand);
            //find out if we need to flip the turn
            if (!(getNeighbour(beadsInHand) instanceof Kalaha))
                getOwner().setTurn();
        } else {
            if (getBeads() > 0)
                System.out.println("Play has been called outside of players turn");
            else
                System.out.println("No beads in the bowl");
        }
        
    }
    
    @Override
    public void strike() {
        //contents of this bowl, should be added to opponents kalaha
        getOpposite().getKalaha().transferBeadsOnStrike(getBeads());
        setBeads(0);
    }
}
