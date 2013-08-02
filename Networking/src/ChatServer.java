import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;


public class ChatServer {
	

	public static void main(String[] args) {
		ArrayList<String> messages= new ArrayList<String>();
		try {
			ServerSocket server = new ServerSocket(9090);
			System.out.println("Listening on port 9090.");
			while(true){
				Socket client = server.accept();
				messages.add("Got a connection from " + client.getInetAddress());
				
				ChatThread thread = new ChatThread(client,messages);
				Thread t = new Thread(thread);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
   class ChatThread implements Runnable
{
	BufferedReader input;
	PrintWriter output;
	ArrayList <String> chatRoom;
	int postion = 0;
	long lastMessageTime = 0;
	public ChatThread(Socket s,ArrayList<String> messages)
	{
		try {
			input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			output = new PrintWriter(s.getOutputStream(),true);
			chatRoom = messages;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void run() {
		while(true){
				try {
					String in = input.readLine();
					
					if(in != null )
					{
						if(in.length() == 0)
						{
							output.println("Bad boy/girl/adult");
						}
						else if(in.length() == 300)
						{
							output.println("Terrible boy/girl/adult");
						}
						else if(lastMessageTime < System.currentTimeMillis() - 1000)
						{
						lastMessageTime=System.currentTimeMillis();
						chatRoom.add(filter(in));
						}
						else
						{
							output.println("You got rate limited foo");
						}
					}
					for(int x = postion; x < chatRoom.size(); x++)
					{
						
						output.println(chatRoom.get(x));
					}
					postion = chatRoom.size();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			}
		
		}
	public String filter(String text)
	{
		
		text = text.replaceAll("(\\w+) is (bad|stupid|dumb|crazy)","$1 is not $2");

		return text;
	}
	}

