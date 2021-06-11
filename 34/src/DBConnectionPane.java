import java.sql.Connection;
import java.sql.DriverManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DBConnectionPane extends BorderPane{
	private Connection connection;

	// UI elements
	private Label lblStatus = new Label("no connection");
	private ComboBox<String> cboDriver = new ComboBox<>();
	private ComboBox<String> cboDatabase = new ComboBox<>();
	private TextField txtUsername = new TextField();
	private PasswordField pfPassword = new PasswordField();
	private Button btnConnect = new Button("Connect to DB");

	public DBConnectionPane() {
		cboDriver.getItems().add("com.mysql.jdbc.Driver");
		cboDriver.setEditable(true);
		cboDatabase.getItems().addAll("jdbc:mysql://apollo.gtc.edu/brothenm2_javabook", "jdbc:mysql://appolo.gtc.edu/rac300_javabook");
		cboDatabase.setEditable(true);


		GridPane inputs = new GridPane();
		inputs.setPadding(new Insets(0,10,0,10));
		inputs.setHgap(10);;
		inputs.setVgap(10);;
		inputs.add(new Label("JDBC Driver"), 0, 0);
		inputs.add(cboDriver,  1, 0);
		inputs.add(new Label("Database URL"),  0, 1);
		inputs.add(cboDatabase, 1, 1);
		inputs.add(new Label("Username"), 0, 2);
		inputs.add(txtUsername, 1, 2);
		inputs.add(new Label("Password"), 0, 3);
		inputs.add(pfPassword, 1, 3);

		HBox buttonPane = new HBox();
		buttonPane.setPadding(new Insets(0, 10, 10, 10));
		buttonPane.setAlignment(Pos.CENTER_RIGHT);
		buttonPane.getChildren().add(btnConnect);

		setTop(lblStatus);
		setCenter(inputs);
		setBottom(buttonPane);


		btnConnect.setOnAction(e -> getConnection());
	}
	private void getConnection(){
		try {
			Class.forName(cboDriver.getValue());
			connection = DriverManager.getConnection
			(cboDatabase.getValue(), txtUsername.getText(), pfPassword.getText());
			System.out.println("Database connected\n");

			lblStatus.setText("Database connected to " + cboDatabase.getValue());

		}
		catch (Exception ex) {
			lblStatus.setText("Connection failed: " + ex);
		}

	}
}
