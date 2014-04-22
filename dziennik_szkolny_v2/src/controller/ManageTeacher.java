package controller;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import utils.HibernateUtil;
import model.Subject;
import model.Teacher;

public class ManageTeacher extends HibernateDaoSupport{

	
	
/*save teacher*/
public void saveTeacher(Teacher teacher)
{
	getHibernateTemplate().save(teacher);
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
	   
	   public Teacher getTeacher(Integer teacherID){
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
/**Inna metoda na to samo**/
	   public Teacher findByTeacherId(Integer teacherID) {
		   
	        return (Teacher) getHibernateTemplate().load(Teacher.class, teacherID);//przerobic na takie metody ladniejsze jakies :)
	 
	    }
	/*get by pin w innej wersji*/
	   
	   public Teacher findTeacherbyPIN(String Pin)
	   {
	    return (Teacher) getSession().createCriteria(Teacher.class).add(Restrictions.eqOrIsNull("personalIdentityNumber", Pin)).uniqueResult();
	   }
	   
			   public Teacher getTeacherbyPIN(String Pin) throws Exception
			   {
				   Session session = HibernateUtil.getSessionFactory().openSession();
				      Transaction tx = null;
				      Teacher teacher = null;
				      try{
				         tx = session.beginTransaction();	
				         
				         String hql = "FROM Teacher T WHERE T.personalIdentityNumber = "+Pin;
				         Query query = session.createQuery(hql);
				         teacher = (Teacher) query.list().get(0);
				         
				         tx.commit(); 
				         
				      }catch (HibernateException e) {
				         if (tx!=null) tx.rollback();
				         e.printStackTrace(); 
				         throw new NumberFormatException();
				      }finally {
				         session.close(); 
				      }
				         return teacher;
				   
			   }
			   
			   
	   /* Method to GET all teachers from the DB */
	   @SuppressWarnings("unchecked")
	public List<Teacher> getAllTeachers()
	   {
		
		   Session session = HibernateUtil.getSessionFactory().openSession();
		      Transaction tx = null;
		      List<Teacher> teachers = null;
		      try{
		         tx = session.beginTransaction();		      
		         teachers  = (List<Teacher>) session.createQuery("select from Teacher where Teacher.name = ").list();				
		         tx.commit(); 
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		         return teachers;
		   
	   }

}
