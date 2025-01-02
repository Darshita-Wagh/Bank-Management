package bank_management;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bank_Deo {

	public static boolean insertRecord(Customer c) {
		boolean f = false;
		try {
			Connection con = Bank_Conn.createC();
			
			String q = "insert into bank_app(cname,phoneno,account_type,balance) values(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, c.getCname());
			pstmt.setString(2, c.getPhoneno());
			pstmt.setString(3, c.getAcc_type());
			pstmt.setLong(4, c.getBal());
			
			pstmt.executeUpdate();
			
			f=true;
			
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return(f);	
	}

	public static boolean deleteRecord(int id) {
		boolean f = false;
		try {
			
			Connection con = Bank_Conn.createC();
			
			String q = "delete from bank_app where cid=?";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			f=true;
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean updateRecord(Customer c) {
		boolean f= false;
		try {
			Connection con = Bank_Conn.createC();
			
			String q3 = "update bank_app set cname=?, phone=?, where cid=?";
			
			PreparedStatement pstmt = con.prepareStatement(q3);
			
			pstmt.setString(1, c.getCname());
			pstmt.setString(2, c.getPhoneno());
			pstmt.setString(3, c.getAcc_type());
			pstmt.setInt(4, c.getCid());
			
			pstmt.executeUpdate();
			
			f=true;
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static void displayRecord() {
		boolean f = false;
		try {
			
			Connection con = Bank_Conn.createC();
			String q = "select * from bank_app";			
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phoneno = set.getString(3);
				String acc_type = set.getString(4);
				long bal = set.getLong(5);
				
				System.out.println("\nId:" + id + " Name:" + name + " Phone:" + phoneno
				+ " Account type:" + acc_type+" Balance:"+bal);
			}
			
			f=true;
			set.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doTransaction() {
		try {
			Connection con = Bank_Conn.createC();
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("*****Operations*****");
			
			while(true) {
				
				System.out.println("1.Deposit");
				System.out.println("2.Withdraw");
				System.out.println("3.Check Balance");
				System.out.println("4.Exit");
				
				System.out.println("Select operation : ");
				int op = Integer.parseInt(bf.readLine());
				
				if(op==1) {
					System.out.println("Enter customer id :");
					int cid = Integer.parseInt(bf.readLine());
					System.out.println("Enter money to deposit : ");
					long bal = Long.parseLong(bf.readLine());
					
					boolean ans = Transaction.deposit(cid,bal);
					
					if(ans) {
						System.out.println("Money deposited");
					}else {
						System.out.println("Something went wrong");
					}
				}
				else if (op==2) {
					System.out.println("Enter customer id :");
					int cid = Integer.parseInt(bf.readLine());
					System.out.println("Enter money to withdraw : ");
					long bal = Long.parseLong(bf.readLine());
					
					boolean ans = Transaction.withdrawl(cid,bal);
					if(ans) {
						System.out.println("Money withdraw...");
					}else {
						System.out.println("Something went wrong");
					}
				}
				else if (op==3) {
					System.out.println("Enter customer id :");
					int id = Integer.parseInt(bf.readLine());
					long bal = Transaction.checkBalance(id);
					System.out.println("Balance fetch : "+bal);
				}
				else if (op==4) {
					System.out.println("Exit From Application");
					System.exit(0);
				}
				else {
					System.out.println("Select only above operation");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
