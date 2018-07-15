package snake_game;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	public ArrayList<Rectangle2D.Float> yilan;
	Food [] foods;
	Food [] antifoods;
	int snakecolor1;
	int snakecolor2;
	int snakecolor3;
	int points_client;
	int points_server;
	String name_client;
	String name_server;
	
	static boolean gameover;
	
	int foodeaten_server_to_client;
	
	boolean serverwin;
	boolean clientwin;
	
	boolean yedin;
	
	Message(){
		
	}
	
}
