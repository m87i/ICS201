package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	private String [] student ;
	private String [] IDs ; 
	private Student [] s ;
	private int size = 0;
	@Override //StudentsUnsorted.txt , StudentsSortedByID.txt
	public void start(Stage primaryStage) {
		try {
			VBox vbox = new VBox();
			BorderPane borderPane = new BorderPane();
            borderPane.setStyle("-fx-background-color: #26A7FF;-fx-border-color: #3a3e43;-fx-border-width: 4px;");
			StackPane sp = new StackPane();
			vbox.setSpacing(10);
			vbox.setAlignment(Pos.CENTER);
			Button Load = new Button("Load"); Load.setMaxSize(150, 200);
			Load.setStyle("-fx-background-color: #FF5126 ; -fx-font-size: 2em;");
			Button Sort = new Button("Sort"); Sort.setMaxSize(150, 200);
			Sort.setStyle("-fx-background-color: #FF5126 ; -fx-font-size: 2em;");
			Button Save = new Button("Save"); Save.setMaxSize(150, 200);
			Save.setStyle("-fx-background-color: #FF5126 ; -fx-font-size: 2em;");
			vbox.getChildren().addAll(Load , Sort , Save);
			Text LoadText = new Text();LoadText.setFont(Font.font("Monotype Corsiva", 30)); 
			Text SortText = new Text();SortText.setFont(Font.font("Monotype Corsiva", 30));
			Text SaveText = new Text();SaveText.setFont(Font.font("Monotype Corsiva", 30));
			
			Load.setOnAction(e -> {
				try {
					Read();
					sp.getChildren().add(LoadText);
					LoadText.setText("The names was loaded successfully!");
					for (int i = 0 ; i<size ; i++) // this loop just to check in console 
						System.out.println(IDs[i]+" "+student[i]);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
			Sort.setOnAction(e -> {Sort();
			SortText.setText("The names was sorted successfully!");});//just to check in console 
			Save.setOnAction(e -> {Print();
			SaveText.setText("The names was saved successfully!");});//just to check in console 
			VBox vb = new VBox();
			vb.setAlignment(Pos.CENTER);
			vb.getChildren().addAll(SortText,SaveText);
			borderPane.setTop(sp);
			borderPane.setCenter(vbox);
			borderPane.setBottom(vb);
			Scene scene = new Scene(borderPane , 500 , 300);
			primaryStage.setTitle("Assignment2");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Read() throws FileNotFoundException {
		File file = new File("StudentsUnsorted.txt");
		Scanner rd = new Scanner(file);
		Scanner rd1 = new Scanner(file);
		while(rd.hasNextLine()) {
			rd.nextLine();
			size++;}
		rd.close();
		student = new String [size];
		IDs = new String [size];
		int j =0;
		while(rd1.hasNextLine()) {
			IDs[j]= rd1.next();
			student[j] = rd1.next();
			j++;
			
		}
		rd1.close();
	}
		
	public void Sort() {
		s = new Student [size] ;
		for(int i = 0 ; i < student.length ; i++)
		s[i] = new Student(IDs[i] ,student[i]);
		Arrays.sort(s);
		System.out.println("Sorted!");
		}
	
	public void Print() {
		File file = new File("StudentsSortedByID.txt");
		try {
			PrintWriter pw = new PrintWriter (file);
			for(int i = 0 ; i<s.length ; i++) {
				pw.println(s[i]);
			}
			pw.close(); System.out.println("Done!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

class Student implements Comparable<Student>{
	private String  Snames;
	private String  IDs ;
	
	public Student(String  IDs , String Snames ) {
		this.IDs = IDs;
		this.Snames = Snames;
	}
	
	
	
	
	public String getSnames() {
		return Snames;
	}




	public void setSnames(String snames) {
		Snames = snames;
	}




	public String getIDs() {
		return IDs;
	}




	public void setIDs(String iDs) {
		IDs = iDs;
	}




	@Override
	public int compareTo(Student St) {
		
		return getIDs().compareTo(St.getIDs());
	}
	
	
	public String toString() {
		return getIDs()+" "+ getSnames();
	}
	
	
	
}
