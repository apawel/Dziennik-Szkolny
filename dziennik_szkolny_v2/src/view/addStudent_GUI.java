package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.SchoolClass;
import controller.ManageSchoolClass;
import controller.ManageStudent;


public class addStudent_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField imie_txt;
	private JTextField nazwisko_txt;
	private JTextField pesel_txt;
	private JTextField haslo_txt;
	private JTextField adres_txt;
	
	

//	private JDatePicker data;

	/**
	 * Create the panelS.
	 */
	public addStudent_GUI() {
		setLayout(null);
		JLabel lblImi = new JLabel("Imi\u0119:");
		lblImi.setBounds(10, 11, 46, 14);
		add(lblImi);
		
		imie_txt = new JTextField();
		imie_txt.setBounds(114, 8, 109, 20);
		add(imie_txt);
		imie_txt.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 36, 79, 14);
		add(lblNazwisko);
		
		nazwisko_txt = new JTextField();
		nazwisko_txt.setColumns(10);
		nazwisko_txt.setBounds(114, 33, 109, 20);
		add(nazwisko_txt);
		
		JLabel lblPesel = new JLabel("Pesel:");
		lblPesel.setBounds(10, 61, 46, 14);
		add(lblPesel);
		
		pesel_txt = new JTextField();
		pesel_txt.setColumns(10);
		pesel_txt.setBounds(114, 58, 109, 20);
		add(pesel_txt);
		
		JLabel lblHaso = new JLabel("Has\u0142o:");
		lblHaso.setBounds(10, 86, 46, 14);
		add(lblHaso);
		
		haslo_txt = new JTextField();
		haslo_txt.setBounds(114, 83, 109, 20);
		add(haslo_txt);
		haslo_txt.setColumns(10);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(10, 111, 46, 14);
		add(lblAdres);
		
		adres_txt = new JTextField();
		adres_txt.setBounds(114, 108, 109, 20);
		add(adres_txt);
		adres_txt.setColumns(10);
		
		JLabel lblData = new JLabel("Data urodzenia:");
		lblData.setBounds(10, 133, 109, 14);
		add(lblData);
		
		final JComboBox<Integer> comboBoxDzien = new JComboBox<Integer>();
		comboBoxDzien.setBounds(114, 130, 46, 20);
		add(comboBoxDzien);
		for(int i =1; i<32;i++)
		{
			comboBoxDzien.addItem(i);
		}
		
		final JComboBox<Integer> comboBoxMiesiac = new JComboBox<Integer>();
		comboBoxMiesiac.setBounds(170, 130, 46, 20);
		add(comboBoxMiesiac);
		for(int i = 1;i<13;i++)
			comboBoxMiesiac.addItem(i);
		
		final JComboBox<Integer> comboBoxRok = new JComboBox<Integer>();
		comboBoxRok.setBounds(226, 130, 53, 20);
		add(comboBoxRok);
		for(int i =1970;i<2020;i++)
		{
			comboBoxRok.addItem(i);
		}
		JLabel lblKlasa = new JLabel("Klasa:");
		lblKlasa.setBounds(10, 154, 100, 14);
		add(lblKlasa);
		
		final ArrayList<SchoolClass> klasy =  ManageSchoolClass.getAllSchoolClasses();
				
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(114, 154, 68, 20);
		add(comboBox);
		for(int i =0;i<klasy.size();i++)
		{
			comboBox.addItem(klasy.get(i).getName());
		}
		
		
		
		JLabel label = new JLabel("-");
		label.setBounds(163, 133, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(219, 133, 46, 14);
		add(label_1);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				int wybrana_klasa = comboBox.getSelectedIndex();				
				ManageStudent.addStudent(klasy.get(wybrana_klasa), imie_txt.getText(), nazwisko_txt.getText(), pesel_txt.getText(), haslo_txt.getText(), new Date((int)comboBoxDzien.getSelectedItem(),(int)comboBoxMiesiac.getSelectedItem(),(int)comboBoxRok.getSelectedItem()), adres_txt.getText());
			}
		});
		btnDodaj.setBounds(114, 199, 89, 23);
		add(btnDodaj);
		


	}
}
