package model;

public class admission {
	// Data Members
	private int admitID;
	private int patientID;
	private int doctorID;
	private int roomNo;
	private int bedNo;
	private String Status;
	DBConnection db = new DBConnection();
	
	// Logical Function Code
	public boolean saveData() {
		String query = "INSERT INTO COVID19_Management_System.Admission (patientID, doctorID, roomNo, bedNo, Status)\r\n" +
				"VALUES ('" +
				this.patientID + "', '" +
				this.doctorID + "', '" +
				this.roomNo + "', '" +
				this.bedNo + "', '" +
				this.Status + "'\r\n);";
		db.executeInsertUpdate(query);
		return true;
	}
	
	// Constructors
	public admission(int admitID, int patientID, int doctorID, int roomNo, int bedNo, String status) {
		super();
		this.admitID = admitID;
		this.patientID = patientID;
		this.doctorID = doctorID;
		this.roomNo = roomNo;
		this.bedNo = bedNo;
		Status = status;
	}

	public admission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Setters & Getters

	public int getAdmitID() {
		return admitID;
	}

	public void setAdmitID(int admitID) {
		this.admitID = admitID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getBedNo() {
		return bedNo;
	}

	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
}
