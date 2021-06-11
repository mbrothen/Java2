import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise16_03  extends Application{
	private Pane lightPane;
	private Circle redLight, yellowLight, greenLight;
	final String green = "green";
	final String yellow = "yellow";
	final String red = "red";
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();

		//Radio Buttons
		ToggleGroup group = new ToggleGroup();
		RadioButton redRadioButton = new RadioButton("Red");
		redRadioButton.setToggleGroup(group);
		RadioButton yellowRadioButton = new RadioButton("Yellow");
		yellowRadioButton.setToggleGroup(group);
		RadioButton greenRadioButton = new RadioButton("Green");
		greenRadioButton.setToggleGroup(group);
		HBox radioButtonBox = new HBox(5);
		radioButtonBox.getChildren().addAll(redRadioButton, yellowRadioButton, greenRadioButton);
		radioButtonBox.setAlignment(Pos.CENTER);
		radioButtonBox.setPadding(new Insets(5, 5, 5, 5));

		//Create lights
		lightPane = getLights();

		//Put boxes in pane
		pane.setCenter(lightPane);
		pane.setBottom(radioButtonBox);

		//Handle radio buttons
		redRadioButton.setOnAction(e -> {
			if (redRadioButton.isSelected()){
				lightOn(red);
			}
		});
		yellowRadioButton.setOnAction(e -> {
			if (yellowRadioButton.isSelected()){
				lightOn(yellow);
			}
		});
		greenRadioButton.setOnAction(e -> {
			if (greenRadioButton.isSelected()){
				lightOn(green);
			}
		});
		//Create Scene
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Exercise 16_03");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public Pane getLights(){
		Pane pane = new Pane();
		Rectangle outside = new Rectangle(160, 25, 100, 300);
		outside.setFill(Color.TRANSPARENT);
		outside.setStroke(Color.BLACK);
		redLight = new Circle(210, 70, 40, Color.TRANSPARENT);
		redLight.setStroke(Color.RED);
		yellowLight = new Circle(210, 170, 40, Color.TRANSPARENT);
		yellowLight.setStroke(Color.YELLOW);
		greenLight = new Circle(210, 275, 40, Color.TRANSPARENT);
		greenLight.setStroke(Color.GREEN);
		pane.getChildren().addAll(outside, redLight, yellowLight, greenLight);
		return pane;
	}
	public void lightOn(String light){
		//Process turning off and on lights based on string passed on button click
		switch (light){
			case "red":
				redLight.setFill(Color.RED);
				greenLight.setFill(Color.TRANSPARENT);
				yellowLight.setFill(Color.TRANSPARENT);
				break;
			case "yellow":
				yellowLight.setFill(Color.YELLOW);
				redLight.setFill(Color.TRANSPARENT);
				greenLight.setFill(Color.TRANSPARENT);
				break;
			case "green":
				greenLight.setFill(Color.GREEN);
				redLight.setFill(Color.TRANSPARENT);
				yellowLight.setFill(Color.TRANSPARENT);
		}

	}
	public static void main(String[] args) {
	  launch(args);
	}
}

