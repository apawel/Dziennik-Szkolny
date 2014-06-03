package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import model.SchoolClass;
import model.Teacher;
import controller.ManageSchoolClass;
import controller.ManageSubject;
import controller.ManageTeacher;

public class AddSchoolClass_GUI extends JPanel {
	private JTextField txt_class_name;
	private JList list_subjects;
	private JButton btnZapisz;

	/**
	 * Create the panel.
	 */
	private JComboBox comboBox_ClassMaster;
	public AddSchoolClass_GUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Nazwa Klasy:");
		panel.add(lblNewLabel);
		
		txt_class_name = new JTextField();
		panel.add(txt_class_name);
		txt_class_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Rok rozpocz\u0119cia:");
		panel.add(lblNewLabel_1);
		
		final JSpinner yearStart = new JSpinner();
		panel.add(yearStart);
		yearStart.setModel(new SpinnerNumberModel(2014, 2014, 2100, 1));
		
		JLabel lblWychowawca = new JLabel("Wychowawca:");
		panel.add(lblWychowawca);
		
		 comboBox_ClassMaster = new JComboBox();
		panel.add(comboBox_ClassMaster);
		ManageTeacher MT = new ManageTeacher();
		final ArrayList<Teacher> teachers = (ArrayList<Teacher>) MT.getAllTeachers();
		for(int i =0;i<teachers.size();i++)
		{
			comboBox_ClassMaster.addItem(teachers.get(i).getLastName()+" "+teachers.get(i).getFirstName());
		}
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		DefaultListModel model = new DefaultListModel<>();
		
		 list_subjects = new JList(model);
		 list_subjects.setValueIsAdjusting(true);
		 list_subjects.setSelectionModel(new DefaultListSelectionModel() {
			    @Override
			    public void setSelectionInterval(int index0, int index1) {
			        if(super.isSelectedIndex(index0)) {
			            super.removeSelectionInterval(index0, index1);
			        }
			        else {
			            super.addSelectionInterval(index0, index1);
			        }
			    }
			});
		// list_subjects.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	//	panel_1.add(list_subjects, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(list_subjects);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(list_subjects);
		
		/**moze zmienic na jtable**/
		final ManageSubject MS = new ManageSubject();
		final ArrayList<model.Subject> przedmioty =  MS.getAllSubjects();
		for(int i =0;i<przedmioty.size();i++)
		{
			model.add(i,przedmioty.get(i).getName());
		}

		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 btnZapisz = new JButton("Dodaj");
		 btnZapisz.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ManageSchoolClass MSC = new ManageSchoolClass();
		 	int SchoolClassID =	MSC.addSchoolClass(teachers.get(comboBox_ClassMaster.getSelectedIndex()), txt_class_name.getText(), yearStart.getValue()+"", ((Integer)yearStart.getValue()+1)+"");
		 		SchoolClass schoolClass = MSC.getSchoolClass(SchoolClassID);
		 	int[] selected =	list_subjects.getSelectedIndices();
		 	ManageSubject MS = new ManageSubject();
		 	for(int i =0;i<selected.length;i++)
		 	{
		 		schoolClass.getSubjects().add(przedmioty.get(selected[i]));
		 	}
		 	MSC.updateDB(schoolClass);
		 	}
		 	
		 });
		panel_2.add(btnZapisz);

	}
}
