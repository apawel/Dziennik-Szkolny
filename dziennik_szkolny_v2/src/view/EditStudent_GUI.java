package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ManageStudent;
import model.Student;

public class EditStudent_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField imie_txt;
	private JTextField nazwisko_txt;
	private JTextField pesel_txt;
	private JTextField haslo_txt;
	private JTextField adres_txt;
	private ArrayList<Student> students;
	private int iter;
	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public EditStudent_GUI() {
	iter =0;
		setLayout(null);
		students = ManageStudent.getAllStudents();
		JLabel lblImi = new JLabel("Imi\u0119:");
		lblImi.setBounds(10, 11, 46, 14);
		add(lblImi);
		
		imie_txt = new JTextField();
		imie_txt.setBounds(114, 8, 109, 20);
		add(imie_txt);
		imie_txt.setColumns(10);
		
		imie_txt.setText(students.get(iter).getFirstName());
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 36, 79, 14);
		add(lblNazwisko);
		
		nazwisko_txt = new JTextField();
		nazwisko_txt.setColumns(10);
		nazwisko_txt.setBounds(114, 33, 109, 20);
		add(nazwisko_txt);
		
		nazwisko_txt.setText(students.get(iter).getLastName());
		
		JLabel lblPesel = new JLabel("Pesel:");
		lblPesel.setBounds(10, 61, 46, 14);
		add(lblPesel);
		
		pesel_txt = new JTextField();
		pesel_txt.setColumns(10);
		pesel_txt.setBounds(114, 58, 109, 20);
		add(pesel_txt);
		
		pesel_txt.setText(students.get(iter).getPersonalIdentityNumber());
		pesel_txt.setEditable(false);
		
		JLabel lblHaso = new JLabel("Has\u0142o:");
		lblHaso.setBounds(10, 86, 46, 14);
		add(lblHaso);
		
		haslo_txt = new JTextField();
		haslo_txt.setBounds(114, 83, 109, 20);
		add(haslo_txt);
		haslo_txt.setColumns(10);
		
		haslo_txt.setText(students.get(iter).getPassword());
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setBounds(10, 111, 46, 14);
		add(lblAdres);
		
		adres_txt = new JTextField();
		adres_txt.setBounds(114, 108, 109, 20);
		add(adres_txt);
		adres_txt.setColumns(10);
		
		adres_txt.setText(students.get(iter).getAddress());
		
		JLabel lblData = new JLabel("Data urodzenia:");
		lblData.setBounds(10, 133, 109, 14);
		add(lblData);
		Date data = students.get(iter).getDateOfBirth();
		JLabel lblDd = new JLabel("DD");
		lblDd.setBounds(124, 133, 79, 14);
		add(lblDd);
		lblDd.setText(data.toLocaleString());
		
		JLabel lblKlasa = new JLabel("Klasa:");
		lblKlasa.setBounds(10, 154, 100, 14);
		add(lblKlasa);
		
		final JLabel txtKlasa = new JLabel("New label");
		txtKlasa.setBounds(114, 154, 450, 14);
		add(txtKlasa);
		
		txtKlasa.setText(students.get(iter).getSchoolClass().getName());
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 267, 450, 33);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNastepny = new JButton("Nast\u0119pny");
		btnNastepny.setBounds(10, 174, 100, 23);
		add(btnNastepny);
		
		JButton btnDodaj = new JButton("Zapisz");
		add(btnDodaj);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = students.get(iter);
				
				student.setAddress(adres_txt.getText());
				student.setFirstName(imie_txt.getText());
				student.setLastName(nazwisko_txt.getText());
				student.setPassword(haslo_txt.getText());
				
				ManageStudent.updateStudent(student);			
	
			}
		});
		btnDodaj.setBounds(114, 174, 79, 23);
		btnNastepny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iter+1<students.size())
					iter++;
				else
					iter=0;
				
				imie_txt.setText(students.get(iter).getFirstName());
				nazwisko_txt.setText(students.get(iter).getLastName());
				pesel_txt.setText(students.get(iter).getPersonalIdentityNumber());
				haslo_txt.setText(students.get(iter).getPassword());
				adres_txt.setText(students.get(iter).getAddress());
				txtKlasa.setText(students.get(iter).getSchoolClass().getName());
			}
		});
		
	
		


	}
}
