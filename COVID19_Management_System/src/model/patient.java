package model;

public class patient {
	private int patientID;
	private String fname;
	private String lname;
	private String Gender;
	private String Phone;
	private String Address;
	DBConnection db = new DBConnection();
	
	// Logical Function Code
	public boolean saveData() {
		String query = "INSERT INTO COVID19_Management_System.Patient (fname, lname, Gender, Phone, Address)\r\n" +
				"VALUES ('" +
				this.fname + "', '" +
				this.lname + "', '" +
				this.Gender + "', '" +
				this.Phone + "', '" +
				this.Address + "'\r\n);";
		db.executeInsertUpdate(query);
		return true;
	}
	
	// Constructors
	public patient(int patientID, String fname, String lname, String gender, String phone, String address) {
		super();
		this.patientID = patientID;
		this.fname = fname;
		this.lname = lname;
		Gender = gender;
		Phone = phone;
		Address = address;
	}

	public patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Setters & Getters
	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
}
