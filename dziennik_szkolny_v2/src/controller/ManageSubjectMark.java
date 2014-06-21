package controller;

import java.util.ArrayList;

import model.Student;
import model.Subject;
import model.SubjectMark;
import model.Teacher;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class ManageSubjectMark  {
	public ManageSubjectMark()
	{
		
	}
	



	 /* Method to CREATE an SubjectMark in the database */
	  static public Integer addSubjectMark(Student student, Subject subject, double value, int weight,
				String description){
	      Session session =  HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Integer subjectMarkID = null;
	      try{
	         tx = session.beginTransaction();
	         SubjectMark  subjectMark = new SubjectMark(student, subject, value, weight, description);
	         subjectMarkID = (Integer) session.save( subjectMark); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return  subjectMarkID;
	   }
	   @SuppressWarnings("unchecked")
	   static public ArrayList<SubjectMark> getAllSubjectMark()
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      ArrayList<SubjectMark> subjectMarks = null;
		      try{
		         tx = session.beginTransaction();		      
		         subjectMarks  = (ArrayList<SubjectMark>)session.createQuery("FROM SubjectMark").list();				
		         tx.commit(); 
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return subjectMarks;
		   
	   }
	
	   /* Method to DELETE an SubjectMark from the records */
	   static   public void deleteSubjectMark(Integer subjectMarkID){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         SubjectMark subjectMark =  (SubjectMark)session.get(Teacher.class, subjectMarkID); 
	         session.delete(subjectMark); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

}
