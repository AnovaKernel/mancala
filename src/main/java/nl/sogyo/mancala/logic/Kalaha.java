package nl.sogyo.mancala.logic;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.logic.Kalaha
 * <p>
 * Created by kverlaan
 * on 26-Oct-17
 */
public class Kalaha {
    
    public Kalaha() {
        this(2);
    }
    private Kalaha(int available) {
        if (available > 0)
            new Kalaha(--available);
        
        else
            throw new IllegalStateException();
    }
    

}
