import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Exercise16_06 extends Application {
	protected TextField mainTextField = new TextField();
	protected TextField columnSizeTextField = new TextField();

	@Override
	public void start(Stage primaryStage) {
		// Create textfield
		mainTextField.setText("JavaFX");
		mainTextField.setAlignment(Pos.BOTTOM_CENTER);
		columnSizeTextField.setAlignment(Pos.BOTTOM_RIGHT);
		columnSizeTextField.setPrefColumnCount(3);
		mainTextField.setPrefColumnCount(12);
		columnSizeTextField.setText("12");

		// Create radio buttons
		RadioButton leftRadioButton = new RadioButton("Left");
		RadioButton centerRadioButton = new RadioButton("Center");
		RadioButton rightRadioButton = new RadioButton("Right");
		centerRadioButton.setSelected(true);

		// Create a toggle group
		ToggleGroup group = new ToggleGroup();
		leftRadioButton.setToggleGroup(group);
		centerRadioButton.setToggleGroup(group);
		rightRadioButton.setToggleGroup(group);

		// Create hbox
		HBox paneForRadioButtons = new HBox(5);
		paneForRadioButtons.getChildren().addAll(leftRadioButton, centerRadioButton, rightRadioButton);
		paneForRadioButtons.setAlignment(Pos.BOTTOM_LEFT);

		HBox paneForColumnSize = new HBox(5);
		paneForColumnSize.getChildren().addAll(
			new Label("Colum Size"), columnSizeTextField);

		HBox paneForTextField = new HBox(5);
		paneForTextField.setAlignment(Pos.CENTER);
		paneForTextField.getChildren().addAll(
			new Label("Text Field"), mainTextField);

		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(paneForRadioButtons, paneForColumnSize);

		// Create a vBox and place nodes in it
		VBox pane = new VBox(10);
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.getChildren().addAll(paneForTextField, hbox);

		// Set Button actions
		leftRadioButton.setOnAction(e -> {
			if (leftRadioButton.isSelected()) {
				mainTextField.setAlignment(Pos.BOTTOM_LEFT);
			}
		});

		centerRadioButton.setOnAction(e -> {
			if (centerRadioButton.isSelected()) {
				mainTextField.setAlignment(Pos.BOTTOM_CENTER);
			}
		});

		rightRadioButton.setOnAction(e -> {
			if (rightRadioButton.isSelected()) {
				mainTextField.setAlignment(Pos.BOTTOM_RIGHT);
			}
		});

		columnSizeTextField.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				mainTextField.setPrefColumnCount(Integer.parseInt(
					columnSizeTextField.getText()));
			}
		});

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_16_06");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		  launch(args);
		}
}