package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {
    
    @Test
    public void testMancalaCreation() {
        
        Mancala m = new Mancala();
        Assert.assertNotNull(m);
        
    }
    
}
