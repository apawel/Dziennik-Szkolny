package controller;

import model.Subject;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class ManageSubject {
	/* Method to DELETE an subject from the records */
	   public Integer addSubject(String name){
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

}
