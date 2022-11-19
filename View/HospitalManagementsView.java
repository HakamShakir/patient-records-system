package View;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import creating_views.Doctors;
import creating_views.Gender;
import creating_views.PatientRecord;
import creating_views.PatientRecords;
import creating_views.PatientVisits;
import creating_views.Position;
import creating_views.Receptionists;
import creating_views.ResourceManager;

 class HospitalManagementsView {

	private PatientRecords pr = new PatientRecords(Lists.patientList);
	private Doctors drs = new Doctors(Lists.drList);
	private Receptionists r = new Receptionists(Lists.receptionistList);
	private PatientVisits pv = new PatientVisits(Lists.pvList);
	private Scanner in = new Scanner(System.in);
	
	
	protected HospitalManagementsView(String userName , String password,PrintWriter out,BufferedReader in) throws Exception {
		
		while(true) {
			out.println(
			"enter the values that are dedicated to the \n" +
			"-------operations that you want---------- \n" +
			"-------Enter 1 to view patient Records without their visits details------- \n"+
			"-------Enter 2 to view patient visits by their patientId------- \n"+
			"-------Enter 3 to view all the patients visits------- \n" +
			"-------Enter 4 to view Patient Visits by their Date of submission------- \n"+
			"-------Enter 5 to search patient record by name------- \n"+
			"-------Enter 6 to return all patients names------- \n"+
			"-------Enter 7 to add Dr info------- \n"+
			"-------Enter 8 to add Receptionist info------- \n"+
			"-------Enter 8 to add Receptionist info------- \n"+
			"-------Enter 9 to search Receptionist by name------- \n"+
			"-------Enter 10 to remove Receptionist by id------- \n"+
			"-------Enter 11 to get only receptionists names------- \n"+
			"-------Enter 12 to view all receptionists datas------- \n"+
			"-------Enter 13 to search Drs by name------- \n"+
			"-------Enter 14 to remove dr by Id------- \n"+
			"-------Enter 15 to view only drs names------- \n"+
			"-------Enter 16 to view all drs datas------- \n"+
			"------------------------------------------------------------------------- \n"+
			"if you want to exit this program please enter 0: \n");
			
			out.println("###");
			String options = in.readLine();
	
			switch(options){
				
			
			case "1" :
				
				pr.viewRecords(out);
				break;
			
			case "2":
				out.println("enter the id that you wanna perform an operation on it: ");
				out.println("###");
				int ids = Integer.parseInt(in.readLine());
				pv.viewVisitsBypId(ids, out);
				break;
				
			case "3":
				pv.viewVisits(out);
				break;
			
			case "4":
				out.println("enter date of submission in M/d/yyyy format: ");
			    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
				out.println("###");
			    String userInput = in.readLine();
				LocalDate dateOfSubmission = LocalDate.parse(userInput , dateFormat);
				pv.viewVisitsByDateOfSubmission(dateOfSubmission,out);
				break;
			
			case "5" :
				out.println("Enter the patient's name :");
				out.println("###");
				String pName = in.readLine();
				Optional<List<PatientRecord>> searchPatientByName = pr.searchPatientRecordByName(pName);
				pr.printSearching(searchPatientByName,out);
				break;
			
			case "6":
				pr.getPatientNames().forEach(out :: println);
				break;
			
			case "7":
				out.println("enter the drs informations sequentely :");
				out.println("enter the userName:");
				out.println("###");
				String userName1 = in.readLine();
				
				System.out.println("enter the password:");
				out.println("###");
				String password1 = in.readLine();
				
				System.out.println("enter the name:");
				out.println("###");
				String name = in.readLine();
				
				System.out.println("enter the phone number:");
				out.println("###");
				String phoneno = in.readLine();
				
				System.out.println("enter gender:");
				out.println("###");
				String g = in.readLine();
				Gender gender = Gender.valueOf(g.toUpperCase());
				
				
				System.out.println("enter position:");
				out.println("###");
				String p = in.readLine();
				Position position = Position.valueOf(p.toUpperCase());
				
				System.out.println(" enter DR's age: ");
				out.println("###");
				int age = Integer.parseInt(in.readLine());
				
				System.out.println(" enter DR ID: ");
				out.println("###");
				int id = Integer.parseInt(in.readLine());
				
				System.out.println(" enter salary: ");
				out.println("###");
				int salary = Integer.parseInt(in.readLine());
				
				System.out.println(" enter years of experience: ");
				out.println("###");
				int yearsOfExperience = Integer.parseInt(in.readLine());
				
				System.out.println("enter the speciality:");
				out.println("###");
				String speciality = in.readLine();
				
				drs.addDr(userName1, password1, name, phoneno, gender, position, age, id, salary, yearsOfExperience, speciality);
				break;
			
			case "8":
				out.println("enter the receptionist informations sequentely :");
				out.println("enter the userName:");
				out.println("###");
				String userNameR = in.readLine();
				
				out.println("enter the password:");
				out.println("###");
				String passwordR = in.readLine();
				
				out.println("enter the name:");
				out.println("###");
				String nameR = in.readLine();
				
				out.println("enter the phone number:");
				out.println("###");
				String phonenoR = in.readLine();
				
				out.println("enter gender:");
				out.println("###");
				String gR = in.readLine();
				Gender genderR = Gender.valueOf(gR.toUpperCase());
				
				out.println(" enter receptionist's age: ");
				out.println("###");
				int ageR = Integer.parseInt(in.readLine());
				
				out.println(" enter receptionist's ID: ");
				out.println("###");
				int idR = Integer.parseInt(in.readLine());
				
				out.println(" enter salary: ");
				out.println("###");
				int salaryR = Integer.parseInt(in.readLine());
				
				r.addReceptionist(userNameR , passwordR , nameR, phonenoR , genderR , ageR , idR, salaryR);
				break;
			
			case "9":
				out.println("enter the name :");
				out.println("###");
				String namesearchR = in.readLine();
				r.printSearching(r.searchReceptionistByName(namesearchR));
				break;
			
			case "10":
				out.println("enter the id that you wanna perform an operation on it: ");
				out.println("###");
				int ids1 = Integer.parseInt(in.readLine());
				r.removeReceptionistById(ids1);
			break;
			
			case "11":
				
				r.getReceptionistNames().forEach(out :: println);
			break;
			
			case "12":
				r.viewReceptionists();
			break;
			
			case "13":
				out.println("enter the name :");
				out.println("###");
				String namesearch = in.readLine();
				drs.printSearching(drs.searchDrByName(namesearch));
			break;
			
			case "14":
			out.println("enter the id that you wanna perform an operation on it: ");
			out.println("###");
			int ids2 = Integer.parseInt(in.readLine());
			drs.removeDrById(ids2);
			break;
			
			case "15":
			if(!drs.getDrNames().isEmpty()) {
				drs.getDrNames().forEach(out :: println);
			}else{
				out.println("no dr is entered yet.");
				break;
			};
			break;
			
			case "16":
				drs.viewDoctors(out);
			break;
			case "0":
				System.exit(0);
				break;
				
			default:
				out.println("please enter a valid option.");
			}
			
		}
		
	}
	


	


	
}
