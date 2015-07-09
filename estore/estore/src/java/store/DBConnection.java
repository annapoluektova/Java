package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public ResultSet queryDBWith(String query) {
		ResultSet rs = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:file:/Users/nisaenko/db/estore","SA", "");
  
			Statement stmt = con.createStatement();
			if(query.equals("")) {
				rs = stmt.executeQuery("SELECT * FROM products");
			} else {
				rs = stmt.executeQuery("SELECT "+query+" FROM products");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rs;
	}	
}
