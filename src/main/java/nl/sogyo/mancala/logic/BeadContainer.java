package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.BeadContainer
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
abstract class BeadContainer {
    
    int           beads;
    BeadContainer neighbour;
    Player        owner;
    
    BeadContainer getNeighbour(int x) {
        
        if (x == 1)
            return neighbour;
        else
            return neighbour.getNeighbour(--x);
    }
    
    public void transferBeadsOnGameEnd(int beads) {}
    
    public void transferBeadsOnStrike(int beads)  {}
    
    void transferBeadsOnPlayerMove(int beads) {
        
        if (beads > 0) {
            setBeads(getBeads() + 1);
            getNeighbour().transferBeadsOnPlayerMove(--beads);
        }
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
    
    int getBeads() {
        
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
        
        return true;
    }
    
    Kalaha getKalaha() {
        
        return searchKalaha(1);
        
    }
}
