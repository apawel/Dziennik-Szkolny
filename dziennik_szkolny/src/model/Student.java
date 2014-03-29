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
public class Student {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentId")
	private int studentId;
	/**
	 * 
	 */

	@Column(name = "firstName")
	private String firstName;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}

	public void setPersonalIdentityNumber(String personalIdentityNumber) {
		this.personalIdentityNumber = personalIdentityNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SchoolClass getSchoolclass() {
		return schoolclass;
	}

	public void setSchoolclass(SchoolClass schoolclass) {
		this.schoolclass = schoolclass;
	}

	/**
	 * 
	 */
	@Column(name = "lastName")
	private String lastName;
	/**
	 * 
	 */
	@Column(name = "personalIdentityNumber")
	private String personalIdentityNumber;
	/**
	 * 
	 */
	@Column(name = "password")
	private String password;
	/**
	 * 
	 *
	 */
	@ManyToOne
	private SchoolClass schoolclass;
	/**
	 * 
	 */
	
	@OneToMany
	private Collection<SubjectMark> subjectsMark = new ArrayList<>();
	

	

}
