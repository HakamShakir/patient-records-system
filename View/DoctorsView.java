package login_package;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import creating_views.Doctor;
import creating_views.Gender;
import creating_views.PatientRecord;
import creating_views.PatientRecords;
import creating_views.PatientVisit;
import creating_views.PatientVisits;
import creating_views.ResourceManager;
class DoctorsView {
	
	private PatientRecords pr = new PatientRecords(Lists.patientList);
	private int patientId;
	private PatientVisits pv = new PatientVisits(Lists.pvList);

	private Scanner in = new Scanner(System.in);

	protected DoctorsView(String userName, String password) throws Exception{
		while(true) {
			System.out.println(
			"enter the values that are dedicated to the \n" +
			"-------operations that you want---------- \n" +
			"-------Enter 1 to add patient visit---------- \n"+
			"-------Enter 2 to view patient Records without their visits details------- \n"+
			"-------Enter 3 to view patient visits by their patientId------- \n"+
			"-------Enter 4 to view all your patients visits------- \n" +
			"-------Enter 5 to view Patient Visits by their Date of submission------- \n"+
			"-------Enter 6 to search patient record by name------- \n"+
			"-------Enter 7 to return all patients names------- \n"+
			"-------Enter 8 to delete patientRecord------- \n"+
			"-------Enter 9 to delete patient visit by visit Id------- \n"+
			"------------------------------------------------------------------------- \n"+
			"if you want to exit this program please enter 0: \n");
			
			String options = in.next();
			
			switch(options){
				
			case "1" :
				if(pr.isThePatientExistById(enterId())) {
				this.addPatientVisit();
				}else{
				System.err.println("this patient doesn't exist");
				break;
					 }
				break;
			
			case "2" :
				int drId = 0;
				for(int i = 0; i < Lists.drList.size(); i++) {
					Doctor d =Lists.drList.get(i);
					if((d.getUsername()).equals(userName)) {
					drId = d.getId();
					}
				}
				pr.searchPatientRecordBydrId(drId).stream().forEach(System.out :: println);
				
				break;
			
			
			case "3":
				pv.viewVisitsBypId(enterId());
				break;
				
			case "4":
				pv.viewVisitsBydrId(enterId());
				break;
			
			case "5":
				System.out.println("enter date of submission in M/d/yyyy format: ");
			    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
			    String userInput = in.next();
				LocalDate dateOfSubmission = LocalDate.parse(userInput , dateFormat);
				pv.viewVisitsByDateOfSubmission(dateOfSubmission);
				break;
			
			case "6" :
				System.out.println("Enter the patient's name :");
				String pName = in.next();
				Optional<List<PatientRecord>> searchPatientByName = pr.searchPatientRecordByName(pName);
				pr.printSearching(searchPatientByName);
				break;
			
			case "7":
				pr.getPatientNames().forEach(System.out :: println);
				break;
			
			case "8":
				
				int pId = enterId();
				if(pr.isThePatientExistById(pId)) {
				pr.removePatientRecordById(pId);
				pv.removePatientVisitByPatientId(pId);
				}else{
				System.err.println("this patient doesn't exist");
				break;
					 }
				break;
			
			case "9":
				
				pv.removePatientVisitsByVisitId(enterId());
				break;
				
			case "0":
				System.exit(0);
				break;
				
			default:
				System.out.println("please enter a valid option.");
			}
			
		}
	}
	
	

	public void addPatientVisit() throws Exception{
		
		System.out.println("enter the patient Id:");
		 patientId = in.nextInt();
		
		System.out.println();
		int visitId = in.nextInt();
		
		System.out.println("enter drId ID:");
		int drId = in.nextInt();
		
		System.out.println("enter cheif complaint: ");
		String chiefComplaint = in.next();
		
		System.out.println("enter history of the patient: ");
		String history = in.next();
		
		System.out.println("enter date of submission in M/d/yyyy format: ");
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    String userInput = in.next();
		LocalDate dateOfSubmission = LocalDate.parse(userInput , dateFormat);
		
		System.out.println("enter treatments: ");
		String treatements = in.next();
		
		System.out.println("enter recommendation: ");
		String recommendation = in.next();
		
		System.out.println("enter duration: ");
		String duration = in.next();
		
		System.out.println("enter the price: ");
		double price = in.nextDouble();
		
		pv.addPatientVisit(patientId, drId , chiefComplaint, history, treatements, recommendation, dateOfSubmission, duration, price,visitId );
		}

	public int enterId() {
		System.out.println("enter the id that you wanna perform an operation on it: ");
		int ids = in.nextInt();
		return ids;
		}
		
}
