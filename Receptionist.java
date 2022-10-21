package updated_system;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.jar.JarException;
import java.util.stream.Collectors;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.format.DateTimeParseException;



public class Receptionist extends User{

	private LocalDate d = LocalDate.now();

	private Scanner in = new Scanner(System.in);
	private String patientName;

	
	public String getPatientName() {
		return patientName;
	}

	

	public Receptionist(String username,String password,String name,String phoneno, Gender gender, Position position, int age, int id, int salary) {
		super(username,password,name,phoneno, gender, position, age, id, salary);
		
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
		
		int age = d.getYear()-DOB.getYear();
		
		patientRecord.add(new PatientRecord(name, surName, gender, DOB, phoneNum, patientId, drId, age));
	   
		
		
	}
	
	public void enterPatientName() {
		System.out.println("enter the name of the patient:");
		patientName = in.next();
	}
	
	public void viewRecords(List<Object>  records){
	
		records.stream().forEach(System.out:: println);
		
	}
	


	
	
	public Optional<List<PatientRecord>> searchByName(List<PatientRecord>  records) {
		
		
     List<PatientRecord> d = records.stream().filter(p -> p.name().equals(patientName)).collect(Collectors.toList());
	
		return Optional.ofNullable(d);
		
	}
	
	
	public void printSearching(Optional<List<Object>> o) {
		
			if(!o.isEmpty()) {
			System.out.println(o.toString());
			}else {
				o.get();
			}
		
		
	}
	

	
	public void removeByName(List<PatientRecord>  records) {
		
		Optional<List<PatientRecord>> searchByName = searchByName(records);
		records.remove(searchByName);
		
	}
	
	

	public void addPatientsVisits(Map<String,PatientVisit> visits) {
		
		enterPatientName();
//		int drId ,String chiefComplaint, String history, String vitals,
//		String investigation, String treatement, String recommendation,
//		LocalDate DateOfSubmission ,String duration, double price
		System.out.println("enter drId ID:");
		int drId = in.nextInt();
		System.out.println("enter cheif complaint: ");
		String chiefComplaint = in.next();
		System.out.println("enter history of the patient: ");
		String history = in.next();
		System.out.println("enter the vitals: ");
		String vitals = in.next();
		System.out.println("enter the investigation: ");
		String investigation = in.next();
		System.out.println("enter treatments: ");
		String treatments = in.next();
		System.out.println("enter recommendation: ");
		String recommendation = in.next();
		System.out.println("enter duration: ");
		String duration = in.next();
		System.out.println("enter the price: ");
		double price = in.nextDouble();
		
		visits.put(patientName, new PatientVisit(drId, chiefComplaint, history, vitals, investigation
				, treatments, recommendation, d, duration, price));
		
	}
	
	public PatientVisit returnVisitsByName(Map<String, PatientVisit> visits) {
		
		return visits.get(patientName);
		
	}
	
	
	
}