package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.security.auth.Subject;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ManageSubjectMark;
import model.Student;
import model.Student_Teacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Ocena_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox value;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Add_Ocena_GUI(final Student_Teacher student_subject) {
		super(student_subject.getStudent().getFirstName() + " " + student_subject.getStudent().getLastName());
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 262, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageSubjectMark MSK = new ManageSubjectMark();
				MSK.addSubjectMark(student_subject.getStudent(), student_subject.getTeacher().getSubject(), (double)value.getSelectedItem(), Integer.parseInt(textField.getText()), textField_1.getText());
				dispose();
			}
		});
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
		
		
		 value = new JComboBox();
		value.setBounds(88, 22, 46, 20);
		contentPane.add(value);
		value.addItem(1.0);
		value.addItem(2.0);
		value.addItem(2.5);
		value.addItem(3.0);
		value.addItem(3.5);
		value.addItem(4.0);
		value.addItem(4.5);
		value.addItem(5.0);
		value.addItem(5.5);
		value.addItem(6.0);
		
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
