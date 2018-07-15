package snake_game;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class menu_frame extends JFrame implements ActionListener,KeyListener,MouseListener{

	
	String a = ""; 
	String name;
	int option = 0;
	
	read_write rw;
	String []names = new String[4];
	int []scores = new int[4];
	
	 
	menu_frame(String a){
		super(a);
	
		
		

		
		group.add(server);
		group.add(player);
		
	
		altpanel.setLayout(fl);
		altpanel.add(b1);
		altpanel.add(b2);
		altpanel.add(b3);

		
		this.add(altpanel,BorderLayout.SOUTH);
	
		ortapanel.setLayout(null);
		ortapanel.add(entername);
		entername.setBounds(90,90,200,30);
		
		ortapanel.add(namelabel);
		namelabel.setBounds(140,40,200,30);
		
		
		ortapanel.add(server);	
		ortapanel.add(player);	

		server.setSelected(true);
		
		server.setBounds(130,120,70,30);
		player.setBounds(200,120,70,30);
		
		
		
	
		ortapanel.add(imglabel);
		imglabel.setBounds(85,5,200,30);
		
		
		this.add(ortapanel,BorderLayout.CENTER);
		
		
		
		
		
		
		setFocusable(true);
		addKeyListener(this);
		
		rw = new read_write();
		names = rw.getnames(); 
		scores = rw.getscores();
		
		
		
		
		
	   

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rw = new read_write();
				names = rw.getnames(); 
				scores = rw.getscores();
				
				if(entername.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill the empty fields");
				}	
			
				else if(entername.getText().equals(names[0]) || entername.getText().equals(names[1]) || entername.getText().equals(names[2])) {
					JOptionPane.showMessageDialog(null, "This name is already exists in high scores");
				}
				else {
					option = 1;
					name = entername.getText();
					setVisible(false);
				}
			
			}
		});
	   
	   
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(entername.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill the empty fields");
				}	
			
				else if(server.isSelected()) {
					option = 2;
					name = entername.getText();
					setVisible(false);
				}
				else if(player.isSelected()) {
					option = 3;
					name = entername.getText();
					setVisible(false);
				}
				
			}
		});
	   
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rw = new read_write();
				names = rw.getnames(); 
				scores = rw.getscores();
				
				JOptionPane.showMessageDialog(null,"single player\n"+"1-"+names[0]+":"+scores[0]+"\n2-"+names[1]+":"+scores[1]+"\n3-"+names[2]+":"+scores[2]);
			}
		});
		
		entername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(entername.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill the empty fields");
				}	
			
				else if(entername.getText().equals(names[0]) || entername.getText().equals(names[1]) || entername.getText().equals(names[2])) {
					JOptionPane.showMessageDialog(null, "This name is already exists in high scores");
				}
				else {
					option = 1;
					name = entername.getText();
					setVisible(false);
				}
			
			}
		});
		
		
		
		
	}
	
	
	
	public String getname() {
		return name;
	}
	
	public int getoption() {
		return option;
	}
	
	
	
	
	//layouts
	GridLayout gl = new GridLayout(1,3);
	FlowLayout fl = new FlowLayout();
	BorderLayout bl = new BorderLayout();
	
	
	//panels
	JPanel altpanel = new JPanel();
	JPanel ortapanel = new JPanel();
	JPanel ustpanel = new JPanel();
	
	
	
	//buttons
	JButton b1 = new JButton("single player");
	JButton b2 = new JButton("multi player");
	JButton b3 = new JButton("high scores");
	
	
	
	
	//textfields
	JTextField entername = new JTextField(a);
	
	
	
	//imageicon
	ImageIcon imgyilan = new ImageIcon("yýlan.png");
		
		
	
	
	
	//labels
	JLabel namelabel = new JLabel("Enter your name");
	JLabel imglabel = new JLabel(imgyilan,JLabel.CENTER);



	//radiobuttons 
	JRadioButton server = new JRadioButton("server");
	JRadioButton player = new JRadioButton("player");
	
	
	
	//radiogroup
	ButtonGroup group = new ButtonGroup();
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {

		if(arg0.getSource() == entername) {
			entername.setText("");
		}

	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {

	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
