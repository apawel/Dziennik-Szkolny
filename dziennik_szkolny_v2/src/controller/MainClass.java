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
	//	MS.addSubject("Agent");
	/*	MS.addSubject("Fizyka");
		MS.addSubject("Chemia");
		MS.addSubject("Polski");
		MS.addSubject("Angielski");
		MS.addSubject("Niemiecki");
		MS.addSubject("Biologia");
		MS.addSubject("WF");
		*/
		//ManageTeacher MT = new ManageTeacher();
		ManageSchoolClass MSC = new ManageSchoolClass();
		
		MSC.getSchoolClass(3).getSubjects().add(MS.getSubject(1));
		MSC.getSchoolClass(3).getSubjects().add(MS.getSubject(2));
		MSC.getSchoolClass(3).getSubjects().add(MS.getSubject(3));
		MSC.getSchoolClass(3).getSubjects().add(MS.getSubject(4));
		MSC.getSchoolClass(3).getSubjects().add(MS.getSubject(5));
		MSC.getSchoolClass(3).getSubjects().add(MS.getSubject(6));
		MSC.getSchoolClass(3).getSubjects().add(MS.getSubject(10));
		Iterator it = MSC.getSchoolClass(3).getSubjects().iterator();
		while(it.hasNext()) {
	         Subject element = (Subject)it.next();
	         System.out.print(element.getName() + " ");
	      }
	//	@SuppressWarnings("deprecation")
		//Date data = new Date(1999-1900,6,21);
	/*	try {
	//		MSC.addSchoolClass(MT.getTeacherbyPIN("92062410079"), "1C", "2013", "2014");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	ManageStudent MS = new ManageStudent();
		MS.addStudent(MSC.getSchoolClass(3), "Ma�gorzata", "Gawor", "99988877766", "12134", data, "Golkowice 52");
		*/
		
		
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
