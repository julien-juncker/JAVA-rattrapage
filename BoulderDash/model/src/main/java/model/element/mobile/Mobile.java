package model.element.mobile;

import java.awt.Point;


import model.IGround;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.element.Element;
import view.IBoard;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

    /**
     * The x.
     */
    private Point   position;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private IGround   ground;

    /** The board. */
    private IBoard  board;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite, final IGround ground, final Permeability permeability) {
        super(sprite, permeability);
        this.setGround(ground);
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite, final IGround ground, final Permeability permeability) {
        this(sprite, ground, permeability);
        this.setX(x);
        this.setY(y);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
     */
    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
        this.getGround().setMobileHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public final void setY(final int y) {
        this.getPosition().y = (y + this.getGround().getHeight()) % this.getGround().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
        else if (this.isExit()) {
        	this.exit();
        }
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public IGround getGround() {
        return this.ground;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setGround(final IGround ground) {
        this.ground = ground;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isAlive()
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /**
     * exit.
     */
    protected void exit() {
        this.alive = false;
        this.setHasMoved();
    }
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrashed()
     */
    @Override
    public Boolean isCrashed() {
        return this.getGround().getOnTheGroundXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    @Override
    public Boolean isExit() {
        return this.getGround().getOnTheGroundXY(this.getX(), this.getY()).getPermeability() == Permeability.EXIT;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}