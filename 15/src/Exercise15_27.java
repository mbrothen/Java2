import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
public class Exercise15_27  extends Application{
	int xCord = 200, yCord = 200;
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		Text scrollText = new Text("Matt can program things!! ¯\\_(ツ)_/¯");
		PathTransition path = new PathTransition(Duration.seconds(3), new Line(-120, 200, 520, 200), scrollText);
		path.setCycleCount(Timeline.INDEFINITE);
		path.play();
		pane.getChildren().addAll(scrollText);

		pane.setOnMousePressed(e -> path.pause());
		pane.setOnMouseReleased(e -> path.play());

		//Create scene and put on stage
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise 15_27");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
	  launch(args);
  }
}

