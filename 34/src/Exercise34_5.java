import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise34_5 extends Application{
	private Statement stmt;
	private TextField tfTableName = new TextField();
	private Label lblStatus = new Label("pending query . . . ");
	private Button btShowContents = new Button("Show Contents");
	private TextArea taTableData = new TextArea();

	@Override
	public void start(Stage primaryStage){
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("Table Name"), tfTableName, btShowContents);
		taTableData.setStyle("-fx-font-family: monospace");  //It took me far too long to figure out why my columns weren't spaced properly.....
		BorderPane pane = new BorderPane();
		Insets insets = new Insets(10);
		pane.setTop(hBox);
		BorderPane.setMargin(hBox, insets);
		pane.setCenter(taTableData);
		BorderPane.setMargin(taTableData, insets);
		pane.setBottom(lblStatus);
		BorderPane.setMargin(lblStatus,  insets);
		Scene scene = new Scene(pane, 1200, 600);
		primaryStage.setTitle("Exercise 34_5");
		primaryStage.setScene(scene);
		primaryStage.show();

		initializeDB();

		btShowContents.setOnAction(e -> getTable());

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
	private void getTable() {
		String query = "SELECT * FROM "+ tfTableName.getText() + ";";
		try{
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Table Queried");
			loadToTextArea(rs);
		}
		catch(SQLException ex) {
			lblStatus.setText("Select failed: " + ex);
		}
	}

	private void loadToTextArea(ResultSet rs) throws SQLException{
		//clear table and placeholderstring
		taTableData.clear();
		String tempString = "";
		System.out.println(rs);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		//Name the column headers
		for(int i=1; i<columnsNumber; i++){
			tempString += resizeStringsToColumnSize(rsmd.getColumnName(i)) + "\t";
		}
		taTableData.appendText(tempString + "\n");
		tempString ="";
		while (rs.next()){
			for (int i=1; i<columnsNumber; i++){
				tempString += resizeStringsToColumnSize(rs.getString(i)) + "\t";
			}
			taTableData.appendText(tempString + "\n");
			tempString ="";

		}
		rs.close();
	}
		private String resizeStringsToColumnSize(String str) {
			//force strings to 15 character legnths, return to size
			final int columnLength = 10;
			str = str.trim();
			while (str.length() < columnLength){
				str = str+" ";
			}

			if (str.length() > columnLength){
			str = str.substring(0,columnLength);
			}
			System.out.println(str + " length = " + str.length());
			return str;
	}
	public static void main(String[] args) {
		  launch(args);
		}
}
