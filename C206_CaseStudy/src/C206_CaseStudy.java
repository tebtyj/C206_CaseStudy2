
import java.util.ArrayList;
import java.util.Scanner;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// initialise User array with user objects
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<registration> registrationList = new ArrayList<registration>();
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		// default user list
		User u1 = new User("A123", "admin", "admin@gmail.com", "admin1", "admin");
		User u2 = new User("T123", "john", "john@gmail.com", "john123", "teacher");
		User u3 = new User("S123", "William Lee", "WillL@gmail.com", "william", "student");
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		// default registration list
		registration r1 = new registration("William", "S123", "WillL@gmail.com", "Badminton");
		// default activity list
		Activity a1 = new Activity("Badminton", "Badminton is a racket sport that is played by two or four players.",
				"Maximum capacity: 40");
		Activity a2 = new Activity("Soccer",
				"Soccer is a team sport, involving 11 players on each side who use their legs, head and torso to pass a ball and score goals.",
				"Maximum capacity: 40");
		Activity a3 = new Activity("Basketball",
				"Basketball is a team sport that involves two teams of five active players each trying to score points against one another",
				"Maximum capacity: 40");
		Activity a4 = new Activity("Rugby",
				"Rugby is a football game played with an oval ball by two teams of 15 players (in rugby union play) or 13 players (in rugby league play).",
				"Maximum capacity: 40");
		activityList.add(a1);
		activityList.add(a2);
		activityList.add(a3);
		activityList.add(a4);
		registrationList.add(r1);
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
				LoginAdmin(userList, registrationList, activityList);
				break;
			case 2:
				LoginTeacher(userList, registrationList, activityList);
				break;
			case 3:
				LoginStudent(userList, registrationList, activityList);
				break;
			case 4:
				System.out.println("Exiting the system. Bye!");
				break;
			default:
				System.out.println("Invalid Choice, Please try again");
			}
		}
	}

	// ================================= Option 1 Login Admin
	// =================================
	private static void LoginAdmin(ArrayList<User> userList, ArrayList<registration> registrationList,
			ArrayList<Activity> activityList) {
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
				adminMenu(userList, registrationList, activityList);
				break;
			} else {
				System.out.println("Wrong Username/Password. Try Again.");
			}
		}
	}

	// ================================= Option 2 Login Teacher
	// =================================
	private static void LoginTeacher(ArrayList<User> userList, ArrayList<registration> registrationList,
			ArrayList<Activity> activityList) {
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
				System.out.println("\nWelcome," + username + "\n");
				teacherMenu(registrationList, activityList);
				break;
			} else {
				System.out.println("Wrong password/username. PLease try again. \n");
			}

		}
	}

	private static void teacherMenu(ArrayList<registration> registrationList, ArrayList<Activity> activityList) {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     TEACHER MENU     *****");
		Helper.line(45, "*");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 5) {
			System.out.println("1.Manage Activities");
			System.out.println("2.Manage Registration");
			System.out.println("3.Manage Attendance");
			System.out.println("4.View Applications"); // Option to view applications
			System.out.println("5.Logout");

			System.out.println("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				manageActivities(activityList); // xinying
				break;
			case 2:
				manageRegistration(registrationList); // rach
				break;
			case 3:
				manageAttendance(registrationList); // kokzhen
				break;
			case 4:
				viewApplicationsForActivity(registrationList, activityList); // View Applications
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}

	// ================================= Option 3 Login Student
	// =================================
	private static void LoginStudent(ArrayList<User> userList, ArrayList<registration> registrationList,
			ArrayList<Activity> activityList) { // tebbie
		Scanner scanner = new Scanner(System.in);

		String username, password;

		System.out.println("Enter your username: ");
		username = scanner.nextLine();
		System.out.println("Enter your password: ");
		password = scanner.nextLine();

		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)
					&& user.getRole().equalsIgnoreCase("student")) {
				System.out.println("\nWelcome, Student\n");
				studentMenu(registrationList, activityList);
				break;
			} else {
				System.out.println("Wrong Username/Password. Try Again.\n");
			}
		}
	}

	private static void adminMenu(ArrayList<User> userList, ArrayList<registration> registrationList,
			ArrayList<Activity> activityList) {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     ADMIN  MENU     *****");
		Helper.line(45, "*");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 4) {
			System.out.println("1.Manage User Accounts");
			System.out.println("2.Manage Activities");
			System.out.println("3.Manage Registration");
			System.out.println("4.Logout");

			System.out.println("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				manageUserAcc(userList); // tebbie
				break;
			case 2:
				manageActivities(activityList); // xinying
				break;
			case 3:
				manageRegistration(registrationList); // rach
				break;
			default:
				System.out.println("Logging out the system..");
				break;
			}
		}
	}

	// ================================= Option 1 Manage User (Admin)
	// =================================
	public static void manageUserAcc(ArrayList<User> userList) { // tebbie
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     MANAGE USER ACCOUNT     *****");
		Helper.line(45, "*");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 4) {
			System.out.println("1.Add a new user");
			System.out.println("2.View All users");
			System.out.println("3.Delete an existing user");
			System.out.println("4.Exit");

			System.out.println("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				User newUser = inputUser();
				addUser(userList, newUser);
				break;
			case 2:
				viewAllUser(userList);
				break;
			case 3:
				deleteUser(userList);
				break;
			case 4:
				System.out.println("Exiting the system..");
				break;
			default:
				System.out.println("Invalid choice, try again.");
				break;
			}
		}
	}

	public static User inputUser() {
		System.out.println("==== Add User ====");
		String entUsername = Helper.readString("Enter username > ");
		String entId = Helper.readString("Enter user Id > ");
		String entPass = Helper.readString("Enter password > ");
		String entEmail = Helper.readString("Enter Email > ");
		String entRole = Helper.readString("Enter user role > ");

		User newuser = new User(entId, entUsername, entEmail, entPass, entRole);
		return newuser;
	}

	public static void addUser(ArrayList<User> userList, User newuser) {
		User item;
		for (int i = 0; i < userList.size(); i++) {
			item = userList.get(i);
			if (item.getUsername().equals(newuser.getUsername()))
				return;
		}
		if ((newuser.getUsername().isEmpty()) || (newuser.getPassword().isEmpty())) {
			return;
		}
		userList.add(newuser);
		System.out.println("User added successfully!");

	}

	public static void viewAllUser(ArrayList<User> userList) {
		System.out.println("==== View Users ====");
		String output = String.format("%-15s %-15s %-20s %-30s \n", "USERNAME", "USER ID", "EMAIL", "ROLE");
		output += retrieveUser(userList);
		System.out.println(output);
	}

	public static String retrieveUser(ArrayList<User> userList) {
		String output = "";
		// write your code here
		for (int i = 0; i < userList.size(); i++) {
			output += String.format("%-15s %-15s %-20s %-30s \n", userList.get(i).getUsername(),
					userList.get(i).getUserId(), userList.get(i).getEmail(), userList.get(i).getRole());
		}
		return output;
	}

	public static void deleteUser(ArrayList<User> userList) {
		String removeUser = Helper.readString("Enter user Id to remove > ");
		// Find the user to be deleted.
		boolean userFound = false;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equalsIgnoreCase(removeUser)) {
				userList.remove(i);
				userFound = true;
				break;
			}
		}

		// If the user was found,display message
		if (userFound == true) {
			System.out.println("User has been removed successfully!");
		} else {
			System.out.println("There is no such user.");
		}
	}

	public static void dodeleteUser(ArrayList<User> userList, String userId) {
		// Find the user to be deleted
		int index = -1;
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(userId)) {
				index = i;
				break;
			}
		}

		// If the user was found, delete it
		if (index != -1) {
			userList.remove(index);
			System.out.println("User has been removed successfully!");
		} else {
			System.out.println("There is no such user.");
		}
	}

	// ================================= Option 2 Manage UserRoles (Admin)
	// =================================
	public static void manageUserRoles() { // tebbie
		// enter code here
	}

	// ================================= Option 3 Manage Activites (Admin)
	// =================================
	public static void manageActivities(ArrayList<Activity> activityList) { // xinying
		  // enter code here
		  System.out.println();
		  Helper.line(45, "*");
		  System.out.println("*     MANAGE ACTIVITIES     *");
		  Helper.line(45, "*");
		  int choice = 0;
		  while (choice != 4) {
		   System.out.println("1.Add an activity");
		   System.out.println("2.View All activities");
		   System.out.println("3.Delete an existing activity");
		   System.out.println("4.Exit");

		   choice = Helper.readInt("Enter your choice: ");

		   switch (choice) {
		   case 1:
		    Activity newActivity = inputActivity();
		    addActivity(activityList, newActivity);
		    break;
		   case 2:
		    viewAllActivities(activityList);
		    break;
		   case 3:
		    Helper.line(35, "=");
		    System.out.println("==== Delete Activity ====");
		    Helper.line(35, "=");
		    String removeCCA = Helper.readString("Enter Activity Name > ");
		    dodeleteActivity(activityList,removeCCA);
		    break;
		   default:
		    System.out.println("Logging out the system..");
		    ;
		   }
		  }
		 }

	public static Activity inputActivity() {
		  Helper.line(35, "=");
		  System.out.println("==== Add Activity ====");
		  Helper.line(35, "=");
		  String activityName = Helper.readString("Enter Activity Name > ");
		  String activityDescription = Helper.readString("Enter Activity Description > ");
		  String activityRequirement = Helper.readString("Enter Activity Requirement > ");

		  Activity newA = new Activity(activityName, activityDescription, activityRequirement);
		  return newA;
		 }

	// add activity
	 public static void addActivity(ArrayList<Activity> activityList, Activity newA) {
	  Activity activity;
	  for (int i = 0; i < activityList.size(); i++) {
	   activity = activityList.get(i);
	   if (activity.getActivityName().equalsIgnoreCase(newA.getActivityName())) {
	    return;
	   }
	   if ((newA.getActivityRequirement().isEmpty()) || (newA.getActivityName().isEmpty())) {
	    return;
	   }
	  }
	  activityList.add(newA);
	  System.out.println("Activity successfully created");
	 }

	 // view all activities
	 public static void viewAllActivities(ArrayList<Activity> activityList) {
	  System.out.println("==== View ALL ACTIVITIES ====");
	  String output = String.format("%-15s %-15s %-15s\n", "ACTIVITY", "DESCRIPTION", "REQUIREMENT");
	  output += retrieveActivity(activityList);
	  System.out.println(output);
	 }

	 public static String retrieveActivity(ArrayList<Activity> activityList) {
	  String output = "";
	  // write your code here
	  for (int i = 0; i < activityList.size(); i++) {
	   output += String.format("%-15s %-15s %-15s\n", activityList.get(i).getActivityName(),
	     activityList.get(i).getActivityDescription(), activityList.get(i).getActivityRequirement());
	  }
	  return output;
	 }

	 // delete activity
	 public static void dodeleteActivity(ArrayList<Activity> activityList, String removeCCA) {
	  boolean ccaFound = false;
	  for (int i = 0; i < activityList.size(); i++) {
	   if (activityList.get(i).getActivityName().equalsIgnoreCase(removeCCA)) {
	    activityList.remove(i);
	    ccaFound = true;
	    break;
	   }
	  }

	  // If the user was found,display message
	  if (ccaFound == true) {
	   System.out.println("Activity successfully deleted");
	  } else {
	   System.out.println("There is no such activity.");
	  }

	 }

	// ================================= Option 4 Manage Registration (Admin)
	// =================================
	public static void manageRegistration(ArrayList<registration> registrationList) { // Rach
		// enter code here
		System.out.println();
		Helper.line(45, "*");
		System.out.println("***     MANAGE REGISTRATION     ***");
		Helper.line(45, "*");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("1.View All registrations");
			System.out.println("2.Delete an existing registration");
			System.out.println("3.Exit");

			System.out.println("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				viewAllRegistration(registrationList);
				break;
			case 2:
				deleteRegistration(registrationList);
				break;
			default:
				System.out.println("Logging out the system..");
				;
			}
		}
	}

	// view all registrations
	public static void viewAllRegistration(ArrayList<registration> registrationList) {
		Helper.line(35, "=");
		System.out.println("==== View All Registration ====");
		Helper.line(35, "=");
		String output = String.format("%-15s %-15s %-20s \n", "NAME", "USER ID", "ACTIVITY CHOSEN");
		output += retrieveRegistration(registrationList);
		System.out.println(output);

	}

	public static String retrieveRegistration(ArrayList<registration> registrationList) {
		String output = "";
		// write your code here
		for (int i = 0; i < registrationList.size(); i++) {
			output += String.format("%-15s %-15s %-20s \n", registrationList.get(i).getName(),
					registrationList.get(i).getUserId(), registrationList.get(i).getCCAc());
		}
		return output;
	}

	// delete registration
	public static void deleteRegistration(ArrayList<registration> registrationList) {
		Helper.line(35, "=");
		System.out.println("==== Delete Registration ====");
		Helper.line(35, "=");
		String removeUser = Helper.readString("Enter user Id to remove > ");
		// Find the user to be deleted.
		boolean userFound = false;
		for (int i = 0; i < registrationList.size(); i++) {
			if (registrationList.get(i).getUserId().equalsIgnoreCase(removeUser)) {
				registrationList.remove(i);
				userFound = true;
				break;
			}
		}

		// If the user was found,display message
		if (userFound == true) {
			System.out.println("Resgistration has been removed successfully!");
		} else {
			System.out.println("There is no such user.");
		}

		// exit
		System.out.println("==== Registration Deleted ====");

	}

	public static void dodeleteRegistration(ArrayList<registration> registrationList, String userId) {
		Helper.line(35, "=");
		System.out.println("==== Delete Registration ====");
		Helper.line(35, "=");
		String removeUser = Helper.readString("Enter user Id to remove > ");
		// Find the user to be deleted.
		boolean userFound = false;
		for (int i = 0; i < registrationList.size(); i++) {
			if (registrationList.get(i).getUserId().equalsIgnoreCase(removeUser)) {
				registrationList.remove(i);
				userFound = true;
				break;
			}
		}

		// If the user was found,display message
		if (userFound == true) {
			System.out.println("Resgistration has been removed successfully!");
		} else {
			System.out.println("There is no such user.");
		}

		// exit
		System.out.println("==== Registration Deleted ====");

	}

