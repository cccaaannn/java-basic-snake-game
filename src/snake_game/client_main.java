package snake_game;

import javax.swing.JFrame;
import javax.swing.Timer;

public class client_main {

	public static void main(String[] args) {

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

	}

}
