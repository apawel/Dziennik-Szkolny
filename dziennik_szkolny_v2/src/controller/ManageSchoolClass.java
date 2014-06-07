package controller;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.SchoolClass;
import model.Subject;
import model.Teacher;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import utils.HibernateUtil;

public class ManageSchoolClass extends HibernateDaoSupport{
	public ManageSchoolClass()
	{		
	}
	
	
	

	/*save school class*/
	public void saveSchoolClass(SchoolClass schoolClass)
	{
		getHibernateTemplate().update(schoolClass);
	}
	 /* Method to CREATE an SchoolClass in the database */
	   public Integer addSchoolClass(Teacher teacher, String name, String yearStart,String yearEnd){
	      Session session =  HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      Integer schoolClassID = null;
	      try{
	         tx = session.beginTransaction();
	         SchoolClass schoolClass = new SchoolClass(teacher, name, yearStart, yearEnd);
	         schoolClassID = (Integer) session.save(schoolClass); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return schoolClassID;
	   }
	
	   
	   
	   /**GET all Schoolclass by subject   zwraca NULLa czemu?....... createcriteria restrictions eqaul.*/
	   /*nie chce to dzialac*/
	   @SuppressWarnings("unchecked")
	public ArrayList<SchoolClass> getAllSchoolClassBySubjectID(Integer subjectID)
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      ArrayList<SchoolClass> klasy = null;
		      try{
		         tx = session.beginTransaction();         
		         
		         
		         klasy  = ( ArrayList<SchoolClass>) session.createQuery("FROM SchoolClass T WHERE T.subjects.idSubject = "+subjectID).list();				
		         tx.commit(); 
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return klasy;
	   
	   }
	   
	   
	   /*to co wyzej ale inaczej*/
	   public ArrayList<SchoolClass> getAllSchoolClassBySubject(Integer subjectID)
	   {
		   ArrayList list = (ArrayList) getSession().createCriteria(SchoolClass.class)
	                .add(Restrictions.eq("Subject.idSubject", subjectID))
	                .list();
		   Iterator it = (Iterator) list.iterator();
			for(int i =0;i<list.size();i++)
			{
			
				System.out.println("Klasa: " + ((SchoolClass) list.get(i)).getName());
			}
	 
	        return list;   
	   }
	   public SchoolClass getSchoolClass(Integer schoolClassID){
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      SchoolClass schoolClass = null;
		      try{
		         tx = session.beginTransaction();
		         schoolClass =  (SchoolClass)session.get(SchoolClass.class, schoolClassID); 		
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return schoolClass;
		      
	   }
	   /**
	    * Musze pomyslec jak do klasy dodac jej przedmioty i odrazu UPDATE bazy
	    * @param teacherID
	    * @return
	    */
	

	static   public void updateSchoolClass(SchoolClass schoolClass)
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;		   
		      try{
		         tx = session.beginTransaction();
		         session.update(schoolClass); 		
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
	   }
	   
	   public SchoolClass getSchoolClassbyTeacherID(Integer teacherID){
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      SchoolClass schoolClass = null;
		      try{
		    	  String hql = "FROM SchoolClass T WHERE T.teacher = "+teacherID;
			         Query query = session.createQuery(hql);
			         schoolClass = (SchoolClass) query.list().get(0);	         
			       
		         tx = session.beginTransaction();	
		         tx.commit();
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return schoolClass;
		      
	   }
		@SuppressWarnings("unchecked")
		static public ArrayList<SchoolClass> getAllSchoolClasses()
		   {
			
			   Session session = HibernateUtil.getSessionFactory().openSession();
			      Transaction tx = null;
			      ArrayList<SchoolClass> schoolclass = null;
			      try{
			         tx = session.beginTransaction();		      
			         schoolclass  = (ArrayList<SchoolClass>) session.createQuery("FROM SchoolClass").list();				
			         tx.commit(); 
			         
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }
			  
			         return schoolclass;
			   
		   }
	   
	   /* Method to DELETE an SchoolClass from the records */
	   public void deleteSchoolClass(Integer schoolClassID){
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         SchoolClass schoolClass =  (SchoolClass)session.get(SchoolClass.class,schoolClassID); 
	         session.delete(schoolClass); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

}
