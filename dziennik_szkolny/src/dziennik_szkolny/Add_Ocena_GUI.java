package dziennik_szkolny;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_Ocena_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Ocena_GUI frame = new Add_Ocena_GUI();
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
	public Add_Ocena_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(134, 109, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setBounds(22, 109, 89, 23);
		contentPane.add(btnAnuluj);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 22, 46, 20);
		contentPane.add(comboBox);
		
		JLabel lblOcena = new JLabel("Ocena");
		lblOcena.setBounds(22, 25, 46, 14);
		contentPane.add(lblOcena);
		
		JLabel lblWaga = new JLabel("Waga");
		lblWaga.setBounds(22, 56, 46, 14);
		contentPane.add(lblWaga);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(78, 53, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKomentarz = new JLabel("Komentarz");
		lblKomentarz.setBounds(22, 81, 60, 14);
		contentPane.add(lblKomentarz);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 78, 137, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
