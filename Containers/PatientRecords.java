package creating_views;

import java.io.Serializable;
import java.time.LocalDate;
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
	private List<PatientRecord> patientrecords;
	
	//private Scanner in = new Scanner(System.in);
	
	private boolean add;
	
	
    public PatientRecords(List<PatientRecord> patientrecords) {
        this.patientrecords = patientrecords;
    }
	
   public void addPatientRecord(String name, String surName, Gender male, LocalDate dOB, String phoneno,int patientId, int drId ,int age) throws Exception  {
    	
    	patientrecords.add(new PatientRecord( name, surName, male, dOB, phoneno , patientId, drId , age));
    	
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
	
	public Optional<List<PatientRecord>> searchPatientRecordByName(String patientName){
	     List<PatientRecord> d = patientrecords.stream().filter(pt -> pt.name().equals(patientName)).collect(Collectors.toList());
	     return Optional.ofNullable(d);
		
	}
	public Optional<List<PatientRecord>> searchPatientRecordBydrId(int drId){
	     List<PatientRecord> d = patientrecords.stream().filter(pt -> pt.drId() == drId).collect(Collectors.toList());
	     return Optional.ofNullable(d);
		
	}
	
	public boolean isThePatientExistById(int pId) {
		 return patientrecords.stream().anyMatch(p -> p.patientId() == pId);
	}
	
	public void removePatientRecordById(int ids) {
		patientrecords.stream().filter(p -> p.patientId() == ids).collect(Collectors.toList()).removeAll(patientrecords);
												}
	
    public List<String> getPatientNames() {
        List<String> PatientNames = new ArrayList<>();
        patientrecords.forEach(p -> PatientNames.add(p.name()));
        return PatientNames;
    }
    
	public void viewRecords(){
		
		patientrecords.forEach(System.out:: println);
	
	}
	
	public boolean isAdd() {
		return add;
	}

	

	

	public void printSearching(Optional<List<PatientRecord>> o) {
		
		if(!o.isEmpty()) {
		System.out.println(o.toString());
		}else {
			o.get();
		}
		}

	
}
