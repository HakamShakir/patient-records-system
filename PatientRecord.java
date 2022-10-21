package updated_system;

import java.time.LocalDate;


public record PatientRecord (String name, String surName, Gender gender, LocalDate dOB, String phoneno,
		int patientId, int drId ,int age) {

	
	
	public int getAge() {
		
		LocalDate d = LocalDate.now();
		return d.getYear()-dOB.getYear();
	
	}
	
	}
