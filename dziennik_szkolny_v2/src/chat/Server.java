package chat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Server {
	
	private static int uniqueId;
	
	private ArrayList<ClientThread> al;
	
	private Server_GUI sg;	
	
	private SimpleDateFormat sdf;
	
	private int port;
	
	private boolean keepGoing;
	

	
	
	public Server(int port,Server_GUI sg) {
		this.sg=sg;
		this.port = port;
		
		sdf = new SimpleDateFormat("HH:mm:ss");
		
		al = new ArrayList<ClientThread>();
	}
	
	public void start() {
		keepGoing = true;
		
		try 
		{
			
			ServerSocket serverSocket = new ServerSocket(port);

			
			while(keepGoing) 
			{
				
				display("Oczekiwanie na polaczenie rodziców na porcie " + port + ".");
				
				Socket socket = serverSocket.accept();  	
			
				if(!keepGoing)
					break;
				ClientThread t = new ClientThread(socket);  
				al.add(t);									
				t.start();
			}
			
			try {
				serverSocket.close();
				for(int i = 0; i < al.size(); ++i) {
					ClientThread tc = al.get(i);
					try {
					tc.input.close();
					tc.output.close();
					tc.socket.close();
					}
					catch(IOException ioE) {
						ioE.printStackTrace();
					}
				}
			}
			catch(Exception e) {
				display("Exception closing the server and clients: " + e);
			}
		}
	
		catch (IOException e) {
            String msg = sdf.format(new Date()) + " Exception on new ServerSocket: " + e + "\n";
			display(msg);
		}
	}		
   
	protected void stop() {
		keepGoing = false;		
		try {
			new Socket("localhost", port);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void display(String msg) {
		String time = sdf.format(new Date()) + " " + msg;		
			sg.appendEvent(time + "\n");
	}
	/*
	 *  to broadcast a message to all Clients
	 */
	private synchronized void broadcast(String message) {
		
		String time = sdf.format(new Date());
		String messageLf = time + " " + message + "\n";			
	
		for(int i = al.size(); --i >= 0;) {
			ClientThread ct = al.get(i);
			// jak sie do jakiegos nie uda napisac to go usuwa bo znaczy ze go nie ma
			if(!ct.writeMsg(messageLf)) {
				al.remove(i);
				display("Disconnected Client " + ct.username + " removed from list.");
			}
		}
	}

	// gdy sie wylogowal klient,usuwanie
	synchronized void remove(int id) {
		
		for(int i = 0; i < al.size(); ++i) {
			ClientThread ct = al.get(i);			
			if(ct.id == id) {
				al.remove(i);
				return;
			}
		}
	}	
	
	/** dla kazdego klienta*/
	class ClientThread extends Thread {
		
		Socket socket; // the socket where to listen/talk
		ObjectInputStream input;
		ObjectOutputStream output;
		// my unique id (easier for deconnection)
		int id;
		// the Username of the Client
		String username;
		// the only type of message a will receive
		ChatMessage cm;
		// the date I connect
		String date;

		
		ClientThread(Socket socket) {
			id = ++uniqueId;
			this.socket = socket;
			
			try
			{
				// create output first
				output = new ObjectOutputStream(socket.getOutputStream());
				input  = new ObjectInputStream(socket.getInputStream());
				// read the username
				username = (String) input.readObject();
				display("Dolaczyl : " +username);
			}
			catch (IOException e) {
				display("Exception creating new Input/output Streams: " + e);
				return;
			}
			
			catch (ClassNotFoundException e) {
			}
            date = new Date().toString() + "\n";
		}

		// what will run forever
		public void run() {
			
			boolean keepGoing = true;
			while(keepGoing) {
				
				try {
					cm = (ChatMessage) input.readObject();
				}
				catch (IOException e) {
					display(username + " Exception reading Streams: " + e);
					break;				
				}
				catch(ClassNotFoundException e2) {
					break;
				}
				
				String message = cm.getMessage();

				switch(cm.getType()) {
				

				case ChatMessage.Action.MESSAGE:
					broadcast(username + ": " + message);
					break;
				case ChatMessage.Action.LOGOUT:
					display(username + " wylogowa³ siê.");
					writeMsg("Zosta³eœ wylogowany\n");	
					keepGoing = false;
					break;
				case ChatMessage.Action.WHOISON:
					writeMsg("Lista obecnych  " + sdf.format(new Date()) + "\n");					
					for(int i = 0; i < al.size(); ++i) {
						ClientThread ct = al.get(i);
						writeMsg((i+1) + ") " + ct.username);
					}
					break;
			
				}
			}
			
			remove(id);
			close();
		}
		
		
		private void close() {
			// try to close the connection
			try {
				if(output != null) 
					output.close();
			}
			catch(Exception e) {}
			try {
				if(input != null)
					input.close();
			}
			catch(Exception e) {};
			try {
				if(socket != null) 
					socket.close();
			}
			catch (Exception e) {}
		}

		
		private boolean writeMsg(String msg) {
		
			if(!socket.isConnected()) {
				close();
				return false;
			}
		
			try {
				output.writeObject(msg);
			}
			
			catch(IOException e) {
				display("Error sending message to " + username);
				display(e.toString());
			}
			return true;
		}
	}
}


