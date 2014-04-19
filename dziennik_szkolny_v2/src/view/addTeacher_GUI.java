package view;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import model.Subject;
import controller.ManageSubject;
import controller.ManageTeacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addTeacher_GUI extends JPanel {
	private JTextField imie_txt;
	private JTextField nazwisko_txt;
	private JTextField pesel_txt;
	private JTextField haslo_txt;
	private JTextField adres_txt;

	
	public addTeacher_GUI() {
		setLayout(null);
		final ManageSubject MS = null;// = new ManageSubject();
		
		
		
		JLabel lblImi = new JLabel("Imi\u0119:");
		lblImi.setBounds(10, 11, 46, 14);
		add(lblImi);
		
		imie_txt = new JTextField();
		imie_txt.setBounds(91, 8, 109, 20);
		add(imie_txt);
		imie_txt.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 36, 79, 14);
		add(lblNazwisko);
		
		nazwisko_txt = new JTextField();
		nazwisko_txt.setColumns(10);
		nazwisko_txt.setBounds(91, 33, 109, 20);
		add(nazwisko_txt);
		
		JLabel lblPesel = new JLabel("Pesel:");
		lblPesel.setBounds(10, 61, 46, 14);
		add(lblPesel);
		
		pesel_txt = new JTextField();
		pesel_txt.setColumns(10);
		pesel_txt.setBounds(91, 58, 109, 20);
		add(pesel_txt);
		
		JLabel lblHaso = new JLabel("Has\u0142o:");
		lblHaso.setBounds(10, 86, 46, 14);
		add(lblHaso);
		
		haslo_txt = new JTextField();
		haslo_txt.setBounds(91, 83, 109, 20);
		add(haslo_txt);
		haslo_txt.setColumns(10);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(10, 111, 46, 14);
		add(lblAdres);
		
		adres_txt = new JTextField();
		adres_txt.setBounds(91, 108, 109, 20);
		add(adres_txt);
		adres_txt.setColumns(10);
		
		JLabel lblPrzedmiot = new JLabel("Przedmiot:");
		lblPrzedmiot.setBounds(10, 137, 79, 14);
		add(lblPrzedmiot);
		
		final ArrayList<Subject> przedmioty =  MS.getAllSubjects();
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 134, 109, 20);
		add(comboBox);
		for(int i =0;i<przedmioty.size();i++)
		comboBox.addItem(przedmioty.get(i).getName());
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageTeacher MT = new ManageTeacher();				
				int wybranyprzedmiot = comboBox.getSelectedIndex();
				Subject przedmiot = przedmioty.get(wybranyprzedmiot);
				
				MT.addTeacher(przedmiot, imie_txt.getText(), nazwisko_txt.getText(), pesel_txt.getText(), haslo_txt.getText(), adres_txt.getText());
			}
		});
		btnDodaj.setBounds(248, 82, 89, 23);
		add(btnDodaj);

	}
}
