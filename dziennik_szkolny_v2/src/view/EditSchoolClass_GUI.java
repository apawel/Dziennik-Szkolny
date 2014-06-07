package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.SchoolClass;
import controller.ManageSchoolClass;

public class EditSchoolClass_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtSchoolClassName;

	/**
	 * Create the panel.
	 */
	private int i =0;
	private ArrayList<SchoolClass> schoolClasses;

	/**
	 * Create the panel.
	 */
	public EditSchoolClass_GUI() {
		setLayout(new BorderLayout(0, 0));
		schoolClasses = new ArrayList<SchoolClass>();
		schoolClasses = ManageSchoolClass.getAllSchoolClasses();
		
		final JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel txtNumer = new JLabel("Numer:");
		panel.add(txtNumer);
	
		
		final JLabel lblNumer = new JLabel("New label");
		panel.add(lblNumer);
		
		
		
		JLabel lblNazwa = new JLabel("Nazwa Klasy:");
		panel.add(lblNazwa);
		
		txtSchoolClassName = new JTextField();
		panel.add(txtSchoolClassName);
		txtSchoolClassName.setColumns(10);
		
		lblNumer.setText(schoolClasses.get(i).getIdSchoolClass()+"");
		txtSchoolClassName.setText(schoolClasses.get(i).getName());
		
		JButton btnNastpny = new JButton("Nast\u0119pny");
		btnNastpny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i+1<schoolClasses.size())
					i++;
				else
					i=0;
				lblNumer.setText(schoolClasses.get(i).getIdSchoolClass()+"");
				txtSchoolClassName.setText(schoolClasses.get(i).getName());
				
				
			}
		});
		panel.add(btnNastpny);
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtSchoolClassName.getText();
				schoolClasses.get(i).setName(name);
				ManageSchoolClass.updateSchoolClass(schoolClasses.get(i));
			}
		});
		panel.add(btnZapisz);
		

	}

}
