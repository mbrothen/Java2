import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.io.*;
import java.net.*;
import java.util.Date;

public class Exercise33_09Server extends Application{
		// GUI Elements
		private Label serverLabel = new Label("Server");
		private TextArea serverChatTextArea = new TextArea();
		private Label clientLabel = new Label("Client");
		private TextArea clientChatTextArea = new TextArea();
		private String serverName = "Server ";
		private String clientName = "Client ";

		//Server Information
		String host = "localhost";
		DataOutputStream toServer = null;
		DataInputStream fromServer = null;

		@Override
		public void start(Stage primaryStage) throws Exception {

			//vertical box to hold everything
			VBox vBox = new VBox();
			vBox.setAlignment(Pos.TOP_LEFT);

			clientChatTextArea.setEditable(false);
			serverChatTextArea.setEditable(true);
			clientChatTextArea.setWrapText(true);
			serverChatTextArea.setWrapText(true);

			vBox.getChildren().addAll(clientLabel, clientChatTextArea, serverLabel, serverChatTextArea);

			//add pane vbox
			Scene scene = new Scene(vBox);
			primaryStage.setTitle("Exercise_33_09Server"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage.
			new Thread( () -> {
				try{
					@SuppressWarnings("resource")
					ServerSocket serverSocket = new ServerSocket(8005);
					Socket socket = serverSocket.accept();
					DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
					DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

					Platform.runLater(() ->
						clientChatTextArea.appendText("Server started at " + new Date() + '\n'));
					//create data streams
					while(true) {
						serverChatTextArea.setOnKeyPressed(e -> {
							if(e.getCode() == KeyCode.ENTER){

								String currentMessage = serverChatTextArea.getText().trim();
								//serverChatTextArea.clear();
								try{
									outputToClient.writeUTF(currentMessage);
									outputToClient.flush();
									clientChatTextArea.appendText(serverName + serverChatTextArea.getText() + "\n");
									serverChatTextArea.setText("");

								}catch (Exception ex){
									ex.printStackTrace();
								}
							}});
						clientChatTextArea.appendText(clientName + inputFromClient.readUTF() + "\n");
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
