package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class addTeacher_GUI extends JPanel {
	private JTextField imie_txt;
	private JTextField nazwisko_txt;
	private JTextField pesel_txt;
	private JTextField textField;
	private JTextField textField_1;

	
	public addTeacher_GUI() {
		setLayout(null);
		
		JLabel lblImi = new JLabel("Imi\u0119:");
		lblImi.setBounds(10, 11, 46, 14);
		add(lblImi);
		
		imie_txt = new JTextField();
		imie_txt.setBounds(91, 8, 86, 20);
		add(imie_txt);
		imie_txt.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 36, 79, 14);
		add(lblNazwisko);
		
		nazwisko_txt = new JTextField();
		nazwisko_txt.setColumns(10);
		nazwisko_txt.setBounds(91, 33, 86, 20);
		add(nazwisko_txt);
		
		JLabel lblPesel = new JLabel("Pesel:");
		lblPesel.setBounds(10, 61, 46, 14);
		add(lblPesel);
		
		pesel_txt = new JTextField();
		pesel_txt.setColumns(10);
		pesel_txt.setBounds(91, 58, 86, 20);
		add(pesel_txt);
		
		JLabel lblHaso = new JLabel("Has\u0142o:");
		lblHaso.setBounds(10, 86, 46, 14);
		add(lblHaso);
		
		textField = new JTextField();
		textField.setBounds(91, 83, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(10, 111, 46, 14);
		add(lblAdres);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 108, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrzedmiot = new JLabel("Przedmiot:");
		lblPrzedmiot.setBounds(10, 137, 79, 14);
		add(lblPrzedmiot);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 134, 86, 20);
		add(comboBox);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(248, 82, 89, 23);
		add(btnDodaj);

	}
}
