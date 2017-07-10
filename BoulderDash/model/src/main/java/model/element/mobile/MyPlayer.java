package model.element.mobile;

import java.io.IOException;

import model.IGround;
import model.Permeability;
import model.Sprite;

/**
 * <h1>The MyVehicle Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class MyPlayer extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "Player.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', "PlayerLeft.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "PlayerRight.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteExplode   = new Sprite('H', "PlayerExplode.png");

    private static final Sprite spriteUp   = new Sprite('H', "PlayerUp.png");
    
    private static final Sprite spriteDown   = new Sprite('H', "PlayerDown.png");
    /**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param road
     *            the road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public MyPlayer(final int x, final int y, final IGround ground) throws IOException {
        super(x, y, sprite, ground, Permeability.BLOCKING);
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteExplode.loadImage();
        spriteDown.loadImage();
        spriteUp.loadImage();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteExplode);
    }

    @Override
    protected final void exit() {
        super.exit();
        this.setSprite(sprite);
    }
    
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteUp);
    }
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteDown);
    }
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}
