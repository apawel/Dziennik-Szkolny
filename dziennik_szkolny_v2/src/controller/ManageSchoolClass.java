package controller;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

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
	/*get all schoolclass*/
	public ArrayList<SchoolClass> getAllSchoolClass()
	{
		return  (ArrayList<SchoolClass>) getHibernateTemplate().loadAll(SchoolClass.class);
		
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
	                .add(Restrictions.eq("Subject.idSubject", subjectID))//nie pamietam jak jest  w bazie sprawdzic konieczne.....
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
	   public void updateSchoolClass(SchoolClass schoolClass)
	   {
			System.out.println("jestem klasa : " + schoolClass.getName() + " W update.");
		   getHibernateTemplate().update("schoolclass", schoolClass);
	   }

	   public void updateDB(SchoolClass schoolClass)
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
		public List<SchoolClass> getAllSchoolClasses()
		   {
			
			   Session session = HibernateUtil.getSessionFactory().openSession();
			      Transaction tx = null;
			      List<SchoolClass> teachers = null;
			      try{
			         tx = session.beginTransaction();		      
			         teachers  = (List<SchoolClass>) session.createQuery("FROM SchoolClass ").list();				
			         tx.commit(); 
			         
			      }catch (HibernateException e) {
			         if (tx!=null) tx.rollback();
			         e.printStackTrace(); 
			      }finally {
			         session.close(); 
			      }
			  
			         return teachers;
			   
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
