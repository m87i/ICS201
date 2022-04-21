package application;



import java.util.ArrayList;
import java.util.Random;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Memorygame extends Application{
	private String imageSource[] = new String[16];
	private GridPane gridpane = new GridPane();
	private BorderPane borderpane = new BorderPane();
	private Button buttons[] = new Button[16] , PlayAgain;
	private Image images[] = new Image[16];
	private static String URLsorces[] = new String [8] ;
	private ImageView imageView[] = new ImageView[16];
	private static int indx1=16,indx2=16;          //The value 16 is to know if indx1 or indx2 were pressed
	private static AudioClip wrongsound  , correctsound , finshsound;
	private static boolean state = true ;
	private static  int PIXL =100 , Try = 0, wrong = 0, correct = 0 ;   //PIXL is the height and width of all buttons
	private static Label TryCounter, WrongCounter, CorrectCounter, TimeCounter, TryName ,
	WrongName , CorrectName , TimeName,topScore,TopScoreLabel;
	private Text Winner ;
	private Long startTime = System.currentTimeMillis(), endTime ;
	private  int topScoreCounter =0;
	public void start(Stage primaryStage) throws Exception {
		setImageName();
		setImages();
		StartGame();
		

		

		PlayAgain = new Button("PlayAgain");
		PlayAgain.setPrefHeight(25);
		PlayAgain.setPrefWidth(PIXL);
		PlayAgain.setOnAction( e ->
		{ try {
			PlayAgain(primaryStage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		} );
		gridpane.setConstraints(PlayAgain, 3, 4);

		gridpane.setPadding(new Insets(20, PIXL, PIXL, PIXL));
		gridpane.setVgap(5);
		gridpane.setHgap(5);
		gridpane.setStyle("-fx-background-color: #DAE7EF;");
	   
		gridpane.getChildren().addAll(buttons);
		gridpane.getChildren().addAll(PlayAgain , CorrectName, CorrectCounter, WrongName, WrongCounter, TryName, TryCounter, 
				TimeCounter, TimeName,TopScoreLabel,topScore);
		borderpane = new BorderPane();
		borderpane.setCenter(gridpane);
		Scene scene = new Scene(borderpane,630,680);
		 primaryStage.setScene(scene);
		 primaryStage.setResizable(false);
		 primaryStage.setTitle("MemoryGame");
		 primaryStage.show();
	}

	public static void main(String[] args) {
        getImageName(); 
		launch(args);
	}
	
	public void StartGame() {
		for(int i=0;i < buttons.length;i++) {
			
			
			int x= i;
			buttons[i].setOnMousePressed(e ->{ System.out.println("again here handler");test(x);
		      
			});
		}
		
		CorrectName = new Label("Correct");
		CorrectName.setFont(new Font(18));
		GridPane.setConstraints(CorrectName, 0, 4);
		CorrectCounter = new Label("0");
		CorrectCounter.setFont(new Font(18));
		GridPane.setConstraints(CorrectCounter, 1, 4);

		//wrong counter
		WrongName = new Label("Wrongs");
		WrongName.setFont(new Font(18));
		GridPane.setConstraints(WrongName, 0, 5);
		WrongCounter = new Label("0");
		WrongCounter.setFont(new Font(18));
		GridPane.setConstraints(WrongCounter, 1, 5);
	
	//Try counter
		TryName = new Label("Try");
		TryName.setFont(new Font(18));
		GridPane.setConstraints(TryName, 0, 6);
		TryCounter = new Label("0");
		TryCounter.setFont(new Font(18));
		GridPane.setConstraints(TryCounter, 1, 6);
		
		TimeName = new Label("Time");
		TimeName.setFont(new Font(18));
		GridPane.setConstraints(TimeName, 0, 7);
		TimeCounter = new Label("0");
		TimeCounter.setFont(new Font(14));
		GridPane.setConstraints(TimeCounter, 1, 7);
	
		 TopScoreLabel= new Label("TopScore");
		 TopScoreLabel.setFont(new Font(18));
		GridPane.setConstraints(TopScoreLabel, 0, 8);
		topScore = new Label(""+topScoreCounter);
		topScore.setFont(new Font(14));
		GridPane.setConstraints(topScore, 1, 8);
	}
	
	public static void getImageName() {
		URLsorces[0]="https://e.top4top.io/p_17947wsmm9.png"; //Cat
		URLsorces[1]="https://b.top4top.io/p_1794gn8k66.png"; //owl
		URLsorces[2]="https://h.top4top.io/p_1794wqpee2.png"; //horse
		URLsorces[3]="https://i.top4top.io/p_1794f54ik3.png"; //wolf
		URLsorces[4]="https://d.top4top.io/p_1794sdube8.png"; //zebra
		URLsorces[5]="https://a.top4top.io/p_1794ctjis5.png"; //lion
		URLsorces[6]="https://l.top4top.io/p_17945upg24.png"; //falcon
		URLsorces[7]="https://g.top4top.io/p_1794z50711.png"; //tiger
		wrongsound = new AudioClip("https://c.top4top.io/m_1800gbmah1.mp3");
		correctsound =  new AudioClip("https://d.top4top.io/m_1800axflg2.mp3");
		finshsound = new AudioClip("https://g.top4top.io/m_1800p27br1.mp3");
	}
	
	
	public void setImages() {
		for (int i =  0 ; i <16; i++) {
			images[i] = new Image( imageSource[i] , PIXL, PIXL, true, true);
		}
		
		int i=0;
		for(int j =0;j<4;j++) {
			for(int x =0;x<4 ;x++) {
		imageView[i] = new ImageView(images[i]);
		gridpane.setConstraints(imageView[i], x, j);
		imageView[i].setFitHeight(PIXL);
		imageView[i].setFitWidth(PIXL);
		buttons[i] = new Button(); 
		gridpane.setConstraints(buttons[i], x, j);
		buttons[i].setPrefHeight(PIXL);
		buttons[i].setPrefWidth(PIXL);
	
		i++;
		
			}
		}	
		
	}
	
	
	public void setImageName(){
		ArrayList<Integer> z = new ArrayList<>(16);
		Random r = new Random();
		int random ;
		getImageName();
		
		for (int i = 0 ; z.size()< 16 ; i++) {
			random = r.nextInt(16);
			if (!z.contains(random))
				z.add(random);
		}
		
		for(int i = 0 ; i < z.size() ; i++) {
			if(z.get(i)<8) {
				switch (z.get(i)) {
				case 0:
					imageSource[i]= URLsorces[0];
					break;
				case 1:
					imageSource[i]= URLsorces[1];
					break;
				case 2:
					imageSource[i]= URLsorces[2];
					break;
				case 3:
					imageSource[i]= URLsorces[3];
					break;
				case 4:
					imageSource[i]= URLsorces[4];
					break;
				case 5:
					imageSource[i]= URLsorces[5];
					break;
				case 6:
					imageSource[i]= URLsorces[6];
					break;
				default :
					imageSource[i]= URLsorces[7];
					break;
					
				}
					
			} else {
				int x  = z.get(i)-8;
				switch (x) {
				case 0:
					imageSource[i]= URLsorces[0];
					break;
				case 1:
					imageSource[i]= URLsorces[1];
					break;
				case 2:
					imageSource[i]= URLsorces[2];
					break;
				case 3:
					imageSource[i]= URLsorces[3];
					break;
				case 4:
					imageSource[i]= URLsorces[4];
					break;
				case 5:
					imageSource[i]= URLsorces[5];
					break;
				case 6:
					imageSource[i]= URLsorces[6];
					break;
				default :
					imageSource[i]= URLsorces[7];
					break;
					
				}
				
			}
			
		}
		
		
	}
	
	public  void test(int x) {
		if(state) {
			indx1 =x;
			state = false;
			correctsound.stop();
			wrongsound.stop();
			gridpane.getChildren().add(imageView[x]);
			System.out.println("indx1 and image show");
		}else {
			indx2 = x;
			state = true;
			gridpane.getChildren().add(imageView[x]);
			System.out.println("indx2 and shold be shown");
			
			buttons[indx2].setOnMouseReleased(e-> {check();
			});
			
			  Try++;
			  
					
				
		
				
			} 
			TryCounter.setText(""+Try);
			WrongCounter.setText(""+ wrong);
			CorrectCounter.setText(""+correct);
			
		}
	  public void check() {
		 
		  if(indx1 < 16 & indx2 < 16) {
		  if(imageSource[indx1].toString() == imageSource[indx2].toString()) {  
			    buttons[indx1].setDisable(true);
				buttons[indx2].setDisable(true);
			    indx1 =16; indx2= 16;
				correct++;
				if (correct<8) {
					correctsound.play();
				}
				else if (correct==8) {
					endTime = System.currentTimeMillis();
					float T = endTime-startTime;
					T/=1000F;
					finshsound.play();
					TimeCounter.setText(""+T+" s");
					Winner = new Text("Winner");
					Winner.setFont(Font.font("Monotype Corsiva", 45));
					StackPane sp = new StackPane();
					sp.getChildren().add(Winner);
					borderpane.setTop(sp);
                    if(topScoreCounter == 0) {
                    	topScoreCounter = correct+wrong;
                    	topScore.setText(""+topScoreCounter);
                    }else if(topScoreCounter > Try) {
                    	topScoreCounter = Try;
                    	topScore.setText(""+topScoreCounter);
                    }
				}
			}else {   System.out.println("if 7");
				wrongsound.play();
				try {
					Thread.sleep(800);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gridpane.getChildren().remove(imageView[indx1]);
				gridpane.getChildren().remove(imageView[indx2]);
				
				indx1 =16; indx2 =16;
				wrong++;
			}
		  }     
	}
	
	public void CleanUp() {
		correct = wrong = Try = 0;
		TryCounter.setText("0");
		CorrectCounter.setText("0");
		WrongCounter.setText("0");
	}
	
	public void PlayAgain(Stage stage) throws Exception {
		CleanUp();
		gridpane.getChildren().clear();
		start(stage);
   
	}
	
}


