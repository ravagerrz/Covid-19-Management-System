package model;

public class login {
	// Data Members
	private String username;
	private String password;
	DBConnection db = new DBConnection();
	
	// Logical Function Code
	public boolean saveData() {
		String query = "INSERT INTO COVID19_Management_System.Login (username, password)\r\n" +
				"VALUES ('" +
				this.username + "', '" +
				this.password + "'\r\n);";
		db.executeInsertUpdate(query);
		return true;
	}
	
	// Constructors
	public login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Setters & Getters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}