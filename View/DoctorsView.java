package login_package;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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

	protected DoctorsView(String userName, String password,PrintWriter out,BufferedReader in) throws Exception{
		while(true) {
			out.println(
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
			out.println("###");
			String options = in.readLine();
			
			switch(options){
				
			case "1" :
				if(pr.isThePatientExistById(enterId(out,in))) {
				this.addPatientVisit(out,in);
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
				pr.searchPatientRecordBydrId(drId).stream().forEach(out :: println);
				
				break;
			
			
			case "3":
				pv.viewVisitsBypId(enterId( out,in),out);
				break;
				
			case "4":
				pv.viewVisits(out);
				break;
			
			case "5":
				out.println("enter date of submission in M/d/yyyy format: ");
			    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
				out.println("###");
			    String userInput = in.readLine();
				LocalDate dateOfSubmission = LocalDate.parse(userInput , dateFormat);
				pv.viewVisitsByDateOfSubmission(dateOfSubmission);
				break;
			
			case "6" :
				out.println("Enter the patient's name :");
				out.println("###");
				String pName = in.readLine();
				Optional<List<PatientRecord>> searchPatientByName = pr.searchPatientRecordByName(pName);
				pr.printSearching(searchPatientByName,out);
				break;
			
			case "7":
				pr.getPatientNames().forEach(out :: println);
				break;
			
			case "8":
				
				int pId = enterId(out,in);
				if(pr.isThePatientExistById(pId)) {
				pr.removePatientRecordById(pId);
				pv.removePatientVisitByPatientId(pId);
				}else{
				System.err.println("this patient doesn't exist");
				break;
					 }
				break;
			
			case "9":
				
				pv.removePatientVisitsByVisitId(enterId(out,in));
				break;
				
			case "0":
				System.exit(0);
				break;
				
			default:
				out.println("please enter a valid option.");
			}
			
		}
	}
	
	

	public void addPatientVisit(PrintWriter out, BufferedReader in) throws Exception{
		
		out.println("enter the patient Id:");
		out.println("###");
		patientId = Integer.parseInt(in.readLine());
		out.println();
		
		out.println("###");
		int visitId = Integer.parseInt(in.readLine());
		
		out.println("enter drId ID:");
		out.println("###");
		int drId = Integer.parseInt(in.readLine());
		
		out.println("enter cheif complaint: ");
		out.println("###");
		String chiefComplaint = in.readLine();
		
		out.println("enter history of the patient: ");
		out.println("###");
		String history = in.readLine();
		
		out.println("enter date of submission in M/d/yyyy format: ");
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    out.println("###");
	    String userInput = in.readLine();
		LocalDate dateOfSubmission = LocalDate.parse(userInput , dateFormat);
		
		out.println("enter treatments: ");
		out.println("###");
		String treatements = in.readLine();
		
		out.println("enter recommendation: ");
		out.println("###");
		String recommendation = in.readLine();
		
		out.println("enter duration: ");
		out.println("###");
		String duration = in.readLine();
		
		out.println("enter the price: ");
		out.println("###");
		double price = Double.parseDouble(in.readLine());
		
		pv.addPatientVisit(patientId, drId , chiefComplaint, history, treatements, recommendation, dateOfSubmission, duration, price,visitId );
		}

	public int enterId(PrintWriter out, BufferedReader in) throws NumberFormatException, IOException {
		out.println("enter the id that you wanna perform an operation on it: ");
		out.println("###");
		int ids = Integer.parseInt(in.readLine());
		return ids;
		}
		
}
