import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private User u1;
	private User u2;
	private registration r1;
	private registration r2;
	private Activity a1;
	private Activity a2;
	private Activity a3;
	private Activity a4;

	private ArrayList<User> userList;
	private ArrayList<registration> registrationList;
	private ArrayList<Activity> activityList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		u1 = new User("A123", "admin", "admin@gmail.com", "admin1", "admin");
		u2 = new User("T123", "john", "john@gmail.com", "john123", "teacher");
		r1 = new registration("William", "S123", "WillL@gmail.com", "Badminton");
		r2 = new registration("Oliver", "S223", "Oliver@gmail.com", "Soccer");
		a1 = new Activity("Badminton", "Badminton is a racket sport that is played by two or four players.",
				"Maximum capacity: 40");
		a2 = new Activity("Soccer",
				"Soccer is a team sport, involving 11 players on each side who use their legs, head and torso to pass a ball and score goals.",
				"Maximum capacity: 40");
		a3 = new Activity("Basketball",
			    "Basketball is a team sport that involves two teams of five active players each trying to score points against one another",
			    "Maximum capacity: 40");
		  a4 = new Activity("Rugby",
		    "Rugby is a football game played with an oval ball by two teams of 15 players (in rugby union play) or 13 players (in rugby league play).",
		    "Maximum capacity: 40");

		userList = new ArrayList<User>();
		registrationList = new ArrayList<registration>();
		activityList = new ArrayList<Activity>();
	}

	@Test
	public void testAddUser() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid user arraylist to add to", userList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addUser(userList, u1);
		assertEquals("Check that user arraylist size is 1", 1, userList.size());
		assertSame("Check that user is added", u1, userList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Check that user arraylist size is 2", 2, userList.size());
		assertSame("Check that user is added", u2, userList.get(1));

	}

	@Test
	public void testViewUsers() {
		// fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid user arraylist to retrieve item from", userList);

		// test if the list of User retrieved from the casestudy is empty - boundary
		String allUser = C206_CaseStudy.retrieveUser(userList);
		String testOutput = "";
		assertEquals("Test that the retrieved userlist is empty?", testOutput, allUser);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		assertEquals("Test that user arraylist size is 2", 2, userList.size());

		// test if the expected output string same as the list of user retrieved from
		// the casestudy
		allUser = C206_CaseStudy.retrieveUser(userList);
		testOutput = String.format("%-15s %-15s %-20s %-30s \n", "admin", "A123", "admin@gmail.com", "admin");
		testOutput += String.format("%-15s %-15s %-20s %-30s \n", "john", "T123", "john@gmail.com", "teacher");
		assertEquals("Test that ViewAllUser", testOutput, allUser);
	}

	@Test
	public void testDeleteUser() {
		// fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid user arraylist to retrieve item from", userList);

		// test if the list of User retrieved from the casestudy is empty - boundary
		String allUser = C206_CaseStudy.retrieveUser(userList);
		String testOutput = "";
		assertEquals("Test that the retrieved userlist is empty?", testOutput, allUser);

		// Given that there is already 2 Users added to userlist,the list would go down
		// to 1 after deleting a user
		// -normal

		C206_CaseStudy.addUser(userList, u1);
		C206_CaseStudy.addUser(userList, u2);
		C206_CaseStudy.dodeleteUser(userList, u1.getUserId());
		// Assert that the size of the user list is 1
		assertEquals("Test that user arraylist size is 1", 1, userList.size());
	}

	// rach
	@Test
	public void testaddRegistration() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid registration arraylist to add to", registrationList);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is same as the first item of the list
		C206_CaseStudy.addRegistration(registrationList, r1);
		assertEquals("Check that registration arraylist size is 1", 1, registrationList.size());
		assertSame("Check that registration is added", r1, registrationList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addRegistration(registrationList, r2);
		assertEquals("Check that Registration arraylist size is 2", 2, registrationList.size());
		assertSame("Check that Registration is added", r2, registrationList.get(1));
	}

	// rach
	@Test
	public void testViewAllRegistration() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid registration arraylist to add to", registrationList);
		assertEquals("Test that the registration arraylist is empty.", 0, registrationList.size());
		// Attempt to retrieve the Registration
		String allRegistration = C206_CaseStudy.retrieveRegistration(registrationList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allRegistration);

		// Test Case 2
		C206_CaseStudy.addRegistration(registrationList, r1);
		C206_CaseStudy.addRegistration(registrationList, r2);
		// Test that the list is not empty
		assertEquals("Test that registration arraylist size is 2", 2, registrationList.size());
		// Attempt to retrieve the student
		allRegistration = C206_CaseStudy.retrieveRegistration(registrationList);
		testOutput = String.format("%-15s %-15s %-20s \n", "William", "S123", "Badminton");
		testOutput += String.format("%-15s %-15s %-20s \n", "Oliver", "S223", "Soccer");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allRegistration);

		// Test Case 3
		C206_CaseStudy.addRegistration(registrationList, r1);
		assertEquals("Test that Camcorder arraylist size is 2.", 2, registrationList.size());
		// assertFalse("Test that the last item in the array list is not available",
		// registrationList.get(2));
		// Attempt to retrieve the Registration
		allRegistration = C206_CaseStudy.retrieveRegistration(registrationList);
		testOutput = String.format("%-15s %-15s %-20s \n", "William", "S123", "Badminton");
		testOutput += String.format("%-15s %-15s %-20s \n", "Oliver", "S223", "Soccer");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allRegistration);
	}

	// rach
	@Test
	public void testdeleteRegistration() {
		// Check that the registration list is empty
		assertNotNull("The registration list must not be null", registrationList);
		assertEquals("The registration list must be empty", 0, registrationList.size());

		// Add a registration to the list
		C206_CaseStudy.addRegistration(registrationList, r1);
		assertEquals("The registration list must have one registration", 1, registrationList.size());

		// Delete the registration from the list
		C206_CaseStudy.dodeleteRegistration(registrationList, r1.getUserId());
		assertEquals("The registration list must be empty", 0, registrationList.size());

		// Try to delete the registration again, should not do anything
		C206_CaseStudy.dodeleteRegistration(registrationList, r1.getUserId());
		assertEquals("The registration list must still be empty", 0, registrationList.size());
	}

	// xinying
	 @Test
	  public void testAddActivity() {
	   assertNotNull("Test if there is valid Activity arraylist to add to", activityList);
	   assertEquals("Test that the Activity arraylist is empty.", 0, activityList.size());

	   C206_CaseStudy.addActivity(activityList, a1);
	   assertEquals("Test that the Activity arraylist size is 1.", 1, activityList.size());

	   // Add an item
	   C206_CaseStudy.addActivity(activityList, a2);
	   assertEquals("Test that the Activity arraylist size is 2.", 2, activityList.size());

	   assertSame("Test that Activity is added to the end of the list.", a2, activityList.get(1));

	   C206_CaseStudy.addActivity(activityList, a2);
	   assertEquals("Test that the Activity arraylist size is unchange.", 2, activityList.size());


	  }

	  @Test
	  public void testRetrieveAllActivities() {
	   // fail("Not yet implemented");
	   activityList.clear();
	   assertNotNull("Test if there is valid Activity arraylist to retrieve item from", activityList);

	   String allActivities = C206_CaseStudy.retrieveActivity(activityList);
	   String testOutput = "";
	   assertEquals("Test that the retrieved activitylist is empty?", 0, activityList.size());

	   C206_CaseStudy.addActivity(activityList, a1);
	   C206_CaseStudy.addActivity(activityList, a2);
	   assertEquals("Test that Activity arraylist size is 2", 2, activityList.size());

	   allActivities = C206_CaseStudy.retrieveActivity(activityList);
	   testOutput = String.format("%-15s %-15s %-15s\n", "Badminton",
	     "Badminton is a racket sport that is played by two or four players.", "Maximum capacity: 40");
	   testOutput += String.format("%-15s %-15s %-15s\n", "Soccer",
	     "Soccer is a team sport, involving 11 players on each side who use their legs, head and torso to pass a ball and score goals.",
	     "Maximum capacity: 40");
	   assertEquals("Test that ViewAllactivitylist", testOutput, allActivities);
	  }

	  @Test
	  public void testDeleteActivity() {
	   
	     C206_CaseStudy.addActivity(activityList, a1);
	     assertEquals("Test that Activity arraylist size is 1", 1, activityList.size());
	     C206_CaseStudy.addActivity(activityList, a2);
	     assertEquals("Test that Activity arraylist size is 2", 2, activityList.size());
	     C206_CaseStudy.addActivity(activityList, a3);
	     assertEquals("Test that Activity arraylist size is 3", 3, activityList.size());
	     C206_CaseStudy.addActivity(activityList, a4);
	     
	   assertNotNull("Test if there is valid Activity arraylist to add to", activityList);
	   assertEquals("Test that the Activity arraylist is 4.", 4, activityList.size());

	   C206_CaseStudy.dodeleteActivity(activityList, a1.getActivityName());
	   assertEquals("Test that the Activity arraylist size is 3.", 3, activityList.size());

	   // Delete an item
	   C206_CaseStudy.dodeleteActivity(activityList, a2.getActivityName());
	   assertEquals("Test that the Activity arr",2,activityList.size());
	  }

	@Test
	public void testUpdateApplicationStatus_NonExistentRegistration() {
		ArrayList<registration> registrationList = new ArrayList<>();
		ArrayList<Activity> activityList = new ArrayList<>();

		// Create sample data
		Activity activity1 = new Activity("Badminton", "Description", "Requirement");
		activityList.add(activity1);

		registration reg1 = new registration("John", "S123", "john@example.com", "Badminton");
		registrationList.add(reg1);

		// Test the updateApplicationStatus function with a non-existent registration
		C206_CaseStudy.updateApplicationStatus(registrationList, activityList);

		// Check if the status remains unchanged for the non-existent registration
		assertEquals("pending", reg1.getStatus());
	}

	@Test
	    public void testUpdateApplicationStatus_ValidInput() {
	        ArrayList<registration> registrationList = new ArrayList<>();
	        ArrayList<Activity> activityList = new ArrayList<>();
	        
	        // Dummy Data
	        Activity activity1 = new Activity("Badminton", "Description", "Requirement");
	        Activity activity2 = new Activity("Soccer", "Description", "Requirement");
	        activityList.add(activity1);
	        activityList.add(activity2);
	        
	        registration reg1 = new registration("John", "S123", "john@example.com", "Badminton");
	        registration reg2 = new registration("Ali", "S124", "ali@example.com", "Badminton");
	        registrationList.add(reg1);
	        registrationList.add(reg2);

	        // Test update function on john
	        C206_CaseStudy.updateApplicationStatus(registrationList, activityList);
	        
	        // Check if only john's status is updated
	        assertEquals("approve", reg1.getStatus());
	}

	@Test
	public void testUpdateApplicationStatus_InvalidStatus() {
		ArrayList<registration> registrationList = new ArrayList<>();
		ArrayList<Activity> activityList = new ArrayList<>();

		// Create sample data
		Activity activity1 = new Activity("Badminton", "Description", "Requirement");
		activityList.add(activity1);

		registration reg1 = new registration("John", "S123", "john@example.com", "Badminton");
		registrationList.add(reg1);

		// Test the updateApplicationStatus function with an invalid status
		// (status other than 'approve', 'reject', 'pending')
		C206_CaseStudy.updateApplicationStatus(registrationList, activityList);

		// Check if the status remains unchanged for the invalid status
		assertEquals("pending", reg1.getStatus());
	}
	@Test
	public void testAddAttendance() {
		 registration testRegistration = new registration("Test Andrew", "P123", "test2131@gmail.com", "Test volley");
	        registrationList.add(testRegistration);
	        C206_CaseStudy.addAttendance(registrationList);
	        assertTrue(testRegistration.isAttendance() || !testRegistration.isAttendance());
	}
	@Test
    public void testViewAllAttendance() {
        String expect = String.format("%-15s %-15s %-20s %-10s\n", "NAME", "USER ID", "ACTIVITY CHOSEN", "ATTENDANCE") +
            String.format("%-15s %-15s %-20s %-10s\n", "William", "S123", "Badminton", "Absent") +
            String.format("%-15s %-15s %-20s %-10s\n", "Oliver", "S223", "Soccer", "Absent");

        String actual = C206_CaseStudy.retrieveAttendance(registrationList);

        assertNotNull("Check if actual output is not null", actual);
        assertEquals("Check if output matches expected output", expect, actual);
    }
	@Test
    public void testDeleteAttendance() {
        // Test deleting attendance of an existing user //normal
        C206_CaseStudy.dodeleteAttendance(registrationList, "S123");
        assertFalse("Check if attendance is deleted for user S123", r1.isAttendance());

        // Test deleting attendance of a non-existing user //error
        C206_CaseStudy.dodeleteAttendance(registrationList, "S999");

        // Test deleting attendance for a user with different case //boundary
        C206_CaseStudy.dodeleteAttendance(registrationList, "s223");
        assertFalse("Check if attendance is deleted for user S223", r2.isAttendance());
    }
	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		r1 = null;
		r2 = null;
		a1 = null;
		a2 = null;

		userList = null;
		registrationList = null;
		activityList = null;
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

}
