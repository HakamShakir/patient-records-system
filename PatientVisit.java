package creating_views;

import java.io.Serializable;
import java.time.LocalDate;

public record PatientVisit(int pId,int drId ,int visitId,String chiefComplaint, String history,
		 String treatement, String recommendation,LocalDate DateOfSubmission ,String duration, double price)implements Serializable {

}