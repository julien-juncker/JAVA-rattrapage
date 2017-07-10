package model;

import model.IMobile;

/**
 * <h1>The Interface IInsaneVehiclesModel.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IBoulderdashModel {

    /**
     * Gets the Ground.
     *
     * @return the Ground
     */
    IGround getGround();

    /**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    IMobile getMyPlayer() ;
}
