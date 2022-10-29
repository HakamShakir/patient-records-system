package SystemForPatients;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.Scanner;
import java.util.stream.Collectors;

public class Doctors implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public List<Doctor> doctors;
    private String drName;
    private int ids;
    // private Scanner in = new Scanner(System.in);

    public Doctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    // public void enterId() {
    // System.out.println("enter the id that you wanna perform an operation on it:
    // ");
    // ids = in.nextInt();
    // }

    // public void enterDrtName() {
    // System.out.println("enter the name of the dr:");
    // drName = in.next();
    // }

    void addDr(String username, String password, String name, String phoneno, Gender gender, Position position, int age,
            int id, int salary, int yearsOfExperience, String speciality) {
        Doctor d = new Doctor(username, password, name, phoneno, gender, position, age, id, salary, yearsOfExperience,
                speciality);
        doctors.add(d);
    }

    public Optional<List<Doctor>> searchDrByName() {
        List<Doctor> d = doctors.stream().filter(pt -> pt.getName().equals(drName)).collect(Collectors.toList());
        return Optional.ofNullable(d);

    }

    public void removeDrById() {
        doctors.stream().filter(p -> p.getId() == ids).collect(Collectors.toList()).removeAll(doctors);
    }

    public List<String> getDrNames() {
        List<String> DrNames = new ArrayList<>();
        doctors.forEach(doctor -> DrNames.add(doctor.getName()));
        return DrNames;
    }

    public void viewDoctors() {
        doctors.stream().forEach(System.out::println);
    }

    // public void printSearching(Optional<List<Object>> o) {

    // if(!o.isEmpty()) {
    // System.out.println(o.toString());
    // }else {
    // o.get();
    // }

}
