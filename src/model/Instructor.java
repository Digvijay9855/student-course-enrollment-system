package model;

public class Instructor {
	  private int id;
	    private String name;
	    
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
		
		//tostring method
		@Override
		public String toString() {
			return "Instructor [id=" + id + ", name=" + name + "]";
		}
		
		//para constructor
		public Instructor(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}	
}
