package model.element.motionless;

import model.Permeability;

import model.Sprite;

public class Exit extends MotionlessElement  {
	
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('E', "Exit.jpg");

    /**
     * Instantiates a new Exit.
     */
    Exit() {
        super(SPRITE, Permeability.EXIT);
    }
}