// end line (admin)
//start line (teacher)
	public static void manageAttendance(ArrayList<registration> registrationList) {
		Scanner scanner = new Scanner(System.in);
		boolean exitManageAttendance = false;

		while (!exitManageAttendance) {
			System.out.println();
			Helper.line(45, "*");
			System.out.println("======= Manage Attendance =======");
			System.out.println();
			Helper.line(45, "*");

			System.out.println("1. Mark Attendance");
			System.out.println("2. Delete Attendance");
			System.out.println("3. View all Attendance");
			System.out.println("4. Back to Teacher Menu");

			int option = Helper.readInt("Enter your option: ");

			switch (option) {
			case 1:
				addAttendance(registrationList);
				break;
			case 2:
				deleteAttendance(registrationList, null);
				break;
			case 3:
				viewAllAttendance(registrationList);
				break;
			case 4:
				exitManageAttendance = true;
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		}
	}

	public static void addAttendance(ArrayList<registration> registrationList) {
		for (registration reg : registrationList) {
			System.out.println("Student: " + reg.getName() + "(UserID: " + reg.getUserId() + ")");
			System.out.println("Activity: " + reg.getCCAc());

			String attendance = Helper.readString("Present or absent (P/A): ");

			if (attendance.equalsIgnoreCase("P")) {
				reg.setAttendance(true);
				System.out.println("\n Attendance marked as Present (P) \n");
			} else if (attendance.equalsIgnoreCase("A")) {
				reg.setAttendance(false);
				System.out.println("\n Attendance marked as Absent (A) \n");
			} else {
				System.out.println("\n Invalid Input, Enter 'P' or 'A' to mark \n");
			}
		}
	}

	public static void deleteAttendance(ArrayList<registration> registrationList, String string) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter UserID you want to delete: ");
		String UID_delete = scanner.nextLine();

		boolean UID_found = false;
		for (registration reg : registrationList) {
			if (reg.getUserId().equalsIgnoreCase(UID_delete)) {
				reg.setAttendance(false);
				System.out.println("Attendance for " + reg.getName() + " has been deleted.");
				UID_found = true;
				break;
			}
		}

		if (!UID_found) {
			System.out.println("UserID " + UID_delete + "not found");
		}
	}

	public static void viewAllAttendance(ArrayList<registration> registrationList) {
		System.out.println("\n==== View All Attendance ====");
		String output = String.format("%-15s %-15s %-20s %-10s\n", "NAME", "USER ID", "ACTIVITY CHOSEN", "ATTENDANCE");
		output += retrieveAttendance(registrationList);
		System.out.println(output);
	}

	public static String retrieveAttendance(ArrayList<registration> registrationList) {
		String output = "";
		for (registration reg : registrationList) {
			String attendanceStatus;
			if (reg.isAttendance()) {
				attendanceStatus = "Present";
			} else {
				attendanceStatus = "Absent";
			}
			output += String.format("%-15s %-15s %-20s %-10s\n", reg.getName(), reg.getUserId(), reg.getCCAc(),
					attendanceStatus);
		}
		return output;
	}

	public static void viewApplicationsForActivity(ArrayList<registration> registrationList,
			ArrayList<Activity> activityList) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("==== View Applications for Activity ====");
		String activityName = Helper.readString("Enter the name of the activity: ");
		Activity selectedActivity = findActivityByName(activityList, activityName);

		if (selectedActivity != null) {
			// Display applications and update status
			displayApplicationsForActivity(registrationList, selectedActivity);
			updateApplicationStatus(registrationList, activityList);
		} else {
			System.out.println("Activity not found.");
		}
	}

	public static void displayApplicationsForActivity(ArrayList<registration> registrationList, Activity activity) {
		System.out.println("Applications for " + activity.getActivityName() + ":");
		for (registration reg : registrationList) {
			if (reg.getCCAc().equals(activity.getActivityName())) {
				System.out.println("Applicant: " + reg.getName());
				System.out.println("Status: " + reg.getStatus());
				System.out.println("-----------------------------");
			}
		}
	}
	public static void updateApplicationStatus(ArrayList<registration> registrationList, ArrayList<Activity> activityList) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter the applicant's name: ");
	    String applicantName = scanner.nextLine();
	    System.out.print("Enter the activity's name: ");
	    String activityName = scanner.nextLine();

	    // Find the registration based on the applicant's name and activity's name
	    registration selectedRegistration = findRegistrationByNameAndActivity(registrationList, applicantName, activityName);

	    if (selectedRegistration != null) {
	        // Prompt for new status (approve, reject, pending)
	        System.out.print("Enter the new status (approve/reject): ");
	        String newStatus = scanner.next();

	        // Update the status of the selected registration
	        if (newStatus.equalsIgnoreCase("approve") || newStatus.equalsIgnoreCase("reject")) {
	            selectedRegistration.setStatus(newStatus);
	            System.out.println("Application status updated.");
	        } else {
	            System.out.println("Invalid status input. Application status remains as 'pending'.");
	        }

	        // Display applications
	        displayApplicationsForActivity(registrationList, findActivityByName(activityList, activityName));
	    } else {
	        System.out.println("Application not found.");
	    }
	}
    public static registration findRegistrationByNameAndActivity(ArrayList<registration> registrationList,
            String applicantName, String activityName) {
        for (registration reg : registrationList) {
            if (reg.getName().equals(applicantName) && reg.getCCAc().equalsIgnoreCase(activityName)) {
                return reg;
            }
        }
        return null;
    }

    public static Activity findActivityByName(ArrayList<Activity> activityList, String name) {
        for (Activity activity : activityList) {
            if (activity.getActivityName().equals(name)) {
                return activity;
            }
        }
        return null;
    }
