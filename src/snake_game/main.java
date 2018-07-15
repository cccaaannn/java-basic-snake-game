package snake_game;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

public class main {

	static int aaa = 100;
	
	

	public static void main(String[] args) {
	

		
		/*
		JFrame f=new JFrame("server");
		frame_server p = new frame_server("saaaa");
		
		//p.setname(menu.getname());
		
		f.addKeyListener(p);
		f.add(p);
		f.setBounds(100, 100, 1280, 720);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		Timer t = new Timer(100,p);
		t.start();
		*/
		
		/*
		JFrame ff=new JFrame("client");
		frame_client pp = new frame_client("asssss");
		
		//p.setname(menu.getname());
		
		ff.addKeyListener(pp);
		ff.add(pp);
		ff.setBounds(100, 100, 1280, 720);
		ff.setResizable(false);
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ff.setVisible(true);
		
		
		Timer tt = new Timer(100,pp);
		tt.start();
		*/
		
		
		
		menu_frame menu = new menu_frame("MENU");
		menu.setBounds(600, 300, 400, 230);
		menu.setResizable(false);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);
		//menu.addKeyListener(menu);
	
		
		
		while(menu.isVisible()) {
			System.out.println(menu.getoption());
		}
		
		
		
		if(menu.getoption() == 1) {
		
		System.out.println(menu.getname());
			
		JFrame f=new JFrame("single player");
		frame p = new frame(menu.getname());
		
		//p.setname(menu.getname());
		
		f.addKeyListener(p);
		f.add(p);
		f.setBounds(100, 100, 1280, 720);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		Timer t = new Timer(100,p);
		t.start();
		
		if(aaa == 0) {
			t.stop();
		}
		}
	
	
		
		if(menu.getoption() == 2) {
			
			JFrame f=new JFrame("server");
			frame_server p = new frame_server(menu.getname());
			
			//p.setname(menu.getname());
			
			f.addKeyListener(p);
			f.add(p);
			f.setBounds(100, 100, 1280, 720);
			f.setResizable(false);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			
			
			Timer t = new Timer(100,p);
			t.start();
			
			
		}
		
		
		
		
		if(menu.getoption() == 3) {
		
		JFrame ff=new JFrame("client");
		frame_client pp = new frame_client(menu.getname());
		
		//p.setname(menu.getname());
		
		ff.addKeyListener(pp);
		ff.add(pp);
		ff.setBounds(100, 100, 1280, 720);
		ff.setResizable(false);
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ff.setVisible(true);
		
		
		Timer tt = new Timer(100,pp);
		tt.start();
		
		}
		
		
	}

	
}



