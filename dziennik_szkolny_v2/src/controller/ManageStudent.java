package controller;



import java.sql.Date;
import java.util.ArrayList;

import model.SchoolClass;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import utils.HibernateUtil;

public class ManageStudent  {
	public ManageStudent()
	{
		
	}
	  public Student getStudentbyId(Integer studentID){
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      Student student = null;
		      try{
		         tx = session.beginTransaction();
		         student =  (Student)session.get(Student.class, studentID); 		
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return student;
		      
	   }
	  static   public void updateStudent(Student student)
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;		   
		      try{
		         tx = session.beginTransaction();
		         session.update(student); 		
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	   }
	  @SuppressWarnings("unchecked")
	static public ArrayList<Student> getAllStudents()
	   {
		
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      ArrayList<Student> students = null;
		      try{
		         tx = session.beginTransaction();		      
		         students  = (ArrayList<Student>) session.createQuery("FROM Student").list();				
		         tx.commit(); 
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return students;
		   
	   }
	  
	/* Method to DELETE an student from the records */
	  public static Integer addStudent(SchoolClass schoolClass, String firstName, String lastName,
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
	  
	  public static Student getStudentbyPIN(String Pin) throws Exception
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      Student student = null;
		      try{
		         tx = session.beginTransaction();	
		         
		        /* String hql = "FROM Student T WHERE T.personalIdentityNumber = "+Pin;
		         Query query = session.createQuery(hql);
		         student = (Student) query.list().get(0);*/
		         student = (Student) session.createCriteria(Student.class).add(Restrictions.eqOrIsNull("personalIdentityNumber", Pin)).uniqueResult();
		         tx.commit(); 
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		         throw new NumberFormatException();
		      }finally {
		         session.close(); 
		      }
		         return student;
		   
	   }
	
	   /* Method to DELETE an student from the records */
	   public static void deleteStudent(Integer studentID){
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
