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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnAnuluj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
				
			}
		});
		btnAnuluj.setBounds(22, 109, 89, 23);
		contentPane.add(btnAnuluj);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(88, 22, 46, 20);
		contentPane.add(comboBox);
		comboBox.addItem(1.0);
		comboBox.addItem(2.0);
		comboBox.addItem(2.5);
		comboBox.addItem(3.0);
		comboBox.addItem(3.5);
		comboBox.addItem(4.0);
		comboBox.addItem(4.5);
		comboBox.addItem(5.0);
		comboBox.addItem(5.5);
		comboBox.addItem(6.0);
		
		JLabel lblOcena = new JLabel("Ocena");
		lblOcena.setBounds(22, 25, 46, 14);
		contentPane.add(lblOcena);
		
		JLabel lblWaga = new JLabel("Waga");
		lblWaga.setBounds(22, 56, 46, 14);
		contentPane.add(lblWaga);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(88, 53, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblKomentarz = new JLabel("Komentarz");
		lblKomentarz.setBounds(22, 81, 72, 14);
		contentPane.add(lblKomentarz);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 78, 137, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
