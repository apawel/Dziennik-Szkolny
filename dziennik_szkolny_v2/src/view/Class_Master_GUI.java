package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

import model.SchoolClass;
import model.Student;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class Class_Master_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Class_Master_GUI(SchoolClass schoolClass) {
		super(schoolClass.getName());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblKlasa = new JLabel("Klasa:");
		lblKlasa.setBounds(10, 11, 46, 14);
		contentPane.add(lblKlasa);
		
		
		final DefaultListModel model = new DefaultListModel();
		final Set uczniowie = schoolClass.getStudents();
		java.util.Iterator it =  uczniowie.iterator();
		final JList lista_uczniow = new JList(model);
		lista_uczniow.setVisibleRowCount(20);
		lista_uczniow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista_uczniow.setBounds(10, 37, 397, 165);
		contentPane.add(lista_uczniow);
		int i=0;
		while(it.hasNext())
		{
			Student uczen = (Student) it.next();
			i++;
			model.addElement(i+". "+uczen.getFirstName() + " " + uczen.getLastName() + "    urodzony: " + uczen.getDateOfBirth());
		}
		
		
		
		JLabel lblNazwaklasy = new JLabel(schoolClass.getName());
		lblNazwaklasy.setEnabled(false);
		lblNazwaklasy.setBounds(81, 11, 69, 14);
		contentPane.add(lblNazwaklasy);
		/*warunek jeœli zalogowany jako wychowawca to przenies do Student_GUI a jesli jako nauczyciel to do Student_Subject_GUI*/
		JButton btnWybierzUcznia = new JButton("Wybierz ucznia");
		btnWybierzUcznia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int wybrany = lista_uczniow.getSelectedIndex();
				java.util.Iterator it =  uczniowie.iterator();
				Student student=null;			
				int i=0;
				while(it.hasNext())
				{
					student = (Student) it.next();
					if(i == wybrany)
						break;
					else
						i++;
						
				}
				Student_GUI student_gui = new Student_GUI(student);
			}
		});
		btnWybierzUcznia.setBounds(302, 227, 130, 23);
		contentPane.add(btnWybierzUcznia);
		
		JButton btnWr = new JButton("Wr\u00F3\u0107");
		btnWr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnWr.setBounds(20, 227, 130, 23);
		contentPane.add(btnWr);
		
		JButton btnNewButton = new JButton("Wirtualne Zebranie");
		btnNewButton.setBounds(153, 227, 146, 23);
		contentPane.add(btnNewButton);
		
	
	}
}
