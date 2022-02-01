import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserRegistration {
	
	
	static public boolean isUserExists(String email) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");  
		  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
		PreparedStatement ps=con.prepareStatement("select * from login where email=?");
		ps.setString(1, email);
		int rows=ps.executeUpdate();
		if(rows>0)
			return true;
		return false;
	}
	
	static public boolean newuser() throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new 	Scanner(System.in);
		System.out.println("enter your full name:");
		String fullname=sc.nextLine();
		System.out.println("enter your email:");
		String email=sc.nextLine();
		System.out.println("enter your password:");
		String password=sc.nextLine();

		boolean userExist=isUserExists(email);
		if(userExist){
			System.out.println("THE USER IS ALREADY REGISTERED WITH THIS APPLICATION");
			System.out.println("LOGIN AS EXISTING USER");
			
		}
		else {
		Class.forName("oracle.jdbc.OracleDriver");  
		  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
		
		PreparedStatement ps=con.prepareStatement("insert into login values(?,?,?)");
		ps.setString(1,fullname);
		ps.setString(2,email);
		ps.setString(3,password);
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("user registration is successful");
			System.out.println("please log in to the application");
			return true;
		}
		else {
			System.out.println("user registration is failed");
			System.out.println("please try again.");
			return false;
		}
		}
		return false;
	}
}
