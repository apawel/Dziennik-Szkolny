package model;

public class Student_Teacher {
	Student student;
	Teacher teacher;
	public Student_Teacher(Student student, Teacher teacher) {		
		this.student = student;
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
