package updated_system;

import java.time.LocalDate;

public record PatientVisit(int drId ,String chiefComplaint, String history, String vitals,
		String investigation, String treatement, String recommendation,LocalDate DateOfSubmission ,String duration, double price) {

}