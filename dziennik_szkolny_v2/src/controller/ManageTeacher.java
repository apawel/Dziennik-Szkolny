package controller;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import model.Subject;
import model.Teacher;

public class ManageTeacher {
public ManageTeacher()
{
	
}
	
	
	 /* Method to CREATE an teacher in the database */
	   public Integer addTeacher(Subject subject, String firstName, String lastName,
				String personalIdentityNumber, String password, String address){
	      Session session =  HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Integer teacherID = null;
	      try{
	         tx = session.beginTransaction();
	         Teacher teacher = new Teacher(subject, firstName, lastName, personalIdentityNumber, password, address);
	         teacherID = (Integer) session.save(teacher); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return teacherID;
	   }
	
	   /* Method to DELETE an teacher from the records */
	   public void deleteTeacher(Integer teacherID){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Teacher teacher =  (Teacher)session.get(Teacher.class, teacherID); 
	         session.delete(teacher); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	   /* Method to GET an teacher from the records */
	   public Teacher getSubject(Integer teacherID){
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      Teacher teacher = null;
		      try{
		         tx = session.beginTransaction();
		         teacher =  (Teacher)session.get(Teacher.class, teacherID); 		
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return teacher;
		      
	   }

}
