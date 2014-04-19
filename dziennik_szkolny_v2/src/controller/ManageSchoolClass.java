package controller;



import java.util.ArrayList;
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
	/*get all schoolclass*/
	public ArrayList<SchoolClass> getAllSchoolClass()
	{
		return  (ArrayList<SchoolClass>) getHibernateTemplate().loadAll(SchoolClass.class);
		
	}
	/*save school class*/
	public void saveSchoolClass(SchoolClass schoolClass)
	{
		getHibernateTemplate().save(schoolClass);
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
	   public ArrayList<SchoolClass> getAllSchoolClassBySubjectID(Integer subjectID)
	   {
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      ArrayList<SchoolClass> klasy = null;
		      try{
		         tx = session.beginTransaction();		      
		         klasy  = ( ArrayList<SchoolClass>) session.createQuery("select from SchoolClass_has_Subject T WHERE T.Subject_idSubject = "+subjectID).list();				
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
		   getHibernateTemplate().update(schoolClass);//konieczny test z takim updatem
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
		    	  String hql = "FROM SchoolClass T WHERE T.ClassMaster_idTeacher = "+teacherID;
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
