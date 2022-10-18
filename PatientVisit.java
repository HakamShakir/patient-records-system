package SystemForPatients;

import java.time.LocalDate;

public record PatientVisit(PatientRecord pr,int drId ,String chiefComplaint, String history, String vitals,
		String investigation, String treatement, String recommendation,LocalDate DateOfSubmission ,String duration, double price) {

}
