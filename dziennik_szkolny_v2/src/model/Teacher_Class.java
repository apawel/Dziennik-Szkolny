package model;

public class Teacher_Class {
	Teacher teacher;
	SchoolClass schoolClass;
	public Teacher_Class(Teacher teacher, SchoolClass schoolClass) {
		super();
		this.teacher = teacher;
		this.schoolClass = schoolClass;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public SchoolClass getSchoolClass() {
		return schoolClass;
	}
	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

}
