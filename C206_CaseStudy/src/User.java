
public class User {
	String username;
	String email;
	String password;
	String role;

	public User(String username, String email, String password,String role) {
		super();
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
	public void setName(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
//aww
