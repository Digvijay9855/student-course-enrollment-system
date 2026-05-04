package model;

public class Enrollment {
	private Student student;
    private Course course;
    
    //getter and setter 
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	//tostring method
	@Override
	public String toString() {
		return "Enrollment [student=" + student + ", course=" + course + "]";
	}
	
	//param constructor
	public Enrollment(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}
}
