package creating_views;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import login_package.Lists;
import login_package.LogIn;


public class Main {

	public static void main(String [] args) throws Exception {
		LocalDate a = LocalDate.now();
		//testing on one object
		Doctor dr2 = new Doctor("hasansabah","password","hasan salah","07501234567",Gender.MALE, Position.DENTIST,48,1,1600,20,"maxillofacial surgeon");
		LocalDate a1 = LocalDate.now();
		PatientRecord alan =new PatientRecord("alan","salam",Gender.MALE,a1,"aaaa",2, 0, 0);
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
		
		ResourceManager.save(doctors, "Doctorslist.ser");
		Doctors doctors1 = (Doctors) ResourceManager.load("C:\\Users\\96478\\eclipse-workspace\\applications2\\Doctorslist.ser");
		System.out.println(doctors1.searchDrByName("hasan salah"));
		
		//making a list of Receptionists then saving/loading it
		List<Receptionist> receptionistlist = new ArrayList<>();
		Receptionists receptionists = new Receptionists(receptionistlist);
		receptionists.addReceptionist("Alisadiq", "password", "ali sadiq", "07501234567", Gender.MALE, 20, 4, 500);
		receptionists.addReceptionist("midyamohammed", "password", "midya mohammed", "07501234567", Gender.FEMALE, 23, 5, 700);
		receptionists.viewReceptionists();
		ResourceManager.save(receptionists, "Receptionistslist.ser");
		Receptionists receptionists1=(Receptionists) ResourceManager.load("C:\\Users\\96478\\eclipse-workspace\\applications2\\Receptionistslist.ser");
		receptionists1.viewReceptionists();
		
		//making a list of patient records then saving/loading it
		List<PatientRecord> patientrecordlist = new ArrayList<>();
		PatientRecords patientrecords = new PatientRecords(patientrecordlist);
		patientrecords.addPatientRecord("hakam", "iqdam", Gender.MALE, a1, "07501234567", 6, 1,8);
		patientrecords.addPatientRecord("shakar", "kosar", Gender.MALE, a1, "07501234567", 7, 1,7);
		patientrecords.addPatientRecord("lawand", "shero", Gender.FEMALE, a1, "07501234567", 8, 2,9);
		patientrecords.addPatientRecord("shwan", "shakr", Gender.MALE, a1, "07501234567", 9, 2,8);
		
		ResourceManager.save(patientrecords, "patientrecords.ser");
		PatientRecords patientrecords1 = (PatientRecords) ResourceManager.load("C:\\Users\\96478\\eclipse-workspace\\applications2\\patientrecords.ser");
		patientrecords1.viewRecords();
		System.out.println(patientrecords1.isThePatientExistById(19));
		
		//making a list of patient visits then saving/loading it
		List<PatientVisit> patienvisitlist = new ArrayList<>();
		PatientVisits patientvisits = new PatientVisits(patienvisitlist);
		patientvisits.addPatientVisit(6, 1, "headache", "diabetic", "insulin shot", null, a1, "3days", 25, 0);
		patientvisits.addPatientVisit(7, 1, "abdominal pain", "asthema", "paracetamol", null, a1, "4days", 25, 0);
		patientvisits.addPatientVisit(8, 2, "cough", "seizures", "paracetamol", null, a1, "a week", 25, 0);
		patientvisits.addPatientVisit(9, 2, "fever", "depression", "paracetamol", null, a1, "a week", 25, 0);
		patientvisits.addPatientVisit(9, 2, "numbness", "anemia", "paracetamol", null, a1, "3days", 25, 0);
		
		
		ResourceManager.save(patientvisits, "patientvisits.ser");
		PatientVisits patientvisits1 = (PatientVisits) ResourceManager.load("C:\\Users\\96478\\eclipse-workspace\\applications2\\patientvisits.ser");
		
		patientvisits.removePatientVisitByPatientId(9);
		
		patientvisits1.viewVisits();
		HospitalManagement s = new HospitalManagement("dlvin","foxyfoxy1","dlo","0751762847", Gender.FEMALE, 20, 1234576, 2000);
		Lists.hList.add(s);
		LogIn.HospitalManagementsView();
}
}