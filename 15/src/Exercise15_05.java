import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Exercise15_05 extends Application{
	//input boxes
	private TextField principalAmountBox = new TextField();
	private TextField termLengthBox = new TextField();
	private TextField interestRateBox = new TextField();
	private TextField futureValueBox = new TextField();
	//calculate buttons
	private Button calculateButton = new Button("Calculate");
	@Override
	public void start(Stage primaryStage) throws Exception {
		//vertical box to hold everything
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.TOP_RIGHT);

		//Box for inputs and for buttons
		VBox inputBox = new VBox(5);
		inputBox.setAlignment(Pos.CENTER);
		HBox buttonBox = new HBox(5);
		buttonBox.setAlignment(Pos.BOTTOM_RIGHT);


		//style the text boxes, lock the result
		principalAmountBox.setPrefColumnCount(10);
		termLengthBox.setPrefColumnCount(10);
		interestRateBox.setPrefColumnCount(10);
		futureValueBox.setPrefColumnCount(10);
		futureValueBox.setEditable(false);

		//add inputs to their boxes
		inputBox.getChildren().addAll(new Label("Principal: "), principalAmountBox, new Label("Nunber of Years: "), termLengthBox, new Label("Interest Rate: "), interestRateBox, new Label("Future Value: "), futureValueBox);
		buttonBox.getChildren().addAll(calculateButton);
		vBox.getChildren().addAll(inputBox, buttonBox);

		//add events for buttons
		calculateButton.setOnAction(e -> calculate());
		
		//add pane and button to vbox
		Scene scene = new Scene(vBox);
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
