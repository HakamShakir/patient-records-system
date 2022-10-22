package SystemForPatients;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Doctor extends User {

	private int yearsOfExperience;
	private String speciality;
	private String patientName;
	private Scanner in = new Scanner(System.in);
	LocalDate a = LocalDate.now();

	public Doctor(String username, String password, String name, String phoneno, Gender gender, Position position,
			int age, int id, int salary, int yearsOfExperience, String speciality) {
		super(username, password, name, phoneno, gender, position, age, id, salary);
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
		return "Doctor" + super.toString() + "yearsOfExperience=" + yearsOfExperience + ", speciality=" + speciality
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(speciality, yearsOfExperience);
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
		return Objects.equals(speciality, other.speciality)
				&& yearsOfExperience == other.yearsOfExperience;
	}

	public void enterPatientName() {
		System.out.println("enter the name of the patient:");
		patientName = in.next();
	}

	// Searches for patient by name from a record given as argument.
	public Optional<List<PatientRecord>> searchByName(List<PatientRecord> records) {

		List<PatientRecord> d = records.stream().filter(p -> p.name().equals(patientName)).collect(Collectors.toList());

		return Optional.ofNullable(d);

	}

	// Gets patient name from enterPatientName() and adds new visit to Map.
	public void addPatientsVisits(Map<String, PatientVisit> visits) {

		enterPatientName();

		System.out.println("enter drId ID:");
		int drId = in.nextInt();
		System.out.println("enter cheif complaint: ");
		String chiefComplaint = in.next();
		System.out.println("enter history of the patient: ");
		String history = in.next();
		System.out.println("enter the vitals: ");
		String vitals = in.next();
		System.out.println("enter the investigation: ");
		String investigation = in.next();
		System.out.println("enter treatments: ");
		String treatments = in.next();
		System.out.println("enter recommendation: ");
		String recommendation = in.next();
		System.out.println("enter duration: ");
		String duration = in.next();
		System.out.println("enter the price: ");
		double price = in.nextDouble();

		visits.put(patientName, new PatientVisit(drId, chiefComplaint, history, vitals, investigation, treatments,
				recommendation, a, duration, price));

	}

	public void viewPatientsData(List<PatientRecord> p) {

		List<PatientRecord> DrsPatients = p.stream().filter(d -> d.drId() == this.getId()).collect(Collectors.toList());

		DrsPatients.forEach(System.out::println);

	}

	public PatientVisit showVisits(Map<String, PatientVisit> visits) {
		enterPatientName();
		return visits.get(patientName);

	}

}
