package model;

import java.io.IOException;


import model.element.mobile.IMobile;
import model.element.mobile.MyPlayer;


/**
 * <h1>The Class InsaneVehiclesModel.</h1>
 */
public class BoulderdashModel implements IBoulderdashModel {

    /** The Ground. */
    private IGround   Ground;

    /** The my vehicle. */
    private IMobile myVehicle;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myVehicleStartX
     *            the my vehicle start X
     * @param myVehicleStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderdashModel(final String fileName, final int myPlayerStartX, final int myPlayerStartY)
            throws IOException {
        this.setGround(new Ground(fileName));
        this.setMyPlayer(new MyPlayer(myPlayerStartX, myPlayerStartY, this.getGround()));
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getGround()
     */
    @Override
    public final IGround getGround() {
        return this.Ground;
    }

    /**
     * Sets the Ground.
     *
     * @param Ground
     *            the Ground to set
     */
    private void setGround(final IGround Ground) {
        this.Ground = Ground;
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMyVehicle()
     */
    @Override
    public final IMobile getMyPlayer() {
        return this.myPlayer;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setMyPlayer(final MyPlayer myPlayer) {
        this.myPlayer = myPlayer;
    }

}
