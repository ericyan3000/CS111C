
public class Parcel {
	private String parcelID;
	private double weight;
	private Address address;
	private final static float DEFAULT_WEIGHT = 1;
	
	public Parcel(String parcelID, double weight, Address address) {
		this.parcelID = parcelID;
		this.weight = weight;
		this.address = address;
	}
	
	public Parcel(String parcelID, Address address) {
		this(parcelID, DEFAULT_WEIGHT, address);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		if (weight > 0) // only set weight if positive
			this.weight = weight;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getParcelID() {
		return parcelID;
	}
	
	// no setter for parcelID because the ID should not be changed once the parcel is initiated.
	
	@Override
	public String toString() {
		return "ID:\n" + parcelID + "\nWeight:\n" + weight + " lb\nDestination:\n" + address ;
	}
	
	@Override
	public boolean equals(Object otherParcel) {
		if (otherParcel instanceof Parcel) {
			return parcelID.equalsIgnoreCase(((Parcel) otherParcel).getParcelID());
		}
		else
			return false;
	}
	
	public boolean meetsCriteria(char first, char second, int numberTimesSecondAfterFirst) {
		
		String subString = parcelID.substring(parcelID.indexOf(first) + 1); // +1 to exclude the first character in substring
		int count = 0; 
		
		if (!subString.equals(parcelID)) { // return false if the first character is not in the ID
			for ( char c : subString.toCharArray()) {
				if (c == second)
					count ++; // get number of time the second character appears after the first one 
			}
		
			return count == numberTimesSecondAfterFirst;
		}
		else
			return false;
	}
	
	
}
