import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;


public class chatClient {
	BufferedReader input;
	PrintWriter output;
	boolean initialized = false;
	public chatClient(String ip , int port)
	{
		try {
			Socket sock = new Socket(ip,port);
			 input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			 output = new PrintWriter(sock.getOutputStream(),true);
			 initialized = true;
			} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	public void send(String message){
		if(initialized)
		{
			output.println("Ronak: " + message);
		}
	}
	public String recieve(){
		if(initialized)
		{
			try {
				return input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
 
}

