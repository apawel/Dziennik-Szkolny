package model;

// Generated 2014-04-01 13:32:49 by Hibernate Tools 4.0.0


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * SchoolClass generated by hbm2java
 */
public class SchoolClass implements java.io.Serializable {

	private Integer idSchoolClass;
	private Teacher teacher;
	private String name;
	private String yearStart;
	private String yearEnd;
	private Set<Subject> subjects = new HashSet<Subject>();
	private Set<Student> students = new HashSet<Student>();

	public SchoolClass() {
	}
	  public void saveListOfStudentsToFile()
	   { 
		   try {
			PrintWriter zapis = new PrintWriter(this.getName() + ".txt");
			Iterator<Student> it = this.getStudents().iterator();
			while(it.hasNext())
			{
				Student student = it.next();
			zapis.println("Imi� i nazwisko: " + student.getFirstName() + " " + student.getLastName() + " Adres: " + student.getAddress() + " Data urodzenia: " + student.getDateOfBirth());

			}
			zapis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   }
	public SchoolClass(Teacher teacher, String name, String yearStart,
			String yearEnd) {
		this.teacher = teacher;
		this.name = name;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.subjects=null;
		this.students=null;
	}

	public SchoolClass(Teacher teacher, String name, String yearStart,
			String yearEnd, Set<Subject> subjects, Set<Student> students) {
		this.teacher = teacher;
		this.name = name;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		this.subjects = subjects;
		this.students = students;
	}

	public Integer getIdSchoolClass() {
		return this.idSchoolClass;
	}

	public void setIdSchoolClass(Integer idSchoolClass) {
		this.idSchoolClass = idSchoolClass;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearStart() {
		return this.yearStart;
	}

	public void setYearStart(String yearStart) {
		this.yearStart = yearStart;
	}

	public String getYearEnd() {
		return this.yearEnd;
	}

	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}

	public Set<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
