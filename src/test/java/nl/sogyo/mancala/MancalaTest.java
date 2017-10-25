package nl.sogyo.mancala;

import nl.sogyo.mancala.logic.Bowl;
import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {
    
    @Test
    public void testBowl() {
        
        Bowl bowl = new Bowl();
        Assert.assertEquals(4, bowl.getBeads());
        
    }
    
    @Test
    public void testBowlHasNeighbour() {
        
        Bowl bowl = new Bowl();
        Assert.assertNotNull(bowl.getNeighbour());
        
    }
    
    @Test
    public void testFirstMove() {
        
        Bowl bowl = new Bowl();
        bowl.transferBeadsOnPlayerMove(bowl.getBeads());
        
    }
    
}
