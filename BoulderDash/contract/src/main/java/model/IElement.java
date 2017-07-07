package model;

import java.awt.Image;

import view.ISquare;


//import fr.exia.showboard.ISquare;

/**
 * <h1>The Interface IElement.</h1>
 *
 * @author Jade
 * @version 0.1
 * @param <Permeability>
 * @param <Sprite>
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     * @param <Sprite>
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

    @Override
    Image getImage();

}
