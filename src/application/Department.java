package application;

public class Department implements Comparable<Department> {
	   int ID;
	   String Department;
	   Department(int ID, String Department){
	      this.ID = ID;
	      this.Department = Department;
	   }
	   @Override 
	     public int compareTo(Department dept){
	      return 0;
	   }
	   void setID(int ID){ this.ID = ID;}
	   void setDepartment(String Department){this.Department = Department;}
	   public String toString(){
	      return  ID +  "," + Department; }
	}