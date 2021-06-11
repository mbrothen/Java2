

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise14_03 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 52; i++){
			list.add(i);
		}
		java.util.Collections.shuffle(list);
		HBox pane = new HBox(5);
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(new ImageView("image/card/"+list.get(0)+".png"));
		pane.getChildren().add(new ImageView("image/card/"+list.get(1)+".png"));
		pane.getChildren().add(new ImageView("image/card/"+list.get(2)+".png"));

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_03"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
