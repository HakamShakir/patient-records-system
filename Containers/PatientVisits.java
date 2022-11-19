package creating_views;

import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PatientVisits  implements Serializable{

	
	
	private static final long serialVersionUID = 2L;
	private List<PatientVisit> patientvisits;
	

	
    
	public PatientVisits(List<PatientVisit> pv) {
        this.patientvisits = pv;
    }
	
    
    public void addPatientVisit(int pId,int drId ,String chiefComplaint, String history, String treatement, String recommendation,LocalDate DateOfSubmission ,String duration, double price ,int visitId) throws Exception  {
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");
    	patientvisits.add(new PatientVisit( pId,  drId,visitId, chiefComplaint,  history,  treatement ,recommendation,DateOfSubmission,duration,price));
    	ResourceManager.save((Serializable) patientvisits, "files\\patientrecords.ser");
    }
    
	
	
	
    public Optional<List<PatientVisit>> searchPatientVisitByDateOfSubmission(LocalDate d) throws Exception{
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

	    List<PatientVisit> p = patientvisits.stream().filter(pv -> pv.DateOfSubmission().equals(d)).collect(Collectors.toList());
		return Optional.ofNullable(p);
		
	}
	
	
	public Optional<List<PatientVisit>> searchPatientVisitBypId(int pId) throws Exception{
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");
	    List<PatientVisit> p = patientvisits.stream().filter(pv -> pv.pId()==pId).collect(Collectors.toList());
		return Optional.ofNullable(p);
		
	}
	
	
	public Optional<List<PatientVisit>> searchPatientVisitBydrId(int drId) throws Exception{
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");
		List<PatientVisit> p = patientvisits.stream().filter(pv -> pv.drId()==drId).collect(Collectors.toList());
		return Optional.ofNullable(p);
		
	}
	
	
	public void removePatientVisitByPatientId(int ids) throws Exception {
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");
		patientvisits.removeIf(p -> p.pId() == ids);
    	ResourceManager.save((Serializable) patientvisits, "files\\patientrecords.ser");

	
	}
	
	
	public void viewVisits() throws Exception{
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

		patientvisits.forEach(System.out:: println);
	}
	
	
	public void viewVisitsBypId(int pId) throws Exception{
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

		Optional<List<PatientVisit>> p = searchPatientVisitBypId(pId);
		if(!p.isEmpty()) {
			System.out.println(p.toString());
			}else {
				p.get();
			}
	}
	
	
	public void viewVisitsBydrId(int drId) throws Exception{
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

		Optional<List<PatientVisit>> p = searchPatientVisitBydrId(drId);
		if(!p.isEmpty()) {
			System.out.println(p.toString());
			}else {
				p.get();
			}
	}
	
	
	public void viewVisitsBypId(int drId, PrintWriter out) throws Exception {
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

		Optional<List<PatientVisit>> p = searchPatientVisitBydrId(drId);
		if(!p.isEmpty()) {
			out.println(p.toString());
			}else {
				p.get();
			}
		
	}
	
	public void viewVisitsByDateOfSubmission(LocalDate dateOfSubmission) throws Exception{
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

		Optional<List<PatientVisit>> p = searchPatientVisitByDateOfSubmission(dateOfSubmission);
		if(!p.isEmpty()) {
			System.out.println(p.toString());
			}else {
				p.get();
			}
		}
	
	public void removePatientVisitsByVisitId(int vId) throws Exception {
    	patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");
		patientvisits.removeIf(pv -> pv.visitId() == vId);
    	ResourceManager.save((Serializable) patientvisits, "files\\patientrecords.ser");

			
		}


	public void viewVisitsByDateOfSubmission(LocalDate dateOfSubmission, PrintWriter out) throws Exception {
		patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

		Optional<List<PatientVisit>> p = searchPatientVisitByDateOfSubmission(dateOfSubmission);
		if(!p.isEmpty()) {
			out.println(p.toString());
			}else {
				p.get();
			}
		}


	public void viewVisits(PrintWriter out) throws Exception {
		patientvisits=(List<PatientVisit> ) ResourceManager.load("files//patientvisits.ser");

		patientvisits.forEach(out:: println);		
	}		
	
	
	
	}





	
