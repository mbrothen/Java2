import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_28 extends Application{
	private int index = 0;
	private final static int SLIDE_COUNT = 10;
	private String[] textSlides = new String[SLIDE_COUNT];
	@Override
	public void start(Stage primaryStage) throws Exception {
		readTextToArray();
	    TextArea textArea = new TextArea();
	    textArea.setWrapText(true);

	    StackPane pane = new StackPane();
	    pane.getChildren().add(new ScrollPane(textArea));


		Scene scene = new Scene(pane, 600, 300);
		primaryStage.setTitle("Exercise_16_28"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.

		//Slideshow animation
		Timeline slideshow = new Timeline(
			new KeyFrame(Duration.millis(2000), e -> {
				if (index < SLIDE_COUNT-1){
					textArea.setText(textSlides[index]);
					index = (index + 1);
				} else {
					index = 0;
					textArea.setText(textSlides[index]);
				}
				})
			);
		slideshow.setCycleCount(Timeline.INDEFINITE);
		slideshow.play();

		//Mouse event pause/resume

		pane.setOnMouseClicked(e -> {
		      if (slideshow.getStatus() == Animation.Status.PAUSED) {
		        slideshow.play();
		      }
		      else {
		        slideshow.pause();
		      }
		    });

	}
	private void readTextToArray() {
		for (int i = 0; i < SLIDE_COUNT; i++){
			textSlides[i] = importText("text/slide" + i + ".txt");
		}
	}
	private String importText(String currentTextFile) {
		String text = "";
		try {
			java.util.Scanner input = new java.util.Scanner(
					new java.io.File(currentTextFile)
					);
			while (input.hasNext()) {
				text += input.nextLine() + "\n";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return text;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
