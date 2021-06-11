import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
public class Exercise15_03 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		pane.setPrefSize(500, 400);
		//make circle
		Circle ball = new Circle();
		ball.setCenterX(250);
		ball.setCenterY(200);
		ball.setRadius(20);

	    //make buttons, set actions
		HBox hbox = new HBox();
		Button leftButton = new Button("Left");
		Button rightButton = new Button("Right");
		Button upButton = new Button("Up");
		Button downButton = new Button("Down");

		leftButton.setOnAction(e -> move(pane, "left", ball));
		rightButton.setOnAction(e -> move(pane, "right", ball));
		upButton.setOnAction(e -> move(pane, "up", ball));
		downButton.setOnAction(e -> move(pane, "down", ball));
		hbox.getChildren().addAll(leftButton, rightButton, upButton, downButton);


		//Create the scene
		hbox.setAlignment(Pos.CENTER);
		pane.setCenter(ball);
		pane.setBottom(hbox);
		Scene scene = new Scene(pane);

		primaryStage.setTitle("Exercise 15_03");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void move(Pane pane, String direction, Circle ball){
		pane.getChildren().remove(ball);
		//process button if center of ball is not outside frame
		 	if (direction == "left") {
				if(ball.getCenterX()>20)
					ball.setCenterX(ball.getCenterX()-10);
			} else if (direction =="right"){
				if (ball.getCenterX() < 480)
					ball.setCenterX(ball.getCenterX()+10);
			} else if (direction == "up") {
				if (ball.getCenterY() > 30)
					ball.setCenterY(ball.getCenterY() -10);
			} else if (direction == "down") {
				if (ball.getCenterY() < 390)
					ball.setCenterY(ball.getCenterY() + 10);
			}
		pane.getChildren().add(ball);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}
}