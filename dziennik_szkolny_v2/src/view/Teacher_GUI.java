package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javassist.bytecode.Descriptor.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

import controller.ManageSchoolClass;
import model.SchoolClass;
import model.Subject;
import model.Teacher;
import model.Teacher_Class;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Set;

public class Teacher_GUI extends JFrame {

	private JPanel contentPane;

	public Teacher_GUI(final Teacher teacher) {	
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
		JLabel lbl_prowadzonyprzeznauczycielaprzedmiot = new JLabel(teacher.getSubject().getName());
		lbl_prowadzonyprzeznauczycielaprzedmiot.setEnabled(false);
		lbl_prowadzonyprzeznauczycielaprzedmiot.setBounds(80, 14, 222, 14);
		contentPane.add(lbl_prowadzonyprzeznauczycielaprzedmiot);
		/*klasy ktore uczeszczaja na dany przedmiot*/
		ArrayList<SchoolClass> klasy = new ArrayList<>();
		ManageSchoolClass MSC = new ManageSchoolClass();
		klasy=(ArrayList<SchoolClass>) MSC.getAllSchoolClasses();
		final ArrayList<SchoolClass> klasy_nauczyciela = new ArrayList<>();
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 49, 164, 20);
		contentPane.add(comboBox);
		
		for(int i =0;i<klasy.size();i++)
		{
			Set przedmioty =  klasy.get(i).getSubjects();
			java.util.Iterator it =  przedmioty.iterator();
			for(int j =0;j<przedmioty.size();j++)
			{
				Subject przedmiot = (Subject) it.next();
				if(przedmiot.getIdSubject()== teacher.getSubject().getIdSubject())
				{
					klasy_nauczyciela.add(klasy.get(i));
					comboBox.addItem(klasy.get(i).getName());
				}
			}
			
		}
		
		
		
		JLabel lblKlasa = new JLabel("Klasa");
		lblKlasa.setBounds(20, 52, 46, 14);
		contentPane.add(lblKlasa);
		
		
		JButton btnDalej = new JButton("Dalej");
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Class_GUI a = new Class_GUI(new Teacher_Class(teacher,klasy_nauczyciela.get(comboBox.getSelectedIndex())));
			}
		});
		btnDalej.setBounds(212, 80, 89, 23);
		contentPane.add(btnDalej);
		
		JButton btnWyloguj = new JButton("Wyloguj");
		btnWyloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnWyloguj.setBounds(10, 80, 89, 23);
		contentPane.add(btnWyloguj);
	}
}
