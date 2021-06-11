import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise15_5_Grid extends Application{
	//input boxes
	private TextField principalAmountBox = new TextField();
	private TextField termLengthBox = new TextField();
	private TextField interestRateBox = new TextField();
	private TextField futureValueBox = new TextField();
	//calculate buttons
	private Button calculateButton = new Button("Calculate");
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create grid pane, add elements
		GridPane pane = new GridPane();
		pane.setVgap(5);
		pane.setHgap(5);
		pane.add(new Label("Investment Amount:"), 0, 0);
		pane.add(new Label("Number of Years:"),  0, 1);
		pane.add(new Label("Annual Interest Rate:"), 0, 2);
		pane.add(new Label("Future value:"), 0, 3);
		pane.add(principalAmountBox, 1, 0);
		pane.add(termLengthBox, 1, 1);
		pane.add(interestRateBox, 1, 2);
		pane.add(futureValueBox, 1, 3);
		pane.add(calculateButton, 1, 4);

		pane.setAlignment(Pos.CENTER);
		principalAmountBox.setAlignment(Pos.BOTTOM_RIGHT);
		termLengthBox.setAlignment(Pos.BOTTOM_RIGHT);
		interestRateBox.setAlignment(Pos.BOTTOM_RIGHT);
		futureValueBox.setAlignment(Pos.BOTTOM_RIGHT);
		pane.setHalignment(calculateButton, HPos.RIGHT);
		pane.setPadding(new Insets(10, 10, 10, 10));
		futureValueBox.setEditable(false);

		//add events for buttons
		calculateButton.setOnAction(e -> calculate());

		//add pane and button to vbox
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_15_05"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}
	
	private void calculate() {
		//get values to make formulate easier to read
		double principal = Double.parseDouble(principalAmountBox.getText());
		double termLength = Double.parseDouble(termLengthBox.getText());
		double interest = Double.parseDouble(interestRateBox.getText());
		double futureValue = principal * Math.pow(1 + (interest / 1200), (termLength * 12));
		//set the futureValueBox with result
		futureValueBox.setText(String.valueOf(String.format("$%.2f", futureValue)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
