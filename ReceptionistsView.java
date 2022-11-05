package login_package;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import creating_views.Gender;
import creating_views.PatientRecord;
import creating_views.PatientRecords;
import creating_views.PatientVisits;
import creating_views.ResourceManager;

 class ReceptionistsView {
	
	private PatientRecords pr = new PatientRecords(Lists.patientList);
	private PatientVisits pv = new PatientVisits(Lists.pvList);
	private LocalDate d = LocalDate.now();
	private Scanner in = new Scanner(System.in);
	
	
	
	protected ReceptionistsView(String userName, String Password) throws Exception  {
		
		
		while(true) {
			System.out.println("enter the values that are dedicated to the :" +
			"-------operations that you want---------- " + 
			"-------Enter 1 to add patient Record -------"+
			"-------Enter 2 to view patient Records without their visits details-------"+
			"-------Enter 3 to view patient visits by their patientId-------" +
			"-------Enter 4 to view visits by their dr Id-------"+
			"-------Enter 5 to view Patient Visits by their Date of submission-------"+
			"-------Enter 6 to search patient record by name-------"+
			"-------Enter 7 to return all patients names-------"+
			"-------Enter 8 to remove patient Record by Id-------"+
			"-------------------------------------------------------------------------"+
			"if you want to exit this program please enter 0:");
			
			String options = in.next();
			
			switch(options){
				
			case "1" :
				this.addPatient();
				break;
			
			case "2" :
				pr.viewRecords();
				break;
			
			case "3":
			
				pv.viewVisitsBypId(enterId());
				break;
				
			case "4":
				
				pv.viewVisitsBydrId(enterId());;
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
				int id = enterId();
				if(pr.isThePatientExistById(id)) {
				pr.removePatientRecordById(id);
				pv.removePatientVisitByPatientId(id);
				}else{
				System.err.println("this patient doesn't exist");
				break;
					 }
				break;
			
			case "0":
				System.exit(0);
				break;
			
			default:
				System.out.println("please enter a valid option.");
			}
			
		}
		
	}
	
	public void addPatient() throws Exception {
		
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
		
//		patientRecord.add(new PatientRecord(name, surName, gender, DOB, phoneNum, patientId, drId, age));
		pr.addPatientRecord(name, surName, gender, DOB, phoneNum, patientId, drId, age);
		ResourceManager.save(pr, "PatientRecords.ser");
		
	}
	public void viewPatientData() throws Exception {
		
		PatientRecords pr = (PatientRecords) ResourceManager.load("C:\\Users\\96478\\eclipse-workspace\\applications2\\patientrecords.ser");
		pr.viewRecords();
		
	}
	
	
	
	public int enterId() {
		System.out.println("enter the id that you wanna perform an operation on it: ");
		int ids = in.nextInt();
		return ids;
	}
	
	
	

	
}
