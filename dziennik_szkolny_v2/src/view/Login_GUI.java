package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import org.omg.CORBA.ExceptionList;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.ComboPopup;


public class Login_GUI {

	private JFrame frame;
	private JTextField txt_pesel;
	private JPasswordField passwordField;
	
	private enum Wybor {    Uczen, Nauczyciel, Wychowawca;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Login_GUI window = new Login_GUI();
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
	public Login_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 290, 226);
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
		btnZamknij.setBounds(20, 147, 108, 29);
		frame.getContentPane().add(btnZamknij);
		
		final JLabel pesel_blad_znak = new JLabel("B\u0142\u0119dny pesel");
		pesel_blad_znak.setEnabled(false);
		pesel_blad_znak.setVisible(false);
		pesel_blad_znak.setBounds(79, 23, 108, 14);
		frame.getContentPane().add(pesel_blad_znak);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(69, 107, 154, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Uczen");
		comboBox.addItem("Nauczyciel");
		comboBox.addItem("Wychowawca");
		

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
				

			String wybrane = (String)comboBox.getSelectedItem();	
           Wybor fruit = Wybor.valueOf(wybrane);

					switch(fruit) {
					    case Uczen:
					    	System.out.println("jestem w uczniu otwieram moje okno z ocenami");
					    	Student_GUI student = new Student_GUI("nazwa studenta");
					        
					        break;
					    case Nauczyciel:
					    	Teacher_GUI teacher = new Teacher_GUI("nazwa nauczyciela");
					    	System.out.println("jestem w nauczycielu , otwieram jego przedmiot i powiazane klasy");					       
					        break;
					    case Wychowawca:
					    	Class_GUI klasa = new Class_GUI("nazwa klasy tego wychowawcy");
					    	System.out.println("jestem w wychowawcy. otwieram jego klase");
					    	break;
					}
			
				/**Obsluga wpisania poprawnego numeru pesel tj 11 cyfr**/
					try{
						pesel_blad_znak.setVisible(false);
						long pesel = Long.parseLong(txt_pesel.getText());
						if(txt_pesel.getText().length() != 11)
							throw new NumberFormatException();
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
		btnZaloguj.setBounds(156, 147, 108, 29);
		frame.getContentPane().add(btnZaloguj);
		

	
		
		
	}
}