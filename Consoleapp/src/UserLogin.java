import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserLogin {
 static public void login() throws Exception {
	// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter your email");
	String email=sc.nextLine();
	System.out.println("Enter your password");
	String password=sc.nextLine();
	Class.forName("oracle.jdbc.OracleDriver");  
	  
	  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
	
	PreparedStatement ps=con.prepareStatement("select password from login where email=?");
	ps.setString(1, email);
	ResultSet rs=ps.executeQuery();
	rs.next();
	String pass=rs.getString(1);
	if(password.equals(pass)) {
		System.out.println("login is successful");
		System.out.println("Redirecting you to home page ");
		Thread.sleep(1000);
		userMenu();
	}
	else {
		System.out.println("wrong username or password");
		System.out.println("please try again");
	}
}
 
 static public void userMenu() throws Exception{
	// TODO Auto-generated method stub
	 Scanner sc=new Scanner(System.in);
	 System.out.println("****Customer Menu****");
		while(true) {
			
			System.out.println("select one of the options");
			System.out.println("1.search book");
			System.out.println("2.DisplayAvailableBook");
			System.out.println("3.Exit");
			
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:JDBCOperations.search();
			break;
			case 2:JDBCOperations.display();
			break;
			case 3:System.out.println("****** THANK YOU  *******");
					System.exit(0);
			default:System.out.println("wrong choice");
				
			}
}
 }
}

