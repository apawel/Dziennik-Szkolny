package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

import model.Student;
import model.Student_Teacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Subject_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtImieINazwisko;
	private JTable table;

	public Student_Subject_GUI(Student_Teacher student_subject) {
		super(student_subject.getStudent().getFirstName() + " " + student_subject.getStudent().getLastName());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUczen = new JLabel("Uczen");
		lblUczen.setBounds(10, 11, 46, 14);
		contentPane.add(lblUczen);
		
		txtImieINazwisko = new JTextField();
		txtImieINazwisko.setEditable(false);
		txtImieINazwisko.setText(student_subject.getStudent().getFirstName() + " " + student_subject.getStudent().getLastName());
		txtImieINazwisko.setBounds(76, 8, 146, 20);
		contentPane.add(txtImieINazwisko);
		txtImieINazwisko.setColumns(10);
		
		table = new JTable();
		table.setBounds(30, 48, 308, 152);
		contentPane.add(table);
		
		JButton btnDodajOcene = new JButton("Dodaj Ocene");
		btnDodajOcene.setBounds(262, 211, 118, 23);
		contentPane.add(btnDodajOcene);
		
		JButton btnWpiszUwage = new JButton("Wpisz uwagê");
		btnWpiszUwage.setBounds(119, 211, 128, 23);
		contentPane.add(btnWpiszUwage);
		
		JButton btnNewButton = new JButton("Wróæ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(10, 211, 99, 23);
		contentPane.add(btnNewButton);
	}
}
