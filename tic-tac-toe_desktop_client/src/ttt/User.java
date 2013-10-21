package ttt;

public class User {
	
	private String keyWord = "";
	private String userName = "";
	private String email = "";
	private String password = "";
	
	private int tttWin  = 0;
	private int tttLoss = 0;
	private int tttDraw = 0;
	private int bshWin  = 0;
	private int bshLoss = 0;
	private int bshDraw = 0;
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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
	public int getTttWin() {
		return tttWin;
	}
	public void setTttWin(int tttWin) {
		this.tttWin = tttWin;
	}
	public int getTttLoss() {
		return tttLoss;
	}
	public void setTttLoss(int tttLoss) {
		this.tttLoss = tttLoss;
	}
	public int getTttDraw() {
		return tttDraw;
	}
	public void setTttDraw(int tttDraw) {
		this.tttDraw = tttDraw;
	}
	public int getBshWin() {
		return bshWin;
	}
	public void setBshWin(int bshWin) {
		this.bshWin = bshWin;
	}
	public int getBshLoss() {
		return bshLoss;
	}
	public void setBshLoss(int bshLoss) {
		this.bshLoss = bshLoss;
	}
	public int getBshDraw() {
		return bshDraw;
	}
	public void setBshDraw(int bshDraw) {
		this.bshDraw = bshDraw;
	}
	
	
}
