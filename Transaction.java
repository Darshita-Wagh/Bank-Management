package bank_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {

	public static boolean deposit(int cid, long bal) {
		boolean f=false;
		try {
			Connection connection = Bank_Conn.createC();
			
			String qString = "update bank_app set balance = balance + ? where cid = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(qString);
			pstmt.setLong(1, bal);
			pstmt.setInt(2, cid);
						
			pstmt.executeUpdate();
			f=true;
			connection.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static boolean withdrawl(int cid, long amt) {
		boolean f = false;
		try {
			Connection con = Bank_Conn.createC();
			
			long bal = checkBalance(cid);
		
			if((bal-amt)<2000) {
				throw new Exception("Insufficient balance : need to maintain 2000");
			}
			else {
				String q = "update bank_app set balance = balance - ? where cid = ?";
				PreparedStatement pstmts = con.prepareStatement(q);
				pstmts.setLong(1, amt);
				pstmts.setInt(2, cid);
				pstmts.executeUpdate();
			}
			f=true;
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
//			e.printStackTrace();
		}
		
		return f;		
	}
	
	public static long checkBalance(int cid) {
		long bal=0;
		try {
			Connection con = Bank_Conn.createC();
			
			String query = "SELECT balance FROM bank_app WHERE cid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cid); 
			ResultSet set = pstmt.executeQuery();

			if (set.next()) {
			    bal = set.getLong("balance");
			}			
			con.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return bal;
	}
}
