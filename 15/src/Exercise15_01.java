import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Exercise15_01 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);

		Button refreshButton = new Button("Refresh");
		HBox pane = new HBox(5);
		getCards(pane);
		pane.setAlignment(Pos.CENTER);

		//event for refresh button, call for new cards
		refreshButton.setOnAction(e -> getCards(pane));
		//add pane and button to vbox
		vBox.getChildren().addAll(pane, refreshButton);

		Scene scene = new Scene(vBox);
		primaryStage.setTitle("Exercise_15_01"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}
	private void getCards(HBox pane) {
		//clear hbox, get new cards add to pane
		pane.getChildren().clear();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 52; i++){
			list.add(i);
		}
		java.util.Collections.shuffle(list);
		pane.getChildren().add(new ImageView("image/card/"+list.get(0)+".png"));
		pane.getChildren().add(new ImageView("image/card/"+list.get(1)+".png"));
		pane.getChildren().add(new ImageView("image/card/"+list.get(2)+".png"));
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
