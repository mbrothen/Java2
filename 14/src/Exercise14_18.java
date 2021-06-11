import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Line;

public class Exercise14_18 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
	    Polyline polyline = new Polyline();
	    ObservableList<Double> list = polyline.getPoints();

	    double scaleFactor = 0.0125;
	    for (int x = -100; x <= 100; x++) {
	      list.add(x + 200.0);
	      list.add(200 - scaleFactor * x * x);
	    }
	    Line lineX = new Line(10, 200, 390, 200);
	    Line lineY = new Line(200, 30, 200, 390);

	    Text x = new Text(350, 200, "X");
	    Text y = new Text(220, 30, "Y");
	    Line yArrowLeft = new Line(200, 30, 180, 50);
	    Line yArrowRight = new Line(200, 30, 220, 50);
	    Line xArrowTop = new Line(390, 200, 370, 220);
	    Line xArrowBottom = new Line(390, 200, 370, 180);
		Group group = new Group();
		group.getChildren().addAll(polyline, lineX, lineY, x, y, yArrowLeft, yArrowRight, xArrowTop, xArrowBottom);
		Scene scene = new Scene(new BorderPane(group), 400, 300);
		primaryStage.setTitle("Exercise 14_21");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}
}
