
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Exercise14_02 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Image imageX = new Image("image/x.gif");
		Image imageO = new Image("image/o.gif");
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5);
		pane.setVgap(5);
		//loop through each row and column
		for (int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++){
				//generate random number and determine x o or blank and set image
				int roll = (int)(Math.random() * 3);
				if (roll == 0) {
					pane.add(new ImageView(imageX), i, j);
				}
				else if (roll == 1) {
					pane.add(new ImageView(imageO), i, j);
				}
			}
		}
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_02"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
