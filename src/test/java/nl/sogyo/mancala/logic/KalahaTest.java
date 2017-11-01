package nl.sogyo.mancala.logic;

import org.junit.Assert;
import org.junit.Test;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.KalahaTest
 * <p>
 * Created by kverlaan
 * on 26-Oct-17
 */
public class KalahaTest {
    
    @Test
    public void testKalahaExists() {
        
        Bowl   b = new Bowl();
        Kalaha k = (Kalaha) b.getNeighbour(6);
        Assert.assertNotNull(k);
        
    }
    
    @Test
    public void testKalahaHasNeighbour() {
        
        Bowl   b = new Bowl();
        Kalaha k = (Kalaha) b.getNeighbour(6);
        
        Assert.assertNotNull(k.getNeighbour());
        
    }
    
    @Test
    public void testTwoKalahaExist() {
        
        Bowl   b  = new Bowl();
        Kalaha k1 = (Kalaha) b.getNeighbour(6);
        Kalaha k2 = (Kalaha) k1.getNeighbour(7);
        
        Assert.assertNotNull(k1);
        Assert.assertNotNull(k2);
    }
    
    @Test
    public void testReturnedKalahaBelongsToRightOwner() {
        
        Bowl   b = new Bowl();
        Kalaha k = b.getKalaha();
        Assert.assertEquals(b.getOwner(), k.getOwner());
    }
    
    @Test
    public void testKalahaCanNotBePlayed() {
        
        Bowl b = new Bowl();
        b.getKalaha().play();
        Assert.assertTrue(b.getOwner().isTurn());
        
    }
    
    @Test
    public void testKalahaContainsAllBeadsOnGameEnd() {
        
        Bowl b = new Bowl();
        //arbitrary amount of plays
        b.play(2);
        b.play(9);
        
        b.getKalaha().getNeighbour().transferBeadsOnGameEnd(0);
        b.transferBeadsOnGameEnd(0);
        
        Assert.assertEquals(48, b.getKalaha().getBeads() + b.getOpposite().getKalaha().getBeads());
        
    }
    
    @Test
    public void testKalahaReceivesAllBeadsOnStrike() {
        
        Bowl b = new Bowl();
        
        b.play(5);
        b.play(8);
        b.play(1);
        
        Assert.assertEquals(8, b.getKalaha().getBeads());
        
    }
    
    @Test
    public void testStrikeCantHappenOnKalaha() {
        
        Bowl   b  = new Bowl();
        Kalaha k1 = b.getKalaha();
        Kalaha k2 = b.getKalaha();
        
        Assert.assertEquals(k1, k2);
        k1.strike();
        Assert.assertEquals(k1, k2);
        
    }
}
