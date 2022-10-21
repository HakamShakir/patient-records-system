package updated_system;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HospitalManagement extends User{

	private Scanner in = new Scanner(System.in);
	private int ids;
	private String patientName;
	public HospitalManagement(String username,String password,String name,String phoneno, Gender gender, Position position, int age, int id, int salary) {
		super(username,password, name,phoneno, gender, position, age, id, salary);
	}
	
	public void viewDatas(List<Object> datas) {
		
		Object[] anyData = datas.toArray();
		
		for(Object data : anyData) {
			System.out.println(data.toString());
		}
		
	}
	public void printSearching(Optional<List<Object>> o) {
		
		if(!o.isEmpty()) {
		System.out.println(o.toString());
		}else {
			o.get();
		}
	
}
	public void viewAllPatientsDatas(PatientRecord p, Map<String, PatientVisit> visitings) {
		
		System.out.println(p.toString());
		visitings.forEach((s,visiting) -> System.out.println(s + visiting));
		
	}
	public void enterPatientName() {
		System.out.println("enter the name of the patient:");
		patientName = in.next();
	}
	public Optional<List<PatientRecord>> searchPatients(List<PatientRecord> p){
		
	     List<PatientRecord> d = p.stream().filter(pt -> pt.name().equals(patientName)).collect(Collectors.toList());
	 	
			return Optional.ofNullable(d);
		
	}
	public Optional<List<Receptionist>> searchReceptionist(List<Receptionist> p){
		
	     List<Receptionist> d = p.stream().filter(pt -> pt.getName().equals(patientName)).collect(Collectors.toList());
	 	
			return Optional.ofNullable(d);
		
	}
	public Optional<List<Doctor>> searchDr(List<Doctor> p){
		
	     List<Doctor> d = p.stream().filter(pt -> pt.getName().equals(patientName)).collect(Collectors.toList());
	 	
			return Optional.ofNullable(d);
		
	}
	
	
	public void enterId() {
		System.out.println("enter the id that you wanna perform an operation on it: ");
		int ids = in.nextInt();
	}
	public void removePatientById(List<PatientRecord> p) {
		
		p.stream().filter(p -> p.patientId() == ids).collect(Collectors.toList()).removeAll(p);
		
	}
	
	public void removeDrById(List<Doctor> d ) {
			
			d.stream().filter(p -> p.getId() == ids).collect(Collectors.toList()).removeAll(d);
			
	}
	
	public void removeReceptionistById(List<Receptionist> r) {
		
		r.stream().filter(p -> p.getId() == ids).collect(Collectors.toList()).removeAll(r);
	}
	
	
	
	
}