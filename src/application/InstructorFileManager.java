package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.collections.*;

public class InstructorFileManager {
	   String filename;
	   MyGenericList<Instructor> instructors = new MyGenericList<Instructor>();// arrayList<Enrollment>

	    //Constructure
	   InstructorFileManager(String filename){
	      try{
	         this.filename = filename;
	         File file = new File(filename);
	         Scanner FileScanner = new Scanner(file); //Create File scanner
	         //Read File line by line
	         if (file.exists()){
	            while (FileScanner.hasNext()){ 
	               String line = FileScanner.nextLine();//read next line
	               String[] I = line.split(",");//Split line into a string array
	             //Asign the element of array to variables
	               int ID = Integer.parseInt(I[0]);
	               String name = I[1];
	               String department = I[2];
	             //Create course object using variables
	               Instructor Inst= new Instructor(ID, name, department);
	               instructors.add(Inst); 
	            }
	            FileScanner.close();
	         }
	      }
	      catch(IOException ioe){
	         System.out.println("Error" + ioe.getMessage());
	      }
	   }

	   boolean addInstructor(int ID, String Name, String department)throws IOException, EmptyFieldException {
	       //If Enrollment does not exsist then add it to the arraylist and return true
	      if( department==null || Name.equals("") ){
	         throw new EmptyFieldException("One or more fields are empty");
	      }
	      else{
	         if (GetInstructor(ID) == null){
	            Instructor inst= new Instructor(ID,Name, department);
	            instructors.add(inst);

	           //Append the new course object to the file
	            FileWriter fwriter = new FileWriter(filename,true); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            outputFile.println(inst);
	            outputFile.close();

	            System.out.println("Instructor Has Been Added");
	            return true;
	         }
	         System.out.println("Instructor Already Exists");
	         return false;
	      }
	   }

	   Instructor GetInstructor(int ID) throws EmptyFieldException, IOException{
	      for(int i =0; i< instructors.count; i++){
	         Instructor current = instructors.get(i);
	         int id = current.ID;
	         if(ID == id){ 
	            return current;
	         }
	      }
	      return null;
	   }

	   boolean AddInstructor(int ID,String Name, String department)throws EmptyFieldException, IOException{
	      if (department == null||Name.equals("")){
	         throw new EmptyFieldException("one or More Field are Empty");
	      }
	      else{
	      //If Enrollment does not exsist then add it to the arraylist and return true
	         if (GetInstructor(ID) == null){
	            Instructor inst= new Instructor( ID, Name,  department);
	            instructors.add(inst);

	              //Append the new course object to the file
	            FileWriter fwriter = new FileWriter(filename,true); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            outputFile.println(inst);
	            outputFile.close();

	            System.out.println("Instructors Has Been Added");
	            return true; 
	         }
	         else {
	            System.out.println("Instructors already Exist");
	            return false;
	         }
	      }

	   }

	   boolean updateInstructor(int ID, String Name,  String department)throws IOException, EmptyFieldException{
	      if (department == null||Name.equals("")){
	         throw new EmptyFieldException("one or More Field are Empty");
	      }
	      else{
	         if (GetInstructor(ID) != null){
	            Instructor inst = GetInstructor(ID);
	            inst.department = department;
	            inst.Name = Name;
	            instructors.add(ID, inst);
	            instructors.delete(ID);

	            FileWriter fwriter = new FileWriter(filename); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            for (int i = 0; i < instructors.count; i++){
	               outputFile.println(instructors.get(i));  
	            }
	            outputFile.close();
	            System.out.println("Enrollment Has Been Updated");
	            return true;
	         }
	         else {
	            System.out.println("Enrollment Does Not Exist");
	            return false;
	         }
	      }

	   } 
	  ObservableList<String> GetInstructorByDeparment(String Deparment) throws EmptyFieldException {
	    ObservableList<String> InstuctorByDeparment = FXCollections.observableArrayList();
	    if (Deparment == null ||Deparment.equals("")){
	      throw new EmptyFieldException("One or more fields are empty");
	    }
	    else{
	      for(int i =0; i< instructors.count; i++){
	         Instructor current = instructors.get(i);
	         String department = current.department;
	         if(department.equals(Deparment)){ 
	            InstuctorByDeparment.add(current.Name);
	         }
	      }
	    }
	      return InstuctorByDeparment;
	 
	  }
	}