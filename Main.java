
public class Main {

	public static void main(String[] args) {

		DataEnterist e = new DataEnterist("tara", Gender.FEMALE, Position.NURSE, 38, 12, 16, 20);
		Doctor et = new Doctor("tara", Gender.FEMALE, Position.NURSE, 38, 12, 16, 20, "wow", "whew");
		System.out.println(e.toString());
		System.out.println(et.toString());
	}
}
