
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise34_1 extends Application{
	private Statement stmt;
	private TextField tfId = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfFirstName = new TextField();
	private TextField tfMi = new TextField();
	private TextField tfAddress = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfState = new TextField();
	private TextField tfTelephone = new TextField();
	private Label lblStatus = new Label("pending query . . . ");
	private Button btView = new Button("View");
	private Button btInsert = new Button("Insert");
	private Button btUpdate = new Button("Update");
	private Button btClear = new Button("Clear");

	@Override
	public void start(Stage primaryStage){
		VBox vBox = new VBox(5);
		HBox hBox1 = new HBox(5);
		hBox1.getChildren().addAll(new Label("ID"), tfId);
		HBox hBox2 = new HBox(5);
		hBox2.getChildren().addAll(new Label("Last Name"), tfLastName, new Label("First Name"), tfFirstName, new Label("MI"), tfMi);
		HBox hBox3 = new HBox(5);
		hBox3.getChildren().addAll(new Label("Address"), tfAddress);
		HBox hBox4 = new HBox(5);
		hBox4.getChildren().addAll(new Label("City"), tfCity, new Label("State"), tfState);
		HBox hBox5 = new HBox(5);
		hBox5.getChildren().addAll(new Label("Telephone"), tfTelephone);

		vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5);

		HBox buttonBox = new HBox(5);
		buttonBox.getChildren().addAll(btView, btInsert, btUpdate, btClear);
		buttonBox.setAlignment(Pos.CENTER);

		BorderPane pane = new BorderPane();
		Insets insets = new Insets(10);
		pane.setTop(lblStatus);
		BorderPane.setMargin(lblStatus, insets);
		pane.setCenter(vBox);
		BorderPane.setMargin(vBox, insets);
		pane.setBottom(buttonBox);
		BorderPane.setMargin(buttonBox,  insets);
		Scene scene = new Scene(pane, 800, 300);
		primaryStage.setTitle("Exercise 34_1");
		primaryStage.setScene(scene);
		primaryStage.show();

		initializeDB();

		btView.setOnAction(e -> view());
		btInsert.setOnAction(e -> insert());
		btUpdate.setOnAction(e -> update());
		btClear.setOnAction(e -> clear());
	}

	public void initializeDB() {
		try {
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://apollo.gtc.edu/brothenm2_javabook", "brothenm2", "password");
			System.out.println("Database connected\n");

			lblStatus.setText("Database connected");

			stmt = conn.createStatement();
		}
		catch (Exception ex) {
			lblStatus.setText("Connection failed: " + ex);
		}
	}
	private void view() {
		String query = "SELECT * FROM Staff WHERE ID = " + "'" + tfId.getText().trim() + "'";
		try{
			ResultSet rs = stmt.executeQuery(query);
			loadToTextField(rs);
		}
		catch(SQLException ex) {
			lblStatus.setText("Select failed: " + ex);
		}
	}
	private void insert() {
		String insertStmt = "INSERT INTO Staff( ID, LastName, FirstName, mi, Address, " + " City, State, Telephone) VALUES('" +
				tfId.getText().trim() + "','" +
				tfLastName.getText().trim() + "','" +
				tfFirstName.getText().trim() + "','" +
				tfMi.getText().trim() + "','" +
				tfAddress.getText().trim() + "','"+
				tfCity.getText().trim() + "','" +
				tfState.getText().trim() + "','" +
				tfTelephone.getText().trim() + "');";

		try {
			stmt.executeUpdate(insertStmt);
		}
		catch (SQLException ex) {
			lblStatus.setText("Insertion failed: " + ex);
		}

		lblStatus.setText("record inserted");
	}
	private void update() {
		String updateStmt = "UPDATE Staff " +

				"SET LastName = '" + tfLastName.getText().trim() + "','" +
				"FirstName = '" + tfFirstName.getText().trim() + "','" +
				"mi = '" + tfMi.getText().trim() + "','" +
				"Address = '" + tfAddress.getText().trim() + "','"+
				"City = '" + tfCity.getText().trim() + "','" +
				"State = '" + tfState.getText().trim() + "','" +
				"Telephon = '" + tfTelephone.getText().trim() + "' " +
				"WHERE ID = '" + tfId.getText().trim() + "';";

		try {
			stmt.executeUpdate(updateStmt);
		}
		catch (SQLException ex) {
			lblStatus.setText("update failed: " + ex);
		}

		lblStatus.setText("record updated");
	}
	private void clear() {
		tfId.setText(null);
		tfLastName.setText(null);
		tfFirstName.setText(null);
		tfLastName.setText(null);
		tfMi.setText(null);
		tfAddress.setText(null);
		tfCity.setText(null);
		tfState.setText(null);
		tfTelephone.setText(null);
	}
	private void loadToTextField(ResultSet rs) throws SQLException{
		if (rs.next()){
			tfLastName.setText(rs.getString(2));
			tfFirstName.setText(rs.getString(3));
			tfMi.setText(rs.getString(4));
			tfAddress.setText(rs.getString(5));
			tfCity.setText(rs.getString(6));
			tfState.setText(rs.getString(7));
			tfTelephone.setText(rs.getString(8));
			lblStatus.setText("Record found");
		}
		else
			lblStatus.setText("Record not found");
	}
	public static void main(String[] args) {
		  launch(args);
		}
}
