package application;

import java.util.Scanner;
import java.io.*;


public class EnrollmentFileManager{
	   String filename;
	   MyGenericList<Enrollment> enrollments = new MyGenericList<Enrollment>();// arrayList<Enrollment>
	   CourseFileManager c = new CourseFileManager("course.txt");
	   StudentFileManager s = new StudentFileManager("student.txt");
	    //Constructure
	   EnrollmentFileManager(String filename){
	      try{
	         this.filename = filename;
	         File file = new File(filename);
	         Scanner FileScanner = new Scanner(file); //Create File scanner
	         //Read File line by line
	         if (file.exists()){
	            while (FileScanner.hasNext()){ 
	               String line = FileScanner.nextLine();//read next line
	               String[] e = line.split(",");//Split line into a string array
	             //Asign the element of array to variables
	               int EID = Integer.parseInt(e[0]);
	               int SID = Integer.parseInt(e[1]);
	               int CID = Integer.parseInt(e[2]);
	               String Year = e[3];
	               String Semester = e[4];
	               char Grade = e[5].charAt(0);
	             //Create course object using variables
	               Enrollment enrollment = new Enrollment( EID, SID, CID,Year, Semester,Grade);
	               enrollments.add(enrollment);//Add course Object to array list 
	            }
	            FileScanner.close();
	         }
	      }
	      catch(IOException ioe){
	         System.out.println("Error" + ioe.getMessage());
	      }
	   }

	   boolean addEnrollment(int EID, int CID, int SID,  String year, String semester, char grade)throws IOException, EmptyFieldException {
	       //If Enrollment does not exsist then add it to the arraylist and return true
	      if( year.equals("") || semester == null || grade == ' '){
	         throw new EmptyFieldException("One or More Fields Are Empty");
	      }
	      else{
	         if (GetEnrollment(EID, CID, SID, year, semester) == null){
	            Enrollment enroll = new Enrollment(EID, SID, CID, year, semester, grade);
	            enrollments.add(enroll);

	           //Append the new course object to the file
	            FileWriter fwriter = new FileWriter(filename,true); 
	            PrintWriter outputFile = new PrintWriter(fwriter);
	            outputFile.println(enroll.EID + "," + enroll.SID + "," + enroll.CID + "," + enroll.year + "," + enroll.semester + "," + enroll.grade);
	            outputFile.close();

	            System.out.println("Enrollment Has Been Added");
	            return true;
	         }
	         System.out.println("Enrollment Already Exists");
	         return false;
	      }
	   }

	   Enrollment GetEnrollment(int eid, int cid, int sid, String Year, String Semester) throws EmptyFieldException, IOException{
	      if (c.GetCourse(cid) != null && s.GetStudent(sid) != null){
	         for(int i =0; i< enrollments.count; i++){
	            Enrollment current = enrollments.get(i);
	            int Eid = current.EID;
	            if(Eid == eid){ 
	               return current;
	            }
	         }
	      }
	      return null;
	   }
	   boolean AddEnrollment(int EID, int CID, int SID, String year, String semester, char Grade)throws EmptyFieldException, IOException{
	      if (year.equals("") || semester == null || Grade == ' '){
	         throw new EmptyFieldException("One or More Fields Are Empty");
	      }
	      else{
	         if (c.GetCourse(CID) != null && s.GetStudent(SID) != null){
	          //If Enrollment does not exsist then add it to the arraylist and return true
	            if (GetEnrollment(EID, CID, SID, year, semester) == null){
	               Enrollment enroll = new Enrollment(EID, SID, CID, year, semester, Grade);
	               enrollments.add(enroll);

	                 //Append the new course object to the file
	               FileWriter fwriter = new FileWriter(filename,true); 
	               PrintWriter outputFile = new PrintWriter(fwriter);
	               outputFile.println(enroll);
	               outputFile.close();

	               System.out.println("Enrollment Has Been Added");
	               return true; 
	            }
	            else {
	               System.out.println("Enrollment already Exist");
	               return false;
	            }
	         }else {
	            System.out.println("Student or Course Does Not Exist");
	            return false;
	         }
	      }

	   }
	   Enrollment GetEnrollment(int eid)throws EmptyFieldException, IOException {
	      if (eid==0){
	         throw new EmptyFieldException("Not a Valid ID");
	      }
	      else{
	         for(int i =0; i< enrollments.count; i++){
	            Enrollment current = enrollments.get(i);
	            int Eid = current.EID;
	            if(Eid == eid){
	               return current;
	            }
	         }
	      }
	      return null;
	   }
	   boolean updateEnrollment(int EID, int CID, int SID, String Year, String semester, char Grade)throws IOException, EmptyFieldException{

	      if (Year.equals("") || semester == null || Grade == ' '){
	         throw new EmptyFieldException("One or More Fields Are Empty");
	      }
	      else{

	         if (c.GetCourse(CID) != null && s.GetStudent(SID) != null){
	            if (GetEnrollment(EID, CID, SID, semester, Year) != null){
	               Enrollment enroll = GetEnrollment(EID, CID, SID, Year, semester);

	               enroll.setEID(EID);
	               enroll.setCID(CID);
	               enroll.setSID(SID);
	               enroll.setYear(Year);
	               enroll.setSemester(semester);
	               enroll.setGrade(Grade);
	               enrollments.add(EID,enroll);
	               enrollments.delete(EID);

	               FileWriter fwriter = new FileWriter(filename); 
	               PrintWriter outputFile = new PrintWriter(fwriter);
	               for (int i = 0; i < enrollments.count; i++){
	                  outputFile.println(enrollments.get(i));  
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
	         else {
	            System.out.println("Student or Course Does Not Exist");
	            return false;
	         }
	      }

	   }
	   String FindStudentsEnrolled(String CourseName, String Semester, String Year)throws IOException, EmptyFieldException{
	      String report = "";
	      if (CourseName.equals("") || Semester == null|| Year.equals("")){
	         throw new EmptyFieldException("Error One or More Fields are Empty");
	      }
	      else{ 
	         for (int i = 0; i< c.courses.count; i++){
	            Course currentCourse = c.courses.get(i);
	            if(currentCourse.name.equals(CourseName)){
	               int CID = currentCourse.courseID;
	               for(int j = 0; j< enrollments.count; j++){
	                  Enrollment currentEnrollment = enrollments.get(j);
	                  if((currentEnrollment.CID) == CID &&( Year.equals(currentEnrollment.year)) &&( Semester.equals(currentEnrollment.semester))){
	                     int SID = currentEnrollment.SID;
	                     Student student = s.GetStudent(SID);
	                     report += "      " + student.ID + "        " + student.FirstName + " " + student.LastName + "         "  + currentEnrollment.semester + "      " + currentEnrollment.year + "       " + currentEnrollment.grade +"\n";
	                  }
	               }
	            }

	         } 
	      }
	      return report;
	   }
	}