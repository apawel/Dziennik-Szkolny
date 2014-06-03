package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import model.SchoolClass;
import model.Student;
import chat.Client_GUI_Teacher;
import chat.Server_GUI;

public class Class_Master_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	private JList lista_uczniow;
	public Class_Master_GUI(final SchoolClass schoolClass) {
		super(schoolClass.getName());
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 502, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		final DefaultListModel model = new DefaultListModel();
		final Set uczniowie = schoolClass.getStudents();
		java.util.Iterator it =  uczniowie.iterator();
		int i=0;
		while(it.hasNext())
		{
			Student uczen = (Student) it.next();
			i++;
			model.addElement(i+". "+uczen.getFirstName() + " " + uczen.getLastName() + "    urodzony: " + uczen.getDateOfBirth());
		}
		/*warunek jeœli zalogowany jako wychowawca to przenies do Student_GUI a jesli jako nauczyciel to do Student_Subject_GUI*/
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JLabel lblKlasa = new JLabel("Klasa:");
		panel.add(lblKlasa);
		
		
		
		JLabel lblNazwaklasy = new JLabel(schoolClass.getName());
		panel.add(lblNazwaklasy);
		lblNazwaklasy.setEnabled(false);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnWr = new JButton("Wr\u00F3\u0107");
		panel_1.add(btnWr);
		btnWr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		final JButton btnGenerujPdfs = new JButton("Generuj PDFs");
		panel_1.add(btnGenerujPdfs);
		btnGenerujPdfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				schoolClass.GeneratePDFs();
				btnGenerujPdfs.setEnabled(false);
			}
		});
		
		JButton btnNewButton = new JButton("Wirtualne Zebranie");
		panel_1.add(btnNewButton);
		JButton btnWybierzUcznia = new JButton("Wybierz ucznia");
		panel_1.add(btnWybierzUcznia);
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
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		  lista_uczniow = new JList(model);
		panel_2.add(lista_uczniow);
		lista_uczniow.setVisibleRowCount(20);
		lista_uczniow.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Server_GUI server_gui= new Server_GUI();
				server_gui.setVisible(true);
				Client_GUI_Teacher CGT = new Client_GUI_Teacher(schoolClass.getTeacher());
			}
		});
		
	
	}
}
