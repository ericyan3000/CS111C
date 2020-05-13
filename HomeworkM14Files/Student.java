
public class Student {
	
	private int id;
	private String firstName, lastName;
	private boolean paidFees;
	
	public Student(int id, String firstName, String lastName, boolean paidFees) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.paidFees = paidFees;
	}
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public boolean hasPaidFees() {
		return paidFees;
	}
	public String toString() {
		return firstName + " " + lastName + " (ID: " + id + ")" + ( paidFees ? "" : " (Fees Owed)");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student otherStudent = (Student) obj;
			return (id == otherStudent.id && lastName.equals(otherStudent.lastName) && firstName.equals(otherStudent.firstName) && paidFees == otherStudent.paidFees);
		}
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 5;
		int result = 7;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (paidFees ? 1231 : 1237);
		return result;
	}


}
