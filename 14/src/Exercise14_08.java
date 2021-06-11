
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise14_08 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 54; i++){
			list.add(i);
		}
		java.util.Collections.shuffle(list);
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5);
		pane.setVgap(5);
		int currentCard = 0; //holds the index of the array
		for(int i = 0; i<6; i++){
			for(int j = 0; j<9; j++){
				pane.add(new ImageView("image/card/"+list.get(currentCard)+".png"), j, i);
				currentCard++; //gets the next index
			}
		}
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_08"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
