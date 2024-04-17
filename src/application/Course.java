package application;

public class Course implements Comparable<Course>{
	   int courseID;
	   String name, description, dept,instructor;
	   Course(int courseID, String name, String description,String dept, String instructor){
	      this.courseID = courseID;
	      this.name = name;
	      this.description = description;
	      this.dept = dept;
	      this.instructor = instructor;
	   }
	   @Override 
	     public int compareTo(Course cour){
	      return 0;
	   }
	   void setID(int courseID){ this.courseID = courseID;}
	   void setName(String name){ this.name = name; }
	   void setDescription(String description){this.description = description;}
	   public String toString(){
	      return  courseID + "," + name + "," + description +","+ dept + ","+ instructor;
	   }
	}