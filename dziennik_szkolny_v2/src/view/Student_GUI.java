package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;

import model.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Student_GUI extends JFrame {

	private JPanel contentPane;
	

	/**
	 to widoczne tez dla wychowawcy po kliknieciu wybierz ucznia z class_gui
	 */
	public Student_GUI(Student nazwa) {
		super(nazwa.getFirstName() + nazwa.getLastName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 244);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_801099329547601");
		panel.setLayout(null);
		
		JButton btnWyloguj = new JButton("Wyloguj");
		btnWyloguj.setBounds(10, 161, 71, 23);
		panel.add(btnWyloguj);
		
		JButton btnUwagi = new JButton("Uwagi");
		btnUwagi.setBounds(229, 161, 61, 23);
		btnUwagi.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.add(btnUwagi);
		
		JList lista_ocen = new JList();
		lista_ocen.setBounds(26, 11, 232, 142);
		panel.add(lista_ocen);
		btnWyloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	}
}
