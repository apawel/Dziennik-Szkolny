package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Pawel
 * 
 */
@Entity
public class Teacher {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "teacherId")
	private int teacherId;
	/**
	 * 
	 */
	@Column(name = "firstName")
	private String firstName;
	/**
	 * 
	 */
	@Column(name = "lastName")
	private String lastName;
	public SchoolClass getSchoolclass() {
		return schoolclass;
	}

	public void setSchoolclass(SchoolClass schoolclass) {
		this.schoolclass = schoolclass;
	}

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
	 */
	@OneToOne
	private SchoolClass schoolclass;
	/**
	 * Przedmioty prowadzone przez nauczyciela
	 */
	//@OneToMany(mappedBy = "teacher")
	//private Collection<SchoolSubject> schoolSubjects = new ArrayList<>();

	/**
	 * 
	 */
	/**
	 * 
	 * @return
	 */
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	/*public Collection<SchoolSubject> getSchoolSubjects() {
		return schoolSubjects;
	}

	public void setSchoolSubjects(Collection<SchoolSubject> schoolSubjects) {
		this.schoolSubjects = schoolSubjects;
	}*/

}
