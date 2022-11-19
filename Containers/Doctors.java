package creating_views;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.Scanner;
import java.util.stream.Collectors;

public class Doctors implements Serializable {

    
	
    private static final long serialVersionUID = 1L;

    private List<Doctor> doctors;
   
    

    public Doctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

   public void addDr(String username, String password, String name, String phoneno, Gender gender, 
    		Position position, int age,
            int id, int salary, int yearsOfExperience, String speciality) throws Exception {
	   		doctors=(List<Doctor>) ResourceManager.load("files\\Doctorslist.ser");
        	doctors.add(new Doctor(username, password, name, phoneno, gender, position, age, id, salary, yearsOfExperience,speciality));
        	ResourceManager.save((Serializable) doctors, "files\\Doctorslist.ser");
    }

    public Optional<List<Doctor>> searchDrByName(String drName) {
        
    	List<Doctor> d = doctors
		    			.stream()
		        		.filter(dr -> dr.getName().equals(drName))
		        		.collect(Collectors.toList());
        
        return Optional.ofNullable(d);
    }

    public void removeDrById(int ids) throws Exception {
   		doctors=(List<Doctor>) ResourceManager.load("files\\Doctorslist.ser");
        doctors.removeIf(p -> p.getId() == ids);
    	ResourceManager.save((Serializable) doctors, "files\\Doctorslist.ser");

    }

    public List<String> getDrNames() throws Exception {
   		doctors=(List<Doctor>) ResourceManager.load("files\\Doctorslist.ser");

        List<String> DrNames = new ArrayList<>();
        doctors
        .forEach(doctor -> DrNames.add(doctor.getName()));
        return DrNames;
    }

    public void viewDoctors() throws Exception {
   		doctors=(List<Doctor>) ResourceManager.load("files\\Doctorslist.ser");

        if(!doctors.isEmpty()) {
        doctors.forEach(System.out::println);
        }else {
        	System.out.println("no doctor has been entered yet.");
        }
    }
    
    
    

     public void printSearching(Optional<List<Doctor>> o) {
    	 
     if(!o.isEmpty()) {
     System.out.println(o.toString());
     }else {
     o.get();
     }}

	public void viewDoctors(PrintWriter out) throws Exception {
		doctors=(List<Doctor>) ResourceManager.load("files\\Doctorslist.ser");

        if(!doctors.isEmpty()) {
        doctors.forEach(out::println);
        }else {
        	out.println("no doctor has been entered yet.");
        }
		
	}

}
     
