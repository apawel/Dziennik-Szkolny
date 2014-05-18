package chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import model.Teacher;
import javax.swing.JScrollPane;

public class Client_GUI_Teacher extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean connected;
	private Client client;
	private int defaultPort;
	private String defaultHost;
	private JTextArea textArea;
	
	private JButton btnPocz;
	private JButton btnKtoJestDostpny;
	private JButton btnWyloguj;
	
	private JPanel contentPane;
	private JTextField txt_adres_serwara;
	private JTextField txt_port;
	private JTextField txt_messages;
private Teacher wychowawca;
private JButton btnWyliPliktekst;
private JScrollPane scrollPane;
	public static void main(String[] args) {
		new Client_GUI();
	}
	public Client_GUI_Teacher(Teacher teacher) {
		super("Okno wychowawcy - wirtualne zebranie");
		wychowawca=teacher;
		defaultPort = 3050;
		defaultHost = "localhost";
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(0.25);
		splitPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JPanel gora_ = new JPanel();
		gora_.setAlignmentX(2.0f);
		gora_.setBorder(new CompoundBorder());
		splitPane.setLeftComponent(gora_);
		FlowLayout fl_gora_ = new FlowLayout(FlowLayout.CENTER, 5, 5);
		fl_gora_.setAlignOnBaseline(true);
		gora_.setLayout(fl_gora_);
		
		JLabel lblnazwa_serwera = new JLabel("Adres serwera: ");
		gora_.add(lblnazwa_serwera);
		
		txt_adres_serwara = new JTextField();
		gora_.add(txt_adres_serwara);
		txt_adres_serwara.setColumns(10);
		
		JLabel lblPort = new JLabel("Port: ");
		gora_.add(lblPort);
		
		txt_port = new JTextField();
		gora_.add(txt_port);
		txt_port.setColumns(10);
		
		btnPocz = new JButton("Po\u0142\u0105cz");
		gora_.add(btnPocz);
		btnPocz.addActionListener(this);
		
		btnWyloguj = new JButton("Wyloguj");
		gora_.add(btnWyloguj);
		btnWyloguj.addActionListener(this);
		btnWyloguj.setEnabled(false);
		
		btnKtoJestDostpny = new JButton("Kto jest dost\u0119pny");
		gora_.add(btnKtoJestDostpny);
		btnKtoJestDostpny.addActionListener(this);
		btnKtoJestDostpny.setEnabled(false);
		
		btnWyliPliktekst = new JButton("Wy\u015Bli plik(tekst)");
		btnWyliPliktekst.addActionListener(this);
			
		btnWyliPliktekst.setEnabled(false);
		gora_.add(btnWyliPliktekst);
		
		JPanel dol_ = new JPanel();
		splitPane.setRightComponent(dol_);
		dol_.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setTabSize(5);
		
		txt_messages = new JTextField();
		dol_.add(txt_messages, BorderLayout.SOUTH);
		
		txt_messages.setText("Tu wpisz swoj¹ wiadomoœæ");
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		dol_.add(scrollPane, BorderLayout.CENTER);
		
		
		
	//	dol_.add(textArea);
		txt_messages.requestFocus();
	}
	void connectionFailed() {
		btnPocz.setEnabled(true);
		btnPocz.setEnabled(false);
		btnKtoJestDostpny.setEnabled(false);
		btnWyliPliktekst.setEnabled(false);
	
		
		txt_port.setText("" + defaultPort);
		txt_adres_serwara.setText(defaultHost);
		
		txt_adres_serwara.setEditable(false);
		txt_port.setEditable(false);
		
		txt_messages.removeActionListener(this);
		connected = false;
	}
	
	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
	
		if(o == btnWyloguj) {
			client.sendMessage(new ChatMessage(ChatMessage.Action.LOGOUT, ""));
			return;
		}

		if(o == btnKtoJestDostpny) {
			client.sendMessage(new ChatMessage(ChatMessage.Action.WHOISIN, ""));				
			return;
		}
		if(o == btnWyliPliktekst)
		{
			FileDialog fd;
			String plik, msg;
			Scanner odczyt;
			Frame a=null;
			fd = new FileDialog(this, "Wczytaj", FileDialog.LOAD);
			fd.setVisible(true);
			plik = fd.getFile();
			msg="";
			try {
				odczyt = new Scanner(new File(plik));
				while (odczyt.hasNext()) {
					msg+=odczyt.nextLine()+"\n";
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			client.sendMessage(new ChatMessage(ChatMessage.Action.MESSAGE,"--Wychowawca-- \n" + msg));				
			txt_messages.setText("");
			return;
		}

		
		if(connected) {
			
			client.sendMessage(new ChatMessage(ChatMessage.Action.MESSAGE,"--Wychowawca-- " + txt_messages.getText()));				
			txt_messages.setText("");
			return;
		}
		

		if(o == btnPocz) {
		
			String server = txt_adres_serwara.getText().trim();
			if(server.length() == 0)
				return;
			
			String portNumber = txt_port.getText().trim();
			if(portNumber.length() == 0)
				return;
			int port = 0;
			try {
				port = Integer.parseInt(portNumber);
			}
			catch(Exception en) {
				return; 
			}

			
			
			client = new Client(server, port, wychowawca.getFirstName() + " " + wychowawca.getLastName(), this);
		
			if(!client.start()) 
				return;
			txt_messages.setText("");			
			connected = true;
			
			btnPocz.setEnabled(false);	
			btnWyloguj.setEnabled(true);
			btnKtoJestDostpny.setEnabled(true);
			btnWyliPliktekst.setEnabled(true);			
			txt_adres_serwara.setEditable(false);
			txt_port.setEditable(false);			
			txt_messages.addActionListener(this);
			
		}
	}
	void append(String str) {
		textArea.append(str);
		textArea.setCaretPosition(textArea.getText().length() - 1);
	}
	
	

}
