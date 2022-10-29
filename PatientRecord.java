package SystemForPatients;

import java.io.Serializable;
import java.time.LocalDate;


public record PatientRecord  (String name, String surName, Gender gender, LocalDate dOB, String phoneno,int patientId, int drId )implements Serializable {


	}
