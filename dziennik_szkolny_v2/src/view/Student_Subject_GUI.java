package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Student;
import model.StudentNote;
import model.Student_Teacher;
import model.SubjectMark;
import controller.ManageStudent;

public class Student_Subject_GUI extends JFrame {

	public JPanel contentPane;
	private JTextField txtImieINazwisko;
	private JTable table_oceny;
	private JTable table_uwagi;
	private int liczba_wierszy;
	private Student student;
	private ManageStudent MS;

	public Student_Subject_GUI(final Student_Teacher student_subject) {
		super(student_subject.getStudent().getFirstName() + " "
				+ student_subject.getStudent().getLastName());
		setVisible(true);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 557, 359);
		contentPane = new JPanel();
	

		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblUczen = new JLabel("Uczen");
		panel.add(lblUczen);

		txtImieINazwisko = new JTextField();
		panel.add(txtImieINazwisko);
		txtImieINazwisko.setEditable(false);
		txtImieINazwisko.setText(student_subject.getStudent().getFirstName()
				+ " " + student_subject.getStudent().getLastName());
		txtImieINazwisko.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnDodajOcene = new JButton("Dodaj Ocene");
		panel_1.add(btnDodajOcene);

		JButton btnWpiszUwage = new JButton("Wpisz uwagê");
		panel_1.add(btnWpiszUwage);
		
	

		JButton btnNewButton = new JButton("Wróæ");
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_2.add(splitPane);

		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		splitPane.setLeftComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		splitPane.setRightComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		// /
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
 MS = new ManageStudent();
 student = MS.getStudentbyId(student_subject.getStudent().getIdStudent()) ;
		Iterator it = student.getSubjectMarks().iterator();

		Object[][] obiekty;
		Integer i = 0;
		while (it.hasNext()) {
			SubjectMark temp = (SubjectMark) it.next();
			if(temp.getSubject().getIdSubject() == student_subject.getTeacher().getSubject().getIdSubject())
			{			
			i++;
			}
		}
		obiekty = new Object[i][4];
		i=0;
		it = student.getSubjectMarks().iterator();
		while (it.hasNext()) {
			SubjectMark temp = (SubjectMark) it.next();
			if(temp.getSubject().getIdSubject() == student_subject.getTeacher().getSubject().getIdSubject())
			{
			obiekty[i][0] = temp.getValue();
			obiekty[i][1] = temp.getWeight();
			Date data = temp.getTimeStamp();
			
			obiekty[i][2] = data.toLocaleString();//data.toGMTString();//data.getDate() + "-"+data.getMonth()+ " " + data.getHours()+":"+data.getMinutes();
			obiekty[i][3] = temp.getDescription();
			i++;
			}

		}
		if (obiekty.length == 0) {
			obiekty = new Object[0][4];
		}

		JScrollPane soceny_scrollluj = new JScrollPane();
		panel_3.add(soceny_scrollluj, BorderLayout.CENTER);

		table_oceny = new JTable();
		table_oceny.setAlignmentX(Component.LEFT_ALIGNMENT);
		table_oceny.setFillsViewportHeight(true);
		// panel_3.add(table_oceny);
		table_oceny.setModel(new DefaultTableModel(obiekty, new String[] {
				"Ocena", "Waga", "Kiedy", "Opis" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_oceny.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_oceny.getColumnModel().getColumn(0).setPreferredWidth(58);
		table_oceny.getColumnModel().getColumn(1).setPreferredWidth(46);
		table_oceny.getColumnModel().getColumn(2).setPreferredWidth(112);
		table_oceny.getColumnModel().getColumn(3).setPreferredWidth(148);
		soceny_scrollluj.setViewportView(table_oceny);
		table_oceny.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// ///////////////////////////////////
		it = student.getStudentNotes().iterator();

		table_uwagi = new JTable();
		table_uwagi.setFillsViewportHeight(true);
		i = 0;

		obiekty = new Object[student.getStudentNotes()
				.size()][2];
		while (it.hasNext()) {
			StudentNote temp = (StudentNote) it.next();
			obiekty[i][0] = i + 1 + ".";
			obiekty[i][1] = temp.getNoteContents();
			i++;
		}
		if (obiekty.length == 0) {
			obiekty = new Object[0][2];
		}
		table_uwagi.setModel(new DefaultTableModel(obiekty,
				new String[] { "LP", "Uwaga" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_uwagi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_uwagi.getColumnModel().getColumn(0).setPreferredWidth(5);
	    table_uwagi.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		table_uwagi.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JScrollPane scrolluj_uwagusie = new JScrollPane();
		panel_4.add(scrolluj_uwagusie, BorderLayout.CENTER);
		
		//table_uwagi.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrolluj_uwagusie.setViewportView(table_uwagi);
		
		btnWpiszUwage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_StudentNote_GUI adduwaga = new Add_StudentNote_GUI(
						student_subject);
			//	student = MS.getStudentbyId(student_subject.getStudent().getIdStudent()) ;
			}
		});
		btnDodajOcene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Ocena_GUI add_subjectmark_gui = new Add_Ocena_GUI(
						student_subject);
				//student = MS.getStudentbyId(student_subject.getStudent().getIdStudent()) ;

			}
		});
	}
}
