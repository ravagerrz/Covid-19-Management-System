package model;

public class DBCreation {
	DBConnection db = new DBConnection();
	
	public void createDatabase()
	{
		String query = "CREATE DATABASE IF NOT EXISTS COVID19_Management_System";
		db.execute(query);
		
		String query1 = "CREATE TABLE IF NOT EXISTS COVID19_Management_System.Login (\r\n" +
				"userID INT NOT NULL AUTO_INCREMENT , \r\n" +
				"username varchar(250) NOT NULL , \r\n" +
				"password varchar(250) NOT NULL , \r\n" +
				"PRIMARY KEY (userID) \r\n" +
				") ENGINE = INNODB;";
		db.execute(query1);
		
		String query2 = "CREATE TABLE IF NOT EXISTS COVID19_Management_System.Patient (\r\n" +
				"patientID INT NOT NULL AUTO_INCREMENT , \r\n" +
				"fname varchar(250) NOT NULL , \r\n" +
				"lname varchar(250) NOT NULL , \r\n" +
				"Gender varchar(250) NOT NULL , \r\n" +
				"Phone varchar(250) NOT NULL , \r\n" +
				"Address varchar(250) NOT NULL , \r\n" +
				"PRIMARY KEY (patientID) \r\n" +
				") ENGINE = INNODB;";
		db.execute(query2);
		
		String query3 = "CREATE TABLE IF NOT EXISTS COVID19_Management_System.Doctor (\r\n" +
				"doctorID INT NOT NULL AUTO_INCREMENT , \r\n" +
				"fname varchar(250) NOT NULL , \r\n" +
				"lname varchar(250) NOT NULL , \r\n" +
				"type varchar(250) NOT NULL , \r\n" +
				"Gender varchar(250) NOT NULL , \r\n" +
				"Phone varchar(250) NOT NULL , \r\n" +
				"Address varchar(250) NOT NULL , \r\n" +
				"Status varchar(250) NOT NULL , \r\n" +
				"PRIMARY KEY (doctorID) \r\n" +
				") ENGINE = INNODB;";
		db.execute(query3);
		
		String query4 = "CREATE TABLE IF NOT EXISTS COVID19_Management_System.Admission (\r\n" +
				"admitID INT NOT NULL AUTO_INCREMENT , \r\n" +
				"patientID INT NOT NULL , \r\n" +
				"doctorID INT NOT NULL , \r\n" +
				"roomNo INT NOT NULL , \r\n" +
				"bedNo INT NOT NULL , \r\n" +
				"Status varchar(250) NOT NULL , \r\n" +
				"PRIMARY KEY (admitID) \r\n" +
				") ENGINE = INNODB;";
		db.execute(query4);
		
		/*
		String query5 = "CREATE TABLE IF NOT EXISTS COVID19_Management_System.Tests (\r\n" +
				"testID INT NOT NULL AUTO_INCREMENT , \r\n" +
				"patientID INT NOT NULL , \r\n" +
				"Status varchar(250) NOT NULL , \r\n" +
				"PRIMARY KEY (testID) \r\n" +
				") ENGINE = INNODB;";
		db.execute(query5);
		
		String query6 = "CREATE TABLE IF NOT EXISTS COVID19_Management_System.Room (\r\n" +
				"roomNo INT NOT NULL , \r\n" +
				"bedsOccupied INT NOT NULL , \r\n" +
				"bedsAvailable INT NOT NULL , \r\n" +
				"PRIMARY KEY (roomNo) \r\n" +
				") ENGINE = INNODB;";
		db.execute(query6);
		*/
	}
}