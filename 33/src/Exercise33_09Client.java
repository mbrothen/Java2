import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.io.*;
import java.net.*;

public class Exercise33_09Client extends Application{
		// GUI Elements
		private Label serverLabel = new Label("Server");
		private TextArea serverChatTextArea = new TextArea();
		private Label clientLabel = new Label("Client");
		private TextArea clientChatTextArea = new TextArea();
		private String serverName = "Server: ";
		private String clientName = "Client: ";
		//Server Information
		String host = "localhost";
		DataOutputStream toServer = null;
		DataInputStream fromServer = null;

		@Override
		public void start(Stage primaryStage) throws Exception {

			//vertical box to hold everything
			VBox vBox = new VBox();
			vBox.setAlignment(Pos.TOP_LEFT);
			clientChatTextArea.setEditable(true);
			serverChatTextArea.setEditable(false);
			clientChatTextArea.setWrapText(true);
			serverChatTextArea.setWrapText(true);
			vBox.getChildren().addAll(serverLabel, serverChatTextArea, clientLabel, clientChatTextArea);

			Scene scene = new Scene(vBox);
			primaryStage.setTitle("Exercise_33_09Client"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage.

			//add event for enter key
			clientChatTextArea.setOnKeyPressed(e -> {
				if(e.getCode() == KeyCode.ENTER){
					try {
						toServer.writeUTF(clientChatTextArea.getText().trim());
						serverChatTextArea.appendText(clientName + clientChatTextArea.getText() + "\n");
						toServer.flush();
						clientChatTextArea.setText("");

					} catch(IOException exe) {
						System.out.println("Error");
					}
			}});
			new Thread(() -> {
				try {
					Socket socket = new Socket(host, 8005);
					toServer = new DataOutputStream(socket.getOutputStream());
					fromServer = new DataInputStream(socket.getInputStream());
					while(true) {
						serverChatTextArea.appendText(serverName + fromServer.readUTF() + "\n");
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}).start();
		}



		public static void main(String[] args) {
			// TODO Auto-generated method stub
		    launch(args);
		}
}
