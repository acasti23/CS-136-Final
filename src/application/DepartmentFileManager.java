package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DepartmentFileManager {
	   String filename;
	   MyGenericList<Department> departments = new MyGenericList<Department>();

	    //Constructure
	   DepartmentFileManager(String filename){
	      try{
	         this.filename = filename;
	         File file = new File(filename);
	         Scanner FileScanner = new Scanner(file); //Create File scanner
	         //Read File line by line
	         if (file.exists()){
	            while (FileScanner.hasNext()){ 
	               String line = FileScanner.nextLine();//read next line
	               String[] d = line.split(",");//Split line into a string array
	             //Asign the element of array to variables
	               int ID = Integer.parseInt(d[0]);
	               String department = d[1];
	             //Create course object using variables
	               Department depart= new Department( ID, department);
	               departments.add(depart);//Add course Object to array list 
	            }
	            FileScanner.close();
	         }
	      }
	      catch(IOException ioe){
	         System.out.println("Error" + ioe.getMessage());
	      }
	   }

	   boolean addDepartment(int ID, String department)throws IOException, EmptyFieldException {
	       //If Enrollment does not exsist then add it to the arraylist and return true
	      if( department==null ){
	         throw new EmptyFieldException("department is empty");
	      }
	      else{
	         if (GetDepartment(ID) == null){
	            Department depart= new Department( ID, department);
	            departments.add(depart);

	           //Append the new course object to the file
	            FileWriter fwriter = new FileWriter(filename,true); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            outputFile.println(depart);
	            outputFile.close();

	            System.out.println("Department Has Been Added");
	            return true;
	         }
	         System.out.println("Department Already Exists");
	         return false;
	      }
	   }

	   Department GetDepartment(int ID) throws EmptyFieldException, IOException{
	      for(int i =0; i< departments.count; i++){
	         Department current = departments.get(i);
	         int id = current.ID;
	         if(ID == id){ 
	            return current;
	         }
	      }
	      return null;
	   }

	   boolean AddDepartment(int ID,String department)throws EmptyFieldException, IOException{
	      if (department == null){
	         throw new EmptyFieldException("Department Field is Empty");
	      }
	      else{
	        //If Enrollment does not exsist then add it to the arraylist and return true
	         if (GetDepartment(ID) == null){
	            Department depart= new Department( ID, department);
	            departments.add(depart);

	              //Append the new course object to the file
	            FileWriter fwriter = new FileWriter(filename,true); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            outputFile.println(depart);
	            outputFile.close();

	            System.out.println("Department Has Been Added");
	            return true; 
	         }
	         else {
	            System.out.println("Department already Exist");
	            return false;
	         }
	      }
	   }
	   boolean updateDepartment(int ID, String department)throws IOException, EmptyFieldException{

	      if (department == null ){
	         throw new EmptyFieldException("Department Fields Are Empty");
	      }
	      else{
	         if (GetDepartment(ID) != null){
	            Department depart = GetDepartment(ID);
	            depart.Department = department;	
	            departments.add(ID, depart);
	            departments.delete(ID);

	            FileWriter fwriter = new FileWriter(filename); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            for (int i = 0; i < departments.count; i++){
	               outputFile.println(departments.get(i));  
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
	}