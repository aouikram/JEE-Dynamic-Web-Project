package database;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionManager  {
	
	 static Connection connection;
	
	public static Connection getConnection() {

		
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			}
			catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
				System.err.println("Unable to find and load driver");
				System.exit(1);
			}
		 
			
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/foodShop?user=root&verifyServerCertificate=true&useSSL=false&requireSSL=true&serverTimezone=UTC");				
			
			}catch(SQLException e) {
				e.printStackTrace();
				}
			
		return connection;        
	}

	
    }
