package updated_system;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Doctor extends User{
	private Scanner in = new Scanner(System.in);
	private int  yearsOfExperience;
	private String  speciality, patientName;
	
	

	
	
	public Doctor(String username,String password,String name,String phoneno ,Gender gender, Position position, int age, int id, int salary, int yearsOfExperience, String speciality) {
		super(username ,password,name, phoneno,gender, position, age, id, salary);
		this.yearsOfExperience = yearsOfExperience;
		this.speciality = speciality;
		
	}
	
	
	
	
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return 	"Doctor" +super.toString()+"yearsOfExperience=" + yearsOfExperience + ", speciality="+ speciality + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash( speciality, yearsOfExperience);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return   Objects.equals(speciality, other.speciality)
				&& yearsOfExperience == other.yearsOfExperience;
	}

	public void viewPatientsData(List<PatientRecord> p) {
		
		List<PatientRecord> DrsPatients = p.stream().filter(d -> d.drId()==this.getId()).collect(Collectors.toList());
		
		DrsPatients.forEach(System.out :: println);
		
	}
	public void enterPatientName() {
		
		String patientName = in.next();
		
	}
	public void viewPatientsVisits(Map<String , PatientRecord> visiting) {
		
		if(visiting.containsKey(patientName)||!visiting.isEmpty() && (visiting.get(patientName).drId())==this.getId()) {
			System.out.println(visiting.get(patientName).toString());
			
		}
	}
	
	

	
	

	
	
	
	
	
	
}