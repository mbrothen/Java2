import java.sql.*;
public class Listing_34_1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");

		//Connect to database
		Connection connection = DriverManager.getConnection("jdbc:mysql://apollo.gtc.edu/brothenm2_javabook", "brothenm2", "password");
		System.out.println("Database connected");

		//Create statement
		Statement statement = connection.createStatement();

		//Execute a statement
		ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName from Student where lastName " + "= 'Smith'");

		while (resultSet.next())
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));

		connection.close();
	}
}
