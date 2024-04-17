package application;
import java.util.Scanner;
import java.io.*;

public class StudentFileManager{
	  String filename;
	  MyGenericList<Student> student = new MyGenericList<Student>();// arrayList<Student>

	  StudentFileManager(String filename){//constuctor //cs136
	    try{
	      File file = new File(filename);
	      this.filename = filename;
	       Scanner FileScanner = new Scanner(file); //Create File scanner
	        //Read File line by line
	        while (FileScanner.hasNext()){ 
	          String line = FileScanner.nextLine();//read next line
	          String[] s = line.split(",");//Split line into a string array
	           //Asign the element of array to variables
	          int sid = Integer.parseInt(s[0]);
	          String firstname = s[1];
	          String lastname = s[2];
	          String address = s[3];
	          String city = s[4];
	          String state = s[5];
	          String zip = s[6];
	          //Create Student object using variables
	          Student stud = new Student(sid, firstname, lastname, address, city, state, zip);
	          student.add(stud);//Add Student Object to array list  
	        }
	      FileScanner.close();
	    }
	    catch(IOException ioe){
	      System.out.println("Error: " + ioe.getMessage());
	    }
	  }
	  boolean AddStudent(int ID, String FirstName,String LastName, String Address, String City, String State, String Zip)throws EmptyFieldException, IOException{
	      if (GetStudent(ID) == null){
	        if( FirstName.equals("") || LastName.equals("") || Address.equals("") || City.equals("") || State == null || Zip.equals("")){
	          throw new EmptyFieldException("One or More Fields Are Empty");
	        }
	        else{
	          //If Student ID does not exist then it will add Student to arraylist
	          Student stud = new Student(ID, FirstName, LastName, Address, City, State, Zip);
	          student.add(stud);

	          //Append Student info to file
	          FileWriter fwriter = new FileWriter(filename,true); 
	          PrintWriter outputFile = new PrintWriter(fwriter);
	          outputFile.println(stud);
	          outputFile.close();
	          //Comfirmation that student was Added and returnd true
	          System.out.println("Student has been added");
	          return true;
	        }
	      }
	      //If student Exist print an error message and return False
	      else {
	          System.out.println("Student Already Exists");
	          return false;
	      }
	  }
	  Student GetStudent(int id )throws EmptyFieldException, IOException{
	      if (id == 0){
	        throw new EmptyFieldException("Not a Valid ID");
	      }
	      else{
	        for(int i = 0; i < student.count; i++){
	          Student current = student.get(i);
	          int ID = current.ID;
	          if (ID==id)
	            return current;
	        }
	        return null;
	      }

	  }

	  boolean updateStudent(int id, String firstname, String lastname, String address, String city, String state, String zip)throws IOException, EmptyFieldException{
	    if( firstname.equals("")|| lastname.equals("")|| address.equals("")|| city.equals("")|| state == null|| zip.equals("") ){
	      throw new EmptyFieldException("One or More Fields Are Empty");
	    }
	      else{

	      if (GetStudent(id) != null){
	        Student stud = GetStudent(id);
	        
	        stud.setFirstName(firstname);
	        stud.setLastName(lastname);
	        stud.setAddress(address);
	        stud.setCity(city);
	        stud.setState(state);
	        stud.setZip(zip);

	        student.add(id,stud);//Replace student object in arraylist
	        student.delete(id);
	        //Write the whole arraylist to the file
	        FileWriter fwriter = new FileWriter(filename); 
	        PrintWriter outputFile = new PrintWriter(fwriter);
	        for (int i = 0; i < student.count; i++){
	          outputFile.println(student.get(i));
	        }

	        outputFile.close();
	        //System.out.println(s"Student has been updated");
	          return true;
	      }

	    }
	      return false;
	  }
	}
