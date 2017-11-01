package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Player
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public class Player {
    
    private String  name;
    private boolean turn;
    private Player  opponent;
    private RESULT  playerResult;
    
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
    
    RESULT getPlayerResult() {
        
        return playerResult;
    }
    
    void setPlayerResult(final int comparedScore) {
        
        if (comparedScore < 0) {
            playerResult = (RESULT.LOSE);
            getOpponent().setPlayerResult(RESULT.WIN);
        } else if (comparedScore > 0) {
            playerResult = (RESULT.WIN);
            getOpponent().setPlayerResult(RESULT.LOSE);
        } else {
            playerResult = (RESULT.DRAW);
            getOpponent().setPlayerResult(RESULT.DRAW);
        }
    }
    
    private void setPlayerResult(final RESULT result) {
        
        this.playerResult = result;
        
    }
    
    Player getOpponent() {
        
        return opponent;
    }
    
    boolean isTurn() {
        
        return turn;
    }
    
    public enum RESULT {
        WIN, DRAW, LOSE
    }
}
