package model.element.motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.3
 */
public abstract class MotionLessElementsFactory {

    /** The Constant MACADAM. */
    private static final Ground             GROUND             = new Ground();

    /** The Constant OBSTACLE. */
    private static final Obstacle            OBSTACLE            = new Obstacle();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[]       motionlessElements  = {

        GROUND,
        OBSTACLE,
    	};

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */


    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createGround() {
        return GROUND;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }


    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return GROUND;
    }
}
