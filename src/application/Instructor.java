package application;

public class Instructor implements Comparable<Instructor> {
	   int ID;
	   String Name, department;
	   Instructor(int ID, String Name, String Department){
	      this.department = Department;
	      this.Name =Name;
	      this.ID = ID;
	   }
	   @Override 
	     public int compareTo(Instructor instructor){
	      return 0;
	   }
	   void setID(int ID){ this.ID = ID;}
	   void setName(String Name){ this.Name = Name; }
	   void setDepartment(String Department){this.department = Department;}
	   public String toString(){
	      return  ID + "," + Name + "," + department; }
	}