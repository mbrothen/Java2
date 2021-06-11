import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Exercise15_29  extends Application{
	private double x = 0, y = 100;
	private Timeline animation;
	@Override
	public void start(Stage primaryStage) {
		CarPane car = new CarPane();
		//change speed based on arrow keys
		car.setOnKeyPressed(e -> {
			switch (e.getCode()){
				case UP:
					animation.setRate(animation.getRate()+1);
					break;
				case DOWN:
					//decrease speed down to 0, stop at 0
					animation.setRate(animation.getRate() > 0?(animation.getRate()-1): 0);
					break;
			}
		});
		//pause and resume on mouse pressed and released
		car.setOnMousePressed(e-> animation.pause());
		car.setOnMouseReleased(e -> animation.play());
		//Create scene and put on stage
		Scene scene = new Scene(car, 800, 100);
		primaryStage.setTitle("Exercise 15_29");
		primaryStage.setScene(scene);
		primaryStage.show();
		car.requestFocus();
	}

	class CarPane extends Pane {
		public CarPane(){
			makeCar();
			animateCar();
		}
		public void makeCar(){
			getChildren().clear();
			Rectangle body = new Rectangle(x,y-20, 50, 10);
			body.setStroke(Color.BLACK);
			body.setFill(Color.RED);
			Circle tire1 = new Circle(x+15, y-5, 5);
			Circle tire2 = new Circle(x+35, y-5, 5);
			Polygon roof = new Polygon(x+10, y-20, x+20, y-30, x+30, y-30, x+40, y-20);
			roof.setFill(Color.TRANSPARENT);
			roof.setStroke(Color.BLACK);
			getChildren().addAll(body, tire1, tire2, roof);
		}
		public void animateCar(){
			animation = new Timeline(
					new KeyFrame(Duration.millis(50), e-> moveCar()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.setRate(1);
			animation.play();
		}
		public void moveCar(){
			//change x to move car, if past window width start at 0
			x=(x<=getWidth()? x+1: 0);
			makeCar();
		}

	}
	public static void main(String[] args) {
	  launch(args);
	}
}