//end line (teacher)
//start line (student)
	private static void studentMenu(ArrayList<registration> registrationList, ArrayList<Activity> activityList) {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****    STUDENT  MENU   *****");
		Helper.line(45, "*");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("1.Apply for CCA");
			System.out.println("2.View CCAs");
			System.out.println("3.Logout");

			System.out.println("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				registration newRegister = inputRegistration();
				addRegistration(registrationList, newRegister);
				break;
			case 2:
				viewCCA(activityList); // tebbie
				break;
			default:
				System.out.println("Logging out...");
				break;
			}
		}
	}

//a
	// add registration
	public static registration inputRegistration() {
		String newStuName = Helper.readString("Enter your name > ");
		String newStuID = Helper.readString("Enter your student ID > ");
		String newEmail = Helper.readString("Enter Email > ");
		String newAct = Helper.readString("Enter your chosen activity > ");

		registration newR = new registration(newStuName, newStuID, newEmail, newAct);
		return newR;
	}

	public static void addRegistration(ArrayList<registration> registrationList, registration newR) {
		registration item;
		for (int i = 0; i < registrationList.size(); i++) {
			item = registrationList.get(i);
			if (item.getUserId().equals(newR.getUserId()))
				return;
		}
		if ((newR.getUserId().isEmpty()) || (newR.getName().isEmpty())) {
			return;
		}
		registrationList.add(newR);
		System.out.println("Registration added successfully!");
	}

	public static void viewCCA(ArrayList<Activity> activityList) {
		System.out.println("==== View ALL ACTIVITIES ====");
		String output = String.format("%-15s %-15s %-15s\n", "ACTIVITY", "DESCRIPTION", "REQUIREMENT");
		output += retrieveCCA(activityList);
		System.out.println(output);
	}

	public static String retrieveCCA(ArrayList<Activity> activityList) {
		String output = "";
		// write your code here
		for (int i = 0; i < activityList.size(); i++) {
			output += String.format("%-15s %-15s %-15s\n", activityList.get(i).getActivityName(),
					activityList.get(i).getActivityDescription(), activityList.get(i).getActivityRequirement());
		}
		return output;
	}
}
//endline (student)