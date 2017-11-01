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
    
        this.beads = 0;
        this.owner = owner;
        this.neighbour = bc;
        
        if (containersCreated == 1 || containersCreated == 8)
            new Kalaha(this, ++containersCreated, owner.getOpponent());
        else if (containersCreated <= 13)
            new Bowl(this, ++containersCreated, owner);
        else
            getNeighbour(13).setNeighbour(this);
    }
    
    void transferBeadsOnStrike(final int beads) {
        
        setBeads(getBeads() + beads);
    }
    
    @Override
    public void transferBeadsOnGameEnd(final int beads) {
        
        setBeads(getBeads() + beads);
        
        if (getBeads() + getNeighbour().getKalaha().getBeads() == 48) {
            getOwner().setPlayerResult(getBeads() - getNeighbour().getKalaha().getBeads());
        } else
            getNeighbour().transferBeadsOnGameEnd(0);
    }
    
    @Override
    void transferBeadsOnPlayerMove(int beads) {
    
        if (getOwner().isTurn()) {
            setBeads(getBeads() + 1);
        
            if (beads > 1)
                getNeighbour().transferBeadsOnPlayerMove(--beads);
            
        } else
            getNeighbour().transferBeadsOnPlayerMove(beads);
        
    }
    
    @Override
    public void strike() {
        
        System.out.println("Strike can only be called on a Bowl");
        
    }
    
    @Override
    public BeadContainer getOpposite() {
    
        return this;
    }
    
    @Override
    public boolean isMovePossible() {
    
        return false; //this means the game has ended!
    }
}
