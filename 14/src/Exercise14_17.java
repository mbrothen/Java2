import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;

public class Exercise14_17 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Line body = new Line(0, 0, 0, -100);
		Line leftLeg = new Line(0, 0, -40, 50);
		Line rightLeg = new Line(0, 0, 40, 50);
		Line leftArm = new Line(0, -80, -50, -70);
		Line rightArm = new Line(0, -80, 50, -70);
		Ellipse head = new Ellipse(0, -120, 20, 20);
		head.setFill(Color.WHITE);
		head.setStroke(Color.BLACK);
		Line noose = new Line(0, -140, 0, -160);
		Line gallowArm = new Line(0, -160, -120, -160);
		Line gallowUpright = new Line(-120, -160, -120, 70);
		Arc base = new Arc(-120, 80, 40, 30, 180, -180);
		base.setStroke(Color.BLACK);
		base.setFill(Color.WHITE);
		Group group = new Group();
		group.getChildren().addAll(body, leftLeg, rightLeg, leftArm, rightArm, head, noose, gallowArm, gallowUpright, base);

		Scene scene = new Scene(new BorderPane(group), 450, 450);
		primaryStage.setTitle("Exercise 14_17");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}
}
