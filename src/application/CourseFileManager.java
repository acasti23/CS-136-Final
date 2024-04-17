package application;

import java.util.Scanner;
import java.io.*;


public class CourseFileManager{
	   MyGenericList<Course> courses = new MyGenericList<Course>(); // arrayList<Courset>
	   String filename; 
	    //Constructor
	   CourseFileManager(String filename){
	      try{
	         this.filename = filename;
	         File file = new File(filename);
	         Scanner FileScanner = new Scanner(file); //Create File scanner
	         //Read File line by line
	         if (file.exists()){
	            while (FileScanner.hasNext()){ 
	               String line = FileScanner.nextLine();//read next line
	               String[] c = line.split(",");//Split line into a string array
	             //Asign the element of array to variables
	               int courseId = Integer.parseInt(c[0]);
	               String courseName = c[1];
	               String courseDescription = c[2];
	              String courseDept = c[3];
	              String courseInstructor = c[4];
	             //Create course object using variables
	               Course course = new Course(courseId, courseName, courseDescription, courseDept,courseInstructor);
	               courses.add(course);//Add course Object to array list 
	            }
	            FileScanner.close();
	         }
	      }
	      catch(IOException e){
	         System.out.println("Error: " + e.getMessage());
	      }
	   }
	   Course GetCourse(int cid)throws EmptyFieldException, IOException{
	       //try{  
	      if(cid == 0){
	         throw new EmptyFieldException("Invalid Course ID");
	      }
	      else{
	         for(int i = 0; i < courses.count; i++){
	            Course current = courses.get(i);
	            int ID = current.courseID;
	            if (ID==cid)        
	               return current;
	         }
	      }
	      return null;

	   }
	   boolean AddCourse(int CID, String courseName, String courseDescrip, String dept, String instructor)throws EmptyFieldException, IOException{
	       if (GetCourse(CID) == null){
	         if(courseName.equals("")||courseDescrip.equals("")||dept == null || instructor == null){
	            throw new EmptyFieldException("Course ID Field is Blank");
	         }
	         else{
	            Course cour = new Course(CID, courseName, courseDescrip, dept, instructor);
	            courses.add(cour);

	           //Append the new course object to the file
	            FileWriter fwriter = new FileWriter(filename,true); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            outputFile.println(cour);
	            outputFile.close();

	            System.out.println("Course has been added");//Confirmation Statement
	            return true;
	         }
	      }
	      else {//If the course already exist then display an error message and return false
	         System.out.println("Course Already Exists");
	         return false;
	      }
	   }

	   boolean updateCourse(int cid, String courName, String courseDescription,String dept,String instructor)throws IOException,EmptyFieldException{
	      if (courName.equals("")|| courseDescription.equals("")||dept == null||instructor == null ) {
	         throw new EmptyFieldException("One or more fields are blank");
	      }
	      //Check if course exists, if it does then update the course object and return true
	      if (GetCourse(cid) != null){
	         Course cour = GetCourse(cid);
	         cour.setID(cid);
	         cour.setName(courName);
	         cour.setDescription(courseDescription);
	        cour.dept = dept;
	         courses.add(cid, cour);//replace cour
	         courses.delete(cid);
	         FileWriter fwriter = new FileWriter(filename); 
	         PrintWriter outputFile = new PrintWriter(fwriter);
	         for (int i = 0; i < courses.count; i++){
	            outputFile.println(courses.get(i));  
	         }
	         outputFile.close();
	         System.out.println("Course Has Been Updated");
	         return true;
	      }
	      System.out.println("Course Does Not Exist");
	      return false;
	   }
	}