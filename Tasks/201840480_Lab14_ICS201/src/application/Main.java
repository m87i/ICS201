package application;
	


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("LAB14");
			StackPane pane;
			Text text = new Text("STOP");
			text.setFill(Color.WHITE);
			text.setFont(Font.font(115));
			pane = new StackPane(new MyPolygon(),text);
			Scene scene = new Scene(pane , 400 , 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

class MyPolygon extends Pane {
	  private void paint() {
	    
	    Polygon polygon = new Polygon();
	    polygon.setFill(Color.RED);
	    polygon.setStroke(Color.BLACK);
	    polygon.setStrokeWidth(8);
	    ObservableList<Double> list = polygon.getPoints();
	    
	    double centerX = getWidth() / 2, centerY = getHeight() / 2;
	    double radius = Math.min(getWidth(), getHeight()) * 0.4;

	   
	    for (int i = 0; i < 8; i++) {
	      list.add(centerX + radius * Math.cos(Math.PI/8 + 2 * i * Math.PI / 8)); 
	      list.add(centerY - radius * Math.sin(Math.PI/8 + 2 * i * Math.PI / 8));
	    }     
	    
	    getChildren().clear(); 
	    getChildren().add(polygon); 
	  }
	  
	  @Override
	  public void setWidth(double width) {
	    super.setWidth(width);
	    paint();
	  }
	  
	  @Override
	  public void setHeight(double height) {
	    super.setHeight(height);
	    paint();
	  }
	}
