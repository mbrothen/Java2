import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import java.util.*;
public class Exercise14_23 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle rectangle1 = generateRectangle(1);
		Rectangle rectangle2 = generateRectangle(2);
		String message = testRectangles(rectangle1, rectangle2);
		Group group = new Group();
		group.getChildren().addAll(new Text(50, 400, message), rectangle1, rectangle2);

		Scene scene = new Scene((group), 450, 450);
		primaryStage.setTitle("Exercise 14_23");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public Rectangle generateRectangle(double number) {
		Scanner input = new Scanner(System.in);
		// Get starting point, width and height
		System.out.println("Enter center point of rectangle " + number);
		System.out.print("X cordinate: ");
		double centerX = input.nextDouble();
		System.out.print("Y cordinate: ");
		double centerY = input.nextDouble();

		System.out.print("Enter width: ");
		double width = input.nextDouble();
		System.out.print("Enter height: ");
		double height = input.nextDouble();
		//find starting and ending coordinates of rectangle from user input
		double startX = (centerX - (width /2));
		double startY = (centerY - (height / 2));
		Rectangle currentRectangle = new Rectangle(startX, startY, width, height);
		currentRectangle.setStroke(Color.BLACK);
		currentRectangle.setFill(Color.TRANSPARENT);

		return currentRectangle;
}
	public String testRectangles(Rectangle rectangle1, Rectangle rectangle2) {
		String message;
		if (rectangle1.getBoundsInLocal().contains(rectangle2.getBoundsInLocal())){
			message = "Rectangle 2 is in Rectangle 1";
		}
		else if (rectangle2.getBoundsInLocal().contains(rectangle1.getBoundsInLocal())){
			message = "Rectangle 1 is in Rectangle 2";
		} else if (rectangle1.getBoundsInLocal().intersects(rectangle2.getBoundsInLocal())) {
			message = "Both Rectangles intersect";
		}
		else {
			message = "The rectangles do not touch";
		}
		return message;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
