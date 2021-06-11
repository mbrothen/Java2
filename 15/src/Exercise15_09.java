import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Exercise15_09 extends Application {
	int xCord = 200, yCord = 200;

  @Override
  public void start(Stage primaryStage) {
    // Create UI
    Pane pane = new Pane();
    Path path = new Path(new MoveTo(xCord, yCord));
    pane.getChildren().add(path);

    pane.setOnKeyPressed(e -> {
      switch (e.getCode()) {
      	case DOWN:
      		yCord += 2;
      		break;
      	case UP:
      		yCord -= 2;
      		break;
      	case RIGHT:
      		xCord += 2;
      		break;
      	case LEFT:
      		xCord -=2;
      		break;
      }
      	path.getElements().add(new LineTo(xCord, yCord));
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 400, 400);
    primaryStage.setTitle("Exercise15_09"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    path.requestFocus();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

