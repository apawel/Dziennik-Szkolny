package dziennik_szkolny;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import org.omg.CORBA.ExceptionList;


public class login_gui {

	private JFrame frame;
	private JTextField txt_pesel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_gui window = new login_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 192);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_pesel = new JTextField();
		txt_pesel.setBounds(69, 48, 154, 20);
		frame.getContentPane().add(txt_pesel);
		txt_pesel.setColumns(10);
		
		JLabel lblPesel = new JLabel("Pesel");
		lblPesel.setBounds(10, 50, 69, 17);
		frame.getContentPane().add(lblPesel);
		
		JLabel lblHaso = new JLabel("Has\u0142o");
		lblHaso.setBounds(10, 78, 45, 17);
		frame.getContentPane().add(lblHaso);
		/**Zaymaknie Okienka Logowania**/
		JButton btnZamknij = new JButton("Zamknij");
		btnZamknij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			}
		});
		btnZamknij.setBounds(20, 110, 108, 29);
		frame.getContentPane().add(btnZamknij);
		
		final JLabel pesel_blad_znak = new JLabel("B\u0142\u0119dny pesel");
		pesel_blad_znak.setEnabled(false);
		pesel_blad_znak.setVisible(false);
		pesel_blad_znak.setBounds(79, 23, 108, 14);
		frame.getContentPane().add(pesel_blad_znak);
		

		passwordField = new JPasswordField();
		passwordField.setBounds(69, 76, 154, 20);
		frame.getContentPane().add(passwordField);
		
		final JLabel lblPassword = new JLabel("B\u0142\u0119dne\r\n has\u0142o");
		lblPassword.setEnabled(false);
		lblPassword.setBounds(178, 23, 86, 14);
		frame.getContentPane().add(lblPassword);
		lblPassword.setVisible(false);
		
		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				/**Obsluga wpisania poprawnego numeru pesel tj 11 cyfr**/
					try{
						pesel_blad_znak.setVisible(false);
						long pesel = Long.parseLong(txt_pesel.getText());
						if(txt_pesel.getText().length() != 11)
							throw new NumberFormatException();
						System.out.println(pesel);
					}
					catch(NumberFormatException ex)
					{
						pesel_blad_znak.setVisible(true);
						
					}			
					char[] password = passwordField.getPassword();
					try{
						//isPasswordCorret(password); metoda sprawdza poprawnosc hasla
					}
					catch(Exception ex)
					{
						lblPassword.setVisible(true);
					}
					
				
					
			
			}
		});
		btnZaloguj.setBounds(156, 110, 108, 29);
		frame.getContentPane().add(btnZaloguj);
		
	
		
		
	}
}
