package application;
//Andrea Castillo
//Andrea Castillo
import java.io.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.event.*;
import javafx.collections.*;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Main extends Application {
   static StudentFileManager s = new StudentFileManager("student.txt");
   static CourseFileManager c = new CourseFileManager("course.txt");
   static EnrollmentFileManager e = new EnrollmentFileManager("enrollment.txt");
   static DepartmentFileManager d = new DepartmentFileManager("department.txt");
   static InstructorFileManager i = new InstructorFileManager("Instructor.txt");
   public static void main(String[] args) {
    // Launch the application.
      launch(args);
   }
   @Override
   public void start(Stage primaryStage) {    
      Label StartTitle = new Label("Start Student Registration");
      Button StartBtn = new Button("Start");
    //Create Menues

      StartBtn.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               CreateAddStudentScene(primaryStage);
            }
         });
      VBox StartVBox = new VBox(StartTitle, StartBtn);
      StartVBox.setAlignment(Pos.CENTER);
      Scene StartScene = new Scene(StartVBox, 400, 270);
      primaryStage.setScene(StartScene);
    // Set the stage title.
      primaryStage.setTitle(" ");

    // Show the window.
      primaryStage.show();
   }
   static MenuBar createMenueBar(Stage primaryStage){
      Menu StudMenu = new Menu("Student");
      MenuItem AddStudMenuItem = new MenuItem("Add Student");
      MenuItem EditStudMenuItem = new MenuItem("Edit Student");
      MenuItem ViewStudMenuItem = new MenuItem("View Student");
      StudMenu.getItems().add(AddStudMenuItem);
      StudMenu.getItems().add(EditStudMenuItem);
      StudMenu.getItems().add(ViewStudMenuItem);

      Menu CourseMenu = new Menu("Course");
      MenuItem AddCourMenuItem = new MenuItem("Add Course");
      MenuItem EditCourMenuItem = new MenuItem("Edit Course");
      MenuItem ViewCourMenuItem = new MenuItem("View Course");
      CourseMenu.getItems().add(AddCourMenuItem);
      CourseMenu.getItems().add(EditCourMenuItem);
      CourseMenu.getItems().add(ViewCourMenuItem);

      Menu InstructMenu = new Menu("Instructor");
      MenuItem AddIntructMenuItem = new MenuItem("Add Instructor");
      MenuItem EditInstructMenuItem = new MenuItem("Edit Instructor");
      MenuItem ViewInstructMenuItem = new MenuItem("View Instructor");
      InstructMenu.getItems().add(AddIntructMenuItem);
      InstructMenu.getItems().add(EditInstructMenuItem);
      InstructMenu.getItems().add(ViewInstructMenuItem);

      Menu DepartMenu = new Menu("Department");
      MenuItem AddDepartMenuItem = new MenuItem("Add Department");
      MenuItem EditDepartMenuItem = new MenuItem("Edit Deparment");
      MenuItem ViewDepartMenuItem = new MenuItem("View Deparment");
      DepartMenu.getItems().add(AddDepartMenuItem);
      DepartMenu.getItems().add(EditDepartMenuItem);
      DepartMenu.getItems().add(ViewDepartMenuItem);

      Menu EnrollMenu = new Menu("Enrollment");
      MenuItem AddEnrollMenuItem = new MenuItem("Add Enrollment");
      MenuItem EditEnrollMenuItem = new MenuItem("Edit Enrollment");
      MenuItem ViewEnrollMenuItem = new MenuItem("View Enrollment");
      EnrollMenu.getItems().add(AddEnrollMenuItem);
      EnrollMenu.getItems().add(EditEnrollMenuItem);
      EnrollMenu.getItems().add(ViewEnrollMenuItem);

      Menu ReportMenu = new Menu("Report");
      MenuItem PrintReportMenuItem = new MenuItem("Print Report");
      ReportMenu.getItems().add(PrintReportMenuItem);
      MenuBar x = new MenuBar(StudMenu, CourseMenu, InstructMenu,  DepartMenu, EnrollMenu, ReportMenu);

      AddStudMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateAddStudentScene(primaryStage);
            }
         });
      EditStudMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateEditStudentScene(primaryStage);
            }
         });
      ViewStudMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateViewStudentScene(primaryStage);
            }
         });
     
      AddCourMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateAddCourseScene(primaryStage);
            }
         });
      EditCourMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateEditCourseScene(primaryStage);
            }
         });
      ViewCourMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateViewCoursScene(primaryStage);
            }
         });

      AddDepartMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateAddDepartmentScene(primaryStage);
            }
         });
      EditDepartMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateEditDepartmentScene(primaryStage);
            }
         });
      ViewDepartMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateViewDepartmentScene(primaryStage);
            }
         });

      AddIntructMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateAddInstructorScene(primaryStage);
            }
         });
       EditInstructMenuItem.setOnAction(
      new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent e){
              CreateEditInstructorScene(primaryStage);
         }
      });
     ViewInstructMenuItem.setOnAction(
     new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e){
             CreateViewInstructorScene(primaryStage);
        }
     });

      AddEnrollMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateAddEnrollmentScene(primaryStage);
            }
         });


      EditEnrollMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateEditEnrollmentcene(primaryStage);
            }
         });
      ViewEnrollMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateViewEnrollmentScene(primaryStage);
            }
         });
      PrintReportMenuItem.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               CreateReportScene(primaryStage);
            }
         });
      return x;
   }

   static void CreateAddStudentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

    //Build Add Student Scene
      Label addStudTitle = new Label("Add Student: ");//Tittle
      HBox addStudBox = new HBox(addStudTitle);
      addStudBox.setAlignment(Pos.CENTER);
    //Student First Name Box
      Label firstName = new Label("Student First Name: ");
      TextField firstNameField = new TextField();
    //Student Last Name Box
      Label LastName = new Label("Student Last Name: ");
      TextField LastNameField = new TextField();
    //Student Address Box
      Label StudAddress = new Label("Address: ");
      TextField StudAddressField = new TextField();
    //Student City Box
