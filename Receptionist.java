package creating_views;

public class Receptionist extends User{
	

	private static final long serialVersionUID = 8904255995808065269L;

	public Receptionist(String username,String password,String name,String phoneno, Gender gender, int age, int id, int salary)
	{
		
		super(username ,password,name, phoneno,gender, age, id, salary);
	}

	public void showRecord() {
		System.out.println(getName());
		System.out.println(getPhoneno());
		System.out.println(getPosition());
		System.out.println(getAge());
		System.out.println(getSalary());
		System.out.println(getId());
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