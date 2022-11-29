package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import creating_views.Doctor;
import creating_views.Receptionist;

public class ReceptionistsDatabase {

	static final String DB_URL = "jdbc:mysql://localhost/systemofpatients";
	static final String USER = "root";
	static final String PASS = "";
	public Connection conn;
	
	public ReceptionistsDatabase() throws SQLException {
	 conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}

	public void insertIntoDrs() throws SQLException {
		String insertSQL = "INSERT INTO Receptionist VALUES(?,?,?,?,?,?,?,?);";
		PreparedStatement ins = conn.prepareStatement(insertSQL);
		int afterLastIndex = Lists.receptionistList.size();
		Receptionist d = Lists.receptionistList.get(afterLastIndex - 1);
		ins.setInt(1, d.getId());
		ins.setString(2, d.getUsername());
		ins.setString(3, d.getPassword());
		ins.setString(4, d.getName());
		ins.setString(5, d.getPhoneno());
		ins.setString(6, d.getgender().toString());
		ins.setInt(7, d.getAge());
		ins.setInt(8, d.getSalary());
		}
	
	public void deleteInDrsTable(int id) throws SQLException {
		String DELETE = "DELETE FROM Receptionist WHERE id = " + id+";";
		Statement delete = conn.createStatement();
		delete.executeUpdate(DELETE);
		
	}
	public void searchByDrName(String name) throws SQLException {
		String SEARCH = "SELECT * FROM Receptionist WHERE Name = " +name +";";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(SEARCH);
		while(s.next()) {
			String Receptionists = "";
			for(int i = 1; i < 9; i++) {
				
					Receptionists += s.getString(i);
				
			}
			System.out.println("Receptionists" + Receptionists);
		}
	}
	
	public void getAllDrs() throws SQLException {
		String GETALL = "SELECT * FROM Receptionist;";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(GETALL);
		while(s.next()) {
			String Receptionists = "";
			for(int i = 1; i < 9; i++) {
				
					Receptionists += s.getString(i);
				
			}
			System.out.println("Receptionists" + Receptionists);
		}
	}
	
	
	public void getOnlyNames() throws SQLException {
		String GETNAMES = "SELECT name FROM  Receptionist;";
		Statement searchByName = conn.createStatement();
		ResultSet s = searchByName.executeQuery(GETNAMES);
		while(s.next()) {
			String Receptionists = "";
			for(int i = 1; i < 9; i++) {
				
					Receptionists += s.getString(i);
				
			}
			System.out.println("Receptionists" + Receptionists);
		}
	}
}
