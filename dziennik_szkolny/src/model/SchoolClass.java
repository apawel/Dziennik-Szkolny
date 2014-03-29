package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Pawel
 * 
 */
@Entity(name = "SchoolClass")
public class SchoolClass {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "classId")
	private int classId;
	/**
	 * 
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 
	 */
	@Column(name = "yearStart")
	@Temporal(TemporalType.DATE)
	private Date yearStart;
	/**
	 * 
	 */
	@Column(name = "yearStop")
	@Temporal(TemporalType.DATE)
	private Date yearStop;
	//
	
	
	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	@OneToMany(mappedBy = "schoolclass")
	private Collection<Student> students = new ArrayList<>();
	

	/**
	 * 
	 */
	/**
	 * 
	 * @return
	 */
	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getYearStart() {
		return yearStart;
	}

	public void setYearStart(Date yearStart) {
		this.yearStart = yearStart;
	}

	public Date getYearStop() {
		return yearStop;
	}

	public void setYearStop(Date yearStop) {
		this.yearStop = yearStop;
	}

	/*public Teacher getClassMaster() {
		return classMaster;
	}

	public void setClassMaster(Teacher classMaster) {
		this.classMaster = classMaster;
	}*/
}
