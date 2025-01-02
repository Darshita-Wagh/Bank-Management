package bank_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import student_management.Student_deo;

public class Bank_App {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("\n******Welcome to Bank Application******");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			System.out.println("1. Add Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Update Customer Info");
			System.out.println("4. Display Customers Data");
			System.out.println("5. Customer Transaction");
			System.out.println("6. Exit");
			
			System.out.print("\n\nSelect Operation : ");
			int ch = Integer.parseInt(bf.readLine());
			
			if(ch==1) {
				System.out.println("Enter name : ");
				String name = bf.readLine();
				System.out.println("Enter account type : ");
				String atype = bf.readLine();
				System.out.println("Enter amount as initial balance : ");
				long bal = Long.parseLong(bf.readLine());
				System.out.println("Enter mobile no : ");
				String mobno = bf.readLine();
				
				Customer cust = new Customer(name, atype, bal,mobno);
				boolean ans = Bank_Deo.insertRecord(cust);
				
				if(ans) {
					System.out.println("Custmer added successfully");
				}
				else {
					System.out.println("Something went wrong");
				}
				
//				System.out.println(cust);
			}
			else if(ch==2) {
				System.out.println("Enter id to be deleted:");
				int id = Integer.parseInt(bf.readLine());
				boolean ans = Bank_Deo.deleteRecord(id);
				
				if(ans) {
					System.out.println("Custmer deleted successfully");
				}
				else {
					System.out.println("Something went wrong");
				}
			}
			else if(ch==3) {
				
				System.out.println("Enter id to be update : ");
				int uid = Integer.parseInt(bf.readLine());
				System.out.println("Enter name to  update : ");
				String name = bf.readLine();
				System.out.println("Enter mobile number to  update : ");
				String mobno = bf.readLine();
				System.out.println("Enter account type:");
				String atype = bf.readLine();
				
				Customer cust = new Customer(name, atype,mobno);
				boolean ans = Bank_Deo.updateRecord(cust);
				if(ans) {
					System.out.println("Record updated successfully");
				}
				else {
					System.out.println("Something went wrong...");
				}
			}
			else if(ch==4) {
				Bank_Deo.displayRecord();
			}
			else if(ch==5) {
				Bank_Deo.doTransaction();
			}
			else {
				System.out.println("Exit from application");
				System.exit(0);
			}
		}
	}
}
