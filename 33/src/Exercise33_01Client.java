import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.io.*;
import java.net.*;

public class Exercise33_01Client extends Application{
	// GUI Elements
		private Label interestLabel = new Label("Annual Interest Rate");
		private TextField interestRateBox = new TextField();
		private Label termLengthLabel = new Label("Number Of Years");
		private TextField termLengthBox = new TextField();
		private Label principalLabel = new Label("Loan Amount");
		private TextField principalAmountBox = new TextField();
		private TextArea loanInfoArea = new TextArea();
		private Button submitButton = new Button("Submit");

		//Server Information
		String host = "localhost";
		DataOutputStream toServer = null;
		DataInputStream fromServer = null;

		@Override
		public void start(Stage primaryStage) throws Exception {
			//vertical box to hold everything
			VBox vBox = new VBox();
			vBox.setAlignment(Pos.TOP_RIGHT);
			//input grid pane
			GridPane inputPane = new GridPane();
			inputPane.add(interestLabel, 0, 0);
			inputPane.add(interestRateBox, 1, 0);
			inputPane.add(termLengthLabel, 0, 1);
			inputPane.add(termLengthBox, 1, 1);
			inputPane.add(principalLabel, 0, 2);
			inputPane.add(principalAmountBox, 1, 2);
			inputPane.add(submitButton, 2, 1);

			//style the text boxes, lock the result
			principalAmountBox.setPrefColumnCount(10);
			termLengthBox.setPrefColumnCount(10);
			interestRateBox.setPrefColumnCount(10);
			loanInfoArea.setPrefColumnCount(10);
			loanInfoArea.setEditable(false);

			vBox.getChildren().addAll(inputPane, loanInfoArea);

			//add events for buttons
			submitButton.setOnAction(e -> {
				try {
					double annualInterestRate = Double.parseDouble(interestRateBox.getText().trim());
					int numberOfYears = Integer.parseInt(termLengthBox.getText().trim());
					double loanAmount = Double.parseDouble(principalAmountBox.getText().trim());
					//create connection with server

					toServer.writeDouble(annualInterestRate);
					toServer.writeInt(numberOfYears);
					toServer.writeDouble(loanAmount);
					toServer.flush();

					//get payment info
					Double monthlyPayment = fromServer.readDouble();
					Double totalPayment = fromServer.readDouble();

					//Print loan info
					loanInfoArea.appendText("AnnualInterest Rate: " + annualInterestRate + '\n');
					loanInfoArea.appendText("Number Of Years: " + numberOfYears + '\n');
					loanInfoArea.appendText("Loan Amount: " + loanAmount + '\n');
					loanInfoArea.appendText("Monthly Payment: " + monthlyPayment + '\n');
					loanInfoArea.appendText("Total Payment: " + totalPayment + '\n');
				} catch(IOException ex) {
					loanInfoArea.appendText(ex.toString() + '\n');
				}
			});

				try {
					Socket socket = new Socket(host, 8000);

					fromServer = new DataInputStream(socket.getInputStream());
					toServer = new DataOutputStream(socket.getOutputStream());
				} catch (IOException ex) {
					loanInfoArea.appendText(ex.toString() + '\n');
				}

			//add pane and button to vbox
			Scene scene = new Scene(vBox);
			primaryStage.setTitle("Exercise_33_01Client"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage.
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
		    launch(args);
		}
}

