package controller;
import java.sql.Date;
import java.util.Iterator;

import model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utils.HibernateUtil;

public class MainClass {

	
	public static void main(String[] args) {
	
		
		ManageSubject MS = new ManageSubject();
		/*MS.addSubject("Agent");
		MS.addSubject("Fizyka");
		MS.addSubject("Chemia");
		MS.addSubject("Polski");
		MS.addSubject("Angielski");
		MS.addSubject("Niemiecki");
		MS.addSubject("Biologia");
		MS.addSubject("WF");*/
		
		ManageTeacher MT = new ManageTeacher();
		//Teacher test = new Teacher(MS.getSubject(21), "Jabn", "Nowak", "98765432198", "1234", "Jakis tam");
		//MT.saveTeacher(test);
		//MT.addTeacher(MS.getSubject(20), "Aga", "Kowalsa", "01234567890", "1234", "Gda�sk, Grunwaldzka 5");
		//MT.addTeacher(MS.getSubject(18), "Przemyslaw", "Plys", "12345678912", "1234", "Zakopane, Grunwald 78");

		//MT.addTeacher(MS.getSubject(19), "Aneta", "Gora", "01234567891", "1234", "Krakow, Czarnowiejska 5");

		ManageSchoolClass MSC = new ManageSchoolClass();
	/* try {
		MSC.addSchoolClass(MT.getTeacherbyPIN("92062410079"), "1D","2013" , "2014");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 */
	 
//	MSC.getSchoolClass(3).saveListOfStudentsToFile();
	SchoolClass klasa = MSC.getSchoolClass(1);
	
	/*	
	System.out.println("jestem klasa : " + klasa.getName() + " TAKA.");
		klasa.getSubjects().add(MS.getSubject(17));

		klasa.getSubjects().add(MS.getSubject(18));

		klasa.getSubjects().add(MS.getSubject(19));

		klasa.getSubjects().add(MS.getSubject(20));

		klasa.getSubjects().add(MS.getSubject(21));
		
		klasa.getSubjects().add(MS.getSubject(22));

		klasa.getSubjects().add(MS.getSubject(23));
		*/
		
		//MSC.updateSchoolClass(klasa);
		/*MSC.updateDB(klasa);
		Iterator it = MSC.getSchoolClass(1).getSubjects().iterator();
		while(it.hasNext()) {
	       Subject element = (Subject)it.next();
	         System.out.print(element.getName() + " ");
	      }*/
@SuppressWarnings("deprecation")
 Date data = new Date(1992-1900,4,22);
		

		
	ManageStudent MSt = new ManageStudent();
	//	MSt.addStudent(MSC.getSchoolClass(1), "Pawe�", "B", "00011122233", "123", data, "Krakow, Czarnowiejska 5");
		MSt.addStudent(MSC.getSchoolClass(1), "Piotr", "Iksinski", "00001112223", "123", data, "Krakow, Czarnowiejska 5");
		MSt.addStudent(MSC.getSchoolClass(1), "Oliwa", "Rurek", "00000111223", "123", data, "Krakow, Czarnowiejska 5");
		MSt.addStudent(MSC.getSchoolClass(1), "Zygmunt", "Wazonik", "00000011122", "123", data, "Krakow, Czarnowiejska 5");
		
		
		
	/*	MT.addTeacher(MS.getSubject(1), "Pawe�", "Wojciechowski", "92062410079", "1234", "Krak�w, Czarnowiejska 15");
		MT.addTeacher(MS.getSubject(1), "Przemys�aw", "P�y�", "12345678910", "4321", "Krak�w, Rynek G��wny 15/2");
		MT.addTeacher(MS.getSubject(2), "Adam", "Nowak", "01234567891", "4321", "Siepraw, D�uga 15/2");
		MT.addTeacher(MS.getSubject(3), "Przemys�aw", "P�y�", "00123456789", "4321", "Zakopane, Kr�tka 15/2");
		*/
/*
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
	 session.beginTransaction();
       // session.save(naucz1);
		session.getTransaction().commit();
		session.close();
*/
	}

}
