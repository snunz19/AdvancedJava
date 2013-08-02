import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;


public class dateClient {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the servers IP address : ");
		String ip = scan.nextLine();
        try {
			Socket sock = new Socket(ip,9090);
			BufferedReader input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintWriter output = new PrintWriter(sock.getOutputStream(),true);
			while(true)
			{
				String in = input.readLine();
				if(in!=null)
				{
					System.out.println(in);
				}
			}
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}

}

