package creating_views;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import login_package.Lists;
import login_package.LogIn;


public class Main {

	public static void main(String [] args) throws Exception {
		
		LocalDate a = LocalDate.now();
	//making a list of drs then saving/loading it
	/*	List<Doctor> drs = new ArrayList<>();
		drs.add (new Doctor("hasansabah","password","hasan salah","07501234567",Gender.MALE, Position.DENTIST,48,1,1600,20,"maxillofacial surgeon"));
		drs.add (new Doctor("alansalam","password","alan salam","07501234567",Gender.MALE, Position.INTERN,48,2,1600,20,"none"));
		drs.add (new Doctor("yarabdullah","password","yar abdullah","07501234567",Gender.FEMALE, Position.PHARMACIST,48,3,1600,20,"PHARMACIST"));
		ResourceManager.save((Serializable) drs, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\Doctorslist.ser"); */
		List<Doctor> doctors1 = (List<Doctor>) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\Doctorslist.ser");
		Lists.drList.addAll(doctors1);
		
	//making a list of Receptionists then saving/loading it
	/*	List<Receptionist> receptionistlist = new ArrayList<>();
		receptionistlist.add (new Receptionist("Alisadiq", "password", "ali sadiq", "07501234567", Gender.MALE,20, 4, 500));
		receptionistlist.add (new Receptionist("midyamohammed", "password", "midya mohammed", "07501234567", Gender.FEMALE, 23, 5, 700));
		ResourceManager.save((Serializable) receptionistlist, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\Receptionistslist.ser"); */
		List<Receptionist> receptionists1=(List<Receptionist>) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\Receptionistslist.ser");
		Lists.receptionistList.addAll(receptionists1);
		
	//making a list of patient records then saving/loading it
	/*	List<PatientRecord> patientrecordlist = new ArrayList<>();
		patientrecordlist.add(new PatientRecord("hakam", "iqdam", Gender.MALE, a, "07501234567", 6, 1,8));
		patientrecordlist.add (new PatientRecord("shakar", "kosar", Gender.MALE, a, "07501234567", 7, 1,7));
		patientrecordlist.add (new PatientRecord("lawand", "shero", Gender.FEMALE, a, "07501234567", 8, 2,9));
		patientrecordlist.add (new PatientRecord("shwan", "shakr", Gender.MALE, a, "07501234567", 9, 2,8));
		ResourceManager.save((Serializable) patientrecordlist, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\patientrecords.ser");*/
		List<PatientRecord> patientrecords1 =  (List<PatientRecord>) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\patientrecords.ser");	
		Lists.patientList.addAll(patientrecords1);
		
	//making a list of patient visits then saving/loading it
	/*	List<PatientVisit> patienvisitlist = new ArrayList<>();
		patienvisitlist.add (new PatientVisit(6, 1,1, "headache", "diabetic", "insulin shot", null, a, "3days", 25));
		patienvisitlist.add (new PatientVisit(7, 1,2, "abdominal pain", "asthema", "paracetamol", null, a, "4days", 25));
		patienvisitlist.add (new PatientVisit(8, 2,3, "cough", "seizures", "paracetamol", null, a, "a week", 25));
		patienvisitlist.add (new PatientVisit(9, 2,4, "fever", "depression", "paracetamol", null, a, "a week", 25));
		patienvisitlist.add (new PatientVisit(9, 2,5, "numbness", "anemia", "paracetamol", null, a, "3days", 25));
		ResourceManager.save((Serializable) patienvisitlist, "C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\patientvisits.ser"); */
		List<PatientVisit>  patientvisits1 =  (List<PatientVisit> ) ResourceManager.load("C:\\Users\\ASUS\\eclipse-workspace\\SystemForPatients\\src\\files\\patientvisits.ser");
		Lists.pvList.addAll(patientvisits1); 
		
	//management
		HospitalManagement s = new HospitalManagement("dlvin","foxyfoxy1","dlo","0751762847", Gender.FEMALE, 20, 1234576, 2000);
		Lists.hList.add(s);
		
		LogIn.HospitalManagementsView();
		
}
}
