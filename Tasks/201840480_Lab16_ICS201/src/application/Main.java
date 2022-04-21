package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;



public class Main extends Application {
	private ImageView []images;
	private int i = 0;
	private Pane pane = new Pane();
	
	@Override
	public void start(Stage primaryStage) {
		
     HBox hBox = new HBox();
     hBox.setSpacing(10);
     hBox.setAlignment(Pos.CENTER);
     Button Next = new Button("Next");
     Button Previous = new Button("Previous");
     hBox.getChildren().add(Next);
     hBox.getChildren().add(Previous);
     
     images = new ImageView[] { new ImageView("http://162.144.86.232/wp-content/uploads/2016/11/ittihad-banner-702x291.png") ,
    		 new ImageView("https://icon2.cleanpng.com/20180407/kqq/kisspng-a-c-milan-uefa-champions-league-serie-a-uefa-euro-1000-5ac87f335e86a5.6495886415230892033872.jpg") ,
    		 new ImageView("https://upload.wikimedia.org/wikipedia/ar/0/02/KSA-Badge.png") ,
    		 new ImageView("https://banner2.cleanpng.com/20190222/kej/kisspng-borussia-dortmund-bundesliga-football-bvb-home-l-bvb-borussia-dortmund-5c6fe2ce373928.8296180115508364302262.jpg"),
    		 new ImageView("https://upload.wikimedia.org/wikipedia/ar/e/e1/Manchester_United_FC.png")
    		 } ;
     images[i].setFitHeight(pane.getHeight());
     images[i].setFitWidth(pane.getWidth());
     pane.getChildren().add(images[i]);
     
     Next.setOnAction(new NextHandler());
     Previous.setOnAction(new PreviousHandler());
     BorderPane borderPane = new BorderPane();
     borderPane.setCenter(pane);
     borderPane.setBottom(hBox);
     BorderPane.setAlignment(hBox, Pos.CENTER);
			
			
     Scene scene = new Scene(borderPane, 300, 300);
     primaryStage.setTitle("Images"); // Set the stage title
     primaryStage.setScene(scene); // Place the scene in the stage
     primaryStage.show();
		
	}
	
	class NextHandler implements EventHandler<ActionEvent> {
	    @Override // Override the handle method
	    public void handle(ActionEvent e) {
	      i++;
	      if(i ==images.length ) 
	    	  i = 0;
	      pane.getChildren().clear();
	      pane.getChildren().add(images[i]);
	      images[i].setFitHeight(pane.getHeight());
	      images[i].setFitWidth(pane.getWidth());

	      
	    }
	  }
	  
	  class PreviousHandler implements EventHandler<ActionEvent> {
		    @Override // Override the handle method
		    public void handle(ActionEvent e) {
		    	 i--;
			      if(i <0 ) 
			    	  i = images.length-1;
			      pane.getChildren().clear();
			      pane.getChildren().add(images[i]);
			      images[i].setFitHeight(pane.getHeight());
			      images[i].setFitWidth(pane.getWidth()); 
		    }
		  }
	
	public static void main(String[] args) {
		launch(args);
	}
}
