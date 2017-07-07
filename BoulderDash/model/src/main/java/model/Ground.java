package model;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import model.IElement;
import model.element.motionless.MotionLessElementsFactory;

/**
 * <h1>The Ground Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
class Ground extends Observable implements IGround {

    /** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the Ground. */
    private IElement[][] onTheGround;

    /**
     * Instantiates a new Ground with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the Ground is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Ground(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheGround = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheGroundXY(MotionLessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IGround#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IGround#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IGround#getOnTheGroundXY(int, int)
     */
    @Override
    public final IElement getOnTheGroundXY(final int x, final int y) {
        return this.onTheGround[x][y];
    }

    /**
     * Sets the on the Ground XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void setOnTheGroundXY(final IElement element, final int x, final int y) {
        this.onTheGround[x][y] = element;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IGround#setMobileHasChanged()
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IGround#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
    }
}
