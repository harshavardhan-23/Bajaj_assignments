import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCOperations {

	static public void display()  throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new 	Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");  
		  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
		
		PreparedStatement ps=con.prepareStatement("select * from books");
		ResultSet rs =ps.executeQuery();
		System.out.println("fetching available books.please wait");
		Thread.sleep(1200);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	}
	
	static public void delete() throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new 	Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");  
		  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
		
		PreparedStatement ps=con.prepareStatement("delete from books where bookid=?");
		System.out.println("enter book id:");
		int id=sc.nextInt();
		ps.setInt(1, id);
		int rows=ps.executeUpdate();
		System.out.println("deleting record.please wait");
		Thread.sleep(1200);
		System.out.println("successfully deleted the record");
	}
	static public void insert() throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new 	Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");  
		  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
		
		PreparedStatement ps=con.prepareStatement("insert into books values(?,?,?,?,?)");
		System.out.println("enter book id: ");
		int id=Integer.valueOf(sc.nextLine());
		System.out.println("enter book name: ");
		String bookname=sc.nextLine();
		System.out.println("enter book Author: ");
		String author=sc.nextLine();
		System.out.println("enter book cost: ");
		int cost=Integer.valueOf(sc.nextLine());
		System.out.println("enter book Publisher: ");
		String publisher=sc.nextLine();
		ps.setInt(1,id);
		ps.setString(2,bookname);
		ps.setString(3,author);
		ps.setInt(4,cost);
		ps.setString(5,publisher);
		int rows=ps.executeUpdate();
		System.out.println("PLEASE WAIT");
   		Thread.sleep(1200);
		System.out.println("Successfully inserted ");
	}
	
	 static public void search() throws Exception{
			// TODO Auto-generated method stub
	    	   Scanner sc=new 	Scanner(System.in);
	   		Class.forName("oracle.jdbc.OracleDriver");  
	   		  
	   		  
	   		Connection con=DriverManager.getConnection(  
	   		"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
	   		
	   		PreparedStatement ps=con.prepareStatement("select * from books where bookid=?");
	   		System.out.println("enter book id:");
	   		int id=sc.nextInt();
	   		ps.setInt(1, id);
	   		int rows=ps.executeUpdate();
	   		System.out.println("PLEASE WAIT.Fetching results.");
	   		Thread.sleep(1200);
	   		if(rows==0) 
	   			System.out.println("no book found with id :"+id);
	   		else {
	   		ResultSet rs=ps.executeQuery();
	   		System.out.println("Bookid		Bookname	Author		Cost		publisher");
	   		while(rs.next()) {
	   			System.out.println(rs.getInt(1)+"		"+rs.getString(2)+"		"+rs.getString(3)+"		"+rs.getInt(4)+"		"+rs.getString(5));
	   		}
	   		}
		}

	 static public void update() throws Exception {
			// TODO Auto-generated method stub
			Scanner sc=new 	Scanner(System.in);
			Class.forName("oracle.jdbc.OracleDriver");  
			  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:1/123@localhost:1521:xe","hr","hr");
			PreparedStatement ps=null;
			System.out.println("enter book id:");
			int id=sc.nextInt();
			System.out.println("enter the attribute you want to update:(bookname,author,cost,publisher)");
			sc.nextLine();
			String attr=sc.nextLine();
			
			if(attr.toLowerCase().equals("bookname")) {
			 ps=con.prepareStatement("update books set bookname=? where bookid=?");
			 System.out.println("enter new bookname:");
			 String bookname=sc.nextLine();
			 ps.setString(1, bookname);
			 ps.setInt(2, id);
			}
			else if(attr.toLowerCase().equals("author")) {
				 ps=con.prepareStatement("update books set author=? where bookid=?");
				 System.out.println("enter new author name:");
				 String authorname=sc.nextLine();
				 ps.setString(1, authorname);
				 ps.setInt(2, id);
			}
			else if(attr.toLowerCase().equals("cost")) {
				 ps=con.prepareStatement("update books set cost=? where bookid=?");
				 System.out.println("enter new cost:");
				int cost=sc.nextInt();
				 ps.setInt(1, cost);
				 ps.setInt(2, id);
			}
			else if(attr.toLowerCase().equals("publisher")) {
				 ps=con.prepareStatement("update books set publisher=? where bookid=?");
				 System.out.println("enter new publisher :");
				 String publisher=sc.nextLine();
				 ps.setString(1, publisher);
				 ps.setInt(2, id);
			}
			System.out.println("updating record.please wait");
			Thread.sleep(1200);
			int rows=ps.executeUpdate();
			
			if(rows>0)
				System.out.println("successfully updated the record");
			else
				System.out.println("updation of record failed.please try again");
		}


}
