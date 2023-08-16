
public class registration {
	String name;
	String userId;
	String email;
	String CCAc;
	
	public registration(String name, String userId, String email,String CCAc) {
		this.name=name;
		this.userId=userId;
		this.email=email;
		this.CCAc=CCAc;
	}
	
	public String getName() {
		return name;
		
	}public String getUserId() {
		return userId;
		
	}public String getEmail() {
		return email;
	}
	public String getCCAc() {
		return CCAc;
	}
	public void setName(String name) {
		this.name = name;
		
	}public void setEmail(String email) {
		this.email=email;
	}

}
//a