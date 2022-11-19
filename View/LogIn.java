package login_package;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import creating_views.Doctor;
import creating_views.Gender;
import creating_views.HospitalManagement;
import creating_views.PatientRecord;
import creating_views.PatientVisit;
import creating_views.Receptionist;
import creating_views.ResourceManager;

public class LogIn {
	static Scanner in = new Scanner(System.in);
	
	
	
	
	public static void receptionistLogin(PrintWriter out,BufferedReader in) throws Exception {
		List<Receptionist> receptionists1=(List<Receptionist>) ResourceManager.load("files\\Receptionistslist.ser");
		Lists.receptionistList.addAll(receptionists1);

		out.println("please enter your user name :");
		out.println("###");
		String userName = in.readLine();
		
		out.println("please enter your password :");
		out.println("###");
		String password = in.readLine();
		if(Lists.receptionistList.stream().anyMatch(r -> (r.getUsername()).equals(userName))&&
		   Lists.receptionistList.stream().anyMatch(r -> (r.getPassword()).equals(password))) {
		   new ReceptionistsView(userName, password,out,in);
			
		}else {
			out.println("the receptionist is not valid");
			System.exit(0);
		}
	}
	public static void DrsLogin(PrintWriter out,BufferedReader in) throws Exception {
		List<Doctor> doctors1 = (List<Doctor>) ResourceManager.load("files\\Doctorslist.ser");
		Lists.drList.addAll(doctors1);
		
		out.println("please enter your user name :");
		out.println("###");
		String userName = in.readLine();
		
		out.println("please enter your password :");
		out.println("###");
		String password = in.readLine();
		if(Lists.drList.stream().anyMatch(d -> (d.getUsername()).equals(userName))&&
		   Lists.drList.stream().anyMatch(d -> (d.getPassword()).equals(password))) {
		new DoctorsView(userName, password,out,in);
		
		}else {
			System.out.println("the doctor is not valid");
			System.exit(0);
		}
		}
		public static void HospitalManagementsView(PrintWriter out,BufferedReader in) throws Exception {
		HospitalManagement s = new HospitalManagement("dlvin","1","dlo","0751762847", Gender.FEMALE, 20, 1234576, 2000);
		Lists.hList.add(s);
	
		out.println("please enter your user name :");
		out.println("###");
		String userName1 = in.readLine();
		
		out.println("please enter your password :");
		out.println("###");
		String password1 = in.readLine();
		if(Lists.hList.stream().anyMatch(h -> (h.getUsername()).equals(userName1))&&
		   Lists.hList.stream().anyMatch(h -> (h.getPassword()).equals(password1))) {
		new HospitalManagementsView(userName1, password1,out,in);
		}else {
			out.println("the manager is not valid");
			System.exit(0);
		}
		}
		
	
	
}
