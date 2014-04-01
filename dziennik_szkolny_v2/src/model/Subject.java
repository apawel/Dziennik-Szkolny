package model;

// Generated 2014-04-01 13:32:49 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Subject generated by hbm2java
 */
public class Subject implements java.io.Serializable {

	private Integer idSubject;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>(0);
	private Set<SubjectMark> subjectMarks = new HashSet<SubjectMark>(0);
	private Set<SchoolClass> schoolClasses = new HashSet<SchoolClass>(0);

	public Subject() {
	}

	public Subject(String name) {
		this.name = name;
	}

	public Subject(String name, Set<Teacher> teachers,
			Set<SubjectMark> subjectMarks, Set<SchoolClass> schoolClasses) {
		this.name = name;
		this.teachers = teachers;
		this.subjectMarks = subjectMarks;
		this.schoolClasses = schoolClasses;
	}

	public Integer getIdSubject() {
		return this.idSubject;
	}

	public void setIdSubject(Integer idSubject) {
		this.idSubject = idSubject;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<SubjectMark> getSubjectMarks() {
		return this.subjectMarks;
	}

	public void setSubjectMarks(Set<SubjectMark> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

	public Set<SchoolClass> getSchoolClasses() {
		return this.schoolClasses;
	}

	public void setSchoolClasses(Set<SchoolClass> schoolClasses) {
		this.schoolClasses = schoolClasses;
	}

}
