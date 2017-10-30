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
    public void testBowlCanPlay() {
        
        Bowl b = new Bowl();
        b.play(1);
        Assert.assertEquals(0, b.getBeads());
        Assert.assertEquals(5, b.getNeighbour().getBeads());
        Assert.assertEquals(5, b.getNeighbour(4).getBeads());
    }
    
    @Test
    public void testTurnSwitchesAfterPlay() {
        
        Bowl   b = new Bowl();
        Player p = b.getOwner();
        b.play(1);
        Assert.assertFalse(p.isTurn());
        
    }
    
    @Test
    public void testOpponentBowlCanNotPlay() {
        
        Bowl b = (Bowl) new Bowl().getOpposite();
        b.play(1);
        Assert.assertEquals(4, b.getBeads());
        
    }
    
    @Test
    public void testBeadsDontGoInOpponentsKalaha() {
        
        Bowl b = new Bowl();
        b.play(1); //p1
        Assert.assertFalse(b.getOwner().isTurn());
        b.play(8); //p2
        Assert.assertTrue(b.getOwner().isTurn());
        b.play(2); //p1
        b.play(3); //p1
        Assert.assertFalse(b.getOwner().isTurn());
        b.play(9); //p2 (ends in kalaha)
        Assert.assertTrue(b.getOwner().isTurn());
        b.play(4); //p1
        Assert.assertFalse(b.getOwner().isTurn());
        b.play(8); //p2
        Assert.assertTrue(b.getOwner().isTurn());
        b.play(6); //p1
        Assert.assertFalse(b.getOwner().isTurn());
        b.play(8); //p2
        Assert.assertTrue(b.getOwner().isTurn());
        b.play(5); //p1
        Assert.assertFalse(b.getOwner().isTurn());
        b.play(8); //p2
        Assert.assertTrue(b.getOwner().isTurn());
        b.play(6); //p1 should end up in 1
        Assert.assertEquals(1, b.getBeads());
        
    }
    
    @Test
    public void testEmptyBowlCanNotBePlayed() {
        
        Bowl   b = new Bowl();
        Player p = b.getOwner();
        b.play(1);
        Assert.assertEquals(0, b.getBeads());
        Assert.assertFalse(p.isTurn());
        b.play(8);
        Assert.assertTrue(p.isTurn());
        b.play(1);
        Assert.assertTrue(p.isTurn());
        
    }
    
    @Test
    public void testPlayerCantMoveWhenNoMovesArePossible() {
        
        Bowl b = new Bowl();
        b.play(1); //p1
        b.play(8);
        b.play(2); //p1
        b.play(9);
        b.play(3); //p1
        b.play(8);
        b.play(4); //p1
        b.play(8);
        b.play(6); //p1
        b.play(8);
        b.play(5); //p1
        b.play(8);
        Assert.assertTrue(b.getOwner().isTurn());
        b.play(6); //p1 may play again but has no stones
        Assert.assertTrue(b.getOwner().isTurn());
        Assert.assertEquals(6, b.getKalaha().getBeads());
        Assert.assertEquals(0, b.getNeighbour(5).getBeads());
        Assert.assertFalse(b.isMovePossible());
        System.out.println(b.getBeads());
        
    }
    
    @Test
    public void testStrikeHappensOnEmptyBowl() {
        
        Bowl b = new Bowl();
        b.play(6);
        b.play(10);
        
        Assert.assertEquals(0, b.getNeighbour(5).getBeads());
        int strikeTotal = b.getNeighbour(5).getOpposite().getBeads() + b.getKalaha().getBeads();
        b.play(2); //this is a strike move!
        Assert.assertEquals(strikeTotal, b.getKalaha().getBeads());
        
    }
    
}
