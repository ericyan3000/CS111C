
public class overnightParcel extends Parcel{
	private boolean isSignatureRequired;
	
	public overnightParcel(String parcelID, double weight, Address address, boolean isSignatureRequired) {
		super(parcelID, weight, address);
		this.isSignatureRequired = isSignatureRequired;
	}
}
