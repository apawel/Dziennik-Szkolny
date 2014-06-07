package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ManageSubject;

public class addSubject_GUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNazwaPrzedmiotu;


	public addSubject_GUI() {
		setLayout(null);
		
		txtNazwaPrzedmiotu = new JTextField();
		txtNazwaPrzedmiotu.setBounds(180, 52, 126, 20);
		add(txtNazwaPrzedmiotu);
		txtNazwaPrzedmiotu.setColumns(10);
		
		JLabel lblNazwaPrzedmiotu = new JLabel("Nazwa przedmiotu:");
		lblNazwaPrzedmiotu.setBounds(46, 55, 112, 14);
		add(lblNazwaPrzedmiotu);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				ManageSubject.addSubject(txtNazwaPrzedmiotu.getText());//dodawanie przedmiotu
			}
		});
		btnDodaj.setBounds(164, 83, 89, 23);
		add(btnDodaj);

	}
}
