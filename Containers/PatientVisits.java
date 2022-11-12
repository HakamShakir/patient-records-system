package creating_views;

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
	
	//private Scanner in = new Scanner(System.in);

	
	
    
	public PatientVisits(List<PatientVisit> pv) {
        this.patientvisits = pv;
    }
	
    
    public void addPatientVisit(int pId,int drId ,String chiefComplaint, String history, String treatement, String recommendation,LocalDate DateOfSubmission ,String duration, double price ,int visitId) throws Exception  {
    	
    	patientvisits.add(new PatientVisit( pId,  drId,visitId, chiefComplaint,  history,  treatement ,recommendation,DateOfSubmission,duration,price));
    }
    
	
	//public void enterId() {
		//System.out.println("enter the id that you wanna perform an operation on it: ");
		//ids = in.nextInt();
	//}


   /* void addpatientVisit()  {
    	enterId();
    	int pId=ids;
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
		
		System.out.println("enter Date Of Submission in M/d/yyyy format: ");
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    String userInput = in.next();
		LocalDate DateOfSubmission = LocalDate.parse(userInput , dateFormat);
		
		System.out.println("enter the price: ");
		double price = in.nextDouble();
		
		patientvisits.add(new PatientVisit(pId,drId, chiefComplaint, history, vitals, investigation, treatments, recommendation, DateOfSubmission, duration, price));
    }*/
	
	
    public Optional<List<PatientVisit>> searchPatientVisitByDateOfSubmission(LocalDate d){
	    List<PatientVisit> p = patientvisits.stream().filter(pv -> pv.DateOfSubmission().equals(d)).collect(Collectors.toList());
		return Optional.ofNullable(p);
		
	}
	
	
	public Optional<List<PatientVisit>> searchPatientVisitBypId(int pId){
	    List<PatientVisit> p = patientvisits.stream().filter(pv -> pv.pId()==pId).collect(Collectors.toList());
		return Optional.ofNullable(p);
		
	}
	
	
	public Optional<List<PatientVisit>> searchPatientVisitBydrId(int drId){
		
		List<PatientVisit> p = patientvisits.stream().filter(pv -> pv.drId()==drId).collect(Collectors.toList());
		return Optional.ofNullable(p);
		
	}
	
	
	public void removePatientVisitByPatientId(int ids) {
		//patientvisits.stream().filter(p -> (p.pId()) == ids).collect(Collectors.toList()).removeAll(patientvisits);
		patientvisits.removeIf(p -> p.pId() == ids);
	
	
	}
	
//   public List<String> getPatientNames() {
//        List<String> PatientNames = new ArrayList<>();
//        patientrecords.forEach(p -> PatientNames.add(p.name()));
//        return PatientNames;
//   }
    
	
	public void viewVisits(){
		patientvisits.forEach(System.out:: println);
	}
	
	
	public void viewVisitsBypId(int pId){
		
		Optional<List<PatientVisit>> p = searchPatientVisitBypId(pId);
		if(!p.isEmpty()) {
			System.out.println(p.toString());
			}else {
				p.get();
			}
	}
	
	
	public void viewVisitsBydrId(int drId){
		Optional<List<PatientVisit>> p = searchPatientVisitBydrId(drId);
		if(!p.isEmpty()) {
			System.out.println(p.toString());
			}else {
				p.get();
			}
	}
	
	public void viewVisitsByDateOfSubmission(LocalDate dateOfSubmission){
		Optional<List<PatientVisit>> p = searchPatientVisitByDateOfSubmission(dateOfSubmission);
		if(!p.isEmpty()) {
			System.out.println(p.toString());
			}else {
				p.get();
			}}
	
	public void removePatientVisitsByVisitId(int vId) {
		
		patientvisits.removeIf(pv -> pv.visitId() == vId);
			
		}


	

}
