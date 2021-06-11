import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_30 extends Application{
	private int index = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {
		Image[] image = new Image[25];;
	    for (int i = 0; i < 25; i++) {
	      image[i] = new Image("image/slide" + i + ".jpg");
	    }
	    ImageView images = new ImageView(image[0]);
		StackPane pane = new StackPane();
		pane.getChildren().add(images);


		Scene scene = new Scene(pane, 800, 600);
		primaryStage.setTitle("Exercise_15_30"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.

		//Slideshow animation
		Timeline slideshow = new Timeline(
			new KeyFrame(Duration.millis(2000), e -> {
				if (index < 25){
					images.setImage(image[++index]);
				}
				else {
					index = 0;
					images.setImage(image[0]);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    launch(args);
	}

}
