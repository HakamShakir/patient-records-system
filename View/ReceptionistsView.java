package login_package;
import login_package.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	
	
	protected ReceptionistsView(String userName, String Password,PrintWriter out,BufferedReader in) throws Exception  {
		
		
		while(true) {
			out.println("enter the values that are dedicated to the :  \n" +
			"-------operations that you want----------  \n" + 
			"-------Enter 1 to add patient Record -------\n"+
			"-------Enter 2 to view patient Records without their visits details-------  \n"+
			"-------Enter 3 to view patient visits by their patientId-------  \n" +
			"-------Enter 4 to view visits by their dr Id-------  \n"+
			"-------Enter 5 to view Patient Visits by their Date of submission-------  \n"+
			"-------Enter 6 to search patient record by name-------  \n"+
			"-------Enter 7 to return all patients names-------  \n"+
			"-------Enter 8 to remove patient Record by Id-------  \n"+
			"-------------------------------------------------------------------------  \n"+
			"if you want to exit this program please enter 0:  \n");
			out.println("###");
			String options = in.readLine();
			
			switch(options){
				
			case "1" :
				this.addPatient(out,in);
				break;
			
			case "2" :
				pr.viewRecords(out);
				break;
			
			case "3":
			
				pv.viewVisitsBypId(enterId(out,in));
				break;
				
			case "4":
				
				pv.viewVisitsBydrId(enterId(out,in));;
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
				System.out.println("Enter the patient's name :");
				out.println("###");
				String pName = in.readLine();
				Optional<List<PatientRecord>> searchPatientByName = pr.searchPatientRecordByName(pName);
				pr.printSearching(searchPatientByName,out);
				break;
			
			case "7":
				pr.getPatientNames().forEach(out :: println);
				break;
			
			case "8":
				int id = enterId(out,in);
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
				out.println("please enter a valid option.");
			}
			
		}
		
	}
	
	public void addPatient(PrintWriter out,BufferedReader in) throws Exception {
		
		out.println("enter the patient info's");
		
		out.println("enter the patient Id:");
		out.println("###");
		int patientId =Integer.parseInt(in.readLine());
		
		out.println("name: " );
		out.println("###");
		String name = in.readLine();
		
		out.println("surName: ");
		out.println("###");
		String surName = in.readLine();
		 
	    out.println("DR ID: ");
		out.println("###");
	    int drId = Integer.parseInt(in.readLine());
	
	    out.println("phone Number:");
		out.println("###");
	    String phoneNum = in.readLine();
	    
	    out.println("enter DOB in M/d/yyyy format: ");
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		out.println("###");
	    String userInput = in.readLine();
		LocalDate DOB = LocalDate.parse(userInput , dateFormat);
		
		out.println("enter gender:");
		out.println("###");
		String g = in.readLine();
		Gender gender = Gender.valueOf(g.toUpperCase());
		
		int age = d.getYear()-DOB.getYear();
		
		pr.addPatientRecord(name, surName, gender, DOB, phoneNum, patientId, drId, age);
		
	}
	public void viewPatientData() throws Exception {
		
		PatientRecords pr = (PatientRecords) ResourceManager.load("C:\\Users\\96478\\eclipse-workspace\\applications2\\patientrecords.ser");
		pr.viewRecords();
		
	}
	
	
	
	public int enterId(PrintWriter out,BufferedReader in) throws NumberFormatException, IOException {
		out.println("enter the id that you wanna perform an operation on it: ");
		out.println("###");
		int ids = Integer.parseInt(in.readLine());
		return ids;
	}
	
	
	
//	public void deletePatientsDataById() throws Exception {
//		PatientRecords pr = (PatientRecords) ResourceManager.load("C:\\Users\\96478\\eclipse-workspace\\applications2\\patientrecords.ser");
//		pr.removePatientRecordById(ids);
//	}
	
}
