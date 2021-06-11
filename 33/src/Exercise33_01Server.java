import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise33_01Server extends Application{
	TextArea ta = new TextArea();
	@Override
	public void start(Stage primaryStage) {

		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("Exercise 33_01Server");
		primaryStage.setScene(scene);
		primaryStage.show();

new Thread( () -> {
	try{
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(8000);
		Platform.runLater(() ->
			ta.appendText("Server started at " + new Date() + '\n'));
		//listen for connection
		Socket socket = serverSocket.accept();

		//create data streams
		DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
		DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
		while(true) {
			Date dateConnectectionCreated = new Date();
			double annualInterestRate = inputFromClient.readDouble();
			int numberOfYears = inputFromClient.readInt();
			double loanAmount = inputFromClient.readDouble();
			//create loan object from input
			Loan currentLoan = new Loan(annualInterestRate, numberOfYears, loanAmount);

			//Send loan terms to client
			outputToClient.writeDouble(currentLoan.getMonthlyPayment());
			outputToClient.writeDouble(currentLoan.getTotalPayment());

			Platform.runLater(() -> {
				ta.appendText("Connected to client at " + dateConnectectionCreated + '\n');
				ta.appendText("Annual Interest Rate: " + currentLoan.getAnnualInterestRate() + '\n');
				ta.appendText("Number Of Years: " + currentLoan.getNumberOfYears() + '\n');
				ta.appendText("Loan Amount: " + currentLoan.getLoanAmount() + '\n');
				ta.appendText("Monthly Payment: " + currentLoan.getMonthlyPayment() + '\n');
				ta.appendText("Total Payment: " + currentLoan.getTotalPayment() + '\n');
			});

		}

	} catch(IOException ex) {
		ex.printStackTrace();
	}
}).start();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}
}



