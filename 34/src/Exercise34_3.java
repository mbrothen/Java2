import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise34_3 extends Application {
	@Override
	public void start(Stage primaryStage){
	DBConnectionPane dbPane = new DBConnectionPane();

	Scene scene = new Scene(dbPane, 600, 300);
	primaryStage.setTitle("DBConnectionPane");
	primaryStage.setScene(scene);
	primaryStage.show();

}
public static void main(String[] args) {
	  launch(args);
	}
}
