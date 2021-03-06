package beans;

public class User {
	private String email="";
	private String password="";
	private String message = "";
	
	public User() {
		
	}
	//constructor
	public String getMessage() {
		return message;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	//getter and setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//validate
	public boolean validate() {
		
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email address";
			return false;
		}
		
		if(password.length()<8) {
			message = "Password must be at least 8 characters.";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "Password cannot containt space.";
			return false;
		}
		
		return true;
	}
}
