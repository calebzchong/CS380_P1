import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		try (Socket socket = new Socket("18.221.102.182", 38001)) {
			
			System.out.println("Connected to server.");
			
			Scanner kb = new Scanner(System.in);
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os, true, "UTF-8");
			
			System.out.print("Enter your desired display name: ");
            String username = kb.nextLine();
            out.printf("%s%n", username);
            
			Runnable listeningRunnable = () -> {
				try {
					InputStream is = socket.getInputStream();
					InputStreamReader isr = new InputStreamReader(is, "UTF-8");
					BufferedReader br = new BufferedReader(isr);
					while ( true ){
						
						String str = br.readLine();
						System.out.println("Server: " + str);
						Thread.sleep(1000);
					}
				} catch ( SocketException e ){
					
				} catch ( Exception e) {
					e.printStackTrace();
				}
			};
			new Thread(listeningRunnable).start();
			
			String input = "";
            while( !input.equals("exit") ) {
//            	System.out.print( username + "> ");
                input = kb.nextLine();
                if ( input.equals("exit") ){
                	kb.close();
                	out.close();
                } else {
                	out.printf("%s%n", input);
                }
        	}
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
