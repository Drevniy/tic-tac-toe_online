package data_transfer;

public class Security_Authorization
{
	final String className  = "Security_Authorization";
	
	private String userName = "";
	private String password = "";
	private boolean result 	= false;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
