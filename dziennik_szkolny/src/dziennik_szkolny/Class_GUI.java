package dziennik_szkolny;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Class_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Class_GUI(String nazwa) {
		super(nazwa);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 24, 397, 197);
		contentPane.add(table);
		
		JLabel lblKlasa = new JLabel("Klasa:");
		lblKlasa.setBounds(10, 11, 46, 14);
		contentPane.add(lblKlasa);
		
		JLabel lblNazwaklasy = new JLabel("nazwa_klasy");
		lblNazwaklasy.setEnabled(false);
		lblNazwaklasy.setBounds(81, 11, 69, 14);
		contentPane.add(lblNazwaklasy);
		/*warunek jeœli zalogowany jako wychowawca to przenies do Student_GUI a jesli jako nauczyciel to do Student_Subject_GUI*/
		JButton btnWybierzUcznia = new JButton("Wybierz ucznia");
		btnWybierzUcznia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(nauczyciel)
				Student_Subject_GUI uczen_przedmiot = new Student_Subject_GUI("nazwa ucznia + nazwa przedmiotu");
				//else if(wychowca)
				Student_GUI student = new Student_GUI("nazwa Studenta");
			}
		});
		btnWybierzUcznia.setBounds(252, 227, 155, 23);
		contentPane.add(btnWybierzUcznia);
		
		JButton btnWr = new JButton("Wr\u00F3\u0107");
		btnWr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnWr.setBounds(20, 227, 130, 23);
		contentPane.add(btnWr);
	}
}
