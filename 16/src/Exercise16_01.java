import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Exercise16_01  extends Application {
	protected Text text = new Text(50, 50, "Programming is...");
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		//Radio Buttons
		ToggleGroup group = new ToggleGroup();
		RadioButton redRadioButton = new RadioButton("Red");
		redRadioButton.setToggleGroup(group);
		RadioButton yellowRadioButton = new RadioButton("Yellow");
		yellowRadioButton.setToggleGroup(group);
		RadioButton blackRadioButton = new RadioButton("Black");
		blackRadioButton.setToggleGroup(group);
		RadioButton orangeRadioButton = new RadioButton("Orange");
		orangeRadioButton.setToggleGroup(group);
		RadioButton greenRadioButton = new RadioButton("Green");
		greenRadioButton.setToggleGroup(group);
		HBox radioButtonBox = new HBox(5);
		radioButtonBox.getChildren().addAll(redRadioButton, yellowRadioButton, blackRadioButton, orangeRadioButton, greenRadioButton);
		radioButtonBox.setAlignment(Pos.CENTER);
		radioButtonBox.setPadding(new Insets(5, 5, 5, 5));

		//Buttons
		Button backButton = new Button("<=");
		Button forwardButton = new Button("=>");
		HBox buttonBox = new HBox(5);
		buttonBox.getChildren().addAll(backButton, forwardButton);
		buttonBox.setAlignment(Pos.CENTER);

		//Text Area
		Pane textPane = new Pane();
		textPane.getChildren().add(text);
		textPane.setStyle("-fx-border-color: black");
		Font textFont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
		text.setFont(textFont);

		//Put boxes in pane
		pane.setTop(radioButtonBox);
		pane.setCenter(textPane);
		pane.setBottom(buttonBox);

		//Create button actions
		backButton.setOnAction(e -> text.setX(text.getX()-10));
		forwardButton.setOnAction(e -> text.setX(text.getX() + 10));

		//Handle radio buttons
		redRadioButton.setOnAction(e -> {
			if (redRadioButton.isSelected()){
				text.setFill(Color.RED);
			}
		});
		yellowRadioButton.setOnAction(e -> {
			if (yellowRadioButton.isSelected()){
				text.setFill(Color.YELLOW);
			}
		});
		blackRadioButton.setOnAction(e -> {
			if (blackRadioButton.isSelected()){
				text.setFill(Color.BLACK);
			}
		});
		orangeRadioButton.setOnAction(e -> {
			if (orangeRadioButton.isSelected()){
				text.setFill(Color.ORANGE);
			}
		});
		greenRadioButton.setOnAction(e -> {
			if (greenRadioButton.isSelected()){
				text.setFill(Color.GREEN);
			}
		});

		//Create Scene
		Scene scene = new Scene(pane, 500, 200);
		primaryStage.setTitle("Exercise 16_01");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
	  launch(args);
	}
}

