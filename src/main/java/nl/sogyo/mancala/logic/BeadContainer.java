package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.BeadContainer
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public abstract class BeadContainer {
    
    int           beads;
    BeadContainer neighbour;
    Player        owner;
    
    public BeadContainer getNeighbour(int x) {
        
        if (x == 1)
            return neighbour;
        else
            return neighbour.getNeighbour(--x);
    }
    
    public void transferBeadsOnGameEnd(int beads) {}
    
    public void transferBeadsOnStrike(int beads)  {}
    
    void transferBeadsOnPlayerMove(int beads) {
        
        if (beads > 1) {
            setBeads(getBeads() + 1);
            getNeighbour().transferBeadsOnPlayerMove(--beads);
        } else if (beads == 1) {
            if (getBeads() == 0) {
                getOpposite().strike();
                transferBeadsOnStrike(beads);
                //setBeads(0);
            } else
                setBeads(getBeads() + 1);
        }
    }
    
    public void strike() {
    
        System.out.println("Strike can not be called on a Kalaha");
        
    }
    
    void play(int i) {
        
        if (i == 1)
            play();
        else
            getNeighbour().play(--i);
    }
    
    void play() {
        
        System.out.println("You can only play on a Bowl");
    }
    
    Kalaha searchKalaha(int i) {
        
        Kalaha k;
        k = getNeighbour(i) instanceof Kalaha ? ((Kalaha) getNeighbour(i)) : searchKalaha(++i);
        return k;
    }
    
    Player getOwner() {
        
        return owner;
    }
    
    public int getBeads() {
        
        return beads;
    }
    
    void setBeads(final int beads) {
        
        this.beads = beads;
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
    
    public boolean isMovePossible() {
        
        if (getOwner().isTurn() && getBeads() > 0)
            return true;
        else
            return getNeighbour().isMovePossible();
    }
    
    public Kalaha getKalaha() {
        
        return searchKalaha(1);
        
    }
}
