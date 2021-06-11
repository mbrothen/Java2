import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class Exercise15_18  extends Application{
	int xCord = 200, yCord = 200;
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Rectangle rectangle = new Rectangle(xCord, yCord, 40, 60);
		pane.getChildren().addAll(rectangle);
		rectangle.setOnMouseDragged(e -> {
			rectangle.setX(e.getX());
			rectangle.setY(e.getY());
		});

		//Create scene and put on stage
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise 15_18");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
	  launch(args);
  }
}
