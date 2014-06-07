package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Teacher;
import controller.ManageTeacher;
import java.awt.FlowLayout;

public class EditTeacher_GUI extends JPanel {
	private JTextField imie_txt;
	private JTextField nazwisko_txt;
	private JTextField pesel_txt;
	private JTextField haslo_txt;
	private JTextField adres_txt;
	private ArrayList<Teacher> teachers;
	private int iterat;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EditTeacher_GUI() {
		iterat = 0;
		teachers = ManageTeacher.getAllTeachers();
		setLayout(null);

		JLabel lblImi = new JLabel("Imi\u0119:");
		lblImi.setBounds(10, 11, 46, 14);
		add(lblImi);

		imie_txt = new JTextField();
		imie_txt.setBounds(91, 8, 109, 20);
		add(imie_txt);
		imie_txt.setColumns(10);

		imie_txt.setText(teachers.get(iterat).getFirstName());

		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 36, 79, 14);
		add(lblNazwisko);

		nazwisko_txt = new JTextField();
		nazwisko_txt.setColumns(10);
		nazwisko_txt.setBounds(91, 33, 109, 20);
		add(nazwisko_txt);

		nazwisko_txt.setText(teachers.get(iterat).getLastName());

		JLabel lblPesel = new JLabel("Pesel:");
		lblPesel.setBounds(10, 61, 46, 14);
		add(lblPesel);

		pesel_txt = new JTextField();
		pesel_txt.setColumns(10);
		pesel_txt.setBounds(91, 58, 109, 20);
		add(pesel_txt);

		pesel_txt.setText(teachers.get(iterat).getPersonalIdentityNumber());
		pesel_txt.setEditable(false);

		JLabel lblHaso = new JLabel("Has\u0142o:");
		lblHaso.setBounds(10, 86, 46, 14);
		add(lblHaso);

		haslo_txt = new JTextField();
		haslo_txt.setBounds(91, 83, 109, 20);
		add(haslo_txt);
		haslo_txt.setColumns(10);

		haslo_txt.setText(teachers.get(iterat).getPassword());

		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(10, 111, 46, 14);
		add(lblAdres);

		adres_txt = new JTextField();
		adres_txt.setBounds(91, 108, 109, 20);
		add(adres_txt);
		adres_txt.setColumns(10);

		adres_txt.setText(teachers.get(iterat).getAddress());

		JLabel lblPrzedmiot = new JLabel("Przedmiot:");
		lblPrzedmiot.setBounds(10, 137, 79, 14);
		add(lblPrzedmiot);
		
	final	JLabel txtPrzedmiot = new JLabel("New label");
	txtPrzedmiot.setBounds(91, 134, 125, 20);
		add(txtPrzedmiot);
		txtPrzedmiot.setText(teachers.get(iterat).getSubject().getName());
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 267, 450, 33);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						
								JButton btnDodaj = new JButton("Zapisz");
								add(btnDodaj);
								btnDodaj.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										Teacher teacher = teachers.get(iterat);
										
										teacher.setAddress(adres_txt.getText());
										teacher.setFirstName(imie_txt.getText());
										teacher.setLastName(nazwisko_txt.getText());
										teacher.setPersonalIdentityNumber(pesel_txt.getText());
										teacher.setPassword(haslo_txt.getText());
										
										
										ManageTeacher.updateTeacher(teacher);
									}
								});
								btnDodaj.setBounds(20, 162, 63, 23);
								
										JButton btnNewButton = new JButton("Nast\u0119pny");
										btnNewButton.setBounds(91, 162, 79, 23);
										add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (iterat+1 < teachers.size())
									iterat++;
								else
									iterat = 0;
								imie_txt.setText(teachers.get(iterat).getFirstName());
								nazwisko_txt.setText(teachers.get(iterat).getLastName());
								pesel_txt.setText(teachers.get(iterat)
										.getPersonalIdentityNumber());
								haslo_txt.setText(teachers.get(iterat).getPassword());
								txtPrzedmiot.setText(teachers.get(iterat).getSubject().getName());
								adres_txt.setText(teachers.get(iterat).getAddress());

							}
						});

	}

}
