package controller;
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
		ManageTeacher MT = new ManageTeacher();
		Teacher test = null;
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
