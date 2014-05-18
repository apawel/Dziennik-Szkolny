package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Student_Teacher;

import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.JSplitPane;

import controller.ManageStudentNote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_StudentNote_GUI extends JFrame {

	private JPanel contentPane;
	private JTextPane txt_Note;

	public Add_StudentNote_GUI(final Student_Teacher student_subject) {
		super(student_subject.getStudent().getFirstName() + " " + student_subject.getStudent().getLastName());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnDodajUwage = new JButton("Dodaj Uwag\u0119");
		btnDodajUwage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txt_Note.getText().length()!=0)
				{
					ManageStudentNote MSN = new ManageStudentNote();
					MSN.addStudentNote(student_subject.getTeacher(), student_subject.getStudent(), txt_Note.getText());
					dispose();
				}
				
			}
		});
		panel.add(btnDodajUwage);
		
		JButton btnZakmnij = new JButton("Zamknij");
		btnZakmnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnZakmnij);
		
		 txt_Note = new JTextPane();
		splitPane.setRightComponent(txt_Note);
	}

}
