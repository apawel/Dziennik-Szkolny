package dziennik_szkolny;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class login_gui {

	private JFrame frame;
	private JTextField txt_pesel;
	private JTextField txt_haslo;

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
		
		txt_haslo = new JTextField();
		txt_haslo.setColumns(10);
		txt_haslo.setBounds(69, 79, 154, 20);
		frame.getContentPane().add(txt_haslo);
		
		JLabel lblHaso = new JLabel("Has\u0142o");
		lblHaso.setBounds(10, 78, 69, 17);
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
		
		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.setBounds(156, 110, 108, 29);
		frame.getContentPane().add(btnZaloguj);
	}
}
