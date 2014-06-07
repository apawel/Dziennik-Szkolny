package view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class AdminGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		mntmKlasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane,"Klasa");
			}
		});
		mnDodaj.add(mntmKlasa);
		
		JMenu mnEdytuj = new JMenu("Edytuj");
		menuBar.add(mnEdytuj);
		
		JMenuItem mntmPrzedmiot_1 = new JMenuItem("Przedmiot");
		mnEdytuj.add(mntmPrzedmiot_1);
		mntmPrzedmiot_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane,"PrzedmiotEdit");
			}
		});
		
		JMenuItem mntmNauczyciel_1 = new JMenuItem("Nauczyciel");
		mnEdytuj.add(mntmNauczyciel_1);
		mntmNauczyciel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane,"NauczycielEdit");
			}
		});
		
		
		JMenuItem mntmUcze_1 = new JMenuItem("Ucze\u0144");
		mnEdytuj.add(mntmUcze_1);
		mntmUcze_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane,"UczenEdit");
			}
		});
		
		JMenuItem mntmKlasa_1 = new JMenuItem("Klasa");
		mnEdytuj.add(mntmKlasa_1);
		mntmKlasa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layout.show(contentPane,"KlasaEdit");
			}
		});
		
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
		
		JPanel addSchoolClass = new AddSchoolClass_GUI();
		contentPane.add("Klasa",addSchoolClass);
		
		JPanel editSubject = new EditSubject_GUI();
		contentPane.add("PrzedmiotEdit",editSubject);
		
		JPanel editTeacher = new EditTeacher_GUI();
		contentPane.add("NauczycielEdit",editTeacher);
		
		JPanel editStudent = new EditStudent_GUI();
		contentPane.add("UczenEdit",editStudent);
		
		JPanel editSchoolClass = new EditSchoolClass_GUI();
		contentPane.add("KlasaEdit",editSchoolClass);
		
		
		
	}
}
