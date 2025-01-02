package bank_management;

import java.sql.Connection;
import java.sql.DriverManager;

public class Bank_Conn {
	
	static Connection con;
	
	public static Connection createC(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bank";
			String user = "root";
			String pass = "";
			con = DriverManager.getConnection(url,user,pass);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
