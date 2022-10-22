import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		LocalDate a = LocalDate.now();

		List<PatientRecord> Patients = new ArrayList<>();
		Map<String, PatientVisit> visits = new HashMap<String, PatientVisit>();

		Doctor et = new Doctor("hasansabah", "password", "hasan salah", "07501234567", Gender.FEMALE, Position.DENTIST,
				48, 1, 1600, 20, "maxillofacial surgeon");
		Receptionist Alan = new Receptionist("alansalam", "hello", "Alan", "023041340", Gender.MALE, Position.INTERN,
				23, 0014, 2300);
		PatientRecord Hakam = new PatientRecord("alan", "salam", Gender.MALE, a, "aaaa", 2);
		Patients.add(Hakam);

		et.addPatientsVisits(visits);
		Patients.forEach(System.out::println);
		System.out.println(Alan);

		System.out.println(et.toString());

	}
}
