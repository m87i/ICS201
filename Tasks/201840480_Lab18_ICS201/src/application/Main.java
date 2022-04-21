package application;
	



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.BlurType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	 private CheckBox ChBold = new CheckBox("Bold");
	 private CheckBox ChItalic = new CheckBox("Italic");
	 private Text text = new Text("Programming is fun");
	 private ComboBox<String> Fname = new ComboBox<>();
	 private ComboBox<Integer> Fsize = new ComboBox<>();
	 private FontWeight Fw;
	 private FontPosture Fp;
	 private ScrollBar Red , Green , Blue ,  Opacity ;
	 
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		BorderPane bp = new BorderPane();
		text.setFont(Font.font("Times", 25));
		bp.setCenter(text);
		Fsize.setValue(25);
		HBox hbT = new HBox(4);
		hbT.setPadding(new Insets(10));
		
		 Fname.getItems().addAll(Font.getFontNames());
		
		 for (int i = 1 ; i<101 ; i++)
			  Fsize.getItems().add(i);
		 
		 
		   
		 hbT.getChildren().addAll(new Label("Font Name") , Fname  , new Label("Font Size") , Fsize);
		 
		 HBox hbB = new HBox (10);
		 
		 hbB.getChildren().addAll(ChBold , ChItalic);
		 hbB.setAlignment(Pos.BOTTOM_CENTER);
		 bp.setTop(hbT);
		 bp.setBottom(hbB);
		 pane.setTop(bp);
		
		
		Fname.setOnAction(e -> Font_Upd() );
		 Fsize.setOnAction(e -> Font_Upd ());
		 ChBold.setOnAction(e -> Font_Upd() );
		 ChItalic.setOnAction(e -> Font_Upd() );
		 
		 VBox SBvb = new VBox();
		 SBvb.setPadding(new Insets(10));
		 SBvb.setAlignment(Pos.CENTER);
		  Red = new ScrollBar();
		  Red.setMax(1);
		  Label Rl = new Label("Red");
		  Green = new ScrollBar();
		  Green.setMax(1); 
		  Label Gl = new Label("Green");
		  Blue = new ScrollBar();
		  Blue.setMax(1); 
		  Label Bl = new Label("Blue");
		  Opacity = new ScrollBar(); 
		  Opacity.setMax(1); Opacity.setValue(1);
		  Label Ol = new Label("Opacity");
		 SBvb.getChildren().addAll( Red , Rl, Green ,Gl , Blue, Bl , Opacity , Ol);
		 
		 Red.valueProperty().addListener(e -> Color() );
		 Green.valueProperty().addListener(e -> Color() );
		 Blue.valueProperty().addListener(e -> Color() );
		 Opacity.valueProperty().addListener(e -> Color() );
		 pane.setBottom(SBvb);
		Scene scene = new Scene(pane , 700 , 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Lab18");
		primaryStage.show();
	}
		
	public void Font_Upd() {
		if (ChBold.isSelected())
			Fw = FontWeight.BOLD;
		else 
			Fw = FontWeight.NORMAL;
		if (ChItalic.isSelected())
			Fp = FontPosture.ITALIC;
		else
			Fp = FontPosture.REGULAR;
		text.setFont(Font.font(Fname.getValue(), Fw , Fp ,Fsize.getValue()));
		
		

	}
	
	
	
	
	public void Color () {
		//text.setFill(new Color(Red.getValue(), Green.getValue(),
			//	 Blue.getValue() , Opacity.getValue())); we have tow ways to do it :)
		text.setFill(Color.color(Red.getValue(), Green.getValue(), Blue.getValue()));
		text.setOpacity(Opacity.getValue());
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
