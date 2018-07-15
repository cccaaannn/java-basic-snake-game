package snake_game;



import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

//import frame.Client;

//import org.omg.Messaging.SyncScopeHelper;



public class frame_client extends JComponent implements ActionListener,KeyListener{

	
	
	static int gameoverdecider = 0;
	
	static boolean clientwin = false;
	static boolean serverwin = false;
	

	boolean serveriswining = true; 
	
	
	
	int time_second;
	int time_minute;
	
	static boolean gameover = false;
	
	Random random = new Random();
	
	boolean powerupisactive = false;
	int powerupblink = 100;
	int gameoverblink = 100;
	
	int lifepoints = 4;
	
	Image backgraund;
	Image backgraund2;
	Image backgraund3;
	
	
	int Vx = 20,Vy = 0;
	int VVx,VVy;
	int VVVx,VVVy;
	
	static String name = "default";
	public static String name2;
	
	static int head = 0;
	static int snake_length = 9;
	
	int hitwhere;
	
	int scoretablesize = 3;
	String [] names = new String[scoretablesize+1];
	int [] scores = new int[scoretablesize+1];
	
	
	read_write rw;
	
	
	static ArrayList<Rectangle2D.Float> rect = new ArrayList<Rectangle2D.Float>();
	static ArrayList<Rectangle2D.Float> rect2 = new ArrayList<Rectangle2D.Float>();
	
	//static Rectangle2D.Float [] rect=new Rectangle2D.Float[500];
	//static Rectangle2D.Float [] rect2=new Rectangle2D.Float[50];
	
	//Rectangle2D.Float [] rect3=new Rectangle2D.Float[20];
	
	
	
	//static boolean [] snake1 = new boolean[500]; 
	//static boolean [] snake2 = new boolean[50]; 
	
	int snake2_length = 9;
	
	
	/*
	boolean [] snake3 = new boolean[20]; 
	
	
	int snake3_length = 19;
	
	int snake2_length2 = 9;
	int snake3_length2 = 19;
	*/
	
	
	static Food [] antifoods = new Food[10];
    
	//Food  [] bigfood = new Food[1];
    
    
	static Food [] foods = new Food[15];
    
	/*Food powerupp; 
    int powerupx,powerupy;
	
	//ArrayList<Rectangle2D.Float> rect = new ArrayList<Rectangle2D.Float>(10); 
	
	*/
	
	
	
	public frame_client(String name) {
		
		
		
		this.name = name;
		
	
for (int i = rect.size(); i < 10; i++) {
			
			rect.add(i,new Rectangle2D.Float(((200-i)*20),300, 20, 20));
		
		}
		
		
for (int i = rect2.size(); i < 10; i++) {
			
			rect2.add(i,new Rectangle2D.Float(((100-i)*20),100, 20, 20));
		
		}
	
		
		
		
		/*
		////////food///////////
		
		int foodx,foody,foodh = 15,foodw = 15;
		
		
		
		for (int i = 0; i < foods.length; i++) {
			foodx = random.nextInt(1200) + 20;
			foody = random.nextInt(680) + 20;
			foods[i] = new Food(1,foodx,foody,foodw,foodh);
		}
		///////big food////////////
		
		bigfood[0] = new Food(1,(random.nextInt(1200) + 20),(random.nextInt(680) + 20),25,25);
		
		///////////antifood//////
		
		int antifoodx,antifoody,antifoodh = 15,antifoodw = 15;
		
		
		for (int i = 0; i < antifoods.length; i++) {
			antifoodx = random.nextInt(1200) + 20;
			antifoody = random.nextInt(680) + 20;
			antifoods[i] = new Food(1,antifoodx,antifoody,antifoodw,antifoodh);
		}
		
		*/
	
		/////////bavkgraund image///////////////
		backgraund = Toolkit.getDefaultToolkit().createImage("background.png");
		backgraund2 = Toolkit.getDefaultToolkit().createImage("background2.png");
		backgraund3 = Toolkit.getDefaultToolkit().createImage("background3.png");
		
		/*
		
		/////////read write-user name construct///////
		rw = new read_write();
		names = rw.getnames(); 
		scores = rw.getscores();
		names[scoretablesize] = name;
		scores[scoretablesize] = 0;
		
		
		*/
		
		
		
		
		
		
		
		
		////////////timers/////////////
		
		
		ilkyilan.start();
		t2.start();
		foodcolisiontimer.start();
		blink.start();
	    timetimer.start();
	
	
	
	////////client thread/////
	    
	
	t.start();
	
	}

	
	
