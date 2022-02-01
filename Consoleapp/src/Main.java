import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
		System.out.println("********* WELCOME TO LIBRARY MANAGEMENT SYSTEM **********");
		System.out.println();
		while(true) {
		System.out.println("Sign in to the application");
		System.out.println("Please enter your option");
		System.out.println("1.Admin");
		System.out.println("2.New User");
		System.out.println("3.Existing User");
		Scanner sc=new Scanner(System.in);
		int userchoice=sc.nextInt();
		switch(userchoice) {
		case 1:AdminOperations.adminLogin();
		break;
		case 2:UserRegistration.newuser();
		break;
		case 3:UserLogin.login();
		break;
		default: System.out.println("wrong choice");
		}
		
		
	}

}
}