//      Label StudCity = new Label("City: ");
//      TextField StudCityField = new TextField();
//    //Student State Box
//     Label State = new Label("State: ");
//
//     ObservableList<String> states = FXCollections.observableArrayList("AK", "AL", "AR", "AZ", "CA",
//                                                   "CO", "CT", "DC", "DE", "FL", 
//                                                   "GA", "HI", "IA", "ID", "IL", 
//                                                   "IN", "KS", "KY", "LA", "LA",
//                                                   "MA", "MD", "ME", "MI", "MN", 
//                                                   "MO", "MS", "MT", "NC", "ND", 
//                                                   "NE", "NH", "NJ", "NM", "NV", 
//                                                   "NY", "OH", "OK", "OR", "PA", 
//                                                   "RI", "SC", "SD", "TN", "TX", 
//                                                   "UT", "VA", "VT", "WA", "WI", 
//                                                   "WV", "WY");                                
//
//     ComboBox<String> StateCB = new ComboBox<>(states);

    //Student Zip Box
      Label StudZip = new Label("Zip Code: ");
      TextField StudZipField = new TextField();
      Button addStud = new Button("Add Student");
      HBox buttonBox = new HBox(addStud);
      buttonBox.setAlignment(Pos.CENTER);

      VBox vbox1 = new VBox(10,  firstName, LastName, StudAddress, /*StudCity, State,*/ StudZip);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox( firstNameField, LastNameField, StudAddressField, /*StudCityField, StateCB,*/ StudZipField);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addStudBox, hbox, buttonBox);
    //Event Handler for Add Student Button
      
      addStud.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            //Get Text from Fields
               final int studentID = s.student.count + 1;
               final String studentFirstName = firstNameField.getText();
               final String studentLastName = LastNameField.getText();
               final String studentAddress = StudAddressField.getText();
               String studentCity = /*StudCityField.getText()*/"city";
               String studentState =  "CA";
               final String studentZip = StudZipField.getText();
               

            //Catch IOException
               try{
                  if (!s.AddStudent(studentID, studentFirstName, studentLastName, studentAddress, studentCity, studentState, studentZip)){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Student Already Exists ", ButtonType.OK);
                    
                     alert.showAndWait();
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student ID: " + studentID +"\nStudent Name: " + studentFirstName + " " + studentLastName + "\nAddress: " + studentAddress + "\n\t   " + studentCity + ", "+ studentState + " " +studentZip, ButtonType.OK);
                     alert.setHeaderText("Student Added");
                     firstNameField.clear();
                     LastNameField.clear();
                     StudAddressField.clear();
                     StudZipField.clear();
                     zipCodeClient ziplient = new zipCodeClient(studentZip);
                     ziplient.printInfo();

                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      Scene AddStudentScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddStudentScene);
   }
   static void CreateEditStudentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

    //Add Student Scen
      Label addStudTitle = new Label("Edit Student: ");
      HBox titleBox = new HBox(addStudTitle);
      titleBox.setAlignment(Pos.CENTER);

      Label StudID = new Label("              Student ID: ");
      TextField StudIDField = new TextField();
      HBox StudIDBox = new HBox(StudID , StudIDField);
      StudIDBox.setAlignment(Pos.CENTER);

      Label firstName = new Label("Student First Name: ");
      TextField firstNameField = new TextField();

      Label LastName = new Label("Student Last Name: ");
      TextField LastNameField = new TextField();

      Label StudAddress = new Label("Address: ");
      TextField StudAddressField = new TextField();

      Label StudCity = new Label("City: ");
      TextField StudCityField = new TextField();

      Label State = new Label("State: ");

      ObservableList<String> states = FXCollections.observableArrayList("AK", "AL", "AR", "AZ", "CA",
                                                    "CO", "CT", "DC", "DE", "FL", 
                                                    "GA", "HI", "IA", "ID", "IL", 
                                                    "IN", "KS", "KY", "LA", "LA",
                                                    "MA", "MD", "ME", "MI", "MN", 
                                                    "MO", "MS", "MT", "NC", "ND", 
                                                    "NE", "NH", "NJ", "NM", "NV", 
                                                    "NY", "OH", "OK", "OR", "PA", 
                                                    "RI", "SC", "SD", "TN", "TX", 
                                                    "UT", "VA", "VT", "WA", "WI", 
                                                    "WV", "WY");                                

      ComboBox<String> StateCB = new ComboBox<>(states);
      Label StudZip = new Label("Zip Code: ");
      TextField StudZipField = new TextField();

      Button FindStud = new Button("Find Student");
      Button EditStud = new Button("Edit Student");
      Button FindAnotherStud = new Button("Find Another Student");
      HBox  EditBTNBox = new HBox(10, FindStud , FindAnotherStud, EditStud);

      VBox vbox1 = new VBox(10,  firstName, LastName, StudAddress, StudCity, State, StudZip);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox( firstNameField, LastNameField, StudAddressField, StudCityField, StateCB, StudZipField);
      HBox hbox = new HBox( vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, titleBox , StudIDBox,  hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);
      FindAnotherStud.setDisable(true);

      EditStud.setDisable(true);


      FindStud.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               try{
                  final int studentID = Integer.parseInt(StudIDField.getText());
                  Student v = s.GetStudent(studentID);
                  if(v != null){
                     StudIDField.setEditable(false);
                     EditStud.setDisable(false);
                     vbox1.setVisible(true);
                     vbox2.setVisible(true);

                     firstNameField.setText(v.FirstName);
                     LastNameField.setText(v.LastName);
                     StudAddressField.setText(v.Address);
                     StudCityField.setText(v.City);
                     StateCB.setValue(v.State);
                     StudZipField.setText(v.Zip);
                     FindStud.setDisable(true);
                     FindAnotherStud.setDisable(false);
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Student Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               // catch(IOException ioe){
               //   System.out.println("Error: " + ioe.getMessage());
               // }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      FindAnotherStud.setOnAction(
         new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
               StudIDField.clear();
               firstNameField.clear();
               LastNameField.clear();
               StudAddressField.clear();
               StudCityField.clear();
               StateCB.setValue(null);
               StudZipField.clear();
               FindAnotherStud.setDisable(true); 
               FindStud.setDisable(false);
               EditStud.setDisable(true);
               StudIDField.setEditable(true);
            }
         });
      EditStud.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               final int studentID = Integer.parseInt(StudIDField.getText());
               final String studentFirstName = firstNameField.getText();
               final String studentLastName = LastNameField.getText();
               final String studentAddress = StudAddressField.getText();
               final String studentCity = StudCityField.getText();
               String studentState = "" ;
               studentState += StateCB.getValue();
               final String studentZip = StudZipField.getText();
               try{
                  s.updateStudent(studentID, studentFirstName, studentLastName, studentAddress, studentCity, studentState, studentZip );
                  Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student ID: " + studentID +"\nStudent Name: " + studentFirstName + " " + studentLastName + "\nAddress: " + studentAddress + "\n\t  " + studentCity + ", "+ studentState + " " +studentZip, ButtonType.OK);
                  alert.setTitle("Student Was Updated");
                  StudIDField.clear();
                  firstNameField.clear();
                  LastNameField.clear();
                  StudAddressField.clear();
                  StudCityField.clear();
                  StateCB.setValue(null);
                  StudZipField.clear();

                  FindStud.setDisable(false);
                  FindAnotherStud.setDisable(true);
                  EditStud.setDisable(true);
                  StudIDField.setEditable(true);
                  alert.showAndWait();
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
    // Create a Scene with the HBox as its root node.
      Scene AddStudentScene = new Scene(fullBox, 400, 270);
    // Add the Scene to the Stage.
      primaryStage.setScene(AddStudentScene);
   }
   static void CreateViewStudentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);
    //Add Student Scen
      Label addStudTitle = new Label("View Student: ");
      Label StudID = new Label("Student ID: ");
      TextField StudIDField = new TextField();
      HBox StudIDBox = new HBox(StudID , StudIDField);
    //StudIDBox.setAlignment(Pos.CENTER);

      Label firstName = new Label();
      Label LastName = new Label();
      Label StudAddress = new Label();
      Label StudCity = new Label();
      Label State = new Label();  
      Label StudZip = new Label();

      VBox labelbox = new VBox( firstName, LastName, StudAddress, StudCity, State, StudZip);
      labelbox.setAlignment(Pos.CENTER);    
      labelbox.setVisible(false);

      Button FindStud = new Button("Find Student");

      FindStud.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               try{
                  final int studentID = Integer.parseInt(StudIDField.getText());
                  Student v = s.GetStudent(studentID);
                  if(v != null){
                     firstName.setText("Student First Name: " + v.FirstName);
                     LastName.setText("Student Last Name: "+ v.LastName);
                     StudAddress.setText("Address: " +v.Address);
                     StudCity.setText("City: " + v.City);
                     State.setText("State: " + v.State);
                     StudZip.setText("Zip Code: " + v.Zip);

                     labelbox.setVisible(true);
                     FindStud.setText("Find Another Student");
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Student Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });

      StudIDBox.setAlignment(Pos.CENTER);
      VBox e = new VBox(x, addStudTitle, StudIDBox , FindStud);
      e.setAlignment(Pos.CENTER);

      VBox AddStudentVBox = new VBox(10, e,labelbox);

      Scene AddStudentScene = new Scene(AddStudentVBox, 400, 270);
      primaryStage.setScene(AddStudentScene);
      primaryStage.show();
   }


   static void CreateAddCourseScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

      Label addCourseTitle = new Label("Add Course: ");//Title
      HBox addCourseBox = new HBox(addCourseTitle);
      addCourseBox.setAlignment(Pos.CENTER_RIGHT);

      Label CourseName = new Label("Course Name: ");
      TextField CourseNameField = new TextField();

      Label CourDescrip = new Label("Course Description: ");
      TextField CourDescripField = new TextField();

      Label CourseDept = new Label("Course Department: ");
     ObservableList<String> DeparmentField = FXCollections.observableArrayList();
     for(int o = 0; o <d.departments.count; o++) {
        DeparmentField.add(d.departments.get(o).Department);
     }
      ComboBox<String> CourseDeptCB = new ComboBox<>(DeparmentField);
     
     Label CourInst = new Label("Course Instructor: ");
     ComboBox<String> CourseInstCB = new ComboBox<>();
      Button addCours = new Button("Add Course");
      addCours.setAlignment(Pos.CENTER_RIGHT);

      VBox vbox1 = new VBox(10, CourseName, CourDescrip,CourseDept,CourInst);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(CourseNameField, CourDescripField,CourseDeptCB, CourseInstCB );
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addCourseTitle, hbox, addCours);

      addCours.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               final int courseID = c.courses.count + 1;
               final String courseName = CourseNameField.getText();
               final String courseDescrip = CourDescripField.getText();
              final String CourseDept= CourseDeptCB.getValue();
              final String CourseInst = CourseInstCB.getValue();
               try{
                  if (!c.AddCourse(courseID, courseName, courseDescrip, CourseDept, CourseInst)){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Course Already Exists ", ButtonType.OK);
                     alert.showAndWait();
                  }
                  else{
                     System.out.print(courseID);
                     Alert alert = new Alert(Alert.AlertType.NONE, "Course ID: " + courseID + "\nCourse Name: " + courseName + "\nCourse Description: " + courseDescrip+"\nDepartment:"+ CourseDept+ "Instructor" +CourseInst, ButtonType.OK);
                     alert.setHeaderText("Course Was Added");
                     alert.showAndWait();
                     CourseNameField.clear();
                     CourDescripField.clear();
                  }
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
     CourseDeptCB.setOnAction(
       new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
          try {
            String CourseDept = CourseDeptCB.getValue();
            ObservableList<String> InstList= i.GetInstructorByDeparment(CourseDept);
            CourseInstCB.setItems(InstList);
          }
          catch(Exception exc){
            Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
            alert.showAndWait();
          }
        }
     });
    // Create a Scene with the HBox as its root node.
      Scene AddCourseScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddCourseScene);
   }
   static void CreateEditCourseScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

    //Add Student Scen
      Label EditCourTitle = new Label("Edit Course: ");

      Label CourID = new Label("              Course ID: ");
      TextField CourIDField = new TextField();
      HBox CourIDBox = new HBox(CourID , CourIDField);
      CourIDBox.setAlignment(Pos.CENTER);

      Label CourName = new Label("Course Name: ");
      TextField CourNameField = new TextField();

      Label CourDesc = new Label("Course Description: ");
      TextField CourDescField = new TextField();


      Button FindCour = new Button("Find Course");
      Button EditCour = new Button("Edit Course");
     
     Label CourseDept = new Label("Course Department: ");
      ObservableList<String> DeparmentField = FXCollections.observableArrayList();
      for(int o = 0; o <d.departments.count; o++) {
         DeparmentField.add(d.departments.get(o).Department);
      }
      ComboBox<String> CourseDeptCB = new ComboBox<>(DeparmentField);
     
      Label CourInst = new Label("Course Instructor: ");
      ComboBox<String> CourseInstCB = new ComboBox<>();

     
      HBox  EditBTNBox = new HBox(10, FindCour , EditCour);

      VBox vbox1 = new VBox(10,  CourName, CourDesc,CourseDept,CourInst);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(CourNameField, CourDescField, CourseDeptCB,CourseInstCB );
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, EditCourTitle , CourIDBox,  hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);

      EditCour.setDisable(true);


      FindCour.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               try{
                  final int CourID = Integer.parseInt(CourIDField.getText());
                  Course v = c.GetCourse(CourID);
                  if(v != null){
                     CourIDField.setEditable(false);
                     EditCour.setDisable(false);
                     vbox1.setVisible(true);
                     vbox2.setVisible(true);

                     CourNameField.setText(v.name);
                     CourDescField.setText(v.description);
                     CourseDeptCB.setValue(v.dept);
                     CourseInstCB.setValue(v.instructor);
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Course Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      EditCour.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               try{
                  final int CourID = Integer.parseInt( CourIDField.getText());
                  final String CoursName = CourNameField.getText();
                  final String CourseDescrip = CourDescField.getText();  
                  final String CourseDept = CourseDeptCB.getValue();
                 final String CourseInstructor = CourseInstCB.getValue();
                  c.updateCourse(CourID, CoursName, CourseDescrip,CourseDept,CourseInstructor);
                  Alert alert = new Alert(Alert.AlertType.NONE, "Course ID: " + CourID + "\nCourse Name: " + CoursName + "\nCourse Description: " + CourseDescrip +"\nCourse Department:" + CourseDept + "\nCourse Instructor:"+ CourseInstructor, ButtonType.OK);
                  alert.setHeaderText("Course Was Updated");
                  alert.showAndWait();
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
     CourseDeptCB.setOnAction(
        new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent event){
           try {
             String CourseDept = CourseDeptCB.getValue();
             ObservableList<String> InstList= i.GetInstructorByDeparment(CourseDept);
             CourseInstCB.setItems(InstList);
           }
           catch(Exception exc){
             Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
             alert.showAndWait();
           }
         }
      });
      Scene AddStudentScene = new Scene(fullBox, 400, 270);
    // Add the Scene to the Stage.
      primaryStage.setScene(AddStudentScene);
   }
   static void CreateViewCoursScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);
      Label addCourseTitle = new Label("View Course: ");
      Label CourseIDLb = new Label("Course ID: ");
      TextField CourseIDField = new TextField();
      HBox CourseIDBox = new HBox(CourseIDLb , CourseIDField);

      Label CourseID = new Label();
      Label CourseName = new Label();
      Label CourseDescr = new Label();
      Label CourseDept = new Label();
     Label CouseInst = new Label();
      VBox labelbox = new VBox(CourseID, CourseName, CourseDescr,CourseDept,CouseInst);
      labelbox.setVisible(false);

      Button FindCourse = new Button("Find Course");
      FindCourse.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                  final int CourseIDS = Integer.parseInt(CourseIDField.getText());
                  Course v = c.GetCourse(CourseIDS);
                  if(v != null){
                     CourseID.setText("Course ID " + v.courseID);
                     CourseName.setText("Course Name: "+ v.name);
                     CourseDescr.setText("Course Description: " + v.description);
                    CourseDept.setText("Course Department: " + v.dept);
                    CouseInst.setText("Course Instructor: " + v.instructor);

                     labelbox.setVisible(true);
                     FindCourse.setText("Find Another Course");
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Course Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      CourseIDBox.setAlignment(Pos.CENTER);
      VBox g = new VBox(10, x, addCourseTitle, CourseIDBox , FindCourse);
      g.setAlignment(Pos.CENTER);

      labelbox.setAlignment(Pos.CENTER);
      VBox ViewCourseVBox = new VBox(10, g,labelbox);

      Scene ViewCourseScene = new Scene(ViewCourseVBox, 400, 270);
      primaryStage.setScene(ViewCourseScene);
      primaryStage.show();
   }

   static void CreateAddDepartmentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

      Label addDepartTitle = new Label("Add Department: ");//Title
      HBox addDepartBox = new HBox(addDepartTitle);
      addDepartBox.setAlignment(Pos.CENTER_RIGHT);

      Label DepartmentName = new Label("Deparment Name: ");
      TextField DeparmentNameField = new TextField();

      Button addDepart = new Button("Add Deparment");
      addDepart.setAlignment(Pos.CENTER_RIGHT);

      VBox vbox1 = new VBox(10, DepartmentName);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(DeparmentNameField );
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addDepartTitle, hbox, addDepart);

      addDepart.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               final int DepartID = d.departments.count + 1;
               final String DepartmentName = DeparmentNameField.getText();
               try{
                  if (!d.addDepartment(DepartID, DepartmentName)){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Deparment Already Exists ", ButtonType.OK);
                     alert.showAndWait();
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.NONE, "Department ID: " + DepartID + "\nDepartment Name: " + DepartmentName , ButtonType.OK);
                     alert.setHeaderText("Deparment Was Added");
                     alert.showAndWait();
                     DeparmentNameField.clear();
                  }
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
       // Create a Scene with the HBox as its root node.
      Scene AddDepartScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddDepartScene);
   }
   static void CreateEditDepartmentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

       //Add Student Scen
      Label EditDepartTitle = new Label("Edit Department: ");

      Label DepartID = new Label("              Department ID: ");
      TextField DepartIDField = new TextField();
      HBox DepartIDBox = new HBox(DepartID , DepartIDField);
      DepartIDBox.setAlignment(Pos.CENTER);

      Label DepartName = new Label("Depart Name: ");
      TextField DepartNameField = new TextField();


      Button FindDepart = new Button("Find Depart");
      Button EditDepart = new Button("Edit Depart");
      HBox  EditBTNBox = new HBox(10, FindDepart , EditDepart);

      VBox vbox1 = new VBox(10,  DepartName);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(DepartNameField);
      HBox hbox = new HBox( vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, EditDepartTitle , DepartIDBox,  hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);

      EditDepart.setDisable(true);


      FindDepart.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               try{
                  final int DepartID = Integer.parseInt(DepartIDField.getText());
                  Department v = d.GetDepartment(DepartID);
                  if(v != null){
                     DepartIDField.setEditable(false);
                     EditDepart.setDisable(false);
                     vbox1.setVisible(true);
                     vbox2.setVisible(true);

                     DepartNameField.setText(v.Department);
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Department Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      EditDepart.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
               try{
                  final int DepartID = Integer.parseInt( DepartIDField.getText());
                  final String DepartName = DepartNameField.getText();  
                  d.updateDepartment(DepartID, DepartName );
                  Alert alert = new Alert(Alert.AlertType.NONE, "Department ID: " + DepartID + "\nDepartment Name: " + DepartName , ButtonType.OK);
                  alert.setHeaderText("Department Was Updated");
                  alert.showAndWait();
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      Scene editDepartScene = new Scene(fullBox, 400, 270);
       // Add the Scene to the Stage.
      primaryStage.setScene(editDepartScene);
   }
   static void CreateViewDepartmentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);
      Label addDepartTitle = new Label("View Dep: ");
      Label DepartIDLb = new Label("Depart ID: ");
      TextField DepartIDField = new TextField();
      HBox DepartIDBox = new HBox(DepartIDLb , DepartIDField);

      Label DepartID = new Label();
      Label DepartName = new Label();

      VBox labelbox = new VBox(DepartID, DepartName);
      labelbox.setVisible(false);

      Button FindDepart = new Button("Find Department");
      FindDepart.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                  final int ID = Integer.parseInt(DepartIDField.getText());
                  Department v = d.GetDepartment(ID);
                  if(v != null){
                     DepartID.setText("Department ID " + v.ID);
                     DepartName.setText("Department Name: "+ v.Department);


                     labelbox.setVisible(true);
                     FindDepart.setText("Find Another Department");
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Course Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      DepartIDBox.setAlignment(Pos.CENTER);
      VBox g = new VBox(10, x, addDepartTitle, DepartIDBox , FindDepart);
      g.setAlignment(Pos.CENTER);

      labelbox.setAlignment(Pos.CENTER);
      VBox ViewDepartmentVBox = new VBox(10, g,labelbox);

      Scene ViewDepartmentScene = new Scene(ViewDepartmentVBox, 400, 270);
      primaryStage.setScene(ViewDepartmentScene);
      primaryStage.show();
   }

   static void CreateEditInstructorScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

      Label editInstructTitle = new Label("Edit Instruct: ");//Title
      HBox editInstructBox = new HBox(editInstructTitle);
      editInstructBox.setAlignment(Pos.CENTER_RIGHT);
     Label InstructID = new Label("              Instructor ID: ");
     TextField InstructIDField = new TextField();
     HBox InstructIDBox = new HBox(InstructID , InstructIDField);
       InstructIDBox.setAlignment(Pos.CENTER);

      Label InstructName = new Label("Instruct Name: ");
      TextField InstructNameField = new TextField();
      Label DepartmentLB = new Label("Deparment: ");
      ObservableList<String> DeparmentField = FXCollections.observableArrayList();
      for(int o = 0; o <d.departments.count; o++) {
         DeparmentField.add(d.departments.get(o).Department);
      }
      ComboBox<String> DeptCB = new ComboBox<>(DeparmentField);
      Button FindInstructor = new Button("Find Instructor");
      Button editInstruct = new Button("Edit Instruct");
      editInstruct.setAlignment(Pos.CENTER_RIGHT);

      VBox vbox1 = new VBox(10, InstructName,DepartmentLB);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(InstructNameField,DeptCB );
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, editInstructTitle,InstructIDBox, hbox, editInstruct,FindInstructor);
      
       FindInstructor.setOnAction(
       new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent e){
             try{
                final int ID = Integer.parseInt(InstructIDField.getText());
                Instructor v = i.GetInstructor(ID);
                if(v != null){
                     InstructIDField.setEditable(false);
                  editInstruct.setDisable(false);
                   vbox1.setVisible(true);
                   vbox2.setVisible(true);
                  InstructNameField.setText(v.Name);
                  DeptCB.setValue(v.department);
                }
                else{
                   Alert alert = new Alert(Alert.AlertType.ERROR,"Instructor Not Found" ,ButtonType.OK);
                   alert.showAndWait();
                }
             }
             catch (EmptyFieldException EFE){
                Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                alert.showAndWait();
             }
             catch(IOException ioe){
                System.out.println("Error: " + ioe.getMessage());
             }
             catch(NumberFormatException NFE){
                Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                alert.showAndWait();
             }
             catch(Exception exc){
                Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                alert.showAndWait();
             }
          }
       });
      editInstruct.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
           public void handle(ActionEvent e){
              try{
                 final int ID = Integer.parseInt( InstructIDField.getText());
                 final String Name = InstructNameField.getText(); 
                final String Deparment = DeptCB.getValue();
                 i.updateInstructor(ID, Name, Deparment);
                 Alert alert = new Alert(Alert.AlertType.NONE, " ID: " + ID + "\n Name: " + Name +"\ndepartment: " + Deparment, ButtonType.OK);
                 alert.setHeaderText("Instructor Was Updated");
                 alert.showAndWait();
              }
              catch (EmptyFieldException EFE){
                 Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                 alert.showAndWait();
              }
              catch(IOException ioe){
                 System.out.println("Error: " + ioe.getMessage());
              }
              catch(NumberFormatException NFE){
                 Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                 alert.showAndWait();
              }
              catch(Exception exc){
                 Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                 alert.showAndWait();
              }
           }
         });
       // Create a Scene with the HBox as its root node.
      Scene editDepartScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(editDepartScene);
   }
  static void CreateAddInstructorScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

      Label addInstructTitle = new Label("Add Instruct: ");//Title
      HBox addInstructBox = new HBox(addInstructTitle);
      addInstructBox.setAlignment(Pos.CENTER_RIGHT);

      Label InstructName = new Label("Instruct Name: ");
      TextField InstructNameField = new TextField();
      Label DepartmentLB = new Label("Deparment: ");
      ObservableList<String> DeparmentField = FXCollections.observableArrayList();
      for(int o = 0; o <d.departments.count; o++) {
         DeparmentField.add(d.departments.get(o).Department);
      }
      ComboBox<String> DeptCB = new ComboBox<>(DeparmentField);

      Button addInstruct = new Button("Add Instruct");
      addInstruct.setAlignment(Pos.CENTER_RIGHT);

      VBox vbox1 = new VBox(10, InstructName,DepartmentLB);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(InstructNameField,DeptCB );
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addInstructTitle, hbox, addInstruct);

      addInstruct.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               final int InstructID = i.instructors.count + 1;
               final String InstructName = InstructNameField.getText();
               final String Deparment = DeptCB.getValue();
               try{
                  if (!i.addInstructor(InstructID, InstructName,Deparment)){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Deparment Already Exists ", ButtonType.OK);
                     alert.showAndWait();
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.NONE, "Department ID: " + InstructID + "\nDepartment Name: " +InstructName + "\nDeparment:"+ Deparment , ButtonType.OK);
                     alert.setHeaderText("Deparment Was Added");
                     alert.showAndWait();
                  }
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
       // Create a Scene with the HBox as its root node.
      Scene AddDepartScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddDepartScene);
   }
  static void CreateViewInstructorScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);
      Label addDepartTitle = new Label("View Instructor: ");
      Label DepartIDLb = new Label("Instructor ID: ");
      TextField DepartIDField = new TextField();
      HBox DepartIDBox = new HBox(DepartIDLb , DepartIDField);

      Label DepartID = new Label();
      Label DepartName = new Label();
    Label Depar = new Label();

      VBox labelbox = new VBox(DepartID, DepartName,Depar);
      labelbox.setVisible(false);

      Button FindDepart = new Button("Find Instructor");
      FindDepart.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                  final int ID = Integer.parseInt(DepartIDField.getText());
                  Instructor v = i.GetInstructor(ID);
                  if(v != null){
                     DepartID.setText("Instructor ID " + v.ID);
                     DepartName.setText("Instructor Name: "+ v.Name);
                    Depar.setText("Deparment: " + v.department);


                     labelbox.setVisible(true);
                     FindDepart.setText("Find Another Instructor");
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Instructor Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      DepartIDBox.setAlignment(Pos.CENTER);
      VBox g = new VBox(10, x, addDepartTitle, DepartIDBox , FindDepart);
      g.setAlignment(Pos.CENTER);

      labelbox.setAlignment(Pos.CENTER);
      VBox ViewDepartmentVBox = new VBox(10, g,labelbox);

      Scene ViewDepartmentScene = new Scene(ViewDepartmentVBox, 400, 270);
      primaryStage.setScene(ViewDepartmentScene);
      primaryStage.show();
   }

  
   static void CreateAddEnrollmentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

    //Build Add Student Scene
      Label addEnrollTitle = new Label("Add Enrollment: ");
      addEnrollTitle.setAlignment(Pos.CENTER_RIGHT);

    //Student First Name Box
      Label CourseID = new Label("Course ID: ");
      TextField CourseIDField = new TextField();
    //Student Last Name Box
      Label StudID = new Label("Student ID: ");
      TextField StudIDField = new TextField();
    //Student Address Box
      Label Year = new Label("Year: ");
      TextField YearField = new TextField();
    //Studen City Box
      Label Semester = new Label("Semester: ");
      ComboBox<String> SemesterCB = new ComboBox<>();
      SemesterCB.getItems().addAll("Spring", "Summer", "Fall", "Winter");
    //Student State Box
      Label Grades = new Label("Grade: ");
      ComboBox<Character> GradesCB = new ComboBox<>();
      GradesCB.getItems().addAll('A','B','C','D','F', 'P','N', 'W');
    //Student Zip Box

      Button addEnrollBTN = new Button("Add Enrollment");

      VBox vbox1 = new VBox(10,   CourseID, StudID, Year, Semester, Grades );
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox( CourseIDField, StudIDField, YearField, SemesterCB, GradesCB);
      HBox hbox = new HBox(vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x, addEnrollTitle, hbox, addEnrollBTN);
    //Event Handler for Add Student Button
      addEnrollBTN.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            //Get Text from Fields

               try{
                  final int EnrollmentID = e.enrollments.count + 1;
                  final int CourseID = Integer.parseInt(CourseIDField.getText());
                  final int StudentID = Integer.parseInt(StudIDField.getText());
                  final String Year = YearField.getText();
                  final String Semester = SemesterCB.getValue();
                  char Grade = ' ';
                  if (GradesCB.getValue() == null){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Select a Grade ", ButtonType.OK);
                     alert.showAndWait();
                  }
                  else
                     Grade = GradesCB.getValue();
                  if (!e.addEnrollment(EnrollmentID, CourseID, StudentID, Year, Semester, Grade)){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Enrollment Already Exists ", ButtonType.OK);
                     alert.showAndWait();
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.NONE, "Enrollment ID: " + EnrollmentID + "\nCourse ID: " + CourseID + "\nStudent ID: " + StudentID +"\nSemester: " + Semester + " " + Year + "\nGrade: " + Grade , ButtonType.OK);
                     alert.setHeaderText("Enrollment Was Added");
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "One or more ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }

            }
         });
    // Create a Scene with the HBox as its root node.
      Scene AddEnrollScene = new Scene(fullBox, 400, 270);
      primaryStage.setScene(AddEnrollScene);
   }
   static void CreateEditEnrollmentcene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);
      Label EditEnrollTitle = new Label("Edit Enrollment: ");
      HBox titleBox = new HBox(EditEnrollTitle);

      Label ErollID = new Label("Enrollment ID: "); 
      TextField EnrollIDField = new TextField();
      HBox ErollIDBox = new HBox(ErollID, EnrollIDField);

      Label CourseID = new Label("Course ID: ");
      TextField CourseIDField = new TextField();

      Label StudID = new Label("Student ID: ");
      TextField StudIDField = new TextField();

      Label Year = new Label("Year: ");
      TextField YearField = new TextField();

      Label Semester = new Label("Semester: ");
      ComboBox<String> SemesterCB = new ComboBox<>();
      SemesterCB.getItems().addAll("Spring", "Summer", "Fall", "Winter");

      Label Grades = new Label("Grade: ");
      ComboBox<Character> GradesCB = new ComboBox<>();
      GradesCB.getItems().addAll('A','B','C','D','F', 'P','N', 'W');  
      Button FindEnrollBTN = new Button("Find Enrollment");
      Button EditEnrollBTN = new Button("Edit Enrollment");
      HBox  EditBTNBox = new HBox(10, FindEnrollBTN , EditEnrollBTN);

      VBox vbox1 = new VBox(10,  CourseID, StudID, Year, Semester, Grades);
      vbox1.setAlignment(Pos.CENTER_RIGHT);
      VBox vbox2 = new VBox(  CourseIDField, StudIDField, YearField, SemesterCB, GradesCB);
      HBox hbox = new HBox( vbox1, vbox2);
      hbox.setAlignment(Pos.CENTER);
      VBox fullBox = new VBox(x,  titleBox ,ErollIDBox,  hbox, EditBTNBox);
      EditBTNBox.setAlignment(Pos.CENTER);

      vbox1.setVisible(false);
      vbox2.setVisible(false);

      EditEnrollBTN.setDisable(true);

      FindEnrollBTN.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                  final int EnrollmentID = Integer.parseInt(EnrollIDField.getText());
                  Enrollment v = e.GetEnrollment(EnrollmentID);
                  if(v != null){
                     EnrollIDField.setEditable(false);
                     EditEnrollBTN.setDisable(true);
                     vbox1.setVisible(true);
                     vbox2.setVisible(true);

                     CourseIDField.setText(String.valueOf(v.CID));
                     StudIDField.setText(String.valueOf(v.SID));
                     YearField.setText(v.year);
                     SemesterCB.setValue(v.semester);
                     GradesCB.setValue(v.grade);
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR,"Enrollment Not Found" ,ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      EditEnrollBTN.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                  final int EnrollmenID = Integer.parseInt(EnrollIDField.getText());
                  final int CourseID =  Integer.parseInt(CourseIDField.getText());
                  final int StudentID =  Integer.parseInt(StudIDField.getText());
                  final String Year = YearField.getText();
                  final String Semester = SemesterCB.getValue();
                  final char Grade = GradesCB.getValue();

                  if (e.updateEnrollment(EnrollmenID, CourseID, StudentID, Year,Semester, Grade)){
                     Alert alert = new Alert(Alert.AlertType.NONE, "Enrollment ID: " + EnrollmenID + "\nCourse ID: " + CourseID + "\nStudent ID: " + StudentID +"\nSemester: " + Semester + " " + Year + "\nGrade: " + Grade , ButtonType.OK);
                     alert.setHeaderText("Enrollment Was Updated");
                     alert.showAndWait();
                     CourseIDField.clear();
                     StudIDField.clear();
                     YearField.clear();
                     SemesterCB.setValue(null);
                     GradesCB.setValue(null);
                     EnrollIDField.clear();
                     EnrollIDField.setEditable(true);
                     EditEnrollBTN.setDisable(true);

                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Enrollment Was Not Updated", ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(NumberFormatException NFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, "ID Field was Left Blank", ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });
      Scene EditEnrollmentScene = new Scene(fullBox, 400, 270);

      primaryStage.setScene(EditEnrollmentScene);
   }
   static void CreateViewEnrollmentScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);

      Label ViewEnrollmenrTitle = new Label("View Enrollment: ");
      Label EnrollmentID = new Label("Enrollment ID: ");
      TextField EnrollIDField = new TextField();
      HBox EnrollIDBox = new HBox( EnrollmentID, EnrollIDField);

      Label EnrollIDlb = new Label();
      Label CourseID = new Label();
      Label StudentID = new Label();
      Label Year = new Label();
      Label Semester = new Label();
      Label Grade = new Label();  

      VBox f = new VBox (EnrollIDlb, CourseID, StudentID, Year, Semester, Grade);
      f.setAlignment(Pos.CENTER);
      f.setVisible(false);



      Button FindEnroll = new Button("Find Enrollment");
      FindEnroll.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try {
                  final int EnrollmentID = Integer.parseInt(EnrollIDField.getText());
                  Enrollment v = e.GetEnrollment(EnrollmentID);
                  if(v != null){
                     EnrollIDlb.setText("Enrollment ID: " + EnrollmentID);
                     CourseID.setText("Course ID: " + v.CID);
                     StudentID.setText("Student ID: " + v.SID);
                     Year.setText("Year: " + v.year);
                     Semester.setText("Semester: " + v.semester);
                     Grade.setText("Grade: " + v.grade);

                     f.setVisible(true);
                     FindEnroll.setText("Find Another Enrollment");
                  }
                  else{
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Enrollment was not Found", ButtonType.OK);
                     alert.showAndWait();
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });

      EnrollIDBox.setAlignment(Pos.CENTER);
      VBox e = new VBox(x, ViewEnrollmenrTitle, EnrollIDBox , FindEnroll);
      e.setAlignment(Pos.CENTER);

      VBox AddStudentVBox = new VBox(10, e,f);
      f.setAlignment(Pos.CENTER);
    // Create a Scene with the HBox as its root node.
      Scene viewEnrollScene = new Scene(AddStudentVBox, 400, 270);
    // Set the scene's alignment to center
    // Add the Scene to the Stage.
      primaryStage.setScene(viewEnrollScene);

    // Show the window.
      primaryStage.show();
   }
   static void CreateReportScene(Stage primaryStage){
      MenuBar x = createMenueBar(primaryStage);
    //Add Student Scen
      Label ReportTitle = new Label("Report ");
      Label CourseName = new Label("Course Name: ");
      TextField CourseNameField = new TextField();
      Label Semester = new Label("Semester: ");
      ComboBox<String> SemesterCB = new ComboBox<>();
      SemesterCB.getItems().addAll("Spring", "Summer", "Fall", "Winter");
      Label Year = new Label("Year: ");
      TextField YearField = new TextField();
      Label FieldNames = new Label("StudentID   Student Name   Semester   Year   Grade");
      VBox LabelBox = new VBox(10, CourseName, Semester, Year);
      VBox FieldBox = new VBox( CourseNameField, SemesterCB, YearField);

      HBox InputBox = new HBox( LabelBox, FieldBox);
      InputBox.setAlignment(Pos.CENTER);

      TextArea ReportArea = new TextArea();
      ReportArea.setVisible(false);
      Button GenerateReport = new Button("Generate Report");

      GenerateReport.setOnAction(
         new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                  final String CourseName = CourseNameField.getText();
                  final String Semester = SemesterCB.getValue();
                  final String Year = YearField.getText();
                  if (e.FindStudentsEnrolled(CourseName, Semester, Year) == null){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "Course was not found", ButtonType.OK);
                     alert.showAndWait();
                  }
                  else if (e.FindStudentsEnrolled(CourseName, Semester, Year) == ""){
                     Alert alert = new Alert(Alert.AlertType.ERROR, "No Student was enrolled", ButtonType.OK);
                     alert.showAndWait();
                  }
                  else{
                     ReportArea.setText(e.FindStudentsEnrolled(CourseName, Semester, Year)); 
                     ReportArea.setVisible(true);
                  }
               }
               catch (EmptyFieldException EFE){
                  Alert alert = new Alert(Alert.AlertType.ERROR, EFE.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
               catch(IOException ioe){
                  System.out.println("Error: " + ioe.getMessage());
               }
               catch(Exception exc){
                  Alert alert = new Alert(Alert.AlertType.ERROR, exc.getMessage(), ButtonType.OK);
                  alert.showAndWait();
               }
            }
         });


      VBox ReportVBox = new VBox(x, ReportTitle, InputBox, GenerateReport,FieldNames, ReportArea);
      Scene viewEnrollScene = new Scene(ReportVBox, 400, 300);
      primaryStage.setScene(viewEnrollScene);
      primaryStage.show();

   }
}
class EmptyFieldException extends Exception{
   EmptyFieldException(String message){
      super(message);
   }
}