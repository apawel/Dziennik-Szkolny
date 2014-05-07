package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class Client  {


	private ObjectInputStream input;		// to read from the socket
	private ObjectOutputStream output;		// to write on the socket
	private Socket socket;	
	private Client_GUI cg;	
	private Client_GUI_Teacher cgt;
	private String server, username;
	private int port;
	
	
	Client(String server, int port, String username, Client_GUI_Teacher cgt) {
		this.server = server;
		this.port = port;
		this.username = username;		
		this.cgt = cgt;
		this.cg=null;
	}

	Client(String server, int port, String username, Client_GUI cg) {
		this.server = server;
		this.port = port;
		this.username = username;		
		this.cg = cg;
		this.cgt=null;
	}
	
	
	public boolean start() {
		// try to connect to the server
		try {
			socket = new Socket(server, port);
		} 
		
		catch(Exception ec) {
			display("Bl¹d podczas ³aczenia z serwerem:" + ec);
			return false;
		}
		
		String msg = "Po³¹czono " + socket.getInetAddress() + ":" + socket.getPort();//popatrzyc
		display(msg);
	
		
		try
		{
			input  = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO) {
			display("Exception creating new Input/output Streams: " + eIO);
			return false;
		}

		// creates the Thread to listen from the server 
		new ListenFromServer().start();
		
		try
		{
			output.writeObject(username);
		}
		catch (IOException eIO) {
			display("Exception doing login : " + eIO);
			disconnect();
			return false;
		}	
		return true;
	}

	/*
	 * To send a message to the console or the GUI
	 */
	private void display(String msg) {		
		if(cgt==null)
			cg.append(msg + "\n");		// append to the ClientGUI JTextArea (or whatever)
		else if(cg==null)
			cgt.append(msg + "\n");
	}
	
	/*
	 * To send a message to the server
	 */
	void sendMessage(ChatMessage msg) {
		try {
			output.writeObject(msg);
		}
		catch(IOException e) {
			display("Exception writing to server: " + e);
		}
	}

	
	private void disconnect() {
		try { 
			if(input != null) 
				input.close();
		}
		catch(Exception e) {} // not much else I can do
		try {
			if(output != null) 
				output.close();
		}
		catch(Exception e) {} // not much else I can do
        try{
			if(socket != null)
				socket.close();
		}
		catch(Exception e) {} // not much else I can do
		
		// inform the GUI
		if(cg != null)
			cg.connectionFailed();
		if(cgt != null)
			cgt.connectionFailed();
			
	}

	/*
	 * a class that waits for the message from the server and append them to the JTextArea
	 * if we have a GUI or simply System.out.println() it in console mode
	 */
	class ListenFromServer extends Thread {

		public void run() {
			while(true) {
				try {
					String msg = (String) input.readObject();	
					if(cgt==null)
						cg.append(msg + "\n");		// append to the ClientGUI JTextArea (or whatever)
					else if(cg==null)
						cgt.append(msg + "\n");
						
					
				}
				catch(IOException e) {
					//display("Server has close the connection: " + e);
					if(cg != null) 
						cg.connectionFailed();
					if(cgt != null)
						cgt.connectionFailed();
						
					break;
				}
				// can't happen with a String object but need the catch anyhow
				catch(ClassNotFoundException e2) {
				}
			}
		}
	}
}

 