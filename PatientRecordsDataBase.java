package View;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import creating_views.PatientRecord;

public class PatientRecordsDataBase {

	static final String DB_URL = "jdbc:mysql://localhost/systemofpatients";
	static final String USER = "root";
	static final String PASS = "";
	private static Connection conn;
	
	public PatientRecordsDataBase() throws SQLException {
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}


	public void insertIntoPRs() throws SQLException {
		
		String insertSQL = "INSERT INTO patientRecord VALUES(?,?,?,?,?,?,?,?);";
		PreparedStatement ins = conn.prepareStatement(insertSQL);
		int afterLastIndex = Lists.patientList.size();
		PatientRecord d = Lists.patientList.get(afterLastIndex - 1);
		ins.setString(1, d.name());
		ins.setString(2, d.surName());
		ins.setString(3, d.gender().toString());
		ins.setDate(4, Date.valueOf(d.dOB()));
		ins.setString(5, d.phoneno());
		ins.setInt(6, d.patientId());
		ins.setInt(7, d.drId());
		ins.setInt(8, d.age());
		
	}
	
	public void deleteInPRTable(int id) throws SQLException {
		
		String DELETE = "DELETE FROM patientRecord WHERE id = " + id+";";
		Statement delete = conn.createStatement();
		delete.executeUpdate(DELETE);
		
	}
	public Optional<ResultSet> searchByPRName(String name) throws SQLException {
		String SEARCH = "SELECT * FROM patientRecord WHERE Name = " +name +";";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(SEARCH);
		
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 9; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient Records" + PRs);
		}
		return Optional.ofNullable(s);
	}
	
	public void getAllPRs() throws SQLException {
		String GETALL = "SELECT * FROM patientRecord;";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(GETALL);
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 9; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient Records" + PRs);
		}
	}
	
	
	public void getOnlyNames() throws SQLException {
		
		String GETNAMES = "SELECT name FROM  PatientRecord;";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(GETNAMES);
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 9; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient Records" + PRs);
		}
	}
	
	public Optional<ResultSet> searchPRByDrId(int drid) throws SQLException{
		String SEARCH = "SELECT * FROM patientRecord WHERE drId = " +drid+";";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(SEARCH);
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 9; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient Records" + PRs);
		}
		return Optional.ofNullable(s);
	}
	
	
	
}