	static int snakecolor1;
	
	static int snakecolor2;
	 
    static int snakecolor3;
	
    
   
    
	//arka plan kýrmýzý yanýp sönsün diye
    int carpmasayaci2 = 1;
	
    //arka plan mavi yanýp sönsün diye
    int positivehitcount2 = 1;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(8));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		
		
		//arka plan kýrmýzý yanýp sönsün diye	
		if(carpmasayaci2 != carpmasayaci) {
		g2.drawImage(backgraund2, 0, 0, null);
		carpmasayaci2 = carpmasayaci;
		}
		else if(positivehitcount2 != positivehitcount){
		g2.drawImage(backgraund3, 0, 0, null);
		positivehitcount2 = positivehitcount;
		}
		else {
		g2.drawImage(backgraund, 0, 0, null);
		}
	
		
if(!gameover) {
	


	
	
	
	for (int i = 0; i < rect.size(); i++) {
	
		if(i==1) {
			g2.setColor(Color.RED);
			g2.fill(rect.get(i));
		}
		else if(i % 2 == 0) {
		g2.setColor(new Color(snakecolor1,0,snakecolor2));
		g2.fill(rect.get(i));
		}
		else {
			g2.setColor(new Color(snakecolor3,0,snakecolor2));
			g2.fill(rect.get(i));
		}
	}
	
	



	for (int i = 0; i < rect2.size(); i++) {
		
		
		if(i==1) {
			g2.setColor(Color.RED);
			g2.fill(rect2.get(i));
		}
		else if(i % 2 == 0) {
		g2.setColor(new Color(0,snakecolor1,snakecolor2));
		g2.fill(rect2.get(i));
		}
		else {
			g2.setColor(new Color(0,snakecolor3,snakecolor2));
			g2.fill(rect2.get(i));
		}
	    
		
	
	
	}









}
		/*
		//ikinci yýlan////////////////////
		for (int i = 0; i < rect2.length; i++) {
			if(snake2[i]) {
			if(i == 1) {
				g2.setColor(Color.GREEN);
				g2.fill(rect2[i]);
			}
			else if(i % 2 == 0) {
				g2.setColor(new Color(snakecolor1,0,snakecolor2));
				g2.fill(rect2[i]);
				}
				else {
					g2.setColor(new Color(snakecolor3,0,snakecolor2));
					g2.fill(rect2[i]);
				}
		   }
		}
		
		
		*/
		
		/*
		
		//3. yýlan///////////////////
			for (int i = 0; i < rect3.length; i++) {
				if(snake3[i]) {
				if(i == 1) {
					g2.setColor(Color.GREEN);
					g2.fill(rect3[i]);
				}
				else if(i % 2 == 0) {
					g2.setColor(new Color(0,snakecolor2,snakecolor1));
					g2.fill(rect3[i]);
					}
					else {
						g2.setColor(new Color(0,snakecolor2,snakecolor3));
						g2.fill(rect3[i]);
					}
			}	
			}
			*/
			//////////////////food antifood////////////////////////////
