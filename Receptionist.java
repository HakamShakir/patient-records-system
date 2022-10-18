public class Receptionist extends User{

	public Receptionist(String username,String password,String name,String phoneno, Gender gender, Position position, int age, int id, int salary) {
		super(username,password,name,phoneno, gender, position, age, id, salary);
		
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
