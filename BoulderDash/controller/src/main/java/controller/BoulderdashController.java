package controller;

import java.io.IOException;


import model.IBoulderdashModel;
import view.IBoulderdashView;

/**
 * <h1>The Class InsaneVehiclesController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public class BoulderdashController implements IBoulderdashController, IOrderPerformer {

    /** The Constant speed. */
    private static final int     speed = 300;

    /** The view. */
    private IBoulderdashView  view;

    /** The model. */
    private IBoulderdashModel model;

    /** The stack order. */
    private UserOrder            stackOrder;

    /**
     * Instantiates a new insane vehicles controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public BoulderdashController(final IBoulderdashView view, final IBoulderdashModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyPlayer().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyPlayer().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyPlayer().moveLeft();
                    break;
                case DOWN:
                    this.getModel().getMyPlayer().moveDown();
                    break;
                case UP:
                    this.getModel().getMyPlayer().moveUp();
                    break;
                case NOP:
                default:
                    this.getModel().getMyPlayer().doNothing();
                    break;
            }
            this.clearStackOrder();
            this.getView().followMyPlayer();
        }
        if (this.getModel().getMyPlayer().isExit()) {
        	this.getView().displayMessage("Finis !!!!!!!!!.");
        }
        else if (this.getModel().getMyPlayer().isCrashed()) {
        	this.getView().displayMessage("CRASH !!!!!!!!!.");
        }
    
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IOrderPerformed#orderPerform(fr.exia.insanevehicles.
     * controller.UserOrder)
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#orderPerform(fr.exia.
     * insanevehicles.controller.UserOrder)
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private IBoulderdashView getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IBoulderdashView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    private IBoulderdashModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IBoulderdashModel model) {
        this.model = model;
    }

    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#getOrderPeformer()
     */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}