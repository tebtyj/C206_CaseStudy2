
import java.util.ArrayList;
import java.util.Scanner;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//initialise User array with user objects 
		ArrayList<User> userList = new ArrayList<User>();
		
		User u1 =  new User("admin","admin@gmail.com","admin1","admin");
		User u2 = new User ("john","john@gmail.com","john123","teacher");
		userList.add(u1);
		userList.add(u2);
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 4) {
			System.out.println("School Co-Curriculum Activities (CCA) Registration");
			System.out.println("1. Login as administrator");
			System.out.println("2. Login as Teacher");
			System.out.println("3. Login as Student");
			System.out.println("4. Exit");

			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				LoginAdmin(userList);
				break;
			case 2:
				LoginTeacher(userList);
				break;
			case 3:
				LoginStudent(userList);
				break;
			case 4:
				System.out.println("Exiting the system..");
				break;
			default:
				System.out.println("Invalid Choice, Please try again");
			}
		}
	}
	//================================= Option 1 Login Admin =================================
	private static void LoginAdmin(ArrayList<User> userList) {
		Scanner scanner = new Scanner(System.in);

		String username, password;

		System.out.println("Enter your username: ");
		username = scanner.nextLine();
		System.out.println("Enter your password: ");
		password = scanner.nextLine();

		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)
					&& user.getRole().equalsIgnoreCase("admin")) {
				System.out.println("\nWelcome, Admin\n");
				adminMenu();
				break;
			}
		}
	}
	//================================= Option 2 Login Teacher =================================
	private static void LoginTeacher(ArrayList<User> userList) {
		// enter code here //kokzhen
				Scanner scanner = new Scanner(System.in);
				
				String username, password;
				
				System.out.println("Enter your username: ");
				username = scanner.nextLine();
				System.out.println("Enter your password: ");
				password = scanner.nextLine();
				
				for (User user : userList) {
					if (user.getUsername().equals(username) && user.getPassword().equals(password)
							&& user.getRole().equalsIgnoreCase("teacher")) {
						System.out.println("\nWelcome," + username +"\n");
						teacherMenu();
						
					}
				}
	}
	private static void teacherMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     TEACHER MENU     *****");
		Helper.line(45, "*");
		
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("1.Manage Activities");
			System.out.println("2.Manage Registration");
			System.out.println("3.Logout");
			
			System.out.println("Enter your choice: ");
			
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				manageActivities(); //xinying
				break;
			case 2:
				manageRegistration(); //rach
				break;
			case 3:
				System.out.println("Logging out the system");
				break;
			}
		}
	}
	//================================= Option 3 Login Student =================================
	private static void LoginStudent(ArrayList<User> userList) {
		//enter code here
	}

	private static void adminMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     ADMIN  MENU     *****");
		Helper.line(45, "*");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 5) {
			System.out.println("1.Manage User Accounts");
			System.out.println("2.Manage User Roles");
			System.out.println("3.Manage Activities");
			System.out.println("4.Manage Registration");
			System.out.println("5.Logout");

			System.out.println("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				manageUserAcc(); // tebbie
				break;
			case 2:
				manageUserRoles();
				break;
			case 3:
				manageActivities(); // xinying
				break;
			case 4:
				manageRegistration(); // rach
				break;
			default:
				System.out.println("Logging out the system..");
				break;
			}
		}
	}
	//================================= Option 1 Manage User (Admin) =================================
	public static void manageUserAcc() { // tebbie
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     MANAGE USER ACCOUNT     *****");
		Helper.line(45, "*");
		ArrayList<User> userList = new ArrayList<User>();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 5) {
			System.out.println("1.Add a new user");
			System.out.println("2.View All users");
			System.out.println("3.Delete an existing user");
			System.out.println("4.Exit");

			System.out.println("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addUser(userList); 
				break;
			case 2:
				viewAllUser(userList);
				break;
			case 3:
				deleteUser(userList); 
				break;
			default:
				System.out.println("Logging out the system..");
				break;
			}
		}
	}
	public static void addUser(ArrayList<User> userList) {
		System.out.println("==== Add User ====");
		String entUsername = Helper.readString("Enter username > ");
		String entPass = Helper.readString("Enter password > ");
		String entEmail = Helper.readString("Enter Email > ");
		String entRole = Helper.readString("Enter user role > ");
		
		for (int i = 0;i<userList.size();i++) {
			if(userList.get(i).getRole().equalsIgnoreCase(entRole)) {
//				if(userList.get(i).getUsername(entUsername)) {
//					
//				}
			}
		}
	}
	public static void viewAllUser(ArrayList<User> userList) {
		//ent code
	}
	public static void deleteUser(ArrayList<User> userList) {
		//enter code
	}
	//================================= Option 2 Manage UserRoles (Admin) =================================
	public static void manageUserRoles() { // any1
		//enter code here
	}
	//================================= Option 3 Manage Activites (Admin) =================================
	public static void manageActivities() { // xinying
		//enter code here
	}
	//================================= Option 4 Manage Registration (Admin) =================================
	public static void manageRegistration() { // Rach
			  //enter code here
			   System.out.println();
			   Helper.line(45, "*");
			   System.out.println("***     MANAGE REGISTRATION     ***");
			   Helper.line(45, "*");
			   ArrayList<registration> registrationList = new ArrayList<registration>();
			   Scanner scanner = new Scanner(System.in);
			   int choice = 0;
			   while (choice != 5) {
			    System.out.println("1.Add a registration");
			    System.out.println("2.View All registrations");
			    System.out.println("3.Delete an existing registration");
			    System.out.println("4.Exit");

			    System.out.println("Enter your choice: ");

			    choice = scanner.nextInt();

			    switch (choice) {
			    case 1:
			     addRegistration(registrationList);
			     break;
			    case 2:
			     viewAllRegistration(registrationList);
			     break;
			    case 3:
			     deleteRegistration(registrationList);
			     break;
			    default:
			     System.out.println("Logging out the system..");
			     ;
			    }
			   }
			  }
			 //a
			     //add registration
			  public static void addRegistration(ArrayList<registration> registrationList) {
			   Helper.line(35, "=");
			   System.out.println("==== Add Registration ====");
			   Helper.line(35, "=");
			   String entName = Helper.readString("Enter Name > ");
			   String entClass = Helper.readString("Enter Class > ");
			   String entEmail = Helper.readString("Enter Email > ");
			   
			   //insert into registrations
			   
			   //exit
			   System.out.println("==== Registration Successful ====");
			   Helper.line(10, " ");
			   
			  }
			  
			  //view all registrations
			  public static void viewAllRegistration(ArrayList<registration> registrationList) {
			   Helper.line(35, "=");
			   System.out.println("==== VIew All Registration ====");
			   Helper.line(35, "=");
			  
			   for (int i=0;i<registrationList.size();i++) {
			    String name=registrationList.get(i).getName();
			    String classroom=registrationList.get(i).getClassroom();
			    String email=registrationList.get(i).getEmail();
			    //title+=String.format("%-10s %-15s %-10s\n",name,classroom,email);
			    }
			   
			  }
			  
			  //delete registration
			  public static void deleteRegistration(ArrayList<registration> registrationList) {
			   Helper.line(35, "=");
			   System.out.println("==== Delete Registration ====");
			   Helper.line(35, "=");
			   String entName = Helper.readString("Enter Name > ");
			   
			   //delete entered name from registrations
			   
			   
			   //exit
			   System.out.println("==== Registration Deleted ====");
			   
			}
	}
} // end line (admin)