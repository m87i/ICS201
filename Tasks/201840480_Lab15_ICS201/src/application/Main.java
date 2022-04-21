package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	private Circle circle = new Circle();
	private Pane pane = new Pane(circle);
	private Scene  scene = new Scene (pane , 400 , 400);
	@Override
	public void start(Stage primaryStage) {
		try {
		primaryStage.setTitle("Lab15");
		
		circle.setRadius(50);
		circle.setCenterX(150);
		circle.setCenterY(150);
		circle.setOnMouseClicked(new MovHandler());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void RandomMethod () {
		circle.setCenterX(Math.random()*(scene.getWidth()-(2*circle.getRadius()))+50);
		circle.setCenterY(Math.random()*(scene.getHeight()-(2*circle.getRadius()))+50);
		circle.setFill(Color.color(Math.random()*1, Math.random()*1, Math.random()*1));
		
	}
	
	class MovHandler implements EventHandler<MouseEvent> {
	    @Override // Override the handle method
	    public void handle(MouseEvent e) {
	    	RandomMethod ();
	    }
	  }
	
	public static void main(String[] args) {
		launch(args);
	}
}
