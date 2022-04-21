package application;

//https://r1---sn-4g5ednsd.googlevideo.com/videoplayback?expire=1605730208&ei=QCu1X8bgFsKn7ASE_6GAAw&ip=185.147.213.62&id=o-AEJdFJjHFQ4uIpeX63v5WBVVhpQq7VuZJUj59fDkO3zW&itag=18&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&gir=yes&clen=32799533&ratebypass=yes&dur=419.816&lmt=1549997372597872&fvip=1&c=WEB&txp=5431432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAKtJ41VaLD3D_2fQSlG3SnGI5snYkVScaUEDE_2JSPEQAiA7JwJzGw1dvreG3j3Ox14tMbxe33-05f5Ao02KOAX6uw%3D%3D&redirect_counter=1&cm2rm=sn-q4fele7e&req_id=6ea3324ebe7aa3ee&cms_redirect=yes&mh=Jy&mip=79.139.41.107&mm=34&mn=sn-4g5ednsd&ms=ltu&mt=1605708504&mv=m&mvi=1&pl=24&lsparams=mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAPSaKs7yRCS9mSugoYD4L3H4kjaALPBbxjKbqyHrXc71AiEAmRgJFSdljzEaPmI9iO8NCB_Ao1KXqtSXV-36lJOgKA8%3D


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
//the path 
//--module-path "C:\Users\az\Documents\javaFX\openjfx-15.0.1_windows-x64_bin-sdk\javafx-sdk-15.0.1\lib" --add-modules=javafx.controls,javafx.fxml,javafx.media
public class Main extends Application {
  private static final String MEDIA_URL = 
    "https://liveexample.pearsoncmg.com/common/sample.mp4";
  BorderPane pane = new BorderPane();
  Media media = new Media(MEDIA_URL);
  MediaPlayer mediaPlayer = new MediaPlayer(media);
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    MediaView mediaView = new MediaView(mediaPlayer);
    mediaView.setFitWidth(pane.getWidth());
    mediaView.setFitHeight(pane.getHeight()); 

    Button StartButton = new Button("Start");
    StartButton.setOnAction(e -> mediaPlayer.play());
    Button PauseButton = new Button("Pause");
    PauseButton.setOnAction(e -> mediaPlayer.pause());
    Button StopButton = new Button("Stop");
    StopButton.setOnAction(e -> mediaPlayer.stop());
    Button rewindButton = new Button("<<");
    rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
    
    Slider slVolume = new Slider();
    slVolume.setPrefWidth(150);
    slVolume.setMaxWidth(Region.USE_PREF_SIZE);
    slVolume.setMinWidth(30);
    slVolume.setValue(50);
    mediaPlayer.volumeProperty().bind(
      slVolume.valueProperty().divide(100));
    HBox Th = new HBox(10);
    Th.setAlignment(Pos.CENTER);
    Label lb = new Label("File URL ");
    TextField url = new TextField();
    url.setPrefColumnCount(20);
    url.setOnAction(e -> {
    	mediaPlayer.stop();
    	mediaPlayer = new MediaPlayer(new Media(url.getText()));
    	mediaPlayer.volumeProperty().bind(
    		      slVolume.valueProperty().divide(100));
         mediaView.setMediaPlayer(mediaPlayer); 
    	
    } );
    Th.getChildren().addAll(lb, url);
    HBox hBox = new HBox(10);
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(StartButton,PauseButton, StopButton, rewindButton,
      new Label("Volume"), slVolume);

    
    pane.setTop(Th);
    pane.setCenter(mediaView);
    pane.setBottom(hBox);

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 650, 500);
    primaryStage.setTitle("MediaDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage    
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
 public static void main(String[] args) {
    launch(args);
  }
}