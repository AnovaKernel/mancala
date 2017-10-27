package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Player
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
class Player {
    
    private boolean turn;
    private Player  opponent;
    
    Player() {
        
        opponent = new Player(this);
        setTurn(true);
    }
    
    private Player(Player player) {
        
        opponent = player;
    }
    
    boolean isTurn() {
        
        return turn;
    }
    
    private void setTurn(boolean turn) {
        
        this.turn = turn;
        if (opponent.isTurn() == turn)
            opponent.setTurn(!turn);
    }
    
    Player getOpponent() {
        
        return opponent;
    }
    
}
