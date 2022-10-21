package updated_system;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String [] args) throws DateTimeParseException {
		
	
		LocalDate d = LocalDate.of(2000, 2, 1);
		PatientRecord p = new PatientRecord("hug", "huyg", Gender.FEMALE,d,"ygtffg", 0, 0,0);
		System.out.println(p.getAge());
		
//		 Scanner in = new Scanner(System.in);
//		 String gender = in.next();
//		 Gender g = Gender.valueOf(gender.toUpperCase());
//		 System.out.println(g);
//		
//		 DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
//		    try{String userInput = "2/1/2dd023";
//			LocalDate date = LocalDate.parse(userInput , dateFormat);
//			System.out.println(date);}
//		    catch(DateTimeParseException d){
//				
//			}
//	}

//		Receptionist c = new Receptionist("skjdhf", null, null, null, null, null, 0, 0, 0);
//		c.enterPatientName();
//		
//		System.out.println(c.getPatientName());
	}
}