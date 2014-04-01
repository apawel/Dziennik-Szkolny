package controller;

import java.util.Date;

import model.SchoolClass;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class ManageStudent {
	/* Method to DELETE an student from the records */
	  public Integer addStudent(SchoolClass schoolClass, String firstName, String lastName,
				String personalIdentityNumber, String password, Date dateOfBirth,
				String address){
	      Session session =  HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Integer studentID = null;
	      try{
	         tx = session.beginTransaction();
	         Student student = new Student(schoolClass, firstName, lastName, personalIdentityNumber, password, dateOfBirth, address);
	         studentID = (Integer) session.save(student); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return studentID;
	   }
	
	   /* Method to DELETE an student from the records */
	   public void deleteStudent(Integer studentID){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Student student =  (Student)session.get(Student.class, studentID); 
	         session.delete(student); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

}
