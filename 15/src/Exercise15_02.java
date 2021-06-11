import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
public class Exercise15_02 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rectangle = new Rectangle(50, 50, 100, 70);
		rectangle.setStroke(Color.RED);
		rectangle.setFill(Color.RED);
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(new Insets(30, 10, 10, 10));
	    vBox.setSpacing(50);
		Button rotateButton = new Button("Rotate");
		rotateButton.setOnAction(e -> rectangle.setRotate(rectangle.getRotate() + 15));

		vBox.getChildren().addAll(rectangle, rotateButton);
		Scene scene = new Scene(vBox);
		primaryStage.setTitle("Exercise 15_02");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}