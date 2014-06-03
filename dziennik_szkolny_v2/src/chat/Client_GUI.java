package chat;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import model.Student;
import controller.ManageStudent;


/**
 * TO DO 
 * 3. cos w wylogowaniem poszukac 
 * @author Pawel
 *
 */

public class Client_GUI extends JFrame implements ActionListener  {

	
	class LoginStudent extends SwingWorker<Student, Void>
	{

		@Override
		protected Student doInBackground() throws Exception {
			try{
				Student student = loginStudent();
			return student;
			}
			catch(NumberFormatException ex)
	    	{
				throw new NumberFormatException();		
			
	    	}	
		}
		protected void done()
		{
			try{
			Student student = new Student(get());
		} catch (InterruptedException | ExecutionException e) {					
			pesel_blad_znak.setVisible(true);					
		}
		}
	}
	public boolean isCorrect(char [] passDB,char[] passtxt)
	{ 	
		
		if(passDB.length != passtxt.length)
			return false;
		for(int i =0 ;i<passDB.length;i++)
		{
			if(passDB[i] != passtxt[i])
				return false;
		}
		return true;
	
	}
	public Student loginStudent() throws Exception
	{	
			
		
		Student student = null;			
boolean correct = false;
		
		if(txt_pesel.getText().length() != 11)
				throw new NumberFormatException();

	    	ManageStudent MS = new ManageStudent();
	    	student = MS.getStudentbyPIN(txt_pesel.getText());
	    	char[] password = passwordField.getPassword();						    	
	    	
	    	if(isCorrect(student.getPassword().toCharArray(),password))
		    			correct=true;//przypisanie nauczyciela
	    	else
	    				throw new NumberFormatException();	
	    	
	
	    	

			return student;	
		
			
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginStudent loginStudent;
	private boolean connected;
	private Client client;
	private int defaultPort;
	private String defaultHost;
	private JTextArea textArea;
	final JLabel pesel_blad_znak = new JLabel("B\u0142\u0119dny pesel lub/i has\u0142o");
	private JButton btnPocz;
	private JButton btnKtoJestDostpny;
	private JButton btnWyloguj;
	
	private JPanel contentPane;
	private JTextField txt_adres_serwara;
	private JTextField txt_port;
	private JTextField txt_pesel;
	private JPasswordField passwordField;
	private JTextField txt_messages;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		new Client_GUI();
	}
	public Client_GUI() {
		super("Klient - wirtualne zebranie");
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
		splitPane.setResizeWeight(0.28);
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
		
		JLabel lblPeselDziecka = new JLabel("Pesel dziecka: ");
		gora_.add(lblPeselDziecka);
		
		txt_pesel = new JTextField();
		gora_.add(txt_pesel);
		txt_pesel.setColumns(10);
		
		JLabel lblHaso = new JLabel("Has\u0142o: ");
		gora_.add(lblHaso);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setEchoChar('*');
		gora_.add(passwordField);
		pesel_blad_znak.setEnabled(false);
		pesel_blad_znak.setVisible(false);
		pesel_blad_znak.setBounds(44, 23, 179, 14);
		gora_.add(pesel_blad_znak); 
		
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
		
		JPanel dol_ = new JPanel();
		splitPane.setRightComponent(dol_);
		dol_.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setTabSize(5);
	//	dol_.add(textArea);
		
		txt_messages = new JTextField();
		dol_.add(txt_messages, BorderLayout.SOUTH);
		
		txt_messages.setText("Tu wpisz swoj¹ wiadomoœæ");
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setViewportView(textArea);
		dol_.add(scrollPane, BorderLayout.CENTER);		
	
		txt_messages.requestFocus();
	}
	void connectionFailed() {
		btnPocz.setEnabled(true);
		btnWyloguj.setEnabled(false);
		btnKtoJestDostpny.setEnabled(false);
	

		txt_port.setText("" + defaultPort);
		txt_adres_serwara.setText(defaultHost);

		txt_adres_serwara.setEditable(false);
		txt_port.setEditable(false);
	
		txt_messages.removeActionListener(this);
		connected = false;
	}
	
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

		
		if(connected) {
			
			client.sendMessage(new ChatMessage(ChatMessage.Action.MESSAGE, txt_messages.getText()));				
			txt_messages.setText("");
			return;
		}
		

		if(o == btnPocz) {
			
			String pesel = txt_pesel.getText().trim();		
			if(pesel.length() == 0)
				return;
			
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

			
			

			pesel_blad_znak.setVisible(false);				    	
    		loginStudent = new LoginStudent();
    		this.loginStudent.execute();
    		
    String username = "Nie POBRALO";
	try {
		username = loginStudent.get().getFirstName() + " " + loginStudent.get().getLastName();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ExecutionException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
			client = new Client(server, port, username, this);			
			if(!client.start()) 
				return;
			txt_messages.setText("");			
			connected = true;			
			btnPocz.setEnabled(false);			
			btnWyloguj.setEnabled(true);
			btnKtoJestDostpny.setEnabled(true);			
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
