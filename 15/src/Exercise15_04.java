import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Exercise15_04 extends Application{
	//input boxes
	private TextField firstNumber = new TextField();
	private TextField secondNumber = new TextField();
	private TextField resultBox = new TextField();
	//calculate buttons
	private Button addButton = new Button("Add");
	private Button subtractButton = new Button("Subtract");
	private Button multiplyButton = new Button("Multiply");
	private Button divideButton = new Button("Divide");
	@Override
	public void start(Stage primaryStage) throws Exception {
		//vertical box to hold everything
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);

		//Box for inputs and for buttons
		HBox buttonBox = new HBox(5);
		buttonBox.setAlignment(Pos.CENTER);
		HBox inputBox = new HBox(5);
		inputBox.setAlignment(Pos.CENTER);

		//style the text boxes, lock the result
		firstNumber.setPrefColumnCount(4);
		secondNumber.setPrefColumnCount(4);
		resultBox.setPrefColumnCount(4);
		resultBox.setEditable(false);

		//add inputs to their boxes
		inputBox.getChildren().addAll(new Label("Number1: "), firstNumber,new Label("Number2: "), secondNumber, new Label("Result: "), resultBox);
		buttonBox.getChildren().addAll(addButton, subtractButton, multiplyButton, divideButton);
		vBox.getChildren().addAll(inputBox, buttonBox);

		//add events for buttons
		addButton.setOnAction(e -> add());
		subtractButton.setOnAction(e -> subtract());
		multiplyButton.setOnAction(e -> multiply());
		divideButton.setOnAction(e -> divide());
		//add pane and button to vbox
		Scene scene = new Scene(vBox);
		primaryStage.setTitle("Exercise_15_04"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}
	private void add() {
		resultBox.setText(String.valueOf(Double.parseDouble(firstNumber.getText()) +	Double.parseDouble(secondNumber.getText())));
	}
	private void subtract() {
		resultBox.setText(String.valueOf(Double.parseDouble(firstNumber.getText()) -	Double.parseDouble(secondNumber.getText())));
	}
	private void multiply(){
		resultBox.setText(String.valueOf(Double.parseDouble(firstNumber.getText()) *	Double.parseDouble(secondNumber.getText())));
	}
	private void divide(){
		if (Double.parseDouble(secondNumber.getText()) == 0){
			resultBox.setText(String.valueOf("Error"));
		} else {
			resultBox.setText(
				String.valueOf(Double.parseDouble(firstNumber.getText())
				/	Double.parseDouble(secondNumber.getText()))
			);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
