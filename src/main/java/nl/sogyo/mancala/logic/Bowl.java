package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Bowl
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 *
 * @see nl.sogyo.mancala.logic.BeadContainer
 */
public class Bowl extends BeadContainer {
    
    public Bowl() {
        
        beads = 4;
        owner = new Player();
        
        new Kalaha(this, 2, owner.getOpponent());
        
    }
    
    Bowl(BeadContainer bc, int containersCreated, Player owner) {
    
        this.beads = 4;
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
    public void strike() {
        //contents of this bowl, should be added to opponents kalaha
        getOpposite().getKalaha().transferBeadsOnStrike(getBeads());
        setBeads(0);
    }
    
    @Override
    public void play() {
    
        if (getOwner().isTurn()) {
            processTurn();
        } else {
            System.out.println("Play has been called outside of players turn");
        }
    
    }
    
    private void processTurn() {
        
        int beadsInHand = getBeads() > 0 ? getBeads() : 0;
        
        if (!(beadsInHand > 0)) {
            System.out.println("No beads to play here");
            return;
        }
        
        setBeads(getBeads() - beadsInHand);
        getNeighbour().transferBeadsOnPlayerMove(beadsInHand);
        processEndOfTurn(getNeighbour(beadsInHand));
        
    }
    
    private void processEndOfTurn(BeadContainer endedIn) {
        
        if (!(endedIn instanceof Kalaha && endedIn.getOwner().isTurn()))
            getOwner().setTurn(); //we did not end in our own kalaha
        else
            System.out.println("Extra turn");
        checkPossibleMovesNextTurn(getOwner());
        
    }
    
    private void checkPossibleMovesNextTurn(Player p) {
        
        boolean movePossible = p.isTurn() ? getOpposite().getKalaha().getNeighbour().isMovePossible() : getKalaha().getNeighbour().isMovePossible();
        
        if (!movePossible) {
            getOpposite().getKalaha().getNeighbour().transferBeadsOnGameEnd(0);
            System.out.println("Game ended");
        }
    }
}
