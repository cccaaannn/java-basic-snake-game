package snake_game;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

//import frame.MyPanel2;

public class Client {


	//private JTextField enterField;
	//private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	
	 ArrayList<Message> readList;
	
	//ArrayList<Rectangle2D.Float> message = new ArrayList<Rectangle2D.Float>();
	
	
	private String chatServer ="127.0.0.1";
	private Socket client;;
	
	
	//Client app = new Client("192.168.1.108");
	//app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	Client(){
	this.runClient();
	}	
	
	
	

	
	public void runClient(){
		try {
			connectToServer();
			getStreams();
			processConnection();
		} catch (EOFException e) {
			displayMessage("\nClient terminated connection");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();			
		}
	}

	private void connectToServer() throws IOException{
		displayMessage("Attempting connection\n");
		client = new Socket(InetAddress.getByName(chatServer), 12349);		
		displayMessage("Connected to: " + client.getInetAddress().getHostName());		
	}

	private void getStreams() throws IOException{
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();

		input = new ObjectInputStream(client.getInputStream());
		displayMessage("\nGot I/O streams\n");
	}

	private void processConnection() throws IOException{
		

		do{
			try {

				
				
				
				Message m = (Message) input.readObject();
				
				frame_client.rect2 = m.yilan;
				
				frame_client.foods = m.foods;
				
				frame_client.antifoods = m.antifoods;
				
				frame_client.snakecolor1 = m.snakecolor1;
				
				frame_client.snakecolor2 = m.snakecolor2;
				
				frame_client.snakecolor3 = m.snakecolor3;
				
				frame_client.foodeaten2 = m.points_server;
				
				frame_client.name2 = m.name_server;
				
				//frame_client.gameoverdecider = m.gameover;
				
				//frame_client.clientwin = m.clientwin;
				
				//frame_client.gameover = m.gameover;
				
				frame_client.yedin = m.yedin;
				
				frame_client.foodeaaten_serverdan_gelen = m.foodeaten_server_to_client;
				
				
				
				Message m2 = new Message();
				
				m2.yilan = frame_client.rect;
				
				m2.points_client = frame_client.foodeaten;
				
				m2.name_client = frame_client.name;
				
				//m2.serverwin = frame_client.serverwin;
				
				sendData(m2);
				
				
				
				
				/*
				message = (ArrayList<Rectangle2D.Float>) input.readObject();
				
				frame_client.rect2 = message;
			*/
				
			
				
			
			} catch (Exception e) {
			Message.gameover = true;
			System.out.println("server saçma sapan biþey aldý");	
			displayMessage("\nUnknown object type recevied");
				
			}
		}while(!Message.gameover);//!message.equals("SERVER>>> TERMINATE")
	//}while(true);
	
	}

	private void closeConnection(){
		displayMessage("\nClosing connection\n");
		//setTextFieldEditable(false);

		try{
			output.close();
			input.close();
			client.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendData(Message message){
		try{
		
			output.writeObject(message);
			output.reset();
			output.flush();
			
		}
		catch (IOException e) {
			//displayArea.append("\nError writing object");
		System.out.println("\nError writing object");
		}
	}

	private void displayMessage(final String messageToDisplay){
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				//displayArea.append(messageToDisplay);				
			System.out.println(messageToDisplay);
			}
		});
	}
/*
	private void setTextFieldEditable(final boolean editable){
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				enterField.setEditable(editable);				
			
			}
		});
	}*/




	Rectangle2D.Float  yilan = new Rectangle2D.Float();


	public Rectangle2D.Float   getsnake() {
		return yilan;
		
	}
	
	
	
}
