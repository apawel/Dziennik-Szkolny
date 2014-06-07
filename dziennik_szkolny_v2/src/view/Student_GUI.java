package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Student;
import model.StudentNote;
import model.SubjectMark;
import controller.ManageStudent;

public class Student_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable oceny;
	private JTable uwagi;
	

	/**
	 to widoczne tez dla wychowawcy po kliknieciu wybierz ucznia z class_gui
	 */
	public Student_GUI(Student student) {
		super(student.getFirstName() +" "+ student.getLastName());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 264);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_801099329547601");
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel.add(splitPane);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnWyloguj = new JButton("Wr\u00F3\u0107");
		panel_1.add(btnWyloguj);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setContinuousLayout(true);
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_2.add(splitPane_1);
		
		JPanel panel_3 = new JPanel();
		splitPane_1.setLeftComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		
		ManageStudent MS = new ManageStudent();
		
		student = MS.getStudentbyId(student.getIdStudent());
		Iterator it = student.getSubjectMarks().iterator();
		
		Object[][] obiekty;
		Integer i = 0;

		obiekty = new Object[student.getSubjectMarks().size()][5];
		while (it.hasNext()) {
			SubjectMark temp = (SubjectMark) it.next();
			obiekty[i][0] = temp.getValue();
			obiekty[i][1] = temp.getWeight();
			Date data = temp.getTimeStamp();
			obiekty[i][2] = data.toLocaleString();//data.getMonth() + "-" + data.getDay() + " " + data.getHours()+":"+data.getMinutes();
			obiekty[i][3] = temp.getSubject().getName();
			obiekty[i][4] = temp.getDescription();
			i++;
		}
		if (obiekty.length == 0) {
			obiekty = new Object[0][5];
		}
		
		
		
		oceny = new JTable();
		oceny.setAlignmentX(Component.LEFT_ALIGNMENT);
		oceny.setFillsViewportHeight(true);
		oceny.setModel(new DefaultTableModel(obiekty, new String[] {
				"Ocena", "Waga", "Kiedy","Przedmiot", "Opis" }) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		
		//panel_3.add(oceny, BorderLayout.CENTER);
		
		oceny.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		oceny.getColumnModel().getColumn(0).setPreferredWidth(58);
		oceny.getColumnModel().getColumn(1).setPreferredWidth(46);
		oceny.getColumnModel().getColumn(2).setPreferredWidth(112);
		oceny.getColumnModel().getColumn(3).setPreferredWidth(148);
		oceny.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		JScrollPane oceny_scroll = new JScrollPane();
		panel_3.add(oceny_scroll, BorderLayout.CENTER);
		oceny_scroll.setViewportView(oceny);
		
		
		JPanel panel_4 = new JPanel();
		splitPane_1.setRightComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		///////////////////////////
	
		
		
		i = 0;
		it = student.getStudentNotes().iterator();
		obiekty = new Object[student.getStudentNotes().size()][3];
		while (it.hasNext()) {
			StudentNote temp = (StudentNote) it.next();
			obiekty[i][0] = i+1+".";
			obiekty[i][1] = temp.getTeacher().getLastName() + " " + temp.getTeacher().getFirstName();
			obiekty[i][2] = temp.getNoteContents();
	
			i++;
		}
		if (obiekty.length == 0) {
			obiekty = new Object[0][3];
		}
		uwagi = new JTable();
		uwagi.setFillsViewportHeight(true);

		uwagi.setModel(new DefaultTableModel(
			obiekty,
			new String[] {
				"LP", "Nauczyciel", "Tre\u015B\u0107"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		//panel_4.add(uwagi, BorderLayout.CENTER);
		
		uwagi.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		uwagi.getColumnModel().getColumn(0).setPreferredWidth(5);
		uwagi.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		uwagi.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		JScrollPane uwagi_scroll = new JScrollPane();
		panel_4.add(uwagi_scroll, BorderLayout.CENTER);
		uwagi_scroll.setViewportView(uwagi);
		
		btnWyloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
