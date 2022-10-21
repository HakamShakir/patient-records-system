package updated_system;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HospitalManagement extends User{

	private Scanner in = new Scanner(System.in);
	private int ids;
	public HospitalManagement(String username,String password,String name,String phoneno, Gender gender, Position position, int age, int id, int salary) {
		super(username,password, name,phoneno, gender, position, age, id, salary);
	}
	
	public void viewDatas(List<Object> datas) {
		
		Object[] anyData = datas.toArray();
		
		for(Object data : anyData) {
			System.out.println(data.toString());
		}
		
	}
	public void viewAllPatientsDatas(PatientRecord p, Map<String, PatientVisit> visitings) {
		
		System.out.println(p.toString());
		visitings.forEach((s,visiting) -> System.out.println(s + visiting));
		
	}
	public void enterId() {
		System.out.println("enter the id that you wanna perform an operation on it: ");
		int ids = in.nextInt();
	}
	public void removePatientById(List<PatientRecord> p) {
		
		prd.stream().filter(p -> p.patientId() == ids).collect(Collectors.toList()).removeAll(prd);
		
	}
	
	public void removeDrById(List<Doctor> d ) {
			
			d.stream().filter(p -> p.getId() == ids).collect(Collectors.toList()).removeAll(d);
			
	}
	
	public void removeReceptionistById(List<Receptionist> r) {
		
		r.stream().filter(p -> p.getId() == ids).collect(Collectors.toList()).removeAll(r);
	}
	
	
	
	
}