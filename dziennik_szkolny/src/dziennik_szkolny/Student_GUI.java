package dziennik_szkolny;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_GUI extends JFrame {

	private JPanel contentPane;
	

	/**
	 to widoczne tez dla wychowawcy po kliknieciu wybierz ucznia z class_gui
	 */
	public Student_GUI(String nazwa) {
		super(nazwa);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnWyloguj = new JButton("Wyloguj");
		btnWyloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnWyloguj.setBounds(40, 216, 89, 23);
		contentPane.add(btnWyloguj);
		
		JList list = new JList();
		list.setBounds(30, 21, 346, 179);
		contentPane.add(list);
		
		JButton btnUwagi = new JButton("Uwagi");
		btnUwagi.setBounds(286, 216, 89, 23);
		contentPane.add(btnUwagi);
	}
}
