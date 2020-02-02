public class Student implements Comparable {

	private String firstName, lastName;
	private int studentID;
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setStudentID(int studentID) {
		if(studentID >=0 && studentID <= 9999) {
			this.studentID = studentID;
		}
	}
	
	@Override
	public String toString() {
		return lastName + ", " + firstName + " (" + studentID + ")";
	}
		
	@Override
	public boolean equals(Object other) {
		if(other instanceof Student) {
			Student otherStudent = (Student) other;
			
			return this.studentID == otherStudent.studentID;		
		} else {
			return false;
		}
		
	}
	
	@Override
	public int compareTo(Object other) {
		if(other instanceof Student) {
			Student otherStudent = (Student) other;
			if(this.studentID < otherStudent.studentID) {
				return -1;
			} else if(this.studentID == otherStudent.studentID){
				return 0;
			} else {
				assert this.studentID > otherStudent.studentID;
				return 1;
			}
		} else { 
			return -99;
		}
	}
	
	/*
	@Override
	public int compareTo(Object other) {
		if(other instanceof Student) {
			Student otherStudent = (Student) other;
			if(this.lastName.equals(otherStudent.lastName)) {
				return this.firstName.compareTo(otherStudent.firstName);
			} else {
				return this.lastName.compareTo(otherStudent.lastName);
			}
		} else {
			return -99;
		}
	}
	*/
	
	
	
	
}
