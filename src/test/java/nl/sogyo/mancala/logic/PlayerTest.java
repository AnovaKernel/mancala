package nl.sogyo.mancala.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.PlayerTest
 * <p>
 * Created by kverlaan
 * on 26-Oct-17
 */
public class PlayerTest {
    
    @Test
    public void testPlayerExists() {
        
        Player p = new Player();
        Assert.assertNotNull(p);
        
    }
    
    @Test
    public void testPlayerHasOpponent() {
        Player p = new Player();
        Assert.assertNotNull(p.getOpponent());
    }
    
    
    @Test
    public void testPlayerIsOpponentsOpponent() {
        Player p = new Player();
        Assert.assertEquals(p,p.getOpponent().getOpponent());
    }
    
    @Test
    public void testOnePlayerHasTurn() {
        Player p = new Player();
        Assert.assertTrue(p.isTurn() != p.getOpponent().isTurn());
        

    }
}
