package updated_system;

import java.util.Objects;

public class User {
	Gender gender;
	Position position;
	private String name ,username, password, phoneno;
	private int age;
	private int id;
	private int salary;
	
	public User(String username,String password, String name,String phoneno, Gender gender, Position position, int age, int id, int salary) {
		super();
		this.username =username;
		this.password= password;
		this.phoneno=phoneno;
		this.name = name;
		this.gender = gender;
		this.position = position;
		this.age = age;
		this.id = id;
		this.salary = salary;
	}
	
	public String getUsername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	
	public String getPhoneno() {
		return username;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getgender() {
		return gender;
	}
	public void setgender(Gender gender) {
		this.gender = gender;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", gender=" + gender + ", position=" + position + ", age=" + age + ", id=" + id
				+ ", salary=" + salary + ",";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id,username,password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(username, other.username) && Objects.equals(password, other.password);
	}
	
}