package data_transfer;

public class Security_Registration {
	final String className  = "Security_Registration";
	
	private String userName = "";
	private String email 	= "";
	private String password = "";
	private boolean result = false;
	
	public String getClassName() {
		return className;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	
}
