import java.util.Objects;

public class Doctor extends User{

	private int  yearsOfExperience;
	private String  speciality;

	
	
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public Doctor(String username,String password,String name,String phoneno ,Gender gender, Position position, int age, int id, int salary, int yearsOfExperience, String speciality) {
		super(username ,password,name, phoneno,gender, position, age, id, salary);
		this.yearsOfExperience = yearsOfExperience;
		this.speciality = speciality;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return 	"Doctor" +super.toString()+"yearsOfExperience=" + yearsOfExperience + ", speciality="+ speciality + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash( speciality, yearsOfExperience);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return   Objects.equals(speciality, other.speciality)
				&& yearsOfExperience == other.yearsOfExperience;
	}
	
}

