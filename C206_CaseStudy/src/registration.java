
public class registration {
	String name;
	String userId;
	String email;
	String CCAc;
	String status;
	boolean attendance;
	
	public registration(String name, String userId, String email,String CCAc) {
		this.name=name;
		this.userId=userId;
		this.email=email;
		this.CCAc=CCAc;
		this.status = "pending";
		this.attendance = false;
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
	public boolean isAttendance() {
		return attendance;
	}
	public void setAttendance(boolean present) {
		this.attendance = present;
	}
	public String getStatus() {
        return status;
    }
	public void setStatus(String status) {
        this.status = status;
    }

}
//a