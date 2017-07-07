package model;

import java.awt.Image;

import model.element.Permeability;
import model.element.Sprite;

//import fr.exia.showboard.ISquare;

/**
 * <h1>The Interface IElement.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see ISquare
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     * @param <Sprite>
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    Image getImage();

}
