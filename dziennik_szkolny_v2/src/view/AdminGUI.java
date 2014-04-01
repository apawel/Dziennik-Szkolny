package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class AdminGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDodaj = new JMenu("Dodaj");
		menuBar.add(mnDodaj);
		
		JMenuItem mntmPrzedmiot = new JMenuItem("Przedmiot");
		mnDodaj.add(mntmPrzedmiot);
		
		JMenuItem mntmNauczyciel = new JMenuItem("Nauczyciel");
		mnDodaj.add(mntmNauczyciel);
		
		JMenuItem mntmUcze = new JMenuItem("Ucze\u0144");
		mnDodaj.add(mntmUcze);
		
		JMenuItem mntmKlasa = new JMenuItem("Klasa");
		mnDodaj.add(mntmKlasa);
		
		JMenu mnEdytuj = new JMenu("Edytuj");
		menuBar.add(mnEdytuj);
		
		JMenuItem mntmPrzedmiot_1 = new JMenuItem("Przedmiot");
		mnEdytuj.add(mntmPrzedmiot_1);
		
		JMenuItem mntmNauczyciel_1 = new JMenuItem("Nauczyciel");
		mnEdytuj.add(mntmNauczyciel_1);
		
		JMenuItem mntmUcze_1 = new JMenuItem("Ucze\u0144");
		mnEdytuj.add(mntmUcze_1);
		
		JMenuItem mntmKlasa_1 = new JMenuItem("Klasa");
		mnEdytuj.add(mntmKlasa_1);
		
		JMenu mnUsu = new JMenu("Usu\u0144");
		menuBar.add(mnUsu);
		
		JMenuItem mntmPrzedmiot_2 = new JMenuItem("Przedmiot");
		mnUsu.add(mntmPrzedmiot_2);
		
		JMenuItem mntmNauczyciel_2 = new JMenuItem("Nauczyciel");
		mnUsu.add(mntmNauczyciel_2);
		
		JMenuItem mntmUcze_2 = new JMenuItem("Ucze\u0144");
		mnUsu.add(mntmUcze_2);
		
		JMenuItem mntmKlasa_2 = new JMenuItem("Klasa");
		mnUsu.add(mntmKlasa_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
