package controller;




import java.util.ArrayList;

import model.Student;
import model.StudentNote;
import model.Teacher;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class ManageStudentNote  {
	public ManageStudentNote()
	{
		
	}

	 /* Method to CREATE an StudentNote in the database */
	 static  public Integer addStudentNote(Teacher teacher, Student student, String noteContents){
	      Session session =  HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Integer studentNoteID = null;
	      try{
	         tx = session.beginTransaction();
	         StudentNote studentNote = new StudentNote(teacher, student, noteContents);
	         studentNoteID = (Integer) session.save(studentNote); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return studentNoteID;
	   }
		@SuppressWarnings("unchecked")
		static	public ArrayList<StudentNote> getAllStudentNote()
		   {
			   Session session = HibernateUtil.getSessionFactory().openSession();
			      Transaction tx = null;
			      ArrayList<StudentNote> studentNote = null;
			      try{
			         tx = session.beginTransaction();		      
			         studentNote  = (ArrayList<StudentNote>)session.createQuery("FROM StudentNote").list();				
			         tx.commit(); 
			         
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }
			         return studentNote;
			   
		   }
	 	   /* Method to DELETE an StudentNote from the records */
		static   public void deleteStudentNote(Integer studentNoteID){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         StudentNote studentNote =  (StudentNote)session.get(StudentNote.class,studentNoteID); 
	         session.delete(studentNote); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

}
