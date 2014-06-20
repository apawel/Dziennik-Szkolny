package chat;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.PushNotification;

public class Server_GUI extends JFrame implements ActionListener, WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_port;
	private Server server;
	JTextArea txtrEventy;
	private JButton btnRozpocznijZebranie;
	private JScrollPane scrollPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_GUI frame = new Server_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	void appendEvent(String str) {
		txtrEventy.append(str);
		
	}
	public Server_GUI() {
		super("Serwer - wirtualne zebrania");
		server = null;
		
		
		setBounds(700, 100, 389, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		JLabel lblPort = new JLabel("Port:");
		panel.add(lblPort);
		lblPort.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPort.setAlignmentY(Component.TOP_ALIGNMENT);
		
		txt_port = new JTextField();
		panel.add(txt_port);
		txt_port.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txt_port.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		txt_port.setColumns(10);
		
		btnRozpocznijZebranie = new JButton(" Rozpocznij zebranie");
		panel.add(btnRozpocznijZebranie);
	
		btnRozpocznijZebranie.addActionListener(this);
		
		
		
		txtrEventy = new JTextArea();
		//contentPane.add(txtrEventy, BorderLayout.SOUTH);
		txtrEventy.setEditable(false);
		addWindowListener(this);
		
		scrollPane = new JScrollPane(txtrEventy);
		splitPane.setRightComponent(scrollPane);

		
		
	}
	
	public void windowClosing(WindowEvent e) {
		// gdy server istnieje
		if(server != null) {
			try {
				server.stop();			
			}
			catch(Exception eClose) {
			}
			server = null;
		}
		
		dispose();
		
	}
	public void actionPerformed(ActionEvent arg0) {
	

		if(server != null) {
			server.stop();
			server = null;
			txt_port.setEditable(true);
			btnRozpocznijZebranie.setText("Rozpocznij zebranie");
			return;
		}
      
		int port;
		try {
			port = Integer.parseInt(txt_port.getText().trim());
		}
		catch(Exception er) {
			appendEvent("Nieprawid³owy port.\n");
			return;
		}
		
		server = new Server(port, this);

		new ServerRunning().start();
		btnRozpocznijZebranie.setText("Zakoñcz zebranie");
		txt_port.setEditable(false);
		
	    String[] channels = new String[]{"Zebrania"};
	    String type = "android";
	    Map<String, String> data = new HashMap<String, String>();
	    data.put("alert", "Zebranie serwer: localhost port:"+ port);

	    try {
	        new PushNotification().sendPost(channels, type, data);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	class ServerRunning extends Thread {
		public void run() {
			server.start();      

			btnRozpocznijZebranie.setText("Start");
			txt_port.setEditable(true);
			appendEvent("Serwer zostal zamkniêty\n");
			server = null;
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
			
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	
	}

}
