package creating_views;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        	
        	
        	doctors.add(new Doctor(username, password, name, phoneno, gender, position, age, id, salary, yearsOfExperience,speciality));
        
    }

    public Optional<List<Doctor>> searchDrByName(String drName) {
        
    	List<Doctor> d = doctors
		    			.stream()
		        		.filter(dr -> dr.getName().equals(drName))
		        		.collect(Collectors.toList());
        
        return Optional.ofNullable(d);
    }

    public void removeDrById(int ids) {
        doctors.removeIf(p -> p.getId() == ids);
    }

    public List<String> getDrNames() {
        List<String> DrNames = new ArrayList<>();
        doctors
        .forEach(doctor -> DrNames.add(doctor.getName()));
        return DrNames;
    }

    public void viewDoctors() {
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

}
