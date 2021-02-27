package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DBConnection {
	private Connection conn;
	private Statement stat;
	
	public void initMySQLjdbc()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String connectionURL = "jdbc:mysql://localhost:3306/";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execute(String query)
	{
		initMySQLjdbc();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeInsertUpdate(String query)
	{
		initMySQLjdbc(); Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeSelect(String query)
	{
		initMySQLjdbc();
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
