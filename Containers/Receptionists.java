package creating_views;

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
	private List<Receptionist> receptionists;
	

    public Receptionists(List<Receptionist> receptionists) {
        this.receptionists = receptionists;
    }

    public void addReceptionist(String username,String password,String name,String phoneno, Gender gender,  int age, int id, int salary) throws Exception  {
		List<Receptionist> receptionists=(List<Receptionist>) ResourceManager.load("files\\Receptionistslist.ser");
    	receptionists.add(new Receptionist(username, password, name, phoneno, gender, age, id, salary));
    	ResourceManager.save((Serializable) receptionists,"files\\Receptionistslist.ser");
		
    }
	
	public Optional<List<Receptionist>> searchReceptionistByName(String receptionistName) throws Exception{
		List<Receptionist> receptionists=(List<Receptionist>) ResourceManager.load("files\\Receptionistslist.ser");

	     List<Receptionist> r = receptionists.stream().filter(receptionist -> receptionist.getName().equals(receptionistName)).collect(Collectors.toList());
		return Optional.ofNullable(r);
	}
	
	public void removeReceptionistById(int id) throws Exception {
		List<Receptionist> receptionists=(List<Receptionist>) ResourceManager.load("files\\Receptionistslist.ser");

		receptionists.removeIf(r -> r.getId() == id);
										 }
	
    public List<String> getReceptionistNames() throws Exception {
		List<Receptionist> receptionists=(List<Receptionist>) ResourceManager.load("files\\Receptionistslist.ser");

        List<String> receptionistNames = new ArrayList<>();
        receptionists.forEach(receptionist -> receptionistNames.add(receptionist.getName()));
        return receptionistNames;
    }

	public void viewReceptionists() throws Exception{
		List<Receptionist> receptionists=(List<Receptionist>) ResourceManager.load("files\\Receptionistslist.ser");

		if(!receptionists.isEmpty()) {
		receptionists.forEach(System.out:: println);
		}else{
			System.out.println("no receptionist entered yet");
			System.exit(0);
		}
		
	}
	
	public void printSearching(Optional<List<Receptionist>> o) {

	     if(!o.isEmpty()) {
	     System.out.println(o.toString());
	     }else {
	     o.get();
	     }}
	
}
