package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import creating_views.HospitalManagement;
import creating_views.Receptionist;

public class HMDataBase {

	static final String DB_URL = "jdbc:mysql://localhost/systemofpatients";
	static final String USER = "root";
	static final String PASS = "";
	private Connection conn;
	
	public HMDataBase() throws SQLException {
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}

	public void insertAllIntoHM() throws SQLException {
		String insertSQL = "INSERT INTO HospitalManagement VALUES(?,?,?,?,?,?,?,?);";
		PreparedStatement ins = conn.prepareStatement(insertSQL);
		
		for(HospitalManagement d : Lists.hList) {
		ins.setInt(1, d.getId());
		ins.setString(2, d.getUsername());
		ins.setString(3, d.getPassword());
		ins.setString(8, d.getName());
		ins.setString(4, d.getPhoneno());
		ins.setString(5, d.getgender().toString());
		ins.setInt(6, d.getAge());
		ins.setInt(7, d.getSalary());}
		}
}
