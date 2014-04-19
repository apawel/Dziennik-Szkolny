package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGUI extends JFrame {

	private Container contentPane;
	private CardLayout layout;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminGUI() {
		super("Panel Admina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 300);
		setVisible(true);
		
		layout = new CardLayout();
		getContentPane().setLayout(layout);
		contentPane = this.getContentPane();
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDodaj = new JMenu("Dodaj");
		menuBar.add(mnDodaj);
		
		JMenuItem mntmPrzedmiot = new JMenuItem("Przedmiot");
		mntmPrzedmiot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane, "Przedmiot");
			}
		});
		mnDodaj.add(mntmPrzedmiot);
		
		JMenuItem mntmNauczyciel = new JMenuItem("Nauczyciel");
		mntmNauczyciel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane,"Nauczyciel");
			}
		});
		mnDodaj.add(mntmNauczyciel);
		
		JMenuItem mntmUcze = new JMenuItem("Ucze\u0144");
		mntmUcze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane,"Uczeñ");
			}
		});
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
		
		contentPane.add("Empty",new JPanel());
		
		JPanel addSubject = new addSubject_GUI();
		contentPane.add("Przedmiot",addSubject);
		
		JPanel addTeacher = new addTeacher_GUI();
	    contentPane.add("Nauczyciel",addTeacher);
		
		JPanel addStudent = new addStudent_GUI();
		contentPane.add("Ucze\u0144",addStudent);
		
		
		
	}
}
