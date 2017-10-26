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
        
        Kalaha kalaha = new Kalaha();
        Assert.assertNotNull(kalaha);
        
    }
    
}
