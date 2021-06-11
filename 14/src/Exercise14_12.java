import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class Exercise14_12 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle project = new Rectangle(10, -40, 100, 40);
		project.setStroke(Color.RED);
		project.setFill(Color.RED);
		Rectangle quiz = new Rectangle(120, -20, 100, 20);
		quiz.setStroke(Color.BLUE);
		quiz.setFill(Color.BLUE);
		Rectangle midterm = new Rectangle(230, -60, 100, 60);
		midterm.setStroke(Color.GREEN);
		midterm.setStroke(Color.GREEN);
		Rectangle test = new Rectangle(340, -80, 100, 80);
		test.setStroke(Color.ORANGE);
		test.setFill(Color.ORANGE);

		Group group = new Group();
		group.getChildren().addAll(new Text(10, -50, "Project -- 20%"), project, new Text(120, -30, "Quiz -- 10%"), quiz, new Text(230, -70, "Midterm -- 30%"), midterm, new Text(340, -90, "Final -- 40%"), test);


		Scene scene = new Scene(new BorderPane(group), 450, 250);
		primaryStage.setTitle("Exercise 14_12");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
