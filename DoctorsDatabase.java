package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import creating_views.Doctor;
import creating_views.Receptionist;

public class DoctorsDatabase {
	static final String DB_URL = "jdbc:mysql://localhost/systemofpatients";
	static final String USER = "root";
	static final String PASS = "";
	public Connection conn;
	
	public DoctorsDatabase() throws SQLException {
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}

	public void insertIntoDrs() throws SQLException {
		
		String insertSQL = "INSERT INTO Doctor VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ins = conn.prepareStatement(insertSQL);
		int afterLastIndex = Lists.drList.size();
		Doctor d = Lists.drList.get(afterLastIndex - 1);
		ins.setInt(1, d.getId());
		ins.setString(2, d.getUsername());
		ins.setString(3, d.getPassword());
		ins.setString(4, d.getName());
		ins.setString(5, d.getPhoneno());
		ins.setString(6, d.getgender().toString());
		ins.setInt(7, d.getAge());
		ins.setInt(8, d.getSalary());
		ins.setInt(9, d.getYearsOfExperience());
		ins.setString(10, d.getSpeciality());
		ins.setString(11, d.getPosition().toString());
		}
	
	public void deleteInDrsTable(int id) throws SQLException {
		String DELETE = "DELETE FROM Doctor WHERE id = " + id+";";
		Statement delete = conn.createStatement();
		delete.executeUpdate(DELETE);
		
	}
	public void searchByDrName(String name) throws SQLException {
		String SEARCH = "SELECT * FROM Doctor WHERE Name = " +name +";";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(SEARCH);
		while(s.next()) {
			String Doctors = "";
			for(int i = 1; i < 12; i++) {
				
					Doctors += s.getString(i);
				
			}
			System.out.println("Doctor" + Doctors);
		}
	}
	
	public void getAllDrs() throws SQLException {
		String GETALL = "SELECT * FROM Doctor;";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(GETALL);
		while(s.next()) {
			String Doctors = "";
			for(int i = 1; i < 12; i++) {
				
					Doctors += s.getString(i);
				
			}
			System.out.println("Doctor" + Doctors);
		}
	}
	
	public void getOnlyNames() throws SQLException {
		String GETNAMES = "SELECT name FROM Doctor;";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(GETNAMES);
		while(s.next()) {
			String Doctors = "";
			for(int i = 1; i < 2; i++) {
				
					Doctors += s.getString(i);
				
			}
			System.out.println("Doctor Names" + Doctors);
		}
	}
	
}
