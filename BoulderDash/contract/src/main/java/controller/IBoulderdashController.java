package controller;

import java.io.IOException;

/**
 * <h1>The Interface IIinsaneVehiclesController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public interface IBoulderdashController {

    /**
     * Play.
     * @param restart 
     * @param compteurMort 
     * @return 
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    boolean play(boolean restart) throws InterruptedException;
    
    public void showDeath(int counterDeath);

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}
