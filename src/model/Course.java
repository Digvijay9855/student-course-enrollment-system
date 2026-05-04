package model;

public class Course {
	private int id;
    private String name;
    private Instructor instructor;
    
    //tostring 
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", instructor=" + instructor + "]";
	}
	
	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	//param constructor
	public Course(int id, String name, Instructor instructor) {
		super();
		this.id = id;
		this.name = name;
		this.instructor = instructor;
	}
}
