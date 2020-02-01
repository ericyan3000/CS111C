
public class ParcelTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address a1 = new Address("Eric", "999 xyz", "San Francisco", "CA", "12345");
		Parcel p1 = new Parcel("d4x1m4m2", 1.5, a1);
		Parcel p2 = new Parcel("a1b2c3c4d5", a1);
		
		boolean b = p1.meetsCriteria('x', 'm', 2);
		
		System.out.println(p2);
		
	}

}
