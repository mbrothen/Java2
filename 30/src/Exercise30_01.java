import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;


public class Exercise30_01 extends Application{
	private TextArea mainTextArea = new TextArea();
	private  Pane pane = new Pane();

	@Override
	public void start(Stage primaryStage) throws Exception {
        mainTextArea.setWrapText(true);
        mainTextArea.setPrefColumnCount(30);
        mainTextArea.setPrefRowCount(10);

		Runnable printA = new PrintChar('a', 100, mainTextArea);
		Runnable printB= new PrintChar('b', 100, mainTextArea);
		Runnable print100 = new PrintNum(100, mainTextArea);

		//Create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);

		//Start threads
		thread1.start();
		thread2.start();
		thread3.start();

		pane.getChildren().add(mainTextArea);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_30_01"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}
}
class PrintChar implements Runnable {
	private char charToPrint;
	private int times;
	private TextArea textArea;
	public PrintChar(char c, int t, TextArea textArea) {
		charToPrint = c;
		times = t;
		this.textArea = textArea;
	}

	@Override

	public void run(){
		for (int i = 0; i < times; i++) {
	//		System.out.print(charToPrint); //change this
			textArea.appendText(Character.toString(charToPrint));
		}
	}
}
class PrintNum implements Runnable {
	private int lastNum;
	private TextArea textArea;
	public PrintNum(int n, TextArea textArea){
		lastNum = n;
		this.textArea = textArea;
	}
	@Override
	public void run() {
		for (int i = 1; i <= lastNum; i++) {
			//System.out.print(" " + i);
			textArea.appendText(Integer.toString(i));
		}
	}
}