

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Exercise16_22  extends Application{
	final AudioClip anthemAudioClip = new AudioClip(new File("src/audio/uk.mp3").toURI().toString());
	@Override
	public void start(Stage primaryStage) {
		Button playButton = new Button("Play");
		Button loopButton = new Button("Loop");
		Button stopButton = new Button("Stop");
		HBox buttonBox = new HBox(5);
		buttonBox.getChildren().addAll(playButton, loopButton, stopButton);
		buttonBox.setAlignment(Pos.CENTER);

		//Set button action
		playButton.setOnAction(e -> anthemAudioClip.play());
		loopButton.setOnAction(e -> anthemAudioClip.setCycleCount(AudioClip.INDEFINITE)	);
		stopButton.setOnAction(e -> anthemAudioClip.stop());
		//Create scene and put on stage
//		pane.getChildren().add(buttonBox);
		Scene scene = new Scene(buttonBox, 200, 100);
		primaryStage.setTitle("Exercise 16_22");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
	  launch(args);
	}
}

