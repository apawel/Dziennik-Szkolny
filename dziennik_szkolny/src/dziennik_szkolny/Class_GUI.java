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

public class Class_GUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class_GUI frame = new Class_GUI();
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
	public Class_GUI() {
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
		btnWybierzUcznia.setBounds(252, 227, 155, 23);
		contentPane.add(btnWybierzUcznia);
		
		JButton btnWr = new JButton("Wr\u00F3\u0107");
		btnWr.setBounds(20, 227, 130, 23);
		contentPane.add(btnWr);
	}
}
