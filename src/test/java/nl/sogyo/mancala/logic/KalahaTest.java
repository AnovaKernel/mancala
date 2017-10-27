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
        Bowl b = new Bowl();
        Kalaha k1 =  (Kalaha)b.getNeighbour(6);
        Kalaha k2 =  (Kalaha)k1.getNeighbour(7);
        
        Assert.assertNotNull(k1);
        Assert.assertNotNull(k2);
    }
    
@Test
    public void testReturnedKalahaBelongsToRightOwner(){
        Bowl b = new Bowl();
        Kalaha k =b.getKalaha();
        Assert.assertEquals(b.getOwner(),k.getOwner());
}
    
}
