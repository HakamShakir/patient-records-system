package login_package;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

 class HospitalManagementsView {

	private PatientRecords pr = new PatientRecords(Lists.patientList);
	private Doctors drs = new Doctors(Lists.drList);
	private Receptionists r = new Receptionists(Lists.receptionistList);
	private PatientVisits pv = new PatientVisits(Lists.pvList);
	private Scanner in = new Scanner(System.in);
	

	
	protected HospitalManagementsView(String userName , String password) throws Exception {
		
		while(true) {
			System.out.println(
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
			
			String options = in.next();
			
			switch(options){
				
			
			case "1" :
				pr.viewRecords();
				break;
			
			case "2":
				pv.viewVisitsBypId(enterId());
				break;
				
			case "3":
				pv.viewVisits();
				break;
			
			case "4":
				System.out.println("enter date of submission in M/d/yyyy format: ");
			    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
			    String userInput = in.next();
				LocalDate dateOfSubmission = LocalDate.parse(userInput , dateFormat);
				pv.viewVisitsByDateOfSubmission(dateOfSubmission);
				break;
			
			case "5" :
				System.out.println("Enter the patient's name :");
				String pName = in.next();
				Optional<List<PatientRecord>> searchPatientByName = pr.searchPatientRecordByName(pName);
				pr.printSearching(searchPatientByName);
				break;
			
			case "6":
				pr.getPatientNames().forEach(System.out :: println);
				break;
			
			case "7":
				this.addDr();
				break;
			
			case "8":
				this.addReceptionist();
				break;
			
			case "9":
				r.printSearching(r.searchReceptionistByName(enterName()));
				break;
			
			case "10":
				r.removeReceptionistById(enterId());
			break;
			
			case "11":
				r.getReceptionistNames().forEach(System.out :: println);
			break;
			
			case "12":
				r.viewReceptionists();
			break;
			
			case "13":
			drs.printSearching(drs.searchDrByName(enterName()));
			break;
			
			case "14":
			drs.removeDrById(enterId());
			break;
			
			case "15":
			if(!drs.getDrNames().isEmpty()) {
				drs.getDrNames().forEach(System.out :: println);
			}else{
				System.out.println("no dr is entered yet.");
				break;
			};
			break;
			
			case "16":
				drs.viewDoctors();
			break;
			case "0":
				System.exit(0);
				break;
				
			default:
				System.out.println("please enter a valid option.");
			}
			
		}
		
	}
	
	public void addDr() throws Exception {
		System.out.println("enter the drs informations sequentely :");
		System.out.println("enter the userName:");
		String userName = in.next();
		
		System.out.println("enter the password:");
		String password = in.next();
		
		System.out.println("enter the name:");
		String name = in.next();
		
		System.out.println("enter the phone number:");
		String phoneno = in.next();
		
		System.out.println("enter gender:");
		String g = in.next();
		Gender gender = Gender.valueOf(g.toUpperCase());
		
		System.out.println("enter gender:");
		String p = in.next();
		Position position = Position.valueOf(p.toUpperCase());
		
		System.out.println(" enter DR's age: ");
		int age = in.nextInt();
		
		System.out.println(" enter DR ID: ");
		int id = in.nextInt();
		
		System.out.println(" enter salary: ");
		int salary = in.nextInt();
		
		System.out.println(" enter years of experience: ");
		int yearsOfExperience = in.nextInt();
		
		System.out.println("enter the speciality:");
		String speciality = in.next();
		
		drs.addDr(userName, password, name, phoneno, gender, position, age, id, salary, yearsOfExperience, speciality);
	
	}
	public void addReceptionist() throws Exception {
		
		System.out.println("enter the drs informations sequentely :");
		System.out.println("enter the userName:");
		String userName = in.next();
		
		System.out.println("enter the password:");
		String password = in.next();
		
		System.out.println("enter the name:");
		String name = in.next();
		
		System.out.println("enter the phone number:");
		String phoneno = in.next();
		
		System.out.println("enter gender:");
		String g = in.next();
		Gender gender = Gender.valueOf(g.toUpperCase());
		
		System.out.println(" enter DR's age: ");
		int age = in.nextInt();
		
		System.out.println(" enter DR ID: ");
		int id = in.nextInt();
		
		System.out.println(" enter salary: ");
		int salary = in.nextInt();
		
		r.addReceptionist(userName , password , name, phoneno , gender , age , id , salary);
	
	}
	
	public int enterId() {
		System.out.println("enter the id that you wanna perform an operation on it: ");
		int ids = in.nextInt();
		return ids;
		}
	
	public String enterName() {
		System.out.println("enter the name :");
		String name = in.next();
		return name;
	}
	
}
