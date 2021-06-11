import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Exercise14_21 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		double x1 = (Math.random() * 450), x2 = (Math.random() * 450), y1 = (Math.random() * 450), y2 = (Math.random() * 450), distance;

		Circle circle1 = new Circle(x1, y1, 15);
		Circle circle2 = new Circle(x2, y2, 15);
		Line connectingLine = new Line(x1, y1, x2, y2);
		distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		Text label = new Text(((x1+x2)/2), ((y1+y2)/2), Double.toString(distance));
		pane.getChildren().addAll(circle1, circle2, connectingLine, label);

		Scene scene = new Scene(pane, 550, 550);
		primaryStage.setTitle("Exercise 14_18");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}
}
