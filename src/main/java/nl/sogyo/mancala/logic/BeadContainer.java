package nl.sogyo.mancala.logic;

import nl.sogyo.mancala.presentation.BoardObject;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.BeadContainer
 * <p>
 * @author kverlaan
 * @since 25-Oct-17
 *
 * Abstract class to define a contract for the Kalaha and Bowl Objects
 * Extends BoardObject to allow presentation in the GUI
 *
 */
public abstract class BeadContainer extends BoardObject {
    
    int           beads;
    BeadContainer neighbour;
    Player        owner;
    
    /**
     * returns the neighbour on position x, if x equals 0 it returns the object on which it was called
     *
     * @param x the neighbour you want
     * @return the requested neighbour as a BeadContainer object
     */
    public BeadContainer getNeighbour(int x) {
        
        if (x == 0)
            return this;
        else if (x == 1)
            return neighbour;
        else
            return neighbour.getNeighbour(--x);
    }
    
    /**
     * transfers all beads that are inside bowls to the corresponding Kalaha
     * is called when no more moves are left
     * @param beads the beads that are moved
     */
    public void transferBeadsOnGameEnd(int beads) {
        
        beads = getBeads() + beads;
        setBeads(0);
        getNeighbour().transferBeadsOnGameEnd(beads);
    }
    
    /**
     * transfer the beads from a bowl and dispenses them one by one counterclockwise
     * @param beads the beads in the played bowl
     */
    void transferBeadsOnPlayerMove(int beads) {
        
        if (beads > 1) {
            setBeads(getBeads() + 1);
            getNeighbour().transferBeadsOnPlayerMove(--beads);
        } else if (beads == 1 && getOwner().isTurn() && getBeads() == 0) {
            getOpposite().strike();
            getKalaha().transferBeadsOnStrike(beads);
            setBeads(0);
        } else
            setBeads(getBeads() + 1);
    
    }
    
    /**
     * method to strike the opposite bowl
     * Can only be called on a Bowl object
     */
    public abstract void strike();
    
    /**
     * execute a play move on a bowl
     * @param i the bowl to be played represented as an int
     */
    void play(int i) {
        
        if (i == 1)
            play();
        else
            getNeighbour().play(--i);
    }
    
    /**
     * returns the nearest kalaha (counterclockwise) starting the search from the given index
     * @param i the index where searching starts
     * @return the nearest Kalaha object found
     */
    private Kalaha searchKalaha(int i) {
        
        Kalaha k;
        k = getNeighbour(i) instanceof Kalaha ? ((Kalaha) getNeighbour(i)) : searchKalaha(++i);
        return k;
    }
    
    /**
     * returns the owner of the current object
     * @return Player object representing the owner
     */
    Player getOwner() {
        
        return owner;
    }
    
    /**
     * returns the beads in the current container
     * @return integer representing the amount of beads
     */
    public int getBeads() {
        
        return beads;
    }
    
    /**
     * sets the beads in the current container
     * @param beads amount of beads
     */
    void setBeads(final int beads) {
        
        this.beads = beads;
    }
    
    /**
     * returns the direct neighbour of the current container
     * @return BeadContainer representing the direct neighbour
     */
    BeadContainer getNeighbour() {
        
        return neighbour;
    }
    
    /**
     * sets the neighbour of the current container
     * @param neighbour the BeadContainer that should be the current objects neighbour
     */
    void setNeighbour(BeadContainer neighbour) {
        
        this.neighbour = neighbour;
    }
    
    /**
     * returns the container directly opposite to the current object
     * @return BeadContainer opposite to current
     */
    public BeadContainer getOpposite() {
        
        return getNeighbour().getOpposite().getNeighbour();
    }
    
    /**
     * returns whether moves are possible
     * @return boolean representing true if there are moves to play, false if there are no more moves
     */
    public boolean isMovePossible() {
        
        return getOwner().isTurn() && getBeads() > 0 || getNeighbour().isMovePossible();
    }
    
    /**
     * returns the nearest Kalaha (counter clockwise) as seen from the current object
     * @return Kalaha object belonging to
     */
    Kalaha getKalaha() {
        
        return searchKalaha(1);
        
    }
    
    /**
     * method to play the current object
     */
    public void play() {
        
        System.out.println("You can only play on a Bowl");
    }
    
    @Override
    public int hashCode() {
        
        int result = super.hashCode();
        result = 31 * result + neighbour.hashCode();
        result = 31 * result + owner.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(final Object o) {
        
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        
        final BeadContainer that = (BeadContainer) o;
        
        if (beads != that.beads)
            return false;
        if (!neighbour.equals(that.neighbour))
            return false;
        return owner.equals(that.owner);
    }
}
