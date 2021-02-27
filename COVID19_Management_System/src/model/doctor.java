package model;

public class doctor {
	// Data Members
	private int doctorID;
	private String fname;
	private String lname;
	private String type;
	private String Gender;
	private String Phone;
	private String Address;
	private String Status;
	DBConnection db = new DBConnection();
	
	// Logical Function Code
		public boolean saveData() {
			String query = "INSERT INTO COVID19_Management_System.Doctor (fname, lname, type, Gender, Phone, Address, Status)\r\n" +
					"VALUES ('" +
					this.fname + "', '" +
					this.lname + "', '" +
					this.type + "', '" +
					this.Gender + "', '" +
					this.Phone + "', '" +
					this.Address + "', '" +
					this.Status + "'\r\n);";
			db.executeInsertUpdate(query);
			return true;
		}
	
	// Constructors
	
	public doctor(int doctorID, String fname, String lname, String type, String gender, String phone, String address,
			String status) {
		super();
		this.doctorID = doctorID;
		this.fname = fname;
		this.lname = lname;
		this.type = type;
		Gender = gender;
		Phone = phone;
		Address = address;
		Status = status;
	}

	public doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Setters & Getters

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
}