package snake_game;



import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;



public class Food extends Ellipse2D.Float implements Serializable{

	int effect;
	int x,y;
	int h,w;
	
  Random random = new Random();

	
	
	
	Food(int effect,int x,int y,int w,int h){
		super(x,y,w,h);
		
		this.effect = effect;
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		
	}
	
	
	int geteffect() {
		return effect;
	}
	
	
	public boolean foodcolision(Rectangle2D.Float [] rect,Food [] foods,int head) {
		
		for (int j = 0; j < foods.length; j++) {
		if((rect[head].x - foods[j].x >= -15 && rect[head].x - foods[j].x <= 15) && (rect[head].y - foods[j].y >= -15 && rect[head].y - foods[j].y <= 15)) {        
 
		
			
			foods[j].x = -1;
			foods[j].y = -1;
			
			foods[j].effect = 0;
			return true;
		}
}
return false;
}
	
public boolean foodcolision(ArrayList<Rectangle2D.Float> rect,Food [] foods,int head) {
		
			for (int j = 0; j < foods.length; j++) {
			if((rect.get(head).x - foods[j].x >= -15 && rect.get(head).x - foods[j].x <= 15) && 
					(rect.get(head).y - foods[j].y >= -15 && rect.get(head).y - foods[j].y <= 15)) {        
	 
				foods[j].x = -1;
				foods[j].y = -1;
				
				foods[j].effect = 0;
				return true;
			}
	}
	return false;
	}
	/*
public boolean foodcolision(Rectangle2D.Float [] rect,Food food,int head) {
	
	
	if((rect[head].x - food.x >= -25 && rect[head].x - food.x <= 25) && (rect[head].y - food.y >= -25 && rect[head].y - food.y <= 25)) {        
		
		food.x = -1;
		food.y = -1;
		
		food.effect = 0;
		return true;
	}

return false;
}
*/

public int foodcount(Food [] foods) {
	
	int count = 0;
	
	for (int i = 0; i < foods.length; i++) {
		if(foods[i].effect == 1)
			count++;
	}
	
	return count;
}
	


public void foodreplacer(Food [] foods) {

	int foodx = 0;
	int foody = 0;
	
	
	for (int i = 0; i < foods.length; i++) {
		
		if(foods[i].effect == 0) {

			foodx = random.nextInt(1200) + 20;
			foody = random.nextInt(680) + 20;
			
			
			foods[i] = new Food(1,foodx,foody,15,15);
	
		}
	}
	
	
}


public void bigfoodreplacer(Food [] foods) {

	int foodx = 0;
	int foody = 0;
	
	
	for (int i = 0; i < foods.length; i++) {
		
		if(foods[i].effect == 0) {

			foodx = random.nextInt(1200) + 20;
			foody = random.nextInt(680) + 20;
			
			
			foods[i] = new Food(1,foodx,foody,25,25);
	
		}
	}
	
	
}

}
