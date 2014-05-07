package chat;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * The server that can be run both as a console application or a GUI
 */
public class Server {
	// a unique ID for each connection
	private static int uniqueId;
	// an ArrayList to keep the list of the Client
	private ArrayList<ClientThread> al;
	// if I am in a GUI
	private Server_GUI sg;	
	// to display time
	private SimpleDateFormat sdf;
	// the port number to listen for connection
	private int port;
	// the boolean that will be turned of to stop the server
	private boolean keepGoing;
	

	
	
	public Server(int port,Server_GUI sg) {
		this.sg=sg;
		this.port = port;
		// to display hh:mm:ss
		sdf = new SimpleDateFormat("HH:mm:ss");
		// ArrayList for the Client list
		al = new ArrayList<ClientThread>();
	}
	
	public void start() {
		keepGoing = true;
		/* create socket server and wait for connection requests */
		try 
		{
			// the socket used by the server
			ServerSocket serverSocket = new ServerSocket(port);

			// infinite loop to wait for connections
			while(keepGoing) 
			{
				// format message saying we are waiting
				display("Oczekiwanie na polaczenie rodziców na porcie " + port + ".");
				
				Socket socket = serverSocket.accept();  	// accept connection
				// if I was asked to stop
				if(!keepGoing)//przestan czekac
					break;
				ClientThread t = new ClientThread(socket);  // make a thread of it
				al.add(t);									// save it in the ArrayList
				t.start();
			}
			// I was asked to stop
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
		// something went bad
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
				username = (String) input.readObject();//tu moze zminie chociaz nie wiem   IMIE I NAZWISKO
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
			// to loop until LOGOUT
			boolean keepGoing = true;
			while(keepGoing) {
				// read a String (which is an object)
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
				// the messaage part of the ChatMessage
				String message = cm.getMessage();

				// Switch on the type of message receive
				switch(cm.getType()) {
				//tutaj mozna dodac wiecej akcji  np whipser dla wychowawcy do poszczegiolny rodzicow

				case ChatMessage.Action.MESSAGE:
					broadcast(username + ": " + message);
					break;
				case ChatMessage.Action.LOGOUT:
					display(username + " wylogowa³ siê.");
					writeMsg("Zosta³eœ wylogowany\n");	
					keepGoing = false;
					break;
				case ChatMessage.Action.WHOISIN:
					writeMsg("Lista obecnych  " + sdf.format(new Date()) + "\n");					
					for(int i = 0; i < al.size(); ++i) {
						ClientThread ct = al.get(i);
						writeMsg((i+1) + ") " + ct.username);
					}
					break;
				case ChatMessage.Action.KICK:
					break;
				case ChatMessage.Action.LOGIN:
					break;
				}
			}
			// remove myself from the arrayList containing the list of the
			// connected Clients
			remove(id);
			close();
		}
		
		// try to close everything
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
			// if Client is still connected send the message to it
			if(!socket.isConnected()) {
				close();
				return false;
			}
			// write the message to the stream
			try {
				output.writeObject(msg);
			}
			// if an error occurs, do not abort just inform the user
			catch(IOException e) {
				display("Error sending message to " + username);
				display(e.toString());
			}
			return true;
		}
	}
}