if(!gameover) {		
			
	
	      for (int i = 0; i < foods.length; i++) {
			 if(foods[i].effect == 1) {
				g2.setColor(Color.ORANGE);
				g2.fill(foods[i]);
			 }
			}
			
			/*
			 if(bigfood[0].effect == 1) {
			g2.setColor(new Color(255,70,0));
			g2.fill(bigfood[0]);
			 }
			*/
			 
			
			for (int i = 0; i < antifoods.length; i++) {
				 if(antifoods[i].effect == 1) {
					g2.setColor(Color.RED);
					g2.fill(antifoods[i]);
				 }
				}
					
			
			/////////////////////////////////////////////////////////////
			
			
			
			/*
			if(poweruptime) {
			
	        
			powerupp = new Food(0,powerupx,powerupy,20,20);
			
			g2.setColor(Color.BLUE);
			g2.fill(powerupp);
			
			powerupapeartime.stop();
			if(poweruptaken == false) {
			powerupstaytime.start();
		
			}
			else {
			powerupstaytime.restart();
			poweruptaken = false;
			}
			
			
			}
			
			*/
			
			
			///////////////////////transparent color//////////////////////
			
			int alpha = 190; // 50% transparent is 127
			Color transparentwhite = new Color(255,255,255, alpha);
			Color transparentyellow = new Color(255,255,0, alpha);
			//////////////////////////////////////////////////////////////	
			
			
	    g2.setFont(new Font("Arial", Font.PLAIN, 20));
		
	    g2.setColor(Color.WHITE);
		
		g2.drawString("PLAYER: "+ name,10,20);
		
		g2.setColor(transparentwhite);
		
		
		
		if(poverup == true) {
		   if(powerupblink % 2 == 0) {
			g2.setColor(transparentyellow);
			g2.drawString("POWER UP READY",10,650);
		  
		   }
		   else {
			g2.setColor(transparentwhite);
			g2.drawString("POWER UP READY",10,650);
			
		   }
		   g2.setColor(transparentwhite);
			}
		
		
		if(ilkyilan.getDelay() <= 50) {
		g2.drawString("SPEED LEVEL: MAX",270,30);
		}
		else if(ilkyilanhizli.isRunning()) {
	    g2.drawString("SPEED LEVEL: SPEED UP",270,30);
	    }
		else if(ilkyilan.isRunning()) {
		g2.drawString("SPEED LEVEL: "+(120-ilkyilan.getDelay()),270,30);
		}
		
      
        g2.drawString("LENGTH: " + snake_length,270,60);
		      
		g2.drawString("POÝNTS: "+foodeaten,10,60);

		g2.drawString("LÝFE: " + (carpmasayaci*5)+" / 100",10,90);     //lifepoints bundan vaz geçtim
		
		
		
		g2.setColor(Color.YELLOW);
	
		g2.drawString("TÝME",540,30);
		
		g2.drawString(time_minute + ":" + time_second,545,60);
		



		g2.drawString("SCORES",1050,30);
		
		g2.setColor(transparentwhite);
		
		if(serveriswining) {
		g2.drawString(name+": "+foodeaten,1050,60);
		g2.drawString(name2+": "+foodeaten2,1050,90);
		}
		else {
		g2.drawString(name2+": "+foodeaten2,1050,60);	
		g2.drawString(name+": "+foodeaten,1050,90);
		}
		
}		
		
		
if(gameover) {
	
			timetimer.stop();
			ilkyilan.stop();
			ilkyilanhizli.stop();
			speeduppointdecreasetimer.stop();
			//foodcolisiontimer.stop();
			
			
			g2.setFont(new Font("Arial", Font.BOLD, 100));
			
		  
			if(powerupblink % 2 == 0) {
			
			g2.setFont(new Font("Arial", Font.BOLD, 100));
			g2.setColor(Color.YELLOW);
			g2.drawString("GAME OVER",300,250);
			
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("TÝME",540,50);
			g2.drawString(time_minute + ":" + time_second,545,100);
			
			}
			
			else {
				
			g2.setFont(new Font("Arial", Font.BOLD, 100));
			g2.setColor(Color.RED);
		    g2.drawString("GAME OVER",300,250);
			
			
		    g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.drawString("TÝME",540,50);
			g2.drawString(time_minute + ":" + time_second,545,100);
			
			}
		
			

			if(foodeaten < foodeaten2) {
				
				
				
				g2.setFont(new Font("Arial", Font.BOLD, 40));
				g2.setColor(Color.YELLOW);
			    g2.drawString("YOU LOST",300,350);
				
			
				
			}
			
			if(foodeaten > foodeaten2) {
				
				g2.setFont(new Font("Arial", Font.BOLD, 40));
				g2.setColor(Color.YELLOW);
			    g2.drawString("YOU WÝN",300,350);
				
			
			}
			

			if(foodeaten == foodeaten2) {
				
				g2.setFont(new Font("Arial", Font.BOLD, 40));
				g2.setColor(Color.YELLOW);
			    g2.drawString("DRAW",300,350);
				
			
			}
			
			
			/*
			g2.setFont(new Font("Arial", Font.BOLD, 70));
			g2.setColor(Color.YELLOW);
			g2.drawString("HIGH SCORES",300,450);
			
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.setColor(Color.WHITE);
			
			for (int i = 0; i < scores.length-1; i++) {
				g2.drawString(names[i]+": "+scores[i],300,500+i*50);
				}
			*/
			
			

			g2.setFont(new Font("Arial", Font.BOLD, 70));
			g2.setColor(Color.YELLOW);
			g2.drawString("SCORES",300,450);
			
			g2.setFont(new Font("Arial", Font.BOLD, 50));
			g2.setColor(Color.WHITE);
			
			if(serveriswining) {
		g2.drawString(name+": "+foodeaten,300,500);
		g2.drawString(name2+": "+foodeaten2,300,550);
		}
		else {
		g2.drawString(name2+": "+foodeaten2,300,500);	
		g2.drawString(name+": "+foodeaten,300,550);
		}
			
			/*
			g2.setFont(new Font("Arial", Font.BOLD, 40));
			g2.setColor(Color.YELLOW);
		    g2.drawString("YOUR SCORE",300,320);
			
		    g2.setFont(new Font("Arial", Font.BOLD, 40));
			g2.setColor(Color.WHITE);
		    g2.drawString(name+": "+foodeaten,300,360);
			*/
			
}
		
		
		
		
		}
	
		
	
	
	
	
	
	
	Client c;
	

	Thread t = new Thread() {
	    public void run() {
	    	c = new Client();
	  
	    }
	};
	
	
	
	
	
	Timer blink = new Timer(500, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	powerupblink++;
	gameoverblink++;
	
	    }    
		});
	
	
	
	
	
	
	
	public void setname(String name) {
		this.name = name;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	int positivehitcount = 0;
	
	 //skor tablosundaki çözemediðim sýkýntý için
	int za = 0;
	 //yýlanlarla çarpma kontrolü
	
	public int carpmasayaci = 0;
	
	
	
	
	
	
	

	Timer t2 = new Timer(20, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

	    	
	    	if(Message.gameover) {
	    		gameover = true;
	    	}
	    	
	    	

if(!gameover) {	    	
    	
	    	if(ishit(rect,rect2)) {
  
		    		carpmasayaci++;
	    			
		    		
		    		if(carpmasayaci % 5 == 0) {
		    			
	    				lifepoints--;
	    				
	    				if(lifepoints == 0) {
	    				Message.gameover = true;
	    					gameover = true;
	    				
	    				}
	    			}
	    			
	    	}
}
	    




if(foodeaten >= foodeaten2) {
	 serveriswining = true;
}

else {
	 serveriswining = false;
}








	    }
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////yýlan hýzý þeyleri////////////////////////////////////////
	int snakespeed = 100;
	//ilkyýlan yavaþ hali
	 Timer ilkyilan  = new Timer(120, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

	    	
	    	rect.set(head,new Rectangle2D.Float(rect.get(head).x + Vx,rect.get(head).y + Vy, 20, 20));
	    	
	    	
				//hacý burayý tam terine çevirdim kafasý sonda deðil vaþta olsun diye UNUTMA ///////////////////////
				for (int i = snake_length; i > 0; i--) {
					
					rect.set(i,new Rectangle2D.Float(rect.get(i-1).x,rect.get(i-1).y, 20, 20));
					
					//rect.get(i).x = rect.get(i-1).x;
					//rect.get(i).y = rect.get(i-1).y;
				
				}
			//////////////////////////////////////////////////////////////////////////////////////////////////////
			walhitfix(rect);
			
			repaint();
	    }
	});
	

	
	
	
	//ilkyýlan hýzlý hali
	Timer ilkyilanhizli  = new Timer(20, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

rect.get(head).x += Vx;
			
			rect.get(head).y += Vy;
			
			for (int i = snake_length; i > 0; i--) {
				rect.get(i).x = rect.get(i-1).x;
				rect.get(i).y = rect.get(i-1).y;
			
			}
			walhitfix(rect);
    
			repaint();
	    }
	});
		
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	////////////////////////////////food zýmbýrtýlarý////////////////////////////////////////////////////////////////////
	
	 static int foodeaten = 0;
	static int foodeaten2 = 0;
	
	
	 int speedupvalue = 2;
	
	static boolean yedin = false;
	
	static int foodeaaten_serverdan_gelen;
	
	Timer foodcolisiontimer  = new Timer(40, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
  
	    	
	    	
	    	//if(foods[0].foodcolision(rect, foods,head)) {
	
	    	if(foodeaten != foodeaaten_serverdan_gelen) {
	    	
	         foodeaten++;		
	         
	         rect.add(new Rectangle2D.Float(rect.get(rect.size()-1).x,rect.get(rect.size()-1).y,20,20));
	         
	    
	         
	         snake_length++;
	    

	         if(ilkyilan.getDelay() >= 50) {
	        	 ilkyilan.setDelay(ilkyilan.getDelay()-speedupvalue);                                                 ////////////////////burda yavaþlama þeyi var
	         System.out.println("delay: "+ilkyilan.getDelay());
	         }
	         
	         
	    	}
	    
	
	    	/*
	    	
	    	if(antifoods[0].foodcolision(rect, antifoods,head) && snake_length > 2) {
	    		
		         foodeaten--;		
		    
		         rect.remove(new Rectangle2D.Float(rect.get(rect.size()-1).x,rect.get(rect.size()-1).y,20,20));
		         
		         snake_length--;
		         
		        
		        
		         if(ilkyilan.getDelay() <= 120) {
		        	 ilkyilan.setDelay(ilkyilan.getDelay()+speedupvalue);                                         ///////////////burda hýz þeyi var                                      ////////////////////burda yavaþlama þeyi var
		         System.out.println("delay: "+ilkyilan.getDelay());
		         }
		         
		         
		    	}
		    
*/
	    	
	    	
	    }
	});
	
	
	
	
	/*
	Timer foodreplacertimer  = new Timer(100, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
  
	    	if(foods[0].foodcount(foods) < 7) {
	
	    		foods[0].foodreplacer(foods);
	
	    		if(bigfood[0].foodcount(bigfood) < 1) {
	    		    
	    	    	bigfood[0].bigfoodreplacer(bigfood);
	    	    	}
	    	    		
	    	}
	    	
	    	
	    	
	    	if(antifoods[0].foodcount(antifoods) < 3) {
	    		
	    		antifoods[0].foodreplacer(antifoods);
	
	    	}
	        	
	    	
	    }
	});
	*/
	////////////////////////////////////time þeyi/////////////////////
	
	Timer timetimer  = new Timer(1000, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    
	    	
	    	//saatin kontrolü yok artýk 1 saat de oynama yani
	    	
	    	if(time_second == 59) {
	    		time_second = 0;
	    		time_minute++;
	    	}
	    	else {
	    	time_second++;
	    	}
	    
	    
	    
	    
	    }});
	
	
	
	//////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	//powerup basýlýnca kullaným süresi
	Timer poveruptime  = new Timer(2000, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	
	    	poverup = false;
	    	/*
	    	ilkyilanhizli.stop();
			
	    	if(foodeaten >= 20) {
				ilkyilan2.start();
			}                                                                 ////////////////////burda yavaþlama þeyi var
			else {
			ilkyilan.start();
			}
		*/	
	    	powerupisactive = false;
	    	poveruptime.stop();
	    
	    }
	});
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	boolean poweruptime = false;
	
	//powerup cooldown süresi
	Timer powerupapeartime  = new Timer(9000, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

	      poweruptime = true;   	
	      powerupx = random.nextInt(1200) + 10;
			powerupy = random.nextInt(680) + 10;
			powerupcolisiontimer.start();
	    
	    }
	});
	
	//powerup kalma süresi
	Timer powerupstaytime  = new Timer(9000, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

	      poweruptime = false;   	
	      powerupapeartime.start();
	      powerupcolisiontimer.stop();
	    }
	});
		
	//start ve restartý ayarlamak için
	boolean poweruptaken = false;
	//powerupalýndý mý kontrolü
	Timer powerupcolisiontimer  = new Timer(20, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

	    	if(powerupcolision(rect,powerupx,powerupy)) {
	    	poverup = true;
	    	poweruptime = false;   	
		      powerupapeartime.start();
				poweruptaken = true;
		      System.out.println("POWERUP ALINDI");
	    	}
	    	
	    	
				
	    }
	});	
	
	*/

	
	
	
	

	///////////////////////////hýzlandýrma zýmbýrtýlarý/////////////////////////////////////
	Timer speeduppointdecreasetimer  = new Timer(500, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

	    	if(foodeaten > 0) {
//////////////puan azaldýkça kýsalman lazým burasý lazým yani
		        
	    		foodeaten--;
	    		
	    		//snake1[snake_length] = false;
			      
	    		rect.remove(rect.size()-1);
	    		
			         snake_length--;
			         
					    
			         if(ilkyilan.getDelay() <= 120) {
			        	 ilkyilan.setDelay(ilkyilan.getDelay()+speedupvalue);                                                 ////////////////////burda yavaþlama þeyi var                           ////////////////////burda yavaþlama þeyi var
			         System.out.println("delay: "+ilkyilan.getDelay());
			         }
			      
	    	}
	     
	    	else {
	    		
	////////////////////hýzlýyken 0 ýn aþtýna düþersen dursun diye    		
	    		
	    		ilkyilanhizli.stop();
        		
    
			ilkyilan.start();                                                 ////////////////////burda yavaþlama þeyi var
        	
	    	
        	
        	speeduppointdecreasetimer.stop();
        	
	    	}
	    	
	    }
	});
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	//************************************************************
	
	///////////////////////////////////////////////hocanýn verdiði kýsýmdan kalanlar/////////////////////////////////////////////////////////////////////////
	
	public void actionPerformed(ActionEvent e) {
	
		/*
	    rect2[0].x += VVx;
		
		rect2[0].y += VVy;
		
		
		for (int i = snake2_length; i > 0; i--) {
			
			
			rect2[i].x = rect2[i-1].x;
			rect2[i].y = rect2[i-1].y;
		
		}
		
		
		walhitfixforbots(rect2);
		//yýlan ýn çoðu kesilmiþse yeniden oluþturuyoruz
		if(snake2[3] == false || snake2[2] == false || snake2[1] == false || snake2[0] == false) {
			rect2[0].x = 20;
			rect2[0].y = 300;
			
			snake2_length = 9;
			snake2_length2 = 9;
			
			for (int i = 0; i < 9; i++) {
			snake2[i] = true;
		}
        
		}
		
		
	    rect3[0].x += VVVx;
		
		rect3[0].y += VVVy;
		
		
		for (int i = snake3_length; i > 0 ; i--) {
			rect3[i].x = rect3[i-1].x;
			rect3[i].y = rect3[i-1].y;
		
		}
		
		walhitfixforbots(rect3);
	    
	//yýlan ýn çoðu kesilmiþse yeniden oluþturuyoruz
		if(snake3[3] == false || snake3[2] == false || snake3[1] == false || snake3[0] == false) {
			rect2[0].x = 20;
			rect2[0].y = 500;
			
			snake3_length = 19;
			snake3_length2 = 19;
			
			
			for (int i = 0; i < 19; i++) {
				snake3[i] = true;
			}
			
		}
		*/
		
		repaint();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	public boolean ishit(ArrayList<Rectangle2D.Float> rect,ArrayList<Rectangle2D.Float> rect2) {
		
			for (int j = 0; j < rect2.size()-1; j++) {
				
		
				if(rect.get(head).intersects(rect2.get(j))) {
					return true;				
				}
			}
		return false;
	}
	
	
	
	
	public boolean powerupcolision(ArrayList<Rectangle2D.Float> rect,int x,int y) {
		
		if(rect.get(head).x - x >= -17 && rect.get(head).x - x <= 17 && rect.get(head).y - y >= -17 && rect.get(head).y - y <= 17) {
			return true;		
		}
			
		return false;
	}
	
	
	
	
	
	

	
	public void walhitfix(ArrayList<Rectangle2D.Float> rect) {
	
	
		if(rect.get(head).x >= 1260 ) {
			rect.get(head).x = 0;
		}
	
		else if(rect.get(head).x <= 0 ) {
			rect.get(head).x = 1250;
		}
	
		else if(rect.get(head).y >= 680 ) {
			rect.get(head).y = 0;
		}
	
		else if(rect.get(head).y <= 10 ) {
			rect.get(head).y = 675;
		}

	}
	
	
	
	
	public void walhitfixforbots(Rectangle2D.Float [] rect) {
		
		
		if(rect[0].x >= 1260 ) {
			rect[0].x = 0;
		}
	
		else if(rect[0].x <= 0 ) {
			rect[0].x = 1250;
		}
	
		else if(rect[0].y >= 680 ) {
			rect[0].y = 0;
		}
	
		else if(rect[0].y <= 10 ) {
			rect[0].y = 675;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	boolean poverup = false;
	boolean poverupbutton = false;
	
	
	boolean right = true;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	
	
	
	public void keyPressed(KeyEvent e) {
		/*switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				Vy= -20;
				Vx = 0;
				break;		
			case KeyEvent.VK_DOWN:
				Vy = 20;
				Vx = 0;
				break;
			case KeyEvent.VK_LEFT:
				Vx=-20;
				Vy=0;
				break;
			case KeyEvent.VK_RIGHT:
				Vx=20;
				Vy=0;
				break;
		}*/
		
		if(e.getKeyCode() == KeyEvent.VK_F) {
			poverupbutton = true;
		
		}
	
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
if(!gameover) {
			
				if(foodeaten > 0) {
			
			speeduppointdecreasetimer.start();
        		
			ilkyilan.stop();
			                                                ////////////////////burda yavaþlama þeyi var
			
			ilkyilanhizli.start();
			}
		
}
		}
		
	
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {

			
if(gameover == true) {
			
				System.exit(0);
				
				
				 
}
		}
		
		
		if(poverup == true && poverupbutton == true) {
			
			powerupisactive = true;
			poveruptime.restart();
			
			/*
			poveruptime.restart();
			ilkyilan.stop();
			ilkyilan2.stop();                                                 ////////////////////burda yavaþlama þeyi var
			
			ilkyilanhizli.start();
		  */  
		}
	
	
	
			
		if((e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) && !(down == true)) {
			Vy= -20;
			Vx = 0;
		
			

			right = false; 
			left = false;
			up = true;
			down = false;
			}
		else if((e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) && !(up == true)) {
			Vy= 20;
			Vx = 0;
		

			right = false; 
			left = false;
			up = false;
			down = true;
		}
		else if((e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) && !(right == true)) {
			Vx= -20;
			Vy = 0;
		

			right = false; 
			left = true;
			up = false;
			down = false;
		}
		else if((e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) && !(left == true)) {
			Vx= 20;
			Vy = 0;
		

			right = true; 
			left = false;
			up = false;
			down = false;
		}
		
		
		
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_F) {
			poverupbutton = false; 
			
		}
		
		
          if(e.getKeyCode() == KeyEvent.VK_SPACE) {
		
if(!gameover) {
      			
        	  
        	  if(foodeaten > 0) {
        	  foodeaten--;
	    		
	    		//snake1[snake_length] = false;
			  
        	  rect.remove(rect.size()-1);
        	  
			         snake_length--;
        	  
        	  
					    
			         if(ilkyilan.getDelay() <= 120) {
			        	 ilkyilan.setDelay(ilkyilan.getDelay()+speedupvalue);                                                 ////////////////////burda yavaþlama þeyi var                           ////////////////////burda yavaþlama þeyi var
			         System.out.println("delay: "+ilkyilan.getDelay());
			         }
        	  
        	  }
			        
        	  
        		ilkyilanhizli.stop();
        		
 
        		speeduppointdecreasetimer.stop();
        		
        	
			ilkyilan.start();                                                 ////////////////////burda yavaþlama þeyi var
        	
		
}
		
        	  
    }
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}





