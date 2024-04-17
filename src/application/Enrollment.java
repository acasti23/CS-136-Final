package application;
public class Enrollment implements Comparable<Enrollment>{
	   int SID, CID, EID;
	   String year, semester;
	   char grade;
	   Enrollment( int EID, int CID, int SID, String year, String semester, char grade){
	      this.SID = SID;
	      this.CID = CID;
	      this.EID = EID;
	      this.year = year;
	      this.semester = semester;
	      this.grade = grade;
	   }
	   @Override 
	     public int compareTo(Enrollment Enroll){
	      return 0;
	   }
	   void setCID(int CID) {this.CID = CID;}
	   void setSID(int SID){this.SID = SID;}
	   void setEID(int EID){this.EID = EID;}
	   void setYear(String year) { this.year = year;}
	   void setSemester(String semester) {this.semester = semester; }
	   void setGrade(char grade){this.grade = grade;}
	   public String toString() {
	      return EID + "," +  CID + "," + SID + "," + year + "," +  semester + "," +  grade;
	   }
	}

	