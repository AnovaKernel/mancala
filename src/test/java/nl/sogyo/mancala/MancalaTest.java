package nl.sogyo.mancala;

import nl.sogyo.mancala.logic.Bowl;
import nl.sogyo.mancala.logic.Kalaha;
import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {
    

    

    
    @Test
    public void testMancalaCreation() {
        
        Mancala m = new Mancala();
        Assert.assertNotNull(m);
        
        
    }
    
}
