package controller;
import model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
	
		Nauczyciel naucz1 = new Nauczyciel();
		naucz1.setImie("Pawe³");
		naucz1.setNazwisko("Wojciechowski");
		naucz1.setPesel("92062410079");
		naucz1.setHaslo("92062410078");

		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
	 session.beginTransaction();
        session.save(naucz1);
		session.getTransaction().commit();
		session.close();

	}

}
