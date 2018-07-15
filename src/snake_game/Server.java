package snake_game;

import java.awt.geom.Rectangle2D;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

//import frame.MyPanel;

public class Server {

	
	
	//private JTextField enterField;
		//private JTextArea displayArea;
		private ObjectOutputStream output;
		private ObjectInputStream input;
		private ServerSocket server;
		private Socket connection;
		private int counter = 1;
		
		
		Server(){
			this.runServer();
		}
		
		Message m = new Message();
		
		public void runServer(){
			try {
				server = new ServerSocket(12349, 100);
				while(true){
					try {
						waitForConnection();
						getStreams();
						processConnection();
					} catch (EOFException e) {
						displayMessage("\nServer terminated connection");
					}finally {
						closeConnection();
						++counter;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void waitForConnection() throws IOException{
			displayMessage("Waiting for connection\n");
			connection = server.accept();
			displayMessage("Connection " + counter + " received from: " + 
					connection.getInetAddress().getHostName());		
		}
		
		private void getStreams() throws IOException{
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			
			input = new ObjectInputStream(connection.getInputStream());
			displayMessage("\nGot I/O streams\n");
		}
		
		private void processConnection() throws IOException{
			
			//sendData(message);
			//setTextFieldEditable(true);
			
			do{
				try {
					
					
			
					
					
					m.yilan = frame_server.rect;
					
					m.foods = frame_server.foods;
				
					m.antifoods = frame_server.antifoods;
				
					m.snakecolor1 =  frame_server.snakecolor1;
					
				    m.snakecolor2 =  frame_server.snakecolor2;
							
					m.snakecolor3 =  frame_server.snakecolor3;
					
					m.snakecolor3 =  frame_server.snakecolor3;
					
					m.points_server = frame_server.foodeaten;
					
					m.name_server =  frame_server.name;
					
					//m.clientwin = frame_server.clientwin;
					
					m.yedin = frame_server.yedin;
					
					m.foodeaten_server_to_client = frame_server.foodeaten3;
					
					
					sendData(m);
					
				
					
					
					
					Message m2 = (Message) input.readObject();
					
					frame_server.rect2 = m2.yilan;
					
					frame_server.foodeaten2 = m2.points_client;
					
					frame_server.name2 = m2.name_client;
					
					//frame_server.serverwin = m2.serverwin;
					
					frame_server.gameover = Message.gameover;
					
					
				
				} catch (Exception e) {
					System.out.println("server saçma sapan biþey aldý");
					displayMessage("\nUnknown object type recevied");
				
					
				}
			}while(!Message.gameover);//!message.equals("SERVER>>> TERMINATE")
			//}while(true);
		
		}

		private void closeConnection(){
			displayMessage("\nTerminating connection\n");
			//setTextFieldEditable(false);
			
			try{
				output.close();
				input.close();
				connection.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void sendData(Message message){
			try{
//				output.writeObject(message);
				output.writeObject(message);
				output.reset();
				output.flush();
				//displayMessage(message);
			}
			catch (IOException e) {
			
				Message.gameover = true;
				
				//displayArea.append("\nError writing object");
//			System.out.println("\nError writing object");
				e.printStackTrace();
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
		}
		*/
		
		Rectangle2D.Float  yilan = new Rectangle2D.Float();
		
		public void setsnake(Rectangle2D.Float a) {
		
			yilan = a;
		
		}
		
	
	
	
}
