package snake_game;

import java.io.*;

public class read_write {

	String [] names = new String[4];
	
	int [] scores = new int[4];
	
	
	String [] s = new String[4];
	
	
	 File file = new File("C:\\Users\\user\\eclipse-workspace\\snake_game2\\high_scores.txt");//C:\\Users\\can\\eclipse-workspace\\snake_game\\high_scores.txt

	read_write() {

		try {
			  BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
		
			  int i = 0;
			  while (i < 4) {
				  s[i] = br.readLine();
				  i++;
			  }
			  
		}
		 catch (Exception e) {
				System.out.println("OKUYAMADIM");
					
		 }
		
		try {
		int i = 0; 
		while(i < 4) {
		scores[i] = Integer.parseInt(s[i].substring(s[i].indexOf("=")+1)); 
		names[i] = s[i].substring(0,s[i].indexOf("=")); 
		i++;
	   }
		}
		 catch (Exception e) {
				System.out.println("KESEMEDÝM");
				scores[0] = 15;
				names[0] = "ali kaptan";
				scores[1] = 10;
				names[1] = "ölümde buluþacaz";
				scores[2] = 7;
				names[2] = "XD";
				scores[3] = 2;
				names[3] = "a";
		 }
		
	}
	
	
	
	public void write(int[] scores,String[] names) {
		
		try {
		PrintWriter writer = new PrintWriter("high_scores.txt", "UTF-8");

	    
		
		    for (int i = 0; i < names.length; i++) {
		    	writer.println(names[i]+"="+scores[i]);
		    } 
		    
		    System.out.println("YAZDIM");
		    writer.close();
		}

	catch (Exception e) {
	System.out.println("YAZAMADIM");
	scores[0] = 15;
	names[0] = "ali kaptan";
	scores[1] = 10;
	names[1] = "ölümde buluþacaz";
	scores[2] = 7;
	names[2] = "XD";
	scores[3] = 2;
	names[3] = "a";
	}
		
	}
	
	
	
	
	
	public int[] getscores() {
		return scores;
	}
	
	public String[] getnames() {
		return names;
	}
	
	
	
	
	
}
