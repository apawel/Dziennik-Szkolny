package controller;



import java.sql.Date;

import model.SchoolClass;
import model.Student;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import utils.HibernateUtil;

public class ManageStudent extends HibernateDaoSupport {
	public ManageStudent()
	{
		
	}
	/*save Student*/
	public void saveStudent(Student student)
	{
		getHibernateTemplate().save(student);
		
	}
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
	  
	  public Student getStudentbyPIN(String Pin) throws Exception
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      Student student = null;
		      try{
		         tx = session.beginTransaction();	
		         
		         String hql = "FROM Student T WHERE T.personalIdentityNumber = "+Pin;
		         Query query = session.createQuery(hql);
		         student = (Student) query.list().get(0);				         
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
