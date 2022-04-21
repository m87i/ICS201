package application;
	




import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class Test3GUI extends Application {
	private Label status = new Label("status: ");
	private TextArea TextA = new TextArea();
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			HBox HB = new HBox();
			Label File = new Label("File: ");
			TextField FName = new  TextField();
			Button open = new Button("Open");
			open.setOnAction(e -> {
				try {
					checkFile(FName.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			Button save = new Button("Save");
			save.setOnAction(e -> {
				try {
					modiFile(FName.getText());
					status.setText("status: File saved");
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			Button clear = new Button("Clear");
			HB.getChildren().addAll(File , FName , open , save , clear);
			root.setTop(HB);
			
			ScrollBar sbHorizontal = new ScrollBar();
			ScrollBar sbVertical = new ScrollBar();
			sbVertical.setOrientation(Orientation.VERTICAL);
			
			Pane paneForText = new Pane();
			paneForText.getChildren().add(TextA);
			BorderPane BPceneter = new BorderPane();
			BPceneter.setCenter(paneForText);
			BPceneter.setBottom(sbHorizontal);
			BPceneter.setRight(sbVertical);
			root.setCenter(BPceneter);
			root.setBottom(status);
			
			clear.setOnAction(e-> {BPceneter.setCenter(new TextArea());
			BPceneter.getChildren().removeAll(sbHorizontal,sbVertical);
			status.setText("status: cleared");
			});
			
			Scene scene = new Scene(root,320,250);
			primaryStage.setTitle("Test3 GUI");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkFile (String s) throws FileNotFoundException {
		File check = new File(s);
		Scanner rd = new Scanner(check);
		if(check.exists()) {
			String textarea = "";
		while(rd.hasNextLine()) {
			textarea += rd.nextLine() +"\n";
		}
		rd.close();
			TextA.setText(textarea);
			status.setText("status: File loaded");
		}else 
			status.setText("status: File Does not Exist");
		
	}
	
	public void modiFile (String s) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(s);
		System.out.println(TextA.getText());
		pw.print(TextA.getText());
		pw.close();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
