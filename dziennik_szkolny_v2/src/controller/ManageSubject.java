package controller;

import java.util.ArrayList;

import model.SchoolClass;
import model.Subject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import utils.HibernateUtil;

public class ManageSubject extends HibernateDaoSupport {
	
	public ManageSubject()
	{
		
	}
	/*save Subject*/
	public void saveSubject(Subject subject)
	{
		getHibernateTemplate().save(subject);
	}
	/*get all Subjects*/
	/*public ArrayList<Subject> getAllSubjects()
	{
		return  (ArrayList<Subject>) getHibernateTemplate().loadAll(Subject.class);
		
	}*/
	/* Method to DELETE an subject from the records */
	static   public Integer addSubject(String name){
	      Session session =  HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Integer subjectID = null;
	      try{
	         tx = session.beginTransaction();
	         Subject subject = new Subject(name);
	         subjectID = (Integer) session.save(subject); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return subjectID;
	   }
	
	   /* Method to DELETE an subject from the records */
	   public void deleteSubject(Integer subjectID){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Subject subject =  (Subject)session.get(Subject.class, subjectID); 
	         session.delete(subject); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	  @SuppressWarnings("unchecked")
	static public ArrayList<Subject> getAllSubjects()
	   {
		
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      ArrayList<Subject> subjects = null;
		      try{
		         tx = session.beginTransaction();		      
		         subjects  =  (ArrayList<Subject>) session.createQuery("FROM Subject").list();				
		         tx.commit(); 
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return subjects;
		   
	   }
	   
	   public Subject getSubject(Integer subjectID){
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      Subject subject = null;
		      try{
		         tx = session.beginTransaction();
		         subject =  (Subject)session.get(Subject.class, subjectID); 
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return subject;
		      
	   }
	static   public void updateSubject(Subject subject)
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;		   
		      try{
		         tx = session.beginTransaction();
		         session.update(subject); 		
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	   }
	 /*  
	   public Subject getSubject(String name){
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      Subject subject = null;
		      try{
		         tx = session.beginTransaction();
		         subject =  (Subject)session.get(Subject.class, subjectID); 
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return subject;
		      
	   }*/

}
