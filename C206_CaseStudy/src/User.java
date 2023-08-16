
public class User {
	String username;
	String email;
	String password;
	String role;
	String userId;

	public User(String userId,String username, String email, String password,String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {	
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getRole() {
		return role;
	}
	public String getUserId() {
		return userId;
	}
	public void setName(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void display() {
		System.out.println(String.format("Username :%s", username));
		System.out.println(String.format("User Id  :%s", userId));
		System.out.println(String.format("Email :%s", email));
		System.out.println(String.format("Role:%s", role));
	}

}

