package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ManageSubject;
import model.Subject;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditSubject_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtSubjectName;

	/**
	 * Create the panel.
	 */
	private int i =0;
	private ArrayList<Subject> subjects;
	public EditSubject_GUI() {
		setLayout(new BorderLayout(0, 0));
		subjects = new ArrayList<Subject>();
		subjects = ManageSubject.getAllSubjects();
		
		final JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel txtNumer = new JLabel("Numer:");
		panel.add(txtNumer);
	
		
		final JLabel lblNumer = new JLabel("New label");
		panel.add(lblNumer);
		
		
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		panel.add(lblNazwa);
		
		txtSubjectName = new JTextField();
		panel.add(txtSubjectName);
		txtSubjectName.setColumns(10);
		
		lblNumer.setText(subjects.get(i).getIdSubject()+"");
		txtSubjectName.setText(subjects.get(i).getName());
		
		JButton btnNastpny = new JButton("Nast\u0119pny");
		btnNastpny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(i+1<subjects.size())
					i++;
				else
					i=0;
				lblNumer.setText(subjects.get(i).getIdSubject()+"");
				txtSubjectName.setText(subjects.get(i).getName());
				
				
			}
		});
		panel.add(btnNastpny);
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtSubjectName.getText();
				subjects.get(i).setName(name);
				ManageSubject.updateSubject(subjects.get(i));
			}
		});
		panel.add(btnZapisz);
		

	}

}
