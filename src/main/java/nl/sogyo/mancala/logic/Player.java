package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Player
 * <p>
 * Created by kverlaan
 * on 25-Oct-17
 */
public class Player {
    
    private String  name; //not yet used
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
    
        if (playerResult == null) {
            if (comparedScore < 0) {
                playerResult = (RESULT.LOSE);
            } else if (comparedScore > 0) {
                playerResult = (RESULT.WIN);
            } else {
                playerResult = (RESULT.DRAW);
            }
            getOpponent().setPlayerResult(comparedScore * -1);
        }
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
