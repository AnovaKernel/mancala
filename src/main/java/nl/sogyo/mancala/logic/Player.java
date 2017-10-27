package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Player
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public class Player {
    
    private boolean turn;
    private Player  opponent;
    
    public Player() {
        
        opponent = new Player(this);
        setTurn();
    }
    
    private Player(Player player) {
        
        opponent = player;
    }
    
    void setTurn() {
        
        turn = !turn;
        if (opponent.isTurn() == turn)
            opponent.setTurn();
        
    }
    
    boolean isTurn() {
        
        return turn;
    }
    
    Player getOpponent() {
        
        return opponent;
    }
    
}
