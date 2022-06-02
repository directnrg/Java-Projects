package gettingStudentInformation;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;  
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;  
import javafx.stage.Stage;  

public class StudentInfo extends Application {
	private String [] studentCourses;
	//private String [] studentActivities;
	private Button buttonDisplay;
	private CheckBox studentCheckBox;
	private CheckBox volunteerCheckBox;
	private RadioButton radioBtnComp;
	private RadioButton radioBtnBusiness;
	private TextField [] allTextFields;
	//private List<String> courseChoice;
	//private ListView<String> coursesList;
	
	
	public static void main(String[] args) {  
		launch(args);     
		} 
	
	@Override  
	public void start(Stage primaryStage) {  
	   
		 // Create a border pane 
	    BorderPane bPane = new BorderPane();
	    
	 // Place nodes in the pane
	    bPane.setCenter(fieldsInfo()); 
	    bPane.setLeft(labelsVBox());
	    bPane.setRight(studentXpVbox());
	    bPane.setBottom(bottomPane());
	    bPane.setTop(checkFields());
	    
	    //Create scene and placed in the stage
	    Scene scene=new Scene(bPane);  
	    primaryStage.setScene(scene);  // Place the scene in the stage
	    primaryStage.setTitle("Student Information");  
	    primaryStage.show();  // Display the stage
	    	    
	}
	
	private VBox labelsVBox() {
			    
		VBox labels = new VBox(15);
	    labels.setPadding(new Insets(15, 5, 5, 5));
	    		
		// labels
		Label [] infoLabels = {
				new Label("Name:"),
				new Label("Adress:"), 
				new Label("Province:"),
				new Label("City:"),
				new Label("Postal:"),
				new Label("Phone:"),
				new Label("Email:")
				};
		
		 for (Label info : infoLabels) {
		      labels.setMargin(info, new Insets(0, 0, 0, 15));
		      labels.getChildren().add(info);
		    }
		 
		 return labels;
	}
	
	private HBox checkFields() {
		
		HBox checkHbox = new HBox();
		checkHbox.setPadding(new Insets(10)); // Set all sides to 10
		checkHbox.setSpacing(8); 
		
		//check boxes
		studentCheckBox = new CheckBox("Student Council");
		volunteerCheckBox = new CheckBox("Volunteer");
		//add checkboxes to pane
		checkHbox.getChildren().addAll(studentCheckBox,volunteerCheckBox);
		return checkHbox;
	}
	
	private VBox fieldsInfo() {
		 
		VBox fieldsVbox = new VBox();
		fieldsVbox.setPadding(new Insets(10)); // Set all sides to 10
		fieldsVbox.setSpacing(8); 
		
		//text fields matching the same amount of labels
		allTextFields = new TextField[7];
		for (int i = 0; i < allTextFields.length; i++  ) {
		
		allTextFields[i] = new TextField();
		}
		
		for (TextField text : allTextFields) {
			fieldsVbox.setMargin(text, new Insets(0, 0, 0, 15));
			fieldsVbox.getChildren().add(text);
		}
		
		return fieldsVbox;
	}

		
	private VBox studentXpVbox() {
		
		VBox studentXp = new VBox();
		studentXp.setPadding(new Insets(10)); // Set all sides to 10
		studentXp.setSpacing(8); 
		
		 //combo box
        ComboBox<String> coursesComboBox = new ComboBox<String>();
        coursesComboBox.setVisibleRowCount(3);
        coursesComboBox.setPrefSize(300, 50);
        
        //list of displayed items
        ListView<String> coursesList = new ListView<String>();
        coursesList.setPrefSize(1, 100);
        List<String> courseChoice = new ArrayList<>();
        ObservableList<String> listModel = FXCollections.observableArrayList();
        ObservableList<String> computerScienceCourses = FXCollections.observableArrayList("Java", "C#", "Advanced Database", 
        		"Web Application Development", "Discrete Maths");
        ObservableList<String> businessCourses = FXCollections.observableArrayList("Finances", "Business Marketing",
        		"Business Administration", "Finance", "Accounting");
		
        
      //radio buttons
	    radioBtnComp = new RadioButton("Computer Science"); 
	    radioBtnBusiness = new RadioButton("Business");  
	  
	    
	    ToggleGroup radioBtnsGroup = new ToggleGroup();  
	    radioBtnComp.setToggleGroup(radioBtnsGroup);  
	    radioBtnBusiness.setToggleGroup(radioBtnsGroup); 
	    
	    radioBtnsGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton selected = (RadioButton) radioBtnsGroup.getSelectedToggle();

                if (selected.getText().equals("Computer Science")) {
                	coursesComboBox.getSelectionModel().clearSelection();
                    listModel.clear();
                    coursesComboBox.setItems(computerScienceCourses);
                } else if (selected.getText().equals("Business")) {
                	coursesComboBox.getSelectionModel().clearSelection();
                     listModel.clear();
                     coursesComboBox.setItems(businessCourses);
                }
            }
        });
	    
	    coursesComboBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String courseSelected = coursesComboBox.getValue().toString();
                if (!courseChoice.contains(courseSelected)) {
                    courseChoice.add(courseSelected);
                    studentCourses = new String[courseChoice.size()];
                    for (int i = 0; i < studentCourses.length; i++)

                    	studentCourses[i] = courseChoice.get(i);
                    	coursesList.getItems().clear();
                    coursesList.getItems().addAll(studentCourses);
                }
            }
        });
	    
	    studentXp.getChildren().addAll(radioBtnComp, radioBtnBusiness, coursesComboBox, coursesList);
        
		return studentXp;
		
	}	

	private AnchorPane bottomPane() {

        AnchorPane anchorpane = new AnchorPane();
  
        
        //Declaring Text Area to display information
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(60);
        textArea.setPrefRowCount(7);
        textArea.setEditable(false);
        
        buttonDisplay = new Button("Display");
	    		
        buttonDisplay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String myCourses = "";
                String otherActivities = "";

                if (studentCheckBox.isSelected() && volunteerCheckBox.isSelected()) {
                    otherActivities = studentCheckBox.getText() + " - " + volunteerCheckBox.getText();
                } else if (studentCheckBox.isSelected() && !volunteerCheckBox.isSelected()) {
                    otherActivities = studentCheckBox.getText();
                } else if (volunteerCheckBox.isSelected() && !studentCheckBox.isSelected()) {
                    otherActivities = volunteerCheckBox.getText();
                } else if (!studentCheckBox.isSelected() && !studentCheckBox.isSelected()) {
                    otherActivities = "No activities";
                }


                for (int i = 0; i < studentCourses.length; i++) {
                   
                    	myCourses = myCourses + studentCourses[i] + ", ";	
 
                }
                	

                textArea.setText(String.format("%s, %s, %s, %s, %s, %s, %s, %n%s: %s, %n%s: %s", allTextFields[0].getText(), allTextFields[1].getText(),
                		allTextFields[2].getText(), allTextFields[3].getText(),allTextFields[4].getText(), allTextFields[5].getText(), allTextFields[6].getText(),"Activities",
                        otherActivities, "Courses", myCourses));
                
               
            }
        });
		 HBox bottomHb = new HBox();
	        bottomHb.setPadding(new Insets(10, 10, 10, 10));
	        bottomHb.setSpacing(10);
	        bottomHb.getChildren().addAll(buttonDisplay, textArea);
	        
	 
	        anchorpane.getChildren().addAll(bottomHb);
	        // Anchor buttons to bottom right, anchor grid to top
	        AnchorPane.setBottomAnchor(bottomHb, 8.0);
       
        return anchorpane;
 
	}
}	 

