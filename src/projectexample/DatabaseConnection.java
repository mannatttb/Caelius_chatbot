package projectexample;

import java.sql.*;

public class DatabaseConnection {

	private static Connection connection;
	
	public static void initializeDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/chatbotstorage";
            String username = "root";
            String password = "mannat30#";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	 public static String queryDb(String user_input) {
	        try {
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT answers FROM chatbotdatabase WHERE questions=?");
	            preparedStatement.setString(1, user_input);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                return resultSet.getString("answers");
	            } else {
	                return "I'm sorry, I don't understand you.";
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "An error occurred while processing your request.";
	        }
	 }

}
