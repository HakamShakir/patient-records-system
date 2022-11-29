package View;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;

import creating_views.PatientRecord;
import creating_views.PatientVisit;

public class PVDataBase {
	static final String DB_URL = "jdbc:mysql://localhost/systemofpatients";
	static final String USER = "root";
	static final String PASS = "";
	private static Connection conn;
	
	public PVDataBase() throws SQLException {
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}


	public void insertIntoPRs() throws SQLException {
		
		String insertSQL = "INSERT INTO patientRecord VALUES(?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ins = conn.prepareStatement(insertSQL);
		int afterLastIndex = Lists.pvList.size();
		PatientVisit d = Lists.pvList.get(afterLastIndex - 1);
		ins.setInt(1, d.pId());
		ins.setInt(2, d.drId());
		ins.setInt(3, d.visitId());
		ins.setString(4, d.chiefComplaint());
		ins.setString(5, d.history());
		ins.setString(6, d.treatement());
		ins.setString(7, d.recommendation());
		ins.setDate(8, Date.valueOf(d.DateOfSubmission()));
		ins.setString(9, d.duration());
		ins.setFloat(9, (float)d.price());
		
	}
	
	public void deleteInPVTable(int id) throws SQLException {
		
		String DELETE = "DELETE FROM patientVisit WHERE id = " + id+";";
		Statement delete = conn.createStatement();
		delete.executeUpdate(DELETE);
		
	}
	public void deleteInPVTableBYPId(int pid) throws SQLException {
		
		String DELETE = "DELETE FROM patientVisit WHERE pid = " + pid+";";
		Statement delete = conn.createStatement();
		delete.executeUpdate(DELETE);
		
	}
	
	public Optional<ResultSet> searchByPId(int id) throws SQLException {
		String SEARCH = "SELECT * FROM patientVisit WHERE pId = " + id +";";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(SEARCH);
		
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 11; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient Visits" + PRs);
		}
		return Optional.ofNullable(s);
	
	}
	
	public Optional<ResultSet> searchByDateOfSubmission(LocalDate d) throws SQLException {
		
		String SEARCH = "SELECT * FROM patientVisit WHERE DateOfSubmission = " + Date.valueOf(d) +";";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(SEARCH);
		
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 11; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient Visits" + PRs);
		}
		return Optional.ofNullable(s);
	}
	
	public Optional<ResultSet> getAllPVs() throws SQLException {
		String GETALL = "SELECT * FROM patientVisit;";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(GETALL);
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 9; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient visits" + PRs);
		}
		return Optional.ofNullable(s);
	}
	
	
	
	
	public Optional<ResultSet> searchPVByDrId(int drid) throws SQLException{
		
		String SEARCH = "SELECT * FROM patientVisit WHERE drId = " +drid+";";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(SEARCH);
		while(s.next()) {
			String PRs = "";
			for(int i = 1; i < 9; i++) {
				
				PRs += s.getString(i);
				
			}
			System.out.println("Patient visits" + PRs);
		}
		return Optional.ofNullable(s);
	}
	
}
