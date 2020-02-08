
public class Person implements Comparable<Person> {

	private String firstName, lastName;
	private int id;
	public Person(String firstName, String lastName, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + id + ")";
	}
	
	@Override
	public int compareTo(Person other) {
		int lastNameComparison = lastName.compareToIgnoreCase(other.lastName);
			if (lastNameComparison == 0 ) { // Same last name, compare by first name
				int firstNameComparison = firstName.compareToIgnoreCase(other.firstName);
				if (firstNameComparison == 0) // same first name, compare by id
					return Integer.compare(id, other.id);
				else 
					return firstNameComparison;
			}
			else
				return lastNameComparison;
	}

	
}
