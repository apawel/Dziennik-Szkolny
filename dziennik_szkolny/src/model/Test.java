package model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.SetSimpleValueTypeSecondPass;

public class Test {

	public static void main(String[] args) {
		Teacher teacher_0 = new Teacher();
		teacher_0.setFirstName("Lucyna");
		teacher_0.setLastName("Musia³");
		teacher_0.setPersonalIdentityNumber("01234567891");
		teacher_0.setPassword("01234567891");
		//
		Teacher teacher_1 = new Teacher();
		teacher_1.setFirstName("Anna");
		teacher_1.setLastName("Mrukowicz");
		teacher_1.setPersonalIdentityNumber("12345678901");
		teacher_1.setPassword("12345678901");
		//
		SchoolSubject schoolSubject_0 = new SchoolSubject();
		schoolSubject_0.setName("Jêzyk Polski");
		schoolSubject_0.setTeacher(teacher_0);
		//
		SchoolSubject schoolSubject_1 = new SchoolSubject();
		schoolSubject_1.setName("Matematyka");
		schoolSubject_1.setTeacher(teacher_1);
		//
		SchoolSubject schoolSubject_2 = new SchoolSubject();
		schoolSubject_2.setName("Fizyka");
		schoolSubject_2.setTeacher(teacher_1);
		
		SchoolClass schoolClass_0 = new SchoolClass();
		schoolClass_0.setName("B2");
		schoolClass_0.setYearStart(new Date(2013, 9, 1));
		schoolClass_0.setYearStop(new Date(2014, 06, 24));
		
		teacher_0.setSchoolclass(schoolClass_0);

		
	/*	teacher_0.getSchoolSubjects().add(schoolSubject_0);
		teacher_0.getSchoolSubjects().add(schoolSubject_1);
		teacher_1.getSchoolSubjects().add(schoolSubject_1);*/
		
		Student student_0 = new Student();
		student_0.setFirstName("Przemek");
		student_0.setLastName("Ja");
		student_0.setPersonalIdentityNumber("12345678901");
		student_0.setPassword("12345678901");
		student_0.setSchoolclass(schoolClass_0);
		
		Student student_1 = new Student();
		student_1.setFirstName("Pawe³");
		student_1.setLastName("Wojciechowski");
		student_1.setPersonalIdentityNumber("12345678901");
		student_1.setPassword("12345678901");
		student_1.setSchoolclass(schoolClass_0);
		
		schoolClass_0.getStudents().add(student_0);
		schoolClass_0.getStudents().add(student_1);
		
		
		
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionfactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionfactory.openSession();
		
		session.beginTransaction();
		 session.save(teacher_0);
		 session.save(teacher_1);
		 session.save(student_0);
		 session.save(student_1);		 
		 session.save(schoolClass_0);
		 session.save(schoolSubject_0);
		 session.save(schoolSubject_1);
		 
		 
		 session.getTransaction().commit();
		 session.close();

	}
}
