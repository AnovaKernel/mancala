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
    public void testBowlCannotBeInstantiatedTwice() {
        
        Bowl b1 = new Bowl();
        Bowl b2 = new Bowl();
        Assert.assertEquals(b1, b2);
        
    }
}
