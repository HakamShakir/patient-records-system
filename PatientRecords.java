package SystemForPatients;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.Scanner;
import java.util.stream.Collectors;

public class PatientRecords implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	List<PatientRecord> patientrecords;
	//private Scanner in = new Scanner(System.in);
	private int ids;
	private String patientName;
	
	
    public PatientRecords(List<PatientRecord> patientrecords) {
        this.patientrecords = patientrecords;
    }
	
    void addPatientRecord(String name, String surName, Gender gender, LocalDate dOB, String phoneno,int patientId, int drId )  {
    	PatientRecord r = new PatientRecord( name,  surName,  gender,  dOB,  phoneno, patientId,  drId );
    	patientrecords.add(r);
    }
    
//	public void enterId() {
//		System.out.println("enter the id that you wanna perform an operation on it: ");
//		ids = in.nextInt();
//	}
	
//	public void enterPatientName() {
//		System.out.println("enter the name of the patient:");
//		patientName = in.next();
//	}


 /*   void addpatientRecrod()  {
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
		patientrecords.add(new PatientRecord(name, surName, gender, DOB, phoneNum, patientId,drId));
    }
    
    */
	
	public Optional<List<PatientRecord>> searchPatientRecordByName(){
	     List<PatientRecord> d = patientrecords.stream().filter(pt -> pt.name().equals(patientName)).collect(Collectors.toList());
		return Optional.ofNullable(d);
		
	}
	
	public void removePatientRecordById() {
		patientrecords.stream().filter(p -> p.patientId() == ids).collect(Collectors.toList()).removeAll(patientrecords);
}
	
    public List<String> getPatientNames() {
        List<String> PatientNames = new ArrayList<>();
        patientrecords.forEach(p -> PatientNames.add(p.name()));
        return PatientNames;
    }
    
	public void viewRecords(){
		patientrecords.stream().forEach(System.out:: println);
		
	}

	//public void printSearching(Optional<List<Object>> o) {
		
	//	if(!o.isEmpty()) {
	//	System.out.println(o.toString());
	//	}else {
	//		o.get();
	//	}

	
}
