package tw.org.iii.mytest;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test01 {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
					   "databaseName=LabDB;user=sa;password=sa"; 
			Connection conn = DriverManager.getConnection(connectionUrl);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
