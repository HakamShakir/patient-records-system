package SystemForPatients;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Receptionists implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	List<Receptionist> receptionists;
	private String receptionistName;
	private int ids;
//	private Scanner in = new Scanner(System.in);
	
//	public void enterId() {
	//	System.out.println("enter the id that you wanna perform an operation on it: ");
		//ids = in.nextInt();
	//}
	
//	public void enterreceptionistName() {
	//	System.out.println("enter the name of the receptionist:");
		//receptionistName = in.next();
	//}

    public Receptionists(List<Receptionist> receptionists) {
        this.receptionists = receptionists;
    }

    void addReceptionist(String username,String password,String name,String phoneno, Gender gender, Position position, int age, int id, int salary)  {
    	Receptionist r = new Receptionist(username, password, name, phoneno, gender, position, age, id, salary);
    	receptionists.add(r);
    }
	
	public Optional<List<Receptionist>> searchReceptionistByName(){
	     List<Receptionist> r = receptionists.stream().filter(receptionist -> receptionist.getName().equals(receptionistName)).collect(Collectors.toList());
		return Optional.ofNullable(r);
	}
	
	public void removeReceptionistById() {
		receptionists.stream().filter(r -> r.getId() == ids).collect(Collectors.toList()).removeAll(receptionists);
}
	
    public List<String> getReceptionistNames() {
        List<String> receptionistNames = new ArrayList<>();
        receptionists.forEach(receptionist -> receptionistNames.add(receptionist.getName()));
        return receptionistNames;
    }

	public void viewReceptionists(){
		receptionists.stream().forEach(System.out:: println);
	}
	//public void printSearching(Optional<List<Object>> o) {
		
	//	if(!o.isEmpty()) {
	//	System.out.println(o.toString());
	//	}else {
	//		o.get();
	//	}
	

}
