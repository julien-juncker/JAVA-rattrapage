package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.IGround;
import model.IMobile;
//import fr.exia.showboard.BoardFrame;

/**
 * <h1>The InsaneVehiclesView Class.</h1>
 *
 * @author Jade
 * @version 0.4
 */
public class BoulderdashView implements Runnable, KeyListener, IBoulderdashView {

    /** The Constant GroundView. */
    private static final int GroundView   = 10;

    /** The Constant squareSize. */
    private static final int squareSize = 50;

    /** The Constant closeView. */
    private Rectangle        closeView;

    /** The Ground. */
    private IGround            Ground;

    /** My vehicle. */
    private IMobile          MyPlayer;

    /** The view. */
    private int              view;

    /** The order performer. */
    private IOrderPerformer  orderPerformer;

    /**
     * Instantiates a new insane vehicles View.
     *
     * @param Ground
     *            the Ground
     * @param MyPlayer
     *            the my vehicle
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderdashView(final IGround ground, final IMobile myPlayer) throws IOException {
        this.setView(groundView);
        this.setGround(ground);
        this.setMyPlayer(MyPlayer);
        this.getMyPlayer().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, this.getMyPlayer().getY(), this.getGround().getWidth(), groundView));
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Close view");
        boardFrame.setDimension(new Dimension(this.getGround().getWidth(), this.getGround().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getGround().getWidth(); x++) {
            for (int y = 0; y < this.getGround().getHeight(); y++) {
                boardFrame.addSquare(this.ground.getOnTheGroundXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyPlayer());

        this.getGround().getObservable().addObserver(boardFrame.getObserver());
        this.followMyPlayer();

        boardFrame.setVisible(true);
    }

    /**
     * Prints the Ground and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart % this.getGround().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getGround().getWidth(); x++) {
                if ((x == this.getMyPlayer().getX()) && (y == yStart)) {
                    System.out.print(this.getMyPlayer().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getGround().getOnTheGroundXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getGround().getHeight();
            System.out.print("\n");
        }
    }

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followMyPlayer()
     */
    @Override
    public final void followMyPlayer() {
        this.getCloseView().y = this.getMyPlayer().getY() - 1;
    }

    /**
     * Gets the Ground.
     *
     * @return the Ground
     */
    private IGround getGround() {
        return this.Ground;
    }

    /**
     * Sets the Ground.
     *
     * @param Ground
     *            the new Ground
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setGround(final IGround Ground) throws IOException {
        this.Ground = Ground;
        for (int x = 0; x < this.getGround().getWidth(); x++) {
            for (int y = 0; y < this.getGround().getHeight(); y++) {
                this.getGround().getOnTheGroundXY(x, y).getSprite().loadImage();
            }
        }
    }

    /**
     * Gets my vehicle.
     *
     * @return my vehicle
     */
    private IMobile getMyPlayer() {
        return this.MyPlayer;
    }

    /**
     * Sets my vehicle.
     *
     * @param MyPlayer
     *            my new vehicle
     */
    private void setMyPlayer(final IMobile MyPlayer) {
        this.MyPlayer = MyPlayer;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private int getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }

    /**
     * Gets the close view.
     *
     * @return the close view
     */
    private Rectangle getCloseView() {
        return this.closeView;
    }

    /**
     * Sets the close view.
     *
     * @param closeView
     *            the new close view
     */
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Gets the order performer.
     *
     * @return the order performer
     */
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    /**
     * Sets the order performer.
     *
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
}