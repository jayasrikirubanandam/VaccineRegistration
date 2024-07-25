package JDBCUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtility {
	
	
	static Connection connect = null;
	
	
	
	//load and register the drivers
	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			System.out.println("class path is not found");
		}
	}

	//establish the connection to DB
	public static Connection getDBConnection() {

		String url= "jdbc:mysql://localhost:3306/mySql_Learning" ;
		String userName= "root";
		String password= "BeStrong23!";

		try {
			connect = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection success");
		} 
		catch (SQLException e) {

			System.out.println("Connection failed");
		}

		return connect;
	}

	public static void close(Connection connect, Statement stmnt, ResultSet rs) throws SQLException {

		if(connect != null)	
			connect.close();
		if(stmnt != null)
			stmnt.close();
		if(rs!= null)
			rs.close();
	}
}
