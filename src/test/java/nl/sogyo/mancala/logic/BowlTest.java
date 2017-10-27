package nl.sogyo.mancala.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.BowlTest
 * <p>
 * Created by kverlaan
 * on 26-Oct-17
 */
public class BowlTest {
    
    @Test
    public void testBowlCanBeInstantiated() {
        
        Bowl b1 = new Bowl();
        Assert.assertNotNull(b1);
        
    }
    
    @Test
    public void testBowlHasContent() {
        
        //BeadContainer bowl = new Bowl();
        Bowl bowl = new Bowl();
        Assert.assertEquals(4, bowl.getBeads());
        
    }
    
    @Test
    public void testBowlHasNeighbour() {
        
        Bowl bowl = new Bowl();
        Assert.assertNotNull(bowl.getNeighbour());
        
    }
    
    @Test
    public void testBowlHasOwner() {
        
        Bowl bowl = new Bowl();
        Assert.assertNotNull(bowl.getOwner());
        
    }
    
    @Test
    public void testBowlHasOppositeBowl() {
        
        Bowl b = new Bowl();
        Assert.assertNotNull(b.getOpposite());
    }
    
    @Test
    public void testOppositeOppositeIsSameBowl() {
        
        Bowl b = new Bowl();
        Assert.assertEquals(b, b.getOpposite().getOpposite());
    }
    
    @Test
    public void testGameCanLoopAround() {
        
        Bowl b1 = new Bowl();
        Bowl b2 = (Bowl) b1.getNeighbour(14);
        Assert.assertEquals(b1, b2);
    }
    
    @Test
    public void testBowlCanPlay(){
        Bowl b = new Bowl();
        b.play(1);
        Assert.assertEquals(0,b.getBeads());
        Assert.assertEquals(5,b.getNeighbour().getBeads());
        Assert.assertEquals(5,b.getNeighbour(4).getBeads());
    }
    
    @Test
    public void testTurnSwitchesAfterPlay() {
        Bowl b = new Bowl();
        Player p = b.getOwner();
        b.play(1);
        Assert.assertFalse(p.isTurn());
        
    }
    
    @Test
    public void testOpponentBowlCanNotPlay(){
        Bowl b = (Bowl) new Bowl().getOpposite();
        b.play(1);
        Assert.assertEquals(4,b.getBeads());

    }
    
}
