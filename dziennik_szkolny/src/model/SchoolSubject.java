package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author Pawel
 * 
 */
@Entity
public class SchoolSubject {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subjectId")
	private int subjectId;
	/**
	 * 
	 */
	@Column(name = "name")
	private String name;
	//
	/**
	 * 
	 */
	@ManyToOne
	private Teacher teacher;
	/**
	 * 
	 */
	@OneToMany
	private Collection<SubjectMark> subjectmarks = new ArrayList<>();

	/**
	 * 
	 * @return
	 */
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
