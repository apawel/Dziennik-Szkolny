package view;

import java.awt.EventQueue;

import model.*;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.JPasswordField;

import org.omg.CORBA.ExceptionList;

import antlr.collections.List;
import controller.ManageTeacher;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.ComboPopup;

public class Login_GUI {

	private JFrame frame;
	private JTextField txt_pesel;
	private JPasswordField passwordField;

	final JLabel pesel_blad_znak = new JLabel(
			"B\u0142\u0119dny pesel lub/i has\u0142o");

	private class LoginStudent extends SwingWorker<Student, Void> {

		@Override
		protected Student doInBackground() throws Exception {
			try {
				Student student = loginStudent();
				return student;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException();

			}
		}

		protected void done() {
			try {
				Student_GUI student_gui = new Student_GUI(get());
			} catch (InterruptedException | ExecutionException e) {
				pesel_blad_znak.setVisible(true);
			}
		}
	}

	class LoginTeacher extends SwingWorker<Teacher, Void> {

		@Override
		protected Teacher doInBackground() throws Exception {
			try {
				Teacher teacher = loginTeacher();
				return teacher;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException();

			}

		}

		@Override
		protected void done() {

			try {
				Teacher_GUI teacher_gui = new Teacher_GUI(get());
			} catch (InterruptedException | ExecutionException e) {
				pesel_blad_znak.setVisible(true);
			}

			// System.out.println("Done");
		}

	}

	class LoginClassMaster extends SwingWorker<SchoolClass, Void> {

		@Override
		protected SchoolClass doInBackground() throws Exception {
			try {
				SchoolClass schoolClass = loginSchoolClass();
				return schoolClass;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException();

			}
		}

		protected void done() {
			try {
				Class_Master_GUI schoolClass_gui = new Class_Master_GUI(get());
			} catch (InterruptedException | ExecutionException e) {
				pesel_blad_znak.setVisible(true);
			}
		}
	}

	private enum Wybor {
		Uczen, Nauczyciel, Wychowawca;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_GUI window = new Login_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_GUI() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public boolean isCorrect(char[] passDB, char[] passtxt) {

		if (passDB.length != passtxt.length)
			return false;
		for (int i = 0; i < passDB.length; i++) {
			if (passDB[i] != passtxt[i])
				return false;
		}
		return true;

	}

	public Teacher loginTeacher() throws Exception {

		Teacher teacher = null;
		boolean correct = false;

		if (txt_pesel.getText().length() != 11)
			throw new NumberFormatException();

		ManageTeacher MT = new ManageTeacher();
		teacher = MT.getTeacherbyPIN(txt_pesel.getText());
		char[] password = passwordField.getPassword();

		if (isCorrect(teacher.getPassword().toCharArray(), password))
			correct = true;// przypisanie nauczyciela
		else
			throw new NumberFormatException();

		return teacher;

	}

	public SchoolClass loginSchoolClass() throws Exception {

		// SchoolClass schoolCLass = null;
		Teacher teacher = null;
		boolean correct = false;

		if (txt_pesel.getText().length() != 11)
			throw new NumberFormatException();

		ManageTeacher MT = new ManageTeacher();
		teacher = MT.getTeacherbyPIN(txt_pesel.getText());
		char[] password = passwordField.getPassword();

		if (isCorrect(teacher.getPassword().toCharArray(), password))
			correct = true;// przypisanie nauczyciela
		else
			throw new NumberFormatException();

		ManageSchoolClass MSC = new ManageSchoolClass();
		SchoolClass schoolClass = MSC.getSchoolClassbyTeacherID(teacher
				.getIdTeacher());

		return schoolClass;

	}

	public Student loginStudent() throws Exception {

		Student student = null;
		boolean correct = false;

		if (txt_pesel.getText().length() != 11)
			throw new NumberFormatException();

		ManageStudent MS = new ManageStudent();
		student = MS.getStudentbyPIN(txt_pesel.getText());
		char[] password = passwordField.getPassword();

		if (isCorrect(student.getPassword().toCharArray(), password))
			correct = true;// przypisanie nauczyciela
		else
			throw new NumberFormatException();

		return student;

	}

	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Wirtualny dziennik Szkolny");
		frame.setResizable(false);
		frame.setBounds(100, 100, 350, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txt_pesel = new JTextField();
		txt_pesel.setBounds(69, 48, 154, 20);
		frame.getContentPane().add(txt_pesel);
		txt_pesel.setColumns(10);

		JLabel lblPesel = new JLabel("Pesel");
		lblPesel.setBounds(10, 50, 69, 17);
		frame.getContentPane().add(lblPesel);

		pesel_blad_znak.setEnabled(false);
		pesel_blad_znak.setVisible(false);
		pesel_blad_znak.setBounds(44, 23, 179, 14);
		frame.getContentPane().add(pesel_blad_znak);

		JLabel lblHaso = new JLabel("Has\u0142o");
		lblHaso.setBounds(10, 78, 45, 17);
		frame.getContentPane().add(lblHaso);
		/** Zaymaknie Okienka Logowania **/
		JButton btnZamknij = new JButton("Zamknij");
		btnZamknij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnZamknij.setBounds(20, 147, 108, 29);
		frame.getContentPane().add(btnZamknij);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(69, 107, 154, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Uczen");
		comboBox.addItem("Nauczyciel");
		comboBox.addItem("Wychowawca");

		passwordField = new JPasswordField();
		passwordField.setBounds(69, 76, 154, 20);
		frame.getContentPane().add(passwordField);

		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(new ActionListener() {
			private LoginTeacher login;
			private LoginStudent loginStudent;
			private LoginClassMaster loginClassMaster;

			public void actionPerformed(ActionEvent arg0) {

				String wybrane = (String) comboBox.getSelectedItem();
				Wybor fruit = Wybor.valueOf(wybrane);

				switch (fruit) {
				case Uczen:
					if (passwordField.getPassword()[0] == '1'
							&& txt_pesel.getText().equals("1")) {
						AdminGUI admin = new AdminGUI();
					} else {
						pesel_blad_znak.setVisible(false);
						loginStudent = new LoginStudent();
						this.loginStudent.execute();
					}

					break;
				case Nauczyciel:
					pesel_blad_znak.setVisible(false);
					login = new LoginTeacher();
					this.login.execute();
					break;
				case Wychowawca:
					pesel_blad_znak.setVisible(false);
					loginClassMaster = new LoginClassMaster();
					this.loginClassMaster.execute();
					break;
				}

			}
		});
		btnZaloguj.setBounds(156, 147, 108, 29);
		frame.getContentPane().add(btnZaloguj);

	}
}
