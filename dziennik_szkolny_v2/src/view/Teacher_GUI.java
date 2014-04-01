package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

import model.Teacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teacher_GUI extends JFrame {

	private JPanel contentPane;

	public Teacher_GUI(Teacher teacher) {
		super(teacher.getFirstName() + " " +teacher.getLastName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 150);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrzedmiot = new JLabel("Przedmiot");
		lblPrzedmiot.setBounds(10, 11, 72, 20);
		contentPane.add(lblPrzedmiot);
		/*Trzeba pobrac ten przedmiot gdzie id w bazie techara jesgo jest :D*/
		JLabel lbl_prowadzonyprzeznauczycielaprzedmiot = new JLabel("s");
		lbl_prowadzonyprzeznauczycielaprzedmiot.setEnabled(false);
		lbl_prowadzonyprzeznauczycielaprzedmiot.setBounds(80, 14, 222, 14);
		contentPane.add(lbl_prowadzonyprzeznauczycielaprzedmiot);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 49, 164, 20);
		contentPane.add(comboBox);
		
		JLabel lblKlasa = new JLabel("Klasa");
		lblKlasa.setBounds(20, 52, 46, 14);
		contentPane.add(lblKlasa);
		
		JButton btnDalej = new JButton("Dalej");
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Class_GUI a = new Class_GUI("Wybrana nazwa klasy");
			}
		});
		btnDalej.setBounds(212, 80, 89, 23);
		contentPane.add(btnDalej);
		
		JButton btnWyloguj = new JButton("Wyloguj");
		btnWyloguj.setBounds(10, 80, 89, 23);
		contentPane.add(btnWyloguj);
	}
}
