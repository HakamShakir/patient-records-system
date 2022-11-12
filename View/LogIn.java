package login_package;

import java.util.Scanner;

public class LogIn {
	static Scanner in = new Scanner(System.in);
	
	public static void receptionistLogin() throws Exception {
		
		System.out.println("please enter your user name :");
		String userName = in.next();
		
		System.out.println("please enter your password :");
		String password = in.next();
		if(Lists.receptionistList.stream().anyMatch(r -> (r.getUsername()).equals(userName))&&
		   Lists.receptionistList.stream().anyMatch(r -> (r.getPassword()).equals(password))) {
		   new ReceptionistsView(userName, password);
			
		}else {
			System.out.println("the receptionist is not valid");
			System.exit(0);
		}
	}
	public static void DrsLogin() throws Exception {
		
		System.out.println("please enter your user name :");
		String userName = in.next();
		
		System.out.println("please enter your password :");
		String password = in.next();
		if(Lists.drList.stream().anyMatch(d -> (d.getUsername()).equals(userName))&&
		   Lists.drList.stream().anyMatch(d -> (d.getPassword()).equals(password))) {
		new DoctorsView(userName, password);
		
		}else {
			System.out.println("the doctor is not valid");
			System.exit(0);
		}
		}
		public static void HospitalManagementsView() throws Exception {
		
		System.out.println("please enter your user name :");
		String userName1 = in.next();
		
		System.out.println("please enter your password :");
		String password1 = in.next();
		if(Lists.hList.stream().anyMatch(h -> (h.getUsername()).equals(userName1))&&
		   Lists.hList.stream().anyMatch(h -> (h.getPassword()).equals(password1))) {
		new HospitalManagementsView(userName1, password1);
		}else {
			System.out.println("the manager is not valid");
			System.exit(0);
		}
		}
		
	
	
}
