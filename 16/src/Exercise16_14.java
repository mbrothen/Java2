import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Exercise16_14 extends Application {
	protected Text text = new Text("Programming is fun");
	protected ComboBox<String> fontNameCombo = new ComboBox<>();
	protected ComboBox<String> fontSizeCombo = new ComboBox<>();
	protected CheckBox boldCheckBox = new CheckBox("Bold");
	protected CheckBox italicCheckBox = new CheckBox("Italic");

	@Override
	public void start(Stage primaryStage) {
		//add fonts to combo box
		List<String> fontFamilies = Font.getFamilies();
		ObservableList<String> fonts = FXCollections.observableArrayList(fontFamilies);
		fontNameCombo.getItems().addAll(fonts);

		//add font sizes to combo box
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i<=100; i++){
			list.add(String.valueOf(i));
		}
		ObservableList<String> sizes = FXCollections.observableArrayList(list);
		fontSizeCombo.getItems().addAll(sizes);

		HBox comboBoxPane = new HBox(5);
		comboBoxPane.setAlignment(Pos.CENTER);
		comboBoxPane.getChildren().addAll(new Label("Font Name"), fontNameCombo, new Label("Font Size"), fontSizeCombo);

		text.setFont(Font.font(50));
		StackPane textPane = new StackPane(text);
		textPane.setPadding(new Insets(20, 5, 20, 5));

		HBox checkBoxPane = new HBox(5);
		checkBoxPane.setAlignment(Pos.CENTER);
		checkBoxPane.getChildren().addAll(boldCheckBox, italicCheckBox);

		fontNameCombo.setValue("Arial");
		fontSizeCombo.setValue("30");
		text.setFont(Font.font(getName(), getWeight(), getPosture(), getSize()));

		boldCheckBox.setOnAction(e -> setDisplay());
		italicCheckBox.setOnAction(e -> setDisplay());
		fontNameCombo.setOnAction(e -> setDisplay());
		fontSizeCombo.setOnAction(e -> setDisplay());

		BorderPane pane = new BorderPane();
		pane.setTop(comboBoxPane);
		pane.setCenter(textPane);
		pane.setBottom(checkBoxPane);

		Scene scene = new Scene(pane, 1000, 400);
		primaryStage.setTitle("Exercise16_14");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void setDisplay() {
		text.setFont(Font.font(getName(), getWeight(), getPosture(), getSize()));
	}
	private String getName() {
		return fontNameCombo.getValue();
	}
	private FontWeight getWeight() {
		return boldCheckBox.isSelected() ? FontWeight.BOLD : FontWeight.NORMAL;
	}
	private FontPosture getPosture() {
		return italicCheckBox.isSelected()? FontPosture.ITALIC : FontPosture.REGULAR;
	}
	private int getSize() {
		return Integer.parseInt(fontSizeCombo.getValue());
	}
	public static void main(String[] args) {
		  launch(args);
		}
}

