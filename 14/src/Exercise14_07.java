
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
public class Exercise14_07 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5);
		pane.setVgap(5);
		//loop through each row and column
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				//generate random number and determine x o or blank and set image
				TextField text = new TextField((int)(Math.random() * 2)+"");
				text.setPrefColumnCount(1);
				text.setAlignment(Pos.CENTER);
				pane.add(text, j, i);

			}
		}
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_07"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
