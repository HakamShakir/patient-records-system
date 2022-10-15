package SystemForPatients;

public class Receptionist extends User{

	public Receptionist(String name, Gender gender, Position position, int age, int id, int salary) {
		super(name, gender, position, age, id, salary);
		
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	
	
}
