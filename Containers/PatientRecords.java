package creating_views;

import java.io.PrintWriter;
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
	
	
	private boolean add;
	
	
    public PatientRecords(List<PatientRecord> patientrecords) {
        this.patientrecords = patientrecords;
    }
	
   public void addPatientRecord(String name, String surName, Gender male, LocalDate dOB, String phoneno,int patientId, int drId ,int age) throws Exception  {
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	
    	patientrecords.add(new PatientRecord( name, surName, male, dOB, phoneno , patientId, drId , age));
		ResourceManager.save((Serializable) patientrecords, "files\\patientrecordss.ser"); 

    	
   }
    

	
	public Optional<List<PatientRecord>> searchPatientRecordByName(String patientName) throws Exception{
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	

	     List<PatientRecord> d = patientrecords.stream().filter(pt -> pt.name().equals(patientName)).collect(Collectors.toList());
	     return Optional.ofNullable(d);
		
	}
	public Optional<List<PatientRecord>> searchPatientRecordBydrId(int drId) throws Exception{
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	

	     List<PatientRecord> d = patientrecords.stream().filter(pt -> pt.drId() == drId).collect(Collectors.toList());
	     return Optional.ofNullable(d);
		
	}
	
	public boolean isThePatientExistById(int pId) throws Exception {
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	

		 return patientrecords.stream().anyMatch(p -> p.patientId() == pId);
	}
	
	public void removePatientRecordById(int ids) throws Exception {
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	

		patientrecords.stream().filter(p -> p.patientId() == ids).collect(Collectors.toList()).removeAll(patientrecords);
		ResourceManager.save((Serializable) patientrecords, "files\\patientrecordss.ser"); 

				}
	
    public List<String> getPatientNames() throws Exception {
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	

        List<String> PatientNames = new ArrayList<>();
        patientrecords.forEach(p -> PatientNames.add(p.name()));
        return PatientNames;
    }
    
	public void viewRecords() throws Exception{
		
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	
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

	public void viewRecords(PrintWriter out) throws Exception {
		List<PatientRecord> patientrecords =  (List<PatientRecord>) ResourceManager.load("files\\patientrecordss.ser");	
		patientrecords.forEach(out:: println);
		
	}

	public void printSearching(Optional<List<PatientRecord>> o, PrintWriter out) {
		if(!o.isEmpty()) {
			out.println(o.toString());
			}else {
				o.get();
			}		
	}

	
}
