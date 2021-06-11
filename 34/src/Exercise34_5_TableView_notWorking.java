import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.beans.property.SimpleStringProperty;

public class Exercise34_5_TableView_notWorking extends Application{
    private ObservableList<ObservableList> data;
	private Statement stmt;
	private TextField tfTableName = new TextField();
	private Label lblStatus = new Label("pending query . . . ");
	private Button btShowContents = new Button("Show Contents");
	private TableView<ObservableList<ObservableList>> tvTableData = new TableView();

	@Override
	public void start(Stage primaryStage){
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("Table Name"), tfTableName, btShowContents);

		BorderPane pane = new BorderPane();
		Insets insets = new Insets(10);
		pane.setTop(hBox);
		BorderPane.setMargin(hBox, insets);
		pane.setCenter(tvTableData);
		BorderPane.setMargin(tvTableData, insets);
		pane.setBottom(lblStatus);
		BorderPane.setMargin(lblStatus,  insets);
		Scene scene = new Scene(pane, 800, 600);
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
        data = FXCollections.observableArrayList();
        //Make sure everything is empty for new data to be added
		tvTableData.getColumns().clear();
		System.out.println(rs);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		TableColumn[] columnNames = new TableColumn[columnsNumber];

		//Name the column headers
		for(int i=0; i<columnsNumber; i++){
			TableColumn currentColumnName = new TableColumn(rsmd.getColumnName(i+1));
			tvTableData.getColumns().addAll(currentColumnName);
//	        columnNames[i] = currentColumnName;  //store column names
		}
		while (rs.next()){
			//get each line from table, tab between column
			ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= columnsNumber; i++) {
					String current = rs.getString(i);
					row.add(rs.getString(i));
					System.out.println(current);
            }
			data.add(row);

		}
		tvTableData.getItems().addAll(data);
		rs.close();
        System.out.println("Entire list: " + data);
        System.out.println(tvTableData.getItems().size());
		data = null;
	}
	public static void main(String[] args) {
		  launch(args);
		}
}
