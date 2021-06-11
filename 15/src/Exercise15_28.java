import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
public class Exercise15_28  extends Application{
	@Override
	public void start(Stage primaryStage) {
		FanPane fan = new FanPane();
		Button pauseButton = new Button("Pause");
		Button resumeButton = new Button("Resume");
		Button reverseButton = new Button("Reverse");
		BorderPane pane = new BorderPane();
		HBox buttonBox = new HBox(5);
		buttonBox.getChildren().addAll(pauseButton, resumeButton, reverseButton);
		buttonBox.setAlignment(Pos.CENTER);
		pane.setCenter(fan);
		pane.setBottom(buttonBox);
		//Create animation
		RotateTransition rotateCircle = new RotateTransition(Duration.millis(4000), fan);
		rotateCircle.setByAngle(360);
		rotateCircle.setCycleCount(Timeline.INDEFINITE);
		rotateCircle.play();
		//Set button action
		pauseButton.setOnAction(e -> rotateCircle.stop());
		resumeButton.setOnAction(e -> rotateCircle.play());
		reverseButton.setOnAction(e -> rotateCircle.setRate((rotateCircle.getRate() * -1)));
		//Create scene and put on stage
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise 15_28");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	class FanPane extends StackPane {
		private Circle circle = new Circle(100);
		public FanPane() {
			Pane blades = getBlades();
			getChildren().addAll(circle, blades);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
		}


	private Pane getBlades() {
		Pane pane = new Pane();
		double angle = 0;
		for (int i = 0; i < 4; i++) {
			Arc arc = new Arc(200, 185, 90, 90, angle + 90, 50);
			arc.setFill(Color.BLACK);
			arc.setType(ArcType.ROUND);
			pane.getChildren().add(arc);
			angle += 90;
		}
		 return pane;
		}
	}
	public static void main(String[] args) {
	  launch(args);
	}
}

