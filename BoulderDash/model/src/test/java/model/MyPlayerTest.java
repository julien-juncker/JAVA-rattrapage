package model;
import org.junit.After;
import org.junit.Before;

import junit.framework.*;
import model.element.mobile.MyPlayer;

public class MyPlayerTest {
	
	private static final Sprite sprite = new Sprite('H', "Player.png");
	private MyPlayer myPlayer; 
	
	public MyPlayerTest(final int x, final int y, final IGround ground) {
		super(x, y, sprite, ground, Permeability.BLOCKING);
	}
	
	@Before
	protected void setUp() throws Exception {
	super.setUp();
	myPlayer = new MyPlayer(0,0,sprite,ground,Permeability.BLOCKING);
	}
	
	@After
	protected void tearDown() throws Exception {
	super.tearDown();
	myPlayer = null;
	}
}
