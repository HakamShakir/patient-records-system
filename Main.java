package SystemForPatients;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String [] args) throws Exception {
		
		//testing on one object
		Doctor dr2 = new Doctor("hasansabah","password","hasan salah","07501234567",Gender.MALE, Position.DENTIST,48,1,1600,20,"maxillofacial surgeon");
		LocalDate a=LocalDate.now();
		PatientRecord alan =new PatientRecord("alan","salam",Gender.MALE,a,"aaaa",2, 0);
		Doctor dr1 = (Doctor) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\Doctor1.ser");
		Doctor dr3=(Doctor) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\Doctor.ser");
		System.out.println(dr1);
		System.out.println(dr3);
		System.out.println(alan);
		System.out.println(dr2);
		
		
		//making a list of drs then saving/loading it
		List<Doctor> drs = new ArrayList<>();
		Doctors doctors = new Doctors(drs);
		doctors.addDr("hasansabah","password","hasan salah","07501234567",Gender.MALE, Position.DENTIST,48,1,1600,20,"maxillofacial surgeon");
		doctors.addDr("alansalam","password","alan salam","07501234567",Gender.MALE, Position.INTERN,48,2,1600,20,"none");
		doctors.addDr("yarabdullah","password","yar abdullah","07501234567",Gender.FEMALE, Position.PHARMACIST,48,3,1600,20,"PHARMACIST");
		doctors.viewDoctors();
		ResourceManager.save(doctors, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\Doctorslist.ser");
		Doctors doctors1=(Doctors) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\Doctorslist.ser");
		doctors1.viewDoctors();
		
		//making a list of Receptionists then saving/loading it
		List<Receptionist> receptionistlist = new ArrayList<>();
		Receptionists receptionists = new Receptionists(receptionistlist);
		receptionists.addReceptionist("Alisadiq", "password", "ali sadiq", "07501234567", Gender.MALE,null, 20, 4, 500);
		receptionists.addReceptionist("midyamohammed", "password", "midya mohammed", "07501234567", Gender.FEMALE,null, 23, 5, 700);
		receptionists.viewReceptionists();
		ResourceManager.save(receptionists, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\Receptionistslist.ser");
		Receptionists receptionists1=(Receptionists) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\Receptionistslist.ser");
		receptionists1.viewReceptionists();
		
		//making a list of patient records then saving/loading it
		List<PatientRecord> patientrecordlist = new ArrayList<>();
		PatientRecords patientrecords = new PatientRecords(patientrecordlist);
		patientrecords.addPatientRecord("hakam", "iqdam", Gender.MALE, a, "07501234567", 6, 1);
		patientrecords.addPatientRecord("shakar", "kosar", Gender.MALE, a, "07501234567", 7, 1);
		patientrecords.addPatientRecord("lawand", "shero", Gender.FEMALE, a, "07501234567", 8, 2);
		patientrecords.addPatientRecord("shwan", "shakr", Gender.MALE, a, "07501234567", 9, 2);
		patientrecords.viewRecords();
		ResourceManager.save(patientrecords, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\patientrecords.ser");
		PatientRecords patientrecords1=(PatientRecords) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\patientrecords.ser");
		patientrecords1.viewRecords();
		
		//making a list of patient visits then saving/loading it
		List<PatientVisit> patienvisitlist = new ArrayList<>();
		PatientVisits patientvisits = new PatientVisits(patienvisitlist);
		patientvisits.addPatientVisit(6, 1, "headache", "diabetic", "insulin shot", null, a, "3days", 25);
		patientvisits.addPatientVisit(7, 1, "abdominal pain", "asthema", "paracetamol", null, a, "4days", 25);
		patientvisits.addPatientVisit(8, 2, "cough", "seizures", "paracetamol", null, a, "a week", 25);
		patientvisits.addPatientVisit(9, 2, "fever", "depression", "paracetamol", null, a, "a week", 25);
		patientvisits.addPatientVisit(9, 2, "numbness", "anemia", "paracetamol", null, a, "3days", 25);
		patientvisits.viewVisits();
		ResourceManager.save(patientvisits, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\patientvisits.ser");
		PatientVisits patientvisits1=(PatientVisits) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\SystemForPatients\\files\\patientvisits.ser");
		patientvisits1.viewVisits();
		
		
	}
}
