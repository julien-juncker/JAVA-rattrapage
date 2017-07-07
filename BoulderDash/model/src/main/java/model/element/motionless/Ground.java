package model.element.motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>The Macadam Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Ground extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Ground.jpg");

    /**
     * Instantiates a new ground.
     */
    Ground() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
