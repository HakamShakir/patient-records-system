package SystemForPatients;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Receptionist extends User{
	private LocalDate d = LocalDate.now();
	private Scanner in = new Scanner(System.in);
	private String patientName;
	
	public Receptionist(String username,String password,String name,String phoneno, Gender gender, Position position, int age, int id, int salary) {
		super(username,password,name,phoneno, gender, position, age, id, salary);
		
	}


	
	public void showRecord() {
		System.out.println(getName());
		System.out.println(getPhoneno());
		System.out.println(getPosition());
		System.out.println(getAge());
		System.out.println(getSalary());
		
		System.out.println(getId());
	}
	
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public void getPatientInfo() {
		
	}
	
	public void addPatient(List<PatientRecord> patientRecord) {
		
		System.out.println("enter the patient info's");
		
		System.out.println("enter the patient Id:");
		int patientId = in.nextInt();
		
		System.out.println("name: " );
		String name = in.next();
		
		System.out.println("surName: ");
		String surName = in.next();
		 
	    System.out.println("DR ID: ");
	    int drId = in.nextInt();
	
	    System.out.println("phone Number:");
	    String phoneNum = in.next();
	    
	    System.out.println("enter DOB in M/d/yyyy format: ");
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    String userInput = in.next();
		LocalDate DOB = LocalDate.parse(userInput , dateFormat);
		
		System.out.println("enter gender:");
		String g = in.next();
		Gender gender = Gender.valueOf(g.toUpperCase());
		
		
		patientRecord.add(new PatientRecord(name, surName, gender, DOB, phoneNum, patientId,drId));
	   
		
		
	}
	
	public void enterPatientName() {
		System.out.println("enter the name of the patient:");
		patientName = in.next();
	}
	
	public void viewRecords(List<Object>  records){
	
		records.stream().forEach(System.out:: println);
		
	}
	public void printSearching(Optional<List<Object>> o) {
		
		if(!o.isEmpty()) {
		System.out.println(o.toString());
		}else {
			o.get();
		}
	
	
}
	
}
