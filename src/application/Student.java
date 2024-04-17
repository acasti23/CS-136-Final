package application;

public class Student implements Comparable<Student>{
	  int ID;
	  String FirstName, LastName, Address, City, State, Zip;
	  //Constructor
	  Student(int ID, String FirstName,String LastName, String Address, String City, String State, String Zip){
	      this.ID = ID;
	      this.FirstName = FirstName;
	      this.LastName = LastName;
	      this.Address = Address;
	      this.City = City;
	      this.State = State;
	      this.Zip = Zip;
	  }
	  @Override 
	  public int compareTo(Student Stud){
		  return 0;
	  }
	  void setID(int SID){ ID = SID;}
	  void setFirstName(String firstName){ FirstName = firstName;}
	  void setLastName(String lastName){ LastName = lastName; }
	  void setAddress(String address){ Address = address; }
	  void setCity(String city){ City = city;}
	  void setState(String state){ State = state; }
	  void setZip(String zip){Zip = zip;}
	  public String toString(){
	    return ID + "," + FirstName + "," + LastName + "," + Address + "," + City + "," + State + "," + Zip;
	  }
	  
}